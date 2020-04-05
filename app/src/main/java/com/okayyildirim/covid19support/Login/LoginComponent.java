package com.okayyildirim.covid19support.Login;

import dagger.Component;


@Component(modules = {LoginModule.class})
interface LoginComponent {

    void inject(LoginActivity loginActivity);
}

