package com.khopan.hackontrolclient;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.khopan.hackontrol.Target;
import com.khopan.hackontrol.target.TargetListener;

import java.util.List;

public class ConnectionListener implements TargetListener {
	private final List<Target> targetList;
	private final RecyclerView.Adapter<?> adapter;
	private final Activity activity;

	public ConnectionListener(List<Target> targetList, RecyclerView.Adapter<?> adapter, Activity activity) {
		this.targetList = targetList;
		this.adapter = adapter;
		this.activity = activity;
	}

	@Override
	public void onTargetConnected(Target target) {
		this.activity.runOnUiThread(() -> {
			int index = this.targetList.size();
			this.targetList.add(target);
			this.targetList.add(target);
			this.targetList.add(target);
			this.targetList.add(target);
			this.adapter.notifyItemRangeInserted(index, 4);
		});
	}

	@Override
	public void onTargetDisconnected(Target target) {
		this.activity.runOnUiThread(() -> {
			int index = this.targetList.indexOf(target);

			if(index < 0) {
				return;
			}

			this.targetList.remove(index);
			this.adapter.notifyItemRemoved(index);
		});
	}
}
