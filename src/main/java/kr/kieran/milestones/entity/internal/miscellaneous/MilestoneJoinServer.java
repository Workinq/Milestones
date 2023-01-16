package kr.kieran.milestones.entity.internal.miscellaneous;

import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.TimeUnit;

public class MilestoneJoinServer
{

    private static final Long TWENTY_FOUR_HOURS_IN_MILLIS = TimeUnit.HOURS.toMillis(24);

    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event)
    {
        // The player has joined the server
        MPlayer mplayer = MPlayer.get(event.getPlayer());

        // It's been more than 24 hours since the player last logged in
        if (mplayer.getTimeSinceLastLoginReward() + TWENTY_FOUR_HOURS_IN_MILLIS > System.currentTimeMillis())
        {
            // Set the last time the player logged in to NOW
            mplayer.setTimeSinceLastLoginReward(System.currentTimeMillis());

            // Increase the times the player has connected to the server
            mplayer.setTimesConnectedToServer(mplayer.getTimesConnectedToServer() + 1);
        }
    }

}
