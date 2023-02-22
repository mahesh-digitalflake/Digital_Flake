package com.example.digitalflake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var newUser:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        newUser=findViewById(R.id.newUser)

        var username=findViewById<EditText>(R.id.username)
        var password=findViewById<EditText>(R.id.password)
        var login=findViewById<Button>(R.id.login)

        //username.inputType(InputType.TYPE_CLASS_TEXT)


        newUser?.setOnClickListener {

            val intent=Intent(this,RegistrationActivity::class.java)
            startActivity(intent)

        }

        login.setOnClickListener {
            if(username.text.trim().isEmpty() && password.text.trim().isEmpty())
            {
                Toast.makeText(this ,"Please Fill Username And Password",Toast.LENGTH_LONG).show()
            }

            else if(username.text.isEmpty())
            {
                Toast.makeText(this ,"Please Enter Username",Toast.LENGTH_LONG).show()
            }

            else if(password.text.isEmpty())
            {
                Toast.makeText(this ,"Please Enter Password",Toast.LENGTH_LONG).show()
            }

            else{
              if(username.text.contentEquals(password.text))
                    {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                   }
                else {
                  Toast.makeText(this ,"Please Enter Valid Username and Password",Toast.LENGTH_LONG).show()

              }
            }

        }

    }
}