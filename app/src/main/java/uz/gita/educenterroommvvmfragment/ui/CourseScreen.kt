package uz.gita.educenterroommvvmfragment.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.adapters.CourseAdapter
import uz.gita.educenterroommvvmfragment.vm.impl.CourseViewModelImpl

class CourseScreen : Fragment(R.layout.course_screen) {
    private lateinit var container: RecyclerView
    private lateinit var btnAdd: FloatingActionButton
    private val viewModel: CourseViewModelImpl by viewModels()
    private val adapter: CourseAdapter by lazy { CourseAdapter() }
    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openAddCourseLiveData.observe(this) {
            navController.navigate(R.id.action_courseScreen_to_addCourseScreen)
        }

        viewModel.openEditCourseLiveData.observe(this) {
            navController.navigate(R.id.action_courseScreen_to_editCourse, bundleOf(Pair("ID", it)))
        }

        viewModel.openGroupScreenLiveData.observe(this) {
            navController.navigate(
                R.id.action_courseScreen_to_groupScreen,
                bundleOf(Pair("CourseId", it))
            )
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd = view.findViewById(R.id.btn_add_course)
        container = view.findViewById(R.id.container_course)
        container.adapter = adapter


        viewModel.courseListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
//add buttonni bosilishi
        btnAdd.setOnClickListener {
            viewModel.openAddCourseScreen()
        }
//edit imageView bosilishi
        adapter.setOnEditCourseListener {
            viewModel.openEditCourseScreen(it)
        }
//item ustiga bosilishi
        adapter.setOnAddGroupListener {
            viewModel.openGroupsScreen(it)
        }
    }
}