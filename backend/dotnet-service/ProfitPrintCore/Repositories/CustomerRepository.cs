using System.Collections.Generic;
using System.Linq;
using ProfitPrintCore.Interfaces;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Repositories
{
    public class CustomerRepository : ICustomerRepository
    {
        private readonly profit_print_dbContext _context;

        public CustomerRepository()
        {
            _context = new profit_print_dbContext();
        }

        public void Create(Customer customer)
        {
            _context.Customer.Add(customer);
            _context.SaveChanges(true);
        }

        public void Delete(Customer customer)
        {
            _context.Customer.Remove(customer);
            _context.SaveChanges(true);
        }

        public Customer Read(long id)
        {
            return _context.Customer.FirstOrDefault(_ => _.Id == id);
        }

        public List<Customer> Read()
        {
            return _context.Customer.ToList();
        }
    }
}
