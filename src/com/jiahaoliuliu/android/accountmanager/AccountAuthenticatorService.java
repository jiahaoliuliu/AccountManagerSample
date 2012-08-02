/*
 * Copyright (C) 2012 Jiahao Liu <http://www.jiahaoliuliu.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiahaoliuliu.android.accountmanager;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/*
 * Authenticator service that returns a subclass of AbstractAccountAuthenticator in onBind()
 */
public class AccountAuthenticatorService extends Service{

    private static final String LOG_TAG = AccountAuthenticatorService.class.getSimpleName();
    private static AccountAuthenticatorImpl sAccountAuthenticator = null;

    public AccountAuthenticatorService() {
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {
        IBinder ret = null;
        if (intent.getAction().equals(android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT)) {
            ret = getAuthenticator().getIBinder();
        }
        return ret;
    }

    private AccountAuthenticatorImpl getAuthenticator() {
        if (AccountAuthenticatorService.sAccountAuthenticator == null) {
            AccountAuthenticatorService.sAccountAuthenticator = new AccountAuthenticatorImpl(this);
        }

        return AccountAuthenticatorService.sAccountAuthenticator;
    }
    private static class AccountAuthenticatorImpl extends AbstractAccountAuthenticator {
        private Context mContext;

        public AccountAuthenticatorImpl (Context context) {
            super(context);
            mContext = context;
        }

        /*
         * The user has requested to add a new account to the system. We return an intent that will launch
         * our login screen if the user has not logged in yet, otherwise our activity will just pass the
         * user's credentials on to the account manager
         */
        @Override
        public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options)
                throws NetworkErrorException {
            Bundle reply = new Bundle();

            /*
            Intent i = new Intent(mContext, LastFMLoginSampleActivity.class);
            i.setAction("fm.last.android.sync.LOGIN");
            i.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
            reply.putParcelable(AccountManager.KEY_INTENT, i);
			*/
            return reply;
        }

        @Override
        public Bundle confirmCredentials(AccountAuthenticatorResponse arg0, Account arg1, Bundle arg2)
                throws NetworkErrorException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Bundle editProperties(AccountAuthenticatorResponse arg0, String arg1) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Bundle getAuthToken(AccountAuthenticatorResponse arg0, Account arg1, String arg2, Bundle arg3)
                throws NetworkErrorException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getAuthTokenLabel(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Bundle hasFeatures(AccountAuthenticatorResponse arg0, Account arg1, String[] arg2)
                throws NetworkErrorException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Bundle updateCredentials(AccountAuthenticatorResponse arg0, Account arg1, String arg2, Bundle arg3)
                throws NetworkErrorException {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
