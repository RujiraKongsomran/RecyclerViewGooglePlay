package com.rujira.recyclerviewgoogleplay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rujira.recyclerviewgoogleplay.Model.ItemData;
import com.rujira.recyclerviewgoogleplay.Model.ItemGroup;
import com.rujira.recyclerviewgoogleplay.R;

import java.util.List;

public class MyItemGroupAdapter extends RecyclerView.Adapter<MyItemGroupAdapter.MyViewHolder> {

    private Context context;
    private List<ItemGroup> dataList;

    public MyItemGroupAdapter(Context context, List<ItemGroup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_group, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.tvItemTitle.setText(dataList.get(position).getHeaderTitle());
        List<ItemData> itemData = dataList.get(position).getListItem();
        MyItemAdapter itemListAdapter = new MyItemAdapter(context, itemData);
        holder.recyclerViewList.setHasFixedSize(true);
        holder.recyclerViewList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerViewList.setAdapter(itemListAdapter);

        holder.recyclerViewList.setNestedScrollingEnabled(false);// Important
        // Button More
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button More : " + holder.tvItemTitle.getText(), Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvItemTitle;
        RecyclerView recyclerViewList;
        Button btnMore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemTitle = (TextView) itemView.findViewById(R.id.tvItemTitle);
            btnMore = (Button) itemView.findViewById(R.id.btnMore);
            recyclerViewList = (RecyclerView) itemView.findViewById(R.id.recyclerViewList);
        }
    }
}
