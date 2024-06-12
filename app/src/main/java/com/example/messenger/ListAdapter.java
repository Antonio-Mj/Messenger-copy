package com.example.messenger;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private final LayoutInflater mInflater;
    private final Random mRandom;

    public ListAdapter(List<ListElement> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = itemList;
        this.mRandom = new Random();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListElement element = mData.get(position);
        holder.bindData(element);
        setImageResources(holder);
        setVisibility(holder, element);

        TextView namesTextView = holder.names;
        TextView messageTextView = holder.message;
        TextView hourTextView = holder.timeOrDay;

        int[] colors;
        int nightModeFlags = holder.itemView.getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES;

        if (isDarkMode) {
            colors = new int[]{Color.LTGRAY, Color.WHITE};
        } else {
            colors = new int[]{Color.DKGRAY};
        }

        int randomColorIndex = new Random().nextInt(colors.length);
        int textColor = colors[randomColorIndex];

        namesTextView.setTextColor(textColor);
        messageTextView.setTextColor(textColor);
        hourTextView.setTextColor(textColor);

        boolean isBold = new Random().nextBoolean();

        if (isBold) {
            namesTextView.setTypeface(null, Typeface.BOLD);
            messageTextView.setTypeface(null, Typeface.BOLD);
            hourTextView.setTypeface(null, Typeface.BOLD);
        } else {
            namesTextView.setTypeface(null, Typeface.NORMAL);
            messageTextView.setTypeface(null, Typeface.NORMAL);
            hourTextView.setTypeface(null, Typeface.NORMAL);
        }
    }

        private void setImageResources(ViewHolder holder) {
            int[] activeIconResources = {
                    R.drawable.active,
            };
            int[] receiveIconResources = {
                    R.drawable.iconamooncheckcircle1__1_,
                    R.drawable.iconamooncheckcircle1fill,
            };
            holder.activoImageView.setImageResource(activeIconResources[mRandom.nextInt(activeIconResources.length)]);
            holder.receiveImageView.setImageResource(receiveIconResources[mRandom.nextInt(receiveIconResources.length)]);
        }

    private void setVisibility(ViewHolder holder, ListElement element) {
        holder.activoImageView.setVisibility(element.isActive() ? View.VISIBLE : View.GONE);
        holder.receiveImageView.setVisibility(element.isViewMessage() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<ListElement> items) {
        mData = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView names, message, timeOrDay;
        ImageView picture, activoImageView, receiveImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.namesTextView);
            message = itemView.findViewById(R.id.messageTextView);
            timeOrDay = itemView.findViewById(R.id.hourTextView);
            picture = itemView.findViewById(R.id.iconImageView);
            activoImageView = itemView.findViewById(R.id.activo);
            receiveImageView = itemView.findViewById(R.id.receiveImageView);
        }

        void bindData(final ListElement item) {
            names.setText(item.getNames());
            message.setText(item.getMessage());
            timeOrDay.setText(item.getTimeOrDay());
            picture.setImageResource(item.getImageResource());
        }
    }
}
