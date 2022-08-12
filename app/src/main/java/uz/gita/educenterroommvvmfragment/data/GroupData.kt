package uz.gita.educenterroommvvmfragment.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group")
data class GroupData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "group_name")
    val groupName: String,

    val mentor: String,
    @ColumnInfo(name = "course_id")
    val courseId: Int
)