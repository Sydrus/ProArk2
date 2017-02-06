package net.thiag.proark.Managers;

import net.thiag.proark.Commands.ForNow;
import net.thiag.proark.Constructors.DiscordCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiag.
 */
public class CommandManager {

    private List<DiscordCommand> _Commands = new ArrayList<DiscordCommand>();

    public CommandManager() {
        _Commands.add(new ForNow());
    }

    public List<DiscordCommand> getCommands() {
        return this._Commands;
    }

}
