package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.api.HUDInstance;
import lombok.AllArgsConstructor;
import lombok.Setter;
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

	@Setter
	@AllArgsConstructor
	public static class EntityPose {
		private int size;
		private float bodyYaw, yaw, pitch;

		public EntityPose(int size, LivingEntity entity) {
			this.size = size;
			this.bodyYaw = entity.getLocation().getYaw();
			this.yaw = entity.getEyeLocation().getYaw();
			this.pitch = entity.getEyeLocation().getPitch();
		}
	}
}
