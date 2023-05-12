package com.example.maddesign.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maddesign.R
import com.example.maddesign.model.FertilizerModel

class FertilizerAdapter (private val empList:ArrayList<FertilizerModel>):
    RecyclerView.Adapter<FertilizerAdapter.ViewHolder>(){

    /////retrive to editor mode
    private lateinit var mListner : onItemClickLisner

    interface onItemClickLisner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(clickListner : onItemClickLisner) {
        mListner = clickListner
    }

    ///////sent and get data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_fertilizer_list_items,parent,false)
        return ViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFer = empList[position]
        holder.tvFertileName.text = currentFer.fertileName
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView:View,clickListener: onItemClickLisner) : RecyclerView.ViewHolder(itemView) {
        val tvFertileName :TextView = itemView.findViewById(R.id.tvFertileName)

        init {
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }


    }

}