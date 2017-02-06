package net.thiag.proark;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.thiag.proark.Listeners.MainDiscordListener;
import net.thiag.proark.Managers.CommandManager;

import javax.security.auth.login.LoginException;

/**
 * Created by thiag.
 */
public class ProArk {

    private JDA _JDA;

    private static ProArk _Instance;

    private CommandManager _CommandManager;

    public ProArk() {
        _Instance = this;
        try {
            _JDA = new JDABuilder().addListener(new MainDiscordListener()).setBotToken("MjY2NzI2NjA4NDIzODc4NjU2.C3qMIQ.VXTaqrEaUUnSUPIBIBo-wXl0M7E").buildBlocking();
        } catch (LoginException | IllegalArgumentException | InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        _CommandManager = new CommandManager();
    }

    public static ProArk getInstance() {
        return _Instance;
    }

    public CommandManager getCommandManager() {
        return this._CommandManager;
    }

    public JDA getJDA() {
        return this._JDA;
    }

}
