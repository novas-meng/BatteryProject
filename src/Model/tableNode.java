package Model;

/**
 * Created by novas on 2016/3/12.
 */
public class tableNode
{
    String bianhao;
    String xinghao;
    int zhouqi;
    double rongliang;
    double wendu;
    double dianya;
    public tableNode(String bianhao,String xinghao,int zhouqi,double rongliang,double wendu,double dianya)
    {
        this.bianhao=bianhao;
        this.xinghao=xinghao;
        this.zhouqi=zhouqi;
        this.rongliang=rongliang;
        this.wendu=wendu;
        this.dianya=dianya;
    }
    public Object get(int index)
    {
        switch (index)
        {
            case 0:
                return bianhao;
            case 1:
                return xinghao;
            case 2:
                return zhouqi;
            case 3:
                return rongliang;
            case 4:
                return wendu;
            case 5:
                return dianya;
            default:
                return null;
        }
    }
}
