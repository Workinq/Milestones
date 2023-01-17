package kr.kieran.milestones.entity.internal.milestone;

import org.bukkit.Material;

import java.io.Serializable;

public class MilestoneCraft extends MilestoneAbstract implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Material materialToCraft;
    public Material getMaterialToCraft() { return materialToCraft; }
    public void setMaterialToCraft(Material materialToCraft) { this.materialToCraft = materialToCraft; }

    private Integer numberOfTimesCrafted;
    public Integer getNumberOfTimesCrafted() { return numberOfTimesCrafted; }
    public void setNumberOfTimesCrafted(Integer numberOfTimesCrafted) { this.numberOfTimesCrafted = numberOfTimesCrafted; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneCraft()
    {
        this(null, null, null, null);
    }

    public MilestoneCraft(Integer id, Integer priority, Material materialToCraft, Integer numberOfTimesCrafted)
    {
        super(id, priority);
    }

}
