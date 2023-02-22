package com.example.digitalflake

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import java.util.Objects

class RegistrationActivity : AppCompatActivity() {
    lateinit var sharedPreferences:SharedPreferences
    val gender= arrayOf("Male","Female","Other")
    var selectedGender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        sharedPreferences=getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE)

        val rdGroup=findViewById<RadioGroup>(R.id.radioGroup)

        var name=findViewById<EditText>(R.id.full_name)
        var username=findViewById<EditText>(R.id.userName_new)
        var password=findViewById<EditText>(R.id.password_new)
        val spinner=findViewById<Spinner>(R.id.spinner)


        var radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        var radiobtn1=findViewById<RadioButton>(R.id.radiobtn1)
        var radiobtn2=findViewById<RadioButton>(R.id.radiobtn2)


        val signUp=findViewById<Button>(R.id.signUp)



        signUp.setOnClickListener {
            if(name.text.trim().isEmpty() && username.text.trim().isEmpty() && password.text.trim().isEmpty() && radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(this,"Please Enter All Details",Toast.LENGTH_LONG).show()
            }
            else if(name.text.trim().isEmpty())
            {
                Toast.makeText(this,"Please Enter Name",Toast.LENGTH_LONG).show()
            }

            else if(username.text.trim().isEmpty())
            {
                Toast.makeText(this,"Please Enter Username",Toast.LENGTH_LONG).show()
            }

            else if(password.text.trim().isEmpty())
            {
                Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show()
            }


             else if(!radiobtn1.isChecked && !radiobtn2.isChecked)
            {
                Toast.makeText(this,"Please Select Nationality",Toast.LENGTH_LONG).show()
            }

             else {
                 if(username.text.contentEquals(password.text)  )
                 { val editor:SharedPreferences.Editor=sharedPreferences.edit()
                     selectedGender = spinner.selectedItem.toString()
                     editor.putString("Name", name.text.toString())
                     editor.putString("Username", username.text.toString())
                     editor.putString("Password",password.text.toString())

                     editor.apply()
//        editor.putString("RadioBtn1", radiobtn1.toString())
//        editor.putString("RadioBtn2",radiobtn2.toString())

                     Log.d("1111","selected gender "+selectedGender)

                     val intent = Intent(this, HomeActivity::class.java)
                     startActivity(intent)
                 }
                 else {
                     Toast.makeText(this ,"Please Enter Valid Username and Password",Toast.LENGTH_LONG).show()

                 }
            }

        }
        username.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                password.setText(p0)
            }

        })






        val arrayAdapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,gender)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedGender = gender[p2]
                //Toast.makeText(applicationContext,"Selected Gender ="+gender[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



    }
}