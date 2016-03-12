package graph;

import Model.DataModel;
import Model.tableNode;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Created by novas on 2016/2/6.
 */
public class paramtable extends JInternalFrame
{
   int parentwidth;
   int parentheight;
   public paramtable(DataModel dataModel,int parentwidth,int parentheight)
   {
       this.parentwidth=parentwidth;
       this.parentheight=parentheight;
       Table_Model model=new Table_Model(dataModel.getTableNodeArray());
       JTable table=new JTable(model);

       JScrollBar scrollBar=new JScrollBar();
       JScrollPane jScrollPane=new JScrollPane(table);
       jScrollPane.setVerticalScrollBar(scrollBar);
       this.setTitle("数据图表");
       this.setBorder(null);
       this.setResizable(false);
     //  this.setFocusable(false );
    //   this.setBounds(20,(int)(1.7*parentheight/3)+10,parentwidth/8*6,parentheight/3);
       this.add(jScrollPane);
       this.setVisible(true);
   }
}
class Table_Model extends AbstractTableModel
{

    String[] titlename={"编号","型号","周期","容量"};
    tableNode[] data;
    public Table_Model(tableNode[] data)
    {
        this.data=data;
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int column) {
        return titlename[column];
    }

    @Override
    public int getColumnCount() {
        return titlename.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex].get(columnIndex);
    }
}
