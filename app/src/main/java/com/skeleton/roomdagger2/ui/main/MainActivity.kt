package com.skeleton.roomdagger2.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.skeleton.roomdagger2.DemoApp
import com.skeleton.roomdagger2.R
import com.skeleton.roomdagger2.data.db.dao.StudentDao
import com.skeleton.roomdagger2.data.db.entity.StudentData
import com.skeleton.roomdagger2.di.component.ActivityComponent
import com.skeleton.roomdagger2.di.component.DaggerActivityComponent
import com.skeleton.roomdagger2.di.module.ActivityModule
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mStudentDao: StudentDao

    private lateinit var mActivityComponent: ActivityComponent

    private var mComposite = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent(DemoApp.get(this).getComponent())
                .build()

        mActivityComponent.inject(this)

        val studentData = StudentData(
                0, "george", 20, "england"
        )


        val insertion = Observable.fromCallable { mStudentDao.insertStudent(studentData) }

        mComposite.add(
                insertion.subscribeOn(Schedulers.newThread())
                .subscribe{
                    Log.d("MAIN_ACT", "USER_SAVED")
                })

        mComposite.add(mStudentDao.getAll()
                .subscribeOn(Schedulers.newThread())
                .subscribe({
                    val listStudent = it
                    listStudent.forEachIndexed { index, studentData ->
                        Log.d("MAIN_ACT", listStudent[index].name)
                        Log.d("MAIN_ACT", listStudent[index].address)
                    }
                }, {
                    Log.e("MAIN_ACT", "no user bruv")
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        mComposite.dispose()
    }
}