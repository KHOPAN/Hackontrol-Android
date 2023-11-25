package com.khopan.hackontrolclient;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.khopan.hackontrol.Target;
import com.sec.sesl.khopan.hackontrolclient.R;

import java.util.ArrayList;
import java.util.List;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class HackontrolApplication extends AppCompatActivity {
	private final List<Target> targetList;

	private HackontrolClient client;

	public HackontrolApplication() {
		this.targetList = new ArrayList<>();
	}

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		ToolbarLayout toolbarLayout = new ToolbarLayout(this, null);
		this.setContentView(toolbarLayout);
		String title = this.getString(R.string.applicationName);
		toolbarLayout.setTitle(title, title);
		toolbarLayout.setExpanded(false, false);
		RecyclerView recyclerView = new RecyclerView(this);
		recyclerView.setLayoutParams(new ToolbarLayout.ToolbarLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		TargetAdapter adapter = new TargetAdapter(this.targetList);
		recyclerView.setAdapter(adapter);
		recyclerView.seslSetFastScrollerEnabled(true);
		recyclerView.seslSetGoToTopEnabled(true);
		recyclerView.seslSetSmoothScrollEnabled(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		toolbarLayout.addView(recyclerView);
		new Thread(() -> this.client = new HackontrolClient(this.targetList, adapter, this)).start();
	}
}
