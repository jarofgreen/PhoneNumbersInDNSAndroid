
package uk.co.jarofgreen.phonenumbersindnsandroid;

import android.os.Bundle;
import android.app.Activity;


public class ResultsActivity extends Activity {

	String url;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        
        Bundle extras = getIntent().getExtras();
        url = extras.getString("url");
        
        setTitle("Results for "+url);
        
    }




    
}
