using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.Config
{
    public class WebServerConfig
    {
        public Env env { get; set; } = null!;
        public Auth auth { get; set; } = null!;
    }

    public class Env
    {
        public string gameId { get; set; } = null!;
        public string gamePassword { get; set; } = null!;
    }

    public class Auth
    {
        public string googleId { get; set; } = null!;
        public string googleSecret { get; set; } = null!;
    }
}
