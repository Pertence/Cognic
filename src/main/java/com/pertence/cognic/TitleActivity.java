package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class TitleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonTitle;

    //Method for finding views
    private void findViews() {
        buttonTitle = (Button) findViewById(R.id.button_title);
        buttonTitle.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonTitle) {
            Intent intent = new Intent(this, MarketStartActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
