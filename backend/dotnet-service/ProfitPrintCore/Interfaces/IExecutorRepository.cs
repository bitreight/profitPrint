using System.Collections.Generic;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Interfaces
{
    public interface IExecutorRepository
    {
        void Create(Executor user);
        void Delete(Executor user);
        Executor Read(long id);
        List<Executor> Read();
    }
}
