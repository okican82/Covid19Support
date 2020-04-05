package com.okayyildirim.covid19support.SingUp;


import dagger.Module;
import dagger.Provides;


@Module
public class SingUpModule {

    private SingUpView SingUpView;

    public SingUpModule(SingUpView SingUpView)
    {
        this.SingUpView = SingUpView;
    }

    @Provides
    SingUpView SingUpView(){return SingUpView;}

    @Provides
    SingUpInteractor SingUpInteractor(){return new SingUpInteractorImpl();}

    @Provides
    SingUpPresenter SingUpPresenter(SingUpInteractor SingUpInteractor,SingUpView SingUpView){
        return new SingUpPresenterImpl(SingUpInteractor,SingUpView);
    }
}