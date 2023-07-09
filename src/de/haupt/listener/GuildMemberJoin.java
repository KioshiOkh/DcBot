package de.haupt.listener;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import de.haupt.manage.LiteSQL;
import de.haupt.manage.roles.Roles;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class GuildMemberJoin extends ListenerAdapter
{
	String[] messages =
		{
			"[member] joined. You must construct additional pylons.",
			"Never gonna give [member] up. Never let [member] down!",
			"Hey! Listen! [member] has joined!",
			"Ha! [member] has joined! You activated my trap card!",
			"We've been expecting you, [member].",
			"Do you want to play with us [member]?",
			"Swoooosh. [member] just landed.",
			"Brace yourselves. [member] just joined the server.",
			"A wild [member] appeared.",
			"A GOD named [member] has joined the server!",
			"Hellow [member] - new Recruit - Welcome to the hell of Discord!",
			"Liliths new Victim [member], has joined the Discord!"
		};
	
	Roles r = new Roles();
	
	public void onGuildMemberJoin(GuildMemberJoinEvent e)
	{
		
		Random rx = new Random();
		int number = rx.nextInt(messages.length)+1;
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(Color.pink);
		join.setDescription(""+messages[number].replace("[member]", e.getMember().getAsMention()).replace("Liliths", e.getGuild().getBotRole().getAsMention()));
		
		System.out.println("DEBUG JOIN MESSAGE: " + messages[number] );
		
		e.getGuild().getDefaultChannel().sendMessage(join.build()).queue();;
		
		// SHOULD add a Role
		
		if(!((User) e.getMember()).isBot()) 
		{
			long guildid = e.getGuild().getIdLong();
			long channelid = e.getGuild().getDefaultChannel().getIdLong();
						
			ResultSet set = LiteSQL.onQuery("SELECT rollenid FROM welcomerole WHERE guildid= "+ guildid +" AND channelid= " + channelid);
			
			try {
				if(set.next())
				{
					long rollenid = set.getLong("rollenid");
					
					Guild guild = e.getGuild();
					guild.addRoleToMember(e.getUser().getName(), guild.getRoleById(rollenid)).queue();
					
				}
			} catch (SQLException ef) {
				// TODO Auto-generated catch block
				ef.printStackTrace();
			}
		}	
		//e.getGuild().addRoleToMember(e.getMember(), (Role) e.getGuild().getRolesByName(r.WelcomeRole.toString(), true)).complete();
		}
	

}
	
