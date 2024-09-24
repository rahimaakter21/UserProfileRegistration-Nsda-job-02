package com.example.userprofileregistration.views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Adapter.ProfileAdapter
import com.example.userprofileregistration.Models.UserProfile
import com.example.userprofileregistration.R
import com.example.userprofileregistration.viewModel.UserProfileViewModel

class AddProfileActivity : AppCompatActivity() {
    private  lateinit var   profileViewModel: UserProfileViewModel
    private  lateinit var  nameTxt:EditText
    private  lateinit var  emailTxt:EditText
    private  lateinit var  dobTxt:EditText
    private  lateinit var  districtTxt:EditText
    private  lateinit var  mobileTxt:EditText
    private  lateinit var  saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

         nameTxt = findViewById(R.id.profileNameEt)
         emailTxt = findViewById(R.id.emailEt)
         dobTxt = findViewById(R.id.dobEt)
         districtTxt = findViewById(R.id.districtEt)
         mobileTxt = findViewById(R.id.mobileEt)

        saveBtn = findViewById(R.id.addBtn)
         saveBtn.setOnClickListener{

             val name = nameTxt.text.toString().trim()
             val email = emailTxt.text.toString().trim()
             val dob = dobTxt.text.toString().trim()
             val district = districtTxt.text.toString().trim()
             val mobile = mobileTxt.text.toString().trim()
              val userProfile = UserProfile(name = name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.insertUserProfile(userProfile)
             finish()
         }
    }
}