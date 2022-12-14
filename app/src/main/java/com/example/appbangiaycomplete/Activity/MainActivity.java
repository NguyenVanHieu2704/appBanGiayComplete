package com.example.appbangiaycomplete.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appbangiaycomplete.R;
import com.example.appbangiaycomplete.fragment.HomeFragment;
import com.example.appbangiaycomplete.fragment.QuanLyDonHangFragment;
import com.example.appbangiaycomplete.fragment.QuanLyKhachHangFragment;
import com.example.appbangiaycomplete.fragment.QuanLySanPham;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_PRODUCT_MANAGER = 1;
    private static final int FRAGMENT_ODER_MANAGER = 2;
    private static final int FRAGMENT_CUSTOMER_MANAGER = 3;
    private int mcurrentFragment = FRAGMENT_HOME;
    //
//    Toolbar toolbar;
//    NavigationView navigationView;
//    DrawerLayout drawerLayout;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bat su kien click vao icon home o toolbar hien thi cac item
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navivgation_drawer_open, R.string.navivgation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //
        NavigationView navigationView = findViewById(R.id.navication_view);
        navigationView.setNavigationItemSelectedListener(this);
        //
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setCheckable(true);
//add fragment Quan ly khach hang
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.quan_ly_khach_hang, new QuanLyKhachHangFragment());
        fragmentTransaction.commit();

//        ActionBar();
//        AnhXa();
    }

    //anh x???
//    private void AnhXa() {
//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        drawerLayout = findViewById(R.id.drawer_layout);
//    }

    //chuyen trang
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            if (mcurrentFragment != FRAGMENT_HOME) {
                replaceFragment(new HomeFragment());
                mcurrentFragment = FRAGMENT_HOME;
            }
        } else if (id == R.id.nav_produc_management) {
            if (mcurrentFragment != FRAGMENT_PRODUCT_MANAGER) {
                Toast.makeText(this, "b???n ch???n Qu???n l?? s???n ph???m  ", Toast.LENGTH_SHORT).show();

                replaceFragment(new QuanLySanPham());
                mcurrentFragment = FRAGMENT_PRODUCT_MANAGER;
            }
        } else if (id == R.id.nav_oder_manager) {

            if (mcurrentFragment != FRAGMENT_ODER_MANAGER) {
                Toast.makeText(this, "b???n ch???n Qu???n l?? ????n h??ng ", Toast.LENGTH_SHORT).show();

                replaceFragment(new QuanLyDonHangFragment());

                mcurrentFragment = FRAGMENT_ODER_MANAGER;
            }
        } else if (id == R.id.nav_customer_manager) {

            if (mcurrentFragment != FRAGMENT_CUSTOMER_MANAGER) {
                Toast.makeText(this, "b???n ch???n Qu???n l?? kh??ch h??ng  ", Toast.LENGTH_SHORT).show();

                replaceFragment(new QuanLyKhachHangFragment());

                mcurrentFragment = FRAGMENT_CUSTOMER_MANAGER;

            }

        } else if (id == R.id.nav_account) {


        } else if (id == R.id.nav_change_pass) {

            drawerLayout.closeDrawer(GravityCompat.START);

        }

        return true;
    }

//    private void replaceFragment(QuanLySanPhamActivity quanLySanPhamActivity) {
//    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
// thanh actionbar v???i toolbar
//    private void ActionBar() {
////ham ho tro toolbar
//        setSupportActionBar(toolbar);
//        //set nut cho actionbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return super.onCreateOptionsMenu(menu);


    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//
//            case R.id.nav_home:
//                Intent intent = new Intent(MainActivity.this, QuanLySanPhamActivity.class);
//                Toast.makeText(this, "b???n ch???n home ", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
//                break;
//
//            case R.id.nav_produc_management:
//                Toast.makeText(this, "b???n ch???n Qu???n l?? s???n ph???m  ", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.nav_oder_manager:
//                Toast.makeText(this, "b???n ch???n Qu???n l?? ????n h??ng  ", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.nav_customer_manager:
//
//                Toast.makeText(this, "b???n ch???n Qu???n l?? kh??ch h??ng   ", Toast.LENGTH_SHORT).show();
//
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}