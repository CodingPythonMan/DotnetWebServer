using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components;

namespace Game.Features.Identity.Components
{
    public partial class NotAuthorizedHandler
    {
        [Inject]
        NavigationManager _NavigationManager { get; set; } = null!;

        [Inject]
        AuthenticationStateProvider _AuthenticationStateProvider { get; set; } = null!;

        protected override async Task OnInitializedAsync()
        {
            var state = await _AuthenticationStateProvider.GetAuthenticationStateAsync();

            if (false == state.User.Identity.IsAuthenticated)
            {
                _NavigationManager.NavigateTo($"/account/signin?returnUrl={System.Net.WebUtility.UrlEncode(new Uri(_NavigationManager.Uri).PathAndQuery)}");
            }
        }
    }
}
