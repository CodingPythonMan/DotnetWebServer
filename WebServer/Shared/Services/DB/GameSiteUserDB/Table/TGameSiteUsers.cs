using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteUsers", Schema = "dbo")]
    public class TGameSiteUsers
    {
        [Key]
        public Int64 Id { get; set; }
        public string UserName { get; set; } = null!;
        public string NormalizedUserName { get; set; } = null!;

        public string Email { get; set; } = null!;

        public string NormalizedEmail { get; set; } = null!;
        public bool? EmailConfirmed { get; set; }
        public string PasswordHash { get; set; } = null!;
        public string SecurityStamp { get; set; } = null!;
        public string ConcurrencyStamp { get; set; } = null!;
        public string PhoneNumber { get; set; } = null!;
        public bool? PhoneNumberConfirmed { get; set; }
        public bool TwoFactorEnabled { get; set; }
        public DateTime? LockoutEnd { get; set; }
        public bool LockoutEnabled { get; set; }
        public int AccessFailedCount { get; set; }
    }
}
