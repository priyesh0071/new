package com.example.techchronicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class LogINActivity : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_inactivity)
        auth = FirebaseAuth.getInstance()
    }

    fun login(view: View) {
        val email = editTextEmailAddress.text.toString()
        val password = editTextPassword.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }.addOnFailureListener {
            Toast.makeText(applicationContext,it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    fun goToRegister(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}