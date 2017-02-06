package net.thiag.proark.Listeners;


import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import net.thiag.proark.Constructors.DiscordCommand;
import net.thiag.proark.ProArk;

public class MainDiscordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        new Thread(()->{

            if(e.getMessage().isPrivate()) {
                //
            } else {
                if(e.getMessage().getContent().startsWith("=")) {
                    for(DiscordCommand cmd: ProArk.getInstance().getCommandManager().getCommands()) {
                        for(String s: cmd.getNames()) {
                            if(e.getMessage().getContent().toLowerCase().startsWith("=" + s + " ")) {
                                cmd.onCommand(e.getAuthor(), e.getMessage(), e.getGuild(), e.getTextChannel(), e.getMessage().isEdited(), e.getMessage().getContent().replaceFirst("=" + s, "").split(" "));
                            } else if(e.getMessage().getContent().toLowerCase().startsWith("=" + s)) {
                                cmd.onCommand(e.getAuthor(), e.getMessage(), e.getGuild(), e.getTextChannel(), e.getMessage().isEdited(), new String[]{});
                            }
                        }
                    }
                } else {
                    // Not Command
                }
            }

        }).start();
    }

}