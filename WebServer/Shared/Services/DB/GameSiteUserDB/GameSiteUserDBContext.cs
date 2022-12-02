using Microsoft.EntityFrameworkCore;
using Shared.Services.DB.GameSiteUserDB.Table;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB
{
    public class GameSiteUserDBContext : DbContext
    {
        public DbSet<TGameSiteUsers> TGameSiteUsers { get; set; } = null!;
        public DbSet<TGameSiteUserRoles> TGameSiteUserRoles { get; set; } = null!;
        public DbSet<TGameSiteRoles> TGameSiteRoles { get; set; } = null!;

        public GameSiteUserDBContext(DbContextOptions<GameSiteUserDBContext> options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<TGameSiteUsers>()
                .HasKey(c => c.Id);

            modelBuilder.Entity<TGameSiteRoles>()
                .HasKey(c => c.Id);

            modelBuilder.Entity<TGameSiteUserRoles>()
                .HasKey(c => new { c.UserId, c.RoleId});
        }
    }
}
