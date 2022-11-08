package com.arajdianaltaf.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMembers: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    private fun showSelectedMemberDetails(member: Member) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)

        detailIntent.putExtra(DetailActivity.EXTRA_DETAIL,  member.detail)
        detailIntent.putExtra(DetailActivity.EXTRA_NAME, member.name)
        detailIntent.putExtra(DetailActivity.EXTRA_BIRTH, member.birthdate)
        detailIntent.putExtra(DetailActivity.EXTRA_POS, member.position)
        detailIntent.putExtra(DetailActivity.EXTRA_PD48RANK, member.pd48Rank)
        detailIntent.putExtra(DetailActivity.EXTRA_INSTA, member.instagram)
        detailIntent.putExtra(DetailActivity.EXTRA_IMG, member.photo)

        startActivity(detailIntent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "IZ*ONE Wiki"

        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)

        list.addAll(MemberData.listData)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        aboutPage(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun aboutPage(aboutId: Int) {
        when (aboutId) {
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)

            }
        }
    }

    private fun showRecyclerList() {
        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(list)
        rvMembers.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallback(object: ListMemberAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Member) {
                showSelectedMemberDetails(data)
            }
        })

    }
}