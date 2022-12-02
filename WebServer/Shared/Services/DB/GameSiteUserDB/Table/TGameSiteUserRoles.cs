using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteUserRoles", Schema="dbo")]
    public class TGameSiteUserRoles
    {
        [Key]
        public Int64 UserId { get; set; }

        [Key]
        public Int64 RoleId { get; set; }
    }
}
