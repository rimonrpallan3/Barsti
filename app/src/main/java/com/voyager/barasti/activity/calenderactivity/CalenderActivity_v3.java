package com.voyager.barasti.activity.calenderactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.barasti.activity.calenderactivity.model.TimeStamp;
import com.voyager.barasti.activity.calenderactivity.pesenter.CalenderPresenter;
import com.voyager.barasti.activity.calenderactivity.pesenter.ICalenderPresenter;
import com.voyager.barasti.activity.calenderactivity.view.ICalenderView;
import com.voyager.barasti.activity.gestCountPage.GuestCountPage;
import com.voyager.barasti.activity.landingpage.LandingPage;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.custom.CalenderV3.customviews.DateRangeCalendarView;
import com.voyager.barasti.R;

import java.util.Calendar;

/**
 * Created by User on 14-Feb-19.
 */

public class CalenderActivity_v3 extends AppCompatActivity implements ICalenderView{

    private DateRangeCalendarView calendar;
    ImageView ivClose;
    TextView tvClear;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView tvStartDay;
    TextView tvStartDayNo;
    TextView tvStartMonth;
    TextView tvEndDay;
    TextView tvEndDayNo;
    TextView tvEndMonth;
    TextView tvTotalDays;
    Button btnSave;
    TimeStamp nonRangeStartDate;
    TimeStamp rangeStartDate;
    TimeStamp rangeEndDate;
    ICalenderPresenter iCalenderPresenter;
    public String currentStartDate="";
    public String currentEndDate = "";
    int propertyId=0;
    int userID=0;
    int totalGuestCount = 0;
    HomeDetails homeDetails;
    String checkIn ="";
    String checkOut = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_v3);

        Intent intent = getIntent();

        propertyId = intent.getIntExtra("propertyId",propertyId);
        userID = intent.getIntExtra("userID",userID);
        totalGuestCount = intent.getIntExtra("totalGuestCount",totalGuestCount);
        homeDetails = intent.getParcelableExtra("homeDetails");
        System.out.println("CalenderActivity_v3 totalGuestCount : "+totalGuestCount);
        calendar = findViewById(R.id.calendar);
        ivClose = findViewById(R.id.ivClose);
        tvClear = findViewById(R.id.tvClear);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDate);
        tvStartDay = findViewById(R.id.tvStartDay);
        tvStartDayNo = findViewById(R.id.tvStartDayNo);
        tvStartMonth = findViewById(R.id.tvStartMonth);
        tvEndDay = findViewById(R.id.tvEndDay);
        tvEndDayNo = findViewById(R.id.tvEndDayNo);
        tvEndMonth = findViewById(R.id.tvEndMonth);
        tvTotalDays = findViewById(R.id.tvTotalDays);
        btnSave = findViewById(R.id.btnSave);
        nonRangeStartDate = new TimeStamp();
        rangeStartDate = new TimeStamp();
        rangeEndDate = new TimeStamp();
        btnSave.setEnabled(false);
        iCalenderPresenter = new CalenderPresenter(this, this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "JosefinSans-Regular.ttf");
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "LobsterTwo-Regular.ttf");
        calendar.setFonts(typeface);

        calendar.setCalendarListener(new DateRangeCalendarView.CalendarListener() {
            @Override
            public void onFirstDateSelected(Calendar startDate) {
                currentStartDate = startDate.getTime().toString();
                Integer totalCount = 1;
                Toast.makeText(CalenderActivity_v3.this, "Start Date: " + startDate.getTime().toString(), Toast.LENGTH_SHORT).show();
                System.out.println("onFirstDateSelected Start Date : "+startDate.getTime().toString());
                nonRangeStartDate = datePrserFormater(startDate.getTime().toString());
                tvStartDay.setText(nonRangeStartDate.getDayString());
                checkIn =nonRangeStartDate.getDayNoString() + " " + nonRangeStartDate.getMonthString();
                tvStartDayNo.setText(nonRangeStartDate.getDayNoString());
                tvStartMonth.setText(nonRangeStartDate.getMonthString());
                tvEndDay.setText("");
                checkOut = nonRangeStartDate.getDayNoString() + " " + nonRangeStartDate.getMonthString();
                tvEndDayNo.setText("");
                tvEndMonth.setText("");
                tvTotalDays.setText(totalCount+" day Selected");
                if(totalCount!=null&&totalCount>0){
                    btnSave.setEnabled(true);
                }
            }

            @Override
            public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
                currentStartDate = startDate.getTime().toString();
                currentEndDate = endDate.getTime().toString();
                Toast.makeText(CalenderActivity_v3.this, "Start Date :" + startDate.getTime().toString() + " End date: " + endDate.getTime().toString(), Toast.LENGTH_SHORT).show();
                Integer totalCount = 0;
                datePrserFormater(startDate.getTime().toString());
                rangeStartDate = datePrserFormater(startDate.getTime().toString());
                datePrserFormater(endDate.getTime().toString());
                tvStartDay.setText(rangeStartDate.getDayString());
                checkIn =rangeStartDate.getDayNoString() + " " + rangeStartDate.getMonthString();
                tvStartDayNo.setText(rangeStartDate.getDayNoString());
                tvStartMonth.setText(rangeStartDate.getMonthString());
                rangeEndDate = datePrserFormater(endDate.getTime().toString());
                tvEndDay.setText(rangeEndDate.getDayString());
                checkOut = rangeEndDate.getDayNoString() + " " + rangeEndDate.getMonthString();
                tvEndDayNo.setText(rangeEndDate.getDayNoString());
                tvEndMonth.setText(rangeEndDate.getMonthString());
                totalCount = getTotalCount(rangeStartDate.getDayNoString(),rangeEndDate.getDayNoString());
                tvTotalDays.setText(totalCount+" night Selected");
                if(totalCount!=null&&totalCount>0){
                    btnSave.setEnabled(true);
                }
            }

        });

