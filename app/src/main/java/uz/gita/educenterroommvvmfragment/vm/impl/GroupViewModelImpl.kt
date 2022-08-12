package uz.gita.educenterroommvvmfragment.vm.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.educenterroommvvmfragment.data.GroupData
import uz.gita.educenterroommvvmfragment.repository.EduRepository
import uz.gita.educenterroommvvmfragment.repository.GroupRepository
import uz.gita.educenterroommvvmfragment.vm.GroupViewModel

class GroupViewModelImpl : GroupViewModel, ViewModel() {

    private val repository: GroupRepository = EduRepository()


    override val groupListLiveData = MediatorLiveData<List<GroupData>>()

    override val openAddGroupScreen = MutableLiveData<Int>()

    override val backToCourseScreen = MutableLiveData<Unit>()

    override val editGroupItem = MutableLiveData<Int>()

    override val deleteGroupItem = MutableLiveData<Unit>()

    override fun insertGroup(groupData: GroupData) {
        repository.insertGroup(groupData)
    }

    override fun updateGroup(groupData: GroupData) {
        repository.updateGroup(groupData)
    }

    override fun deleteGroup(groupData: GroupData) {
        repository.deleteGroup(groupData)
    }

    override fun getGroups(id: Int) {
        groupListLiveData.addSource(repository.getAllGroups(id)) {
            groupListLiveData.value = it
        }
    }

    override fun openAddGroupScreen(id: Int) {
        openAddGroupScreen.value = id
    }

    override fun back() {
        backToCourseScreen.value = Unit
    }

    override fun openEditGroupScreen(id: Int) {
        editGroupItem.value = id
    }
}