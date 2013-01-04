public class Item
{
	private String id;
	private String name;
	private String icon;
	private String tooltipParams;
	private String displayColor;
	
	public String getId()
	{
		return id;
	}

	public String getIcon()
	{
		return icon;
	}

	public String getTooltipParams()
	{
		return (tooltipParams != null ? tooltipParams : "");
	}

	public String getDisplayColor()
	{
		return displayColor;
	}

	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return (name != null ? name : "");
	}
}