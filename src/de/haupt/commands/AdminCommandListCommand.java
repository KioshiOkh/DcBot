package de.haupt.commands;

import java.awt.Color;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class AdminCommandListCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) 
	{
		
		
		if(m.hasPermission(channel, Permission.MESSAGE_WRITE))
		{
			String[] args = message.getContentDisplay().split(" ");			
			
			if(args.length == 1)
			{				
				channel.sendMessage(createEmbed()).queue();;
											
			}
		}
							
	}
	
	public MessageEmbed createEmbed() { 		
		EmbedBuilder ebuilder = new EmbedBuilder();
		//ebuilder.setTitle("Commandlist");
		ebuilder.setAuthor("LilithBot AdminCommands" , null , "https://i.imgur.com/gGLXe3v.png");
		ebuilder.setThumbnail("https://i.imgur.com/gGLXe3v.png");
		ebuilder.setColor(Color.pink);
		ebuilder.addField(":question: Help", "`admincommands`,`help`,`support`,`commands`,`privacy`", false);
		ebuilder.addField("",":arrow_down: How to set a Reactionrole :arrow_down:", false);
		ebuilder.addField(":one: SetMessage","`rmessage 'Text'`", false);
		ebuilder.addField(":two: ReactionRole", "`rrole <channelid> <messageid> <emote> <role>`" , false);
		
		ebuilder.addField("", "Type `l-help <command>` to recieve more information about a command!", false);
		
		return ebuilder.build();
	}
}
