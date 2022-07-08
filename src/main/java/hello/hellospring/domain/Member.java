package hello.hellospring.domain;


public class Member {
	
	private long id;  //데이터를 구분하기 위해서 시스템이 저장하는 아이디
	private String name;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
