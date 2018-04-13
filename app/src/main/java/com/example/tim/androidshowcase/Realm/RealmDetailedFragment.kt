package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.ViewModelProviders
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import com.example.tim.androidshowcase.R
import kotlinx.android.synthetic.main.fragment_realm_item_detailed.*
import kotlinx.android.synthetic.main.fragment_realm_new_item.*
import kotlinx.android.synthetic.main.fragment_three.*

/**
 * Created by Tim on 23-3-2018.
 */

class RealmDetailedFragment : Fragment() {

    lateinit var realmViewModel: RealmViewModel

    companion object {
        val tag: String = "RealmDetailed"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_item_detailed, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        realmViewModel = ViewModelProviders.of(activity).get(RealmViewModel::class.java)
        var selectedPerson: Person = realmViewModel.getSelectedPerson()
        textViewRealmDetailedName.text = selectedPerson.name
        textViewRealmDetailedAge.text = selectedPerson.age.toString()
        textViewRealmDetailedProfession.text = selectedPerson.profession
        val starResource = if (selectedPerson.important) R.drawable.ic_stars_yellow_48dp else R.drawable.ic_stars_white_48dp
        imageViewRealmDetailedStar.setImageResource(starResource)
        imageViewRealmDetailedPhoto.setImageResource(R.drawable.ic_account_box_white_48dp)
        imageViewRealmDetailedPhoto.setOnClickListener {
            DummyTask(context).execute("")
        }
        imageViewRealmDetailedStar.setOnClickListener {
            selectedPerson.setImportance(!selectedPerson.important)
            val starResource = if (selectedPerson.important) R.drawable.ic_stars_yellow_48dp else R.drawable.ic_stars_white_48dp
            imageViewRealmDetailedStar.setImageResource(starResource)
        }
    }

}
