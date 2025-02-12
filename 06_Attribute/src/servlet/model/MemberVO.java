package servlet.model;

public class MemberVO {
	private String name;
	private int age;
	private String addr;
	
	
	
	public MemberVO() {
		super();
	}

	public MemberVO(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

	
	
}
