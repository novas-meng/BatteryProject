import FileUtils.VectorUtils;
import math.Vector;
import network.bpnetwork;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by novas on 2016/2/4.
 */
public class test {

    public static void main(String[] args)
    {
        double[] data= VectorUtils.getData("B0005.txt");
        double max=VectorUtils.getMax(data);
        double min=VectorUtils.getMin(data);
        max=100;
        min=0;
        data=VectorUtils.toOne(data,max,min);
        for(int i=0;i<data.length;i++)
        {
            System.out.println(data[i]);
        }
        ArrayList<Vector> inputSampleList=VectorUtils.getInputSampleVectors(data,4);
        ArrayList<Vector> outputSampleList=VectorUtils.getOutputSampleVectors(data,4);
        bpnetwork bpnetwork=new bpnetwork(inputSampleList,outputSampleList);
        Vector vector1=inputSampleList.get(inputSampleList.size()-1);
        System.out.println("输入向量"+vector1);
        System.out.println("期望输出"+outputSampleList.get(outputSampleList.size()-1).getValue()[0]);
        Vector vector=bpnetwork.train(vector1);
        System.out.println(vector.getValue()[0]);
    }
}
