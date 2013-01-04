
public class HeroStats
{
	//Base Stats
	private double life;
	private double damage;
	private double armor;
	private double strength;
	private double dexterity;
	private double vitality;
	private double intelligence;
	
	//Resist Stats
	private double physicalResist;
	private double fireResist;
	private double coldResist;
	private double lightningResist;
	private double poisonResist;
	private double arcaneResist;
	
	//Combat Stats
	private double attackSpeed;
	private double critDamage;
	private double blockChance;
	private double blockAmountMin;
	private double blockAmountMax;
	private double damageIncrease;
	private double critChance;
	private double damageReduction;
	private double thorns;
	private double lifeSteal;
	private double lifePerKill;
	private double lifeOnHit;
	
	//Other Stats
	private double goldFind;
	private double magicFind;
	private double primaryResource;
	private double secondaryResource;
	
	public double getLife()
	{
		return life;
	}
	public double getDamage()
	{
		return damage;
	}
	public double getArmor()
	{
		return armor;
	}
	public double getStrength()
	{
		return strength;
	}
	public double getDexterity()
	{
		return dexterity;
	}
	public double getVitality()
	{
		return vitality;
	}
	public double getIntelligence()
	{
		return intelligence;
	}
	public double getPhysicalResist()
	{
		return physicalResist;
	}
	public double getFireResist()
	{
		return fireResist;
	}
	public double getColdResist()
	{
		return coldResist;
	}
	public double getLightningResist()
	{
		return lightningResist;
	}
	public double getPoisonResist()
	{
		return poisonResist;
	}
	public double getArcaneResist()
	{
		return arcaneResist;
	}
	public double getAttackSpeed()
	{
		return attackSpeed;
	}
	public double getCritDamage()
	{
		return critDamage;
	}
	public double getBlockChance()
	{
		return blockChance;
	}
	public double getBlockAmountMin()
	{
		return blockAmountMin;
	}
	public double getBlockAmountMax()
	{
		return blockAmountMax;
	}
	public double getDamageIncrease()
	{
		return damageIncrease;
	}
	public double getCritChance()
	{
		return critChance;
	}
	public double getDamageReduction()
	{
		return damageReduction;
	}
	public double getThorns()
	{
		return thorns;
	}
	public double getLifeSteal()
	{
		return lifeSteal;
	}
	public double getLifePerKill()
	{
		return lifePerKill;
	}
	public double getLifeOnHit()
	{
		return lifeOnHit;
	}
	public double getGoldFind()
	{
		return goldFind;
	}
	public double getMagicFind()
	{
		return magicFind;
	}
	public double getPrimaryResource()
	{
		return primaryResource;
	}
	public double getSecondaryResource()
	{
		return secondaryResource;
	}
	
	
	public String toString()
	{
		//Only returning a few variables.
		try
		{
			return String.format("Life=%s Damage=%s Armor=%s ++ atkspeed=%s str=%s dex=%s vit=%s", life, damage, armor, attackSpeed, strength, dexterity, vitality);
		}
		catch (Exception ex)
		{
			return null;
		}
	}
}
