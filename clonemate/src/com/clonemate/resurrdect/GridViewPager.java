package com.clonemate.resurrdect;
//this page is the transition to gridview activity so
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



	public class GridViewPager extends FragmentActivity 
    implements View.OnLongClickListener
{

    static final int DEFAULT_NUM_FRAGMENTS = 4;
    static final int DEFAULT_NUM_ITEMS = 4;
    static final int PUB0_DIALOG_ID = 0;
    static final int PUB1_DIALOG_ID = 1;
    static final int PUB2_DIALOG_ID = 2;
    static final int PUB3_DIALOG_ID = 3;
    
    static final String DEBUG_TAG = "Pubmate Quiz Log";

    

    MyAdapter mAdapter;
    ViewPager mPager;
    int mNumFragments = 0;       // total number of fragments
    int mNumItems = 0;           // number of items per fragment

/**
 * onCreate 
 * Create a set of views from a FragmentPagerAdapter object.
 * Arrange for those views to be displayed by a ViewPager view.
 */

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
   setContentView(R.layout.demo_pager);

   Resources res = getResources ();

   // Create a TopicList for this demo. Save it as the shared instance in TopicList
   String sampleText = res.getString (R.string.sample_topic_text);
   TopicList tlist = new TopicList (sampleText);
   TopicList.setInstance (tlist);

   // Create an adapter object that creates the fragments that we need 
   // to display the images and titles of all the topics.
   mAdapter = new MyAdapter (getSupportFragmentManager(), tlist, res);
   mPager = (ViewPager)findViewById(R.id.pager);
   mPager.setAdapter(mAdapter);

   // Save information about how many fragments are needed and how many items are on each page.
   int numTopics = tlist.getNumTopics ();
   int numRows = res.getInteger (R.integer.grid_num_rows);
   int numCols = res.getInteger (R.integer.grid_num_cols);
   int numTopicsPerPage = numRows * numCols;
   int numFragments = numTopics / numTopicsPerPage;
   if (numTopics % numTopicsPerPage != 0) numFragments++; // Add one if there is a partial page
   mNumFragments = numFragments;
   mNumItems = numTopicsPerPage;

   // Watch for button clicks on the first and last buttons.
   Button setPassword = (Button)findViewById(R.id.goto_first);
   setPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(0);
            }
   });
 Button  button = (Button)findViewById(R.id.goto_last);
   button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem (mNumFragments-1);
            }
        });
    }

/**
 * Respond to a long click in one of the topic views.
 * 
 * @param v View
 * @return 
 */
@Override
//public boolean onLongClick (View v) {

public boolean onLongClick (View v) {
	
	
try
{
    Integer num = (Integer) v.getTag ();
    int index = num.intValue ();
  
    showTopic(index);
    
}catch(Exception e){
	Toast.makeText(this,""+ e,Toast.LENGTH_SHORT).show();
	Log.d("Debug","first integer not showing"+e);
    }
    
    
   

    return true;

}// end onLongClick

;

/*
 * showTopic - start a GridImageActivity object to display the nth topic.
 *
 * @param index int - the index number of the topic to display
 * @return 
 *
 */
public void showTopic (int index) {

Toast.makeText (this, "" + index, Toast.LENGTH_SHORT).show();
Log.d("Debug","check the index:"+index);
Intent intent = new Intent (this.getApplicationContext(), GridViewActivity.class);
intent.putExtra ("index", index);
this.startActivity (intent);
}




//dialog section,returns dialog that checks if user selects database or map
/*DBAdapter db = new DBAdapter(this);
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
					
					 Intent myIntent2 = new Intent(GridViewPager.this,PubSmsSendActivity.class);
				    	GridViewPager.this.startActivity(myIntent2);
					//---get all contacts---
					
					db.open();
					Cursor c = db.getAllPrices();
					if (c.moveToFirst())
					{
					do {
					DisplayContact(c);
					} while (c.moveToNext());
					}
					db.close();
					}
					public void DisplayContact(Cursor c)
					{
					Toast.makeText(getBaseContext(),
					"id: " + c.getString(0) + "\n" +
							"Name: "+ c.getString(1) + "\n" +
							"Price: " + c.getInt(2) + "\n" +
							"Previous Price" + c.getInt(3),
							Toast.LENGTH_LONG).show();
					
					
					
				}
				})
				.setNegativeButton("Show Map", new
				DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
				int whichButton)
				{
				Toast.makeText(getBaseContext(),
				"Map clicked!", Toast.LENGTH_SHORT).show();
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
				
				 Intent myIntent2 = new Intent(GridViewPager.this,PubSmsSendActivity.class);
			    	GridViewPager.this.startActivity(myIntent2);
				
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
			
			
			
		}*/

	

/**
 * Adapter class
 *
 * This adapter class sets up GridFragment objects to be displayed by a ViewPager.
 */

public static class MyAdapter extends FragmentStatePagerAdapter {

private TopicList mTopicList;
private int mNumItems = 0;
private int mNumFragments = 0;

/**
 * Return a new adapter.
 */

public MyAdapter (FragmentManager fm, TopicList db, Resources res) {
    super(fm);
    setup (db, res);
}

/**
 * Get the number of fragments  to be displayed in the ViewPager.
 */

@Override public int getCount() {
    return mNumFragments;
}

/**
 * Return a new GridFragment that is used to display n items at the position given.
 *
 * @param position int - the position of the fragement; 0..numFragments-1
 */

@Override public Fragment getItem(int position) {
    //Create a new Fragment and supply the fragment number, image position, and image count as arguments.
    // (This was how arguments were handled in the original pager example.)
    Bundle args = new Bundle();
    args.putInt("num", position);
    //args.putInt("num", position+1);
    args.putInt("firstImage", position * mNumItems);

    // The last page might not have the full number of items.
    int imageCount = mNumItems;
    if (position == (mNumFragments-1)) {
       int numTopics = mTopicList.getNumTopics ();
       int rem = numTopics % mNumItems;
       if (rem > 0) imageCount = rem;
    }       
    args.putInt("imageCount", imageCount);
    args.putSerializable ("topicList", TopicList.getInstance ());

    // Return a new GridFragment object.
    GridFragment f = new GridFragment ();
    f.setArguments(args);
    return f;
}

/**
 * Set up the adapter using information from a TopicList and resources object.
 * When this method completes, all the instance variables of the adapter are valid;
 * 
 * @param tlist TopicList
 * @param res Resources
 * @return void
 */

void setup (TopicList tlist, Resources res) {
    mTopicList = tlist;

    if ((tlist == null) || (res == null)) {
       mNumItems = DEFAULT_NUM_ITEMS;
       mNumFragments = DEFAULT_NUM_FRAGMENTS;
    } else {
      int numTopics = tlist.getNumTopics ();
      int numRows = res.getInteger (R.integer.grid_num_rows);
      int numCols = res.getInteger (R.integer.grid_num_cols);
      int numTopicsPerPage = numRows * numCols;
      int numFragments = numTopics / numTopicsPerPage;
      if (numTopics % numTopicsPerPage != 0) numFragments++; // Add one if there is a partial page

      mNumFragments = numFragments;
      mNumItems = numTopicsPerPage;
    }

    Log.d ("GridViewPager", "Num fragments, topics per page: " + mNumFragments + " " + mNumItems);

} // end setup

} // end class MyAdapter

} // end class*/


	

		
	
	
	
	
	
	
	

