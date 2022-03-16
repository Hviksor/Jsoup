package com.example.jsoup

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsoup.databinding.ItemLayoutBinding

class RVAdapter : RecyclerView.Adapter<RVAdapter.RVViewHolder>() {
    private val listAD = ArrayList<ItemClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return RVViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        val item = listAD[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return listAD.size
    }

    class RVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemLayoutBinding.bind(itemView)
        fun setData(item: ItemClass) = with(binding) {
            itemCourse.text=item.data_1
            itemCourseAVG.text=item.data_2
            itemNbu.text=item.data_3
            itemBlack.text=item.data_4

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: ArrayList<ItemClass>) {
        listAD.clear()
        listAD.addAll(newList)
        notifyDataSetChanged()


    }
}