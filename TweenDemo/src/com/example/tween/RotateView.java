package com.example.tween;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class RotateView extends View {
	
	TargetDrawable targetDrawable;

	public RotateView(Context context) {
		super(context);
		targetDrawable = new TargetDrawable(context.getResources(), R.drawable.jui_ic_lockscreen_decline_normal);
		targetDrawable.setAlpha(1.0f);
		targetDrawable.setPositionX(200);
		targetDrawable.setPositionY(400);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		targetDrawable.draw(canvas);
	}

}
