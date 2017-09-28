package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HouseHintActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonHouseHint;

    //Method for finding views
    private void findViews() {
        buttonHouseHint = (Button) findViewById(R.id.button_house_hint);
        buttonHouseHint.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_hint);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonHouseHint) {
            Intent intent = new Intent(this, HouseStorageActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
