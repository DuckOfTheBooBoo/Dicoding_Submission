package com.arajdianaltaf.dicodingsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMemberAdapter(private val listMember: ArrayList<Member>): RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_member_name)
//        var tvDetail: TextView = itemView.findViewById(R.id.tv_member)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_member_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_member, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val member = listMember[position]

        Glide.with(holder.itemView.context)
            .load(member.photo)
            .apply(RequestOptions().fitCenter())
            .into(holder.imgPhoto)

        holder.tvName.text = member.name

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMember[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listMember.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Member)
    }

}