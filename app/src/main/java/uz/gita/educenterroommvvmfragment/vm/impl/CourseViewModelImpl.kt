package uz.gita.educenterroommvvmfragment.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.educenterroommvvmfragment.data.CourseData
import uz.gita.educenterroommvvmfragment.repository.CourseRepository
import uz.gita.educenterroommvvmfragment.repository.EduRepository
import uz.gita.educenterroommvvmfragment.vm.CourseViewModel

class CourseViewModelImpl : CourseViewModel, ViewModel() {
    val repository: CourseRepository = EduRepository()

    override val courseListLiveData = MediatorLiveData<List<CourseData>>()
    override val openAddCourseLiveData = MutableLiveData<Unit>()
    override val openEditCourseLiveData = MutableLiveData<Int>()
    override val openGroupScreenLiveData = MutableLiveData<Int>()


    init {
        courseListLiveData.addSource(repository.getAllCourses()) {
            courseListLiveData.value = it
        }
    }

    override fun insertCourse(courseData: CourseData) {
        repository.insertCourse(courseData)
    }

    override fun getAllCourses(): LiveData<List<CourseData>> {
        return repository.getAllCourses()
    }

    override fun getGroupsCount(courseId: Int): LiveData<Int> {
        return repository.getGroupsCount(courseId)
    }

    override fun openAddCourseScreen() {
        openAddCourseLiveData.value = Unit
    }

    override fun openGroupsScreen(id: Int) {
        openGroupScreenLiveData.value = id
    }

    override fun openEditCourseScreen(id: Int) {
        openEditCourseLiveData.value = id
    }


}