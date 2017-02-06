package net.thiag.proark.Constructors;

import lombok.Getter;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.thiag.proark.ProArk;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by thiag.
 */
public abstract class DiscordCommand {

    @Getter
    private final String[] names;
    @Getter
    private final String description;

    public DiscordCommand(String description, String... names) {
        this.description = description;
        this.names = names;
    }

    public abstract void onCommand(User _Sender, Message _Message, Guild _Guild, TextChannel _Chat, Boolean _isEdited, String[] args);

    public JDA getAPI() {
        return ProArk.getInstance().getJDA();
    }

    public String sender(User user) {
        return "**[<@" + user.getId() + ">]** ";
    }

    public String error(String msg) {
        return "**Error**: _" + msg + "_.";
    }

    public String usage(String msg) {
        return "**Usage**: " + msg + ".\n";
    }

    public String description(String msg) {
        return "**Description**: " + msg + ".\n";
    }

    public Boolean isAdmin(String _UserID, JSONObject _Settings) {
        JSONArray a = _Settings.getJSONArray("Admins");
        for(int i = 0; i < a.length(); i++) {
            JSONObject o = a.getJSONObject(i);
            if(_UserID.equals(o.get("ID"))) {
                return true;
            }
        }
        return false;
    }

    public String argsToString(String[] args, Integer index) {
        String myString = "";
        for (int i = index; i < args.length; i++) {
            String arg = args[i] + " ";
            myString = myString + arg;
        }
        myString = myString.substring(0, myString.length() - 1);
        return myString;
    }

}
