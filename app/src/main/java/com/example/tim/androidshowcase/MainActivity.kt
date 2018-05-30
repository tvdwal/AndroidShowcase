package com.example.tim.androidshowcase

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.example.tim.androidshowcase.Fragments.FragmentsActivity
import com.example.tim.androidshowcase.REST.RestClientActivity
import com.example.tim.androidshowcase.Realm.RealmActivity
import com.example.tim.androidshowcase.Recycler.RecyclerViewSharedElementActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.default_toolbar.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()
        setButtons()
        setLatestActivity()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.default_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when (item.itemId) {
            R.id.id_menu_item_account -> msg = item.toString()
            R.id.id_menu_item_android -> msg = item.toString()
            R.id.id_menu_item_delete -> msg = item.toString()
            R.id.id_menu_item_help -> msg = item.toString()
            R.id.id_menu_item_home -> msg = item.toString()
            R.id.id_menu_item_settings -> msg = item.toString()
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }

    private fun setToolbar() {
        setSupportActionBar(default_toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        default_toolbar.title = "Welcome"
        default_toolbar.subtitle = "Tim"
    }

    private fun setButtons() {
        btnRecyclerViewSharedElement.setOnClickListener { goToActivity(RecyclerViewSharedElementActivity::class.java) }
        btnRestClient.setOnClickListener { goToActivity(RestClientActivity::class.java) }
        btnFragments.setOnClickListener { goToActivity(FragmentsActivity::class.java) }
        btnViewModel.setOnClickListener { goToActivity(ViewModelActivity::class.java) }
        btnSharedPreferences.setOnClickListener { goToActivity(SharedPreferenceActivity::class.java) }
        btnRealm.setOnClickListener{ goToActivity(RealmActivity::class.java) }
    }

    private fun goToActivity(destinationActivity: Class<*>) {
        val i = Intent(this@MainActivity, destinationActivity)
        startActivity(i)
    }

    private fun setLatestActivity() {
        val sharedPreferences = getSharedPreferences(packageName + Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(Constants.LATEST_ACTIVITY, "MAIN_ACTIVITY")
        editor.apply()
    }

}
