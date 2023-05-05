package hexlet.code;

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
}
