package com.okayyildirim.covid19support.Splash;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    private SplashView splashView;

    public SplashModule(SplashView splashView) {
        this.splashView = splashView;
    }

    @Provides
    SplashView providesSplashView(){
        return this.splashView;

    }

    @Provides
    SplashInteractor loginInteractor(){
        return new SplashInteractorImpl();
    }

    @Provides
    SplashPresenter loginPresenter(SplashInteractor splashInteractor, SplashView splashView){
        return new SplashPresenterImpl(splashInteractor, splashView);
    }

}
