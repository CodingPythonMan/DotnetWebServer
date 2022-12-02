using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DBConnectString
{
    public class RDBNode
    {
        public SqlConnectionStringBuilder Config { get; set; } = null!;
        public Int64 MaxRange { get; set; }
    }
}
