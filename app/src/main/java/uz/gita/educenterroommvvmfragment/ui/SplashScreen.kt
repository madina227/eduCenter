package uz.gita.educenterroommvvmfragment.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.vm.impl.SplashViewModelImpl

class SplashScreen : Fragment(R.layout.splash_screen) {
    private val viewModel: SplashViewModelImpl by viewModels()
    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openCourseScreen.observe(viewLifecycleOwner) {
            navController.navigate(R.id.action_splashScreen_to_courseScreen)
        }
    }
}