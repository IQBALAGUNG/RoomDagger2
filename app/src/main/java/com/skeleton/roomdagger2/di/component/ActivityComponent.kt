package com.skeleton.roomdagger2.di.component

import com.fourseven.daggertryout.di.PerActivity
import com.skeleton.roomdagger2.di.module.ActivityModule
import com.skeleton.roomdagger2.ui.main.MainActivity
import dagger.Component

/**
 * Created by Iqbal Agung Gunawan on 26/07/2018.
 */
@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}