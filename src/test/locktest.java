package test;

import java.util.Objects;

/**
 * Created by novas on 2016/2/8.
 */
public class locktest
{
    public static void main(String[] args)
    {
        String A=new String("A");
        String B=new String("B");
        String C=new String("C");
        printthread printA=new printthread(C,A,B);
        printthread printB=new printthread(A,B,C);
        printthread printC=new printthread(B,C,A);
        Thread AT=new Thread(printA);
        Thread BT=new Thread(printB);
        Thread CT=new Thread(printC);
        AT.start();
        BT.start();
        CT.start();
    }
}
class printthread implements Runnable
{
    String print;
    Object pre;
    Object last;
    public printthread(Object pre,String print,Object last)
    {
        this.pre=pre;
        this.print=print;
        this.last=last;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            try
            {
                synchronized (pre)
                {
                    synchronized (print)
                    {
                        System.out.println(print);
                        print.notify();
                        System.out.println("====");
                    }
                    pre.wait();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }
    }
}
