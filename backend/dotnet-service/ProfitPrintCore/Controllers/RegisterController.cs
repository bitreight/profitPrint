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

        //public async Task GetToken(LoginModel loginModel)
        //{
        //     var client = new HttpClient();
        //    client.DefaultRequestHeaders.Accept.Clear();
        //    client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer <token>");
        //    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        //    var response = await client.PostAsync("http://localhost:9092/auth/login", new StringContent(JsonConvert.SerializeObject(loginModel), Encoding.UTF8, "application/json"));
        //    var token = new JsonObject(await response.Content.ReadAsStringAsync());
        //    response.EnsureSuccessStatusCode();
        //}

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

        //DELETE api/values/5
        //[HttpDelete("{id}")]
        //public void Delete(long id)
        //{
        //}
    }
}
