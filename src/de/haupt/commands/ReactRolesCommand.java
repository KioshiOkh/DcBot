package de.haupt.commands;



import java.util.List;

import de.haupt.commands.types.ServerCommand;
import de.haupt.manage.LiteSQL;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class ReactRolesCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		//!react #channel  	messageID	:ok:	@Rolle
		//args[0] args[1]  args[2] 		args[3]	args[4 ]
		
		String[] args = message.getContentDisplay().split(" ");
		
		if(args.length == 5)
		{
			List<TextChannel> channels = message.getMentionedChannels();	
			List<Role> roles = message.getMentionedRoles();
			
			if(m.hasPermission(channel, Permission.MANAGE_EMOTES)) {
				if(!channels.isEmpty() && !roles.isEmpty())
				{
					TextChannel tc = channels.get(0);
					Role role = roles.get(0);
					String messageIDString = args[2];
					
					try {
						
						long messageID = Long.parseLong(messageIDString);
						
						String emote = args[3];
						
						for(int i = 3; i < args.length; i++) 
						{
							tc.addReactionById(messageID, emote).queue();
							
							LiteSQL.onUpdate("INSERT INTO reactroles(guildid, channelid, messageid, emote, rollenid) VALUES(" 
							+ channel.getGuild().getIdLong()+", " + tc.getIdLong()+ ", " + messageID + ", '" + emote + "', " + role.getIdLong() + ")");
						}
						
					}catch(NumberFormatException e) {e.printStackTrace();}
				}
			}
		}
		else
		{
			channel.sendMessage("Please use `l-rrole <#channel> [messageID] <emote> <@Rolle>` ").queue();
		}
	}
}
