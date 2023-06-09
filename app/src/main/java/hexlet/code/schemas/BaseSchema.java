package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    protected final List<Predicate> predicates = new ArrayList<>();
    protected boolean isRequired = false;

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public final void addPredicate(Predicate predicate) {
        predicates.add(predicate);
    }

    public final boolean isValid(Object toCheck) {
        if ((toCheck == null || toCheck.equals(""))) {
            if (!isRequired) {
                return true;
            } else if (isRequired) {
                return false;
            }
        } else {
            for (Predicate predicate : predicates) {
                if (!predicate.test(toCheck)) {
                    return false;
                }
            }
        }
        return true;
    }
}
