package net.thiag.proark.Commands;

import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.thiag.proark.Constructors.DiscordCommand;

/**
 * Created by thiag.
 */
public class ForNow extends DiscordCommand {

    public ForNow() {
        super("Descricao", new String[]{"status"});
    }

    @Override
    public void onCommand(User _Sender, Message _Message, Guild _Guild, TextChannel _Chat, Boolean _isEdited, String[] args) {
        _Chat.sendMessage(sender(_Sender) + "I'm in developing, I just have this command enabled! More commands will be added!"); // = [@User] Hi
    }


}
