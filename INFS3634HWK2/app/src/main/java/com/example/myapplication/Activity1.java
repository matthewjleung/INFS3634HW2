package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {
    ListView listView;
    private static final String TAG = "Activity1";
    public Double gTotal;
    public String orderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        gTotal = globalClass.getGrandTotal();
        orderTotal = globalClass.getOrderTotal();

        Log.i(TAG, "onCreate:globalClass:getOrderHead1:" + globalClass.getOrderHead1());
        Log.i(TAG, "onCreate:globalClass:gTotal:" + gTotal);

        //create a list to display on the screen
        listView = (ListView) findViewById(R.id.listview);
        final ArrayList<String> arrayList = new ArrayList <> ();

        String orderItem1 = globalClass.getOrderItem1();
        String orderItem2 = globalClass.getOrderItem2();
        String orderItem3 = globalClass.getOrderItem3();
        String orderItem4 = globalClass.getOrderItem4();
        String orderItem5 = globalClass.getOrderItem5();
        String orderItem6  = globalClass.getOrderItem6();
        String orderItem7 = globalClass.getOrderItem7();
        String orderItem8 = globalClass.getOrderItem8();
        String orderItem9 = globalClass.getOrderItem9();
        String orderItem10 = globalClass.getOrderItem10();
        String orderItem11 = globalClass.getOrderItem11();
        String orderItem12 = globalClass.getOrderItem12();
        String orderItem13 = globalClass.getOrderItem13();
        String orderItem14 = globalClass.getOrderItem14();
        String orderItem15 = globalClass.getOrderItem15();

        String orderHead1 = globalClass.getOrderHead1();
        String orderHead2 = globalClass.getOrderHead2();
        String orderHead3 = globalClass.getOrderHead3();
        String orderHead4 = globalClass.getOrderHead4();
        String orderHead5 = globalClass.getOrderHead5();
        String orderHead6 = globalClass.getOrderHead6();
        String orderHead7 = globalClass.getOrderHead7();
        String orderHead8 = globalClass.getOrderHead8();
        String orderHead9 = globalClass.getOrderHead9();
        String orderHead10 = globalClass.getOrderHead10();
        String orderHead11 = globalClass.getOrderHead11();
        String orderHead12 = globalClass.getOrderHead12();
        String orderHead13 = globalClass.getOrderHead13();
        String orderHead14 = globalClass.getOrderHead14();
        String orderHead15 = globalClass.getOrderHead15();

        //String selected_head = globalClass.getSelected_head();

        //arrayList.add("Order total is $" + gTotal);
        arrayList.add("Order total is $" + orderTotal);

        Log.i(TAG, "onCreate:globalClass:orderHead1:" + orderHead1);
        Log.i(TAG, "onCreate:globalClass:orderItem1:" + orderItem1);
        if (orderHead1 != null) {
            if (orderHead1.equals("Bopper")) {
                Log.i(TAG, "onCreate:globalClass:orderItem1 (added):" + orderItem1);
                arrayList.add(orderItem1);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead2:" + orderHead2);
        Log.i(TAG, "onCreate:globalClass:orderItem2:" + orderItem2);
        if  (orderHead2 != null) {
            if (orderHead2.equals("Bopper Jr.")) {
                Log.i(TAG, "onCreate:globalClass:orderItem2 (added):" + orderItem2);
                arrayList.add(orderItem2);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead3:" + orderHead3);
        Log.i(TAG, "onCreate:globalClass:ordetItem3:" + orderItem3);
        if (orderHead3 != null) {
            if (orderHead3.equals("Chips")) {
                Log.i(TAG, "onCreate:globalClass:orderItem3 (added):" + orderItem3);
                arrayList.add(orderItem3);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead4:" + orderHead4);
        Log.i(TAG, "onCreate:globalClass:ordetItem4:" + orderItem4);
        if (orderHead4 != null) {
            if (orderHead4.equals("Onion Rings")) {
                Log.i(TAG, "onCreate:globalClass:orderItem4 (added):" + orderItem4);
                arrayList.add(orderItem4);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead5:" + orderHead5);
        Log.i(TAG, "onCreate:globalClass:ordetItem5:" + orderItem5);
        if (orderHead5 != null) {
            if (orderHead5.equals("Cheese Burger"))  {
                Log.i(TAG, "onCreate:globalClass:orderItem5 (added):" + orderItem5);
                arrayList.add(orderItem5);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead6:" + orderHead6);
        Log.i(TAG, "onCreate:globalClass:ordetItem6:" + orderItem6);
        if (orderHead6 != null) {
            if (orderHead6.equals("Double BBQ Bacon Stacker")) {
                Log.i(TAG, "onCreate:globalClass:orderItem6 (added):" + orderItem6);
                arrayList.add(orderItem6);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead7:" + orderHead7);
        Log.i(TAG, "onCreate:globalClass:ordetItem7:" + orderItem7);
        if (orderHead7 != null) {
            if (orderHead7.equals("Chicken Royale")) {
                Log.i(TAG, "onCreate:globalClass:orderItem7 (added):" + orderItem7);
                arrayList.add(orderItem7);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead8:" + orderHead8);
        Log.i(TAG, "onCreate:globalClass:ordetItem8:" + orderItem8);
        if (orderHead8 != null) {
            if (orderHead8.equals("Chicken Nuggets")) {
                Log.i(TAG, "onCreate:globalClass:orderItem8 (added):" + orderItem8);
                arrayList.add(orderItem8);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead9:" + orderHead9);
        Log.i(TAG, "onCreate:globalClass:ordetItem9:" + orderItem9);
        if (orderHead9 != null) {
            if (orderHead9.equals("Chicken Peri Peri Wrap")) {
                Log.i(TAG, "onCreate:globalClass:orderItem9 (added):" + orderItem9);
                arrayList.add(orderItem9);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead10:" + orderHead10);
        Log.i(TAG, "onCreate:globalClass:ordetItem10:" + orderItem10);
        if (orderHead10 != null) {
            if (orderHead10.equals("Grilled Chicken Caesar Wrap")) {
                Log.i(TAG, "onCreate:globalClass:orderItem2 (added):" + orderItem10);
                arrayList.add(orderItem10);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead11:" + orderHead11);
        Log.i(TAG, "onCreate:globalClass:ordetItem11:" + orderItem11);
        if (orderHead11 != null) {
            if (orderHead11.equals("Caramel Sundae")) {
                Log.i(TAG, "onCreate:globalClass:orderItem11 (added):" + orderItem11);
                arrayList.add(orderItem11);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead12:" + orderHead12);
        Log.i(TAG, "onCreate:globalClass:ordetItem12:" + orderItem12);
        if (orderHead12 != null) {
            if (orderHead12.equals("Chocolate Sundae")) {
                Log.i(TAG, "onCreate:globalClass:orderItem12 (added):" + orderItem12);
                arrayList.add(orderItem12);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead13:" + orderHead13);
        Log.i(TAG, "onCreate:globalClass:ordetItem13:" + orderItem13);
        if (orderHead13 != null) {
            if (orderHead13.equals("Soft Serve")) {
                Log.i(TAG, "onCreate:globalClass:orderItem13 (added):" + orderItem13);
                arrayList.add(orderItem13);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead14:" + orderHead14);
        Log.i(TAG, "onCreate:globalClass:ordetItem14:" + orderItem14);
        if (orderHead14 != null) {
            if (orderHead14.equals("Frozen Coke")){
                Log.i(TAG, "onCreate:globalClass:orderItem14 (added):" + orderItem14);
                arrayList.add(orderItem14);
            }
        }

        Log.i(TAG, "onCreate:globalClass:orderHead15:" + orderHead15);
        Log.i(TAG, "onCreate:globalClass:ordetItem15:" + orderItem15);
        if (orderHead15 != null) {
            if (orderHead15.equals("Frozen Sprite")) {
                Log.i(TAG, "onCreate:globalClass:orderItem15 (added):" + orderItem15);
                arrayList.add(orderItem15);
            }
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long L) {
                Toast.makeText(Activity1.this, "Clicked item is " +i+ " " + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
               // total_price = total_price + 10;
            }
        });

        // back to main activity screen button
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
