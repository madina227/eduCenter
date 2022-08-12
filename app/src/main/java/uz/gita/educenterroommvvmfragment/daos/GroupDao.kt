package uz.gita.educenterroommvvmfragment.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import uz.gita.educenterroommvvmfragment.data.GroupData

@Dao
interface GroupDao : BaseDao<GroupData> {

    @Query("SELECT * FROM `group` WHERE course_id=:id")
    fun getGroups(id: Int): LiveData<List<GroupData>>


}