package com.rosa.a211androidh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpanButton = findViewById<Button>(R.id.simpanButton)
        val batalButton = findViewById<Button>(R.id.batalButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        val namaEditText = findViewById<EditText>(R.id.namaEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val noHandphoneEditText = findViewById<EditText>(R.id.noHandphoneEditText)
        val tanggalLahirEditText = findViewById<EditText>(R.id.tanggalLahirEditText)
        val jarakEditText = findViewById<EditText>(R.id.jarakEditText)

        simpanButton.setOnClickListener {
            val nama = namaEditText.text.toString()
            val email = emailEditText.text.toString()
            val noHandphone = noHandphoneEditText.text.toString()
            var jarak = jarakEditText.text.toString().toInt()
            jarak = jarak * 1000
            val tanggalLahir = tanggalLahirEditText.text.toString()


            Toast.makeText(this, "Hai $jarak",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HasilActivity::class.java)
            intent.putExtra("nama",nama)
            intent.putExtra("email",email)
            intent.putExtra("noHandphone",noHandphone)
            intent.putExtra("tanggalLahir",tanggalLahir)
            intent.putExtra("jarak",jarak)
            startActivity(intent)
        }

        batalButton.setOnClickListener {
            finish()
        }

        logoutButton.setOnClickListener {
            val sharedPreferences = this.getSharedPreferences("MY_SP", MODE_PRIVATE)

            with(sharedPreferences.edit()) {
                putString("username", "")
                putString("password", "")
                apply()
            }

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}