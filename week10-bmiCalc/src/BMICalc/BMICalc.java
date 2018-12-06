package BMICalc;

//做一个窗体应用程序“体重指数计算器”，能根据用户输入的性别、身高、体重计算出“体质指数（身体质量指数）”，
//并给出是否偏胖的判断。其中，体质指数（BMI）=体重（kg）÷身高^2（m），大于24则为偏胖，更详细的判断可以在网上查查相关的资料。
//要求有用户界面组件（如文本框、单选按钮、按钮）、布局和事件处理。

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
		
		//两个布局再在总的界面里面拼接起来
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.NORTH, pnlHead);
		getContentPane().add(BorderLayout.CENTER, pnlBody);
		getContentPane().add(BorderLayout.SOUTH, pnlJudge);
		
		// 添加事件处理
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
					out = "正常";
				}else if(BMI>=24&&BMI<27.9){
					out = "超重 偏胖 ";
				}else if(BMI>=28){
					out = "超重 肥胖";
				}
			}else if(standardWHO.isSelected()){
				if(BMI<=18.5){
					out = "偏瘦";
				}else if(BMI<=24.9&&BMI>=18.5){
					out = "正常";
				}else if(BMI>=25&&BMI<29.9){
					out = "超重 偏胖 ";
				}else if(BMI>=30&&BMI<=34.9){
					out = "超重 肥胖";
				}else if(BMI>=35&&BMI<=39.9){
					out = "超重 重度肥胖";
				}else if(BMI>=40){
					out = "超重 极重度肥胖";
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
