namespace Game.Features.Identity.Model
{
    public class GoogleUser
    {
        public string ID { get; set; } = null!;
        public string AccessToken { get; set; } = null!;
        public string RefreshToken { get; set; } = null!;
        public string FirstName { get; set; } = null!;
        public string LastName { get; set; } = null!;
        public string Email { get; set; } = null!;
        public string ImageUrl { get; set; } = null!;
    }
}
