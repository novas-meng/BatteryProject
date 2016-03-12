package Model;

import javax.sql.StatementEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by novas on 2016/3/12.
 */
public class mySqlModel
{
    java.sql.Connection conn;
    HashMap<String,double[]> map=new HashMap<String, double[]>();
    public double[] readData(File f)
    {
        ArrayList<Double> list=new ArrayList<Double>();
        double[] res=null;
        BufferedReader br=null;
        try
        {
            br =new BufferedReader(new FileReader(f));
            String line=br.readLine();
            while (line!=null)
            {
                list.add(Double.parseDouble(line));
                line=br.readLine();
            }
            res=new double[list.size()];
            for(int i=0;i<list.size();i++)
            {
                res[i]=list.get(i);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public void initData()
    {
        File f=new File("../BatteryProject");
        File[] files=f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(".txt"))
                    return true;
                return false;
            }
        });
        for(int i=0;i<files.length;i++)
        {
            //System.out.println(files[i].getName());
            String name=files[i].getName();
            name=name.substring(0,name.indexOf("."));
            System.out.println("name="+name);
            map.put(name,readData(files[i]));
        }
    }
    public void connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/novas?user=root");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void insert()
    {
        try
        {
            java.sql.Statement sql=conn.createStatement();
            Set<String> keySet=map.keySet();
            Iterator<String> iterator=keySet.iterator();
            while (iterator.hasNext())
            {
                String key=iterator.next();
                System.out.println("key="+key);
                double[] value=map.get(key);
                for(int i=0;i<value.length;i++)
                {
                    System.out.println(value[i]);
                    String query="insert into battery values( "+"'"+key+"',"+"'"+"li"+"',"+(i+1)+","+value[i]+","+value[i]+","+value[i]+")";
                    //  String query="insert into battery values('s4os','li',2,2,2,2)";
                    sql.executeUpdate(query);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public mySqlModel()
   {
        initData();
        connect();
   }
    public tableNode[] query()
    {
        ArrayList<tableNode> list=new ArrayList<tableNode>();
        try {
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from battery");
            while (resultSet.next())
            {
                String bianhao=resultSet.getString(1);
                String xinghao=resultSet.getString(2);
                int zhouqi=resultSet.getInt(3);
                double rongliang=resultSet.getDouble(4);
                double wendu=resultSet.getDouble(5);
                double dianya=resultSet.getDouble(6);
                list.add(new tableNode(bianhao,xinghao,zhouqi,rongliang,wendu,dianya));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        tableNode[] tableNodes=new tableNode[list.size()];
        list.toArray(tableNodes);
        return tableNodes;
    }

    public static void main(String[] args)
    {
        mySqlModel mySqlModel=new mySqlModel();
    }
}
