import java.util.*;
import java.lang.Math;
import java.math.*;
public class ASum {
  
  public static long findNb(long m) {
    // your code
    
        BigInteger b = new BigInteger(String.valueOf(m));
        
        BigInteger res = b.sqrt();
        res = res.multiply(new BigInteger("2"));
        res = res.sqrt();
        
        BigInteger tmp = res.multiply(res.add(new BigInteger("1")));
        tmp = tmp.multiply(tmp);
        tmp = tmp.divide(new BigInteger("4"));
        
        if(tmp.compareTo(b) == 0){
          return res.intValue();
        }
    return -1;
    
  } 
}
