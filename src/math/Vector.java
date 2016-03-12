package math;

import network.bpnetwork;

import java.util.Random;

/**
 * Created by novas on 2016/2/4.
 */
public class Vector
{
    double[] var1;
    int length;
    public int getLength()
    {
        return this.length;
    }
    public Vector(double[] var1)
    {
        this.var1=var1;
        this.length=this.var1.length;
    }
    public double[] getValue()
    {
        double[] res=new double[var1.length];
        System.arraycopy(var1,0,res,0,var1.length);
        return res;
    }
    public double multipleADDVector(Vector vector)
    {
        double sum=0;
        for(int i=0;i<length;i++)
        {
            sum=sum+var1[i]*vector.var1[i];
        }
        return sum;
    }
    public Vector multipleVector(Vector vector)
    {
        double[] res=this.getValue();
        double[] temp=vector.getValue();
        for(int i=0;i<res.length;i++)
        {
            res[i]=res[i]*temp[i];
        }
        return new Vector(res);
    }
    public Vector subInteger(int x)
    {
        double[] res=this.getValue();
        for(int i=0;i<res.length;i++)
        {
            res[i]=1-res[i];
        }
        return new Vector(res);
    }
    public Vector subVector(Vector x)
    {
        double[] res=this.getValue();
        double[] temp=x.getValue();
        for(int i=0;i<res.length;i++)
        {
            res[i]=res[i]-temp[i];
        }
        return new Vector(res);
    }
    //public Vector sub
    //获取权值向量
    public static Vector[] getRandomVectorArray(int vectorlength,int vectorcount)
    {
        Vector[] vectors=new Vector[vectorcount];
        Random random=new Random();
        for(int i=0;i<vectorcount;i++)
        {
            double[] array=new double[vectorlength];
            int j=0;
            for(j=0;j<array.length-1;j++)
            {
                //array[j]=0.1;
                array[j]=random.nextDouble()%0.1;
            }
            array[j]= -bpnetwork.o;
            vectors[i]=new Vector(array);
        }
        return vectors;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<var1.length;i++)
        {
            sb.append("["+var1[i]+"]");
        }
        sb.append("\n");
        return sb.toString();
    }
}
