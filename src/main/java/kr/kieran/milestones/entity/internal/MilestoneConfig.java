package kr.kieran.milestones.entity.internal;

import java.io.Serializable;

public class MilestoneConfig implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private String milestoneName;
    public String getMilestoneName() { return milestoneName; }
    public void setMilestoneName(String milestoneName) { this.milestoneName = milestoneName; }

    private String milestoneDescription;
    public String getMilestoneDescription() { return milestoneDescription; }
    public void setMilestoneDescription(String milestoneDescription) { this.milestoneDescription = milestoneDescription; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

}
