using System;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Converters
{
    public static class RegisterModelToUserModelConverter
    {
        public static User Convert(RegisterModel registerModel)
        {
            try
            {
                var user = new User { Email = registerModel.Email, Phone = registerModel.Phone };
                var cutomer = new Customer
                {
                    LastName = registerModel.LastName,
                    FirstName = registerModel.FirstName,
                    IdNavigation = user
                };
                var userCredentials = new Usercredentials
                {
                    User = user,
                    Login = registerModel.Login,
                    UserId = user.Id,
                    Password = registerModel.Password,
                    Role = registerModel.UserRoles
                };

                user.Usercredentials = userCredentials;
                user.Customer = cutomer;
                return user;
            }
            catch (Exception)
            {
                throw new Exception("Can not be converted");
            }
        }
    }
}
