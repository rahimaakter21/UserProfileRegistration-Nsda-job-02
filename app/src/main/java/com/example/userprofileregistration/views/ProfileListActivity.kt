package com.example.userprofileregistration.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration.Adapter.ProfileAdapter
import com.example.userprofileregistration.R
import com.example.userprofileregistration.viewModel.UserProfileViewModel

class ProfileListActivity : AppCompatActivity() {

    private  lateinit var  profileViewHolder: UserProfileViewModel
    private  lateinit var  profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list)
    profileViewHolder =  ViewModelProvider(this).get(UserProfileViewModel::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView))

    }
}