using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteUserTokens", Schema = "dbo")]
    public class TGameSiteUserTokens
    {
        [Key]
        public Int64 UserId { get; set; }

        [Key]
        public string LoginProvider { get; set; } = null!;

        [Key]
        public string Name { get; set; } = null!;

        public string Value { get; set; } = null!;
    }
}
