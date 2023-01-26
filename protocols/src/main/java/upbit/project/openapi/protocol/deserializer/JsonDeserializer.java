package upbit.project.openapi.protocol.deserializer;

import upbit.project.openapi.protocol.gson.GsonUtil;
import org.junit.platform.commons.util.StringUtils;
import upbit.project.openapi.protocol.parameterized.ListParameterizedType;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class JsonDeserializer {
    private final GsonUtil gsonUtil;

    public JsonDeserializer(GsonUtil gsonUtil) {
        this.gsonUtil = gsonUtil;
    }

    public <T> List<T> deserializeAsList(String data, Class<T> classOfT) {
        if(StringUtils.isBlank(data)) {
            return Collections.emptyList();
        }

        Type type = new ListParameterizedType(classOfT);
        return gsonUtil.fromJson(data, type);
    }

    public <T> T deserializeAsObject(String data, Class<T> classOfT) {
        if(StringUtils.isBlank(data)) {
            return null;
        }

        return gsonUtil.fromJson(data, classOfT);
    }
}
