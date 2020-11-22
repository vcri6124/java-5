package pro1;

//古诗整理工具类
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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


