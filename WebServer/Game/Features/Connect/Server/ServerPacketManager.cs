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

        //Dictionary<ushort, Action<PacketSession>
    }
}
