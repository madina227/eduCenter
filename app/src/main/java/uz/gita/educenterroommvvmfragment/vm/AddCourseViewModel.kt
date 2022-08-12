package uz.gita.educenterroommvvmfragment.vm

import androidx.lifecycle.LiveData

interface AddCourseViewModel {

    val confirmCourseLiveData: LiveData<Unit>

    val backLiveData: LiveData<Unit>

    fun confirmCourseLiveData()

    fun saveCourse(name: String)

    fun back()
}