package uz.gita.educenterroommvvmfragment.vm.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.educenterroommvvmfragment.data.CourseData
import uz.gita.educenterroommvvmfragment.repository.CourseRepository
import uz.gita.educenterroommvvmfragment.repository.EduRepository
import uz.gita.educenterroommvvmfragment.vm.EditCourseViewModel

class EditCourseViewModelImpl : EditCourseViewModel, ViewModel() {

    private val repository: CourseRepository = EduRepository()

    override val saveCourseLiveData = MutableLiveData<Unit>()

    override val backLiveData = MutableLiveData<Unit>()

    override fun confirmCourseLiveData() {

    }

    //edit qvotganda id qattan olarkan
    override fun saveCourse(id: Int, name: String) {
        repository.updateCourse(CourseData(id, name))
    }

    override fun back() {
        backLiveData.value = Unit
    }
}