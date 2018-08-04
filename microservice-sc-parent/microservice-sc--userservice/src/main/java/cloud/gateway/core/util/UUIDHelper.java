package cloud.gateway.core.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDHelper {

	public static String getUUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

}
