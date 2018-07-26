package com.skeleton.roomdagger2.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides


/**
 * Created by Iqbal Agung Gunawan on 21/07/2018.
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }
}
