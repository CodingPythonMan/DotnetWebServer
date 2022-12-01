using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Forms;
using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;

namespace Game.Features.GameSite.Component
{
	public partial class Login
	{
        [Inject]
        NavigationManager _NavigationManager { get; set; } = null!;


        /*
        [Inject]
        SignInManager<Object> _SignInManager { get; set; } = null!;

        [Inject]
        UserManager<Object> _UserManager { get; set; } = null!;*/

        public class LoginModel
        {
            [Required]
            public string Email { get; set; } = string.Empty;

            [Required]
            public string Password { get; set; } = string.Empty;
        }

        LoginModel _input = new();

        void _OnSubmit(EditContext context)
        {
            /*if(false == context.Validate())
            {
                
            }*/

           // var identityUser = _UserManager.FindByIdAsync();

            //_SignInManager.SignInAsync().GetAwaiter();

            _NavigationManager.NavigateTo("/", true);
        }
    }
}
