package com.example.tim.androidshowcase.Realm

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
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

    var persons: ArrayList<Person> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_overview, container, false)

        return view
    }

    private fun fillArrayListWithPhotos() {
        persons.add(Person("Tim", 25, "CEO"))
        persons.add(Person("Tim2", 22, "CFO"))
        persons.add(Person("Tim3", 23, "CIO"))
        persons.add(Person("Tim4", 24, "COO"))
    }

    private fun initiateRecyclerView() {
        fillArrayListWithPhotos()

        recyclerViewRealm.layoutManager = LinearLayoutManager(activity)
        recyclerViewRealm.adapter = RealmRecyclerAdapter(persons)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fabRealm.setOnClickListener {
            FragmentHelper.replaceFragment(fragmentManager, R.id.layoutRealmFragmentContainer, RealmNewItemFragment())
        }
        initiateRecyclerView()
    }

}
