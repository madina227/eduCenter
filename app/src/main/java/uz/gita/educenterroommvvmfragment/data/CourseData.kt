package uz.gita.educenterroommvvmfragment.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "course_name")
    val courseName: String
)
