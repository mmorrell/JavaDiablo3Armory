
import java.util.*;


public class HTTPClientHeaders
{
	//Firefox Implentation. Accept-Charset excluded.
	//TODO: Accept-Encoding: gzip, deflate + Cookies
	
	interface DefaultHeaders
	{
	    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:17.0) Gecko/20100101 Firefox/17.0";
	    public static final String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	    public static final String ACCEPT_LANGUAGE = "en-US,en;q=0.5";
	    public static final String CONNECTION = "keep-alive";
	}
	
	private Map<String, String> headers = new HashMap<String, String>();
	
	public HTTPClientHeaders()
	{
		headers.put("User-Agent", DefaultHeaders.USER_AGENT);
		headers.put("Accept", DefaultHeaders.ACCEPT);
		headers.put("Accept-Language", DefaultHeaders.ACCEPT_LANGUAGE);
		headers.put("Connection", DefaultHeaders.CONNECTION);
	}	
	public HTTPClientHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}
	

	public Map<String, String> getHeaders()
	{
		return headers;
	}	
	public boolean setHeader(String headerName, String headerValue)
	{
		try
		{
			headers.put(headerName, headerValue);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	public boolean removeHeader(String headerName)
	{
		try
		{
			headers.remove(headerName);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	public String getHeaderValue(String headerName)
	{
		return headers.get(headerName);
	}

	public void setAllHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}
	
}
