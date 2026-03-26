package com.raihanputraakbar.campusinfo.model;

import java.util.Objects;

public class Schedule {
    private final String day;
    private final String subject;
    private final String time;
    private final String room;

    public Schedule(String day, String subject, String time, String room) {
        this.day = day;
        this.subject = subject;
        this.time = time;
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(day, schedule.day) &&
                Objects.equals(subject, schedule.subject) &&
                Objects.equals(time, schedule.time) &&
                Objects.equals(room, schedule.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, subject, time, room);
    }
}