package com.raihanputraakbar.campusinfo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.raihanputraakbar.campusinfo.model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementViewModel extends ViewModel {
    private final MutableLiveData<List<Announcement>> announcements = new MutableLiveData<>();
    private final MutableLiveData<String> studentName = new MutableLiveData<>("Raihan Putra Akbar");

    public AnnouncementViewModel() {
        loadAnnouncements();
    }

    private void loadAnnouncements() {
        List<Announcement> list = new ArrayList<>();
        list.add(new Announcement(1, "Seminar Nasional Teknologi", "Seminar ini akan membahas tren AI di tahun 2024. Terbuka untuk seluruh mahasiswa."));
        list.add(new Announcement(2, "Pendaftaran KRS Semester Genap", "Segera lakukan pengisian KRS melalui portal akademik masing-masing mahasiswa."));
        list.add(new Announcement(3, "Lomba Inovasi Mahasiswa", "Tunjukkan ide kreatifmu dalam lomba inovasi tingkat universitas. Hadiah jutaan rupiah!"));
        list.add(new Announcement(4, "Workshop Android Development", "Belajar membuat aplikasi Android menggunakan Jetpack Component dan Java."));
        announcements.setValue(list);
    }

    public LiveData<List<Announcement>> getAnnouncements() {
        return announcements;
    }

    public LiveData<String> getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName.setValue(name);
    }
}