package kr.kieran.milestones.entity.internal.milestone;

import java.io.Serializable;

public class MilestoneAbstract implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    private Integer priority;
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneAbstract()
    {
        this(null, null);
    }

    public MilestoneAbstract(Integer id, Integer priority)
    {
        this.id = id;
        this.priority = priority;
    }

}
