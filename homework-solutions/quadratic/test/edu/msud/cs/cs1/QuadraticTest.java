package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.Complex;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticTest {

    private static double delta;

    @BeforeAll
    static void beforeAll() { delta = 1e-10; }

    @Test
    void test02() {
        Quadratic q = new Quadratic(1, 1, 1);
        Complex[] roots = q.roots();

        // From Wolfram Alpha
        // x≈-0.500000000000000 + 0.866025403784439 i
        // x≈-0.500000000000000 - 0.866025403784439 i

        assertEquals(roots[0].re(), -0.500000000000000, delta);
        assertEquals(roots[0].im(), 0.866025403784439, delta);
        assertEquals(roots[1].re(), -0.500000000000000, delta);
        assertEquals(roots[1].im(), -0.866025403784439, delta);

        assertTrue(q.isComplex());
        assertFalse(q.isReal());
        assertFalse(q.isSame());
    }
}
