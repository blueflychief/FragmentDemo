package com.example.administrator.fragmentdemo.login;

/**
 * Created by Administrator on 2016-04-16.
 */
public class LoginStateManager {
    private static boolean mIsLogin = false;

    public LoginStateManager() {
    }

    private static class SingletonHolder {
        private static final LoginStateManager INSTANCE = new LoginStateManager();
    }

    public static final LoginStateManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void changLoginState(boolean is_login) {
        mIsLogin = is_login;
    }

    public static boolean isLogin() {
        return mIsLogin;
    }
}
