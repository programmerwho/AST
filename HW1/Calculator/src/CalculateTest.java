import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
	char[] hundredChar(String s)
	{
		char[] hc = new char[100];
		int i;
		for(i=0;i!=(s.length()<99?s.length():99);i++)
		{
			hc[i] = s.charAt(i);
		}
		hc[i] = '\0';
		return hc;
	}
	
	@Test
	public void testTrans() {
		Calculate CL = new Calculate();
		char c1[] = {'3','+','-','1','\0'};
		char c2[] = {'3','*','/','1','\0'};
		char c3[] = {'3','^','^','2','\0'};
		char c4[] = {'3','*','2','-','\0'};
		char c5[] = {'3','*','(','2','-','1',')','\0'};
		char c6[] = {'!','3','\0'};
		char c7[] = {'/','3','*','+','1','\0'};
		char c8[] = {' ','3','+','2','\0'};
		char op[] = {'+','-','*','/','^','s','c','t','l','$','`','!',' ','\0'};
		assertEquals(CL.trans(c1,op),"+����-�������ֶ���������һ�������");
		assertEquals(CL.trans(c2,op),"*��/�������ֶ���������һ�������");
		assertEquals(CL.trans(c3,op),"^(ڤ�������)�������ֶ���������һ�������");
		assertEquals(CL.trans(c4,op),"����ʽ��׺���ַ������������");
		assertEquals(CL.trans(c5,op),"ok");
		assertEquals(CL.trans(c6,op),"ok");
		assertEquals(CL.trans(c7,op),"+����-�������ֶ���������һ�������");
	}
	
	@Test
	public void testJiecheng() {
		assertEquals(Calculate.jiecheng(5),120,0);
		assertEquals(Calculate.jiecheng(5),120,0);
		assertEquals(Calculate.jiecheng(5.1),120,0);
		assertEquals(Calculate.jiecheng(-5),1,0);
		assertEquals(Calculate.jiecheng(-5.1),1,0);
		assertEquals(Calculate.jiecheng(0),1,0);
	}
	
	@Test
	public void testCheck() {
		Calculate CL = new Calculate();
		char c1[]= {'+','3','-','1','\0'};
		char c2[]= {'y','2','\0'};
		char c3[]= {'3','+','5','(','\0'};
		char c4[]= {'(','3','+','1',')','\0'};
		assertEquals(CL.check(c1),"���ʽ��ʼλ�ò���");
		assertEquals(CL.check(c2),"���뺬�зǷ����ַ���������������ȷ����ѧ���ʽ!");
		assertEquals(CL.check(c3),"�������û����ƥ�������!����������!");
		assertEquals(CL.check(c4),"ok");
	}
	
	@Test
	public final void testExp() {
		assertEquals(-4, new Calculate().exp(-2,-2, '+'),0.0);
		assertEquals(-3.2, new Calculate().exp(-1.2,-2, '+'),0.0);
		assertEquals(-2, new Calculate().exp(0,-2, '+'),0.0);
		assertEquals(-0.8, new Calculate().exp(1.2,-2, '+'),0.0);
		assertEquals(0, new Calculate().exp(2,-2, '+'),0.0);
		
		assertEquals(-3.2, new Calculate().exp(-2,-1.2, '+'),0.0);
		assertEquals(-2.4, new Calculate().exp(-1.2,-1.2, '+'),0.0);
		assertEquals(-1.2, new Calculate().exp(0,-1.2, '+'),0.0);
		assertEquals(0, new Calculate().exp(1.2,-1.2, '+'),0.0);
		assertEquals(0.8, new Calculate().exp(2,-1.2, '+'),0.0);

		assertEquals(-2, new Calculate().exp(-2,0, '+'),0.0);
		assertEquals(-1.2, new Calculate().exp(-1.2,0, '+'),0.0);
		assertEquals(0, new Calculate().exp(0,0, '+'),0.0);
		assertEquals(1.2, new Calculate().exp(1.2,0, '+'),0.0);
		assertEquals(2, new Calculate().exp(2,0, '+'),0.0);
		
		assertEquals(-0.8, new Calculate().exp(-2,1.2, '+'),0.0);
		assertEquals(0, new Calculate().exp(-1.2,1.2, '+'),0.0);
		assertEquals(1.2, new Calculate().exp(0,1.2, '+'),0.0);
		assertEquals(2.4, new Calculate().exp(1.2,1.2, '+'),0.0);
		assertEquals(3.2, new Calculate().exp(2,1.2, '+'),0.0);
		
		assertEquals(0, new Calculate().exp(-2,2, '+'),0.0);
		assertEquals(0.8, new Calculate().exp(-1.2,2, '+'),0.0);
		assertEquals(2, new Calculate().exp(0,2, '+'),0.0);
		assertEquals(3.2, new Calculate().exp(1.2,2, '+'),0.0);
		assertEquals(4, new Calculate().exp(2,2, '+'),0.0);
		
		assertEquals(0, new Calculate().exp(-2,-2, '-'),0.0);
		assertEquals(-0.8, new Calculate().exp(-1.2,-2, '-'),0.0);
		assertEquals(-2, new Calculate().exp(0,-2, '-'),0.0);
		assertEquals(-3.2, new Calculate().exp(1.2,-2, '-'),0.0);
		assertEquals(-4, new Calculate().exp(2,-2, '-'),0.0);
		             
		assertEquals(0.8, new Calculate().exp(-2,-1.2, '-'),0.0);
		assertEquals(0, new Calculate().exp(-1.2,-1.2, '-'),0.0);
		assertEquals(-1.2, new Calculate().exp(0,-1.2, '-'),0.0);
		assertEquals(-2.4, new Calculate().exp(1.2,-1.2, '-'),0.0);
		assertEquals(-3.2, new Calculate().exp(2,-1.2, '-'),0.0);
                     
		assertEquals(2, new Calculate().exp(-2,0, '-'),0.0);
		assertEquals(1.2, new Calculate().exp(-1.2,0, '-'),0.0);
		assertEquals(0, new Calculate().exp(0,0, '-'),0.0);
		assertEquals(-1.2, new Calculate().exp(1.2,0, '-'),0.0);
		assertEquals(-2, new Calculate().exp(2,0, '-'),0.0);
		             
		assertEquals(3.2, new Calculate().exp(-2,1.2, '-'),0.0);
		assertEquals(2.4, new Calculate().exp(-1.2,1.2, '-'),0.0);
		assertEquals(1.2, new Calculate().exp(0,1.2, '-'),0.0);
		assertEquals(0, new Calculate().exp(1.2,1.2, '-'),0.0);
		assertEquals(-0.8, new Calculate().exp(2,1.2, '-'),0.0);
		             
		assertEquals(4, new Calculate().exp(-2,2, '-'),0.0);
		assertEquals(3.2, new Calculate().exp(-1.2,2, '-'),0.0);
		assertEquals(2, new Calculate().exp(0,2, '-'),0.0);
		assertEquals(0.8, new Calculate().exp(1.2,2, '-'),0.0);
		assertEquals(0, new Calculate().exp(2,2, '-'),0.0);
		
		assertEquals(4, new Calculate().exp(-2,-2, '*'),0.0);
		assertEquals(2.4, new Calculate().exp(-1.2,-2, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,-2, '*'),0.0);
		assertEquals(-2.4, new Calculate().exp(1.2,-2, '*'),0.0);
		assertEquals(-4, new Calculate().exp(2,-2, '*'),0.0);
		
		assertEquals(2.4, new Calculate().exp(-2,-1.2, '*'),0.0);
		assertEquals(1.44, new Calculate().exp(-1.2,-1.2, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,-1.2, '*'),0.0);
		assertEquals(-1.44, new Calculate().exp(1.2,-1.2, '*'),0.0);
		assertEquals(-2.4, new Calculate().exp(2,-1.2, '*'),0.0);

		assertEquals(0, new Calculate().exp(-2,0, '*'),0.0);
		assertEquals(0, new Calculate().exp(-1.2,0, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,0, '*'),0.0);
		assertEquals(0, new Calculate().exp(1.2,0, '*'),0.0);
		assertEquals(0, new Calculate().exp(2,0, '*'),0.0);
		
		assertEquals(-2.4, new Calculate().exp(-2,1.2, '*'),0.0);
		assertEquals(-1.44, new Calculate().exp(-1.2,1.2, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,1.2, '*'),0.0);
		assertEquals(1.44, new Calculate().exp(1.2,1.2, '*'),0.0);
		assertEquals(2.4, new Calculate().exp(2,1.2, '*'),0.0);
		
		assertEquals(-4, new Calculate().exp(-2,2, '*'),0.0);
		assertEquals(-2.4, new Calculate().exp(-1.2,2, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,2, '*'),0.0);
		assertEquals(2.4, new Calculate().exp(1.2,2, '*'),0.0);
		assertEquals(4, new Calculate().exp(2,2, '*'),0.0);
		
		//pair-wise
		/*assertEquals(-4, new Calculate().exp(-2,-2, '+'),0.0);
		assertEquals(-3.2, new Calculate().exp(-1.2,-2, '+'),0.0);
		assertEquals(-2, new Calculate().exp(0,-2, '+'),0.0);
		assertEquals(-0.8, new Calculate().exp(1.2,-2, '+'),0.0);
		assertEquals(0, new Calculate().exp(2,-2, '+'),0.0);
		
		assertEquals(0, new Calculate().exp(-2,-2, '-'),0.0);
		assertEquals(-0.8, new Calculate().exp(-1.2,-2, '-'),0.0);
		assertEquals(-2, new Calculate().exp(0,-2, '-'),0.0);
		assertEquals(-3.2, new Calculate().exp(1.2,-2, '-'),0.0);
		assertEquals(-4, new Calculate().exp(2,-2, '-'),0.0);
		
		assertEquals(4, new Calculate().exp(-2,-2, '*'),0.0);
		assertEquals(2.4, new Calculate().exp(-1.2,-2, '*'),0.0);
		assertEquals(0, new Calculate().exp(0,-2, '*'),0.0);
		assertEquals(-2.4, new Calculate().exp(1.2,-2, '*'),0.0);
		assertEquals(-4, new Calculate().exp(2,-2, '*'),0.0);
		
		assertEquals(-3.2, new Calculate().exp(-2,-1.2, '+'),0.0);
		assertEquals(-2, new Calculate().exp(-2,0, '+'),0.0);
		assertEquals(-0.8, new Calculate().exp(-2,1.2, '+'),0.0);
		assertEquals(0, new Calculate().exp(-2,2, '+'),0.0);
		
		assertEquals(-2.4, new Calculate().exp(-1.2,-1.2, '+'),0.0);
		assertEquals(-1.2, new Calculate().exp(-1.2,0, '+'),0.0);
		assertEquals(0, new Calculate().exp(-1.2,1.2, '+'),0.0);
		assertEquals(0.8, new Calculate().exp(-1.2,2, '+'),0.0);
		
		assertEquals(-1.2, new Calculate().exp(0,-1.2, '+'),0.0);
		assertEquals(0, new Calculate().exp(0,0, '+'),0.0);
		assertEquals(1.2, new Calculate().exp(0,1.2, '+'),0.0);
		assertEquals(2, new Calculate().exp(0,2, '+'),0.0);
		
		assertEquals(0, new Calculate().exp(1.2,-1.2, '+'),0.0);
		assertEquals(1.2, new Calculate().exp(1.2,0, '+'),0.0);
		assertEquals(2.4, new Calculate().exp(1.2,1.2, '+'),0.0);
		assertEquals(3.2, new Calculate().exp(1.2,2, '+'),0.0);
		
		assertEquals(0, new Calculate().exp(2,-2, '+'),0.0);
		assertEquals(2, new Calculate().exp(2,0, '+'),0.0);
		assertEquals(3.2, new Calculate().exp(2,1.2, '+'),0.0);
		assertEquals(4, new Calculate().exp(2,2, '+'),0.0);*/
	}
	
	@Test
	public void testCompvalue() {
		Calculate cal = new Calculate();
		char[] testComp;
		String result;

		//2+
		testComp = hundredChar("1#1#+");
		result = cal.compvalue(testComp, 2);
		assertEquals(2, Double.parseDouble(result),0.01);

		//2-
		testComp = hundredChar("0#0#-");
		result = cal.compvalue(testComp, 2);
		assertEquals(0.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#1#-");
		result = cal.compvalue(testComp, 2);
		assertEquals(-1, Double.parseDouble(result),0.01);
		testComp = hundredChar("1#0#-");
		result = cal.compvalue(testComp, 2);
		assertEquals(1, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#0#-");
		result = cal.compvalue(testComp, 2);
		assertEquals(2.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#10#-");
		result = cal.compvalue(testComp, 2);
		assertEquals(-2.0, Double.parseDouble(result),0.01);
		

		//2*
		testComp = hundredChar("10#10#*");
		result = cal.compvalue(testComp, 2);
		assertEquals(4.0, Double.parseDouble(result),0.01);

		//2/
		testComp = hundredChar("1#0#/");
		result = cal.compvalue(testComp, 2);
		assertEquals("������󣬳�����������!����������!", result);
		testComp = hundredChar("10#1#/");
		result = cal.compvalue(testComp, 2);
		assertEquals(2.0, Double.parseDouble(result),0.01);
		
		

		//8+
		testComp = hundredChar("1#1#+");
		result = cal.compvalue(testComp, 8);
		assertEquals(2, Double.parseDouble(result),0.01);

		//8-
		testComp = hundredChar("0#0#-");
		result = cal.compvalue(testComp, 8);
		assertEquals(0.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#1#-");
		result = cal.compvalue(testComp, 8);
		assertEquals(-1, Double.parseDouble(result),0.01);
		testComp = hundredChar("1#0#-");
		result = cal.compvalue(testComp, 8);
		assertEquals(1, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#0#-");
		result = cal.compvalue(testComp, 8);
		assertEquals(8.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#10#-");
		result = cal.compvalue(testComp, 8);
		assertEquals(-8.0, Double.parseDouble(result),0.01);
		

		//8*
		testComp = hundredChar("10#10#*");
		result = cal.compvalue(testComp, 8);
		assertEquals(64.0, Double.parseDouble(result),0.01);

		//8/
		testComp = hundredChar("1#0#/");
		result = cal.compvalue(testComp, 8);
		assertEquals("������󣬳�����������!����������!", result);
		testComp = hundredChar("10#1#/");
		result = cal.compvalue(testComp, 8);
		assertEquals(8.0, Double.parseDouble(result),0.01);
		

		//16+
		testComp = hundredChar("1#1#+");
		result = cal.compvalue(testComp, 16);
		assertEquals(2, Double.parseDouble(result),0.01);

		//16-
		testComp = hundredChar("0#0#-");
		result = cal.compvalue(testComp, 16);
		assertEquals(0.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#1#-");
		result = cal.compvalue(testComp, 16);
		assertEquals(-1, Double.parseDouble(result),0.01);
		testComp = hundredChar("1#0#-");
		result = cal.compvalue(testComp, 16);
		assertEquals(1, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#0#-");
		result = cal.compvalue(testComp, 16);
		assertEquals(16.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#10#-");
		result = cal.compvalue(testComp, 16);
		assertEquals(-16.0, Double.parseDouble(result),0.01);
		

		//16*
		testComp = hundredChar("10#10#*");
		result = cal.compvalue(testComp, 16);
		assertEquals(256.0, Double.parseDouble(result),0.01);

		//16/
		testComp = hundredChar("1#0#/");
		result = cal.compvalue(testComp, 16);
		assertEquals("������󣬳�����������!����������!", result);
		testComp = hundredChar("10#1#/");
		result = cal.compvalue(testComp, 16);
		assertEquals(16.0, Double.parseDouble(result),0.01);
		
		
		//+
		testComp = hundredChar("0.1#0.1#+");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.2, Double.parseDouble(result),0.01);

		//-
		testComp = hundredChar("0#0#-");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#0.1#-");
		result = cal.compvalue(testComp, 10);
		assertEquals(-0.1, Double.parseDouble(result),0.01);
		testComp = hundredChar("0.1#0#-");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.1, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#0#-");
		result = cal.compvalue(testComp, 10);
		assertEquals(10.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#10#-");
		result = cal.compvalue(testComp, 10);
		assertEquals(-10.0, Double.parseDouble(result),0.01);
		

		//*
		testComp = hundredChar("0.1#0.1#*");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.01, Double.parseDouble(result),0.01);

		///
		testComp = hundredChar("1#0#/");
		result = cal.compvalue(testComp, 10);
		assertEquals("������󣬳�����������!����������!", result);
		testComp = hundredChar("0.1#0.1#/");
		result = cal.compvalue(testComp, 10);
		assertEquals(1.0, Double.parseDouble(result),0.01);
		
		//sin
		testComp = hundredChar("0.1#s");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.001745, Double.parseDouble(result),0.01);
		
		//cos
		testComp = hundredChar("0.1#c");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.9999, Double.parseDouble(result),0.01);
		
		//tan
		testComp = hundredChar("90#t");
		result = cal.compvalue(testComp, 10);
		assertEquals("tan����ֵ����", result);
		testComp = hundredChar("89#t");
		result = cal.compvalue(testComp, 10);
		assertEquals(57.2899, Double.parseDouble(result),0.01);
		testComp = hundredChar("0#t");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.0, Double.parseDouble(result),0.01);
		testComp = hundredChar("89#`t");
		result = cal.compvalue(testComp, 10);
		assertEquals(-57.2899, Double.parseDouble(result),0.01);
		testComp = hundredChar("90#`t");
		result = cal.compvalue(testComp, 10);
		assertEquals("tan����ֵ����", result);

		//!
		testComp = hundredChar("0#!");
		result = cal.compvalue(testComp, 10);
		assertEquals(1, Double.parseDouble(result),0.01);
		testComp = hundredChar("1#!");
		result = cal.compvalue(testComp, 10);
		assertEquals(1, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#!");
		result = cal.compvalue(testComp, 10);
		assertEquals(3628800, Double.parseDouble(result),0.01);

		//l
		testComp = hundredChar("0#l");
		result = cal.compvalue(testComp, 10);
		assertEquals("log����������С�ڵ���0", result);
		testComp = hundredChar("0.1#l");
		result = cal.compvalue(testComp, 10);
		assertEquals(-2.3025, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#l");
		result = cal.compvalue(testComp, 10);
		assertEquals(2.3025, Double.parseDouble(result),0.01);
		
		//^
		testComp = hundredChar("0.1#0.1#^");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.7943, Double.parseDouble(result),0.01);

		//$
		testComp = hundredChar("0.1#`$");
		result = cal.compvalue(testComp, 10);
		assertEquals("����������С��0��", result);
		testComp = hundredChar("0#$");
		result = cal.compvalue(testComp, 10);
		assertEquals(0, Double.parseDouble(result),0.01);
		testComp = hundredChar("0.1#$");
		result = cal.compvalue(testComp, 10);
		assertEquals(0.3162, Double.parseDouble(result),0.01);
		testComp = hundredChar("10#$");
		result = cal.compvalue(testComp, 10);
		assertEquals(3.1622, Double.parseDouble(result),0.01);
		
	}
}
