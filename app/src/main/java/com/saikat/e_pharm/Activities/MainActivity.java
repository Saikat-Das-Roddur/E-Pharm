package com.saikat.e_pharm.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.saikat.e_pharm.Adapters.ViewPagerAdapter;
import com.saikat.e_pharm.CustomViews.CustomBottomNavigationView;
import com.saikat.e_pharm.Fragments.AccountFragment;
import com.saikat.e_pharm.Fragments.HomeFragment;
import com.saikat.e_pharm.Fragments.UserOrdersFragment;
import com.saikat.e_pharm.R;

public class MainActivity extends AppCompatActivity {

    String TAG = getClass().getSimpleName();

    FloatingActionButton floatingActionButtonAddProduct;

    ViewPager viewPager;
    CustomBottomNavigationView curvedBottomNavigationView;
    ViewPagerAdapter viewPagerAdapter;
    public Drawer drawer;

    public  int preItem = 0,i=1;

    public HomeFragment homeFragment;
    public UserOrdersFragment userOrdersFragment;
    public AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        floatingActionButtonAddProduct = findViewById(R.id.productFab);
        curvedBottomNavigationView = findViewById(R.id.customBottomBar);
        curvedBottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        homeFragment = new HomeFragment();
        userOrdersFragment = new UserOrdersFragment();
        accountFragment = new AccountFragment();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(homeFragment);
        viewPagerAdapter.addFragments(userOrdersFragment);
        viewPagerAdapter.addFragments(accountFragment);
        addDrawerComponent();
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);

                if (position>1) {
                        curvedBottomNavigationView.getMenu().getItem(position+1).setChecked(true);
                    }
                    else {
                        curvedBottomNavigationView.getMenu().getItem(position).setChecked(true);
                    }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged: "+ state);
            }
        });

    }

    private CustomBottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Log.d(TAG, "onNavigationItemSelected: " + menuItem.getOrder());


            if (menuItem.getOrder() > 2&&menuItem.getOrder()!=4) {
                preItem = menuItem.getOrder()-1;
                viewPager.setCurrentItem(preItem, true);
            } else if(menuItem.getOrder()<2) {
                preItem = menuItem.getOrder();
                viewPager.setCurrentItem(preItem, true);

            }else if (menuItem.getOrder()==4){
                drawerOpen();
            }

            else {
                floatingActionButtonAddProduct.performClick();
            }

            return true;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void addPrescription(View view) {
        startActivity(new Intent(MainActivity.this,AddDrugActivity.class));
        finish();
    }

    public void addDrawerComponent(){
            drawer = new DrawerBuilder()
                    .withActivity(this).addDrawerItems(
                            new PrimaryDrawerItem().withName(R.string.menu_items).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.home).withIcon(R.drawable.ic_home_circle_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.cart).withIcon(R.drawable.ic_cart_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.add_prescription).withIcon(R.drawable.ic_plus_thick_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++),
                            new PrimaryDrawerItem().withName(R.string.others).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.settings).withIcon(R.drawable.ic_settings_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.support).withIcon(R.drawable.ic_chat_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++),
                            new SecondaryDrawerItem().withName(R.string.log_out).withIcon(R.drawable.ic_logout_white_48dp).withIconTintingEnabled(true).withIconColorRes(R.color.primary).withIdentifier(i++)
                            )
                    .withHeader(R.layout.header)
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            Toast.makeText(MainActivity.this, "Drawer position " + position, Toast.LENGTH_SHORT).show();
                            if (position >= 2 && position <5) {
                                goToPositionedItem(position);
                            } else if (position == 6) {
                                goToPositionedItem(position);
                                drawer.closeDrawer();
                            } else if (position == 7) {
                                startActivity(new Intent(MainActivity.this, SupportActivity.class));
                                drawer.closeDrawer();
                            }
                            return true;
                        }
                    })
                    .build();

    }

    public void goToPositionedItem(int position){
        if (position==4){
            floatingActionButtonAddProduct.performClick();

        }else {
            preItem = position-2;
            curvedBottomNavigationView.getMenu().getItem(preItem).setCheckable(true);
            viewPager.setCurrentItem(preItem, true);
        }

        drawer.closeDrawer();
    }

    public void drawerOpen(){
        drawer.openDrawer();
    }
    public void setViewPagerPosition(int position){
        preItem = position;
        viewPager.setCurrentItem(preItem,true);
    }

}
