package com.example.blablablabla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var nomeri: EditText
    private lateinit var sms: EditText
    private lateinit var paroli: EditText
    private lateinit var paroli2: EditText
    private lateinit var reset: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nomeri = findViewById(R.id.nomeri)
        sms = findViewById(R.id.sms)
        paroli = findViewById(R.id.paroli)
        paroli2 = findViewById(R.id.paroli2)
        reset = findViewById(R.id.reset)

        reset.setOnClickListener {

            val phone = nomeri.text.toString().trim()
            val code = sms.text.toString().trim()
            val password = paroli.text.toString().trim()
            val password2 = paroli2.text.toString().trim()


            if (phone.isEmpty()) {
                nomeri.error = "გთხოვთ შეიყვანეთ ტელეფონის ნომერი"
                return@setOnClickListener
            } else if (phone.length != 9) {
                nomeri.error = "ტელეფონის ნომერი უნდა შედგებოდეს 9 ციფრისაგან"
                return@setOnClickListener
            }  else if (!phone.startsWith("5")) {
                nomeri.error = "ნომერი უნდა იწყებოდეს 5-ით"
                return@setOnClickListener
            } else if (phone.contains("[a-z]".toRegex())){
                nomeri.error = "ნომერი არასწორია"
                return@setOnClickListener
            } else if (phone.contains("[A-Z]".toRegex())){
                nomeri.error = "ნომერი არასწორია"
                return@setOnClickListener
            } else if (code.isEmpty()) {
                sms.error = "გთხოვთ შეიყვანეთ SMS Code"
                return@setOnClickListener
            } else if (code.length != 4) {
                sms.error = "SMS Code უნდა შედგებოდის 4 ციფრისაგან"
                return@setOnClickListener
            } else if (password.isEmpty()) {
                paroli.error = "გთხოვთ შეიყვანეთ პაროლი"
                return@setOnClickListener
            } else if (password2.isEmpty()) {
                paroli.error = "გთხოვთ შეიყვანეთ პაროლი"
                return@setOnClickListener
            } else if(password != password2) {
                Toast.makeText(this, "პაროლები არ ემთხვევა ერთმანეთს", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "შეამოწმე E-mail", Toast.LENGTH_SHORT).show()
            }



        }

    }
}