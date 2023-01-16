package kr.kieran.milestones.entity.internal.miscellaneous;

import kr.kieran.milestones.MilestonesPlugin;
import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MilestoneTalkInChat
{

    @EventHandler(ignoreCancelled = true)
    public void onPlayerSendMessage(AsyncPlayerChatEvent event)
    {
        if (true) return;
        if (event.isAsynchronous())
        {
            Bukkit.getScheduler().runTask(MilestonesPlugin.get(), () -> this.handlePlayerChatEvent(event.getPlayer()));
            return;
        }

        this.handlePlayerChatEvent(event.getPlayer());
    }

    private void handlePlayerChatEvent(Player player)
    {
        // The player has sent a message in chat
        MPlayer mplayer = MPlayer.get(player);
        mplayer.setMessagesSentInChat(mplayer.getMessagesSentInChat() + 1);
    }

}
