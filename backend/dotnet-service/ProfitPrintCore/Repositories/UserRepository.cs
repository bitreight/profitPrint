using System;
using System.Linq;
using ProfitPrintCore.Interfaces;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Repositories
{
    public class UserRepository: IUserRepository
    {
        profit_print_dbContext _context;

        public UserRepository(profit_print_dbContext context)
        {
            _context = context;
        }

        public void Create(User user)
        {
            _context.User.Add(user);
            _context.SaveChanges(true);
        }

        public void Delete(User user)
        {
            _context.User.Remove(user);
            _context.SaveChanges(true);
        }

        public User Read(long id)
        {
            return _context.User.FirstOrDefault(_ => _.Id == id);
        }
    }
}