//        calendar.setNavLeftImage(ContextCompat.getDrawable(this,R.drawable.ic_left));
//        calendar.setNavRightImage(ContextCompat.getDrawable(this,R.drawable.ic_right));

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -0);
        Calendar later = (Calendar) now.clone();
        later.add(Calendar.MONTH, 3);

        calendar.setVisibleMonthRange(now,later);

        Calendar startSelectionDate = Calendar.getInstance();
        startSelectionDate.add(Calendar.MONTH, -1);
        Calendar endSelectionDate = (Calendar) startSelectionDate.clone();
        endSelectionDate.add(Calendar.DATE, 40);

        calendar.setSelectedDateRange(startSelectionDate, endSelectionDate);

        Calendar current = Calendar.getInstance();
        calendar.setCurrentMonth(current);
        calendar.resetAllSelectedViews();
    }

    public Integer getTotalCount(String startDate, String endDate){
       Integer startDateNo;
       Integer endDateNo;
       Integer totalDateCount =0;

        try {
            startDateNo = Integer.parseInt(startDate);
            endDateNo = Integer.parseInt(endDate);
            totalDateCount =(endDateNo-startDateNo);
        } catch(NumberFormatException nfe) {
            nfe.getMessage();
            nfe.printStackTrace();
        }
        return totalDateCount;
    }

    public TimeStamp datePrserFormater(String date){
        TimeStamp timeStamp = new TimeStamp();
        String[] splitStr = date.split("\\s+");
        for(int i=0;i<splitStr.length;i++) {
            String currentDate = splitStr[i];
            if(i == 0) {
                String dayString =splitStr[i];
                timeStamp.setDayString(dayString);
            }else if(i == 1){
                String monthString =splitStr[i];
                timeStamp.setMonthString(monthString);
            }else if(i == 2){
                String dayNoString =splitStr[i];
                timeStamp.setDayNoString(dayNoString);
            }else if(i == 3){
                String timeString =splitStr[i];
                timeStamp.setTimeString(timeString);
            }else if(i == 4){
                String timeZoneString =splitStr[i];
                timeStamp.setTimeZoneString(timeZoneString);
            }else if(i == 5){
                String yearString =splitStr[i];
                timeStamp.setYearString(yearString);
            }
        }
        return timeStamp;

    }

    public void btnSave(View v){
        Toast.makeText(CalenderActivity_v3.this, "Btn Clicked", Toast.LENGTH_SHORT).show();
        iCalenderPresenter.saveBookingDetails(currentStartDate,currentEndDate,propertyId,userID);
        Intent intent = new Intent(this, GuestCountPage.class);
        intent.putExtra("currentStartDate", currentStartDate);
        intent.putExtra("currentEndDate", currentEndDate);
        intent.putExtra("propertyId", propertyId);
        intent.putExtra("userID", userID);
        intent.putExtra("totalGuestCount", totalGuestCount);
        intent.putExtra("homeDetails", homeDetails);
        intent.putExtra("checkIn", checkIn);
        intent.putExtra("checkOut", checkOut);
        startActivity(intent);

    }

    public void ivCloseClick(View v){
        finish();
    }

    public void tvClearClick(View v){
        calendar.resetAllSelectedViews();
        tvStartDay.setText("");
        tvStartDayNo.setText("");
        tvStartMonth.setText("");
        tvEndDay.setText("");
        tvEndDayNo.setText("");
        tvEndMonth.setText("");
        tvTotalDays.setText("");
        btnSave.setEnabled(false);
    }
}