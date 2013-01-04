import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class HTTPClient
{

	private static HTTPClientHeaders httpHeaders = new HTTPClientHeaders();
	private String referer = null;
	
	
	public HTTPClient()
	{
		
	}
	public HTTPClient(String userAgent)
	{
		this.httpHeaders.setHeader("User-Agent", userAgent);
	}
	
	
	public static String Post(String requestUrl, String requestParameters)
    {
		String urlParameters = requestParameters;

		URL url;
		try
		{
			url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
	    	connection.setDoOutput(true);
	    	connection.setDoInput(true);
	    	connection.setInstanceFollowRedirects(true); 
	    	connection.setRequestMethod("POST"); 
	    	
	    	for (Entry<String, String> header : httpHeaders.getHeaders().entrySet())
	        {
	            connection.setRequestProperty(header.getKey(), header.getValue());
	        }
	    	
	    	connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	    	connection.setRequestProperty("charset", "utf-8");
	    	connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
	
	
	    	DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
	    	wr.writeBytes(urlParameters);
	    	wr.flush();
	    	wr.close();
	    	
	    	InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
	        StringBuffer response = new StringBuffer(); 
	        while((line = rd.readLine()) != null)
	        {
	        		response.append(line);
	        		response.append('\n');
	        }
	        rd.close();
	        connection.disconnect();
	        return response.toString();
		} catch (Exception e)
		{
			return "";
		} 
    }
    public static String Get(String inputURL)
    {
    	String url = inputURL;
    	HttpURLConnection connection;
		try
		{
			connection = (HttpURLConnection)new URL(url).openConnection();
	    	connection.setDoInput(true);
	    	connection.setDoOutput(false);
	    	connection.setRequestMethod("GET");
	    	
	        for (Map.Entry<String, String> header : httpHeaders.getHeaders().entrySet())
	        {
	            connection.setRequestProperty(header.getKey(), header.getValue());
	        }
	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    	StringBuilder data = new StringBuilder();
	    	String s = null;
	    	while((s = br.readLine()) != null)
	    	{
	    		data.append(s);
	    		data.append('\n');
	    	}
	    	String pageData = data.toString();
	    	return pageData;
		} catch (Exception e)
		{
			return "";
		}
    }
	
}
