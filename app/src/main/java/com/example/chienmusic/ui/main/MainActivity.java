package com.example.chienmusic.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.chienmusic.R;
import com.example.chienmusic.ui.home.HomeFragment;
import com.example.chienmusic.ui.library.LibraryFragment;
import com.example.chienmusic.ui.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;
    private HomeFragment mHomeFragment;
    private LibraryFragment mLibraryFragment;
    private SearchFragment mSearchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        registerListener();
    }

    private void registerListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initComponents() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        openScreenHome();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_home:
                openScreenHome();
                return true;
            case R.id.nav_library:
                openScreenLibrary();
                return true;
            case R.id.nav_search:
                openScreenSearch();
                return true;
            default:
                return false;
        }
    }

    private void openScreenSearch() {
        mSearchFragment = new SearchFragment();
        addFragment(mSearchFragment);
    }

    private void openScreenLibrary() {
        mLibraryFragment = new LibraryFragment();
        addFragment(mLibraryFragment);
    }

    private void openScreenHome() {
        mHomeFragment = new HomeFragment();
        addFragment(mHomeFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
