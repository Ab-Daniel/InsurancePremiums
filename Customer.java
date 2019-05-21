public class Customer implements Comparable<Customer>
{
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public int compareTo(Customer other)
	{
		if(name.compareTo(other.name) < 0)
			return -1;
		else if(name.compareTo(other.name) > 0)
			return 1;
		return 0;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		String formatedName = "";
		loop: for(int i = 0; i < name.length(); i++)
		{
			char c = name.charAt(i);
			if((c + "").equals(" "))
			{
				String first = name.substring(0, i);
				String second = name.substring(i, name.length());
				formatedName = first + "," + second;
				break loop;
			}
		}
		int spaceNum = NUM_OF_CHARS - (formatedName.length() - 1) - (age + "").length();
		String space = "";
		for(int i = 0; i < spaceNum; i++)
			space += " ";
		return formatedName + space + age;
	}
	private String name;
	private int age;
	private static final int NUM_OF_CHARS = 24;
}
