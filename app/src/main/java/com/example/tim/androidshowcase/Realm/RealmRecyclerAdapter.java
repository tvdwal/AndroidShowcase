package com.example.tim.androidshowcase.Realm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tim.androidshowcase.Activities.RecycleViewDetailedActivity;
import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.Recycler.DataObject;

import java.util.ArrayList;

/**
 * Created by Tim on 4-7-2017.
 */

public class RealmRecyclerAdapter extends RecyclerView.Adapter<RealmRecyclerAdapter.PersonHolder> {

    ArrayList<Person> myPersons;

    public static class PersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewProfile;
        TextView textViewName;
        TextView textViewAgeProfession;
        Person person;

        public PersonHolder(View itemView) {
            super(itemView);

            imageViewProfile = itemView.findViewById(R.id.imageViewRealmItemPhoto);
            textViewName = itemView.findViewById(R.id.textViewRealmItemName);
            textViewAgeProfession = itemView.findViewById(R.id.textViewRealmItemAgeProfession);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            Intent sharedElementTransitionIntent = new Intent(context, RecycleViewDetailedActivity.class);
            sharedElementTransitionIntent.putExtra("source", person);
            Pair<View, String> p1 = Pair.create((View) imageViewProfile, "sharedElementTransitionImage");
            Pair<View, String> p2 = Pair.create((View) textViewName, "sharedElementTransitionTitle");
            Pair<View, String> p3 = Pair.create((View) textViewAgeProfession, "sharedElementTransitionDescription");
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, p1, p2, p3);
            context.startActivity(sharedElementTransitionIntent, optionsCompat.toBundle());
        }

        public void bindPerson(Person person) {
            this.person = person;
            imageViewProfile.setImageResource(R.drawable.ic_account_box_white_48dp);
            textViewName.setText(person.getName());
            textViewAgeProfession.setText(person.getAge() + ", " + person.getProfession());
        }
    }

    public RealmRecyclerAdapter(ArrayList<Person> persons) {
        myPersons = persons;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_realm_recycler_item, parent, false);
        return new PersonHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        Person person = myPersons.get(position);
        holder.bindPerson(person);
    }

    @Override
    public int getItemCount() {
        return myPersons.size();
    }
}
