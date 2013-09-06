package com.clonemate.resurrdect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] mobileValues;

	public ImageAdapter(Context context, String[] mobileValues) {
		this.context = context;
		this.mobileValues = mobileValues;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.menu, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(mobileValues[position]);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String mobile = mobileValues[position];

			if (mobile.equals("Settings")) {
				imageView.setImageResource(R.drawable.settings);
			} else if (mobile.equals("Help")) {
				imageView.setImageResource(R.drawable.help);
			} else if (mobile.equals("SMS")) {
				imageView.setImageResource(R.drawable.sms);
			}
			else if (mobile.equals("Calendar")) {
				imageView.setImageResource(R.drawable.calendar);
				}
			else {
				imageView.setImageResource(R.drawable.beer);
			}

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}


	public int getCount() {
		return mobileValues.length;
	}

	
	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

}
