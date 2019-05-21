public class Premiums implements Comparable<Premiums>
{
	public Premiums(int age, int premium)
	{
		this.age = age;
		this.premium = premium;
	}
	public int compareTo(Premiums other)
	{
		if(age < other.age)
			return -1;
		else if(age > other.age)
			return 1;
		return 0;
	}
	public int getAge()
	{
		return age;
	}
	public int getPremium()
	{
		return premium;
	}
	private int age;
	private int premium;
}
