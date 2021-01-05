package com.hanseltritama.mergeadapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.entity_news.view.*
import java.lang.Exception
import java.net.URL

class CustomAdapter(val context: Context, val news: List<EntityNews>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.entity_news, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        val newsAtIndexPosition = news[position]
        holder.setData(newsAtIndexPosition)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(news: EntityNews) {
            itemView.tv_country.text = news.country
            itemView.tv_headlines.text = news.headlines

            try {
                val imageUrl: URL = URL(news.thumb)
                Log.d("image_url", imageUrl + "") // check whether the URL works or not
                val options: RequestOptions = RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                Glide.with(context).load(imageUrl).apply(options).into(itemView.img_thumb)
            } catch (e: Exception) {
                Log.d("error", e+"")
            }
        }
    }

}