using Shared.Services.Config;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DBConnectString
{
    public class DBConnectStringService
    {
        public Dictionary<int, RDBNode> Nodes = new();

        public DBConnectStringService()
        {
            var mssql = ConfigService._dbConfig.MsSql;

            foreach(var db in mssql.DB)
            {
                if (false == db.Validate) continue;

                var node = new RDBNode()
                {
                    Config = new SqlConnectionStringBuilder()
                    {
                        DataSource = $"{db.IPAddress},{db.Port}",
                        InitialCatalog = db.DatabaseName,
                        UserID = db.Id,
                        Password = db.Password,
                        Pooling = true,
                        MaxPoolSize = 512,
                    },
                    MaxRange = db.MaxRange
                };

                try
                {
                    var prepareLoad = new SqlConnection(node.Config.ConnectionString);
                }
                catch(Exception)
                {
                    continue;
                }

                Nodes.Add(db.TypeId, node);
            }
        }

        public string GetConnectionString(int key)
        {
            RDBNode? node = null;
            if(this.Nodes.TryGetValue(key, out node) is false)
            {
                return null!;
            }

            return node.Config.ConnectionString;
        }
    }
}
