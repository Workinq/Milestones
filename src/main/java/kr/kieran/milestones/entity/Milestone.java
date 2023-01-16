package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;

@EditorName("config")
public class Milestone extends Entity<Milestone>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    protected static transient Milestone i;
    public static Milestone get() { return i; }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //



    // -------------------------------------------- //
    // OVERRIDE: ENTITY
    // -------------------------------------------- //

    @Override
    public Milestone load(Milestone that)
    {
        super.load(that);
        return this;
    }

}
