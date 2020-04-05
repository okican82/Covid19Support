package com.okayyildirim.covid19support.Splash;

import dagger.Component;

@Component(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
