package ar.reloadersystem.tabsswipebottom.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.reloadersystem.tabsswipebottom.Adapters.FragmentPageAdapter;
import ar.reloadersystem.tabsswipebottom.R;

/**
 * Created by Reloader - Resembrink Correa.
 */
public class DeskWork1_Fragment extends Fragment {

    View rootview;

    FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;


    public DeskWork1_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_desk_work1, container, false);
        viewPager = rootview.findViewById(R.id.viewPager);
        tabLayout = rootview.findViewById(R.id.tabLayout);

        setAdapter();
        setTabLayout();

        return rootview;
    }

    private void setTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Para ti");
        tabLayout.getTabAt(1).setText("Listas de éxito");
        tabLayout.getTabAt(2).setText("Premium");
        tabLayout.getTabAt(3).setText("Categorias");

    }

    private void setAdapter() {
        fragmentPagerAdapter = new FragmentPageAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
    }
}
