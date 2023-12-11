package com.birzavitalvarez.horoscappbirza.ui.horoscope.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.birzavitalvarez.horoscappbirza.R
import com.birzavitalvarez.horoscappbirza.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList(),
                       private val onItemSelected:(HoroscopeInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list:List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }
}