package com.sfw.smallupdate.smallupdate_lib.lib.ours;

import dagger.Component;

/**
 *
 */
@Component(modules = {WeatherModule.class})
public interface WeatherComponent {
    void inject(WeatherModel weatherModel);
}
