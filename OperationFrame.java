package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//记录离校信息
public class OperationFrame extends JFrame implements ActionListener {
    /************************定义各控件******************************/
    private String welcomMsg="选择如下操作:";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btQuery=new JButton("显示详细信息");
    private JButton btModify=new JButton("记录离校信息");
    private JButton btExit=new JButton("退出");
    public OperationFrame() {
        /****************************界面初始化************************/
        super("当前查询: "+Conf.account);
        this.setLayout(new GridLayout(4,1));
        this.add(lblWelcome);
        this.add(btQuery);
        this.add(btModify);
        this.add(btExit);
        this.setSize(300,250);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************增加监听*******************************/
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btQuery) {
            String message="您的详细资料为:\n";
            message+="姓名："+Conf.account+"\n";
            message+="学号："+Conf.password+"\n";
            message+="入校时间："+Conf.time+"\n";
            message+="离校时间："+Conf.leave+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==btModify) {
            new ModifyDialog(this);
        }
        else {
            JOptionPane.showMessageDialog(this,"谢谢光临");
            System.exit(0);
        }
    }
}
