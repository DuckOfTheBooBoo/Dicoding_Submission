package com.arajdianaltaf.dicodingsubmission

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private var instagramLink: String? = ""

    companion object {
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIRTH = "extra_birth"
        const val EXTRA_POS = "extra_pos"
        const val EXTRA_PD48RANK = "extra_pd48rank"
        const val EXTRA_INSTA = "extra_insta"
    }

//    TODO: Calculate age based on birth date and current date (https://stackoverflow.com/a/46038561/16899959), (https://stackoverflow.com/a/59609344/16899959)
    private fun getAge(dateString: String){
        val monthNum = mapOf(
            "Januari" to 1,
            "Februari" to 2,
            "Maret" to 3,
            "April" to 4,
            "Mei" to 5,
            "Juni" to 6,
            "Juli" to 7,
            "Agustus" to 8,
            "September" to 9,
            "Oktober" to 10,
            "November" to 11,
            "Desember" to 12
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgMember: ImageView = findViewById(R.id.detailAc_member_photo)
        val detMember: TextView = findViewById(R.id.detailAc_member_detail)
        val nameMember: TextView = findViewById(R.id.detailAc_member_name)
        val birthdateMember: TextView = findViewById(R.id.detailAc_member_birthdate)
        val positionMember: TextView = findViewById(R.id.detailAc_member_position)
        val pd48RankMember: TextView = findViewById(R.id.detailAc_member_pd48rank)
        val instaMemberBtn: Button = findViewById(R.id.detailAc_member_instagram)


        val bundle = intent.extras
        if (bundle != null) {
            val pict = bundle.getInt(EXTRA_IMG)
            imgMember.setImageResource(pict)
        }


        instagramLink = intent.getStringExtra(EXTRA_INSTA)
        val username = instagramLink?.replace("https://www.instagram.com/", "")?.replace("/", "")


        detMember.text = intent.getStringExtra(EXTRA_DETAIL)
        nameMember.text = intent.getStringExtra(EXTRA_NAME)
        birthdateMember.text = intent.getStringExtra(EXTRA_BIRTH)
        positionMember.text = intent.getStringExtra(EXTRA_POS)
        pd48RankMember.text = intent.getStringExtra(EXTRA_PD48RANK)
        "@${username}".also { instaMemberBtn.text = it }

        supportActionBar?.title = nameMember.text

//        Instagram Button
        instaMemberBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.detailAc_member_instagram -> {
                val url = instagramLink

                val goToUrl = Intent(Intent.ACTION_VIEW)
                goToUrl.data = Uri.parse(url)
                startActivity(goToUrl)

            }
        }

    }
}