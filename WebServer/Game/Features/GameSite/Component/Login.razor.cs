using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Forms;
using Microsoft.AspNetCore.DataProtection;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Formatters;
using Radzen;
using Shared.Base.Common;
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
        [Inject]
        private NotificationService _NotificationService { get; set; } = null!;

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
            if (false == context.Validate())
            {
                string message = context.GetValidationMessages().FirstOrDefault()!;

                if (false == string.IsNullOrEmpty(message))
                {
                    ShowNotify(message, NotificationSeverity.Error);
                    return;
                }
            }

            ErrorResult result = await LoginProcess();

            switch (result)
            {
                case ErrorResult.SUCCESS:
                    break;
                case ErrorResult.ERROR_USER_NOT_FOUND:
                    ShowNotify("ERROR_USER_NOT_FOUND", NotificationSeverity.Error);
                    break;
                case ErrorResult.ERROR_INVAILD_PASSWORD:
                    ShowNotify("ERROR_INVAILD_PASSWORD", NotificationSeverity.Error);
                    break;
                default:
                    ShowNotify(result.ToString(), NotificationSeverity.Error);
                    break;
            }
        }

        private async Task<ErrorResult> LoginProcess()
        {
            ErrorResult result = ErrorResult.FAIL;

            do
            {
                var user = await _UserManager.FindByEmailAsync(_input.Email);

                if (user == null)
                {
                    result = ErrorResult.ERROR_USER_NOT_FOUND;
                    break;
                }

                bool isVaild = await _UserManager.CheckPasswordAsync(user, _input.Password);

                if (false == isVaild)
                {
                    result = ErrorResult.ERROR_INVAILD_PASSWORD;
                    break;
                }

                var token = await _UserManager.GenerateUserTokenAsync(user, TokenOptions.DefaultProvider, "SignIn");
                var returnUrl = "/";
                var data = $"{user.Id}|{token}|{returnUrl}";

                var protector = _DataProtectionProvider.CreateProtector("SignIn");
                var passData = protector.Protect(data);

                _NavigationManager.NavigateTo($"/account/signin?data={passData}", true);

                result = ErrorResult.SUCCESS;

            } while (false);

            return result;
        }

        void ShowNotify(string message, NotificationSeverity severity = NotificationSeverity.Success)
        {
            _NotificationService.Notify(new NotificationMessage()
            {
                Severity = severity,
                Summary = message,
            });
        }

        public void GoogleLogin()
        {
            _NavigationManager.NavigateTo($"/account/googlesignin", true);
        }
    }
}
