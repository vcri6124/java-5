package pro1;

public class person { //��Ա��
	private String id;//���
	private String name;//����
	private String gender;//�Ա�
	private String department;//ѧԺ
	//���췽��
	public person(String i,String n,String g,String d) {
		this.department=d;
		this.gender=g;
		this.id=i;
		this.name=n;
	}
	//���úͻ�ø�������ֵ
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	//tostring �����Ϣ
	public String toString() {
		String result="����:"+getName()+'\n'+
				"���:"+getId()+'\n'+
				"�Ա�:"+getGender()+'\n'+
				"ѧԺ:"+getDepartment()+'\n';
		
        return result;
    }
	

}