import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class Hero
{
	@SerializedName("class")
	private String heroClass;
	
	private String name;
	private String id;
	private String lastUpdated;
	
	private int level;
	private int paragonLevel;
	private int gender; // 0 = Male, 1 = Female
	
	@SerializedName("hardcore")
	private boolean isHardcore;
	@SerializedName("dead")
	private boolean isDead;
	
	private String battleTagName;
	private String battleTagNumber;
	
	private HeroDetail heroDetail;
	
	public void retrieveInfo()
	{
		try
		{
			heroDetail = new Gson().fromJson(HTTPClient.Get(String.format("http://us.battle.net/api/d3/profile/%s-%s/hero/%s", this.battleTagName, this.battleTagNumber, this.id)), HeroDetail.class);
		} catch (Exception e)
		{
			System.out.println("Retrieval of hero detail failed");
			e.printStackTrace();
		}
	}
	
	public String getHeroClass()
	{
		return heroClass;
	}
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
	public String getLastUpdated()
	{
		return lastUpdated;
	}
	public int getLevel()
	{
		return level;
	}
	public int getParagonLevel()
	{
		return paragonLevel;
	}
	public int getGender()
	{
		return gender;
	}
	public boolean isHardcore()
	{
		return isHardcore;
	}
	public boolean isDead()
	{
		return isDead;
	}
	
	public HeroDetail getHeroDetail()
	{
		return heroDetail;
	}

	public void setBattleTagName(String battleTagName)
	{
		this.battleTagName = battleTagName;
	}

	public void setBattleTagNumber(String battleTagNumber)
	{
		this.battleTagNumber = battleTagNumber;
	}

	public String toString()
	{
		return String.format("%s[Level: %s] (%s) - %s - %s - Normal/HC: %s", name, level + (paragonLevel > 0 ? " Paragon: " + paragonLevel : ""), (gender == 0 ? "Male" : "Female"), heroClass.replace("-", " "), id, (isHardcore ? "HC" + (isDead ? " [Dead]" : "") : "Normal"));
	}

}
