package utils;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, String> contextMap;

    public ScenarioContext() {
        contextMap = new HashMap<>();
    }

    public void setContextValue(String key, String value) {
        contextMap.put(key, value);
    }

    public String getContextValue(String key) {
        return contextMap.get(key);
    }
}
