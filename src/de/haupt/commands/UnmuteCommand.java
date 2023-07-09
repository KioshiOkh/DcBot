package de.haupt.commands;

import java.util.List;

import de.haupt.commands.types.ServerCommand;
import de.haupt.manage.LiteSQL;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnmuteCommand implements ServerCommand
{
	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		if(m.hasPermission(channel, Permission.VOICE_MUTE_OTHERS))
		{
			String[] args = message.getContentDisplay().split(" ");
			
			if(args.length == 2)
			{	
				List<Member> a = message.getMentionedMembers();
				List<Member> Members = message.getMentionedMembers();
				long guildid = channel.getGuild().getIdLong();
				
				if(!Members.isEmpty())
				{
					Member Member = Members.get(0);
					long memberid = Member.getIdLong();
					try
					{
						for(int i = 1; i < args.length; i++) 
						{	
							
							LiteSQL.onUpdate("DELETE FROM mutedmember WHERE guildid= "+ guildid+" AND memberid="+memberid);
						}
					}catch(NumberFormatException e) {e.printStackTrace();}
				}
				
				channel.sendMessage(a + " has been unmuted").queue();										
			}
		}
	}
}
