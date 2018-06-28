package com.example.tim.androidshowcase.CardIO

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tim.androidshowcase.R
import io.card.payment.CardIOActivity
import io.card.payment.CreditCard
import kotlinx.android.synthetic.main.activity_card_io.*
import kotlinx.android.synthetic.main.default_toolbar.*

class CardIoActivity : AppCompatActivity() {

    companion object {
        const val SCAN_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_io)
        setSupportActionBar(toolbarCardIo)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_card_io, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.id_menu_item_card_io_camera -> {
                startCardIoActivity()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startCardIoActivity() {
        val scanIntent = Intent(this, CardIOActivity::class.java)
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true)
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false)
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false)
        startActivityForResult(scanIntent, SCAN_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null)
            return

        when (requestCode) {
             SCAN_REQUEST_CODE -> {
                val creditCard: CreditCard = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT)
                textViewCreditCardNumber.text = creditCard.cardNumber
            }
            else -> {
                // default, do nothing
            }
        }
    }
}
