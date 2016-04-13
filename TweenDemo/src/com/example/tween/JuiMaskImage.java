package com.example.tween;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.widget.ImageView;

public class JuiMaskImage extends ImageView {

	public JuiMaskImage(Context context) {
		super(context);
		defaultImage();
	}
		

	public JuiMaskImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		defaultImage();
	}

	public void defaultImage(){
		// 获取图片的资源文件
		Bitmap original = BitmapFactory.decodeResource(getResources(),
				R.drawable.test);
		// 获取遮罩层图片
		Bitmap mask = BitmapFactory.decodeResource(getResources(),
				R.drawable.picture_unknown);
		Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(),
				Config.ARGB_8888);
		// 将遮罩层的图片放到画布中
		Canvas mCanvas = new Canvas(result);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
		mCanvas.drawBitmap(original, 0, 0, null);
		mCanvas.drawBitmap(mask, 0, 0, paint);
		paint.setXfermode(null);
		setImageBitmap(result);
		setScaleType(ScaleType.CENTER);
	}


	public void updateOriginalImage(Context context, Bitmap original) {
		
		// 获取遮罩层图片
		Bitmap mask = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.picture_unknown);
		Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(),
				Config.ARGB_8888);
		// 将遮罩层的图片放到画布中
		Canvas mCanvas = new Canvas(result);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
		mCanvas.drawBitmap(original, 0, 0, null);
		mCanvas.drawBitmap(mask, 0, 0, paint);
		paint.setXfermode(null);
		setImageBitmap(result);
		setScaleType(ScaleType.CENTER);
	}
	
	
	private Bitmap ZoomImage(Bitmap original,int width,int height){

		int w = original.getWidth();
		int h = original.getHeight();
		Matrix matrix = new Matrix();
		float scaleWidth = ((float) width / w);
		float scaleHeight = ((float) height / h);
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbmp = Bitmap.createBitmap(original, 0, 0, w, h, matrix, true);
		if (newbmp!=null) {
			return newbmp;
		}
		return original;
		
	}

}
