package com.skeleton.roomdagger2

import android.app.Application
import android.content.Context
import com.skeleton.roomdagger2.data.db.AppDb
import com.skeleton.roomdagger2.di.component.AppComponent
import com.skeleton.roomdagger2.di.component.DaggerAppComponent
import com.skeleton.roomdagger2.di.module.ApplicationModule
import com.skeleton.roomdagger2.di.module.RoomModule
import javax.inject.Inject

/**
 * Created by Iqbal Agung Gunawan on 24/07/2018.
 */
class DemoApp : Application() {

    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var appDb: AppDb

    companion object {
        fun get(context: Context): DemoApp {
            return context.applicationContext as DemoApp
        }
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        appComponent.inject(this)
    }

    fun getComponent(): AppComponent {
        return appComponent
    }
}