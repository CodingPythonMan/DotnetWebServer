using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.DataProtection;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace Game.Features.Identity.Controllers
{
    public class AccountController : Controller
    {
        private readonly UserManager<GameSiteUser> _UserManager;
        private readonly SignInManager<GameSiteUser> _SignInManager;
        private readonly IDataProtector _DataProtector;


        public AccountController(IDataProtectionProvider dataProtectionProvider, 
            UserManager<GameSiteUser> userManager, SignInManager<GameSiteUser> signInManager)
        {
            _UserManager = userManager;
            _SignInManager = signInManager;
            _DataProtector = dataProtectionProvider.CreateProtector("SignIn");
        }

        [HttpGet("account/signin")]
        public async Task<IActionResult> SignIn(string data)
        {
            var receivedData = _DataProtector.Unprotect(data);

            var parts = receivedData.Split('|');

            var identityUser = await _UserManager.FindByIdAsync(parts[0]);

            var isTokenValid = await _UserManager.VerifyUserTokenAsync(identityUser,
                TokenOptions.DefaultProvider, "SignIn", parts[1]);

            if(isTokenValid)
            {
                Console.WriteLine("로그인 성공!");
                await _SignInManager.SignInAsync(identityUser, true);
                if(parts.Length == 3 && Url.IsLocalUrl(parts[2]))
                {
                    return Redirect(parts[2]);
                }
                return Redirect(receivedData);
            }
            else
            {
                return Unauthorized("STOP!");
            }
        }

        [HttpGet("account/googlesignin")]
        public IActionResult GoogleSignIn()
        {
            var properties = new AuthenticationProperties()
            {
                RedirectUri = "/",

                // prompt=consent : 매번 권한 요청 및 승인 시 RefreshToken 획득
                // prompt=login : 최초 권한 승인만 RefreshToken 획득
                Parameters = { { "prompt", "consent" } },
            };

            return Challenge(properties, GoogleDefaults.AuthenticationScheme);
        }

        [Authorize]
        [HttpGet("account/logout")]
        public async Task<IActionResult> Logout()
        {
            await _SignInManager.SignOutAsync();

            return Redirect("/");
        }
    }
}
