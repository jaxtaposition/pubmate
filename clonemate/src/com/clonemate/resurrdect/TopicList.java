package com.clonemate.resurrdect;

import java.io.Serializable;





public class TopicList implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String mSampleTopicText = "Topic text goes here.";

   public static TopicList SharedInstance = null;

/**
 * Get the shared instance of TopicList used in this demo.
 * 
 * @return TopicList
 */

static public TopicList getInstance () {
    if (SharedInstance == null) SharedInstance = new TopicList (null);
    return SharedInstance;
}

/**
 * Set the shared instance of TopicList used in this demo.
 * 
 * @param tlist TopicList
 * @return void
 */

static public void setInstance (TopicList tlist) {
    SharedInstance = tlist;
}



/**
 * Return a TopicList that sets itself up using information from Resources.
 * 
 * @param sampleText String - text to be used for sample topics
 * @return TopicList
 */

public TopicList (String sampleText) {
    mSampleTopicText = sampleText;
} // end getInstance

/**
 * Get the total number of topics in the list.
 * 
 * @return int
 */

public int getNumTopics () {
    return TestTopics.Titles.length;
} // end getNumTopics

/**
 * Get the title of the nth topic in the list.
 * 
 * @param index int - index number for a topic
 * @return String
 */

public String getTopicTitle (int index) {
    if (index >= TestTopics.Titles.length) return null;
    return TestTopics.Titles [index];
} // end getNumTopics

/**
 * Get the image id of the nth topic in the list.
 * 
 * @param index int - index number for a topic
 * @return int - id of the image
 */

public int getTopicImage (int index) {
    if (index >= TestTopics.Titles.length) return 0;
    return TestTopics.ImageIds [index];
} // end getTopicImage

/**
 * Get the text for the nth topic in the list.
 * 
 * @param index int - index number for a topic
 * @return String
 */

public String getTopicText (int index) {
    // All topics share some sample text in this demo.
    if (index >= TestTopics.Titles.length) return null;
    return mSampleTopicText;
} // end getTopicText

}



