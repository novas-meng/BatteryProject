import java.sql.DriverManager;

/**
 * Created by novas on 2016/3/12.
 */
public class mysqltest
{
    public static void main(String[] args)throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/novas?user=root");
        java.sql.Statement sql=conn.createStatement();
        java.sql.ResultSet rs=sql.executeQuery("select * from pet");
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
    }
}
