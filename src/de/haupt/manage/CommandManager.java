package de.haupt.manage;

import java.util.concurrent.ConcurrentHashMap;

import de.haupt.commands.*;
import de.haupt.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class CommandManager 
{

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager()
	{
		this.commands = new ConcurrentHashMap<>();
		
		this.commands.put("clear", new ClearCommand());
		this.commands.put("hi", new messageRespondCommand());
		this.commands.put("commands", new CommandListCommand());
		this.commands.put("rmessage", new PreviewCommand());
		this.commands.put("react", new ReactCommand());
		this.commands.put("rrole", new ReactRolesCommand());
		this.commands.put("admincommands", new AdminCommandListCommand());
		this.commands.put("sauce", new SauceCommand());
		this.commands.put("help", new HelpCommand());
		this.commands.put("support", new SupportCommand());
		this.commands.put("mute", new MuteCommand());
		this.commands.put("unmute", new UnmuteCommand());
		this.commands.put("user", new UserCommand());
		this.commands.put("test", new TestCommand());
		this.commands.put("setwelcomerole", new SetWelcomeRole());
		this.commands.put("ivite", new InviteCommand());
		
	}
	
	public boolean perform(String command, Member m, TextChannel channel, Message message) 
	{
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase()))!= null)
		{
			cmd.performCommand(m, channel, message);
			return true;
		}
		
		return false;
	}
}
