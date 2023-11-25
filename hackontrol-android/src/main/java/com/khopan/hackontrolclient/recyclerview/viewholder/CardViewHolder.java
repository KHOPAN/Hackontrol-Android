package com.khopan.hackontrolclient.recyclerview.viewholder;

import android.content.Context;
import android.view.ViewGroup;

import com.khopan.api.common.card.CardView;
import com.sec.sesl.khopan.hackontrolclient.R;

import dev.oneuiproject.oneui.widget.RoundLinearLayout;

public class CardViewHolder extends ViewHolder {
	private final RoundLinearLayout linearLayout;
	private final CardView cardView;

	public CardViewHolder(RoundLinearLayout linearLayout, CardView cardView) {
		super(linearLayout);
		this.linearLayout = linearLayout;
		this.cardView = cardView;
	}

	public void setTitle(String title) {
		this.cardView.setTitle(title);
	}

	public void setSummary(String summary) {
		this.cardView.setSummary(summary);
	}

	public void setDividerVisible(boolean visible) {
		this.cardView.setDividerVisible(visible);
	}

	public void setRoundedCorners(int corners) {
		this.linearLayout.setRoundedCorners(corners);
	}

	public static CardViewHolder getInstance(Context context) {
		RoundLinearLayout linearLayout = new RoundLinearLayout(context);
		linearLayout.setOrientation(RoundLinearLayout.VERTICAL);
		linearLayout.setBackgroundColor(context.getColor(R.color.oui_background_color));
		CardView cardView = new CardView(context);
		cardView.setLayoutParams(new RoundLinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		linearLayout.addView(cardView);
		return new CardViewHolder(linearLayout, cardView);
	}
}
