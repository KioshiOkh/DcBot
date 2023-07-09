package de.haupt.commands;

import java.awt.Color;
import java.util.Random;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class TestCommand implements ServerCommand
{
	String[] messages = {
			"[member] joined. You must construct additional pylons.",
			"Never gonna give [member] up. Never let [member] down!",
			"Hey! Listen! [member] has joined!",
			"Ha! [member] has joined! You activated my trap card!",
			"We've been expecting you, [member].",
			"Do you want to play with us, [member]?",
			"Swoooosh. [member] just landed.",
			"Brace yourselves. [member] just joined the server.",
			"A wild [member] appeared."
		};
	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		String[] args = message.getContentDisplay().split(" ");			
		
		if(m.hasPermission(channel, Permission.ADMINISTRATOR))
		{
			if(args.length == 1)
			{				
				Random rx = new Random();
				int number = rx.nextInt(messages.length);
				
				EmbedBuilder join = new EmbedBuilder();
				join.setColor(Color.pink);
				join.setDescription("" + messages[number].replace("[member]", m.getUser().getAsMention()));
				
				channel.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
				return;
			}
		}
	}
}
