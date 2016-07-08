package xyz.aungpyaephyo.joketeller.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.aungpyaephyo.joketeller.R;
import xyz.aungpyaephyo.joketeller.data.vos.EventVO;
import xyz.aungpyaephyo.joketeller.fragments.EventFragment;

/**
 * Created by aung on 6/26/16.
 */
public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.tv_event_title)
    TextView tvEventTitle;

    @Bind(R.id.iv_stock_photo)
    ImageView ivStockPhoto;

    @Bind(R.id.tv_event_desc)
    TextView tvEventDesc;

    @Bind(R.id.tv_event_time)
    TextView tvEventTime;

    private EventVO mEvent;
    private EventFragment.ControllerEventItem mEventItemController;

    public EventViewHolder(View view, EventFragment.ControllerEventItem eventItemController) {
        super(view);
        ButterKnife.bind(this, view);

        view.setOnClickListener(this);
        mEventItemController = eventItemController;
    }

    public void setData(EventVO event) {
        this.mEvent = event;

        tvEventTitle.setText(event.getEventTitle());
        tvEventDesc.setText(event.getEventDesc());
        tvEventTime.setText(event.getEventTime()); //Friday, Feb 26, 1:00pm - 5:00pm

        Glide.with(ivStockPhoto.getContext())
                .load(event.getStockPhotoPath())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivStockPhoto);
    }

    @Override
    public void onClick(View view) {
        mEventItemController.onTapEvent(mEvent, ivStockPhoto);
    }
}
