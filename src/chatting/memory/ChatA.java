package chatting.memory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame{
	//�ʿ��ϸ� �����϶�!@!
	JTextArea area;
	JScrollPane scroll;
	JTextField txt;
	JButton bt;
	JPanel p;
	ChatB chatB;
	
	public ChatA() {
		area=new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		bt= new JButton("open");
		p=new JPanel();
		
		
		p.add(txt);
		p.add(bt);
		
		//�����ڰ� ���̾ƿ��� �������� ������ ������ �ƴ϶�
		//����Ʈ ���̾ƿ��� �����...
		//�ڹ� GUI ��� ������Ʈ�� ���̾ƿ� �ɷ��� �ִ°� �ƴ϶�,
		//�����̳����� ���̾ƿ� �ɷ��� �ִ�...
		// ���� ���� �� �� �ִ� ����	: �����̳� (Frame, Panel)
		//										���� �����ϱ� ���� ��ġ�� ���....
		//										Frame : BorderLayout
		//										Panel  : FlowLayout
		// ���ԵǴ� ����					: ���־� ������Ʈ(Button,check...)
		add(scroll,BorderLayout.CENTER);//* ���� �𸣴� ��*
		add(p,BorderLayout.SOUTH);
		
		//���� ����!!
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openB();
			}
		});
		
		txt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER) {
					String msg=txt.getText();
					area.append(msg+"\n");
					chatB.area.append(msg+"\n");
					txt.setText("");
				}
			}
		});
		
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void openB() {
		//��ȭ ������ ChatB�� �����Ѵ�!!
		chatB=new ChatB(this);

	}
	public static void main(String[] args) {
		new ChatA();
	}
}
