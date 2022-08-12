package uz.gita.educenterroommvvmfragment.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import uz.gita.educenterroommvvmfragment.data.CourseData

interface CourseRepository {

    fun insertCourse(courseData: CourseData)

    fun updateCourse(courseData: CourseData)

    fun getAllCourses(): LiveData<List<CourseData>>

    fun getGroupsCount(courseId: Int): LiveData<Int>
}