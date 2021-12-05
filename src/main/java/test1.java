import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

/**
 * Project name(项目名称)：Swing表格
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/5
 * Time(创建时间)： 13:22
 * Version(版本): 1.0
 * Description(描述)： 表格是 Swing 新增加的组件，主要功能是把数据以二维表格的形式显示出来，并且允许用户对表格中的数据进行编辑。
 * 表格组件是最复杂的组件之一，它的表格模型功能非常强大、灵活而易于执行。
 * Swing 使用 JTable 类实现表格，常用构造方法如下所示。
 * JTable()：构造一个默认的 JTable，使用默认的数据模型、默认的列模型和默认的选择模型对其进行初始化。
 * JTable(int numRows,int numColumns)：使用 DefaultTableModel 构造具有 numRows 行和 numColumns 列个空单元格的 JTable。
 * JTable(Object[][] rowData,Object[] columnNames)：构造一个 JTable 来显示二 维数组 rowData 中的值，其列名称为 columnNames。
 * JTable类的常用方法
 * 方法名称	说明
 * getColumnCount()	返回列模型中的列数
 * getColumnN ame(int column)	返回出现在视图中 column 列位置处的列名称
 * getRowCount()	返回 JTable 中可以显示的行数（给定无限空间）
 * getRowSorter()	返回负责排序的对象
 * getSelectedColumn()	返回第一个选定列的索引，如果没有选定的列， 则返回 -1
 * getSelectedRow()	返回第一个选定行的索引，如果没有选定的行， 则返回 -1
 * getValueAt(int row,int column)	返回 row 和 column 位置的单元格值
 * isEditing()	如果正在编辑单元格，则返回 true
 * selectAll()	选择表中的所有行、列和单元格
 * setColumnSelectionInterval(int index0,int index1)	选择从 index0 到 index1之间（包含两端）的列
 * setRowSelectionInterval(int index0,int index1)	选择从 index0 到 index1 之间（包含两端）的行
 * setTableHeader(JTableHeader tableHeader)	将此 JTable 所使用的 tableHeader 设置为 newHeader
 * setUpdateSelectionOnSort(boolean update)	指定排序后是否应该更新选择
 * setValueAt(Object a Value,int row,int column)	设置表模型中 row 和 column 位置的单元格值
 */

public class test1
{
    public static double getDoubleRandom(double min, double max)  //double型随机数
    {
        if (min > max)
        {
            min = max;
        }
        return min + (Math.random() * (max - min));
    }

    public static double getDoubleRandom(double min, double max, String format)
    {            //空间复杂度和时间复杂度都特别高，只适合获取非常少的格式化的随机数使用。farmat：##.##或00.00
        DecimalFormat decimalFormat = new DecimalFormat(format);
        if (min > max)
        {
            min = max;
        }
        return Double.parseDouble(decimalFormat.format(min + (Math.random() * (max - min))));
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("学生成绩表");
        frame.setLocation(200, 200);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                int result;
                Toolkit.getDefaultToolkit().beep();
                result = JOptionPane.showConfirmDialog(null, "是否退出？", "提示", 0);
                if (result == 0)
                {
                    System.exit(1);
                }
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(20,100,20,100));
        jPanel.setLayout(new BorderLayout());
        Object[][] object = new Object[500][5];
        for (int i = 0; i < object.length; i++)
        {
            for (int j = 0; j < object[i].length; j++)
            {
                object[i][j] = getDoubleRandom(50,100);
            }
        }
        String[] name = {"学号", "姓名", "性别", "年龄", "绩点"};
        JTable table = new JTable(object, name);
        table.setPreferredScrollableViewportSize(new Dimension(900, 500));
        table.setAutoResizeMode(1);
        JScrollPane jScrollPane = new JScrollPane(table);
        jPanel.add(jScrollPane);
        frame.add(jPanel);
        frame.setVisible(true);
    }
}
