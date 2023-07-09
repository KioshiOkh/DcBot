package de.haupt.commands;

import java.awt.Color;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class CommandListCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) 
	{
		
		
		if(m.hasPermission(channel, Permission.MESSAGE_WRITE))
		{
			String[] args = message.getContentDisplay().split(" ");			
			
			if(args.length == 1)
			{				
				channel.sendMessage(createEmbed()).queue();											
			}
		}						
	}
	
	public MessageEmbed createEmbed() { 		
		EmbedBuilder ebuilder = new EmbedBuilder();
		//ebuilder.setTitle("__Lilith Commands__");
		ebuilder.setAuthor("Lilith Commands" , null , "https://i.imgur.com/gGLXe3v.png");
		ebuilder.setThumbnail("https://i.imgur.com/gGLXe3v.png");
		ebuilder.setColor(Color.pink);
		ebuilder.addField(":question: Help", "`help`,`support`,`commands`,`privacy`,`invite`", false);
		ebuilder.addField(":gear: Settings", "`setwelcomerole <roleID>`", false);		
		ebuilder.addField(":globe_with_meridians: Other-Stuff","`user`",false);
		ebuilder.addField(":underage: NSFW", "||`sauce`||", false);
		ebuilder.addField(":bookmark_tabs: Chat-Managment", "`clear [amount]`, `un/mute [@member]`", false);
		ebuilder.addField("", "Type `l-help <command>` to recieve more information about a command!",false);
		
		//ebuilder.setDescription("Type `l-help <command>` to recieve more information about a command!");
		
		return ebuilder.build();
	}
}
