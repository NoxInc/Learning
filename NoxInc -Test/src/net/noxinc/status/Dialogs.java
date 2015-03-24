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
}
