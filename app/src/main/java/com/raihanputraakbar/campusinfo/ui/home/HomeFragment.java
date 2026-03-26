package com.raihanputraakbar.campusinfo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.raihanputraakbar.campusinfo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AnnouncementViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(AnnouncementViewModel.class);

        AnnouncementAdapter adapter = new AnnouncementAdapter(announcement -> {
            HomeFragmentDirections.ActionNavigationHomeToAnnouncementDetailFragment action =
                    HomeFragmentDirections.actionNavigationHomeToAnnouncementDetailFragment(
                            announcement.getTitle(), announcement.getContent());
            Navigation.findNavController(view).navigate(action);
        });

        binding.rvAnnouncements.setAdapter(adapter);

        viewModel.getAnnouncements().observe(getViewLifecycleOwner(), adapter::submitList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}