package de.haupt.commands;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class SauceCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		if(m.hasPermission(channel, Permission.MESSAGE_WRITE))
		{
			String[] args = message.getContentDisplay().split(" ");			
			
			if(args.length == 1)
			{				
				try {
					
					int min = 100000;
					int max = 359509;					
					
					channel.sendMessage("Sauce: " + ((int)(Math.random()*(max - min) + min))).queue();
					
					return;
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}											
			}
		}
	}
}
