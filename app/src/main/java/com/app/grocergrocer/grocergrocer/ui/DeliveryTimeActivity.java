package com.app.grocergrocer.grocergrocer.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.DeliveryTimeAdapter;
import com.app.grocergrocer.grocergrocer.models.DeliverySlot;
import com.p_v.flexiblecalendar.FlexibleCalendarView;
import com.p_v.flexiblecalendar.view.BaseCellView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DeliveryTimeActivity extends AppCompatActivity implements
        FlexibleCalendarView.OnMonthChangeListener, FlexibleCalendarView.OnDateClickListener, View.OnClickListener {

    private static final String MONTHS[] = new DateFormatSymbols(Locale.getDefault()).getMonths();

    private FlexibleCalendarView calendarView;
    private Toolbar toolbar;
    private int currentMonth;
    private int currentYear;
    private int today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_time);

        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH);
        currentYear = calendar.get(Calendar.YEAR);
        today = calendar.get(Calendar.DAY_OF_MONTH);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(MONTHS[currentMonth] + " " + today + ", " + currentYear);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendarView = (FlexibleCalendarView) findViewById(R.id.calendar_view);

        calendarView.setCalendarView(new FlexibleCalendarView.CalendarView() {
            @SuppressWarnings("InflateParams")
            @Override
            public BaseCellView getCellView(int position, View convertView, ViewGroup parent, int cellType) {
                BaseCellView view = (BaseCellView) convertView;

                if (view == null) {
                    view = (BaseCellView) getLayoutInflater().inflate(R.layout.calendar_day, null);
                }
                if (cellType == BaseCellView.TODAY) {
                    view.setTextColor(0xde000000);
                } else {
                    view.setTextColor(-1);
                }

                return view;
            }

            @SuppressLint("InflateParams")
            @Override
            public BaseCellView getWeekdayCellView(int position, View convertView, ViewGroup parent) {
                BaseCellView view = (BaseCellView) convertView;

                if (view == null) {
                    view = (BaseCellView) getLayoutInflater().inflate(R.layout.calendar_week, null);
                }

                return view;
            }

            @Override
            public String getDayOfWeekDisplayValue(int dayOfWeek, String defaultValue) {
                return String.valueOf(defaultValue.charAt(0));
            }
        });
        calendarView.requestLayout();
        calendarView.setDisableAutoDateSelection(true);
        calendarView.setOnDateClickListener(this);
        calendarView.setOnMonthChangeListener(this);

        List<DeliverySlot> deliverySlotList = new ArrayList<>();
        deliverySlotList.add(new DeliverySlot("7am - 8am"));
        deliverySlotList.add(new DeliverySlot("8am - 9am"));
        deliverySlotList.add(new DeliverySlot("9am - 10am"));
        deliverySlotList.add(new DeliverySlot("10am - 11am"));
        deliverySlotList.add(new DeliverySlot("11am - 12pm"));
        deliverySlotList.add(new DeliverySlot("12pm - 1pm"));
        deliverySlotList.add(new DeliverySlot("1pm - 2pm"));
        deliverySlotList.add(new DeliverySlot("2pm - 3pm"));
        deliverySlotList.add(new DeliverySlot("3pm - 4pm"));
        deliverySlotList.add(new DeliverySlot("4pm - 5pm"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new DeliveryTimeAdapter(deliverySlotList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button btnReviewOrder = (Button) findViewById(R.id.btn_review_order);

        btnReviewOrder.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_delivery_time, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_calendar_go_to_today:
                if (calendarView.isShown()) {
                    calendarView.goToCurrentDay();
                    toolbar.setTitle(MONTHS[currentMonth] + " " + today + ", " + currentYear);
                }
                return true;
            case R.id.action_collapse_calendar:
                if (calendarView.isShown()) {
                    calendarView.collapse();
                } else {
                    calendarView.expand();
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateClick(int year, int month, int day) {
        toolbar.setTitle(MONTHS[month] + " " + day + ", " + year);
    }

    @Override
    public void onMonthChange(int year, int month, int direction) {
        calendarView.selectDate(year, month, 0);
        toolbar.setTitle(MONTHS[month] + " " + year);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_review_order:
                Intent intent = new Intent(this, ReviewOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}