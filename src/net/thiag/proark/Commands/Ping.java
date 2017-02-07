package net.thiag.proark.Commands;

import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.thiag.proark.Constructors.DiscordCommand;

import java.util.concurrent.TimeUnit;

/**
 * Created by thiag on 07/02/2017.
 */
public class Ping extends DiscordCommand {

    public Ping() {
        super("Descricao", new String[]{"ping"});
    }

    long sec = System.currentTimeMillis();

    public String PPing(){
        Long time = System.currentTimeMillis() - sec;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return seconds + "ms";
    }

    @Override
    public void onCommand(User _Sender, Message _Message, Guild _Guild, TextChannel _Chat, Boolean _isEdited, String[] args) {

        _Chat.sendMessage("```Markdown\n" + "#PONG " + PPing() + "```");

    }
}
