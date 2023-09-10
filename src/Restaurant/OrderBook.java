package Restaurant;

import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.*;

public class OrderBook extends JFrame implements ActionListener {
	long random;
	JTextField shopNameTextF,qtyTextF,priceTextF;
	JComboBox itemNameTextF,deliveryboyTextF;
	JDateChooser cal;
	JButton btn,btn2;
	
	public OrderBook(){
		setLayout(null);
		setTitle("SAI PRASAD RESTAURANT ");
		Random ran=new Random();
		random=(Math.abs(ran.nextLong()% 9000L)+1000L);
		
		
		JLabel billno=new JLabel("Bill No: "+random);
		billno.setBounds(290,80,400,30);
		billno.setFont(new Font("Raleway",Font.BOLD,30));
		add(billno);
		
		JLabel dob=new JLabel("Date :");
		dob.setBounds(370,160,400,30);
		dob.setFont(new Font("Raleway",Font.BOLD,25));
		add(dob);
		
		cal=new JDateChooser();
		cal.setBounds(450,160,200,30);
		cal.setFont(new Font("Raleway",Font.BOLD,15));
		add(cal);
		
		JLabel shopName=new JLabel("Shop Name ");
		shopName.setBounds(100,220,400,30);
		shopName.setFont(new Font("Raleway",Font.BOLD,25));
		add(shopName);
		
		shopNameTextF=new JTextField();
		shopNameTextF.setBounds(260,220,400,30);
		shopNameTextF.setFont(new Font("Raleway",Font.BOLD,18));
		add(shopNameTextF);
		
		JLabel itemName=new JLabel("Item Name ");
		itemName.setBounds(100,290,400,30);
		itemName.setFont(new Font("Raleway",Font.BOLD,25));
		add(itemName);
		
		String item[]= {"None","Special Tea","Filter Coffee","Burger","Pizza","Fried Rice"};
		itemNameTextF=new JComboBox(item);
		itemNameTextF.setBounds(260,290,400,30);
		itemNameTextF.setFont(new Font("Raleway",Font.BOLD,18));
		add(itemNameTextF);
		
		JLabel deliveryboy=new JLabel("Delivery Boy ");
		deliveryboy.setBounds(100,360,400,30);
		deliveryboy.setFont(new Font("Raleway",Font.BOLD,25));
		add(deliveryboy);
		
		
		String dboy[]= {"None","Nithin","Sharad","Ashish"};
		deliveryboyTextF=new JComboBox(dboy);
		deliveryboyTextF.setBounds(260,360,400,30);
		deliveryboyTextF.setFont(new Font("Raleway",Font.BOLD,18));
		add(deliveryboyTextF);
		
		JLabel qty=new JLabel("Quantity");
		qty.setBounds(100,430,400,30);
		qty.setFont(new Font("Raleway",Font.BOLD,25));
		add(qty);
		
		qtyTextF=new JTextField();
		qtyTextF.setBounds(260,430,400,30);
		qtyTextF.setFont(new Font("Raleway",Font.BOLD,18));
		add(qtyTextF);
		
		JLabel price=new JLabel("Amount");
		price.setBounds(100,500,400,30);
		price.setFont(new Font("Raleway",Font.BOLD,25));
		add(price);
		
		priceTextF=new JTextField();
		priceTextF.setBounds(260,500,400,30);
		priceTextF.setFont(new Font("Raleway",Font.BOLD,18));
		add(priceTextF);
		
		
		btn=new JButton("SUBMIT");
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setFont(new Font("Raleway",Font.BOLD,13));
		btn.addActionListener(this);
		btn.setBounds(420,560,100,30);
		add(btn);
		

		btn2=new JButton("CLEAR");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setFont(new Font("Raleway",Font.BOLD,13));
		btn2.addActionListener(this);
		btn2.setBounds(520,560,80,30);
		add(btn2);
		
		setSize(800,730);
		getContentPane().setBackground(Color.gray);
		setLocation(320,0);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae){
		String formno=""+random;
		String dob=((JTextField)cal.getDateEditor().getUiComponent()).getText();
		String sshopname=shopNameTextF.getText();
		String dname=(String)deliveryboyTextF.getSelectedItem();
		String qqty=qtyTextF.getText();
		String amt=priceTextF.getText();
		
		
		try {
			if(ae.getSource()==btn2) {
				shopNameTextF.setText("");
				qtyTextF.setText("");
				priceTextF.setText("");
			}else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Date");
			}else if(sshopname.equals("")) {
				JOptionPane.showMessageDialog(null, "Shop Name is Required");
			}else if(qqty.equals("")) {
				JOptionPane.showMessageDialog(null, "Quanity is Required");
			}
			else if(amt.equals("")) {
				JOptionPane.showMessageDialog(null, "Total Amount is Required");
			}
			else {
				Conn c=new Conn();
				String query="INSERT into orderbook values('"+formno+"','"+dob+"','"+sshopname+"','"+dname+"','"+qqty+"','"+amt+"')";
				c.s.executeUpdate(query);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new OrderBook();
		
	}

}
