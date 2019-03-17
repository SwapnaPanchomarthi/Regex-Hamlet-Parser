import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
      // HamletParser.method2(hamletText, "Hamlet", "Leon");
       hamletParser.method2(hamletText, "Hamlet", "Leon");
      // hamletParser.getHamletData();
       Assert.assertTrue(hamletParser.match("Leon"));
        Assert.assertFalse(hamletParser.match("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.method2(hamletText, "Horatio", "Tariq");
        hamletParser.getHamletData();
        Assert.assertTrue(hamletParser.match("Tariq"));
        Assert.assertFalse(hamletParser.match("Horatio"));

    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.match("Horatio"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.match("Hamlet"));

    }
}