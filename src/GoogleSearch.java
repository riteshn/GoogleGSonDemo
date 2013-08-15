import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.rnath.domain.SearchResults;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * 
 */

/**
 * @author rnath
 *
 */
public class GoogleSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	    throws Exception 
	{
		try 
		{
			URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=Java");
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", "");
	
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) 
			{
				System.out.println("Got response from Google " + line);
			     builder.append(line);
			}
			Gson gson = new GsonBuilder().serializeNulls().create();
			
			String jsonResults = gson.toJson(builder.toString());
			System.out.println(jsonResults);
			
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(jsonResults);
			System.out.println("Is this json primitive " + jsonElement.isJsonPrimitive());
			JsonPrimitive p = jsonElement.getAsJsonPrimitive();
			System.out.println(p.getAsString());
			SearchResults results = gson.fromJson(jsonResults, SearchResults.class);
			

			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		


	}

}
