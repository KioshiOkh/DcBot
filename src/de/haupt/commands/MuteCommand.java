package de.haupt.commands;

import java.util.List;

import de.haupt.commands.types.ServerCommand;
import de.haupt.manage.LiteSQL;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;


public class MuteCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		if(m.hasPermission(channel, Permission.VOICE_MUTE_OTHERS))
		{
			String[] args = message.getContentDisplay().split(" ");
			
			if(args.length == 2)
			{	
				List<Member> Members = message.getMentionedMembers();
				
				if(!Members.isEmpty())
				{
					Member Member = Members.get(0);
					try
					{
						for(int i = 1; i < args.length; i++) 
						{								
							LiteSQL.onUpdate("INSERT INTO mutedmember(guildid, memberid) VALUES(" 
							+ channel.getGuild().getIdLong()+", " + Member.getIdLong() + ")");
						}
					}catch(NumberFormatException e) {e.printStackTrace();}
				}	
				
				channel.sendMessage(message.getMentionedMembers().toString() + " has been muted").queue();										
			}
		}
	}
}

