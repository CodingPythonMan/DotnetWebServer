using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Base.Common
{
    public enum Roles
    {
        Admin = 0,
        Viewer
    }

    public enum ErrorResult
    {
        FAIL = 0,
        SUCCESS,

        // WEB
        ERROR_USER_DENIED = 10000,
        ERROR_SET_APPROVED_FOR_ALL,
        ERROR_NOT_SELECTED_WALLET_ACCOUNT,
        ERROR_NOT_LINKED_ACCOUNT,
        ERROR_ACCOUNT_NOT_MATCHED,
        ERROR_ALREADY_LINKED_ACCOUNT,
        ERROR_NOT_VERIFIED_CONFIRM_CODE,
        ERROR_USER_NOT_FOUND,
        ERROR_NOT_EXISTS_MARKETPLACE_ITEM,
        ERROR_NOT_EXISTS_NFT,
        ERROR_NOT_EXISTS_WALLETACCOUNT,
        ERROR_NOT_EXISTS_BUYERWALLETACCOUNT,
        ERROR_NOT_CONFIRMED_EMAIL,
        ERROR_INVAILD_PASSWORD,
        ERROR_ALREADY_EMAIL_ACCOUNT,
        ERROR_TASK_TIMEOUT,
        ERROR_EXPIRE_LINK,                  
        ERROR_INVAILD_TOKEN,                    
        ERROR_RESET_PASSWORD,                     
        ERROR_NOT_EXISTS_MARKETPLACE_CHARACTER,
        ERROR_NOT_EXISTS_NFT_CHARACTER,
        ERROR_REQUIRED_GAME_ACCESS,
        ERROR_TASK_CANCELED,
        ERROR_COST,           
        ERROR_SIGNEDSIGNATURE,						 
    }
}
