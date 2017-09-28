package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HouseStartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonHouseStart;
    private Button buttonRestart;
    private Button buttonExit;

    //Method for finding views
    private void findViews() {
        buttonHouseStart = (Button) findViewById(R.id.button_house_start);
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonExit = (Button) findViewById(R.id.button_exit);
        buttonHouseStart.setOnClickListener(this);
        buttonRestart.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_start);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonHouseStart) {
            Intent intent = new Intent(this, HouseHintActivity.class);
            this.startActivity(intent);
            finish();
        } else if (v == buttonRestart) {
            Intent intent = new Intent(this, TitleActivity.class);
            this.startActivity(intent);
            finish();
        } else if (v == buttonExit) {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
