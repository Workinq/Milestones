package kr.kieran.milestones.entity.internal.milestone;

import java.io.Serializable;

public class MilestoneRequirement implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Integer requirementAmount;
    public Integer getRequirementAmount() { return requirementAmount; }
    public void setRequirementAmount(Integer requirementAmount) { this.requirementAmount = requirementAmount; }

    private String rewardCommand;
    public String getRewardCommand() { return rewardCommand; }
    public void setRewardCommand(String rewardCommand) { this.rewardCommand = rewardCommand; }

    private MilestoneItem completedItem;
    public MilestoneItem getCompletedItem() { return completedItem; }
    public void setCompletedItem(MilestoneItem completedItem) { this.completedItem = completedItem; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneRequirement()
    {
        this(null, null, null);
    }

    public MilestoneRequirement(Integer requirementAmount, String rewardCommand, MilestoneItem completedItem)
    {
        this.requirementAmount = requirementAmount;
        this.rewardCommand = rewardCommand;
        this.completedItem = completedItem;
    }

}
