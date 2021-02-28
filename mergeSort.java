import java.util.*;
import java.lang.Math;
public class MyClass {
    public static void main(String args[]) {
        
        int[] arrayInt = {1,5,3,7,2,2,4,6,8,9};

        
        mergeSort(arrayInt , 0 , arrayInt.length-1);
        
        for(int i=0 ; i<arrayInt.length ; i++){
            System.out.println(arrayInt[i]);
        }
        
    }
    
    public static void mergeSort(int[] arrayInt, int first, int last)
    {
        int middle = (int) Math.floor((first+last)/2.0);
        if(first==last)
        {
            return;
        }
        
        mergeSort(arrayInt, first, middle);
        mergeSort(arrayInt, middle+1, last);
     
        ArrayList<Integer> ali = new ArrayList<Integer>();
        int i = first;
        int j = middle+1;
        while(i<=middle && j<=last)
        {
            if(arrayInt[i]<=arrayInt[j])
            {
                ali.add(arrayInt[i]);
                i++;
            }
            if(arrayInt[i]>arrayInt[j])
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
    }
    
    
}
