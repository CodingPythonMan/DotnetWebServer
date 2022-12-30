using Game.Features.Identity.Model;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Identity;
using Shared.Base.Common;

namespace Game.Features.GameSite.Pages
{
    public partial class AssignRoles
    {
        class UserRoleInfo
        {
            public string Email { get; set; } = null!;
            public bool[] Roles { get; set; } = new bool[Enum.GetValues(typeof(Roles)).Length];
        }

        [Inject]
        UserManager<GameSiteUser> _UserManager { get; set; } = null!;

        List<UserRoleInfo> _userRoleInfos = new();

        Dictionary<(int infoIdx, int roleIdx), bool> _dirties = new();

        protected override async Task OnInitializedAsync()
        {
            await _InitUserRoleInfo();

            StateHasChanged();
        }

        async Task _InitUserRoleInfo()
        {
            var users = _UserManager.Users.ToList();

            foreach (var user in users)
            {
                UserRoleInfo userRoleInfo = new();
                userRoleInfo.Email = user.UserName;
                //LOG.Trace(user.UserName);

                var roles = await _UserManager.GetRolesAsync(user);

                for (int i = 0; i < roles.Count; i++)
                {
                    int idx = (int)Enum.Parse(typeof(Roles), roles[i]);
                    userRoleInfo.Roles[idx] = true;
                }

                _userRoleInfos.Add(userRoleInfo);
            }
        }

        async void _OnClickSave()
        {
            await SaveRoleInfo();
        }

        void _OnChangedRole(int infoIdx, int roleIdx, object eventArgsVal)
        {
            //LOG.Trace(changed);
            bool changed = (bool)eventArgsVal;

            _userRoleInfos[infoIdx].Roles[roleIdx] = changed;

            var key = (infoIdx, roleIdx);

            _dirties[key] = changed;


            StateHasChanged();
        }

        async Task SaveRoleInfo()
        {
            Dictionary<string, GameSiteUser> _users = new();

            foreach (var dirty in _dirties)
            {
                GameSiteUser user;
                if (_users.ContainsKey(_userRoleInfos[dirty.Key.infoIdx].Email))
                {
                    user = _users[_userRoleInfos[dirty.Key.infoIdx].Email];
                }
                else
                {
                    user = await _UserManager.FindByEmailAsync(_userRoleInfos[dirty.Key.infoIdx].Email);
                }

                string roleString = ((Roles)dirty.Key.roleIdx).ToString();

                bool isInRole = await _UserManager.IsInRoleAsync(user, roleString);

                if (dirty.Value != isInRole)
                {
                    if (dirty.Value)
                    {
                        var result = await _UserManager.AddToRoleAsync(user, roleString);
                        //LOG.Trace("");
                    }
                    else
                    {
                        var result = await _UserManager.RemoveFromRoleAsync(user, roleString);
                        //LOG.Trace("");
                    }
                }
            }
        }

    }
}
