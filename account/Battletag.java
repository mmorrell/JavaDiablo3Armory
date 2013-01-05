import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Battletag
{
	@SerializedName("kills") private KillStatistics killStatistics;
	
	private String battleTag;
	private ArrayList<Hero> heroes;
	
	private String battleTagName;
	private String battleTagNumber;
	
	public void parseBattletag()
	{
		String[] battleTagArray = battleTag.split("#");
		this.battleTagName = battleTagArray[0];
		this.battleTagNumber = battleTagArray[1];
	}
	
	public ArrayList<Hero> getHeroes()
	{
		return heroes;
	}

	public String getBattleTag()
	{
		return battleTag;
	}
	
	public KillStatistics getKillStatistics()
	{
		return killStatistics;
	}
	
	public String getName()
	{
		return battleTag;
	}
	
	public String getBattleTagName()
	{
		return battleTagName;
	}
	
	public String getBattleTagNumber()
	{
		return battleTagNumber;
	}
	
}
