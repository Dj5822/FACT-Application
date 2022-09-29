package com.example.factapplication.ui.choicepoint;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.factapplication.R;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    private AwayFragment awayFragment;
    private ChoiceFragment choiceFragment;
    private TowardsFragment towardsFragment;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        awayFragment = AwayFragment.newInstance();
        choiceFragment = ChoiceFragment.newInstance();
        towardsFragment = TowardsFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return awayFragment;
        }
        else if (position == 1) {
            return choiceFragment;
        }
        else {
            return towardsFragment;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    public void updateText() {
        awayFragment.updateText();
        choiceFragment.updateText();
        towardsFragment.updateText();

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}