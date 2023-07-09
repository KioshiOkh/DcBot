package de.haupt.manage;

public class SQLManager 
{
	public static void onCreate()
	{
		//id 	guildID 	channelID	messageID 	EMOTE 	rollenID
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS reactroles(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, channelid INTEGER, messageid INTEGER, emote VARCHAR, rollenid INTEGER)");
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS welcomerole(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, channelid INTEGRER, rollenid INTEGER)");
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS mutedmember(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, memberid INTEGER)");
		
	}
}
