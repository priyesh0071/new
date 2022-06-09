package com.example.techchronicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Register"
        auth = FirebaseAuth.getInstance()
    }

    fun register(view: View) {
        val email = editTextEmailAddress.text.toString()
        val password = editTextPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()

            }
        }.addOnFailureListener {

            Toast.makeText(applicationContext,it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
    fun goToLogin(view: View) {
        val intent = Intent(this@RegisterActivity, LogINActivity::class.java)
        startActivity(intent)

    }
}