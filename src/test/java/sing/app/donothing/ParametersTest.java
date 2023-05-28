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
public class ParametersTest {

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
  void testPrintUsage() {
    Parameters p=new Parameters();
    p.process(new String[]{"-h"});
    p.printUsage();
    expect.toMatchSnapshot(baos.toString());
  }

  @Test
  void testProcess1() {
    Parameters p=new Parameters();
    p.process(new String[]{"-h"});
    assertEquals(true, p.help);
    assertEquals(false, p.version);
    assertEquals(0, p.parameters.size());
  }
  @Test
  void testProcess2() {
    Parameters p=new Parameters();
    p.process(new String[]{"-v"});
    assertEquals(false, p.help);
    assertEquals(true, p.version);
    assertEquals(0, p.parameters.size());
  }
  @Test
  void testProcess3() {
    Parameters p=new Parameters();
    p.process(new String[]{"abc", "cde"});
    assertEquals(false, p.help);
    assertEquals(false, p.version);
    assertEquals(2, p.parameters.size());
  }
}
