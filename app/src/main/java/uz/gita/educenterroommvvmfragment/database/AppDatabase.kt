package uz.gita.educenterroommvvmfragment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.educenterroommvvmfragment.daos.CourseDao
import uz.gita.educenterroommvvmfragment.daos.GroupDao
import uz.gita.educenterroommvvmfragment.data.CourseData
import uz.gita.educenterroommvvmfragment.data.GroupData

@Database(entities = [CourseData::class, GroupData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groupDao(): GroupDao

    abstract fun courseDao(): CourseDao

    companion object {
        private var instance: AppDatabase? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appdatabase"
                )
                    .allowMainThreadQueries()
                    .build()
            }
        }

        fun getDatabase() = instance!!
    }

}