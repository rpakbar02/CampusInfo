package com.raihanputraakbar.campusinfo.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.raihanputraakbar.campusinfo.databinding.FragmentProfileBinding;
import com.raihanputraakbar.campusinfo.ui.home.AnnouncementViewModel;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private AnnouncementViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Menggunakan ViewModel yang sama dengan HomeFragment (Shared ViewModel melalui scope Activity)
        viewModel = new ViewModelProvider(requireActivity()).get(AnnouncementViewModel.class);

        viewModel.getStudentName().observe(getViewLifecycleOwner(), name -> {
            binding.tvProfileName.setText(name);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}