package Model;

import java.util.HashMap;

/**
 * Created by novas on 2016/2/6.
 */
//ÕÛÏßÍ¼Êý¾ÝModel
public class LineChartModel
{
    HashMap<String,double[]> data=new HashMap<String, double[]>();
    //int Xlength;
    public LineChartModel()
    {

    }
    public void add(String key,double[] value)
    {
      //  Xlength=value.length;
        data.put(key,value);
    }
    public double[] getYValue(String key)
    {
        return data.get(key);
    }
    public String[] getAllKeys()
    {
        String[] strs=new String[data.size()];
        data.keySet().toArray(strs);
        return strs;
    }
    public double[] getXValues(String key)
    {
        int Xlength=data.get(key).length;
        double[] xs=new double[Xlength];
        for(int i=0;i<xs.length;i++)
        {
            xs[i]=i;
        }
        return xs;
    }
}
