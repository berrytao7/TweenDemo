package com.example.tween;

import android.R.anim;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.FloatMath;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button btn1,btn2,btn3,btn4,btn5,btn6;
	ImageView img_btn4,img_btn3,img_btn2,img_btn1;
	AnimationDrawable animationDrawable;
	Animation operatingAnim;
	
	private Tweener rotateTweener;
	Animator animation2 = null;
	
	EditText editText;
	TranslateAnimation mHiddenAction,mShowAction;
	
	ImageView imageview1;
	
	Animation disAnimation;
	MaskImage imageView2;
	boolean open = false,display = false;
	
	Animation animationIn,animationIn0,animationOut,animationOut0,animList,animButton,animButton2,animButton22,animButton23;
	Animator animatorButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		
		img_btn1 = (ImageView) findViewById(R.id.img_btn1);
		img_btn2 = (ImageView) findViewById(R.id.img_btn2);
		img_btn3 = (ImageView) findViewById(R.id.img_btn3);		
		img_btn4 = (ImageView) findViewById(R.id.img_btn4);
		
		animList = AnimationUtils.loadAnimation(MainActivity.this, R.anim.jui_translation_listview);
		DecelerateInterpolator interpolatorList = new DecelerateInterpolator(1.0f);
		animList.setInterpolator(interpolatorList);
		animButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.jui_translation_button);
		animButton2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.jui_translation_button2);
		animButton22 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.jui_translation_button22);
		animButton23 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.jui_translation_button23);
		
		
		animatorButton =AnimatorInflater.loadAnimator(MainActivity.this, R.animator.jui_translation_bt);
		imageView2 = (MaskImage) findViewById(R.id.imageview_2);
		
		imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Drawable drawable = getResources().getDrawable(R.drawable.test);
				
				imageView2.updateOriginalImage(MainActivity.this, ((BitmapDrawable)drawable).getBitmap());
				
			}
		});
		
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		editText = (EditText) findViewById(R.id.edittext);

		editText.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s) {				
//				if (s.toString().length() > 10) {
//					editText.setTextSize(30);
//				} else {
//					editText.setTextSize(48);
//				}

			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

		});
		
		
		mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,     
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,     
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,     
                0.0f);   //向上移动出现
		
		mShowAction.setDuration(1000);  
		
		mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,     
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,     
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);    //向下移动消失 
		
		mHiddenAction.setDuration(1000); 
		 
		
		disAnimation = AnimationUtils.loadAnimation(this,R.anim.jui_dis);
		
		disAnimation.setAnimationListener(new AnimationListener() {
			
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
				showDialog();
			}
		});
				
		animationIn0= AnimationUtils.loadAnimation(this, R.anim.jui_view_in);
		animationOut0 = AnimationUtils.loadAnimation(this, R.anim.jui_view_out);
		animationIn= AnimationUtils.loadAnimation(this, R.anim.jui_view_in);
		animationOut = AnimationUtils.loadAnimation(this, R.anim.jui_view_out);
		DecelerateInterpolator interpolator = new DecelerateInterpolator(0.5f);
		animationIn.setInterpolator(interpolator);
		animationOut.setInterpolator(interpolator);
	}
	
	    

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
//			//3
//			img_btn3.clearAnimation();
//			//4
//			if (animationDrawable!=null) {
//				animationDrawable.stop();
//			}
//			
//			AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.2f);  
//			alphaAnimation1.setDuration(1000);  
//			alphaAnimation1.setRepeatCount(Animation.INFINITE);  
//			alphaAnimation1.setRepeatMode(Animation.REVERSE);  
//			img_btn1.setAnimation(alphaAnimation1);  
//			alphaAnimation1.start();  
			
//			Intent intent = new Intent(MainActivity.this, MyDrawActivity.class);
//			startActivity(intent);	
			
//			Animator animatorcc = AnimatorInflater.loadAnimator(this, R.animator.cc);
//			animatorcc.setTarget(img_btn1);
//			animatorcc.start();
			
			showDialog();
//			if (imageview1.getVisibility()==View.GONE || imageview1.getVisibility()==View.INVISIBLE) {
//				//imageview1.startAnimation(mShowAction);
//				
//				img_btn2.startAnimation(animationIn0);
//				img_btn2.setVisibility(View.VISIBLE);
//				
//				imageview1.startAnimation(animationIn);
//				imageview1.setVisibility(View.VISIBLE);
//				
//				
//				
//			}else {
////				imageview1.startAnimation(mHiddenAction);
//				//imageview1.startAnimation(disAnimation);
//				
//				img_btn2.startAnimation(animationOut0);
//				img_btn2.setVisibility(View.GONE);
//				
//				imageview1.startAnimation(animationOut);				
//				imageview1.setVisibility(View.GONE);
//				
//				
//				
//				
//			}
			
			
			break;

		case R.id.btn2:
			//1
			img_btn1.clearAnimation();
			//4
			if (animationDrawable!=null) {
				animationDrawable.stop();
			}
//			Intent intent = new Intent(MainActivity.this, Tween2Activity.class);
//			startActivity(intent);
			
			
			
