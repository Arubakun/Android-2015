package com.example.ProjetAndroidESGI.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * Created by Alban on 06/01/2016.
 */
public class GridListAdapter extends ArrayAdapter {

    public GridListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        View listItem = new View(getContext());

        return listItem;
    }
}
