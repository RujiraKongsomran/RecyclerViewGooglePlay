package com.rujira.recyclerviewgoogleplay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rujira.recyclerviewgoogleplay.Interface.ItemClickListener;
import com.rujira.recyclerviewgoogleplay.Model.ItemData;
import com.rujira.recyclerviewgoogleplay.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder> {

    private Context context;
    private List<ItemData> itemDataList;

    public MyItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvItemTitle.setText(itemDataList.get(position).getName());
        Picasso.get().load(itemDataList.get(position).getImage()).into(holder.imgView);

        // Don't forget implement item click

    }

    @Override
    public int getItemCount() {
        return (itemDataList != null ? itemDataList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvItemTitle;
        ImageView imgView;

        ItemClickListener itemClickListener;

        public void setTvItemTitle(TextView tvItemTitle) {
            this.tvItemTitle = tvItemTitle;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            itemClickListener.onItemClickListener(view, getAdapterPosition());
        }
    }
}
