package com.voyager.barasti.activity.gestCountPage.adapter;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.gestCountPage.model.GuestCount;
import com.voyager.barasti.activity.gestCountPage.presenter.IGuestPresenter;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<GuestCount> guestCounts;
    int minteger = 0;
    Activity activity;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;
    int totalGuestCount =0;
    IGuestPresenter iGuestPresenter;
    Integer guestCount =0;

    public GuestListAdapter(List<GuestCount> guestCounts, Activity activity,int totalGuestCount,IGuestPresenter iGuestPresenter) {
        this.guestCounts = guestCounts;
        this.activity = activity;
        this.totalGuestCount = totalGuestCount;
        this.iGuestPresenter = iGuestPresenter;
    }

    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_guest_count, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivMen.setImageResource(guestCounts.get(position).getDress());
        holder.tvMenHeading.setText(guestCounts.get(position).getMenheading());

        holder.ivMenAmt.setText(guestCounts.get(position).getIntialAmt());
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("decrease : "+minteger);
                System.out.println("totalGuestCount : "+totalGuestCount);
                if(minteger>0) {
                    minteger = minteger - 1;
                    holder.tvMenIDNo.setText("" + minteger);
                }else if(minteger==0){
                    Snackbar.make(v, "Guest cant be less than zero.", Snackbar.LENGTH_SHORT).show();
                }
                guestCount = Integer.valueOf(holder.tvMenIDNo.getText().toString());
                iGuestPresenter.setCurrentGuestCount(guestCount);
            }
        });
        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("increase : "+minteger);
                System.out.println("totalGuestCount : "+totalGuestCount);
                if(minteger<totalGuestCount) {
                    minteger = minteger + 1;
                    holder.tvMenIDNo.setText("" + minteger);
                }else if(minteger==totalGuestCount){
                    Snackbar.make(v, "the Max Guest count is : "+totalGuestCount, Snackbar.LENGTH_SHORT).show();

                }
                guestCount = Integer.valueOf(holder.tvMenIDNo.getText().toString());
                iGuestPresenter.setCurrentGuestCount(guestCount);
            }
        });



    }


    @Override
    public int getItemCount() {
        return guestCounts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMenHeading;
        private TextView ivMenAmt;
        private ImageView ivMen;
        private TextView tvMenIDNo;
        private Button decrease;
        private Button increase;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMenHeading = itemView.findViewById(R.id.tvMenHeading);
            ivMenAmt = itemView.findViewById(R.id.ivMenAmt);
            ivMen = itemView.findViewById(R.id.ivMen);
            tvMenIDNo = itemView.findViewById(R.id.tvMenIDNo);
            increase = itemView.findViewById(R.id.btnMenIncrease);
            decrease = itemView.findViewById(R.id.btnMenDecrease);

        }
    }
}