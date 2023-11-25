package com.khopan.hackontrolclient;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.recyclerview.widget.RecyclerView;

import com.khopan.hackontrol.Target;
import com.khopan.hackontrolclient.recyclerview.viewholder.CardViewHolder;

import java.util.List;

public class TargetAdapter extends RecyclerView.Adapter<CardViewHolder> {
	private final List<Target> targetList;

	public TargetAdapter(List<Target> targetList) {
		this.targetList = targetList;
	}

	@NonNull
	@Override
	public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return CardViewHolder.getInstance(parent.getContext());
	}

	@Override
	public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
		Target target = this.targetList.get(position);
		holder.setTitle(target.getMachineIdentifier().getIdentifier());

		if(position == 0) {
			holder.setDividerVisible(false);
			holder.setRoundedCorners(SeslRoundedCorner.ROUNDED_CORNER_TOP_LEFT | SeslRoundedCorner.ROUNDED_CORNER_TOP_RIGHT);
			return;
		} else if(position == this.targetList.size() - 1) {
			holder.setDividerVisible(true);
			holder.setRoundedCorners(SeslRoundedCorner.ROUNDED_CORNER_BOTTOM_LEFT | SeslRoundedCorner.ROUNDED_CORNER_BOTTOM_RIGHT);
			return;
		}

		holder.setDividerVisible(true);
		holder.setRoundedCorners(SeslRoundedCorner.ROUNDED_CORNER_NONE);
	}

	@Override
	public int getItemCount() {
		return this.targetList.size();
	}
}
