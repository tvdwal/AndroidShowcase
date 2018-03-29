package com.example.tim.androidshowcase.Realm

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tim.androidshowcase.Fragments.FragmentHelper
import com.example.tim.androidshowcase.R

import kotlinx.android.synthetic.main.fragment_realm_overview.*
/**
 * Created by Tim on 23-3-2018.
 */

class RealmOverviewFragment : Fragment() {

    companion object {
        val tag: String = "RealmOverview"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_overview, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fabRealm.setOnClickListener {
            FragmentHelper.replaceFragment(fragmentManager, R.id.layoutRealmFragmentContainer, RealmNewItemFragment())
        }
    }

}
