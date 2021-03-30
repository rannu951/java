import java.util.*;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {
    
        Map<Character, Integer> hash = new HashMap<>();
        
        
        for (int i = 0; i < str2.length(); i++) 
        {
            hash.put(str2.charAt(i), hash.containsKey(str2.charAt(i)) ? hash.get(str2.charAt(i)) + 1 : 1);
        }

        
        for(int i=0; i < str1.length(); i++)
        {
            if(hash.containsKey(str1.charAt(i)))
                hash.put(str1.charAt(i),hash.get(str1.charAt(i)) - 1);
        }

        
        for(Map.Entry<Character, Integer> entry : hash.entrySet())
        {
          if(entry.getValue() > 0)
          {
            return false;
          }
        }
        return true;   
        
    }
}
