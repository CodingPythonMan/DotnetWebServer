using Microsoft.AspNetCore.Components;
using System.Security.Principal;

namespace Game.Features.GameSite.Component
{
    public partial class NavMenu
    {
        [Inject]
        NavigationManager _NavigationManager { get; set; } = null!;

        bool sidebarExpanded = true;


        void Logout()
        {
            _NavigationManager.NavigateTo("/account/logout", true);
        }
    }
}
