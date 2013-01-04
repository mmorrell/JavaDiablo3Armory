import java.util.Map;
import java.util.TreeMap;


public class D3AccountDemo
{
    public static void main(String args[])
    {

    	D3Account myd3 = new D3Account("Eurodance", "1289");
    
    	System.out.println("\n" + myd3.getHeroInfo());
    		
    	ItemFunctions itemDatabase = new ItemFunctions();
    	
    	for (Hero x : myd3.getHeroList())
    	{
    		System.out.println(x.getName() + "/" + x.getHeroClass() + "/" + x.getLevel() + "/" + x.getParagonLevel() + " -- " + x.getHeroDetail().getStatsSummary());
    		System.out.println("\n" + x + "\n");
    		for (Map.Entry<String, Item> entry : x.getHeroDetail().getItems().entrySet())
    		{
    		    System.out.println(String.format("%s: %s", entry.getKey(), (entry.getValue().equals(null) ? "" : entry.getValue())));
    		    
    		    String tooltipParams = entry.getValue().getTooltipParams();
    		    if (!tooltipParams.isEmpty())
    		    {
    		    	itemDatabase.addItem(tooltipParams, itemDatabase.getItemJson(tooltipParams));
    		    	System.out.println(tooltipParams + " -- added!");
    		    }
    		}

    	}
    }
}