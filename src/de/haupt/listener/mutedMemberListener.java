package de.haupt.listener;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.haupt.manage.LiteSQL;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class mutedMemberListener extends ListenerAdapter
{

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e)
	{
		Message message = e.getMessage();
		
		if(!(e.getAuthor().isBot()))
		{
			long guildid = e.getGuild().getIdLong();			
			
			ResultSet set = LiteSQL.onQuery("SELECT memberid FROM mutedmember WHERE guildid= "+ guildid);
			
			try
			{
				if(set.next())
				{
					long memberid = set.getLong("memberid");
					
					Guild guild = e.getGuild();
					guild.getMember(User.fromId(memberid));
					
					long t = message.getAuthor().getIdLong();
					
					if(t == memberid)
					{		
						if(e.getMember().hasPermission(Permission.VOICE_MUTE_OTHERS))
						{
							if(message.getContentDisplay().contains("l-unmute"))
							{
								return;
							}
							else
							{
								message.delete().queue();
							}
						}
						else
						{
							message.delete().queue();
						}						
					}					
				}
				else
				{
					//System.out.println("Eine Nachricht konnte nicht gelöscht werden");
					return;
				}
			
			}catch (SQLException ef) {
				// TODO Auto-generated catch block
				ef.printStackTrace();
			}			
		}
		else
		{
			return;
		}		
	}
}
