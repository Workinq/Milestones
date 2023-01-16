package kr.kieran.milestones.cmd.type;

import com.massivecraft.massivecore.command.type.Type;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.entity.MPlayerColl;

public class TypeMPlayer
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    public static Type<MPlayer> get()
    {
        return MPlayerColl.get().getTypeEntity();
    }

}
