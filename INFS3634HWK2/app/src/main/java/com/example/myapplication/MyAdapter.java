package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = "MyAdapter";
    private List<ListItems> listItems;
    private Context context;

    public MyAdapter(List<ListItems> listItems, Context context){
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false  );
        return new ViewHolder(v);
    }

    @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListItems listItem  = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.textViewPrice.setText(listItem.getPrice());
        Picasso.with(context)
                .load(listItem.getImageUrl())
                .into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                Intent intent = new Intent(context, Activity2.class);

                // replace this with intent
                //Toast.makeText(context, "You clicked" + listItem.getHead(), Toast.LENGTH_SHORT).show();

                String head = listItem.getHead();
                String desc = listItem.getDesc();
                String price = listItem.getPrice();
                String image = listItem.getImageUrl();

                Log.i(TAG, "onBindViewHolderr:head:"+head);
                Log.i(TAG, "onBindViewHolderr:desc:"+desc);
                Log.i(TAG, "onBindViewHolderr:price:"+price);
                Log.i(TAG, "onBindViewHolderr:image:"+image);

                intent.putExtra("details_head",head);
                intent.putExtra("details_desc",desc);
                intent.putExtra("details_price",price);
                intent.putExtra("details_image",image);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewPrice;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
