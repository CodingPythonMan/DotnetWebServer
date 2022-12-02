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
        public string Email { get; set; } = null!;
        public string PasswordHash { get; set; } = null!;
    }
}
