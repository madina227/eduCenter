package uz.gita.educenterroommvvmfragment.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.vm.impl.EditCourseViewModelImpl

class EditCourseScreen : Fragment(R.layout.edit_course_screen) {
    private lateinit var etName: EditText
    private lateinit var confirm: Button
    private lateinit var btnBack: ImageButton

    private val viewModel: EditCourseViewModelImpl by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.backLiveData.observe(this) {
            navController.navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_edit_course)
        confirm = view.findViewById(R.id.btn_edit_courseS)
        btnBack = view.findViewById(R.id.btn_back_edit_course)


        val id = requireArguments().getInt("ID", id)

        confirm.setOnClickListener {
            viewModel.saveCourse(id, etName.text.toString())
            viewModel.back()
        }

        btnBack.setOnClickListener {
            viewModel.back()
        }
    }
}