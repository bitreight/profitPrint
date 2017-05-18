using System.Collections.Generic;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Interfaces
{
    public interface IUserRepository
    {
        void Create(User user);
        void Delete(User user);
        User Read(long id);
        List<User> Read();
    }
}
