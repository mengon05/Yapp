package com.yapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListActivity;
import com.yapp.utils.Category;

public class HomeActivity extends SherlockListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		List<Category> categories = new ArrayList<Category>();
		int i = 0;
		String[] options = getResources().getStringArray(R.array.options);
		categories.add(new Category(options[i++], 0, true, R.drawable.underline_grey));
		categories.add(new Category(options[i++], R.drawable.ic_launcher, true, R.drawable.underline_cyan1));
		categories.add(new Category(options[i++], R.drawable.ic_launcher, false, R.drawable.underline_cyan2));
		categories.add(new Category(options[i++], R.drawable.ic_launcher, true, R.drawable.underline_orange));
		categories.add(new Category(options[i++], R.drawable.ic_launcher, false, R.drawable.underline_red));
		categories.add(new Category(options[i++], R.drawable.ic_launcher, true, R.drawable.underline_yellow));
		categories.add(new Category(options[i++], 0, true, R.drawable.underline_grey));
		getListView().setAdapter(new HomeAdapter(getApplicationContext(), categories));
		getListView().setOnItemClickListener(this);
	}

	public static Intent newIntent(Context context) {
		Intent intent = new Intent(context, HomeActivity.class);
		return intent;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		startActivity(TabActivity.newIntent(getApplicationContext()));

	}

	private class HomeAdapter extends ArrayAdapter<Category> {

		public HomeAdapter(Context context, List<Category> objects) {
			super(context, 0, 0, objects);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.item_home, null, false);
				holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
				holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
				holder.imgFav = (ImageView) convertView.findViewById(R.id.imgFav);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			Category category = getItem(position);
			convertView.setBackgroundResource(category.getBackgroundID());
			holder.txtTitle.setText(category.getName());
			if (category.getIconID() > 0) {
				if (category.isFavorite()) {
					holder.imgFav.setImageResource(R.drawable.ic_favorite);
				} else {
					holder.imgFav.setImageResource(R.drawable.ic_unfavorite);
				}
				holder.imgIcon.setImageResource(category.getIconID());
			} else {
				holder.imgFav.setVisibility(View.INVISIBLE);
				holder.imgIcon.setVisibility(View.INVISIBLE);
			}

			return convertView;
		}

	}

	private class ViewHolder {
		ImageView imgIcon;
		TextView txtTitle;
		ImageView imgFav;
	}

}
