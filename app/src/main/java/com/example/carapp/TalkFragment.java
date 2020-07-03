package com.example.carapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.Top_Publish.Edit;
import com.example.toptab.Notify;
import com.example.toptab.topFragment1;
import com.example.toptab.topFragment2;
import com.example.toptab.topFragment3;
import com.example.toptab.topFragment4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * 我想知道的碎片页面
 * @author wwj_748
 *
 */
public class TalkFragment extends Fragment {
    static final int NUM_ITEMS = 4;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TabLayout tab_layout;
    private ViewPager viewPager;
    private Button notify;
    private Button edit;
    MyAdapter fragmentAdater;
    /*private topMyFragmentPagerAdapter fragmentAdater;*/
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

    public class MyAdapter extends FragmentPagerAdapter {
        private String[] strings = new String[]{"推荐","资讯","问答","分享"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        /*public Fragment getItem(int position) {
            if (position == 1) {
                return new topFragment2();
            } else if (position == 2) {
                return new topFragment3();
            }else if (position==3){
                return new topFragment4();
            }
            return new topFragment1();
        }*/
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Nullable
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.main_tab2_fragment, container,
				false);
        /*//使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) view.findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new topMyFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);
        four.setIcon(R.mipmap.ic_launcher);*/
        fragmentList.add(new topFragment1());
        fragmentList.add(new topFragment2());
        fragmentList.add(new topFragment3());
        fragmentList.add(new topFragment4());
        tab_layout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.viewPager);
        fragmentAdater = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentAdater);
        tab_layout.setupWithViewPager(viewPager);
        /*one = tab_layout.getTabAt(0);
        two = tab_layout.getTabAt(1);
        three = tab_layout.getTabAt(2);
        four = tab_layout.getTabAt(3);
        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);
        four.setIcon(R.mipmap.ic_launcher);*/
		return view;
	}
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        notify = (Button) getActivity().findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Notify.class);
                startActivity(intent);
            }
        });
        edit = (Button) getActivity().findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Edit.class);
                startActivity(intent);
            }
        });

        /*loginname = (TextView) getActivity().findViewById(R.id.loginname);
        loginname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });*/
    }
}