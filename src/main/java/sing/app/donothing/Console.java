package sing.app.donothing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@SuppressWarnings("java:S106")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Console {
    static void printf(String format, Object... objects) {
        System.out.printf(format, objects);
    }

    static void println(Object object) {
        System.out.println(object);
    }
}
