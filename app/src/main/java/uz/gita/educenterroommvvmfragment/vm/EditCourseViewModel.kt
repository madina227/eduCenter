package uz.gita.educenterroommvvmfragment.vm

import androidx.lifecycle.LiveData

interface EditCourseViewModel {

    val saveCourseLiveData: LiveData<Unit>

    val backLiveData: LiveData<Unit>

    fun confirmCourseLiveData()

    fun saveCourse(id: Int, name: String)

    fun back()
}