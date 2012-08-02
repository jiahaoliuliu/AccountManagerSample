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

import android.content.Context;

/**
 * This class simulates the login/sign up of a server.
 * Because it is only a demo, all the data are saved in the shared preferences
 * In the shared preferences, the username will be saved as key and the password
 * will be saved as value
 * @author Jiahao Liu
 * @version 0.1
 */
public class FakeServer {

    private static final String FILE_NAME = "users";

    private Context context;

    public FakeServer(Context context) {
        this.context = context;
        /*
         * TODO Enter the shared preferences
         */
    }

    /**
     * It allow the user to log in the server.
     * @param userName The user name to log in.
     * @param password The password to log in.
     * @return True if the user exists in the server and the password is correct
     *         False otherwise
     */
    public boolean login(String userName, String password) {
        /*
         * TODO implement it.
         */
        return true;
    }

    /**
     * This method allow the user to change the password.
     * @param userName The user name to change the password
     * @param oldPassword The old password to be removed
     * @param newPassword The new password to be set
     * @return True if the userName exists and the oldPassword is correct
     *         False otherwise
     */
    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        /*
         * TODO implement it
         */
        return true;
    }

    /**
     * This method allow the user to create a new user in the server.
     * @param userName The new user's name
     * @param password The password associated with the new user's name
     * @return True if the user doesn't exists before and the password has been set correctly
     *         False otherwise
     */
    public boolean SignUp(String userName, String password) {
        /*
         * TODO implement it
         */
        return true;
    }
}
