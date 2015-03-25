package net.noxinc.status;

public class Dialogs 
{
	public static void status(String msg)
	{
		String tmp = " ";
		String tmp2 = " ";
		for(int i = 0; i < msg.length(); i++)
		{
			tmp += "_";
			tmp2 += "-";
		}
		tmp += "_\n| ";
		
		System.out.println(tmp += msg + "|\n" + tmp2 + "-");
	}
	
	public static void inventory1()
	{
		System.out.println(" Select item by typing its index.\n 0. Exit");
	}
}
