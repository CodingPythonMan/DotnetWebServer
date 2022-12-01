using Microsoft.AspNetCore.Components;

namespace Game
{
    public partial class App
    {
        [Inject]
        NavigationManager _NavigationManager { get; set; } = null!;

        bool _isNotFound = false;

        protected override void OnAfterRender(bool firstRender)
        {
            if(firstRender && _isNotFound)
            {
                _NavigationManager.NavigateTo("/", true);
            }
        }
    }
}
