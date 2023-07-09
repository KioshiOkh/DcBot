package de.haupt.commands;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.List;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UserCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		String[] args = message.getContentDisplay().split(" ");			
		
		if(args.length == 1)
		{				
			try {
				
				EmbedBuilder ebuilder = new EmbedBuilder();
				ebuilder.setAuthor(m.getUser().getName(), m.getUser().getAvatarUrl(), m.getUser().getAvatarUrl());
				ebuilder.setThumbnail(m.getUser().getAvatarUrl());
				ebuilder.setColor(Color.pink);				
				ebuilder.addField("**Joined Discord:**", "`"+ m.getUser().getTimeCreated().format(DateTimeFormatter.ofPattern("YYYY-MM-d"))+"`", true);
				ebuilder.addField("**Joined Server:**", "`"+m.getGuild().getTimeCreated().format(DateTimeFormatter.ofPattern("YYYY-MM-d"))+"`",true);
				ebuilder.setFooter(m.getUser().getName()+"#"+m.getUser().getDiscriminator());
				
				channel.sendMessage(ebuilder.build()).queue();				
				return;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
