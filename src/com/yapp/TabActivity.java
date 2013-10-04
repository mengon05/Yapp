package com.yapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitlePageIndicator.IndicatorStyle;
import com.yapp.fragment.ChannelFragment;

public class TabActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_tabs);
		FragmentPagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		indicator.setFooterIndicatorStyle(IndicatorStyle.Triangle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.tab, menu);
		return true;
	}
	public static Intent newIntent(Context context){
		Intent intent = new Intent(context, TabActivity.class);
		return intent;
	}
	private class PagerAdapter extends FragmentPagerAdapter {
		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new ChannelFragment();
			case 1:
				return new ChannelFragment();
			case 2:
				return new ChannelFragment();
			default:
				return new Fragment();
			}

		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return "Populares";
			case 1:
				return "Mis Canales";
			case 2:
				return "Recomendados";
			default:
				return "wut";
			}
		}

		@Override
		public int getCount() {
			return 3;
		}
	}

}
