package com.valsoft.cardiodiary.presentation.ui.diary;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.ui.diary.adapters.ViewPagerAdapter;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.DiaryViewModel;

public class DiaryFragment extends Fragment {

    private static Fragment sFragment;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private DiaryViewModel mViewModel;

    public static Fragment newInstance(){
        if (sFragment != null){
            return sFragment;
        }
        sFragment = new DiaryFragment();
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DiaryViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        mViewPager = view.findViewById(R.id.viewpager);
        mTabLayout = view.findViewById(R.id.tabCabinet);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Щоденник");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        mViewPagerAdapter.add(new PressureFragment());
        mViewPagerAdapter.add(new SymptomFragment());
        mViewPagerAdapter.add(new DailyControlFragment());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("ТИСК");
        mTabLayout.getTabAt(1).setText("СИМПТОМИ");
        mTabLayout.getTabAt(2).setText("ВІДЧУТТЯ");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
