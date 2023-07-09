package de.haupt.commands;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class SupportCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		
			String[] args = message.getContentDisplay().split(" ");			
			
			if(args.length == 1)
			{				
				try {
					
					channel.sendMessage("Join our Support-Server: https://discord.gg/qBT7E4v4UB").queue();
					return;
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
}
