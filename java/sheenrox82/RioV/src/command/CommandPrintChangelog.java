package sheenrox82.RioV.src.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import sheenrox82.Core.src.base.ModUpdateChecker;
import sheenrox82.RioV.src.api.util.Color;

public class CommandPrintChangelog extends CommandBase implements ICommand
{
	@SuppressWarnings("rawtypes")
	private List aliases;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CommandPrintChangelog()
	{
		this.aliases = new ArrayList();
		this.aliases.add("printChangelog");
		this.aliases.add("printchangelog");
		this.aliases.add("pc");
	}

	@Override
	public String getCommandName()
	{
		return "printChangelog";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return Color.GOLD + "/printChangelog - Prints changelog for new update.";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{        
		if(icommandsender instanceof EntityPlayer)
		{
			ModUpdateChecker.printChangelog("http://minecraft.m4gdev.com/riovchangelog.txt");
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	public int getRequiredPermissionLevel()
	{
		return 3;
	}
}