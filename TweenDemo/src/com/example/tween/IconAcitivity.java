package com.example.tween;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IconAcitivity extends Activity {
	ImageView icon,icon2,icon21,icon_bg;
	Animation animator = null;
	Animation  anim2,anim21;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_icon);
		icon = (ImageView) findViewById(R.id.icon);
		icon2 = (ImageView) findViewById(R.id.icon2);
		icon21 = (ImageView) findViewById(R.id.icon21);
		icon_bg = (ImageView) findViewById(R.id.icon_bg);
		final AnimationDrawable anim = (AnimationDrawable) icon.getDrawable();
		if (!anim.isRunning()) {
			anim.start();
		}		
		icon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (anim.isRunning()) {
					anim.stop();
				}
				
			}
		});
		/*animator = AnimationUtils.loadAnimation(IconAcitivity.this, R.anim.jui_icon_anim);
		icon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//icon.startAnimation(animator);
				
			}
		});*/
		
		 anim2 = AnimationUtils.loadAnimation(IconAcitivity.this, R.anim.jui_account_anim0);
		 anim21 = AnimationUtils.loadAnimation(IconAcitivity.this, R.anim.jui_account_anim1);
		 anim2.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				icon2.setVisibility(View.GONE);
				
			}
		});
		 anim21.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				icon21.setVisibility(View.GONE);
				
			}
		});
		
		icon_bg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				icon2.setVisibility(View.VISIBLE);
				icon21.setVisibility(View.VISIBLE);
				icon2.startAnimation(anim2);
				icon21.startAnimation(anim21);
				
			}
		});
		
	}

}
