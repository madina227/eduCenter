package uz.gita.educenterroommvvmfragment.app

import android.app.Application
import uz.gita.educenterroommvvmfragment.database.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)
    }
}