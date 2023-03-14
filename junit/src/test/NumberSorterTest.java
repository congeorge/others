package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import udemy.unit.NumberSorter;

public class NumberSorterTest
{
    NumberSorter sorterTest;

    @Before
    public void setup()
    {
    sorterTest = new NumberSorter();
    }

    @Test
    public void testSorterAscending()
    {
        sorterTest.find(new int [] {2,3,4,6});
        Assert.assertEquals(6,sorterTest.getBiggest());
        Assert.assertEquals(2,sorterTest.getSmallest());

    }

    @Test
    public void testSorterDescending()
    {
        sorterTest.find(new int [] {6,4,3,2});
        Assert.assertEquals(6,sorterTest.getBiggest());
        Assert.assertEquals(2,sorterTest.getSmallest());

    }
}


