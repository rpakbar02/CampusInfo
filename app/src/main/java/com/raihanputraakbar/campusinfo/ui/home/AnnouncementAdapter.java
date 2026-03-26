package com.raihanputraakbar.campusinfo.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.raihanputraakbar.campusinfo.databinding.ItemAnnouncementBinding;
import com.raihanputraakbar.campusinfo.model.Announcement;

import java.util.function.Consumer;

public class AnnouncementAdapter extends ListAdapter<Announcement, AnnouncementAdapter.ViewHolder> {

    private final Consumer<Announcement> onItemClick;

    public AnnouncementAdapter(Consumer<Announcement> onItemClick) {
        super(DIFF_CALLBACK);
        this.onItemClick = onItemClick;
    }

    private static final DiffUtil.ItemCallback<Announcement> DIFF_CALLBACK = new DiffUtil.ItemCallback<Announcement>() {
        @Override
        public boolean areItemsTheSame(@NonNull Announcement oldItem, @NonNull Announcement newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Announcement oldItem, @NonNull Announcement newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAnnouncementBinding binding = ItemAnnouncementBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position), onItemClick);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemAnnouncementBinding binding;

        ViewHolder(ItemAnnouncementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Announcement announcement, Consumer<Announcement> onItemClick) {
            binding.tvTitle.setText(announcement.getTitle());
            binding.tvSummary.setText(announcement.getContent());
            itemView.setOnClickListener(v -> onItemClick.accept(announcement));
        }
    }
}