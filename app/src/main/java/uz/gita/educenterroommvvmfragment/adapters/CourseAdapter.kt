package uz.gita.educenterroommvvmfragment.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.data.CourseData

class CourseAdapter : ListAdapter<CourseData, CourseAdapter.CourseViewHolder>(CourseCallBack) {
    private var editCourseListener: ((Int) -> Unit)? = null

    private var addGroupToCourseListener: ((Int) -> Unit)? = null

    fun setOnEditCourseListener(block: ((Int) -> Unit)) {
        editCourseListener = block
    }

    fun setOnAddGroupListener(block: (Int) -> Unit) {
        addGroupToCourseListener = block
    }

    object CourseCallBack : DiffUtil.ItemCallback<CourseData>() {

        override fun areItemsTheSame(oldItem: CourseData, newItem: CourseData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CourseData, newItem: CourseData): Boolean {
            return oldItem.id == newItem.id && oldItem.courseName == newItem.courseName
        }

    }

    inner class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvCourseName: TextView = view.findViewById(R.id.tv_course_name)
        private val tvCount: TextView = view.findViewById(R.id.tv_count)
        private val btnEdit: ImageButton = view.findViewById(R.id.btn_edit_course)

        fun bind() {
            val item = getItem(adapterPosition)
            tvCourseName.text = item.courseName
            //  tvCount.text=item. todo
        }

        init {
            btnEdit.setOnClickListener {
                editCourseListener?.invoke(getItem(adapterPosition).id)
            }

            view.setOnClickListener {
                addGroupToCourseListener?.invoke(getItem(adapterPosition).id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind()
    }
}