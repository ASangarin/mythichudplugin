package eu.asangarin.mythichud.api;

import java.io.DataOutputStream;
import java.io.IOException;

public interface HUDInstance {
	int getId();
	void write(DataOutputStream out) throws IOException;
}
