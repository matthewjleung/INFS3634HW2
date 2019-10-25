package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Activity2 extends AppCompatActivity {
    private static final String TAG = "Activity2";
    public String head;
    public String desc;
    public String price;
    public String image;
    public Double subTotal;
    public Double itemPrice;
    public Integer subQty;
    public String subItem;
    public Double gTotal;
    public String orderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        subQty = 0;
        subTotal = 0.00;

        //orderTotal = globalClass.getOrderTotal();

        gTotal = globalClass.getGrandTotal();

        Log.i(TAG, "onCreate:gTotal (doubles):" + gTotal);
        //Log.i(TAG, "onCreate:orderTotal (string):" + orderTotal);

        Intent intent = getIntent();

        Button button_add = (Button) findViewById(R.id.button_add);
        Button button_remove = (Button) findViewById(R.id.button_remove);
        Button button_back = (Button) findViewById(R.id.button_back);

        head = intent.getStringExtra("details_head");
        desc = intent.getStringExtra("details_desc");
        price = intent.getStringExtra("details_price");
        image = intent.getStringExtra("details_image");

        TextView head_textView = (TextView) findViewById(R.id.details_head);
        head_textView.setText(head);

        TextView desc_textView = (TextView) findViewById(R.id.details_desc);
        desc_textView.setText(desc);

        TextView price_textView = (TextView) findViewById(R.id.details_price);
        price_textView.setText("$" + price);

        // display image 
        Picasso.with(getApplicationContext())
                .load(image)
                .into((ImageView) findViewById(R.id.details_image));

        TextView qty_textView = (TextView) findViewById(R.id.qty);
        qty_textView.setText("Items in cart : " + subQty);

        Log.i(TAG, "onCreate:head:" + head);
        Log.i(TAG, "onCreate:desc:" + desc);
        Log.i(TAG, "onCreate:price:" + price);
        Log.i(TAG, "onCreate:image:" + image);

        // remove item button
        button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (subQty>0) {
                    subQty = subQty - 1;
                    itemPrice = Double.valueOf(price).doubleValue();
                    subTotal = subTotal - itemPrice;
                    subItem = subQty.toString() + " * " + head + " @ $" + price + " = $" + String.format("%.2f", subTotal);
                    TextView qty_textView = (TextView) findViewById(R.id.qty);
                    qty_textView.setText("Items in cart : " + subQty);
                    gTotal = gTotal - subQty;

                }
                //Toast.makeText(getApplicationContext(),  head + " removed ", Toast.LENGTH_SHORT).show();
            }
        });

        // add item button
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subQty = subQty + 1;
                itemPrice = Double.valueOf(price).doubleValue();
                subTotal = subTotal + itemPrice;
                subItem = subQty.toString() + " * " + head + " @ $" + price + " = $" + String.format("%.2f", subTotal);

                TextView qty_textView = (TextView) findViewById(R.id.qty);
                qty_textView.setText("Items in cart : " + subQty);

                Log.i(TAG, "onCreate:setOnClickListener:head:" + head);
                Log.i(TAG, "onCreate:setOnClickListener:subQty:" + subQty);
                Log.i(TAG, "onCreate:setOnClickListener:subTotal:" + subTotal);
                Log.i(TAG, "onCreate:setOnClickListener:subItem:" + subItem);

                if (head.equals("Bopper")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead1(head);
                    globalClass.setOrderItem1(subItem);
                    Log.i(TAG, "onCreate:if head1 = Booper");
                    Log.i(TAG, "onCreate:if item1 = Booper, then globalClass.set " + head + ", " + subItem + ", gTotal " + gTotal);
                }
                else if (head.equals("Bopper Jr.")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead2(head);
                    globalClass.setOrderItem2(subItem);
                    Log.i(TAG, "onCreate:if head2 = Booper Jr.");
                    Log.i(TAG, "onCreate:if item2 = Booper Jr, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Chips")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead3(head);
                    globalClass.setOrderItem3(subItem);
                    Log.i(TAG, "onCreate:if head3 = Chips");
                    Log.i(TAG, "onCreate:if item3 = Chips, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Onion Rings")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead4(head);
                    globalClass.setOrderItem4(subItem);
                    Log.i(TAG, "onCreate:if head4 = Onion Ring");
                    Log.i(TAG, "onCreate:if item4 = Onion Ring, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Cheese Burger")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead5(head);
                    globalClass.setOrderItem5(subItem);
                    Log.i(TAG, "onCreate:if head5 = Cheese Burger");
                    Log.i(TAG, "onCreate:if item5 = Cheese Burger, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Double BBQ Bacon Stacker")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead6(head);
                    globalClass.setOrderItem6(subItem);
                    Log.i(TAG, "onCreate:if head6 = Double BBQ Bacon Stacker");
                    Log.i(TAG, "onCreate:if item6 = Double BBQ Bacon Stacker, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Chicken Royale")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead7(head);
                    globalClass.setOrderItem7(subItem);
                    Log.i(TAG, "onCreate:if head7 = Chicken Royale");
                    Log.i(TAG, "onCreate:if item7 = Chicken Royale, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Chicken Nuggets")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead8(head);
                    globalClass.setOrderItem8(subItem);
                    Log.i(TAG, "onCreate:if head8 = Chicken Nuggets");
                    Log.i(TAG, "onCreate:if item8 = Chicken Nuggets, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Chicken Peri Peri Wrap")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead9(head);
                    globalClass.setOrderItem9(subItem);
                    Log.i(TAG, "onCreate:if head9 = Chicken Peri Peri Wrap");
                    Log.i(TAG, "onCreate:if item9 = Chicken Peri Peri Wrap, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals ("Grilled Chicken Caesar Wrap")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead10(head);
                    globalClass.setOrderItem10(subItem);
                    Log.i(TAG, "onCreate:if head10 = Grilled Chicken Caesar Wrap");
                    Log.i(TAG, "onCreate:if item10 = Grilled Chicken Caesar Wrap, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Caramel Sundae")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead11(head);
                    globalClass.setOrderItem11(subItem);
                    Log.i(TAG, "onCreate:if head11 = Caramel Sundae");
                    Log.i(TAG, "onCreate:if item11 = Caramel Sundae, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Chocolate Sundae")){
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead12(head);
                    globalClass.setOrderItem12(subItem);
                    Log.i(TAG, "onCreate:if head12 = Chocolate Sundae");
                    Log.i(TAG, "onCreate:if item12 = Chocolate Sundae, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Soft Serve")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead13(head);
                    globalClass.setOrderItem13(subItem);
                    Log.i(TAG, "onCreate:if head13 = Soft Serve");
                    Log.i(TAG, "onCreate:if item13 = Soft Serve, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Frozen Coke")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead14(head);
                    globalClass.setOrderItem14(subItem);
                    Log.i(TAG, "onCreate:if head14 = Frozen Coke");
                    Log.i(TAG, "onCreate:if item14 = Frozen Coke, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }
                else if (head.equals("Frozen Sprite")) {
                    gTotal = gTotal + itemPrice;
                    globalClass.setGrandTotal(gTotal);
                    globalClass.setOrderHead15(head);
                    globalClass.setOrderItem15(subItem);
                    Log.i(TAG, "onCreate:if head15 = Frozen Sprite");
                    Log.i(TAG, "onCreate:if item15 = Frozen Sprite, then globalClass.set " + head + ", " + subItem + ", gTotal " +gTotal);
                }

                //Toast.makeText(getApplicationContext(),  head + " added", Toast.LENGTH_SHORT).show();
            }
        });

        // back to main activity screen
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

             }
        });

    }

}
