package uz.gita.educenterroommvvmfragment.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.adapters.GroupAdapter
import uz.gita.educenterroommvvmfragment.vm.impl.GroupViewModelImpl

class GroupScreen : Fragment(R.layout.group_screen) {
    private lateinit var container: RecyclerView
    private lateinit var addButton: FloatingActionButton
    private lateinit var btnBack: ImageButton

    private val adapter: GroupAdapter by lazy { GroupAdapter() }
    private val viewModel: GroupViewModelImpl by viewModels()
    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openAddGroupScreen.observe(this) {
            navController.navigate(
                R.id.action_groupScreen_to_addGroupScreen,
                bundleOf(Pair("ID", it))
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        container = view.findViewById(R.id.container_group)
        addButton = view.findViewById(R.id.btn_add_group)
        btnBack = view.findViewById(R.id.btn_back)
        container.adapter = adapter
        val courseId = requireArguments().getInt("CourseId")

        viewModel.getGroups(courseId) //esindan chiqib qovotti shu

        viewModel.groupListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        addButton.setOnClickListener {
            viewModel.openAddGroupScreen(courseId)
        }

        adapter.setOnDeleteListener {
            viewModel.deleteGroup(it)
        }


    }
}