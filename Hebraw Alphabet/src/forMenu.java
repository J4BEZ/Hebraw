import java.awt.*;

import javax.swing.*;

public class forMenu extends JPanel{
	//�޴��� ���� J�г�
	JComboBox menuList;
	JButton Next;
	
	//�⺻Ÿ�� ���� ����
	String[] menubar = {"��带 �������ּ���","����",};
	Color defaultColor = Color.decode("#00B992");
	Font defaultFont = new Font("�����ٸ���",Font.BOLD,20);
	
	forMenu(){
		
		setLayout(null);
		setSize(180,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		//�޴���
		menuList = new JComboBox(menubar);
		menuList.setSelectedIndex(0);
		menuList.setBounds(5,5,170,30);
		menuList.setBackground(defaultColor);
		menuList.setForeground(Color.WHITE);
		menuList.setFont(defaultFont);
		add(menuList);
		
		
		//
		
	}
}
