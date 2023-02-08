using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;

namespace Game.Features.Identity.Components
{
    public class ApplicationDbContext : IdentityDbContext<GameSiteUser, IdentityRole<long>, long>
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options) { }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<GameSiteUser>().ToTable("tGameSiteUsers");
            modelBuilder.Entity<IdentityRole<long>>().ToTable("tGameSiteRoles");
            modelBuilder.Entity<IdentityRoleClaim<long>>().ToTable("tGameSiteRoleClaims");
            modelBuilder.Entity<IdentityUserClaim<long>>().ToTable("tGameSiteUserClaims");
            modelBuilder.Entity<IdentityUserLogin<long>>().ToTable("tGameSiteUserLogins");
            modelBuilder.Entity<IdentityUserRole<long>>().ToTable("tGameSiteUserRoles");
            modelBuilder.Entity<IdentityUserToken<long>>().ToTable("tGameSiteUserTokens");
        }
    }
}
