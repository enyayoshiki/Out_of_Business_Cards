package com.example.out_of_business_cards

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val company = pref.getString("company", "")
        val postal = pref.getString("postal", "")
        val address = pref.getString("address", "")
        val tel = pref.getString("tel", "")
        val fax = pref.getString("fax", "")
        val email = pref.getString("email", "")
        val url = pref.getString("url", "")
        val position = pref.getString("position", "")
        val name = pref.getString("name", "")

        companyText.text = company
        postalText.text = postal
        addressText.text = address
        telText.text = "tel:" + tel
        faxText.text = "fax:" + fax
        emailText.text = email
        urlText.text = url
        positionText.text = position
        nameText.text = name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.edit -> {
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
            }
            return super.onOptionsItemSelected(item) -> true
        }

    }
