import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project name(项目名称)：Swing表格
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/5
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2 extends JFrame
{
    private JPanel contentPane;
    private JTable table;

    public test2()
    {
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowActivated(WindowEvent e)
            {
                do_this_windowActivated(e);
            }
        });
        setTitle("图书信息表");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        JButton button = new JButton("删除");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);
    }

    protected void do_this_windowActivated(WindowEvent e)
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"书名", "出版社", "出版时间", "丛书类别", "定价"});    //设置表头
        tableModel.addRow(new Object[]{"Java从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "59.8元"});    //增加列
        tableModel.addRow(new Object[]{"PHP从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元"});
        tableModel.addRow(new Object[]{"Visual Basic从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元"});
        tableModel.addRow(new Object[]{"Visual C++从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元"});
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
    }

    protected void do_button_actionPerformed(ActionEvent e)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();    //获得表格模型
        int[] selectedRows = table.getSelectedRows();
        for (int i = selectedRows[0]; i < selectedRows.length; i++)
        {
            model.removeRow(selectedRows[0]);
        }
        table.setModel(model);
    }

    public static void main(String[] args)
    {
        test2 frame = new test2();
        frame.setVisible(true);
    }
}
