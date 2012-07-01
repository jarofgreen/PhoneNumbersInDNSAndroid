
package uk.co.jarofgreen.phonenumbersindnsandroid;

import java.util.List;

import uk.co.jarofgreen.phonenumbersindnsandroid.lib.Query;
import uk.co.jarofgreen.phonenumbersindnsandroid.lib.Result;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
        
        new ResultsActivityWorker().execute(url);
        
    }
    
    
    
    private class ResultsActivityWorker extends AsyncTask<String, Integer, Boolean> {
    	
    	List<Result> results;
    	
		@Override
		protected Boolean doInBackground(String... params) {

			try {
				Query query = new Query(params[0]);
				results = query.execute();
				
				return true;
			} catch (Exception e) {
				Log.d("AGH",e.toString());
				return false;
			}
		}
		
		
        protected void onPostExecute(Boolean taskResult) {   	
        	if (taskResult) {
        		for (Result result: results) {
        			Log.d("PARSEDDATA",result.getCountryCode());
        			Log.d("PARSEDDATA",result.getNumber());
        			Log.d("PARSEDDATA",result.getDescription());
        			
        		}		
        	}
        }
		
		
    }




    
}
