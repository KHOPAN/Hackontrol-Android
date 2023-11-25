package com.khopan.hackontrolclient;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.khopan.hackontrol.Hackontrol;
import com.khopan.hackontrol.Target;

import java.util.List;

public class HackontrolClient {
	private final Hackontrol hackontrol;

	public HackontrolClient(List<Target> targetList, RecyclerView.Adapter<?> adapter, Activity activity) {
		this.hackontrol = new Hackontrol();
		this.hackontrol.setTargetListener(new ConnectionListener(targetList, adapter, activity));
	}
}
