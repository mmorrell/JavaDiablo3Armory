import java.util.*;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

public class HeroDetail
{
	//TODO: Items, everything. Use ArrayList<Class> not Class[] for collections.
	
	@SerializedName("id") private String heroId;
	@SerializedName("name")	private String heroName;
	@SerializedName("class") private String heroClass;
	@SerializedName("gender") private String heroGender;
	@SerializedName("level") private int heroLevel;
	
	private int paragonLevel;
	private boolean hardcore;
	private HeroStats stats;
	private HeroItems items;
	
	private Map<String, Item> itemList;
		
	
	public String getName()
	{
		return heroName;
	}
		
	public String getHeroClass()
	{
		return heroClass;
	}

	public String getHeroId()
	{
		return heroId;
	}

	public String getHeroGender()
	{
		return heroGender;
	}

	public int getHeroLevel()
	{
		return heroLevel;
	}

	public int getParagonLevel()
	{
		return paragonLevel;
	}

	public boolean isHardcore()
	{
		return hardcore;
	}
	
	public HeroStats getStats()
	{
		return stats;
	}
	
	public Map<String, Item> getItems()
	{
		return items.getItemList();
	}
	
	public String getStatsSummary()
	{
		return stats.toString();
	}
		
}
