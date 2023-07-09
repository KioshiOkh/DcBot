package de.haupt.commands;

import java.awt.Color;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class PreviewCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		

		if(m.hasPermission(channel, Permission.MANAGE_CHANNEL))
		{
		String mess = message.getContentRaw().substring(10);
		
		EmbedBuilder ebuilder = new EmbedBuilder();
		
		ebuilder.setDescription(mess);
		ebuilder.setColor(Color.pink);		
		
		message.delete().queue();
		channel.sendMessage(ebuilder.build()).queue();		
		}
		else
		{
			channel.sendMessage("You don't have Permission to use this command" + m.getAsMention()).queue();
			
		}
	}

}
