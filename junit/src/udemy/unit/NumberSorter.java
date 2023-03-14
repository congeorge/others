package udemy.unit;

public class NumberSorter {
    private int smallest=Integer.MAX_VALUE;
    private int biggest=Integer.MIN_VALUE;
    public void find(int [] list)
    {

        for (int n:list
             ) {
            if (n<smallest) smallest=n;
            if (n>biggest) biggest=n;

        }
    }
    public int getBiggest()
    {
        return biggest;
    }


    public int getSmallest()
    {
        return smallest;
    }
}
