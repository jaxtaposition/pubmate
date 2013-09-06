package com.clonemate.resurrdect;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewActivity extends MainActivity {

	    static final int PUB0_DIALOG_ID = 0;
	    static final int PUB1_DIALOG_ID = 1;
	    static final int PUB2_DIALOG_ID = 2;
	    static final int PUB3_DIALOG_ID = 3;
	    

		/**
		 * An activity that shows a single image and the topic title associated with it.
		 * Touching the image or the title takes you to a view of the topic's text.
		 * 
		 */

		@Override
		protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.demo_pager_grid_item);
		    Intent in = getIntent ();
		    int index = in.getIntExtra("index",0);

		    TopicList tlist = TopicList.getInstance ();
		    int imageId = tlist.getTopicImage (index);
		    String title = tlist.getTopicTitle (index);

		    TextView tv = (TextView) findViewById(R.id.title);
		    if (tv != null) {
		       tv.setText (title);
		       tv.setTag (index);
		       tv.setOnClickListener(new OnClickListener() {
		            public void onClick(View v) {
		                onClickTitle (v);
		            }
		       });
		    }

		    ImageView iv = (ImageView) findViewById(R.id.pubinfoimage);
		    if (iv != null) {
		       iv.setTag (index);
		       //iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		       iv.setBackgroundResource (R.color.background_grid1_cell);
		       //iv.setPadding(8, 8, 8, 8);
		       iv.setImageResource (imageId);
		       iv.setOnClickListener(new OnClickListener() {
		            public void onClick(View v) {
		                onClickImage (v);
		            }
		       });
		    }

		}

		/**
		 * Handle the click of the image being displayed.
		 * 
		 */

		/*public static class MyAlertDialogFragment extends DialogFragment {

		    public static MyAlertDialogFragment newInstance(int index) {
		        MyAlertDialogFragment frag = new MyAlertDialogFragment();
		       // Bundle args = new Bundle();
		        //args.putInt("title", title);
		        //frag.setArguments(args);
		        return frag;
		    }
		
		
		}*/
		
		public void onClickImage (View v)
		{
		   Integer index = (Integer) v.getTag ();
		  
		   showDialog(index);
		   
		
		   
		 
		   
		} // end onClickImage

		/**
		 * Handle the click of the image being displayed.
		 * 
		 */

		public void onClickTitle (View v)
		{
		   Integer index = (Integer) v.getTag ();
		   showDialog (index);
		} // end onClickTitle

		/**
		 * Show the topic indicated by the index number.
		 * 
		 */

		public void showTopic (int index) {

		    Intent intent = new Intent(this.getApplicationContext(), TopicActivity.class);
		    intent.putExtra ("index", index);
		    startActivity (intent);

		}

		@Override
			protected Dialog onCreateDialog(int id) {
				
				 switch (id)
					{
					case PUB0_DIALOG_ID:
						 
						
						return new AlertDialog.Builder(this)
						.setIcon(R.drawable.beer)
						.setTitle("This is a dialog with prices...")
						.setPositiveButton("Show Prices", new
						DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
						int whichButton)
						{
						//Toast.makeText(getBaseContext(),
						//"OK clicked!", Toast.LENGTH_SHORT).show();
							
							 /*Intent myIntent2 = new Intent(GridViewPager.this,PubSmsSendActivity.class);
						    	GridViewPager.this.startActivity(myIntent2);*/
							//---get all contacts---
							
							startActivity(new Intent(GridViewActivity.this, PubHelpActivity.class));
							
							
							
						}
						})
						.setNegativeButton("Show Map", new
						DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
						int whichButton)
						{
							
					        
					        	
					        	//String uri = "geo:-1.296935,36.821945?q=-1.296935,36.821945";
					        	
							String uri ="geo:-1.317085,36.810029?q=The+Carnivore+Restaurant,+P.+O.+Box+56685,+Nairobi,+Kenya&hl=en&ll=-1.328476,36.800487&spn=0.010275,0.021136&sll=-1.296935,36.821945&sspn=0.041102,0.084543&oq=the+&hnear=The+Carnivore+Restaurant,+P.+O.+Box+56685,+Nairobi+West,+Nairobi,+Nairobi+Province,+Kenya&t=m&z=16";
							//String uri = "google.streetview:cbll=37.827500,-122.481670,&cbp=1,99.56,,1,-5.27&mz=21";
					       //String uri = "google.streetview:cbll=" + 42.374260 + "," + -71.120824 + "&cbp=1,180,,0,1.0";
							Intent streetView = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse(uri));
							startActivity(streetView);
					        	 
					        


						//Toast.makeText(getBaseContext(),
						//"Map clicked!", Toast.LENGTH_SHORT).show();
						}
						})
						
				
						
						.create();
				
						
				case PUB1_DIALOG_ID:
					
					return new AlertDialog.Builder(this)
					.setIcon(R.drawable.beer)
					.setTitle("This is a dialog with some simple text...")
					.setPositiveButton("OK", new
					DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
					int whichButton)
					{
					//Toast.makeText(getBaseContext(),
					//"OK clicked!", Toast.LENGTH_SHORT).show();
						
						 //Intent myIntent2 = new Intent(GridViewActivity.this,GPSPubmateActivity.class);
					    	//GridViewActivity.this.startActivity(myIntent2);
					    	 startActivity(new Intent(GridViewActivity.this, PubHelpActivity.class));
					}
					})
					.setNegativeButton("Cancel", new
					DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
					int whichButton)
					{
					Toast.makeText(getBaseContext(),
					"Cancel clicked!", Toast.LENGTH_SHORT).show();
					}
					})
					
			
					
					.create();
						
						
					}
					return null;
					
					
					
				}

			

		} // end class

    
    
