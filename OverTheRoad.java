public class MyClass {
    public static void main(String args[]) 
    {
      System.out.println(overTheRoad(10,5));
    }
    public static long overTheRoad(long address, long n) 
    {
        if(address%2==1)
        {
          return address+(n*2-1)-((address-1)/2)*4;
        }
        else
        {
          return address-((n*2-1)-(((n*2)-address)/2)*4);
        }
    }
}
