package de.haupt.commands;

import java.awt.Color;

import de.haupt.commands.types.ServerCommand;
import de.haupt.text.embed.EmbedHelpText;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand
{
	EmbedHelpText eht = new EmbedHelpText();
	
	
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
			if (args.length == 2)
			{
				eht.Input = args[1];
				
				eht.setHelpText();			
				
				channel.sendMessage(eht.setHelpText()).queue(); 
			}			
		}					
	}
	
	public MessageEmbed createEmbed() { 		
		EmbedBuilder ebuilder = new EmbedBuilder();
		//ebuilder.setTitle("__Lilith Commands__");
		ebuilder.setAuthor("Lilith Help");
		ebuilder.setThumbnail("https://i.imgur.com/gGLXe3v.png");
		ebuilder.setColor(Color.pink);
		ebuilder.setDescription("Please specify a command you want to view help for use `l-help <command>`. Use `l-commands` or  `l-admincommands`to see a list of all available commands.");
		ebuilder.addField("", "If you need help beyond what the commands provide, don't hesitate to use `l-support` and join our support server. We're looking forward to help you with any problems / troubles you might have.", false);
		
		//ebuilder.setDescription("Type `l-help <command>` to recieve more information about a command!");
		
		return ebuilder.build();
	}
}


