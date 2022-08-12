package uz.gita.educenterroommvvmfragment.vm.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.educenterroommvvmfragment.data.GroupData
import uz.gita.educenterroommvvmfragment.repository.EduRepository
import uz.gita.educenterroommvvmfragment.repository.GroupRepository
import uz.gita.educenterroommvvmfragment.vm.AddGroupViewModel

class AddGroupViewModelImpl : AddGroupViewModel, ViewModel() {

    val repository: GroupRepository = EduRepository()

    override val confirmGroupLiveData = MutableLiveData<Unit>()

    override val backLiveData = MutableLiveData<Unit>()

    override fun confirmGroupLiveData() {
        confirmGroupLiveData.value = Unit
    }

    override fun saveGroup(name: String, mentor: String, courseId: Int) {
        repository.insertGroup(GroupData(0, name, mentor, courseId))
    }

    override fun back() {
        backLiveData.value = Unit
    }
}