package com.assignment.pc.cookingrecipes;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener
,FragmentTwo.OnFragmentInteractionListener,FragmentThree.SelectionListener{
    RecyclerView rc_lowcarb;
//    RcAdapter adapter;
    TabLayout tablayout;
    ViewPager viewpager;
    private static final String[] CATEGORIES = { "Desserts", "Low carb",
            "Chinese", "French toasts", "Appetizers", "Salads", "Pork", "Soup" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rc_lowcarb = (RecyclerView) findViewById(R.id.rc_lowcarb);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
//        new getXml().execute("http://www.food.com/rssapi.do?page_type=26&slug=chicken");


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(),"Meat & chicken");
        adapter.addFragment(new FragmentTwo(),"Seafood");
        adapter.addFragment(new FragmentThree(),"Categories");
        viewpager.setAdapter(adapter);
        // limit number of current page
        viewpager.setOffscreenPageLimit(3);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onItemSelected(int position) {
        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
        myIntent.putExtra("title", CATEGORIES[position]);
        MainActivity.this.startActivity(myIntent);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mFragments = new ArrayList<>();
        List<String> names = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
        public void addFragment(Fragment frag,String title){
            mFragments.add(frag);
            names.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return names.get(position);
        }
    }
}
