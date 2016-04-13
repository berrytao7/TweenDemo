package com.example.tween;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDrawView extends View {
	
	TargetDrawable firstDrawable;
	Tweener firstTweener;
	
	TargetDrawable f1Drawable,f2Drawable;
	TargetDrawable loadDrawable1,loadDrawable2,loadDrawable3;
	
	
	Tweener loadTweener1,loadTweener2,loadTweener3;

	public MyDrawView(Context context) {
		super(context);
		
	}
	
	
	
	public MyDrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Resources res = getResources();
		firstDrawable = new TargetDrawable(res, R.drawable.jieting_all);
		f1Drawable = new TargetDrawable(res, R.drawable.jui_ic_in_call_touch_handle_normal);
		
		loadDrawable1 = new TargetDrawable(res, R.drawable.jui_loading_jiantou);
		loadDrawable2 = new TargetDrawable(res, R.drawable.jui_loading_jiantou);
		loadDrawable3 = new TargetDrawable(res, R.drawable.jui_loading_jiantou);
		
		
	}



	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		
		firstDrawable.setX(300);
		firstDrawable.setY(600);
		f1Drawable.setX(300);
		f1Drawable.setY(300);
		
		loadDrawable1.setX(200);
		loadDrawable1.setY(300);
		loadDrawable2.setX(215);
		loadDrawable2.setY(300);
		loadDrawable3.setX(230);
		loadDrawable3.setY(300);
		
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		firstDrawable.draw(canvas);
//		f1Drawable.draw(canvas);
		
		loadDrawable1.draw(canvas);
		loadDrawable2.draw(canvas);
		loadDrawable3.draw(canvas);
	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		if (event.getAction()==MotionEvent.ACTION_DOWN) {
//			stopAnim();
//		}
//		return super.onTouchEvent(event);
//	}
	public void startAnim(){
//		firstTweener = Tweener.rotateAnim(firstDrawable, 1.0f, 0.0f);
//		firstTweener.animator.start();
		
		loadTweener1 = Tweener.alphaAnim3(loadDrawable1, 0, 1000, 0.0f, 0.5f, 1.0f);
		loadTweener2 = Tweener.alphaAnim3(loadDrawable2, 0, 1000, 0.0f, 0.5f, 1.0f);
		loadTweener3 = Tweener.alphaAnim3(loadDrawable3, 0, 1000, 0.0f, 0.5f, 1.0f);
		
		loadTweener1.animator.start();
		loadTweener2.animator.start();
		loadTweener3.animator.start();
		System.out.println("=================ehllo");
	}
	
	public void stopAnim(){
//		firstTweener.animator.cancel();
		loadTweener1.animator.cancel();
		loadTweener2.animator.cancel();
		loadTweener3.animator.cancel();
	}
	

}
