using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Customer
    {
        public Customer()
        {
            Order = new HashSet<Order>();
        }

        public long Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public virtual ICollection<Order> Order { get; set; }
        public virtual User IdNavigation { get; set; }
    }
}
