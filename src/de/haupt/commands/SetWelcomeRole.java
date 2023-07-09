package de.haupt.commands;

import java.util.List;

import de.haupt.commands.types.ServerCommand;
import de.haupt.manage.LiteSQL;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class SetWelcomeRole implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		String[] args = message.getContentDisplay().split(" ");
			
		
		if(m.hasPermission(channel, Permission.MANAGE_ROLES))
		{			
			if(args.length == 2)
			{				
				List<Role> roles = message.getMentionedRoles();
				
					if(!roles.isEmpty())
					{
						Role role = roles.get(0);
						
						try {
							
							for(int i = 1; i < args.length; i++) 
							{								
								LiteSQL.onUpdate("INSERT INTO welcomerole(guildid, channelid, rollenid) VALUES(" 
								+ channel.getGuild().getIdLong()+", " + channel.getGuild().getDefaultChannel().getIdLong()+ ", " + role.getIdLong() + ")");
							}
							message.getChannel().sendMessage(m.getAsMention() +" WelcomeRole has been set to `" + role.getName()+"`").queue();
							
						}catch(NumberFormatException e) {e.printStackTrace();}
					}
					else if(roles.isEmpty())
					{
						message.getChannel().sendMessage("No Role found").queue();
					}
					else
					{
						message.getChannel().sendMessage("Error").queue();
					}
			}
			else
			{
				channel.sendMessage("Please use `l-setwelcomerole <@Role>` ").queue();
			}
		}
	}
}
