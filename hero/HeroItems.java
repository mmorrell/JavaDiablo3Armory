import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HeroItems
{
	private Item head = new Item();
	private Item torso = new Item();
	private Item feet = new Item();
	private Item hands = new Item();
	private Item shoulders = new Item();
	private Item legs = new Item();
	private Item bracers = new Item();
	private Item waist = new Item();
	private Item mainHand = new Item();
	private Item offHand = new Item();
	private Item rightFinger = new Item();
	private Item leftFinger = new Item();
	private Item neck = new Item();
	

	private Map<String, Item> itemMap = new HashMap<String, Item>();
	
	private void loadItems()
	{
		itemMap = new HashMap<String, Item>();
		
		itemMap.put("Head", head);
		itemMap.put("Torso", torso);
		itemMap.put("Feet", feet);
		itemMap.put("Hands", hands);
		itemMap.put("Shoulders", shoulders);
		itemMap.put("Legs", legs);
		itemMap.put("Bracers", bracers);
		itemMap.put("Waist", waist);
		itemMap.put("Main Hand", mainHand);
		itemMap.put("Off Hand", offHand);
		itemMap.put("Right Finger", rightFinger);
		itemMap.put("Left Finger", leftFinger);
		itemMap.put("Neck", neck);
	}
	
	public String toString()
	{
		loadItems();
		
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Item> item : itemMap.entrySet())
		{
			if (!item.getValue().equals(new Item()))
			{
				builder.append(String.format("%s: %s\n", item.getKey(), (item.getValue().getName() != null ? item.getValue().toString() : "")));
			}
		}
		return builder.toString();
	}
	
	public Map<String, Item> getItemList()
	{
		loadItems();
		return itemMap;
	}
}