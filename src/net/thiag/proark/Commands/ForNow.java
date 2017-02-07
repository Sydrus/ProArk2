package net.thiag.proark.Commands;

import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.thiag.proark.Constructors.DiscordCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by thiag.
 */
public class ForNow extends DiscordCommand {

    public ForNow() {
        super("Descricao", new String[]{"status"});
    }

    long sec = System.currentTimeMillis();

    public String getUptime() {
        Long time = System.currentTimeMillis() - sec;
        long days = TimeUnit.MILLISECONDS.toDays(time);
        time -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return days + " Days " + hours + " Hours " + minutes + " Minutes " + seconds + " Seconds";
    }


    @Override
    public void onCommand(User _Sender, Message _Message, Guild _Guild, TextChannel _Chat, Boolean _isEdited, String[] args) {

        _Chat.sendMessage( "```css\n" + "#Status\n\n" + "Uptime: " + getUptime() + "\n\n" + "Plugins:\n" + "[In Development]\n\n" + "DataBase:\n" + " MySQL\n" + "```");
    }


}
