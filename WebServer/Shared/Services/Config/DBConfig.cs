using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.Config
{
    public class DBConfig
    {
        public MSSQL MsSql { get; set; } = null!;
    }

    public class MSSQL
    { 
        public DataBase[] DB { get; set; } = null!;
    }

    public class DataBase
    {
        public int TypeId { get; set; }
        public bool Validate { get; set; }
        public string DatabaseName { get; set; } = null!;
        public string IPAddress { get; set; } = null!;
        public int Port { get; set; }
        public string Id { get; set; } = null!;
        public string Password { get; set; } = null!;
        public Int64 MaxRange { get; set; }
    }
}