//			operatingAnim = AnimationUtils.loadAnimation(this, R.anim.anim3);  
//			operatingAnim.reset();
//			operatingAnim.setFillAfter(false);//设置动画完毕是否回到初始位置，true为不回到初始位置
//			img_btn2.startAnimation(operatingAnim);
			
			animation2 = AnimatorInflater.loadAnimator(this, R.animator.bb);
			animation2.setTarget(img_btn2);
			animation2.start();
			
			break;
		case R.id.btn3:
			
			//1
			img_btn1.clearAnimation();
			//4
			if (animationDrawable!=null) {
				animationDrawable.stop();
			}
			if (animation2!=null) {
				animation2.setupStartValues();
				animation2.cancel();
			}
			
			
			operatingAnim = AnimationUtils.loadAnimation(this, R.anim.anim31);  
//			LinearInterpolator lin = new LinearInterpolator();  
//			operatingAnim.setInterpolator(lin);  
//			if (operatingAnim!=null) {
//				img_btn3.startAnimation(operatingAnim);
//			}
			
			
//			operatingAnim.reset();
//			operatingAnim.setFillAfter(true);//设置动画完毕是否回到初始位置，true为不回到初始位置
//			img_btn3.startAnimation(operatingAnim);
//			
//			ImageView imageView = new ImageView(getApplicationContext());
//			imageView.setId(R.id.btn3);
			
			Animator animation = AnimatorInflater.loadAnimator(this, R.animator.aa);
			animation.setTarget(img_btn3);
			animation.start();
			System.out.println("================berrytao,start,"+animation.isRunning());
			
			break;
		case R.id.btn4:
			//1
			img_btn1.clearAnimation();
			//3
			img_btn3.clearAnimation();
			img_btn4.setImageResource(R.drawable.anim4);  
            animationDrawable = (AnimationDrawable) img_btn4.getDrawable();  
            animationDrawable.start();  
			break;
		case R.id.btn5:
			Animation rotatAnimation1 = AnimationUtils.loadAnimation(this, R.anim.jui_view_rotation_anticlockwise_90);
			Animation rotatAnimation2 = AnimationUtils.loadAnimation(this, R.anim.jui_view_rotation_clockwise_90);
			if (open) {
				open = false;
				btn5.startAnimation(rotatAnimation2);
			}else {
				open = true;
				btn5.startAnimation(rotatAnimation1);
			}
			break;
		case R.id.btn6:
			Animation rotatAnimation3 = AnimationUtils.loadAnimation(this, R.anim.jui_view_rotation_clockwise_180);
			Animation rotatAnimation4 = AnimationUtils.loadAnimation(this, R.anim.jui_view_rotation_anticlockwise_180);
			if (display) {
				display = false;
				btn6.startAnimation(rotatAnimation4);
			}else {
				display = true;
				btn6.startAnimation(rotatAnimation3);
			}
			
			
			break;
		}
		
	}
	
	
	
	private void showDialog(){
//AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Translucent);//
//		
//		View view = LayoutInflater.from(this).inflate(R.layout.jui_dialog_msg, null);
//		ListView lView = (ListView) view.findViewById(R.id.jui_msg_list);
//		Button btn1 = (Button) view.findViewById(R.id.jui_btn_cancel);
//		Button btn2 = (Button) view.findViewById(R.id.jui_btn_huifu);
//		
//		builder.setView(view);
//		final Dialog  dialog = builder.create();
		
		final AlertDialog dialog = new AlertDialog.Builder(this,android.R.style.Theme_Translucent).create();
		 Window window = dialog.getWindow();
		 window.setGravity(Gravity.BOTTOM|Gravity.CENTER);
		 // window.setWindowAnimations(R.style.jui_dialog_message_style);  //添加动画   
		dialog.show();
//		 
//		dialog.getWindow().setContentView(view);
		
//		final Dialog dialog = new Dialog(this,android.R.style.Theme_Translucent);
//		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		
		dialog.getWindow().setContentView(R.layout.jui_dialog_msg);
		ListView lView = (ListView) dialog.getWindow().findViewById(R.id.jui_msg_list);
		ImageView footView = new ImageView(MainActivity.this);
		footView.setBackgroundColor(getResources().getColor(R.color.list_divider));
		lView.addFooterView(footView);
		
		LayoutAnimationController controller = new LayoutAnimationController(animList);
//		lView.setLayoutAnimation(controller);
		//android.R.layout.simple_list_item_1, android.R.id.text1
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.jui_dialog_msg_list_item,R.id.jui_list_item_text ,new String[]{"hhhhhhhhhhhhh","ssssss","ffffff"});
		lView.setAdapter(adapter);
		
		Button btn1 = (Button) dialog.getWindow().findViewById(R.id.jui_btn_cancel);
		Button btn2 = (Button) dialog.getWindow().findViewById(R.id.jui_btn_huifu);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				
			}
		});

		
		final LinearLayout layout1 = (LinearLayout) dialog.getWindow().findViewById(R.id.jui_layout_cancel);
		final LinearLayout layout2 = (LinearLayout) dialog.getWindow().findViewById(R.id.jui_layout_huifu);
		
		layout1.startAnimation(animButton2);//animButton
//		layout2.startAnimation(animButton);
		layout2.startAnimation(animButton2);
		layout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				
			}
		});
		layout2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				
			}
		});
		
		animButton2.setAnimationListener(new AnimationListener() {
			
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
				layout1.startAnimation(animButton22);
				layout2.startAnimation(animButton22);
				
			}
		});
		
		animButton22.setAnimationListener(new AnimationListener() {
			
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
				layout1.startAnimation(animButton23);
				layout2.startAnimation(animButton23);
				
			}
		});
		
		
		
	}
}
