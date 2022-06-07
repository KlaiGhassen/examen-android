package com.example.exam

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class home : AppCompatActivity() {
    lateinit var rent: Button
    lateinit var profile: Button
    lateinit var favorite: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction().replace(R.id.flfragment, carsList()).commit()
        rent = findViewById(R.id.rent)
        profile = findViewById(R.id.profile)
        favorite = findViewById(R.id.favorites)
        rent.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flfragment, carsList()).commit()
        }
        profile.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.flfragment, profile()).commit()


        }
        favorite.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.flfragment, fav()).commit()


        }



}
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var mSharedPref: SharedPreferences
        when(item.itemId){

            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("logout")
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}