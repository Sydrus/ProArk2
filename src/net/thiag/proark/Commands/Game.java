package net.thiag.proark.Commands;

import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.thiag.proark.Constructors.DiscordCommand;

/**
 * Created by thiag.
 */
public class Game extends DiscordCommand {

    public Game() {
        super("Descricao", new String[]{"mekno"});
    }

    @Override
    public void onCommand(User _Sender, Message _Message, Guild _Guild, TextChannel _Chat, Boolean _isEdited, String[] args) {

            String g = argsToString(args, 0). replace("=game", "");
            getAPI().getAccountManager().setGame(g);
            _Chat.sendMessage("```css\n" + "#Now Playing: '" + g + " '```");

    }

}