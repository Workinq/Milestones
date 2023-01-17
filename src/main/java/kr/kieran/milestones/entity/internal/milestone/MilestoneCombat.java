package kr.kieran.milestones.entity.internal.milestone;

import org.bukkit.entity.EntityType;

import java.io.Serializable;

public class MilestoneCombat extends MilestoneAbstract implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private EntityType typeOfEntity;
    public EntityType getTypeOfEntity() { return typeOfEntity; }
    public void setTypeOfEntity(EntityType typeOfEntity) { this.typeOfEntity = typeOfEntity; }

    private Integer killsNecessary;
    public Integer getKillsNecessary() { return killsNecessary; }
    public void setKillsNecessary(Integer killsNecessary) { this.killsNecessary = killsNecessary; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneCombat()
    {
        this(null, null, null, null);
    }

    public MilestoneCombat(Integer id, Integer priority, EntityType typeOfEntity, Integer killsNecessary)
    {
        super(id, priority);
        this.typeOfEntity = typeOfEntity;
        this.killsNecessary = killsNecessary;
    }

}
