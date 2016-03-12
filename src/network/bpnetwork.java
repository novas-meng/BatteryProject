package network;

import math.Vector;

import java.util.ArrayList;

/**
 * Created by novas on 2016/2/4.
 */
public class bpnetwork
{
    /*
     输入层采用4个神经元，隐藏层采用6个神经元，输出层采用1个神经元,4-6-1结构
     */
    int inputLayout=4;
    int hiddenLayout=8;
    int outputLayout=1;
    //o表示阈值
    public static double o=0.9;
    //学习速率步长 0.1-0.4之间
    double n=0.1;
    //样本输入
    ArrayList<Vector> inputSampleList=new ArrayList<Vector>();
    //期望输出
    ArrayList<Vector> expectOutputSampleList=new ArrayList<Vector>();
    //输入层到隐藏层的权系数，输入层4个神经元，隐藏层6个神经元
    Vector[] inputToHiddenMartix=Vector.getRandomVectorArray(inputLayout+1,hiddenLayout);
    //隐藏层到输出层的权系数，隐藏层6个神经元，输出层1个神经元
    Vector[] hiddenToOutputMartix=Vector.getRandomVectorArray(hiddenLayout+1 ,1);
    //隐藏层输出
    Vector hiddenOutputVector;
    //输出层输出
    Vector outputVector;
    public bpnetwork(ArrayList<Vector> inputSampleList,ArrayList<Vector> expectOutputSampleList)
    {
        this.inputSampleList=inputSampleList;
        this.expectOutputSampleList=expectOutputSampleList;
        train();
    }
    public Vector train(Vector vector)
    {
        System.out.println("输入"+vector);
        for(int l=0;l<inputToHiddenMartix.length;l++)
        {
            System.out.println(inputToHiddenMartix[l]);
        }
        Vector hiddenVector=CalOutputVector(vector,inputToHiddenMartix);
        System.out.println("隐藏层输出"+hiddenVector);
        for(int l=0;l<inputToHiddenMartix.length;l++)
        {
            System.out.println(inputToHiddenMartix[l]);
        }
        //然后计算输出层输出
        Vector outputtempVector=CalOutputVector(hiddenVector,hiddenToOutputMartix);
        System.out.println("输出层输出"+outputtempVector);
        return outputtempVector;
    }
    public void train()
    {
        int count=0;
        double errorhold = 0;
        do
        {
            errorhold=0;
            for(int i=0;i<inputSampleList.size();i++) {
           //  System.out.println(i);
              count++;
              Vector inputVector = inputSampleList.get(i);
              // System.out.println("输入向量 "+inputVector);
              //首先计算隐藏层输出
              Vector hiddenVector = CalOutputVector(inputVector, inputToHiddenMartix);
              // System.out.println("隐藏层输出"+hiddenVector);
              //然后计算输出层输出
              Vector outputtempVector = CalOutputVector(hiddenVector, hiddenToOutputMartix);
             // System.out.println("实际输出" + outputtempVector);
              //真实输出
              Vector realOutputVector = expectOutputSampleList.get(i);
            //  System.out.println("期望输出" + realOutputVector);
                errorhold = getError(outputtempVector, realOutputVector)+errorhold;
              //计算每一层的D
              //输出层D
             // double a = outputtempVector.getValue()[0];
            //  double b = realOutputVector.getValue()[0];
              Vector outputDVector = outputtempVector.subInteger(1).multipleVector(outputtempVector).multipleVector(outputtempVector.subVector(realOutputVector));
              Vector vector1 = outputtempVector.subInteger(1);
              // System.out.println("============="+vector1+"   "+outputtempVector);
              Vector vector2 = vector1.multipleVector(outputtempVector);
              // System.out.println("错误值 输出层"+outputDVector+"    "+(a*(1-a)*(b-a))+"   "+vector2+"    "+(1-a)*a);
              //计算隐藏层D
              Vector hiddenDVector = CalD(hiddenVector, hiddenToOutputMartix[0], outputDVector);

              //修正权系数
              //修正隐藏层到输出层系数
              // System.out.println("hiddenVector="+hiddenDVector.getLength());
              justW(hiddenToOutputMartix, outputDVector, hiddenVector);
              //  System.out.println("校正前");
              //  for( int k=0;k<inputToHiddenMartix.length;k++)
              //  {
              //  System.out.println(inputToHiddenMartix[k]);
              //  }
              //  System.out.println("次序"+i+"输入向量"+inputVector);
              //   System.out.println("隐藏层误差"+hiddenDVector);
              //修正输入层到隐藏层系数
              justW(inputToHiddenMartix, hiddenDVector, inputVector);
              //  System.out.println("校正后");
              //  for( int k=0;k<inputToHiddenMartix.length;k++)
              // {
              // System.out.println(inputToHiddenMartix[k]);
              //  }
          }
            System.out.println("hold="+errorhold);
        }while (errorhold>0.000005);
    }
    //矫正权系数
    public void justW(Vector[] W,Vector d,Vector outputVector)
    {
        double[] dd=d.getValue();
        double[] oo=outputVector.getValue();
        for(int i=0;i<W.length;i++)
        {
            double[] ww=W[i].getValue();
            int j=0;
            for(j=0;j<ww.length-1;j++)
            {
               // System.out.println("oo="+oo[j]);
                ww[j]=ww[j]-this.n*dd[i]*oo[j];
            }
            ww[j]=ww[j]-this.n*dd[i];
            W[i]=new Vector(ww);
        }
    }
    //计算D
    public Vector CalD(Vector currentout,Vector W,Vector d)
    {
        //System.out.println("W="+W);
       // System.out.println("隐藏层输出"+currentout);
        Vector vector=currentout.subInteger(1);
      //  System.out.println("减1"+vector);
        Vector vector1=currentout.multipleVector(vector);
      //  System.out.println("减1相乘之后"+vector1+"   "+d.getLength());
        double[] temp=new double[W.getLength()];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=W.getValue()[i]*d.getValue()[0];
        }
        return vector.multipleVector(new Vector(temp));
    }
    //计算每层的输出
    public Vector CalOutputVector(Vector inputVector,Vector[] VectorMartix)
    {
        double[] tempout=new double[VectorMartix.length];
       // System.out.println("length="+VectorMartix.length+"   "+VectorMartix[0]);
        for(int i=0;i<VectorMartix.length;i++)
        {
            tempout[i]=sigmoid.sigmoid(inputVector.multipleADDVector(VectorMartix[i]));
          //  System.out.println("tempout[i]="+tempout[i]);
        }
        return new Vector(tempout);
    }
    public double getError(Vector vector2,Vector vector1)
    {
        double error=0;
        double[] data1=vector1.getValue();
        double[] data2=vector2.getValue();
        for(int i=0;i<data1.length;i++)
        {
            error=error+0.5*(data1[i]-data2[i])*(data1[i]-data2[i]);
        }
       // System.out.println("错误率"+error);
        return error;
    }
}
