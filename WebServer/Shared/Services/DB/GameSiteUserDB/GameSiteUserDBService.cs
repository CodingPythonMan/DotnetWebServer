using Microsoft.EntityFrameworkCore;
using Shared.Services.DBConnectString;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB.GameSiteUserDB
{
    public class GameSiteUserDBService : AbstractDBService<GameSiteUserDBContext>
    {
        public GameSiteUserDBService(DBConnectStringService dBConnectStringService) : base(dBConnectStringService)
        {
        }

        public override GameSiteUserDBContext GetContext()
        {
            return new GameSiteUserDBContext(_contextOptions[ShardID]);
        }

        protected override void SetDBContext(DBConnectStringService dBConnectStringService)
        {
            _contextOptions.Add(new DbContextOptionsBuilder<GameSiteUserDBContext>()
                .UseSqlServer(dBConnectStringService.GetConnectionString(Shared.Base.Common.Defines.GameSiteUserDB))
                .Options);
        }
    }
}
