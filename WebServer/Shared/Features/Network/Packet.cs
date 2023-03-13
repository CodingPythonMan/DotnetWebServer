using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Features.Network
{
    public interface IPacket
    {
        ushort Protocol { get; }
    }
}
