using Shared.Features.Network;
using System;

namespace Game.Features.Connect.Server
{
    class PacketManager
    {
        #region Singleton
        static PacketManager _instance = new PacketManager();
        public static PacketManager Instance { get { return _instance; } }
        #endregion

        PacketManager()
        {
            
        }

        Dictionary<ushort, Action<PacketSession, ArraySegment<byte>>> _onRecv = new Dictionary<ushort, Action<PacketSession, ArraySegment<byte>>>();
        Dictionary<ushort, Action<PacketSession, IPacket>> _handler = new Dictionary<ushort, Action<PacketSession, IPacket>>();

        public void Register()
        {
            //_onRecv.Add((ushort)PacketID.LGOP_REP_SEND_NOTICE, MakePacket<LGOP_REP_SEND_NOTICE>);
            //_handler.Add((ushort)PacketID.LGOP_REP_SEND_NOTICE, PacketHandler.LGOP_REP_SEND_NOTICE);
        }

        public void OnRecvPacket(PacketSession session, ArraySegment<byte> buffer)
        {
            ushort count = 0;

            ushort id = BitConverter.ToUInt16(buffer.Array!, buffer.Offset);
            count += 2;
            ushort size = BitConverter.ToUInt16(buffer.Array!, buffer.Offset + count);
            count += 2;

            Action<PacketSession, ArraySegment<byte>> action = null!;
            if (_onRecv.TryGetValue(id, out action!))
                action.Invoke(session, buffer);
        }

        void MakePacket<T>(PacketSession session, ArraySegment<byte> buffer) where T : IPacket, new()
        {
            T pkt = new T();
            //pkt.Read(buffer);
            Action<PacketSession, IPacket> action = null!;
            if (_handler.TryGetValue(pkt.Protocol, out action!))
                action.Invoke(session, pkt);
        }
    }
}
