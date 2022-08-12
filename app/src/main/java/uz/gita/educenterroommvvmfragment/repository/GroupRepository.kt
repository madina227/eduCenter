package uz.gita.educenterroommvvmfragment.repository

import androidx.lifecycle.LiveData
import uz.gita.educenterroommvvmfragment.data.GroupData

interface GroupRepository {

    fun insertGroup(groupData: GroupData)

    fun updateGroup(groupData: GroupData)

    fun deleteGroup(groupData: GroupData)

    fun getAllGroups(id:Int): LiveData<List<GroupData>>

}