package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tim.androidshowcase.Fragments.FragmentHelper
import com.example.tim.androidshowcase.MyViewModel
import com.example.tim.androidshowcase.R
import kotlinx.android.synthetic.main.activity_viewmodel.*

import kotlinx.android.synthetic.main.fragment_realm_overview.*
/**
 * Created by Tim on 23-3-2018.
 */

class RealmOverviewFragment : Fragment() {

    companion object {
        val tag: String = "RealmOverview"
    }

    lateinit var realmViewModel: RealmViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_overview, container, false)

        return view
    }

    private fun initiateRecyclerView() {
        recyclerViewRealm.layoutManager = LinearLayoutManager(activity)
        recyclerViewRealm.adapter = RealmRecyclerAdapter(realmViewModel, this.fragmentManager, context)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        realmViewModel = ViewModelProviders.of(activity).get(RealmViewModel::class.java)
        realmViewModel.getPersonList().observe(this, Observer {
            initiateRecyclerView()
        })
        fabRealm.setOnClickListener {
            FragmentHelper.replaceFragment(fragmentManager, R.id.layoutRealmFragmentContainer, RealmNewItemFragment())
        }

        var handler = Handler()
        handler.postDelayed(Runnable {
            realmViewModel.addPerson(Person("Bob", 50, "Janitor"))
        }, 5000)

    }

}
