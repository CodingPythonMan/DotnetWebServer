using Microsoft.AspNetCore.Components.Forms;
using System.ComponentModel.DataAnnotations;

namespace Game.Features.GameSite.Component
{
	public partial class Login
	{
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
          
        }
    }
}
