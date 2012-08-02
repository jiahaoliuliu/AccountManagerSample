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

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class AccountManagerSampleActivity extends Activity {
	// With this we can make sure if the name of the class is changed
	// the log tag will be changed also
	private static final String LOG_TAG = AccountManagerSampleActivity.class.getSimpleName();
	public static final String PREFS = "LoginPrefs";
	private AccountManager accountManager;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Creates the account manager
		accountManager = AccountManager.get(this);

		SharedPreferences settings = getSharedPreferences(PREFS, 0);
		String userName = settings.getString("userName", "");
		
		// If the username == "" -> Request user to log in
		// if the username != "" but it doesn't exists in the accountmananger ->
		//	request user to log in
		// else log in with the username and the password
		if (userName.equalsIgnoreCase("")) {
			requestLogin();
		} else {
			// Check if there any account in account manager with such username
			Account[] accounts = accountManager.getAccountsByType(getResources().getString(R.string.account_type));
			// If there is not account of the type required
			if (accounts.length <= 0) {
				requestLogin();
			} else {
				boolean accountFound = false;
				for (Account account : accounts) {
					if (account.name.equals(userName)) {
						accountFound = true;
						String authToken = getAuthToken(account);
						loginWithUserNameAuthToken(userName, authToken);
					}
				}
				
				if (!accountFound) {
					requestLogin();
				}
			}
		}

        
    }
    
    // Request the authToken to the Account manager based on one account
    private String getAuthToken(Account account) {
    	return "";
    }
    
    // There was something wrong with the user account
    // Request the user to login
    private void requestLogin() {
        setContentView(R.layout.main);
    }
    
    private void loginWithUserNameAuthToken(String userName, String authToken) {
    	Log.v(LOG_TAG, "Login with the user name \"" + userName + "\" and the authToken \"" + authToken);
    }
}