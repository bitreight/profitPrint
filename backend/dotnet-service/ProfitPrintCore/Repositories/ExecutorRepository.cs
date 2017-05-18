using System;
using System.Collections.Generic;
using System.Linq;
using ProfitPrintCore.Interfaces;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Repositories
{
    public class ExecutorRepository: IExecutorRepository
    {
        private readonly profit_print_dbContext _context;

        public ExecutorRepository()
        {
            _context = new profit_print_dbContext();
        }

        public void Create(Executor executor)
        {
            _context.Executor.Add(executor);
            _context.SaveChanges(true);
        }

        public void Delete(Executor executor)
        {
            _context.Executor.Remove(executor);
            _context.SaveChanges(true);
        }

        public Executor Read(long id)
        {
            return _context.Executor.FirstOrDefault(_ => _.Id == id);
        }

        public List<Executor> Read()
        {
            return _context.Executor.ToList();
        }
    }
}
