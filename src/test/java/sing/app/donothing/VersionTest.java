package sing.app.donothing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import au.com.origin.snapshots.Expect;
import au.com.origin.snapshots.junit5.SnapshotExtension;

@ExtendWith({SnapshotExtension.class})
public class VersionTest {
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
  void testGetAPPLICATION_NAME() {
    assertEquals(Version.getAPPLICATION_NAME(), "Do-Nothing");
  }

  @Test
  void testGetAPPLICATION_VERSION() {
    assertEquals(Version.getAPPLICATION_VERSION(), "1.0.0");
  }

  @Test
  void testPrintApplicationVersion() {
    Version.printApplicationVersion();
    expect.toMatchSnapshot(baos.toString());
  }

  @Test
  void testPrintHelp() {
    Parameters parameters=new Parameters();
    parameters.process(new String[]{"-h"});
    Version.printHelp(parameters);
    expect.toMatchSnapshot(baos.toString());

  }

  @Test
  void testPrintVersion() {
    Version.printVersion();
    expect.toMatchSnapshot(baos.toString());
  }

}
