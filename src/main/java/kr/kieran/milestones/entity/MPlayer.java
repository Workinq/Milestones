package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.collections.MassiveMap;
import com.massivecraft.massivecore.collections.MassiveSet;
import com.massivecraft.massivecore.store.SenderEntity;
import com.massivecraft.massivecore.util.MUtil;
import kr.kieran.milestones.task.TaskUpdatePlayerData;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class MPlayer extends SenderEntity<MPlayer>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    public static MPlayer get(Object oid)
    {
        return MPlayerColl.get().get(oid);
    }

    // -------------------------------------------- //
    // LOAD
    // -------------------------------------------- //

    @Override
    public MPlayer load(MPlayer that)
    {
        this.completedMilestones = that.completedMilestones;
        this.entityKills = that.entityKills;
        this.timeSinceLastLoginReward = that.timeSinceLastLoginReward;
        this.timesConnectedToServer = that.timesConnectedToServer;
        this.messagesSentInChat = that.messagesSentInChat;
        this.itemsCrafted = that.itemsCrafted;
        this.itemsEnchanted = that.itemsEnchanted;
        this.blocksMined = that.blocksMined;

        return this;
    }

    // -------------------------------------------- //
    // IS DEFAULT
    // -------------------------------------------- //

    @Override
    public boolean isDefault()
    {
        if (this.hasCompletedMilestones()) return false;
        if (this.hasKilledEntities()) return false;
        if (this.hasTimeSinceLastLogin()) return false;
        if (this.hasConnectedToServerBefore()) return false;
        if (this.hasSentMessagesInChat()) return false;
        if (this.hasCraftedItems()) return false;
        if (this.hasEnchantedItems()) return false;
        if (this.hasMinedBlocks()) return false;

        return true;
    }

    // -------------------------------------------- //
    // CHANGED
    // -------------------------------------------- //

    public void queueChange()
    {
        TaskUpdatePlayerData.get().addMPlayerToUpdateQueue(this);
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    // Stores the id's of completed milestones
    private MassiveSet<Integer> completedMilestones = new MassiveSet<>();

    // Stores the number of mobs the player has killed
    private MassiveMap<EntityType, Integer> entityKills = new MassiveMap<>();

    // Stores the time (in milliseconds) that has passed since the player last logged in
    // to further their progress for times connected to the server (24h intervals)
    private Long timeSinceLastLoginReward = 0L;

    // Stores the number of times the player has joined the server in 24h intervals
    private Integer timesConnectedToServer = 0;

    // Stores the number of times a player has sent a message in chat
    private Integer messagesSentInChat = 0;

    // Stores the number of times a player has crafted an item
    private MassiveMap<Material, Integer> itemsCrafted = new MassiveMap<>();

    // Stores the number of times the player has enchanted an item
    private Integer itemsEnchanted = 0;

    // Stores the number of blocks a player has mined
    private MassiveMap<Material, Integer> blocksMined = new MassiveMap<>();

    // -------------------------------------------- //
    // FIELD: completedMilestones
    // -------------------------------------------- //

    public void addCompletedMilestone(Integer milestoneId)
    {
        // No rubbish
        if (milestoneId == null) return;

        // Apply
        boolean addedNewMilestone = completedMilestones.add(milestoneId);

        // Mark as changed
        if (addedNewMilestone) this.changed();
    }

    public void removeCompletedMilestone(Integer milestoneId)
    {
        // No rubbish
        if (milestoneId == null) return;

        // Apply
        boolean removedExistingMilestone = completedMilestones.remove(milestoneId);

        // Mark as changed
        if (removedExistingMilestone) this.changed();
    }

    public MassiveSet<Integer> getCompletedMilestoneIds()
    {
        return completedMilestones;
    }

    public boolean hasCompletedMilestones()
    {
        return !completedMilestones.isEmpty();
    }

    // -------------------------------------------- //
    // FIELD: mobsKilled
    // -------------------------------------------- //

    public Integer getTotalKillsFromEntity(EntityType entityType)
    {
        Integer ret = entityKills.get(entityType);
        if (ret == null) ret = 0;
        return ret;
    }

    public void setTotalKillsForEntity(EntityType entityType, Integer totalKills)
    {
        // Clean input
        Integer target = totalKills;
        if (target == null || target <= 0) target = null;

        // Detect no change
        Integer storedEntityKills = entityKills.get(entityType);
        if (MUtil.equals(target, storedEntityKills)) return;

        // Apply
        if (target == null && storedEntityKills != null)
        {
            // Apply
            entityKills.remove(entityType);

            // Mark as changed
            this.queueChange();

            // Stop here
            return;
        }

        if (target != null)
        {
            // Apply
            entityKills.put(entityType, target);

            // Mark as changed
            this.queueChange();
        }
    }

    public boolean hasKilledEntities()
    {
        return !entityKills.isEmpty();
    }

    // -------------------------------------------- //
    // FIELD: timeSinceLastLoginReward
    // -------------------------------------------- //

    public Long getTimeSinceLastLoginReward()
    {
        Long ret = timeSinceLastLoginReward;
        if (ret == null) ret = 0L;
        return ret;
    }

    public void setTimeSinceLastLoginReward(Long timeSinceLastLoginReward)
    {
        // Clean input
        Long target = timeSinceLastLoginReward;
        if (target == null || target == 0L) target = null;

        // Detect no change
        if (MUtil.equals(target, this.timeSinceLastLoginReward)) return;

        // Apply
        this.timeSinceLastLoginReward = target;

        // Mark as changed
        this.queueChange();
    }

    public boolean hasTimeSinceLastLogin()
    {
        return timeSinceLastLoginReward != null && timeSinceLastLoginReward > 0;
    }

    // -------------------------------------------- //
    // FIELD: timesConnectedToServer
    // -------------------------------------------- //

    public Integer getTimesConnectedToServer()
    {
        Integer ret = timesConnectedToServer;
        if (ret == null) ret = 0;
        return ret;
    }

    public void setTimesConnectedToServer(Integer timesConnectedToServer)
    {
        // Clean input
        Integer target = timesConnectedToServer;
        if (target == null || target == 0) target = null;

        // Detect no change
        if (MUtil.equals(target, this.timesConnectedToServer)) return;

        // Apply
        this.timesConnectedToServer = target;

        // Mark as changed
        this.queueChange();
    }

    public boolean hasConnectedToServerBefore()
    {
        return timesConnectedToServer != null && timesConnectedToServer > 0;
    }

    // -------------------------------------------- //
    // FIELD: messagesSentInChat
    // -------------------------------------------- //

    public Integer getMessagesSentInChat()
    {
        Integer ret = messagesSentInChat;
        if (ret == null) ret = 0;
        return ret;
    }

    public void setMessagesSentInChat(Integer messagesSentInChat)
    {
        // Clean input
        Integer target = messagesSentInChat;
        if (target == null || target == 0) target = null;

        // Detect no change
        if (MUtil.equals(target, this.messagesSentInChat)) return;

        // Apply
        this.messagesSentInChat = target;

        // Mark as changed
        this.queueChange();
    }

    public boolean hasSentMessagesInChat()
    {
        return messagesSentInChat != null && messagesSentInChat > 0;
    }

    // -------------------------------------------- //
    // FIELD: itemsCrafted
    // -------------------------------------------- //

    public Integer getTotalItemCraftsFromMaterial(Material material)
    {
        Integer ret = itemsCrafted.get(material);
        if (ret == null) ret = 0;
        return ret;
    }

    public void setTotalItemCraftsForMaterial(Material material, Integer totalCrafts)
    {
        // Clean input
        Integer target = totalCrafts;
        if (target == null || target <= 0) target = null;

        // Detect no change
        Integer storedTotalCrafts = itemsCrafted.get(material);
        if (MUtil.equals(target, storedTotalCrafts)) return;

        // Apply
        if (target == null && storedTotalCrafts != null)
        {
            // Apply
            itemsCrafted.remove(material);

            // Mark as changed
            this.queueChange();

            // Stop here
            return;
        }

        if (target != null)
        {
            // Apply
            itemsCrafted.put(material, target);

            // Mark as changed
            this.queueChange();
        }
    }

    public boolean hasCraftedItems()
    {
        return !itemsCrafted.isEmpty();
    }

    // -------------------------------------------- //
    // FIELD: itemsEnchanted
    // -------------------------------------------- //

    public Integer getItemsEnchanted()
    {
        Integer ret = itemsEnchanted;
        if (ret == null) ret = 0;
        return ret;
    }

    public void setItemsEnchanted(Integer itemsEnchanted)
    {
        // Clean input
        Integer target = itemsEnchanted;
        if (target == null || target == 0) target = null;

        // Detect no change
        if (MUtil.equals(target, this.itemsEnchanted)) return;

        // Apply
        this.itemsEnchanted = target;

        // Mark as changed
        this.queueChange();
    }

    public boolean hasEnchantedItems()
    {
        return itemsEnchanted != null && itemsEnchanted > 0;
    }

    // -------------------------------------------- //
    // FIELD: blocksMined
    // -------------------------------------------- //

    public Integer getTotalBlocksMinedFromMaterial(Material material)
    {
        Integer ret = blocksMined.get(material);
        if (ret == null) ret = 0;
        return ret;
    }

    public void setTotalBlocksMinedForMaterial(Material material, Integer timesMined)
    {
        // Clean input
        Integer target = timesMined;
        if (target == null || target <= 0) target = null;

        // Detect no change
        Integer storedTimesMined = blocksMined.get(material);
        if (MUtil.equals(target, storedTimesMined)) return;

        // Apply
        if (target == null && storedTimesMined != null)
        {
            // Apply
            blocksMined.remove(material);

            // Mark as changed
            this.queueChange();

            // Stop here
            return;
        }

        if (target != null)
        {
            // Apply
            blocksMined.put(material, target);

            // Mark as changed
            this.queueChange();
        }
    }

    public boolean hasMinedBlocks()
    {
        return !blocksMined.isEmpty();
    }

}
