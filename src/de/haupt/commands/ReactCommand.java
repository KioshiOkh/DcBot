package de.haupt.commands;



import java.util.List;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class ReactCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		//!react #channel ID :ok:
		//args[0] usw...
		
		String[] args = message.getContentDisplay().split(" ");
		
		List<TextChannel> channels = message.getMentionedChannels();		
		if(m.hasPermission(channel, Permission.MANAGE_ROLES)) {
		
			if(m.hasPermission(channel, Permission.MANAGE_EMOTES)) {
				if(!channels.isEmpty())
				{
					TextChannel tc = message.getMentionedChannels().get(0);
					String messageIDString = args[2];
					
					try {
						
						long messageID = Long.parseLong(messageIDString);
						
						for(int i = 3; i < args.length; i++) 
						{
							tc.addReactionById(messageID, args[i]).queue();
						}
						
					}catch(NumberFormatException e) {e.printStackTrace();}
				}
			}
		}
	}
	
	
}
