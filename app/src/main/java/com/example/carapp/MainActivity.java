package com.example.carapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    // 三个tab布局
    private RelativeLayout knowLayout, iWantKnowLayout, meLayout, serviceLayout, mineLayout;

    // 底部标签切换的Fragment
    private Fragment knowFragment, iWantKnowFragment, meFragment, serviceFragment,mineFragment,
            currentFragment;
    // 底部标签图片
    private ImageView knowImg, iWantKnowImg, meImg, serviceImg, mineImg;
    // 底部标签的文本
    private TextView knowTv, iWantKnowTv, meTv, serviceTv, mineTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initTab();
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        knowLayout = (RelativeLayout) findViewById(R.id.rl_know);
        iWantKnowLayout = (RelativeLayout) findViewById(R.id.rl_want_know);
        meLayout = (RelativeLayout) findViewById(R.id.rl_me);
        serviceLayout = (RelativeLayout) findViewById(R.id.rl_service);
        mineLayout = (RelativeLayout) findViewById(R.id.rl_mine);

        knowLayout.setOnClickListener(this);
        iWantKnowLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);
        serviceLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);

        knowImg = (ImageView) findViewById(R.id.iv_know);
        iWantKnowImg = (ImageView) findViewById(R.id.iv_i_want_know);
        meImg = (ImageView) findViewById(R.id.iv_me);
        serviceImg = (ImageView) findViewById(R.id.iv_service);
        mineImg = (ImageView) findViewById(R.id.iv_mine);

        knowTv = (TextView) findViewById(R.id.tv_know);
        iWantKnowTv = (TextView) findViewById(R.id.tv_i_want_know);
        meTv = (TextView) findViewById(R.id.tv_me);
        serviceTv = (TextView) findViewById(R.id.tv_service);
        mineTv = (TextView) findViewById(R.id.tv_mine);

    }

    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (knowFragment == null) {
            knowFragment = new HomeFragment();
        }

        if (!knowFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, knowFragment).commit();

            // 记录当前Fragment
            currentFragment = knowFragment;
            // 设置图片文本的变化
            knowImg.setImageResource(R.mipmap.btn_know_pre);
            knowTv.setTextColor(getResources()
                    .getColor(R.color.bottomtab_press));
            iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_nor);
            iWantKnowTv.setTextColor(getResources().getColor(
                    R.color.bottomtab_normal));
            meImg.setImageResource(R.mipmap.btn_my_nor);
            meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

            serviceImg.setImageResource(R.mipmap.btn_my_nor);
            serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
            mineImg.setImageResource(R.mipmap.btn_my_nor);
            mineTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_know: // 知道
                clickTab1Layout();
                break;
            case R.id.rl_want_know: // 我想知道
                clickTab2Layout();
                break;
            case R.id.rl_me: // 我的
                clickTab3Layout();
                break;
            case R.id.rl_service: // 我的
                clickTab4Layout();
                break;
            case R.id.rl_mine: // 我的
                clickTab5Layout();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void clickTab1Layout() {
        if (knowFragment == null) {
            knowFragment = new HomeFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), knowFragment);

        // 设置底部tab变化
        knowImg.setImageResource(R.mipmap.btn_know_pre);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
        iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.mipmap.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        serviceImg.setImageResource(R.mipmap.btn_my_nor);
        serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        mineImg.setImageResource(R.mipmap.btn_my_nor);
        mineTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
    }

    /**
     * 点击第二个tab
     */
    private void clickTab2Layout() {
        if (iWantKnowFragment == null) {
            iWantKnowFragment = new TalkFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), iWantKnowFragment);

        knowImg.setImageResource(R.mipmap.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_pre);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_press));
        meImg.setImageResource(R.mipmap.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        serviceImg.setImageResource(R.mipmap.btn_my_nor);
        serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        mineImg.setImageResource(R.mipmap.btn_my_nor);
        mineTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    /**
     * 点击第三个tab
     */
    private void clickTab3Layout() {
        if (meFragment == null) {
            meFragment = new CarFragment();
        }

        addOrShowFragment(getSupportFragmentManager().beginTransaction(), meFragment);
        knowImg.setImageResource(R.mipmap.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.mipmap.btn_my_pre);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_press));

        serviceImg.setImageResource(R.mipmap.btn_my_nor);
        serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        mineImg.setImageResource(R.mipmap.btn_my_nor);
        mineTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    private void clickTab4Layout() {
        if (serviceFragment == null) {
            serviceFragment = new ServiceFragment();
        }

        addOrShowFragment(getSupportFragmentManager().beginTransaction(), serviceFragment);
        knowImg.setImageResource(R.mipmap.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.mipmap.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        serviceImg.setImageResource(R.mipmap.btn_my_pre);
        serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
        mineImg.setImageResource(R.mipmap.btn_my_nor);
        mineTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    private void clickTab5Layout() {
        if (mineFragment == null) {
            mineFragment = new MineFragment();
        }

        addOrShowFragment(getSupportFragmentManager().beginTransaction(), mineFragment);
        knowImg.setImageResource(R.mipmap.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.mipmap.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.mipmap.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        serviceImg.setImageResource(R.mipmap.btn_my_nor);
        serviceTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        mineImg.setImageResource(R.mipmap.btn_my_pre);
        mineTv.setTextColor(getResources().getColor(R.color.bottomtab_press));

    }

    /**
     * 添加或者显示碎片
     *
     * @param transaction
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction,
                                   Fragment fragment) {
        if (currentFragment == fragment)
            return;

        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }

        currentFragment = fragment;
    }

}
