using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.Config
{
    public class WebServerConfig
    {
        public Env env { get; set; }
    }

    public class Env
    {
        public string gameId { get; set; }
        public string gamePassword { get; set; }
    }
}
