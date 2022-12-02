using Microsoft.EntityFrameworkCore;
using Shared.Services.DBConnectString;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services.DB
{
    public abstract class AbstractDBService<ContextType> : IDBService where ContextType : DbContext
    {
        public List<string> TableNameList { get; set; } = new();

        public abstract ContextType GetContext();
        protected abstract void SetDBContext(DBConnectStringService dBConnectStringService);
     
        public AbstractDBService(DBConnectStringService dBConnectStringService)
        {
            SetDBContext(dBConnectStringService);
            SetTableNameList();
        }

        protected void SetTableNameList()
        {
            using var context = GetContext();

            foreach (var entityType in context.Model.GetEntityTypes())
            {
                TableNameList.Add(entityType.ClrType.Name);
            }
        }
    }
}
