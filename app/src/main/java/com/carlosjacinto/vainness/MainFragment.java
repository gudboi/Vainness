package com.carlosjacinto.vainness;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainFragment extends ListFragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, VainData.Headlines);

        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (getActivity().findViewById(R.id.fragment_container) != null){
            /*Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait."
                    + NewsData.Headlines[position], Toast.LENGTH_SHORT).show();*/
            // Create fragment and give it an argument specifying the article it should show
            HeroesFragment newFragment = new HeroesFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        } else{
            /*Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape."
                    + NewsData.Headlines[position], Toast.LENGTH_SHORT).show();*/
            TextView article = (TextView) getActivity().findViewById(R.id.article_text);
            article.setText(VainData.Articles[position]);
        }
    }
}
