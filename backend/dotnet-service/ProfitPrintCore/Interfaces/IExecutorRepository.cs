using System.Collections.Generic;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Interfaces
{
    public interface IExecutorRepository
    {
        void Create(Executor userExecutor);
        void Delete(Executor userExecutor);
        Executor Read(long id);
        List<Executor> Read();
    }
}
