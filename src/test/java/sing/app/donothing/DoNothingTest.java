package sing.app.donothing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import au.com.origin.snapshots.Expect;
import au.com.origin.snapshots.junit5.SnapshotExtension;

@ExtendWith({SnapshotExtension.class})
class DoNothingTest {
    PrintStream stdout;
    ByteArrayOutputStream baos;
    private Expect expect;

    @BeforeEach
    void setup() {
        stdout = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    void teardown() throws IOException {
        System.setOut(stdout);
        baos.close();
    }

    @Test
    void callMainWithNoArguments() {
        DoNothing.main(new String[] {});
        assertTrue(true);
    }

    @Test
    void callMainWithArguments() {
        DoNothing.main(new String[] {"ABC", "CDE"});
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-h", "--help"})
    void callMainWithHelp(String argument1) {
        DoNothing.main(new String[] {argument1});
        assertDoesNotThrow(() -> expect.toMatchSnapshot(baos.toString()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-v", "--version"})
    void callMainWithVersion(String argument1) {
        DoNothing.main(new String[] {argument1});
        assertDoesNotThrow(() -> expect.toMatchSnapshot(baos.toString()));
    }
}
