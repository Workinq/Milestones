package kr.kieran.milestones.entity.internal.milestone;

import java.io.Serializable;

public class MilestoneIsland extends MilestoneAbstract implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Integer islandLevel;
    public Integer getIslandLevel() { return islandLevel; }
    public void setIslandLevel(Integer islandLevel) { this.islandLevel = islandLevel; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneIsland()
    {
        this(null, null, null);
    }

    public MilestoneIsland(Integer id, Integer priority, Integer islandLevel)
    {
        super(id, priority);
        this.islandLevel = islandLevel;
    }

}
