package udemy.unit;

import java.util.HashMap;

public class RomanNumeralConvertor {



    private HashMap<String,Integer> baseMap;
    public RomanNumeralConvertor()
    {
        baseMap = new HashMap<String,Integer>();
        baseMap.put("I",1);
        baseMap.put("V",5);
        baseMap.put("X",10);
        baseMap.put("L",50);
        baseMap.put("C",100);
        baseMap.put("D",500);
        baseMap.put("M",1000);
    }




    public int convert(String roman)
    {
        int length = roman.length();
      //  System.out.println("Length"+length);
        int result=0;
        for(int i=0; i<length;i++) {

            int currrent = baseMap.get(roman.substring(i, i + 1));
        //    System.out.println("current is " + i +":" + currrent );
            if (i + 2 <= length) {
                  int right = baseMap.get(roman.substring(i + 1, i + 2));
                  if (currrent < right)
                    currrent = currrent * -1;
             }
               result=result+currrent;

            }
          return result;
    }
}
