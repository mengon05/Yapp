package com.yapp.fragment;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.yapp.R;
import com.yapp.utils.LoremIpsum;

public class ChannelFragment extends SherlockFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.simple_list, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ListView listView = (ListView) view.findViewById(android.R.id.list);
		listView.setAdapter(new ChannelAdapter(getActivity(), LoremIpsum.createList(10)));

	}

	private class ChannelAdapter extends ArrayAdapter<LoremIpsum> {

		public ChannelAdapter(Context context, List<LoremIpsum> objects) {
			super(context, 0, objects);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LoremIpsum lorem = getItem(position);
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (lorem.isOrangeThing()) {
				ViewHolder holder;
				if (convertView == null) {

					holder = new ViewHolder();
					convertView = inflater.inflate(R.layout.item_channel, null, false);
					holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
					holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
					holder.txtDetail = (TextView) convertView.findViewById(R.id.txtDetail);
					convertView.setTag(holder);
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.txtTitle.setText(lorem.getText1());
				holder.txtDetail.setText(lorem.getText2());
			} else {
				convertView = inflater.inflate(R.layout.item_orange_thing, null, false);
			}
			return convertView;
		}

		@Override
		public int getViewTypeCount() {
			return 2;
		}

		@Override
		public int getItemViewType(int position) {
			return getItem(position).isOrangeThing() ? 0 : 1;
		}

	}

	private class ViewHolder {
		ImageView imgIcon;
		TextView txtTitle;
		TextView txtDetail;
	}

}
