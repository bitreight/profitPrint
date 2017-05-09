using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class Usercredentials
    {
        public long Id { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }
        public string Role { get; set; }
        public long? UserId { get; set; }

        public virtual User User { get; set; }
    }
}
