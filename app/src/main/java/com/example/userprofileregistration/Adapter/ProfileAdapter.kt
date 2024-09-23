package com.example.userprofileregistration.Adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration.Models.UserProfile
import com.example.userprofileregistration.R

class ProfileAdapter():ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback()) {
    private lateinit var  OnItemClickListener:((UserProfile)->Unit)
    private lateinit var  OnDeleteClickListener:((UserProfile)->Unit)
    private lateinit var  OnEditClickListener:((UserProfile)->Unit)

    fun setOnItemClickListener(listener: (UserProfile) -> Unit) {

        OnItemClickListener = listener
    }
    fun setOnDeleteClickListener(listener: (UserProfile) -> Unit) {
        OnDeleteClickListener = listener
    }
    fun setOnEditClickListener(listener: (UserProfile) -> Unit) {
         OnEditClickListener = listener
    }

    class ProfileViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        private val profileName: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDob: TextView = itemView.findViewById(R.id.DobTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.districtTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.mobileTxt)
        private val editBtn: TextView = itemView.findViewById(R.id.editBtn)
        private val deleteBtn: TextView = itemView.findViewById(R.id.deleteBtn)

        fun bind(userProfile: UserProfile) {
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDob.text = userProfile.dob
            profileDistrict.text = userProfile.district

        }

}


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder  {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_layout, parent, false)
        return  ProfileViewHolder(itemView)

    }
    override fun onBindViewHolder(holder:ProfileAdapter.ProfileViewHolder, position: Int) {
         holder.bind(getItem(position))
    }
}
class  DiffCallback :DiffUtil.ItemCallback<UserProfile>(){
    override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return  oldItem == newItem

    }

}


