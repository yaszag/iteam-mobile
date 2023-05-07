package com.example.iteam.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iteam.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iteam.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.NewsViewHolder> {

    List<Event> Data = new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_card_event, parent, false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Event currentEvent = Data.get(position);
        holder.Title.setText(currentEvent.getTitle());
        holder.Desc.setText(currentEvent.getDescription());
        holder.Date.setText(currentEvent.getDate());
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public void setList(List<Event> list) {
        this.Data = list;
        notifyDataSetChanged();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView Title, Desc, Date;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.event_title);
            Desc = itemView.findViewById(R.id.iteam_description);
            Date = itemView.findViewById(R.id.iteam_date);
        }
    }
}
