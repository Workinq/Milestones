package kr.kieran.milestones.event;

import com.massivecraft.massivecore.event.EventMassiveCore;

public abstract class EventMilestonesAbstract extends EventMassiveCore
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesAbstract()
    {
    }

    public EventMilestonesAbstract(boolean isAsync)
    {
        super(isAsync);
    }

}
