import java.util.ArrayList;

import com.google.gson.Gson;


public class D3Account
{
	
	private String battleTagName;
	private String battleTagNumber;
	private boolean isBattletagRetrieved = false;
	
	private static ArrayList<Hero> heroList = new ArrayList<Hero>();
	private static Battletag battletag;
	
	public D3Account(String battleTag, String battleTagNumber)
	{
		this.battleTagName = battleTag;
		this.battleTagNumber = battleTagNumber;
		this.getBattletagInformation();
	}
	
	private boolean getBattletagInformation()
	{
		try
		{
			battletag = new Gson().fromJson(HTTPClient.Get(String.format("http://us.battle.net/api/d3/profile/%s-%s/", battleTagName.toLowerCase(), battleTagNumber)), Battletag.class);
			battletag.parseBattletag();
			
			if (battletag.getName() != null)
			{
				this.isBattletagRetrieved = true;
				this.heroList = battletag.getHeroes();
				this.setHeroBattletags();
				return true;
			} else {
				System.out.println("An error occured retrieving the Battletag.1");
				this.isBattletagRetrieved = false;
				return false;
			}
			
		} catch (Exception e)
		{
			System.out.println("An error occured retrieving the Battletag.2");
			return false;
		}
	}
	public Battletag getBattletag()
	{
		return battletag;

	}
	public boolean isBattleTagRetrieved()
	{
		return isBattletagRetrieved;
	}

	public ArrayList<Hero> getHeroList()
	{
		return heroList;
		
	}
	
	
	public String getHeroInfo()
	{
		StringBuilder output = new StringBuilder();
		for(Hero hero : heroList)
		{
			output.append(hero + "\n");
		}
		return output.toString();
	}
		
	private void setHeroBattletags()
	{
		for(int i = 0; i < heroList.size(); i++)
		{
			heroList.get(i).setBattleTagName(battleTagName);
			heroList.get(i).setBattleTagNumber(battleTagNumber);
			heroList.get(i).retrieveInfo();
		}
	}
		
	
	
}
