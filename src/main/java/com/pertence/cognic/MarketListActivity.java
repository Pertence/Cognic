package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import static com.pertence.cognic.MarketStartActivity.listItem;

public class MarketListActivity extends AppCompatActivity implements View.OnClickListener {

    public static int cartSize = 3;
    public static int shelfSize = 6;
    public static int itemSize = 9;
    public static int[] cart;
    public static int[] shelf;
    private ImageView[] imageViewMarketList;
    private TextView[] textViewMarketList;

    //Method for shuffling an array
    private int[] shuffleArray(int[] array) {
        Random rng = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomPosition = rng.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }

    // Method for selecting for the cart and shelf
    private void setCart() {
        int[] array = new int[itemSize];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        array = shuffleArray(array);
        for (int i = 0; i < cart.length; i++) {
            cart[i] = array[i];
        }
        for (int i = 0; i < shelf.length; i++) {
            shelf[i] = array[i];
        }
        shuffleArray(shelf);
    }

    //Method for setting views
    private void setViews() {
        for (int i = 0; i < 3; i++) {
            String name = listItem.get(cart[i]).name;
            textViewMarketList[i].setText(name);
            int id = listItem.get(cart[i]).resourceId;
            imageViewMarketList[i].setImageResource(id);
        }
    }

    //Method for finding views
    private void findViews() {
        imageViewMarketList[0] = (ImageView) findViewById(R.id.imageview_market_list1);
        imageViewMarketList[1] = (ImageView) findViewById(R.id.imageview_market_list2);
        imageViewMarketList[2] = (ImageView) findViewById(R.id.imageview_market_list3);
        textViewMarketList[0] = (TextView) findViewById(R.id.textview_market_list1);
        textViewMarketList[1] = (TextView) findViewById(R.id.textview_market_list2);
        textViewMarketList[2] = (TextView) findViewById(R.id.textview_market_list3);
        findViewById(R.id.button_market_list).setOnClickListener(this);
    }

    //Method for setting data
    private void setData() {
        imageViewMarketList = new ImageView[cartSize];
        textViewMarketList = new TextView[shelfSize];
        cart = new int[cartSize];
        shelf = new int[shelfSize];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_list);
        setData();
        setCart();
        findViews();
        setViews();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_market_list:
                Intent intent = new Intent(this, MarketPurchaseActivity.class);
                this.startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
    }

}