using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Registerkey
    {
        public long Id { get; set; }
        public long? ExecutorId { get; set; }
        public string Value { get; set; }

        public virtual Executor Executor { get; set; }
    }
}
