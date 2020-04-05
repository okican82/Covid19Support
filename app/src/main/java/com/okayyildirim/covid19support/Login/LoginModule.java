package com.okayyildirim.covid19support.Login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    private LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    LoginView providesMainScreenContractView() {
        return loginView;
    }

    @Provides
    LoginInteractor loginInteractor(){
        return new LoginInteractorImpl();
    }

    @Provides
    LoginPresenter loginPresenter(LoginInteractor loginInteractor, LoginView loginView){
        return new LoginPresenterImpl(loginInteractor, loginView);
    }

}
