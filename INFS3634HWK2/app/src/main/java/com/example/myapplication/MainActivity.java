package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    public static final String EXTRA_HEAD = "";
    public static final String EXTRA_DESC = "";
    public static final String EXTRA_PRICE = "";
    public static final String EXTRA_IMAGE = "";
    public static final String EXTRA_QUANTITY = "";

    private static final String TAG = "MainActivity";
    private static final String URL_DATA = "https://www.ttnsw.com.au/home/files/2014/8375293875293jkwhjkfhyhh/task2data.json";
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private double zeroDollar;
    private List<ListItems> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        globalClass.setGrandItems(0);
        globalClass.setGrandTotal(0.00);
        globalClass.setOrderQty1(0);
        globalClass.setOrderQty2(0);
        globalClass.setOrderQty3(0);
        globalClass.setOrderQty4(0);
        globalClass.setOrderQty5(0);
        globalClass.setOrderQty6(0);
        globalClass.setOrderQty7(0);
        globalClass.setOrderQty8(0);
        globalClass.setOrderQty9(0);
        globalClass.setOrderQty10(0);
        globalClass.setOrderQty11(0);
        globalClass.setOrderQty12(0);
        globalClass.setOrderQty13(0);
        globalClass.setOrderQty14(0);
        globalClass.setOrderQty15(0);

        //zeroDollar = zeroDollar + 0;
        globalClass.setGrandTotal(zeroDollar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        // call load recycle view class
        loadRecyclerViewData();

    }
    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        // retrieve fast food items from external URL via JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("food");

                            for (int i =0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);

                                ListItems item = new ListItems(
                                        o.getString("name"),
                                        o.getString("desc"),
                                        o.getString("price"),
                                        o.getString("imageurl")
                                        // add to a list
                                );
                                listItems.add(item);

                                adapter = new MyAdapter(listItems, getApplicationContext());
                                recyclerView.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        // View Order button on main activity screen
        Button button = (Button) findViewById(R.id.viewOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
    }
    public void openActivity1() {

        String head = "";
        String desc = "";
        String price = "";
        String image = "";
        String quantity = "";

        // put varables for an Intent call
        Intent intent = new Intent(this, Activity1.class);
        intent.putExtra(EXTRA_HEAD, head);
        intent.putExtra(EXTRA_DESC, desc);
        intent.putExtra(EXTRA_PRICE, price);
        intent.putExtra(EXTRA_IMAGE, image);
        intent.putExtra(EXTRA_QUANTITY, quantity);

        startActivity(intent);
    }
}
