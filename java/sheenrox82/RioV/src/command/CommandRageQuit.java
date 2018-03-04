package sheenrox82.RioV.src.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;

public class CommandRageQuit extends CommandBase implements ICommand
{
	@SuppressWarnings("rawtypes")
	private List aliases;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CommandRageQuit()
	{
		this.aliases = new ArrayList();
		this.aliases.add("rageQuit");
		this.aliases.add("ragequit");
		this.aliases.add("rq");
	}

	@Override
	public String getCommandName()
	{
		return "rageQuit";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return Color.GOLD + "/rageQuit - Kicks you from the server.";
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		EntityPlayer player = (EntityPlayer)icommandsender;
        EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().func_152612_a(icommandsender.getCommandSenderName());
        String s = "You rage quit!";
        
		if(icommandsender instanceof EntityPlayer)
		{
            ((EntityPlayer)icommandsender).attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
            entityplayermp.playerNetServerHandler.kickPlayerFromServer(s);
            RioVAPI.getInstance().getUtil().sendMessageToAll(player.getDisplayName() + " rage quit!");
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}