using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Executor
    {
        public Executor()
        {
            Executorserviceitem = new HashSet<Executorserviceitem>();
            Order = new HashSet<Order>();
        }

        public long Id { get; set; }
        public string Address { get; set; }
        public TimeSpan CloseTime { get; set; }
        public double Latitude { get; set; }
        public double Longtitude { get; set; }
        public TimeSpan OpenTime { get; set; }
        public string Title { get; set; }
        public string WebSite { get; set; }

        public virtual ICollection<Executorserviceitem> Executorserviceitem { get; set; }
        public virtual ICollection<Order> Order { get; set; }
        public virtual Registerkey Registerkey { get; set; }
        public virtual User IdNavigation { get; set; }
    }
}
