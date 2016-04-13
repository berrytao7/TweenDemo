package com.example.tween;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.Button;

public class MyDrawActivity extends Activity {
	MyDrawView myDrawView;
	Button btn_start,btn_stop;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_draw);
		myDrawView = (MyDrawView) findViewById(R.id.myView);
//		myDrawView.startAnim();
//		
//		ViewPropertyAnimator  anim = myDrawView.animate();
//		anim.setDuration(5000);
////		anim.x(50f).y(100f).alpha(0.0f).start();//移动消失
////		anim.rotation(90f).alpha(0.0f).start();//绕图像中心旋转90度消失
////		anim.scaleX(1f).scaleY(2f).alpha(0.0f).start();//x方向放大1倍（即不变）,y方向放大2倍消失  图片会实际放大至x倍
////		anim.scaleX(1.2f).scaleY(1.2f).alpha(0.0f).start();
//		
////		anim.scaleXBy(0.5f).scaleYBy(0.5f).alpha(0.0f).start();//放大,图片会实际放大至x倍，下次使用时是放大后的效果
//		anim.scaleX(0.5f).scaleY(0.5f).alpha(0.0f).start();//缩小
//		anim.cancel();
		
		
		btn_start = (Button) findViewById(R.id.btn_start);
		btn_stop = (Button) findViewById(R.id.btn_stop);
		
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				myDrawView.startAnim();
			}
		});
		
		btn_stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				myDrawView.stopAnim();
			}
		});
		
	}

}
