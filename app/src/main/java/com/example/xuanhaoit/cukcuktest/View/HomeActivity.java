package com.example.xuanhaoit.cukcuktest.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.example.xuanhaoit.cukcuktest.Adapter.ViewPagerAdapter;
import com.example.xuanhaoit.cukcuktest.R;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

/**
 * Created by XuanHaoIT on 11/08/2017.
 */

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ViewPagerAdapter viewPagerAdapter;
    private AHBottomNavigation ahBottomNavigation;
    private AHBottomNavigationViewPager bottomNavigationViewPager;
    private AHBottomNavigationAdapter ahBottomNavigationAdapter;
    private CoordinatorLayout coordinatorLayout;
    int[] colors;
    int[] tabColorsDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    public void init() {
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationViewPager = findViewById(R.id.vPager);
        ahBottomNavigation = findViewById(R.id.bottom_bar);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        setSupportActionBar(toolbar);
        BottomBar();
    }

    public void BottomBar() {
//        setViewPager();
//        String [] colors = this.getResources().getStringArray(R.array.default_preview);
//        ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
//        models.add(new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.ic_event_note_black_24dp), Color.parseColor(colors[0]))
//                .title(getResources().getString(R.string.order)).badgeTitle("1").build());
//
//        models.add(new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.ic_view_carousel_black_24dp), Color.parseColor(colors[1]))
//                .title(getResources().getString(R.string.so_do)).badgeTitle("2").build());
//
//        models.add(new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.ic_room_service_white_24dp), Color.parseColor(colors[2]))
//                .title(getResources().getString(R.string.tra_mon)).badgeTitle("3").build());
//
////        models.add(new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.ic_note_black_24dp), Color.parseColor(colors[3]))
////                .title(getResources().getString(R.string.tam_tinh)).badgeTitle("4").build());
////
////        models.add(new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.ic_list_black_24dp), Color.parseColor(colors[4]))
////                .title(getResources().getString(R.string.tien_ich)).badgeTitle("5").build());
//
//        bottomNavigation.setModels(models);
//        bottomNavigation.setViewPager(viewPager,0);
////        bottomNavigation.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
////            @Override
////            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////
////            }
////
////            @Override
////            public void onPageSelected(int position) {
////                bottomNavigation.getModels().get(position).hideBadge();
////            }
////
////            @Override
////            public void onPageScrollStateChanged(int state) {
//
////            }
////        });
////        bottomNavigation.setBehaviorEnabled(true);
////        bottomNavigation.setIsSwiped(true);
////        bottomNavigation.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
////            @Override
////            public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {
////            }
////
////            @Override
////            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
////                model.hideBadge();
////            }
////        });
//        bottomNavigation.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < bottomNavigation.getModels().size(); i++) {
//                    final NavigationTabBar.Model model = bottomNavigation.getModels().get(i);
//                    bottomNavigation.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            model.showBadge();
//                        }
//                    }, i * 100);
//                }
//            }
//        }, 500);
////        bottomNavigation.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
////            @Override
////            public void onStartTabSelected(NavigationTabBar.Model model, int index) {
////
////            }
////
////            @Override
////            public void onEndTabSelected(NavigationTabBar.Model model, int index) {
////
////            }
////
////    });

        colors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        tabColorsDark = getApplicationContext().getResources().getIntArray(R.array.tab_colors_dark);

        ahBottomNavigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation);
        ahBottomNavigationAdapter.setupWithBottomNavigation(ahBottomNavigation, colors);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        bottomNavigationViewPager.setAdapter(viewPagerAdapter);
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                bottomNavigationViewPager.setCurrentItem(position, false);
                updateToolbar(position);
                return true;
            }
        });
//        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.order, R.drawable.ic_event_note_black_24dp, R.color.tab_1);
//        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.so_do, R.drawable.ic_view_carousel_black_24dp, R.color.tab_2);
//        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tra_mon, R.drawable.ic_room_service_white_24dp, R.color.tab_3);
//        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tam_tinh, R.drawable.ic_note_black_24dp, R.color.tab_4);

//        arr.add(item1);
//        arr.add(item2);
//        arr.add(item3);
//        arr.add(item4);
//
//        ahBottomNavigation.addItems(arr);

        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        ahBottomNavigation.setBehaviorTranslationEnabled(false);
        ahBottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        ahBottomNavigation.setForceTint(true);
        ahBottomNavigation.setColored(true);
        ahBottomNavigation.setTranslucentNavigationEnabled(true);


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        bottomNavigationViewPager.setAdapter(viewPagerAdapter);


    }

    //    public void setViewPager()
//    {
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(viewPagerAdapter);
//    }
    void updateToolbar(int position) {
        switch (position) {
            case 0:
                toolbar.setTitle(R.string.order);
                break;
            case 1:
                toolbar.setTitle(R.string.so_do);
                break;
            case 2:
                toolbar.setTitle(R.string.tra_mon);
                break;
            case 3:
                toolbar.setTitle(R.string.tam_tinh);
                break;
            default:
                toolbar.setTitle(R.string.order);
                break;
        }
        toolbar.setBackgroundColor(colors[position]);
        getWindow().setStatusBarColor(tabColorsDark[position]);
    }
}