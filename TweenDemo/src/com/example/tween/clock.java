package com.example.tween;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class clock extends Activity {

	 private LinearLayout myClock;  
	    private draw drawClock;  
	    protected static final int MESSAGE = 123;  
	    public Handler handler;  
	    private Thread mthread;  
	    TextView tv = null;  
	    int i = 0;
	  
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        View view = this.getWindow().getDecorView(); // getDecorView  
	        view.setBackgroundDrawable(this.getResources().getDrawable(  
	                R.drawable.bg));  
	        setContentView(R.layout.main);  
	  
	        myClock = (LinearLayout) findViewById(R.id.clock);  
//	        drawClock = new draw(this);  
//	        drawView = new DrawView(this,0);
//	        myClock.addView(drawView);  
//	  
//	        handler = new Handler() {  
//	            public void handleMessage(Message mess) {  
//	                if (mess.what == clock.MESSAGE) {  
//	                    myClock.removeView(drawView);  
//	                    drawView = new DrawView(clock.this,i*1000);  
//	                    myClock.addView(drawView);  
//	                }  
//	                super.handleMessage(mess);  
//	            }  
//	        };  
//	  
//	        mthread = new myThread();  
//	        mthread.start();  
	        RotateView myView = new RotateView(this);
	        myClock.addView(myView);
	    }  
	  
	    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	    	final int action = event.getActionMasked();
	        boolean handled = false;
	        switch (action) {
	            case MotionEvent.ACTION_POINTER_DOWN:
	            case MotionEvent.ACTION_DOWN:
//	                if (DEBUG) Log.v(TAG, "*** DOWN ***");
//					stopAndHideWaveAnimation();
//	                handleDown(event);
//	                handleMove(event);
	                handled = true;
	                break;

	            case MotionEvent.ACTION_MOVE:
//	                if (DEBUG) Log.v(TAG, "*** MOVE ***");
//	                handleMove(event);
	            	System.out.println("+++++++++x:"+event.getX()+",Y:"+event.getY());
	            	
	                handled = true;
	                break;

	            case MotionEvent.ACTION_POINTER_UP:
	            case MotionEvent.ACTION_UP:
//	                if (DEBUG) Log.v(TAG, "*** UP ***");
//	                /// M: In default logic, ACTION_UP should trigger events, but ACTION_CANCEL should not.
//	                mActionCancel = false;
//	                handleMove(event);
//	                handleUp(event);
	                handled = true;
	                break;

	            case MotionEvent.ACTION_CANCEL:
//	                if (DEBUG) Log.v(TAG, "*** CANCEL ***");
//	                /// M: In default logic, ACTION_CANCLE may trigger events, but it should not.
//	                mActionCancel = true;
//	                handleMove(event);
//	                handleCancel(event);
	                handled = true;
	                break;

	        }
	        return handled ? true : super.onTouchEvent(event);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    class myThread extends Thread {  
	        public void run() {  
	            super.run();  
	            while (Thread.interrupted() == false) {  
	                try {  
	                    Thread.sleep(1000);  
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }  
	                i++;
	                Message m = new Message();  
	                m.what = clock.MESSAGE;  
	                clock.this.handler.sendMessage(m);  
	            }  
	        }  
	    }  
	    
}
