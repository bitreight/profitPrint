using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class User
    {
        public long Id { get; set; }
        public string Email { get; set; }
        public string Phone { get; set; }

        public virtual Customer Customer { get; set; }
        public virtual Executor Executor { get; set; }
        public virtual Usercredentials Usercredentials { get; set; }
    }
}
