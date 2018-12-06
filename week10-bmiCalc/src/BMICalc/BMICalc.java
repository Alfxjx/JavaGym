package BMICalc;

//��һ������Ӧ�ó�������ָ�������������ܸ����û�������Ա���ߡ����ؼ����������ָ������������ָ��������
//�������Ƿ�ƫ�ֵ��жϡ����У�����ָ����BMI��=���أ�kg�������^2��m��������24��Ϊƫ�֣�����ϸ���жϿ��������ϲ����ص����ϡ�
//Ҫ�����û�������������ı��򡢵�ѡ��ť����ť�������ֺ��¼�����

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import java.util.regex.*;

public class BMICalc extends JFrame implements ActionListener {
	JLabel head = new JLabel("BMI Calculator");
	
	JRadioButton standardCHN = new JRadioButton("China");
	JRadioButton standardWHO = new JRadioButton("WHO");
	JLabel lblHeight = new JLabel("Height");
	JLabel lblWeight = new JLabel("Weight");
	JButton btnRes = new JButton("BMI");
	JTextField htDisplay = new JTextField("height m");
	JTextField wtDisplay = new JTextField("weight kg");
	JTextField txtRes = new JTextField("BMI");
	JTextField txtJudge = new JTextField("");
	
	public BMICalc(){
		super("BMICalculator");
		Font font = new Font("Consolas", Font.BOLD, 16);
		// add components head BorderLayout
		JPanel pnlHead = new JPanel(new BorderLayout());
		pnlHead.add(head, BorderLayout.NORTH);
		head.setFont(font);
		// add components body GridLayout
		JPanel pnlBody = new JPanel(new GridLayout(4,2));
		pnlBody.add(standardCHN);
		pnlBody.add(standardWHO);
		pnlBody.add(lblHeight);
		pnlBody.add(htDisplay);
		pnlBody.add(lblWeight);
		pnlBody.add(wtDisplay);
		pnlBody.add(btnRes);
		pnlBody.add(txtRes);
		//add judge
		JPanel pnlJudge = new JPanel(new BorderLayout());
		pnlJudge.add(txtJudge);
		
		//�������������ܵĽ�������ƴ������
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.NORTH, pnlHead);
		getContentPane().add(BorderLayout.CENTER, pnlBody);
		getContentPane().add(BorderLayout.SOUTH, pnlJudge);
		
		// ����¼�����
		standardCHN.addActionListener(this);
		standardWHO.addActionListener(this);
		htDisplay.addActionListener(this);
		wtDisplay.addActionListener(this);
		btnRes.addActionListener(this);
		txtRes.addActionListener(this);
		txtJudge.addActionListener(this);
		
		//set frame properties
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		//String cmd = e.getActionCommand();
		if(source==btnRes){
			handleBMI();
		}
	}
	
	Double height;
	Double weight;
	Double BMI;
	String strBMI;
	
	public void handleBMI(){
		String strHeight = htDisplay.getText();
		String strWeight = wtDisplay.getText();
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
		Matcher heightNum = pattern.matcher(strHeight);
		Matcher weightNum = pattern.matcher(strWeight);
		boolean acc = true;
		if(!heightNum.matches()||!weightNum.matches()){
			acc = false;
		}
		if(acc){
			height = Double.parseDouble(strHeight);
			weight = Double.parseDouble(strWeight);
			BMI = weight/(height*height);
			DecimalFormat df = new DecimalFormat("#.0");
			String out = "";
			strBMI = df.format(BMI);
			txtRes.setText(strBMI);
			if(standardCHN.isSelected()){
				if(BMI<=23.9&&BMI>=18.5){
					out = "����";
				}else if(BMI>=24&&BMI<27.9){
					out = "���� ƫ�� ";
				}else if(BMI>=28){
					out = "���� ����";
				}
			}else if(standardWHO.isSelected()){
				if(BMI<=18.5){
					out = "ƫ��";
				}else if(BMI<=24.9&&BMI>=18.5){
					out = "����";
				}else if(BMI>=25&&BMI<29.9){
					out = "���� ƫ�� ";
				}else if(BMI>=30&&BMI<=34.9){
					out = "���� ����";
				}else if(BMI>=35&&BMI<=39.9){
					out = "���� �ضȷ���";
				}else if(BMI>=40){
					out = "���� ���ضȷ���";
				}
			}
			txtJudge.setText(out);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(()->{
			new BMICalc();
		});
	}
}
