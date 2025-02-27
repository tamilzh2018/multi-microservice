using Microsoft.AspNetCore.Mvc;

namespace csharp_api.Controllers
{
    [ApiController]
    [Route("api/data")]
    public class MyController : ControllerBase
    {
        [HttpGet]
        public ActionResult<string> GetData()
        {
            return "Hello from C#!";
        }
    }
}
