package com.skeleton.roomdagger2.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Iqbal Agung Gunawan on 24/07/2018.
 */
@Entity(tableName = "tbStudent")
data class StudentData(@PrimaryKey(autoGenerate = true) var id: Long?,
                       @ColumnInfo(name = "name") var name: String,
                       @ColumnInfo(name = "age") var age: Int,
                       @ColumnInfo(name = "address") var address: String)