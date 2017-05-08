using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Customer
    {
        public long Id { get; set; }
        public string Fname { get; set; }
        public string Lname { get; set; }

        public virtual User IdNavigation { get; set; }
    }
}
