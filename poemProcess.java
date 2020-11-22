package pro1;

//��ʫ��������
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class poemProcess  {
	
	private String content; //����
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public poemProcess() { //�չ��췽��
		content="";
	}
	public poemProcess(String n) { //���췽��
		content=n;
	}
	
	
	//��ȡ�ļ������뵽content������
	public void inputFileContent(String filePath) {
		
		try {
			 String result="";
             String encoding="utf-8";
             File file=new File(filePath);
             if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);//���ǵ������ʽ
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 while((lineTxt = bufferedReader.readLine()) != null){
                     result+=lineTxt;
                 }
                 read.close();
                 this.content=result;
                 
                 
	     }else{
	         System.out.println("�Ҳ���ָ�����ļ�");
	     }
             
		} catch (Exception e) {
         System.out.println("��ȡ�ļ����ݳ���");
       e.printStackTrace();
     }
	}
	
	public String processPoem() { //���ش����ʫ�Ľ��
		String result="";
		for(int i=0;i<content.length();i++) {
			result+=content.charAt(i);
			if((i+1)%7==0&&(i+1)%14!=0) {
				result+='��';
			}
			if((i+1)%14==0) {
				result+="��\n";
			}
		}
		return result;
		
	}
	
	 //�Ѵ����������ָ���ļ�A
	public  void rwFile(String content,String filepath){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath, true);//·��һ��Ҫ��"\\"
                fw.write(content);//�������ļ���������123
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


