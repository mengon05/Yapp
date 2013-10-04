package com.yapp;

import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void facebookLogin(View view){
		startActivity(HomeActivity.newIntent(getApplicationContext()));
	}
	
	public void twitterLogin(View view){
		startActivity(HomeActivity.newIntent(getApplicationContext()));

	}
	
	public void noLogin(View view){
		startActivity(HomeActivity.newIntent(getApplicationContext()));
	}
}
