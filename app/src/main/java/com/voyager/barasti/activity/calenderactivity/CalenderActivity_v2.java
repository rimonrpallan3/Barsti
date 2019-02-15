package com.voyager.barasti.activity.calenderactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.custom.CalenderLib2.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by User on 11-Feb-19.
 */

public class CalenderActivity_v2 extends AppCompatActivity {

    Activity activity;
    Toolbar toolbar;
    RecyclerView events_recyclerview;
    CalendarPickerView calendar;
    Button button;
    //Faith_Church_Events_Adapter events_adapter;
    int lastNo;
    String startDate;
    String endDate;
    ImageView ivClose;
    TextView tvClear;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView tvTotalDays;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_v2);

        Intent intent = getIntent();
        //church_id = intent.getStringExtra("church_id");
        ivClose = findViewById(R.id.ivClose);
        tvClear = findViewById(R.id.tvClear);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDate);
        tvTotalDays = findViewById(R.id.tvTotalDays);
        btnProceed = findViewById(R.id.btnProceed);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.clearSelectedDates();
            }
        });

        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 0);
        nextYear.add(Calendar.MONTH,2);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -0);



        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        button = (Button) findViewById(R.id.get_selected_dates);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        //calendar.deactivateDates(list);
        ArrayList<Date> arrayList = new ArrayList<>();
        try {
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c);

            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            String strdate = formattedDate;
            String strdate2 = "01-2-2019";
            Date newdate = dateformat.parse(strdate);
            Date newdate2 = dateformat.parse(strdate2);
            arrayList.add(newdate);
            arrayList.add(newdate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.init(lastYear.getTime(), nextYear.getTime() ) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDate(new Date())
                .withHighlightedDates(arrayList);

        calendar.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
            @Override
            public boolean onCellClicked(Date date) {
                lastNo = calendar.getSelectedDates().size()-1;
                String setDate = String.valueOf(date.getDate());
                System.out.println("Date set : "+setDate);
                System.out.println("Date list : "+calendar.getSelectedDates().toString());
                if(calendar.getSelectedDates().size()>1){
                    tvEndDate.setText(date.getDate() + " "+ date.getMonth());
                }else {
                    if(date!=null) {
                        tvStartDate.setText(""+date.getDate());
                        tvEndDate.setText("");
                    }
                }
                Toast.makeText(getApplicationContext(),"Date : "+calendar.getSelectedDates().toString(),Toast.LENGTH_LONG).show();
                System.out.println("Date : "+calendar.getSelectedDates().toString());
                System.out.println("Date set : "+date.getDate());
                for(int i=0;i<=calendar.getSelectedDates().size();i++){
                    if(i==0) {
                        startDate = calendar.getSelectedDates().get(i).toString();
                        System.out.println("startDate : "+startDate);
                    }else if(i==lastNo){
                        endDate = calendar.getSelectedDates().get(i).toString();
                        System.out.println("endDate : "+endDate);
                    }
                }
             /*   if(startDate!=null) {
                    tvStartDate.setText(startDate);
                }else {
                    tvStartDate.setText("");
                }
                if(endDate!=null) {
                    tvEndDate.setText(endDate);
                }else {
                    tvEndDate.setText("");
                }*/
                return false;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("list",  calendar.getSelectedDates().toString());

                //calendar.clearSelectedDates();
            }
        });


    }
}
