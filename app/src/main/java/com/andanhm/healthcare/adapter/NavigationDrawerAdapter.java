package com.andanhm.healthcare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andanhm.healthcare.R;
import com.andanhm.healthcare.model.NavigationDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by andan on 02/06/17.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MenuViewHolder> {
    List<NavigationDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context mContext;
    public NavigationDrawerAdapter(Context mContext,List<NavigationDrawerItem> data){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.data = data;
    }
    @Override
    public NavigationDrawerAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MenuViewHolder holder = new MenuViewHolder(view);
        return holder;
    }
    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public void onBindViewHolder(NavigationDrawerAdapter.MenuViewHolder holder, int position) {
        NavigationDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MenuViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
