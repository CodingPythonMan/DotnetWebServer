using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Forms;
using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;
using System.Xml.Linq;

namespace Game.Features.GameSite.Pages
{
    public partial class Registration
    {
        public class RegisterUserModel
        {
            [Required]
            [EmailAddress]
            public string Email { get; set; } = null!;

            [Required]
            [DataType(DataType.Password)]
            [Display(Name = "Password")]
            public string Password { get; set; } = null!;

            [DataType(DataType.Password)]
            [Compare("Password", ErrorMessage = "The password and confirmation password do not match.")]
            [Display(Name = "Confirm password")]
            public string ConfirmPassword { get; set; } = null!;
        }

        [Inject]
        UserManager<GameSiteUser> _UserManager { get; set; } = null!;

        RegisterUserModel _input = new();

        async void _OnSubmit(EditContext context)
        {
            if (context.Validate())
            {
                var user = await _UserManager.FindByEmailAsync(_input.Email);

                if (user != null)
                {
                    return;
                }

                var result = await _UserManager.CreateAsync(
                    new GameSiteUser(_input.Email)
                    {

                        Email = _input.Email,
                        EmailConfirmed = true
                    }, _input.Password
                );

                if (result.Succeeded)
                {
                    _input = new();
                    StateHasChanged();
                }
            }
        }
    }
}
