using Game.Features.Identity.Components;
using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection.Extensions;
using Shared.Base.Common;
using Shared.Services.Config;
using Shared.Services.DB.GameSiteUserDB;
using Shared.Services.DBConnectString;
using System.Data;

var builder = WebApplication.CreateBuilder(args);

builder.WebHost.UseUrls("http://*:80");

// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();

// Dependency Injection
builder.Services.AddSingleton<ConfigService>(new ConfigService());

DBConnectStringService dbConnectStringService = new DBConnectStringService();
builder.Services.AddSingleton<DBConnectStringService>(dbConnectStringService);

builder.Services.AddScoped<GameSiteUserDBService>();

builder.Services.AddDbContext<ApplicationDbContext>(options => 
    options.UseSqlServer(dbConnectStringService.GetConnectionString(Shared.Base.Common.Defines.GameSiteUserDB)));

builder.Services.AddIdentity<GameSiteUser, IdentityRole<long>>(options =>
{
    options.Password.RequireLowercase = false;
    options.Password.RequireUppercase = false;
    options.Password.RequireNonAlphanumeric = false;

    options.User.RequireUniqueEmail = true;
    options.Password.RequiredLength = 4;

    options.Tokens.PasswordResetTokenProvider = TokenOptions.DefaultPhoneProvider;
    options.Tokens.EmailConfirmationTokenProvider = TokenOptions.DefaultPhoneProvider;

    //이메일인증을 한다.
    options.SignIn.RequireConfirmedEmail = true;

}).AddEntityFrameworkStores<ApplicationDbContext>()
.AddDefaultTokenProviders();


builder.Services.ConfigureApplicationCookie(options =>
{
    options.LoginPath = "/";
    options.ExpireTimeSpan = TimeSpan.FromMinutes(20);
});

// 왜 필요한건지 파악하기
/*builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("RequireAdmin", c => c.RequireRole("Admin"));
});*/

builder.Services.AddAuthentication(CookieAuthenticationDefaults.AuthenticationScheme)
.AddCookie(options =>
{
    options.Cookie.Name = "GoogleOAuth";
})
.AddGoogle(options =>
{
    //options.ClientId = builder.Configuration["Authentication:Google:ClientId"];
    //options.ClientSecret = builder.Configuration["Authentication:Google:ClientSecret"];
    options.ClientId = ConfigService._webServerConfig.auth.googleId;
    options.ClientSecret = ConfigService._webServerConfig.auth.googleSecret;
});

var app = builder.Build();

using var scope = app.Services.CreateScope();
var userManager = scope.ServiceProvider.GetService<UserManager<GameSiteUser>>()!;
var roleManager = scope.ServiceProvider.GetService<RoleManager<IdentityRole<long>>>()!;

var roles = Enum.GetNames(typeof(Roles));

for (int i = 0; i < roles.Length; i++)
{
    string roleName = roles[i];

    if (!roleManager.RoleExistsAsync(roleName).GetAwaiter().GetResult())
    {
        roleManager.CreateAsync(new IdentityRole<long>(roleName)).GetAwaiter().GetResult();
    }
}

if (false == string.IsNullOrEmpty(ConfigService._webServerConfig.env.gameId))
{
    var admin = userManager.FindByEmailAsync(ConfigService._webServerConfig.env.gameId).GetAwaiter().GetResult();
    if (admin == null)
    {
        userManager.CreateAsync(
            new GameSiteUser(ConfigService._webServerConfig.env.gameId)
            {
                Email = ConfigService._webServerConfig.env.gameId,
                EmailConfirmed = true
            }, ConfigService._webServerConfig.env.gamePassword
        ).GetAwaiter().GetResult();

        admin = userManager.FindByEmailAsync(ConfigService._webServerConfig.env.gameId).GetAwaiter().GetResult();
    }

    if (!userManager.IsInRoleAsync(admin, Constants.ROLE_ADMIN).GetAwaiter().GetResult())
    {
        userManager.AddToRoleAsync(admin, Constants.ROLE_ADMIN).GetAwaiter().GetResult();
    }
}

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

//app.UseHttpsRedirection();

app.UseStaticFiles();

app.UseRouting();

// SameSite 오류 해결
app.UseCookiePolicy(new CookiePolicyOptions()
{
    //MinimumSameSitePolicy = SameSiteMode.Lax
    Secure = CookieSecurePolicy.Always
});

// 인증
app.UseAuthentication();
app.UseAuthorization();

// Controller 사용
app.MapControllers();

app.MapBlazorHub();
app.MapFallbackToPage("/_Host");

app.Run();
