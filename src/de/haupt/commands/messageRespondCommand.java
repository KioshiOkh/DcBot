package de.haupt.commands;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class messageRespondCommand implements ServerCommand 
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
					
					channel.sendMessage("Es hat Funktioniert" + message.getMember().getAsMention()).queue();
					return;
					
				}catch(Exception e) {
					e.printStackTrace();
				}
											
			}
			
		
		}	
	}

}
