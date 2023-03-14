package test;

import org.junit.Assert;
import org.junit.Test;
import udemy.unit.RomanNumeralConvertor;

public class RomanNumeralConvertorTest {



    @Test
    public void convertSingleChar()
    {
        RomanNumeralConvertor conv = new RomanNumeralConvertor();

        Assert.assertEquals(1,conv.convert("I"));
        Assert.assertEquals(5,conv.convert("V"));
        Assert.assertEquals(10,conv.convert("X"));
        Assert.assertEquals(50,conv.convert("L"));
        Assert.assertEquals(100,conv.convert("C"));
        Assert.assertEquals(500,conv.convert("D"));
        Assert.assertEquals(1000,conv.convert("M"));



    }


    @Test
    public void convertMultipleChar()
    {
        RomanNumeralConvertor conv = new RomanNumeralConvertor();

        Assert.assertEquals(15,conv.convert("XV"));
        Assert.assertEquals(11,conv.convert("XI"));
        Assert.assertEquals(30,conv.convert("XXX"));

        Assert.assertEquals(4,conv.convert("IV"));
        Assert.assertEquals(40,conv.convert("XL"));
        Assert.assertEquals(800,conv.convert("DCCC"));
    }
}
