package uk.co.jarofgreen.phonenumbersindnsandroid.lib;

import java.util.ArrayList;
import java.util.List;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TXTRecord;
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
		
		Lookup lookup = new Lookup("jarofgreen.co.uk", Type.TXT);
		lookup.setResolver(new SimpleResolver("8.8.8.8"));
		Record[] records = lookup.run();
		for (int i = 0; i < records.length; i++) {
			TXTRecord t =  (TXTRecord)records[i];
			List<String> data = t.getStrings();
			try {
				Result r = Result.parse(data.get(0));
				Log.d("DATA","We got: " + data.get(0));
				out.add(r);
			} catch (ResultParseException e) {
			}
			
		}

		
		
		return out;
	}
	
}
