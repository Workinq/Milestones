package kr.kieran.milestones.entity.internal.milestone;

import org.bukkit.Material;

import java.io.Serializable;

public class MilestoneBlock extends MilestoneAbstract implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Material typeOfBlock;
    public Material getTypeOfBlock() { return typeOfBlock; }
    public void setTypeOfBlock(Material typeOfBlock) { this.typeOfBlock = typeOfBlock; }

    private Integer necessaryTimesMined;
    public Integer getNecessaryTimesMined() { return necessaryTimesMined; }
    public void setNecessaryTimesMined(Integer necessaryTimesMined) { this.necessaryTimesMined = necessaryTimesMined; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneBlock()
    {
        this(null, null, null, null);
    }

    public MilestoneBlock(Integer id, Integer priority, Material typeOfBlock, Integer necessaryTimesMined)
    {
        super(id, priority);
        this.typeOfBlock = typeOfBlock;
        this.necessaryTimesMined = necessaryTimesMined;
    }

}
