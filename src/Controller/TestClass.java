package Controller;

import Model.Model;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestClass {
    @Test
    public void testNegatives()
    {
        Model m = new Model();
        m.setHeight1(-1);
        assertTrue(m.getHeight1() == 0);
    }
}
