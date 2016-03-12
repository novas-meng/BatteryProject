package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataModel
{
    mySqlModel mySqlModel;
    public  DataModel()
    {
        mySqlModel=new mySqlModel();
    }
    private tableNode[] tableNodes;
    /*
    ������������ͼ��Model,�������Ǹ���sqlmodel ���ɵ�tablenodes����LineChartModel��tablenodes�������е���Ϣ���������ͨ����Ž��л�����
     */
    public LineChartModel getLineChartModel()
    {
        LineChartModel lineChartModel=new LineChartModel();
        HashMap<String,ArrayList<Double>> map=new HashMap<String, ArrayList<Double>>();
        for(int i=0;i<tableNodes.length;i++)
        {
            String key=tableNodes[i].bianhao;
            if(map.containsKey(key))
            {
                ArrayList<Double> arrayList=map.get(key);
                arrayList.add(tableNodes[i].rongliang);
            }
            else
            {
                ArrayList<Double> arrayList=new ArrayList<Double>();
                map.put(key,arrayList);
            }
        }
        Set<String> keySet=map.keySet();
        Iterator<String> iterator=keySet.iterator();
        while (iterator.hasNext())
        {
            String key=iterator.next();
            ArrayList<Double> arrayList=map.get(key);
            double[] datas=new double[arrayList.size()];
            for(int i=0;i<arrayList.size();i++)
                datas[i]=arrayList.get(i);
            System.out.println("key="+key+"length="+datas.length);
            lineChartModel.add(key,datas);
        }
        return lineChartModel;
    }
    public void initTableNodeArray()
    {
        /*
        String bianhao="B005";
        String xinghao="li";
        BufferedReader br=null;
        ArrayList<tableNode> list=new ArrayList<tableNode>();
        try {
            int count=0;
            br=new BufferedReader(new FileReader("B0005.txt"));
            String line=br.readLine();
            while (line!=null)
            {
                count++;
                list.add(new tableNode(bianhao,xinghao,count,line));
                line=br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        tableNodes=new tableNode[list.size()];
        list.toArray(tableNodes);
        */
        tableNodes=mySqlModel.query();
    }
    public tableNode[] getTableNodeArray()
    {
        return tableNodes;
    }
}
