package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.recycleview.restapi.MealActivity;
import com.example.recycleview.sqlite.DisplayData;
import com.example.recycleview.databinding.ActivityProfileBinding;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {
  private DrawerLayout drawer;
  private ActivityProfileBinding binding;
  SharedPreferences preferences;
  SharedPreferences.Editor editor;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    super.onCreate(savedInstanceState);
    binding = ActivityProfileBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new
            ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
          case R.id.nav_alarm:
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
            break;
          case R.id.nav_food:
            Intent i = new Intent(ProfileActivity.this, FoodActivity.class);
            startActivity(i);
            break;
          case R.id.nav_favorite:
            Intent j = new Intent(ProfileActivity.this, FavoriteActivity.class);
            startActivity(j);
            break;
          case R.id.nav_profile:
            Intent k = new Intent(ProfileActivity.this, ProfileActivity.class);
            startActivity(k);
            break;
          case R.id.nav_sql:
            Intent intent4 = new Intent(ProfileActivity.this, DisplayData.class);
            startActivity(intent4);
            break;
          case R.id.nav_meal:
            Intent intent5 = new Intent(ProfileActivity.this, MealActivity.class);
            startActivity(intent5);
            break;
        }
        return true;
      }
    });
    preferences = getSharedPreferences("AndroidHiveLogin", 0);
    editor = preferences.edit();
    binding.Logout.setOnClickListener((new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
      }
    }));
  }
}