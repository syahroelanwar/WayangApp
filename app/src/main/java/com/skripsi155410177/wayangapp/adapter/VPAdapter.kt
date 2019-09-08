package com.skripsi155410177.wayangapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.skripsi155410177.wayangapp.fragments.Fragment1
import com.skripsi155410177.wayangapp.fragments.Fragment2
import com.skripsi155410177.wayangapp.fragments.Fragment3
import com.skripsi155410177.wayangapp.fragments.Fragment4

class VPAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        Fragment1(),
        Fragment2(),
        Fragment3(),
        Fragment4()
    )
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
        //return 4 tab
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Bathara"
            1->"Resi"
            2->"Raja"
            else->"Perang"
        }
        //set tab tittle
    }
}