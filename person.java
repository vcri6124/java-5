package pro1;

public class person { //人员类
	private String id;//编号
	private String name;//姓名
	private String gender;//性别
	private String department;//学院
	//构造方法
	public person(String i,String n,String g,String d) {
		this.department=d;
		this.gender=g;
		this.id=i;
		this.name=n;
	}
	//设置和获得各个属性值
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
	//tostring 输出信息
	public String toString() {
		String result="姓名:"+getName()+'\n'+
				"编号:"+getId()+'\n'+
				"性别:"+getGender()+'\n'+
				"学院:"+getDepartment()+'\n';
		
        return result;
    }
	

}