package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.pertence.cognic.MarketListActivity.cart;
import static com.pertence.cognic.MarketListActivity.shelf;
import static com.pertence.cognic.MarketListActivity.shelfSize;
import static com.pertence.cognic.MarketStartActivity.listItem;

public class MarketPurchaseActivity extends AppCompatActivity implements View.OnClickListener {

    private int score = 0;
    private ImageView[] imageViewMarketPurchase;
    private ImageButton[] imageButtonMarketPurchase;
    private TextView textViewMarketPurchase;
    private Button buttonMarketPurchase;
    private int[] imageButtonResource = {
            R.id.imagebutton_market_purchase1, R.id.imagebutton_market_purchase2,
            R.id.imagebutton_market_purchase3, R.id.imagebutton_market_purchase4,
            R.id.imagebutton_market_purchase5, R.id.imagebutton_market_purchase6};

    //Method for checking if item is in an array
    private boolean checkArray(int[] array, int i) {
        for (int j : array) {
            if (j == i) {
                return true;
            }
        }
        return false;
    }

    //Method for checking if the selected item is correct
    private boolean checkCart(int i) {
        //Evaluate if a correct item is chosen
        if (checkArray(cart, i)) {
            score = score + 1;
            //Evaluate if all correct items are correct
            if (score == cart.length) {
                setViews(2);
            } else {
                setViews(0);
            }
            return true;
        } else {
            setViews(1);
            return false;
        }
    }

    //Method for setting views
    private void setViews(int i) {
        String text;
        switch (i) {
            case 0:
                text = getResources().getString(R.string.text_correct);
                textViewMarketPurchase.setText(text);
                break;
            case 1:
                text = getResources().getString(R.string.text_incorrect);
                textViewMarketPurchase.setText(text);
                break;
            case 2:
                text = getResources().getString(R.string.text_correct);
                textViewMarketPurchase.setText(text);
                for (int j = 0; j < shelfSize; j++) {
                    imageButtonMarketPurchase[j].setEnabled(false);
                }
                buttonMarketPurchase.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void setShelvesView() {
        for (int i = 0; i < shelfSize; i++) {
            int id = listItem.get(shelf[i]).resourceId;
            imageButtonMarketPurchase[i].setImageResource(id);
        }
    }

    //Method for setting the right or wrong icons
    private void setIcon(ImageView icon, boolean b) {
        if (b) {
            icon.setImageResource(R.drawable.right);
        } else {
            icon.setImageResource(R.drawable.wrong);
        }
    }

    //Method for finding views
    private void findViews() {
        for (int i = 0; i < shelfSize; i++) {
            imageButtonMarketPurchase[i] = (ImageButton) findViewById(imageButtonResource[i]);
            imageButtonMarketPurchase[i].setOnClickListener(this);
        }
        imageViewMarketPurchase[0] = (ImageView) findViewById(R.id.imageview_market_purchase1);
        imageViewMarketPurchase[1] = (ImageView) findViewById(R.id.imageview_market_purchase2);
        imageViewMarketPurchase[2] = (ImageView) findViewById(R.id.imageview_market_purchase3);
        imageViewMarketPurchase[3] = (ImageView) findViewById(R.id.imageview_market_purchase4);
        imageViewMarketPurchase[4] = (ImageView) findViewById(R.id.imageview_market_purchase5);
        imageViewMarketPurchase[5] = (ImageView) findViewById(R.id.imageview_market_purchase6);
        textViewMarketPurchase = (TextView) findViewById(R.id.textview_market_purchase2);
        buttonMarketPurchase = (Button) findViewById(R.id.button_market_purchase);
        buttonMarketPurchase.setOnClickListener(this);
    }

    //Method for setting views
    private void setData() {
        imageButtonMarketPurchase = new ImageButton[shelfSize];
        imageViewMarketPurchase = new ImageView[shelfSize];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_purchase);
        setData();
        findViews();
        setShelvesView();
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < shelfSize; i++) {
            if (imageButtonResource[i] == view.getId()) {
                imageButtonMarketPurchase[i].setEnabled(false);
                boolean b = checkCart(shelf[i]);
                setIcon(imageViewMarketPurchase[i], b);
                return;
            }
        }
        if (view.getId() == R.id.button_market_purchase) {
            Intent intent = new Intent(this, MarketPaymentActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}