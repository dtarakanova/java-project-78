package hexlet.code;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<Object> isString = x -> x instanceof String;
        addPredicate(isString);
    }

    public StringSchema required() { //test
        setRequired(true);
        return this;
    }

    public void minLength(int limit) {
        Predicate<String> minLength = x -> x.length() >= limit;
        addPredicate(minLength);
    }

    public StringSchema contains(String string) {
        Predicate<String> contains = x -> x.contains(string);
        addPredicate(contains);
        return this;
    }
}
