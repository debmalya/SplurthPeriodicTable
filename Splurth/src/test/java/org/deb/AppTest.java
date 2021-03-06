package org.deb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( App.followsRule("Spenglerium", "Ee") );
        assertTrue( App.followsRule("Zeddemorium", "Zr") );
        assertTrue( App.followsRule("Venkmine", "Kn") );
        assertFalse( App.followsRule("Stantzon", "Zt") );
        assertFalse( App.followsRule("Melintzum", "Nn") );
        assertFalse( App.followsRule("Tullium", "Ty") );
        assertFalse( App.followsRule("অনেক", "Ty") );
        assertFalse( App.followsRule("Tullium", "অনেক") );
        
        assertEquals("Ei", App.findValidSymbol("Gozerium"));
        assertEquals("Ie", App.findValidSymbol("Slimyrine"));
        
        assertEquals(11,App.countDistinctSymbol("Zuulon"));
    }
}
