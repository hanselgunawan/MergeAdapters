package com.hanseltritama.mergeadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val newsList = arrayListOf<EntityNews>()
    private val reNewsList = arrayListOf<EntityNews>()
    private lateinit var customAdapter: CustomAdapter
    private lateinit var customAdapterRe: CustomAdapterRe
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        my_recycler_view.layoutManager = layoutManager

        prepareNews()
        prepareReNews()
        prepareMerge()
    }

    fun prepareNews() {
        newsList.add(EntityNews("https://i.imgur.com/jOh14Vd.jpg", "USA", "How International Students Can Practice English"))
        newsList.add(EntityNews("https://i.imgur.com/cNPbc1J.jpg", "India", "International Yoga Day Theme Of The Year"))
        newsList.add(EntityNews("https://i.imgur.com/uOmdgRT.jpg", "UK", "World Development Report the Age of Global Value Chains"))
        customAdapter = CustomAdapter(this, newsList)
    }

    fun prepareReNews() {
        reNewsList.add(EntityNews("https://i.imgur.com/GoodUfr.jpg", "Australia", "World Creativity and Innovation Day brings creativity"))
        reNewsList.add(EntityNews("https://i.imgur.com/9brUaNM.jpg", "Canada", "Various Interesting Ways To Make Money Online"))
        reNewsList.add(EntityNews("https://i.imgur.com/fX0CD7H.jpg", "South Africa", "Blind Photographer captures a world he can not see"))
        customAdapterRe = CustomAdapterRe(this, reNewsList)
    }

    fun prepareMerge() {
        val mergeAdapter: MergeAdapter = MergeAdapter(customAdapter, customAdapterRe)
        my_recycler_view.adapter = mergeAdapter
    }
}