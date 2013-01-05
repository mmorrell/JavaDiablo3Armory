import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemFunctions
{
	
	private Connection con;
	private String username = "root";
	private String password = "";
	private HTTPClient http = new HTTPClient();
	
	public ItemFunctions()
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", username, password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addItem(String itemId, String itemJson)
	{
		if (!itemId.isEmpty())
		{
			try
			{
				PreparedStatement pstmt = con.prepareStatement("REPLACE d3_item( item_id, item_date_modified, item_json ) VALUES(?, current_timestamp, ?)");
				pstmt.setString(1, itemId);
				pstmt.setString(2, itemJson);
				
				pstmt.executeUpdate();
	
			} catch (Exception e)
			{
				System.out.println("Error:\n");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			System.out.println("addItem completed.");
		}
	}
	
	public String getItemJson(String itemId)
	{
		String url = String.format("http://us.battle.net/api/d3/data/%s", itemId);
		String itemJson = http.Get(url);
		return itemJson;
	}

}
