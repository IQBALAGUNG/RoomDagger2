package com.skeleton.roomdagger2.di.component

import android.app.Application
import com.skeleton.roomdagger2.data.db.AppDb
import com.skeleton.roomdagger2.data.db.dao.StudentDao
import com.skeleton.roomdagger2.di.module.ApplicationModule
import com.skeleton.roomdagger2.di.module.RoomModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Iqbal Agung Gunawan on 25/07/2018.
 */
@Singleton
@Component(modules = [ApplicationModule::class, RoomModule::class])
interface AppComponent {

    fun inject(application: Application)

    val studentDao: StudentDao

    val appDb: AppDb

//    val app: DemoApp
}