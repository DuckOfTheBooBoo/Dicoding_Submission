package com.arajdianaltaf.dicodingsubmission

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dicodingBtn: Button = findViewById(R.id.dicoding_user_btn)

        dicodingBtn.setOnClickListener(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.dicoding_user_btn -> {
                val dicodingLink = "https://www.dicoding.com/users/arajdianaltaf"

                val goToUrl = Intent(Intent.ACTION_VIEW)
                goToUrl.data = Uri.parse(dicodingLink)
                startActivity(goToUrl)
            }
        }
    }
}