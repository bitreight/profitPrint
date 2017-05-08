using System;
using System.Collections.Generic;

namespace ProfitPrintCore.Models
{
    public partial class UserCredentials
    {
        public long Id { get; set; }
        public long? FkUserId { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }
        public string Role { get; set; }

        public virtual User FkUser { get; set; }
    }
}
