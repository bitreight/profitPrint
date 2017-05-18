using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Order
    {
        public long Id { get; set; }
        public int Count { get; set; }
        public string CustomerComment { get; set; }
        public long CustomerId { get; set; }
        public DateTime Date { get; set; }
        public string Description { get; set; }
        public long ExecutorId { get; set; }
        public long ExecutorServiceItemId { get; set; }
        public string Priority { get; set; }
        public string State { get; set; }

        public virtual Customer Customer { get; set; }
        public virtual Executor Executor { get; set; }
        public virtual Executorserviceitem ExecutorServiceItem { get; set; }
    }
}
