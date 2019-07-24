package com.dapurkreatorindonesia.hollandvillage.facilities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.dapurkreatorindonesia.hollandvillage.AboutActivity
import com.dapurkreatorindonesia.hollandvillage.MainActivity
import com.dapurkreatorindonesia.hollandvillage.R
import kotlinx.android.synthetic.main.activity_facility.*

class FacilityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility)

        imgBtnBasketAR.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        imgBtnFutsalAR.setOnClickListener {
            val intent = Intent(this, FutsalActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        imgBtnVollyAR.setOnClickListener {
            val intent = Intent(this, VollyActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }

    //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // actions on click menu items
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
            }

            R.id.action_home -> {
                startActivity(Intent(this, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
            }
        }
        return false
    }

}