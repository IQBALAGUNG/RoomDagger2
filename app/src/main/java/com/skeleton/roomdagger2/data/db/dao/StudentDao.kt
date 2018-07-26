package com.skeleton.roomdagger2.data.db.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.skeleton.roomdagger2.data.db.entity.StudentData
import io.reactivex.Single

/**
 * Created by Iqbal Agung Gunawan on 24/07/2018.
 */
@Dao
interface StudentDao {

    @Query("SELECT * FROM tbStudent")
    fun getAll(): Single<List<StudentData>>

    @Insert(onConflict = REPLACE)
    fun insertStudent(studentData: StudentData)

    @Update
    fun updateStudent(studentData: StudentData)

    @Delete
    fun removeStudent(studentData: StudentData)

    @Query("SELECT * FROM tbStudent WHERE age > :minAge")
    fun loadOlderThan(minAge: Int): List<StudentData>

    @Query("DELETE FROM tbStudent")
    fun truncate()

}