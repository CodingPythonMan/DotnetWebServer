using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteUserLogins", Schema = "dbo")]
    public class TGameSiteUserLogins
    {
        [Key]
        public string LoginProvider { get; set; } = null!;

        [Key]
        public string ProviderKey { get; set; } = null!;

        public string ProviderDisplayName { get; set; } = null!;

        public Int64 UserId { get; set; }
    }
}
