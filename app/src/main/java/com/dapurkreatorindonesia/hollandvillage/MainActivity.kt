package com.dapurkreatorindonesia.hollandvillage

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.dapurkreatorindonesia.hollandvillage.facilities.HowtoUseFacilitiesActivity
import com.dapurkreatorindonesia.hollandvillage.maps.MapsActivity
import com.dapurkreatorindonesia.hollandvillage.room.HowToUseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgBtnFacilities.setOnClickListener {
            startActivity(Intent(this, HowtoUseFacilitiesActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        imgBtnRoom.setOnClickListener {
            startActivity(Intent(this, HowToUseActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        btnFindLocation.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id -> this@MainActivity.finish() })
            .setNegativeButton("No", null)
            .show()
    }

}
