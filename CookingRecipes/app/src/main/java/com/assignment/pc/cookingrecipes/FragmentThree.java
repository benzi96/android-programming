package com.assignment.pc.cookingrecipes;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentThree extends ListFragment {
    private static final String[] CATEGORIES = { "Desserts", "Low carb",
            "Chinese", "French toasts", "Appetizers", "Salads", "Pork", "Soup" };
    private static final String TAG = "Lab-Fragments";

    public interface SelectionListener {
        public void onItemSelected(int position);
    }

    private SelectionListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // use different layout definition, depending on whether device is pre-
        // or post-honeycomb

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.layout.simple_list_item_activated_1
                : android.R.layout.simple_list_item_1;

        // Set the list adapter for this ListFragment
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, CATEGORIES));
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            mCallback = (SelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SelectionListener");
        }
    }

    // Note: ListFragments come with a default onCreateView() method.
    // For other Fragments you'll normally implement this method.
    // 	@Override
    //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //		Bundle savedInstanceState)


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "Entered onActivityCreated()");
    }

    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {

        // Notify the hosting Activity that a selection has been made.

        mCallback.onItemSelected(position);

    }
}
