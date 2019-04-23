package builder;

public class Person {
	
	
	//필수 사항
	private String name;
	private int age;
	private String job;
	//선택 사항
	private String location;
	private String hobby;
	
	/* 일반적 방법
	//생성자1
	public Person(String name,int age,String job) {
		this.name=name;
		this.age=age;
		this.job=job;
	}
	//생성자2
	public Person(String name,int age,String job,String location) {
		this.name=name;
		this.age=age;
		this.job=job;
		this.location=location;
	}
	//생성자3
	public Person(String name,int age,String job,String location,String hobby) {
		this.name=name;
		this.age=age;
		this.job=job;
		this.location=location;
		this.hobby=hobby;
	} */
	
	/*자바빈 패턴
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setJob(String job) {
		this.job=job;
	}
	
	public void setLocation(String location) {
		this.location=location;
	}
	
	public void setHobby(String hobby) {
		this.hobby=hobby;
	}*/
	
	/* 빌더 패턴*/
	private Person(String name,int age,String job,String location,String hobby) {
		this.name=name;
		this.age=age;
		this.job=job;
		this.location=location;
		this.hobby=hobby;
		
	}
	
		public static class Builder implements AbstractBuilder{
			//필수 사항
			private String name;
			private int age;
			private String job;
			//선택 사항
			private String location;
			private String hobby;
			
			public Builder(String name,int age,String job) {
				this.name=name;
				this.age=age;
				this.job=job;
				
			}
			
			public Builder setLocation(String location) {
				this.location=location;
				return this;
			}
			
			public Builder setHobby(String hobby) {
				this.hobby=hobby;
				return this;
			}
			
			public Person build() {
				return new Person(name,age,job,location,hobby);
			}

			
			
			
		}
	
	public static void main(String[] args) {
		
		/* 일반적 방법
		//생성자1 이용
		Person person1 = new Person("김기기",27,"Student");
		
		//생성자2 이용
		Person person2 = new Person("남기웅",27,"Programmer","Seoul");
		
		//생성자3 이용
		Person person3 = new Person("박무무",40,"건물주","Seoul","월세 받기");
		*/
		
		/*자바빈 패턴
		Person person1 = new Person();
		person1.setName("김기기");
		person1.setAge(27);
		person1.setJob("Student");
		
		Person person2 = new Person();
		person2.setName("남기웅");
		person2.setAge(27);
		person2.setJob("Programmer");
		person2.setLocation("Seoul");
		
		Person person3 = new Person();
		person3.setName("박무무");
		person3.setAge(40);
		person3.setJob("건물주");
		person3.setLocation("Seoul");
		person3.setHobby("월세 받기");*/

		/* 빌더 패턴 */
		Person.Builder builder = new Person.Builder("김기기",27,"Student"); //ConcreteBuilder
		Person person1=builder.build();
		
		Person.Builder builder2 = new Person.Builder("남기웅",27,"Programmer")
				.setLocation("Seoul");
		
		Person person2=builder2.build();
		
		Person.Builder builder3 = new Person.Builder("박무무",40,"건물주")
				.setLocation("Seoul")
				.setHobby("월세 받기");
		
		Person person3=builder3.build();
		
		
		
		

	}

}
