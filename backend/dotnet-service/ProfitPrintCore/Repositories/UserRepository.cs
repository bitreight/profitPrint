﻿using System.Collections.Generic;
using System.Linq;
using ProfitPrintCore.Interfaces;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Repositories
{
    public class UserRepository: IUserRepository
    {
        private readonly profit_print_dbContext _context;

        public UserRepository()
        {
            _context = new profit_print_dbContext();
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

        public List<User> Read()
        {
            return _context.User.ToList();
        }
    }
}
