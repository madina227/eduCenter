package uz.gita.educenterroommvvmfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.educenterroommvvmfragment.R
import uz.gita.educenterroommvvmfragment.data.GroupData

class GroupAdapter : ListAdapter<GroupData, GroupAdapter.GroupViewHolder>(GroupCallBack) {

    var deleteListener: ((GroupData) -> Unit)? = null

    fun setOnDeleteListener(block: (GroupData) -> Unit) {
        deleteListener = block
    }

    object GroupCallBack : DiffUtil.ItemCallback<GroupData>() {
        override fun areItemsTheSame(oldItem: GroupData, newItem: GroupData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GroupData, newItem: GroupData): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.groupName == newItem.groupName &&
                    oldItem.mentor == newItem.mentor &&
                    oldItem.courseId == newItem.courseId
        }

    }

    inner class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val groupName = view.findViewById<TextView>(R.id.tv_group_name)
        private val mentorName = view.findViewById<TextView>(R.id.tv_mentor)
        private val ivDelete = view.findViewById<ImageView>(R.id.btn_delete_group)
        private val ivEdit = view.findViewById<ImageView>(R.id.btn_edit_group)
        fun bind() {
            val item = getItem(adapterPosition)
            groupName.text = item.groupName
            mentorName.text = item.mentor
        }

        init {
            ivDelete.setOnClickListener {
                deleteListener?.invoke(getItem(adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind()
    }
}