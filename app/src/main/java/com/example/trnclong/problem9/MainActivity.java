package com.example.trnclong.problem9;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    PagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }
    private void addControls() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        final TabLayout.Tab Tab1 = tabLayout.newTab();
        final TabLayout.Tab Tab2 = tabLayout.newTab();
        final TabLayout.Tab Tab3 = tabLayout.newTab();

        View tab1 = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView tab1Image = tab1.findViewById(R.id.img_tab);
        TextView tab1Text = tab1.findViewById(R.id.txt_name_tab);
        tab1Image.setImageResource(R.drawable.ic_tab_around_selected);
        tab1Text.setText("Tab1");


        View tab2 = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView tab2Image = tab2.findViewById(R.id.img_tab);
        TextView tab2Text = tab2.findViewById(R.id.txt_name_tab);
        tab2Image.setImageResource(R.drawable.ic_tab_map);
        tab2Text.setText("Tab2");

        View tab3 = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView tab3Image = tab3.findViewById(R.id.img_tab);
        TextView tab3Text = tab3.findViewById(R.id.txt_name_tab);
        tab3Image.setImageResource(R.drawable.ic_tab_chat);
        tab3Text.setText("Tab3");



        Tab1.setCustomView(tab1Image);
        Tab2.setCustomView(tab2Image);
        Tab3.setCustomView(tab3Image);

        tabLayout.addTab(Tab1,0);
        tabLayout.addTab(Tab2,1);
        tabLayout.addTab(Tab3,2);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tab1Image.setImageResource(R.drawable.ic_tab_around_selected);
                        tab2Image.setImageResource(R.drawable.ic_tab_map);
                        tab3Image.setImageResource(R.drawable.ic_tab_chat);
                        break;
                    case 1:
                        tab1Image.setImageResource(R.drawable.ic_tab_around);
                        tab2Image.setImageResource(R.drawable.ic_tab_map_selected);
                        tab3Image.setImageResource(R.drawable.ic_tab_chat);
                        break;
                    case 2:
                        tab1Image.setImageResource(R.drawable.ic_tab_around);
                        tab2Image.setImageResource(R.drawable.ic_tab_map);
                        tab3Image.setImageResource(R.drawable.ic_tab_chat_selected);
                        break;
                    case 3:
                        tab1Image.setImageResource(R.drawable.ic_tab_around);
                        tab2Image.setImageResource(R.drawable.ic_tab_map);
                        tab3Image.setImageResource(R.drawable.ic_tab_chat);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}

