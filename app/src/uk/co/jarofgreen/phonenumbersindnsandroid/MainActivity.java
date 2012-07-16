package uk.co.jarofgreen.phonenumbersindnsandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void go(View v) {
    
    	EditText et = (EditText)findViewById(R.id.url);
    	
    	Intent i = new Intent(this, ResultsActivity.class);
    	i.putExtra("url", et.getText().toString());
    	startActivity(i);
    }
    
}
