package com.padcmyanmar.padc7.hellofragments.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.padcmyanmar.padc7.hellofragments.R;
import com.padcmyanmar.padc7.hellofragments.fragments.OneFragment;
import com.padcmyanmar.padc7.hellofragments.fragments.TwoFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        Button btnFragmentOne = findViewById(R.id.btn_show_frag_one);
        btnFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragmentOne();
            }
        });

        Button btnFragmentTwo = findViewById(R.id.btn_show_frag_two);
        btnFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragmentTwo();
            }
        });

        Button btnFragmentThree = findViewById(R.id.btn_frag_two_backstack);
        btnFragmentThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragmentTwoWithBackstack();
            }
        });

        Button btnFragmentOneWithTransition = findViewById(R.id.btn_frag_one_transition);
        btnFragmentOneWithTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragmentOneWithTransaction();
            }
        });
    }

    private void showFragmentOne() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, OneFragment.newInstance())
                .commit();
    }

    private void showFragmentTwo() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, TwoFragment.newInstance())
                .commit();
    }

    private void showFragmentTwoWithBackstack() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, TwoFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
    
    private void showFragmentOneWithTransaction() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fl_container, OneFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
