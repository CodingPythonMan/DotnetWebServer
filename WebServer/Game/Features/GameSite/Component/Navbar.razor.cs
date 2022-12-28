using Microsoft.AspNetCore.Components;
using Microsoft.JSInterop;
using System.Security.Principal;

namespace Game.Features.GameSite.Component
{
    public partial class Navbar
    {
        [Inject]
        private IJSRuntime JS { get; set; } = null!;

        protected override async Task OnAfterRenderAsync(bool firstRender)
        {
            if(firstRender)
            {
                await JS.InvokeVoidAsync("Navbar.Init");
            }
        }
    }
}
