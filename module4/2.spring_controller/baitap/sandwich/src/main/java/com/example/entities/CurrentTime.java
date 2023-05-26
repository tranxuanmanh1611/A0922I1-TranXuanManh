package com.example.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
    Date date;
    SimpleDateFormat a = new SimpleDateFormat("h:mm a");
    Date lunchTime;
    public CurrentTime() throws ParseException {
        lunchTime = new Date();
        date = new Date();
        lunchTime  =a.parse("12:00 AM");
        date = a.parse(date.toString());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
