using System;
using Microsoft.AspNetCore.Mvc;
using ProfitPrintCore.Converters;
using ProfitPrintCore.Interfaces;
using ProfitPrintCore.Models;

namespace ProfitPrintCore.Controllers
{
    [Route("api/customer")]
    public class RegisterController : Controller
    {
        private readonly IUserRepository _repository;

        public RegisterController(IUserRepository repository)
        {
            _repository = repository;
        }

        [HttpPost]
        public IActionResult Post([FromBody]RegisterModel registerModel)
        {
            try
            {
                if (registerModel == null)
                {
                    ModelState.AddModelError("", "Не указаны данные для пользователя");
                    return BadRequest(ModelState);
                }
                if (!ModelState.IsValid)
                    return BadRequest(ModelState);

                _repository.Create(RegisterModelToUserModelConverter.Convert(registerModel));

                return Ok();
            }   
            catch (Exception exception)
            {
                return BadRequest(exception.Message);
            }
        }
    }
}