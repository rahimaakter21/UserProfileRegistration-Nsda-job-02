package com.example.userprofileregistration.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Models.UserProfile
import com.example.userprofileregistration.R
import com.example.userprofileregistration.viewModel.UserProfileViewModel

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var userProfile: UserProfile
    private lateinit var profileViewModel: UserProfileViewModel

    private lateinit var NameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var dobEt: EditText
    private lateinit var districtEt: EditText
    private lateinit var mobileEt: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_update_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        userProfile = intent.getSerializableExtra("USER_PROFILE") as UserProfile

        NameEt = findViewById(R.id.NameEt)
        emailEt = findViewById(R.id.emailEt)
        dobEt = findViewById(R.id.dobEt)
        districtEt = findViewById(R.id.districtEt)
        mobileEt = findViewById(R.id.mobileEt)


        populateFields()

        findViewById<Button>(R.id.updateBtn).setOnClickListener {
            updateUserProfile()
        }
    }
        private fun populateFields() {
            NameEt.setText(userProfile.name)
            emailEt.setText(userProfile.email)
            dobEt.setText(userProfile.dob)
            districtEt.setText(userProfile.district)
            mobileEt.setText(userProfile.mobile)
        }
        fun updateUserProfile() {

            val name = NameEt.text.toString().trim()
            val email = emailEt.text.toString().trim()
            val dob = dobEt.text.toString().trim()
            val district = districtEt.text.toString().trim()
            val mobile = mobileEt.text.toString().trim()

            val updateUserProfile = UserProfile(id= userProfile.id,name = name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.updateUserProfile(updateUserProfile)
            finish()
        }

    }

