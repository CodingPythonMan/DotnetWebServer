using Microsoft.AspNetCore.Identity;

namespace Game.Features.Identity.Model
{
    public class GameSiteUser : IdentityUser<long>
    {
        public GameSiteUser() { }
        public GameSiteUser(string userName) : base(userName) { }
    }

    public class GameSiteRole : IdentityRole<long>
    {
        public GameSiteRole(string roleName) : base(roleName) { }
    }
}
