package com.skeleton.roomdagger2.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.skeleton.roomdagger2.data.db.AppDb
import com.skeleton.roomdagger2.data.db.dao.StudentDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Iqbal Agung Gunawan on 24/07/2018.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() = application

    private var appDb: AppDb = Room.databaseBuilder(application, AppDb::class.java, "db_demo").build()

    @Singleton
    @Provides
    fun providesAppDb(): AppDb = appDb

    @Singleton
    @Provides
    fun providesStudentDao(): StudentDao = appDb.getStudentDao()
}