package com.example.myapplication;

public class ListItems {
    private String head;
    private String desc;
    private String price;
    private String imageUrl;

    public ListItems(String head, String desc, String price, String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
