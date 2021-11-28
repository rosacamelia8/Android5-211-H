package com.rosa.a211androidh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val keluarButton = findViewById<Button>(R.id.keluarButton)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)


        loginButton.setOnClickListener {
            val username = "rosa@uniska-bjm.ac.id"
            val password = "rosa123"

            val usernameInput = usernameEditText.text.toString()
            val passwordInput = passwordEditText.text.toString()

            if(usernameInput == username && passwordInput == password){

                val sharedPreferences = this.getSharedPreferences("MY_SP", MODE_PRIVATE)

                with(sharedPreferences.edit()) {
                    putString("username", usernameInput)
                    putString("password", passwordInput)
                    apply()
                }


                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Username/Password Salah",Toast.LENGTH_SHORT).show()
            }
        }

        keluarButton.setOnClickListener {
            finish()
        }
    }
}