package com.example.tim.androidshowcase.Realm

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast

class DummyTask(context: Context): AsyncTask<String, String, String>() {

    var context: Context = context

    override fun onPreExecute() {
        super.onPreExecute()
        Toast.makeText(context, "Starting task", Toast.LENGTH_SHORT).show()
    }

    override fun doInBackground(vararg p0: String?): String {
        // do stuff
        return ""
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Toast.makeText(context, "Finished task", Toast.LENGTH_SHORT).show()
    }
}