package de.haupt.commands;

import java.awt.Color;

import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class InviteCommand implements ServerCommand
{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message)
	{
		// TODO Auto-generated method stub
		String[] args = message.getContentDisplay().split(" ");
		
		if (args.length == 1)
		{
			channel.sendMessage(createEmbed()).queue();
		}
	}
	public MessageEmbed createEmbed() { 		
		EmbedBuilder ebuilder = new EmbedBuilder();
		//ebuilder.setTitle("__Lilith Commands__");
		ebuilder.setAuthor("Lilith Invite");
		ebuilder.setThumbnail("https://i.imgur.com/gGLXe3v.png");
		ebuilder.setColor(Color.pink);
		ebuilder.addField("", "https://bit.ly/3rLLsGL", false);
		ebuilder.addField("|https://discord.com/api/oauth2/authorize?client_id=843139053528678442&permissions=8&scope=bot|", null, false);
		
		//ebuilder.setDescription("Type `l-help <command>` to recieve more information about a command!");
		
		return ebuilder.build();
	}

}
