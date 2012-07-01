package uk.co.jarofgreen.phonenumbersindnsandroid.lib;

import java.util.ArrayList;
import java.util.List;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.Type;

import android.util.Log;

public class Query {

	
	String url;

	public Query(String url) {
		super();
		this.url = url;
	}
	
	public List<Result> execute() throws Exception {
		List<Result> out = (ArrayList<Result>)new ArrayList<Result>();
		
		Lookup lookup = new Lookup("gmail.com", Type.MX);
		lookup.setResolver(new SimpleResolver("8.8.8.8"));
		Record[] records = lookup.run();
		for (int i = 0; i < records.length; i++) {
			MXRecord mx =  (MXRecord)records[i];
			Log.d("DATA","Host " + mx.getTarget());
		}

		
		
		return out;
	}
	
}
