import java.awt.event.*; 
import java.awt.*;//�����ĵ��ĶԻ�����
class MyDialog extends Dialog implements ActionListener  //�����Ի�����
{  static final int YES=1,NO=0;
   int message=-1; Button yes,no;
   TextArea area;String help;
   MyDialog(Frame f,String s,boolean b) //���췽��
   {  super(f,s,b);
      yes=new Button("ȷ��"); yes.addActionListener(this);
      no=new Button("ȡ��");   no.addActionListener(this);
      setLayout(new FlowLayout());
	 
	  help = "ʹ�ð�����\n";
	  help +="�����������㷽ʽ����������������ʽ���������ķ�ʽ.\n";
	  help +="�����������������ޣ�����Щ������������ض��壬���г������������\n";
	  help +="s����sin��c����cos��t����tan��������׳ˣ�l����log\n";
	  help +="`�����ţ����Ҫ�ü��������ʱ������ȷ����\n";
	  help +="����������4����Ҫ���ܣ�         \n";
	  help +="1.���з������㣬�����ü��̽������룬ִ�н�����԰��س����\n";
	  help +="2.����2��8��10��16���Ƶĸ��������Լ��໥ת����16����û��ʵ��a��b��c��d��e��f������\n";
	  help +="3.���д���������\n4.������������";
		 area = new TextArea(help,10,50,3);
		//area.setEnabled(false);
		 area.setForeground(Color.BLUE);
		area.setFont(new Font("����",Font.BOLD,16));
		 add(area);
      add(yes); add(no);
	  yes.setPreferredSize(new Dimension(100,25));
	  no.setPreferredSize(new Dimension(100,25));
      setBounds(300,300,500,300);
      addWindowListener(new WindowAdapter()
                      {   public void windowClosing(WindowEvent e)
                           { message=-1;setVisible(false);
                           }
                      }
                   );
   }
   public void actionPerformed(ActionEvent e)
   {  if(e.getSource()==yes) 
      { message=YES;setVisible(false);
      }
     else if(e.getSource()==no)
      { message=NO;setVisible(false);
      }
   }
   public int getMessage()
   {  return message;
   }
}
