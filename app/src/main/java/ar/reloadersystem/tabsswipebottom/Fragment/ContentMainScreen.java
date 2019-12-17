package ar.reloadersystem.tabsswipebottom.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ar.reloadersystem.tabsswipebottom.R;
import ar.reloadersystem.tabsswipebottom.ViewPagerAdapter;

/**
 * Created by Reloader - Resembrink Correa.
 */
public class ContentMainScreen extends Fragment {

    View rootview;
    private BottomNavigationView bnv_mainIni;
    private ViewPager viewPager;
    MenuItem prevMenuItem;

    DeskWork1_Fragment deskWork1_fragment;
    DeskWork2_Fragment deskWork2_fragment;
    DeskWork3_Fragment deskWork3_fragment;
    DeskWork4_Fragment deskWork4_fragment;


    public ContentMainScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_mainscreen, container, false);

        viewPager = rootview.findViewById(R.id.vp_mainContent);
        bnv_mainIni = rootview.findViewById(R.id.bnv_mainIni);

        BottomNavigationView navigationView = rootview.findViewById(R.id.bnv_mainIni);
        Menu nav_Menu = navigationView.getMenu();


        nav_Menu.findItem(R.id.menu_item1).setTitle("Juegos");
        nav_Menu.findItem(R.id.menu_item1).setIcon(R.drawable.ic_stars);
        nav_Menu.findItem(R.id.menu_item2).setTitle("Apps");
        nav_Menu.findItem(R.id.menu_item2).setIcon(R.drawable.ic_slow_motion);
        nav_Menu.findItem(R.id.menu_item3).setTitle("Películas");
        nav_Menu.findItem(R.id.menu_item3).setIcon(R.drawable.ic_wallpaper);
        nav_Menu.findItem(R.id.menu_item4).setTitle("Libros");
        nav_Menu.findItem(R.id.menu_item4).setIcon(R.drawable.ic_watch);

        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);
//
        bnv_mainIni.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_item1:
                        viewPager.setCurrentItem(0);

                        return true;

                    case R.id.menu_item2:
                        viewPager.setCurrentItem(1);
                        return true;

                    case R.id.menu_item3:

                        viewPager.setCurrentItem(2);
                        return true;

                    case R.id.menu_item4:

                        viewPager.setCurrentItem(3);
                        return true;

                    default:
                        return false;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bnv_mainIni.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bnv_mainIni.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bnv_mainIni.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return rootview;
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        deskWork1_fragment = new DeskWork1_Fragment();
        deskWork2_fragment = new DeskWork2_Fragment();
        deskWork3_fragment = new DeskWork3_Fragment();
        deskWork4_fragment = new DeskWork4_Fragment();

        adapter.addFragment(deskWork1_fragment);
        adapter.addFragment(deskWork2_fragment);
        adapter.addFragment(deskWork3_fragment);
        adapter.addFragment(deskWork4_fragment);

        viewPager.setAdapter(adapter);
    }
}
