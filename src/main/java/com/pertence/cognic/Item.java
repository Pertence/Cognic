package com.pertence.cognic;

public class Item {

    public String name;
    public int price;
    public int resourceId;
    public int storageId;

    public Item(String name, int price, int resourceId, int storageId) {
        this.name = name;
        this.price = price;
        this.resourceId = resourceId;
        this.storageId = storageId;
    }

}
