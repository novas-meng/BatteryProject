package network;

/**
 * Created by novas on 2016/2/4.
 */
public class sigmoid
{
    //�����������sigmoid
    public static double sigmoid(double x)
    {
        x=-x;
        return 1.0/(1+Math.exp(x)) ;
    }
}
