package uz.gita.educenterroommvvmfragment.repository

import androidx.lifecycle.LiveData
import uz.gita.educenterroommvvmfragment.data.CourseData
import uz.gita.educenterroommvvmfragment.data.GroupData
import uz.gita.educenterroommvvmfragment.database.AppDatabase

class EduRepository : CourseRepository, GroupRepository {

    private val database: AppDatabase = AppDatabase.getDatabase()

    override fun insertCourse(courseData: CourseData) {
        database.courseDao().insert(courseData)
    }

    override fun updateCourse(courseData: CourseData) {
        database.courseDao().update(courseData)
    }

    override fun getAllCourses(): LiveData<List<CourseData>> {
        return database.courseDao().getAllCourses()
    }

    override fun getGroupsCount(courseId: Int): LiveData<Int> {
        return database.courseDao().getGroupsCount(courseId)
    }

    override fun insertGroup(groupData: GroupData) {
        database.groupDao().insert(groupData)
    }

    override fun updateGroup(groupData: GroupData) {
        database.groupDao().update(groupData)
    }

    override fun deleteGroup(groupData: GroupData) {
        database.groupDao().delete(groupData)
    }

    override fun getAllGroups(id: Int): LiveData<List<GroupData>> {
        return database.groupDao().getGroups(id)
    }

}