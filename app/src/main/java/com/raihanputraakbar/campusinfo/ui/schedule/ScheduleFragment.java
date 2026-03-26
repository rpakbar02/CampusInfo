package com.raihanputraakbar.campusinfo.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.raihanputraakbar.campusinfo.databinding.FragmentScheduleBinding;
import com.raihanputraakbar.campusinfo.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private FragmentScheduleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScheduleAdapter adapter = new ScheduleAdapter();
        binding.rvSchedules.setAdapter(adapter);

        adapter.submitList(getDummySchedules());
    }

    private List<Schedule> getDummySchedules() {
        List<Schedule> list = new ArrayList<>();
        list.add(new Schedule("Senin", "Pemrograman Perangkat Bergerak", "08:00 - 10:30", "Lab Komputer 1"));
        list.add(new Schedule("Senin", "Kecerdasan Buatan", "13:00 - 15:30", "Ruang 3.02"));
        list.add(new Schedule("Selasa", "Keamanan Siber", "08:00 - 10:30", "Ruang 4.01"));
        list.add(new Schedule("Rabu", "Etika Profesi", "10:00 - 12:00", "Ruang 2.05"));
        list.add(new Schedule("Kamis", "Manajemen Proyek TI", "08:00 - 10:30", "Ruang 3.01"));
        list.add(new Schedule("Jumat", "Workshop Pengembangan App", "13:30 - 16:00", "Lab Komputer 2"));
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}