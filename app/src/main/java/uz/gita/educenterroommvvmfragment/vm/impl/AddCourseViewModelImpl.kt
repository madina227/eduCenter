package uz.gita.educenterroommvvmfragment.vm.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.educenterroommvvmfragment.data.CourseData
import uz.gita.educenterroommvvmfragment.repository.CourseRepository
import uz.gita.educenterroommvvmfragment.repository.EduRepository
import uz.gita.educenterroommvvmfragment.vm.AddCourseViewModel

class AddCourseViewModelImpl : AddCourseViewModel, ViewModel() {
    val repository: CourseRepository = EduRepository()

    override val confirmCourseLiveData = MutableLiveData<Unit>()

    override val backLiveData = MutableLiveData<Unit>()

    override fun saveCourse(name: String) {
        repository.insertCourse(CourseData(0, name))
    }

    override fun back() {
        backLiveData.value = Unit
    }

    override fun confirmCourseLiveData() {
        confirmCourseLiveData.value = Unit
    }
}