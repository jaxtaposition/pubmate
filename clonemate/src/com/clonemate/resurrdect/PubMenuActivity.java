package com.clonemate.resurrdect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class PubMenuActivity extends MainActivity {
	GridView gridView;
	static final String[] MOBILE_OS = new String[] { "Settings", "Help",
		"SMS","Calendar", "Events" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menugrid);
        gridView  = (GridView) findViewById(R.id.gridView1);

		gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
	
				
				  switch(position)
				    {
				    case 0:               
				    	Intent myIntent = new Intent(PubMenuActivity.this, PubSettingsActivity.class);
				    	PubMenuActivity.this.startActivity(myIntent);
				   break;

				  case 1:
					  Intent myIntent1 = new Intent(PubMenuActivity.this, PubHelpActivity.class);
				    	PubMenuActivity.this.startActivity(myIntent1);
				      break;
				  case 2:
					  Intent myIntent2 = new Intent(PubMenuActivity.this,PubSmsSendActivity.class);
				    	PubMenuActivity.this.startActivity(myIntent2);
				    break;
				  case 3:
					  Intent myIntent3 = new Intent(PubMenuActivity.this,PubCalendarActivity.class);
				    	PubMenuActivity.this.startActivity(myIntent3);
				    break;
				  case 4:
					  Intent myIntent4 = new Intent(PubMenuActivity.this,GridViewPager.class);
				    	PubMenuActivity.this.startActivity(myIntent4);
					  }
				 };     
				});
        
        
        
        
        
        
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    
    
    
}
