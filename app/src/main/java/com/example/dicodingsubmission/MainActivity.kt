package com.example.dicodingsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMembers: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    private fun showSelectedMember(member: Member) {
        Toast.makeText(this, "You clicked on " + member.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)

        list.addAll(MemberData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(list)
        rvMembers.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallback(object: ListMemberAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Member) {
                showSelectedMember(data)
            }
        })

    }
}