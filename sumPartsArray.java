class SumParts {

  public static int[] sumParts(int[] ls) {

    int[] ls2 = new int[ls.length+1];
    for(int i=0 ; i<ls2.length ; i++)
    {
        ls2[i] = 0;
    }
    int tmp = 0;
    for(int i=0 ; i<ls.length ; i++)
    {
        tmp += ls[i]; 
    }
    int tmp2 = 0;
    for(int i=0 ; i<ls2.length ; i++)
    {
        if(i>0)
        {
            tmp2 += ls[i-1];
            ls2[i] = tmp - tmp2;
        }
        else
        {
            ls2[i] = tmp;
        }
    }
    return ls2;
  }
}
