package com.okayyildirim.covid19support.SingUp;

import dagger.Component;


@Component(modules = {SingUpModule.class})
public interface SingUpComponent {
    void inject(SingUpActivity singUpActivity);
}
