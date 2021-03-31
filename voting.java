import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(3);        
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        System.out.println(voting(arr,3));


    }

    public static ArrayList<Integer> voting(ArrayList<Integer> arr, Integer repCount)
    {
    	HashMap<Integer, Integer> hash = new HashMap<>();
        Iterator<Integer> sequence = arr.iterator();

        while(sequence.hasNext())
        {
        	Integer buf = sequence.next();
        	hash.put(buf, hash.containsKey(buf) ? hash.get(buf)+1 : 1);
        }

        ArrayList<Integer> ret = new ArrayList<Integer>();

        for(Map.Entry<Integer, Integer> entry : hash.entrySet())
        {
        	if(entry.getValue() > repCount)
        	{
        		ret.add(entry.getKey());
        	}
        }
        return ret;
    }

}
