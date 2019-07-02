package net;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	//�ʿ��ϸ� �����϶�!@!
	JTextArea area;
	JScrollPane scroll;
	JTextField t_port,txt;
	JButton bt,bt_connect;
	Choice ch;//ip����	
	JPanel p_north,p;
	String[] ip= {"143","15","41","51","55","60","67","79"};
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public ChatClient() {
		area=new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		bt= new JButton("open");
		p=new JPanel();
		

		
		ch=new Choice();
		t_port=new JTextField("7777");
		bt_connect=new JButton("join");
		p_north=new JPanel();
		
		//ip
		for(int i=0;i<ip.length;i++) {
			ch.add("192.168.0."+ip[i]);
		}
		//
		
		//add pannel
		p_north.add(ch);
		p_north.add(t_port);
		p_north.add(bt_connect);
		//pannel location north
		add(p_north,BorderLayout.NORTH);
		
		p.add(txt);
		p.add(bt);
		
		add(scroll,BorderLayout.CENTER);//* ���� �𸣴� ��*
		add(p,BorderLayout.SOUTH);
		
		//���� ����!!
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		txt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					send(txt.getText());
					
				}
			}
		});
		
		//join event
		bt_connect.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void connect() {
		String ip=ch.getSelectedItem();
		int port=Integer.parseInt(t_port.getText()); // "7777" -> 7777
		
		//join to server!!
		try {
			client = new Socket(ip, port);
			
			//�������κ��� ��Ʈ�� ���!!
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//���������κ��� �ޱ�
	public void listen() {
		String msg=null;
		try {
			msg= buffr.readLine();
			area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void send(String msg) {
		//������ ������ ����
		try {
			buffw.write(msg+"\n");//���ڿ��� ���� �ٹٲ�ǥ�ð� �־�� ������ ���� �����Ѵ�
									 // ���� ������������ ���ڿ��� ���� ���� ������ ���
									// ����ϰ� ����
			buffw.flush();//����ó���� ��½�Ʈ�� �迭���� �� �޼��带 ȣ���ϸ�
			//���� ��Ʈ���� �׿��ִ� �����͸� ��� ���� ��ġ ���� �� �����°Ͱ� ����
			listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
