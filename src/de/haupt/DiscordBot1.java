package de.haupt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.security.auth.login.LoginException;

import de.haupt.listener.CommandListener;
import de.haupt.listener.GuildMemberJoin;
import de.haupt.listener.ReactionListener;
import de.haupt.listener.mutedMemberListener;
import de.haupt.manage.CommandManager;
import de.haupt.manage.LiteSQL;
import de.haupt.manage.SQLManager;
import de.haupt.manage.T;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class DiscordBot1 {

	public static DiscordBot1 INSTANCE;
	
	@SuppressWarnings("exports")
	public ShardManager shardMan;
	private CommandManager cmdMan;
	private Thread loop;
	
	public static void main(String[] args)throws InterruptedException
	{
		// TODO Auto-generated method stub
			try {
				new DiscordBot1();
			} catch (LoginException e) {
				
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			}			
	}
	
	public DiscordBot1() throws LoginException, IllegalArgumentException
	{
		INSTANCE = this;
		T t= new T();
		
		LiteSQL.connect();
		SQLManager.onCreate();
		
		DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(t.TOKEN);
				
				
		builder.setActivity(Activity.playing("Use l- "));
		builder.setStatus(OnlineStatus.ONLINE);	
		
		
		this.cmdMan = new CommandManager();		
		
		builder.addEventListeners(new GuildMemberJoin());
		builder.addEventListeners(new mutedMemberListener());
		builder.addEventListeners(new CommandListener());		
		builder.addEventListeners(new ReactionListener());
		
		
		
		shardMan = builder.build();
		
		shutdown();
		runActivityloop();
		
		
		System.out.println("Gestartet");
	}

		public void shutdown() {
			
			new Thread(() ->{
				
				String line= "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					while((line = reader.readLine()) != null) 
					{
						if(line.equalsIgnoreCase("exit"))
						{
							shutdown = true;
							if(shardMan != null) {
								shardMan.setStatus(OnlineStatus.OFFLINE);
								shardMan.shutdown();
								LiteSQL.Disconnect();								
								System.out.println("Program Terminated");
							}
							
							if(loop != null)
							{
								loop.interrupt();
							}
							reader.close();
							break;
						}else {
							System.out.println("Use 'exit' to terminate Program");
						}
					}
					
				}catch(IOException e) {
						e.printStackTrace();
				}
				
			}).start();
		}
		
		public boolean shutdown = false;
		
		public void runActivityloop()
		{
			this.loop = new Thread(() ->{
				
				long time = System.currentTimeMillis();
				
				while(!shutdown)
				{
					if(System.currentTimeMillis() >= time + 1000)
					{
						time = System.currentTimeMillis();
						onSecond();
					}
				}			
			});
			this.loop.setName("Activityloop");
			this.loop.start();			
		}
		
		String[] status = new String[]{"& dancing with Levi ", " Arata while he learns", " with her students", " use l-"};
		int next = 30;
		
		public void onSecond()
		{
			if(next <= 0)
			{
				Random rx = new Random();
				int i = rx.nextInt(status.length);
				
				shardMan.getShards().forEach(jda -> {
				String text = status[i].replaceAll("%members", "" + jda.getUsers().size());
					
					jda.getPresence().setActivity(Activity.playing(text));
				});
				next = 30;
			}
			else
			{
				next--;
			}
		}
		
		public CommandManager getCmdMan() {
			return cmdMan;
		}
}
