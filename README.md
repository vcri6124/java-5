# java-5
# 实验五 模拟学生作业处理

实验目的

掌握字符串String及其方法的使用
掌握文件的读取/写入方法
掌握异常处理结构

业务要求


在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
文件A包括两部分内容：
一是学生的基本信息；
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

1.	每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
2.	允许提供输入参数，统计古诗中某个字或词出现的次数
3.	输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
4.	考虑操作中可能出现的异常，在程序中设计异常处理程序

输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>

输出：
汉皇重色思倾国，御宇多年求不得。
杨家有女初长成，养在深闺人未识。
天生丽质难自弃，一朝选在君王侧。
回眸一笑百媚生，六宫粉黛无颜色。
春寒赐浴华清池，温泉水滑洗凝脂。
侍儿扶起娇无力，始是新承恩泽时。
云鬓花颜金步摇，芙蓉帐暖度春宵。
春宵苦短日高起，从此君王不早朝。
…………
要求：
1.	设计学生类（可利用之前的）；
2.	采用交互式方式实例化某学生；
3.	设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。

系统设计：

1.古诗处理类poemProcess.java


public class poemProcess  {
	private String content; //内容
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public poemProcess() { //空构造方法
		content="";
	}
	public poemProcess(String n) { //构造方法
		content=n;
	}
	
	
	//读取文件并输入到content变量中
	public void inputFileContent(String filePath) {
		
		try {
			 String result="";
             String encoding="utf-8";
             File file=new File(filePath);
             if(file.isFile() && file.exists()){ //判断文件是否存在
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);//考虑到编码格式
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 while((lineTxt = bufferedReader.readLine()) != null){
                     result+=lineTxt;
                 }
                 read.close();
                 this.content=result;
                 
                 
	     }else{
	         System.out.println("找不到指定的文件");
	     }
             
		} catch (Exception e) {
         System.out.println("读取文件内容出错");
       e.printStackTrace();
     }
	}
	
	public String processPoem() { //返回处理古诗的结果
		String result="";
		for(int i=0;i<content.length();i++) {
			result+=content.charAt(i);
			if((i+1)%7==0&&(i+1)%14!=0) {
				result+='，';
			}
			if((i+1)%14==0) {
				result+="。\n";
			}
		}
		return result;
		
	}
	
	 //把处理结果输出到指定文件A
	public  void rwFile(String content,String filepath){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath, true);//路径一定要用"\\"
                fw.write(content);//这里向文件中输入结果123
                fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}


2.main 方法测试程序

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


3.学生类的实现

package pro1;

public class student extends person {

	public student(String i, String n, String g, String d) {
		super(i, n, g, d);
	
		// TODO Auto-generated constructor stub
	}
	
	

	public String toString() {
		
		String result="*******************\n"+"姓名:"+getName()+'\n'+
				"编号:"+getId()+'\n'+
				"性别:"+getGender()+'\n'+
				"学院:"+getDepartment()+'\n';
		
        return result;
    }

}



实验感想：

通过每次实验，掌握了字符串String及其方法的使用，掌握了文件的读取/写入方法以及对输入输出文件中的异常处理结构。
