package com.example.tim.androidshowcase.Realm

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SeekBar
import com.example.tim.androidshowcase.R
import kotlinx.android.synthetic.main.fragment_realm_new_item.*

/**
 * Created by Tim on 23-3-2018.
 */

class RealmDetailedFragment : Fragment() {

    companion object {
        val tag: String = "RealmDetailed"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_item_detailed, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

    }

}
