package com.semenov.sqlitesearch_2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList <Contact> contactArrayList;

    public MainAdapter(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        try {
            holder.name.setText(contactArrayList.get(position).getName());
            holder.phoneNumber.setText(contactArrayList.get(position).getPhoneNumber());
        } catch (Exception ex){
            Log.d("mLog", "Not text in holder");
        }
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phoneNumber;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView);
            phoneNumber = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
