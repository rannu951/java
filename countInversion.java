import java.util.*;
import java.lang.Math;
public class MyClass {
    public static void main(String args[]) 
    {
        int[] arrayInt = {3,6,4,2,5,1};

        System.out.println(countInversion(arrayInt , 0 , arrayInt.length-1));
    }
    
    public static int countInversion(int[] arrayInt, int first, int last)
    {
        if(first==last)
        {
            return 0;
        }
        int middle = (int) Math.floor((first+last)/2.0);
        return countInversion(arrayInt, first, middle) + countInversion(arrayInt, middle+1, last) + mergeSortAndCountInversion(arrayInt, first, middle, last);
    }
    
    public static int mergeSortAndCountInversion(int[] arrayInt, int first, int middle, int last)
    {
        int countInversion = 0;
        if(first==last)
        {
            return countInversion;
        }
        ArrayList<Integer> ali = new ArrayList<Integer>();
        int i = first;
        int j = middle+1;
        while(i<=middle && j<=last)
        {
            if(arrayInt[i]>=arrayInt[j])
            {
                ali.add(arrayInt[i]);
                i++;
                countInversion += (last-j+1);
            }
            if(arrayInt[i]<arrayInt[j])
            {
                ali.add(arrayInt[j]);
                j++;
            }
        }
        for(int k = i ; k<=middle ; k++)
        {
            ali.add(arrayInt[k]);
        }
        for(int k = j ; k<=last ; k++)
        {
            ali.add(arrayInt[k]);
        }
        for(int k = first ; k<=last ; k++)
        {
            arrayInt[k] = ali.get(k-first);
        }
        
        return countInversion;
    }
}
