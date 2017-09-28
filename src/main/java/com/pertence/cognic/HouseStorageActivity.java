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
import static com.pertence.cognic.MarketStartActivity.listItem;

public class HouseStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private static int storageSize = 3;
    private int score = 0;
    private int item = 0;
    private ImageButton[] imageButtonHouseStorage;
    private ImageView[] imageViewIcon;
    private ImageView imageViewHouseStorage;
    private TextView textViewHouseStorage;
    private Button buttonHouseStorage;
    private int[] arrayStorageId = {0, 1, 2};
    private int[] imageButtonResource = {R.id.imagebutton_house_storage1,
            R.id.imagebutton_house_storage2, R.id.imagebutton_house_storage3};

    //Method for checking if item is stored correctly
    private boolean checkStorage(int i, int j) {
        //Evaluate if item is stored correctly
        int id = listItem.get(cart[i]).storageId;
        if (id == j) {
            score = score + 1;
            item = item + 1;
            //Evaluate if all items are stored correctly
            if (score == cart.length) {
                setViews(2);
            } else {
                setViews(0);
            }
            return (true);
        } else {
            setViews(1);
            return (false);
        }
    }

    //Method for setting views
    private void setViews(int i) {
        String text;
        switch (i) {
            case 0:
                text = getResources().getString(R.string.text_correct);
                int id = listItem.get(cart[item]).resourceId;
                //int id = arrayMarketImage.getResourceId(cart[item], -1);
                imageViewHouseStorage.setImageResource(id);
                for (int j = 0; j < storageSize; j++) {
                    imageViewIcon[j].setImageResource(android.R.color.transparent);
                }
                textViewHouseStorage.setText(text);
                break;
            case 1:
                text = getResources().getString(R.string.text_incorrect);
                textViewHouseStorage.setText(text);
                break;
            case 2:
                for (int j = 0; j < imageButtonHouseStorage.length; j++) {
                    imageButtonHouseStorage[j].setEnabled(false);
                }
                text = getResources().getString(R.string.text_correct);
                textViewHouseStorage.setText(text);
                buttonHouseStorage.setVisibility(View.VISIBLE);
                break;
        }
    }

    //Method for setting the right or wrong icons
    private void setIcon(ImageView icon, boolean b) {
        if (b) {
            icon.setImageResource(android.R.color.transparent);
        } else {
            icon.setImageResource(R.drawable.wrong);
        }
    }

    //Method for finding views
    private void findViews() {
        for (int i = 0; i < storageSize; i++) {
            imageButtonHouseStorage[i] = (ImageButton) findViewById(imageButtonResource[i]);
            imageButtonHouseStorage[i].setOnClickListener(this);
        }
        imageViewHouseStorage = (ImageView) findViewById(R.id.imageview_house_storage);
        imageViewIcon[0] = (ImageView) findViewById(R.id.imageview_icon1);
        imageViewIcon[1] = (ImageView) findViewById(R.id.imageview_icon2);
        imageViewIcon[2] = (ImageView) findViewById(R.id.imageview_icon3);
        textViewHouseStorage = (TextView) findViewById(R.id.textview_house_storage2);
        buttonHouseStorage = (Button) findViewById(R.id.button_house_storage);
        buttonHouseStorage.setOnClickListener(this);
    }

    //Method for setting data
    private void setData() {
        imageButtonHouseStorage = new ImageButton[3];
        imageViewIcon = new ImageView[3];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_storage);
        setData();
        findViews();
        int id = listItem.get(cart[0]).resourceId;
        imageViewHouseStorage.setImageResource(id);
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < storageSize; i++) {
            if (view.getId() == imageButtonResource[i]) {
                boolean b = checkStorage(item, arrayStorageId[i]);
                setIcon(imageViewIcon[i], b);
                return;
            }
        }
        if (view.getId() == R.id.button_house_storage) {
            Intent intent = new Intent(this, FinishActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
}