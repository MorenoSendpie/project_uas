package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.Preferences.UserPreferences;
import com.example.project.Model.User;
public class ProfilActivity extends AppCompatActivity {
private UserPreferences userPreferences;
private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Button logoutBtn = findViewById(R.id.logoutBtn);
        bottomNavigation();
        userPreferences = new UserPreferences(ProfilActivity.this);
        user = userPreferences.getUserLogin();
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPreferences.logout();
                Toast.makeText(ProfilActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                checklogin();
            }
        });
    }

    private void checklogin() {
        if (!userPreferences.checkLogin()) {
            startActivity(new Intent(ProfilActivity.this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(ProfilActivity.this, "Heyy kamu sudah login!!", Toast.LENGTH_SHORT).show();
        }
    }


    private void bottomNavigation() {
        LinearLayout profilBtn = findViewById(R.id.profilBtn);
        LinearLayout card_btn = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        profilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilActivity.this, ProfilActivity.class));
            }
        });
        card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilActivity.this, MainActivity.class));
            }
        });
    }



}