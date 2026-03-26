package com.raihanputraakbar.campusinfo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.raihanputraakbar.campusinfo.databinding.FragmentAnnouncementDetailBinding;

public class AnnouncementDetailFragment extends Fragment {

    private FragmentAnnouncementDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            AnnouncementDetailFragmentArgs args = AnnouncementDetailFragmentArgs.fromBundle(getArguments());
            binding.tvDetailTitle.setText(args.getAnnouncementTitle());
            binding.tvDetailContent.setText(args.getAnnouncementContent());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}