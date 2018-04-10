package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.ViewModelProviders
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

class RealmNewItemFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    companion object {
        val tag: String = "RealmNewItem"
    }

    lateinit var realmViewModel: RealmViewModel

    private fun editTextHasValue(editText: EditText): Boolean {
        if (editText.text.toString().trim().isNotBlank()) {
            editText.error = null
            return true
        }
        editText.error = "Empty value"
        return false
    }

    private fun checkFields(): Boolean {
        if (editTextHasValue(editTextRealmName) && editTextHasValue(editTextRealmAge) && editTextHasValue(editTextRealmProfession))
            return true
        return false
    }

    private fun savePersonToDatabase(person: Person) {
        realmViewModel.addPerson(person)
        fragmentManager.popBackStackImmediate()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_realm_new_item, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        realmViewModel = ViewModelProviders.of(activity).get(RealmViewModel::class.java)
        buttonSavePerson.setOnClickListener {
            if (checkFields()) {
                var person = Person(
                        editTextRealmName.text.toString(),
                        editTextRealmAge.text.toString().toInt(),
                        editTextRealmProfession.text.toString())
                savePersonToDatabase(person)
            }
        }

        seekBarRealmAge.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        editTextRealmAge.setText(progress.toString())
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        // do nothing
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        // do nothing
    }
}
