package com.dapurkreatorindonesia.hollandvillage.room

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dapurkreatorindonesia.hollandvillage.R
import kotlinx.android.synthetic.main.activity_main.*

class HowToUseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howtouse)

        btnFindLocation.setOnClickListener {
            startActivity(
                Intent(this, RoomActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }

    }
}