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

