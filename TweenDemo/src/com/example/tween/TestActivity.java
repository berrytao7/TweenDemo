package com.example.tween;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TestActivity extends Activity {
	ImageView imageView;
	Button button,button2;
	Animation animation,animation2;
	MyAdapter myAdapter;
	ListView mListView;
	ArrayList<String> mStrings = new ArrayList<String>();
	int count = 0;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_test);
		imageView = (ImageView) findViewById(R.id.imageview);
		button = (Button) findViewById(R.id.button);
		button2 = (Button) findViewById(R.id.button2);
		mListView = (ListView) findViewById(R.id.mylist);
		myAdapter = new MyAdapter(mStrings);
		mListView.setAdapter(myAdapter);
		animation = AnimationUtils.loadAnimation(TestActivity.this, R.anim.list_occur);	
		animation2 = AnimationUtils.loadAnimation(TestActivity.this, R.anim.list_hide);
		animation2.setFillEnabled(true);
		animation2.setFillAfter(true);
		animation.setFillEnabled(true);
		animation.setFillAfter(true);
		animation2.setAnimationListener(new AnimationListener() {
			
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
				imageView.startAnimation(animation);
				
			}
		});
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				imageView.setVisibility(View.VISIBLE);
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				imageView.setVisibility(View.INVISIBLE);
//				imageView.startAnimation(animation);
				addData();
				refreshList();
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mStrings.clear();
				count = 0;
				myAdapter.notifyDataSetChanged();
				
			}
		});
	}
	
	private void addData(){
		count ++ ;
		mStrings.add("第"+count+"个TextView");
	}
	
	private void refreshList(){
		myAdapter.notifyDataSetChanged();
	}
	
	public class MyAdapter extends BaseAdapter{	
		ArrayList<String> mList;
		public MyAdapter(ArrayList<String> mList) {
			this.mList = mList;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			if (convertView==null) {
				convertView = getLayoutInflater().inflate(R.layout.test_list_item, null);
			}
			TextView tView = (TextView) convertView.findViewById(R.id.text);
			if (mList!=null && mList.size()>0) {
				tView.setText(mList.get(position).toString());
			}
			return convertView;
		}
		
	}

}
