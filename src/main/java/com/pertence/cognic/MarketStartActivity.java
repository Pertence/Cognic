package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MarketStartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonMarketStart;
    public static ArrayList<Item> listItem;

    //Method for finding views
    private void findViews() {
        buttonMarketStart = (Button) findViewById(R.id.button_market_start);
        buttonMarketStart.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_start);
        findViews();

        listItem = new ArrayList<>();
        listItem.add(0, new Item("Abacaxi", 3, R.drawable.pineapple, 1));
        listItem.add(1, new Item("Banana", 2, R.drawable.banana, 1));
        listItem.add(2, new Item("Queijo", 15, R.drawable.cheese, 0));
        listItem.add(3, new Item("Escova", 8, R.drawable.toothbrush, 2));
        listItem.add(4, new Item("Carne", 20, R.drawable.meat, 0));
        listItem.add(5, new Item("Pente", 5, R.drawable.comb, 2));
        listItem.add(6, new Item("Mexerica", 7, R.drawable.tangerine, 1));
        listItem.add(7, new Item("Leite", 4, R.drawable.milk, 0));
        listItem.add(8, new Item("Creme dental", 6, R.drawable.toothpaste, 2));
    }

    @Override
    public void onClick(View v) {
        if (v == buttonMarketStart) {
            Intent intent = new Intent(this, MarketListActivity.class);
            this.startActivity(intent);
            finish();
        }
    }
}
