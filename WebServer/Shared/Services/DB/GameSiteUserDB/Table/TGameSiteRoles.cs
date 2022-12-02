using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB.Table
{
    [Table("tGameSiteRoles", Schema="dbo")]
    public class TGameSiteRoles
    {
        [Key]
        public Int64 Id { get; set; }
        public string Name { get; set; } = null!;
    }
}
