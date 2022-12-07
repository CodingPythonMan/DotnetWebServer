using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Forms;
using Microsoft.AspNetCore.DataProtection;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Formatters;
using System.ComponentModel.DataAnnotations;

namespace Game.Features.GameSite.Component
{
	public partial class Login
	{
        [Inject]
        NavigationManager _NavigationManager { get; set; } = null!;

        [Inject]
        private UserManager<GameSiteUser> _UserManager { get; set; } = null!;
        [Inject]
        private IDataProtectionProvider _DataProtectionProvider { get; set; } = null!;

        public class LoginModel
        {
            [Required]
            public string Email { get; set; } = string.Empty;

            [Required]
            public string Password { get; set; } = string.Empty;
        }

        LoginModel _input = new();

        private async Task _OnSubmit(EditContext context)
        {
            var user = await _UserManager.FindByEmailAsync(_input.Email);

            if(user is null)
            {
                return;
            }

            bool isValid = await _UserManager.CheckPasswordAsync(user, _input.Password);

            if (isValid is false)
            {
                return;
            }

            var token = await _UserManager.GenerateUserTokenAsync(user, TokenOptions.DefaultProvider, "SignIn");

            var returnUrl = "/";

            var data = $"{user.Id}|{token}|{returnUrl}";

            var protector = _DataProtectionProvider.CreateProtector("SignIn");

            var passData = protector.Protect(data);

            _NavigationManager.NavigateTo($"/account/signin?data={passData}", true);
        }

        public void GoogleLogin()
        {
            _NavigationManager.NavigateTo($"/account/googlesignin", true);
        }
    }
}
