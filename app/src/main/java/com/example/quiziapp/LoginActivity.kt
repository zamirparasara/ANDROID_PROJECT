package com.example.quiziapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            loginUser()
        }

        loginSignUpText.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginUser() {
        val email: String = loginEmailAddress.text.toString()
        val password: String = loginPassword.text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Blank Email or Password", Toast.LENGTH_SHORT).show()
            return
        }
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error Occured !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}