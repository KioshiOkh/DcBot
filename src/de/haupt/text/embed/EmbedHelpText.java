package de.haupt.text.embed;

import java.awt.Color;

import jdk.nio.Channels;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class EmbedHelpText
{
		
	public String Input;
	public Guild guildid;
	public String member;
	public Channels channel;
	
	
	//TITLE
	String a  = "Lilith Help - ";
	
	String aT = "Clear";
	String bT = "Admin/Commands";
	String cT = "ReactionMessage";
	String dT = "ReactionRole";
	String eT = "User";
	String fT = "WelcomeRole";
	String gT = "Invite";
	String hT = "Help";
	String iT = "Mute/Unmute";
	String jT = "Support/Privacy";
	String kT = "";
	String lT = "";
	String mT = "";
	String nT = "";
	String oT = "";
	String pT = "";
	String qT = "";
	String rT = "";
	String sT = "";
	String tT = "";
	String uT = "";
	String vT = "";
	String wT = "";
	String xT = "";
	String yT = "";
	String zT = "";	
	
	//Description
	String aD = "Clears the chat for a specified amount, NOTICE: pinned messages fo not get cleared!";
	String bD = "Shows the entire commandlist.";
	String cD = "Sets up a Embed-Message to simplify the setup for a ReactionRole.";
	String dD = "Sets up the ReactionRole, you can use every text-message.";
	String eD = "Gives dated information of yourself";
	String fD = "To set up a welcomeRole which is given when a new Member joins the Discord";
	String gD = "Gives a link to Invite Lilith to your own server";
	String hD = "Please specify a command you want to view help for use `l-help <command>`";
	String iD = "Will mute or unmute a Member so they aren't able to text. To perform his command u need Permission `VOICE_MUTE_OTHERS`";
	String jD = "`l-support`will provide you an invitaion link to our developer Discord, where We're looking forward to help you with any problems / troubles you might have.";
	String kD = "";
	String lD = "";
	String mD = "";
	String nD = "";
	String oD = "";
	String pD = "";
	String qD = "";
	String rD = "";
	String sD = "";
	String tD = "";
	String uD = "";
	String vD = "";
	String wD = "";
	String xD = "";
	String yD = "";
	String zD = "";	
	
	//Field
	String aF = "`l-clear [amount]`";
	String bF = "`l-commands`, `l-admincommands`";
	String cF = "`l-rmessage <Text>` use (shift+enter) for a wordwrap";
	String dF = "`l-rrole <channelID> <messageID> <emote> <role>`";
	String eF = "`l-user`";
	String fF = "`l-setwelcomerole <roleID>`";
	String gF = "`l-invite`";
	String hF = "If you need help beyond what the commands provide, don't hesitate to use `l-support` and join our support server. We're looking forward to help you with any problems / troubles you might have.";
	String iF = "`l-mute <@member>` to mute someone.`l-unmute <@member>` to unmute.";
	String jF = "`l-privacy` to look up what data I collect and use to improve the user experience";
	String kF = "";
	String lF = "";
	String mF = "";
	String nF = "";
	String oF = "";
	String pF = "";
	String qF = "";
	String rF = "";
	String sF = "";
	String tF = "";
	String uF = "";
	String vF = "";
	String wF = "";
	String xF = "";
	String yF = "";
	String zF = "";
	
	public MessageEmbed setHelpText()
	{
		
		EmbedBuilder ebuilder2 = new EmbedBuilder();
		ebuilder2.setThumbnail("https://i.imgur.com/gGLXe3v.png");
		ebuilder2.setColor(Color.pink);
		
		if(Input.equalsIgnoreCase("clear"))
		{
			ebuilder2.setTitle(a+aT);
			ebuilder2.setDescription(aD);
			ebuilder2.addField("",aF,false);			
		}
		if(Input.equalsIgnoreCase("commands")||Input.equalsIgnoreCase("admincommands"))
		{			
			ebuilder2.setTitle(a+bT);
			ebuilder2.setDescription(bD);
			ebuilder2.addField("",bF,false);
		}
		if(Input.equalsIgnoreCase("rmessage"))
		{
			ebuilder2.setTitle(a+cT);
			ebuilder2.setDescription(cD);
			ebuilder2.addField("",cF,false);
		}
		if(Input.equalsIgnoreCase("rrole"))
		{
			ebuilder2.setTitle(a+dT);
			ebuilder2.setDescription(dD);
			ebuilder2.addField("",dF,false);
		}
		if(Input.equalsIgnoreCase("User"))
		{
			ebuilder2.setThumbnail("https://i.imgur.com/gGLXe3v.png");
			ebuilder2.setColor(Color.pink);
			ebuilder2.setTitle(a+eT);
			ebuilder2.setDescription(eD);
			ebuilder2.addField("",eF,false);
		}
		if(Input.equalsIgnoreCase("setwelcomerole"))
		{
			ebuilder2.setTitle(a+fT);
			ebuilder2.setDescription(fD);
			ebuilder2.addField("",fF,false);
		}
		if(Input.equalsIgnoreCase("invite"))
		{
			ebuilder2.setTitle(a+gT);
			ebuilder2.setDescription(gD);
			ebuilder2.addField("",gF,false);
		}
		if(Input.equalsIgnoreCase("mute")||(Input.equalsIgnoreCase("unmute")))
		{
			ebuilder2.setTitle(a+iT);
			ebuilder2.setDescription(iD);
			ebuilder2.addField("",iF,false);
		}
		if(Input.equalsIgnoreCase("support")||Input.equalsIgnoreCase("privacy"))
		{
			ebuilder2.setTitle(a+jT);
			ebuilder2.setDescription(jD);
			ebuilder2.addField("",jF,false);
		}
		else
		{
			ebuilder2.setTitle(a+hT);
			ebuilder2.setDescription(hD);
			ebuilder2.addField("",hF,false);
		}
		
		return ebuilder2.build();
	}
	
	public void performEmbed()
	{
				
	}
}
