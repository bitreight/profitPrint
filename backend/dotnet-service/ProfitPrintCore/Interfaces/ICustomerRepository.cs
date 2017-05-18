using System.Collections.Generic;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Interfaces
{
    public interface ICustomerRepository
    {
        void Create(Customer customer);
        void Delete(Customer customer);
        Customer Read(long id);
        List<Customer> Read();
    }
}
