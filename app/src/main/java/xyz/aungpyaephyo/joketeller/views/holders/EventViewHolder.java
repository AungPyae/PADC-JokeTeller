package xyz.aungpyaephyo.joketeller.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import xyz.aungpyaephyo.joketeller.R;
import xyz.aungpyaephyo.joketeller.data.vos.EventVO;

/**
 * Created by aung on 6/26/16.
 */
public class EventViewHolder extends RecyclerView.ViewHolder{

    private TextView tvEventTitle;
    private ImageView ivStockPhoto;
    private TextView tvEventDesc;
    private TextView tvEventTime;

    public EventViewHolder(View view) {
        super(view);
        tvEventTitle = (TextView) view.findViewById(R.id.tv_event_title);
        ivStockPhoto = (ImageView) view.findViewById(R.id.iv_stock_photo);
        tvEventDesc = (TextView) view.findViewById(R.id.tv_event_desc);
        tvEventTime = (TextView) view.findViewById(R.id.tv_event_time);
    }

    public void setData(EventVO event) {
        tvEventTitle.setText(event.getEventTitle());
        tvEventDesc.setText(event.getEventDesc());
        tvEventTime.setText(event.getEventTime()); //Friday, Feb 26, 1:00pm - 5:00pm

        Glide.with(ivStockPhoto.getContext())
                .load(event.getStockPhotoPath())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .into(ivStockPhoto);
    }
}
