package com.andanhm.healthcare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andanhm.healthcare.R;
import com.andanhm.healthcare.model.NavigationDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 *
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MenuViewHolder> {
    private List<NavigationDrawerItem> mNavigationDrawerItem = Collections.emptyList();
    private LayoutInflater inflater;
    private Context mContext;

    public NavigationDrawerAdapter(Context mContext, List<NavigationDrawerItem> mNavigationDrawerItem) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.mNavigationDrawerItem = mNavigationDrawerItem;
    }

    @Override
    public NavigationDrawerAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(inflater.inflate(R.layout.nav_drawer_row, parent, false));
    }

    @Override
    public void onBindViewHolder(NavigationDrawerAdapter.MenuViewHolder holder, int position) {
        NavigationDrawerItem current = mNavigationDrawerItem.get(position);
        if (current.getTitle().equals(mContext.getString(R.string.nav_item_notifications))){
            holder.notificationLayout.setVisibility(View.VISIBLE);
        }
        holder.txtTitle.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNavigationDrawerItem.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtNoOfNotificationReceived;
        LinearLayout notificationLayout;

        MenuViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.title);
            txtNoOfNotificationReceived = (TextView) itemView.findViewById(R.id.txtNoOfNotificationReceived);
            notificationLayout = (LinearLayout) itemView.findViewById(R.id.layoutNotification);

        }
    }
}
