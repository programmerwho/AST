import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.math.*;
class WinFrame extends Frame implements ActionListener,KeyListener,ItemListener
{
    mypanel pane1,pane2,pane3,pane4,pane5;
	Label label1,label2;
	short j_flag=10;//��������ı�ʾ,��ʼ��Ϊʮ����
    String strAsk="",strAnswer="";
	boolean b_flag = true;
	boolean p_flag = true;//��������
	TextArea text1;//���������ר����
	MenuBar menubar;
	Menu menu1,menu2,menu3;
	MenuItem item1,item2;
	MyDialog dialog;//�����ĵ��Ի���
	CheckboxMenuItem menuitem1,menuitem2,menuitem3;
    String a[] = {"1","2","3",//��������а�ť����������Ϣ���ݵĻ�ȡ
                  "4","5","6",
                  "7","8","9",
                  "0",".","+/-"};
    String a1[] = {"1","2","3",
                  "4","5","6",
                  "7","8","9",
                  "0",".","`"};
    String b[] ={"/","C","*","��","+","=","-","CE"};
    String c[] ={"sin","cos","tan","!","pow","sprt","log","pi"};
    String c1[] ={"s","c","t","!","^","$","l","p"};
    String d[] ={"( ",")"};
    String d1[] ={"(",")"};
	String e[] = {" A"," B"," C"," D"," E","F"};
    JTextField ask ,answer;
    char exp[];char postexp[];
	Checkbox box1,box2,box3,box4,box5;
	CheckboxGroup jin;
	String data = "0";//��������������
	TextArea text2,text3;
	int opear;
	CardLayout mycard;
	String answer1 = "";// ����ת��ʱ��ʮ���ƴ𰸴���
	Long answer2 = (long)0;//�������ƴ𰸴���
	Panel pCenter;//���һ������װר��������
	void area()//��ʼ�� ���֣�ֻ�ǲ����ڹ��췽���еĶ���̫�࣬������������
	{
	mycard = new CardLayout();
	pCenter = new Panel();
	pCenter.setLayout(mycard);
        setLayout(new FlowLayout());
        setBounds(60,60,450,290);
		
	  menu1 = new Menu("�鿴");
	  menu2 = new Menu("ϵͳ");
	  menu3 = new Menu("����");
	  menuitem1 = new CheckboxMenuItem("��ͨ",true);
	  menuitem2 = new CheckboxMenuItem("������",false);
	  menuitem3 = new CheckboxMenuItem("������",false);
	  item1 = new MenuItem("�˳�");
	  item2 = new MenuItem("����");
	  
	  menuitem1.addItemListener(this);
	  menuitem2.addItemListener(this);
	  menuitem3.addItemListener(this);
	  item1.addActionListener(this);
	  item2.addActionListener(this);
	  menubar = new MenuBar();
      menu1.add(menuitem1);
	  menu1.add(menuitem2);
	  menu1.addSeparator();//�ָ���
	  menu1.add(menuitem3);
	  menu2.add(item1);
	  menu3.add(item2);
	  
	  menuitem1.setShortcut(new MenuShortcut(KeyEvent.VK_P));
	  menuitem2.setShortcut(new MenuShortcut(KeyEvent.VK_D));
	  menuitem3.setShortcut(new MenuShortcut(KeyEvent.VK_B));
	  item1.setShortcut(new MenuShortcut(KeyEvent.VK_Q));
	  item2.setShortcut(new MenuShortcut(KeyEvent.VK_F1));

	  menubar.add(menu2);
	  menubar.add(menu1);
	  menubar.add(menu3);
	  setMenuBar(menubar);
	  dialog = new MyDialog(this,"�����ĵ�",true);	
		
        pane1 = new mypanel(a,4,3,Color.red);
		pane3 = new mypanel(c,4,2,Color.black);
        pane2 = new mypanel(d,1,2,Color.black);
        pane4 = new mypanel(b,4,2,Color.BLUE);
		pane5 = new mypanel(e,1,6,Color.red);
		jin = new CheckboxGroup();
		box1 = new Checkbox("������",false,jin);
		box2 = new Checkbox("�˽���",false,jin);
		box3 = new Checkbox("ʮ����",true,jin);
        box4 = new Checkbox("ʮ������",false,jin);
        box5 = new Checkbox("����������");
		pane3 = new mypanel(c,4,2,Color.black); 
		 for(int i=0;i<8;i++)
		pane3.btu[i].addActionListener(this);
		box1.addItemListener(this);
		box2.addItemListener(this);
		box3.addItemListener(this);
		box4.addItemListener(this);
		box5.addItemListener(this);
		for(int i=0;i<12;i++)
        pane1.btu[i].addActionListener(this);
         for(int i=0;i<2;i++)
        pane2.btu[i].addActionListener(this);
         for(int i=0;i<8;i++)
         pane4.btu[i].addActionListener(this);
        ask = new JTextField(38);
        ask.setHorizontalAlignment(JTextField.RIGHT);
        answer = new JTextField(38);  
		ask.addKeyListener(this);
		
        answer.setHorizontalAlignment(JTextField.RIGHT);
        answer.setEditable(false);
        add(ask);
        add(answer);
        add(box5);
		add(box1);
		add(box2);
		add(box3);
		add(box4);
        
		text1= new TextArea("",6,10,3);
		text1.setForeground(Color.BLUE);
        pCenter.add("1",pane3);
	    pCenter.add("2",text1);
	    add(pCenter);
        add(pane1);
        add(pane4);
		add(pane2);
		add(pane5);
		label1 = new Label("�밴��ʽ���������������,���ո�������һ��,�س�����𰸡�");
		add(label1);
		label2 = new Label("�����£�");
		add(label2);
		text2 =new TextArea("",6,28,3);
		text3 =new TextArea("",6,28,2);
		label1.setVisible(false);
		label2.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
		text2.addKeyListener(this);
		add(text2);
		add(text3);
		for(int i=0;i<6;i++)
           {
		   pane5.btu[i].setPreferredSize(new Dimension(50,25));
		   pane5.btu[i].setEnabled(false);
		   }
        setVisible(true);
        validate();
	}
    WinFrame(String s)
    {
	   super(s);
		area();
        addWindowListener(new WindowAdapter()
	                         {
	                          public void windowClosing(WindowEvent e)
	                           {
	                        System.exit(0);
	                           }
	                         }
	                      );
    }
    public void actionPerformed(ActionEvent e)//��ť�Լ����ֲ˵�����
    {
        int i=0;
		if(e.getSource() ==item1)//�˳��˵�
		System.exit(0);
		else if(e.getSource() ==item2)//�����˵�
		{
		   dialog.setVisible(true);
		}
		strAsk = ask.getText();
       while(i<11)//��������ĸ�ֵ
       {
           if(e.getSource() == pane1.btu[i])
           {
               strAsk += a1[i];
               break;
           }

           i++;
       }
        if(e.getSource() == pane1.btu[11]&&b_flag)//ӦΪ���źͼ�����ͬ�������ض�����һ��
           {
               strAsk += a1[11];
           }
		else if(e.getSource() == pane1.btu[11]&&!b_flag)//������û���û�����㣬ӦΪ������ֵ�Ƚϳ������Ը���Ϊ����
		strAsk +="-";
        i=0;
        while(i<2)//����
       {
           if(e.getSource() == pane2.btu[i])
           {
           strAsk += d1[i];
           break;
           }
           i++;
       }
         i=0;
        while(i<7)//�߼��������
       {
           if(e.getSource() == pane3.btu[i])
           {
           strAsk +=c1[i];
          break;
           }
           i++;
       }
         i=0;
           while(i<4)//�ͼ��������
       {
           if(e.getSource() == pane4.btu[i*2]&&b_flag)//��ͨ���㣬����������
           {
           strAsk +=b[i*2];
            break;
           }
		   else if(e.getSource() == pane4.btu[i*2]&&!b_flag)//����������
		   {
		       data = ask.getText();
			   strAsk ="";
			   opear = i*2;
		   }
           i++;
       }
       if(e.getSource() == pane4.btu[1])//C��ť
       strAsk = "";
       else if(e.getSource() == pane4.btu[3]&&strAsk.length()>0)//�˸�ť
	   strAsk = strAsk.substring(0,strAsk.length()-1);
	   else if(e.getSource() == pane4.btu[7])//CE��ť
       text2.setText(null);
           
       else if(e.getSource() == pane4.btu[5]&&b_flag)//=��ť����ͨ���㣩
         {
		 
           strAsk =ask.getText();
		   if(strAsk.equals(""))
		   strAnswer="�����������ݣ�Ȼ����м��㣡";
		   else
		   {
           String as=ask.getText()+"\0";
           exp =as.toCharArray();
	       postexp = new char[100];
	       Calculate acs =new Calculate();
           if(acs.check(exp).equals("ok"))
           {
	       if(acs.trans(exp,postexp).equals("ok"))
		   {
           strAnswer = acs.compvalue(postexp,j_flag);
		   answer1 = strAnswer;
		   double nu;
		   try
		   {
		   nu = Double.parseDouble(strAnswer);
		   }
		   catch(NumberFormatException w)
		   {
		   nu =0;
		   }
		   long nu1 = (long)nu;
		   answer2 = nu1;
		   if(j_flag!=10)
		   strAnswer = Long.toString(nu1,j_flag);
		   }
		   else
		   strAnswer=acs.trans(exp,postexp);
           }
           else
               strAnswer = acs.check(exp);
		   }
         }
	   else if(e.getSource() == pane4.btu[5]&&!b_flag)//=�����������㣩
	   {
	    strAsk =ask.getText();String num="";
		try
		{
		BigInteger data1 = new BigInteger(data);
		BigInteger data2 = new BigInteger(strAsk);
		
	         switch(opear)
			 {
			 case 0:
			 num = data1.divide(data2).toString(j_flag);break;
			 case 2:
             num = data1.multiply(data2).toString(j_flag);break;
             case 4:
          	 num = data1.add(data2).toString(j_flag);	break;	 
			 case 6:
          	 num = data1.subtract(data2).toString(j_flag);	break;	 
			 }
			 strAnswer = num;
			 text1.setText(num);
	    }
		catch(NumberFormatException n)
		{
		strAnswer="����Ĵ�������������";
		}
			 
	   }
       else if(e.getSource() == pane4.btu[1])
       strAsk = "";
       else if(e.getSource() == pane3.btu[7])
       strAsk = String.valueOf(Math.PI);
	   

       ask.setText(strAsk);
       answer.setText(strAnswer);
    }
    public void keyPressed(KeyEvent e)//���̼���
    {
        if(e.getKeyCode() == KeyEvent.VK_ENTER&&p_flag)//= ��ͨ���� ��������û����ӣ�
        {
           strAsk =ask.getText();
	       if(strAsk.equals(""))
		   strAnswer="�����������ݣ�Ȼ����м��㣡";
		   else
		   {
           String as= ask.getText()+"\0";
           exp =as.toCharArray();
	       postexp = new char[100];
	       Calculate acs =new Calculate();
	       if(acs.check(exp).equals("ok"))
           {
           if(acs.trans(exp,postexp).equals("ok"))
		   {
           strAnswer = acs.compvalue(postexp,j_flag);
		   answer1 = strAnswer;
		   double nu;
		   try
		   {
		   nu = Double.parseDouble(strAnswer);
		   }
		   catch(NumberFormatException w)
		   {
		   nu =0;
		   }
		   long nu1 = (long)nu;
		   answer2 = nu1;
		   if(j_flag!=10)
		   strAnswer = Long.toString(nu1,j_flag);
		   }
		   else
		   strAnswer=acs.trans(exp,postexp);
           }
           else
               strAnswer = acs.check(exp);
		  
		  } answer.setText(strAnswer);
        }
		 if(e.getKeyCode() == KeyEvent.VK_ENTER&&!p_flag)//=�����������㣩
        {
          String temp,as,ans="";
		   Calculate acs =new Calculate();
		   text3.setText(null);
		   temp = text2.getText();
		  StringTokenizer analysis = new StringTokenizer(temp," '\n', ");
		  int n =analysis.countTokens();
		  String a[] = new String[analysis.countTokens()];
		  for(int i=0;i<n;i++)
		  {
		   a[i] = analysis.nextToken();
		   a[i]=a[i]+"\0";
		
		  }
		  for(int i=0;i<n;i++)
		 {
			 exp =a[i].toCharArray();
	         postexp = new char[100];
	        
	         if(acs.check(exp).equals("ok"))
            {
	        if(acs.trans(exp,postexp).equals("ok"))
			{
			String strAn = acs.compvalue(postexp,j_flag);
			double nu;
		   try
		   {
		   nu = Double.parseDouble(strAnswer);
		   }
		   catch(NumberFormatException w)
		   {
		   nu =0;
		   }
		   long nu1 = (long)nu;
		   if(j_flag!=10)
		    strAn = Long.toString(nu1,j_flag);
			ans = ans+strAn+"\n";
			}
            
			else
			ans = ans+acs.trans(exp,postexp)+"\n";
            }
            else
            ans = ans + acs.check(exp)+"\n";	   
		   }
            text3.setText(ans);
        }
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
	public void itemStateChanged(ItemEvent e)//ѡ�������
	{
	        for(int i=1;i<12;i++)
            pane1.btu[i].setEnabled(true);
	     if(e.getSource() == box1)//1����4Ϊ���ư�ť
		 {
		    j_flag = 2;
		    for(int i=1;i<9;i++)
            pane1.btu[i].setEnabled(false);
			for(int i=0;i<6;i++)
            pane5.btu[i].setEnabled(false);
			answer.setText(Long.toString(answer2,j_flag));
		 }
		 else if(e.getSource() == box2)
		 {
		    j_flag =8;
		    for(int i=7;i<9;i++)
            pane1.btu[i].setEnabled(false);
			for(int i=0;i<6;i++)
            pane5.btu[i].setEnabled(false);
			answer.setText(Long.toString(answer2,j_flag));
		 }
		 else if(e.getSource() == box3)
		 {
		    j_flag =10;
			for(int i=0;i<6;i++)
            pane5.btu[i].setEnabled(false);
			answer.setText(answer1);
		 }
		 else if(e.getSource() == box4)
		 {
		    j_flag =16;
			for(int i=0;i<6;i++)
            pane5.btu[i].setEnabled(true);
			answer.setText(Long.toString(answer2,j_flag));
		 }
		 else if(e.getSource() == box5)//��������ť
		 {
		  validate();
		    b_flag = !b_flag;
			mycard.next(pCenter);
		 }
		 else if(e.getSource()==menuitem1){//�˵���Ӧ�İ�ť
		   this.setBounds(60,60,450,290);
			menuitem2.setState(false);
			menuitem1.setState(true);
			p_flag = true;
			label1.setVisible(false);
		    label2.setVisible(false);
		    text2.setVisible(false);
		    text3.setVisible(false);
						
		}
		else if(e.getSource()==menuitem2){
			this.setBounds(60,60,450,430);
			menuitem1.setState(false);
			menuitem2.setState(true);
			p_flag =false;
			label1.setVisible(true);
		   label2.setVisible(true);
	     	text2.setVisible(true);
	    	text3.setVisible(true);
			}
			else if(e.getSource()==menuitem3){
			menuitem3.setState(b_flag);
			b_flag = !b_flag;
			mycard.next(pCenter);
			}
	}
}