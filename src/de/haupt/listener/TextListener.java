package de.haupt.listener;


/*import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
*/
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class TextListener extends ListenerAdapter
{
	/*
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e)
	{
		String[] args = e.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase("l-mute"))
		{
			if(args.length > 1 && args.length < 3)
			{
				Member member = e.getGuild().getMemberById(args[1].replace("<@!", "").replace(">", ""));
				Role role = e.getGuild().getRoleById("844868122065764352");
				
				
				if(!member.getRoles().contains(role))		//Mute user
				{
					e.getChannel().sendMessage("Muted " + args[1] +".").queue();
					e.getGuild().addRoleToMember(member, role).complete();
				}
				else		//Unmute user
				{
					e.getChannel().sendMessage("Unmuted " + args[1] +".").queue();
					e.getGuild().removeRoleFromMember(member, role).complete();
				}
			}
			else if(args.length == 3)
			{
				
			}
			else
			{
				e.getChannel().sendMessage("Incorrect Syntax. Use `l-mute [@user] [time <optional>]").queue();
			}
		}
	}
	*/	
}

