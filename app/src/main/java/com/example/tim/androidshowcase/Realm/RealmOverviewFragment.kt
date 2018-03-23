package com.example.tim.androidshowcase.Realm

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tim.androidshowcase.R

/**
 * Created by Tim on 23-3-2018.
 */

class RealmOverviewFragment : Fragment() {

    companion object {
        val fab_icon = R.drawable.ic_home_white_48dp
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_overview, container, false)
        return view
    }

    fun getFabIcon(): Int {
        return fab_icon
    }

}
