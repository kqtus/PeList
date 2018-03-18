package com.example.marek.pelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Marek on 18.03.2018.
 */

public class ProfileListAdapter extends ArrayAdapter<ProfileModel> {

    public ProfileListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ProfileListAdapter(Context context, int resource, List<ProfileModel> profiles) {
        super(context, resource, profiles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater li;
            li = LayoutInflater.from(getContext());
            view = li.inflate(R.layout.person_entry, null);
        }

        ProfileModel model = getItem(position);

        if (model != null) {
            TextView nameTextView = view.findViewById(R.id.name);
            TextView ageTextView = view.findViewById(R.id.age);

            if (nameTextView != null) {
                nameTextView.setText(model.getFullName());
            }

            if (ageTextView != null) {
                ageTextView.setText(model.getAge().toString());
            }
        }

        return view;
    }
}
