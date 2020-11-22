package pro1;

public class main {
	public  static void main(String args[]) {
		poemProcess p=new poemProcess();
		p.inputFileContent("D:\\Program Files (x86)\\eclipseWorkplace\\pro1\\src\\pro1\\B.txt");
		//System.out.println(p.getContent());
		//System.out.println(p.processPoem());
		p.rwFile(p.processPoem(), "D:\\Program Files (x86)\\eclipseWorkplace\\pro1\\src\\pro1\\A.txt");
	}
}
