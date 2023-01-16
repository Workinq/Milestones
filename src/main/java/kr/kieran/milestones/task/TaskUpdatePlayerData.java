package kr.kieran.milestones.task;

import com.massivecraft.massivecore.ModuloRepeatTask;
import kr.kieran.milestones.MilestonesPlugin;
import kr.kieran.milestones.entity.MPlayer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TaskUpdatePlayerData extends ModuloRepeatTask
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final long MILLIS_INTERVAL = TimeUnit.SECONDS.toMillis(5);

    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //

    private static TaskUpdatePlayerData i = new TaskUpdatePlayerData();
    public static TaskUpdatePlayerData get() { return i; }
    public TaskUpdatePlayerData()
    {
        super(MILLIS_INTERVAL);
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private final Set<MPlayer> mplayersToUpdate = Collections.synchronizedSet(new HashSet<>());

    // -------------------------------------------- //
    // FIELD: mplayersToUpdate
    // -------------------------------------------- //

    public void addMPlayerToUpdateQueue(MPlayer mplayer)
    {
        synchronized (mplayersToUpdate)
        {
            mplayersToUpdate.add(mplayer);
        }
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void invoke(long now)
    {
        MilestonesPlugin.get().debug("Iterating over mplayersToUpdate with size", mplayersToUpdate.size());
        synchronized (mplayersToUpdate)
        {
            Iterator<MPlayer> mplayersIterator = mplayersToUpdate.iterator();
            while (mplayersIterator.hasNext())
            {
                MPlayer mplayer = mplayersIterator.next();
                MilestonesPlugin.get().debug("Saving data for MPlayer", mplayer);
                mplayer.changed();
                mplayersIterator.remove();
            }
        }
    }

    @Override
    public void setActive(boolean active)
    {
        super.setActive(active);

        // Only clear when disabling
        if (!active)
        {
            MilestonesPlugin.get().debug("Saving and clearing mplayersToUpdate");
            synchronized (mplayersToUpdate)
            {
                mplayersToUpdate.forEach(MPlayer::changed);
                mplayersToUpdate.clear();
            }
        }
    }

}
