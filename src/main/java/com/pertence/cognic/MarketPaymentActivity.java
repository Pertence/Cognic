package com.pertence.cognic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.pertence.cognic.MarketListActivity.cart;
import static com.pertence.cognic.MarketListActivity.cartSize;
import static com.pertence.cognic.MarketStartActivity.listItem;

public class MarketPaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private static int moneySize = 6;
    private int cartPrice;
    private int partialSum = 0;
    private String[] textMarketPayment;
    private ImageButton[] imageButtonMarketPayment;
    private TextView[] textViewMarketPayment;
    private Button buttonMarketPayment;
    private int[] arrayValueMoney = {1, 2, 5, 10, 20, 50};
    private int imageButtonResource[] = {
            R.id.imagebutton_market_payment1, R.id.imagebutton_market_payment2,
            R.id.imagebutton_market_payment3, R.id.imagebutton_market_payment4,
            R.id.imagebutton_market_payment5, R.id.imagebutton_market_payment6};

    //Method for setting the total price of the cart
    private void setCartPrice() {
        cartPrice = 0;
        for (int i=0; i<cartSize; i++) {
            cartPrice = cartPrice + listItem.get(cart[i]).price;
        }
    }

    //Method for checking the payment in progress
    private void checkPayment(int i) {
        setTextEmpty();
        partialSum = partialSum + i;
        if (partialSum < cartPrice) {
            //call if the sum is yet to be reached
            setViews(0);
        } else if (partialSum == cartPrice) {
            //call if the sum payed is correct
            setViews(1);
        } else if (partialSum > cartPrice) {
            //call if the sum payed is bigger and restart
            partialSum = 0;
            setViews(2);
        }
    }

    //Method for finding views
    private void findViews() {
        for (int i = 0; i < imageButtonMarketPayment.length; i++) {
            imageButtonMarketPayment[i] = (ImageButton) findViewById(imageButtonResource[i]);
            imageButtonMarketPayment[i].setOnClickListener(this);
        }
        textViewMarketPayment[0] = (TextView) findViewById(R.id.textview_market_payment2);
        textViewMarketPayment[1] = (TextView) findViewById(R.id.textview_market_payment3);
        textViewMarketPayment[2] = (TextView) findViewById(R.id.textview_market_payment4);
        buttonMarketPayment = (Button) findViewById(R.id.button_market_payment);
        buttonMarketPayment.setOnClickListener(this);
    }

    //Method for setting views
    private void setViews(int i) {
        String text;
        switch (i) {
            case 0:
                text = textMarketPayment[1] + " " + Integer.toString(partialSum) + " " + textMarketPayment[2];
                textViewMarketPayment[1].setText(text);
                break;
            case 1:
                text = textMarketPayment[1] + " " + Integer.toString(partialSum) + " " + textMarketPayment[2];
                textViewMarketPayment[1].setText(text);
                for (int j = 0; j < moneySize; j++) {
                    imageButtonMarketPayment[j].setEnabled(false);
                }
                buttonMarketPayment.setVisibility(View.VISIBLE);
                break;
            case 2:
                text = textMarketPayment[1] + " " + Integer.toString(partialSum) + " " + textMarketPayment[2];
                textViewMarketPayment[1].setText(text);
                text = textMarketPayment[3];
                textViewMarketPayment[2].setText(text);
                break;
        }
    }

    //Method for setting data
    private void setData() {
        textMarketPayment = new String[4];
        textViewMarketPayment = new TextView[4];
        imageButtonMarketPayment = new ImageButton[moneySize];
        textMarketPayment[0] = getResources().getString(R.string.text_market_payment2);
        textMarketPayment[1] = getResources().getString(R.string.text_market_payment3);
        textMarketPayment[2] = getResources().getString(R.string.text_market_payment4);
        textMarketPayment[3] = getResources().getString(R.string.text_market_payment5);
    }

    //Method for setting text views
    private void setTextViews() {
        String text;
        text = textMarketPayment[0] + " " + Integer.toString(cartPrice) + " " + textMarketPayment[2];
        textViewMarketPayment[0].setText(text);
        text = textMarketPayment[1];
        textViewMarketPayment[1].setText(text);
    }


    //Method for setting a text view to empty
    private void setTextEmpty() {
        textViewMarketPayment[2].setText(" ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_payment);
        setData();
        setCartPrice();
        findViews();
        setTextViews();
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < moneySize; i++) {
            if (view.getId() == imageButtonResource[i]) {
                checkPayment(arrayValueMoney[i]);
                return;
            }
        }
        if (view.getId() == R.id.button_market_payment) {
            Intent intent = new Intent(this, HouseStartActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
