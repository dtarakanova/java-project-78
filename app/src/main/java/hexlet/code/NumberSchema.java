package hexlet.code;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> isNumber = x -> x instanceof Integer;
        addPredicate(isNumber);
    }

    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = x -> x > 0;
        addPredicate(positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = x -> (x >= min) && (x <= max);
        addPredicate(range);
        return this;
    }

}
