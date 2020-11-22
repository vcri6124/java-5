package pro1;

import java.util.Scanner;

public class main {
	public  static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("依次输入学生的姓名、编号、性别、学院：");

	    String name=scan.next();
	    String id=scan.next();
	    String gender=scan.next();
	    String department=scan.next();
	    student st=new student(id,name,gender,department);
		
		poemProcess p=new poemProcess();
		p.inputFileContent("D:\\Program Files (x86)\\eclipseWorkplace\\pro1\\src\\pro1\\B.txt");
		//System.out.println(p.getContent());
		//System.out.println(p.processPoem());
		p.rwFile(p.processPoem(), "D:\\Program Files (x86)\\eclipseWorkplace\\pro1\\src\\pro1\\A.txt");
		
	}
}
