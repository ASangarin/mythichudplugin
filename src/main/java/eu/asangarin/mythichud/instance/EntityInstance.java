package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.core.HUDInstance;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.LivingEntity;

import java.io.DataOutputStream;
import java.io.IOException;

public class EntityInstance implements HUDInstance {
	private final int entityId;
	private final EntityPose pose;

	public EntityInstance(LivingEntity entity, EntityPose pose) {
		this.entityId = entity.getEntityId();
		this.pose = pose;
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeInt(entityId);
		out.writeInt(pose.size);
		out.writeFloat(pose.bodyYaw);
		out.writeFloat(pose.yaw);
		out.writeFloat(pose.pitch);
	}

	@RequiredArgsConstructor
	public static class EntityPose {
		private final int size;
		private final float bodyYaw, yaw, pitch;
	}
}
