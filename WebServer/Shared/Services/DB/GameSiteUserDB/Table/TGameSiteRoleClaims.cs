using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteRoleClaims", Schema = "dbo")]
    public class TGameSiteRoleClaims
    {
        [Key]
        public int Id { get; set; }

        public Int64 RoleId { get; set; }
        public string ClaimType { get; set; } = null!;

        public string ClaimValue { get; set; } = null!;
    }
}
