package com.skeleton.roomdagger2.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.skeleton.roomdagger2.data.db.dao.StudentDao
import com.skeleton.roomdagger2.data.db.entity.StudentData
import javax.inject.Singleton


/**
 * Created by Iqbal Agung Gunawan on 24/07/2018.
 */
@Database(entities = [(StudentData::class)], version = AppDb.VERSION)
abstract class AppDb : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun getStudentDao(): StudentDao

}