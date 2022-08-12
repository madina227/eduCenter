package uz.gita.educenterroommvvmfragment.vm

import androidx.lifecycle.LiveData

interface AddGroupViewModel {

    val confirmGroupLiveData: LiveData<Unit>

    val backLiveData: LiveData<Unit>

    fun confirmGroupLiveData()

    fun saveGroup(name: String, mentor: String, courseId: Int)

    fun back()
}