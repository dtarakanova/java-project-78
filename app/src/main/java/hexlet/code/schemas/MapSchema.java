package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> isMap = x -> x instanceof Map<?, ?>;
        addPredicate(isMap);
    }

    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        Predicate<Map<?, ?>> sizeof = x -> x.size() == mapSize;
        addPredicate(sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Map<?, ?>> shape = x -> {
            for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
                if (!entry.getValue().isValid(x.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        };
        addPredicate(shape);
        return this;
    }
}
