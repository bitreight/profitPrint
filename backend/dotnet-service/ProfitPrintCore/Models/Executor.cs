using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Executor
    {
        public long Id { get; set; }

        public virtual User IdNavigation { get; set; }
    }
}
