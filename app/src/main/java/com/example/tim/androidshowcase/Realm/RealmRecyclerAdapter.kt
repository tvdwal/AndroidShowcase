package com.example.tim.androidshowcase.Realm

import android.app.Fragment
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tim.androidshowcase.Fragments.FragmentHelper

import com.example.tim.androidshowcase.R

import java.util.ArrayList

/**
 * Created by Tim on 4-7-2017.
 */

class RealmRecyclerAdapter(val items: ArrayList<Person>, val fragmentManager: android.support.v4.app.FragmentManager) : RecyclerView.Adapter<RealmRecyclerAdapter.PersonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_realm_recycler_item, parent, false)
        return PersonHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person: Person = items[position]
        holder.textViewName?.text = person.name
        holder.textViewAgeProfession?.text = person.age.toString() + ", " + person.profession
        holder.imageViewPhoto?.setImageResource(R.drawable.ic_account_box_white_48dp)
        val starResource = if (person.important) R.drawable.ic_stars_yellow_48dp else R.drawable.ic_stars_white_48dp
        holder.imageViewStar?.setImageResource(starResource)
        holder.itemView.setOnClickListener {
            
            FragmentHelper.replaceFragment(fragmentManager, R.id.layoutRealmFragmentContainer, RealmDetailedFragment())
            /*sharedElementTransitionIntent.putExtra("source", person)
            val p1 = Pair.create(mImageView as View, "sharedElementTransitionImage")
            val p2 = Pair.create(mTextView1 as View, "sharedElementTransitionTitle")
            val p3 = Pair.create(mTextView2 as View, "sharedElementTransitionDescription")
            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity), p1, p2, p3)*/
        }
    }

    class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textViewName = itemView.findViewById(R.id.textViewRealmItemName) as? TextView
        val textViewAgeProfession = itemView.findViewById(R.id.textViewRealmItemAgeProfession) as? TextView
        val imageViewPhoto = itemView.findViewById(R.id.imageViewRealmItemPhoto) as? ImageView
        val imageViewStar = itemView.findViewById(R.id.imageViewRealmItemStar) as? ImageView

        override fun onClick(p0: View?) {

        }
    }
}
