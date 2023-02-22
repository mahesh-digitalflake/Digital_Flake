package com.example.digitalflake

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    lateinit var preferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        var myName=findViewById<TextView>(R.id.myName)
//        var nameInput=findViewById<TextView>(R.id.nameInput)
//
//        var myUsername=findViewById<TextView>(R.id.myUsername)
//        var userNameInput=findViewById<TextView>(R.id.userNameInput)
//
//        var myPassword=findViewById<TextView>(R.id.myPassword)
//        var passwordInput=findViewById<TextView>(R.id.passwordInput)
        preferences=getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE)
        val name=preferences.getString("Name","")
        //nameInput.text=name

        val userName=preferences.getString("Username","")
        //userNameInput.text=userName

        val password=preferences.getString("Password","")
       // passwordInput.text=password

        val listView=findViewById<ListView>(R.id.listView)

        val teamName=ArrayList<String>()
        teamName.add("Mallikarjun")
        teamName.add("Parag Agrawal")
        teamName.add("Abhijit Kumar")
        teamName.add("Munendra Singh")
        teamName.add("Sanket Purohit")
        teamName.add("Sagar Kanake")
        teamName.add("Pallavi Tantarpale")
        teamName.add("Irfan Shaikh")
        teamName.add("Sanakalpa Bhoite")
        teamName.add("Kiran Kamble")
        teamName.add("Rushikesh Patil")
        teamName.add("Tukaram Waghmare")
        teamName.add("Hina Chauhan")
        teamName.add("Snehal Chavan")
        teamName.add("Gaurav Shelvate")
        teamName.add("Ujjwal Kumari")
        teamName.add("Neha Yadav")
        teamName.add("Shweta Chaudhari")
        teamName.add("Kirti Savita")
        teamName.add("Shubhangi Bansode")
        teamName.add("Pratap Ekorge")
        teamName.add("Pranay Chandale")
        teamName.add("Kapil Dongre")

    val arrayListAdapter:ArrayAdapter<String> =
        ArrayAdapter(this,android.R.layout.simple_list_item_1,teamName)

    listView.adapter=arrayListAdapter

    listView.setOnItemClickListener { adapterView, view, i, l ->
        Toast.makeText(this,"Item Selected:- "+teamName[i],Toast.LENGTH_LONG).show()
    }

    }
}