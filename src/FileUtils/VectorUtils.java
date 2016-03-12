package FileUtils;

import math.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by novas on 2016/2/4.
 */
public class VectorUtils
{
    public static double[] getData(String path)
    {
        BufferedReader br=null;
        ArrayList<Double> list=new ArrayList();
        try {
            br=new BufferedReader(new FileReader(path));
            String line=br.readLine();
            while(line!=null)
            {
                list.add(Double.parseDouble(line));
                line=br.readLine();
            }
            double[] res=new double[list.size()];
            for(int i=0;i<res.length;i++)
            {
                res[i]=list.get(i);
            }
            return res;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Vector> getInputSampleVectors(double[] data,int length)
    {
        ArrayList<Vector> inputSampleVectorList=new ArrayList<Vector>();
        for(int i=0;i<data.length/4;i++)
        {
            double[] res=new double[length+1];
            int j=0;
            for(j=0;j<res.length-1;j++)
            {
                res[j]=data[i+j];
            }
            res[j]=1;
            inputSampleVectorList.add(new Vector(res));
        }
        return inputSampleVectorList;
    }
    public static ArrayList<Vector> getOutputSampleVectors(double[] data,int length)
    {
        ArrayList<Vector> outputSampleVectorList=new ArrayList<Vector>();
        for(int i=length;i<data.length/4+length;i++)
        {
            double[] res=new double[1];
            for(int j=0;j<res.length;j++)
            {
                res[j]=data[i];
            }
            outputSampleVectorList.add(new Vector(res));
        }
        return outputSampleVectorList;
    }
    public static double getMin(double[] data)
    {
        double min=10;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]<min)
            {
                min=data[i];
            }
        }
        return min;
    }
    public static double getMax(double[] data)
    {
        double max=0;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]>max)
            {
                max=data[i];
            }
        }
        return max;
    }
    public static double[] toOne(double[] data,double max,double min)
    {
        double[] res=new double[data.length];
        for(int i=0;i<res.length;i++)
        {
            res[i]=(data[i]-min)/(max-min);
        }
        return res;
    }
    public static Vector generateVctor(double[] data,double max,double min)
    {
        double[] res=new double[data.length+1];
        System.arraycopy(data,0,res,0,data.length);
        int i=0;

        for(i=0;i<res.length-1;i++)
        {
            res[i]=(data[i]-min)/(max-min);
        }
        res[i]=1;
        return new Vector(res);
    }
}
