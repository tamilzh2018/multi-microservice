// Startup.cs
public class Startup {
    public void ConfigureServices(IServiceCollection services) {
        services.AddControllers();
    }

    public void Configure(IApplicationBuilder app, IWebHostEnvironment env) {
        app.UseRouting();
        app.UseEndpoints(endpoints => {
            endpoints.MapControllers();
        });
    }
}

// MyController.cs
[ApiController]
[Route("api/data")]
public class MyController : ControllerBase {
    [HttpGet]
    public ActionResult<string> GetData() {
        return "Hello from C#!";
    }
}
