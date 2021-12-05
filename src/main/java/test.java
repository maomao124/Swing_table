import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Project name(项目名称)：Swing表格
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/5
 * Time(创建时间)： 12:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("测试");
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.setLocation(200, 200);
        jFrame.setSize(1280, 720);

        jFrame.addWindowListener(new WindowListener()
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
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 5));
        JTextArea jTextArea = new JTextArea(20, 20);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel.add(jScrollPane);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        JLabel label = new JLabel("");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        JTextArea jTextArea1 = new JTextArea(30, 30);
        JPanel jPanel1 = new JPanel();
        jPanel1.add(jTextArea1);
        try
        {
            int pos = jTextArea.getCaretPosition();
            //获取行数
            int lineOfC = 0;
            lineOfC = jTextArea.getLineOfOffset(pos) + 1;
            //获取列数
            int col = pos - jTextArea.getLineStartOffset(lineOfC - 1) + 1;
            System.out.println("当前光标位置:" + lineOfC + "行," + col + "列");
        }
        catch (BadLocationException e)
        {
            System.out.println("无法获取光标位置");
            e.printStackTrace();
        }
        jFrame.remove(jPanel);
        jFrame.add(jPanel1);
        jPanel1.updateUI();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        jFrame.remove(jPanel1);
        jFrame.add(jPanel);
        jPanel.add(label);
        //jPanel.updateUI();
        jFrame.repaint();
        jTextArea.addCaretListener(new CaretListener()
        {
            @Override
            public void caretUpdate(CaretEvent e)
            {
                try
                {
                    int pos = jTextArea.getCaretPosition();
                    //获取行数
                    int lineOfC = 0;
                    lineOfC = jTextArea.getLineOfOffset(pos) + 1;
                    //获取列数
                    int col = pos - jTextArea.getLineStartOffset(lineOfC - 1) + 1;
                    System.out.println("当前光标位置:" + lineOfC + "行," + col + "列");
                    label.setText("当前光标位置:" + lineOfC + "行," + col + "列");
                }
                catch (BadLocationException e1)
                {
                    System.out.println("无法获取光标位置");
                    label.setText("无法获取光标位置");
                    //e1.printStackTrace();
                }
            }
        });

    }
}
