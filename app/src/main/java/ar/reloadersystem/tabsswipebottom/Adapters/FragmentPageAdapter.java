package ar.reloadersystem.tabsswipebottom.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ar.reloadersystem.tabsswipebottom.SubDeskWork.SubDeskWork1_fragment;
import ar.reloadersystem.tabsswipebottom.SubDeskWork.SubDeskWork2_fragment;
import ar.reloadersystem.tabsswipebottom.SubDeskWork.SubDeskWork3_fragment;
import ar.reloadersystem.tabsswipebottom.SubDeskWork.SubDeskWork4_fragment;

public class FragmentPageAdapter extends FragmentPagerAdapter {

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new SubDeskWork1_fragment();

            case 1:
                return new SubDeskWork2_fragment();
            case 2:
                return new SubDeskWork3_fragment();
            case 3:
                return new SubDeskWork4_fragment();

        }
        return null;
    }


    @Override
    public int getCount() {
        return 4;
    }
}
