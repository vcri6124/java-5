package pro1;

public class student extends person {

	public student(String i, String n, String g, String d) {
		super(i, n, g, d);
	
		// TODO Auto-generated constructor stub
	}
	
	

	public String toString() {
		
		String result="*******************\n"+"����:"+getName()+'\n'+
				"���:"+getId()+'\n'+
				"�Ա�:"+getGender()+'\n'+
				"ѧԺ:"+getDepartment()+'\n';
		
        return result;
    }

}

