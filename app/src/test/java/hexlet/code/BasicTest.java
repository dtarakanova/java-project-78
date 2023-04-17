package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class BasicTest {
    @Test
    public void basicTest() {
        String result = App.main();
        assertThat(result).isEqualTo("brb");
    }
}
