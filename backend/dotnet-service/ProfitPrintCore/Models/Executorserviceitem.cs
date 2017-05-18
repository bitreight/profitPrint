using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Executorserviceitem
    {
        public Executorserviceitem()
        {
            Order = new HashSet<Order>();
        }

        public long Id { get; set; }
        public string Description { get; set; }
        public long ExecutorId { get; set; }
        public double? HighPriorityCoefficient { get; set; }
        public double? LowPriorityCoefficient { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }

        public virtual ICollection<Order> Order { get; set; }
        public virtual Executor Executor { get; set; }
    }
}
