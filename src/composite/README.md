# 콤퍼짓 패턴 (Composite pattern)

### 유재국

## 콤퍼짓 패턴(Composite pattern)이란?

객체의 구조를 수정하는 구조 패턴으로, 콤퍼짓 패턴을 구현하면 클라이언트가 단일 객체와 복합 객체를 균일하게 처리할 수 있도록 하는 패턴.

## 문제 - 언제 패턴을 사용하는가?

개별적인 객체들과 객체들의 집합간의 처리 방법의 차이가 없을 경우 사용

트리와 같은 구조가 필요할 때 사용

## 해결방안 - 설계를 구성하는 요소 간의 관계 (클래스 다이어그램)

![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/composite/Composite%20Pattern%20%E1%84%8B%E1%85%A8%E1%84%8C%E1%85%A6%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A8%E1%84%83%E1%85%A9.png)

## 결과 - 적용해서 얻는 결과

클라이언트는 인터페이스를 통해 단일 객체와 복합 객체를 균일하게 처리하므로 클라이언트 코드가 간단해짐

### - 장점

클라이언트 입장에서는 기본 객체와 구성 객체를 구별하지 않고 소스코드를 작성할 수 있기에 편리.

최상위 클래스는 하위 클래스들이 필요로 하는 모든 인터페이스를 정의하고 있기 때문에, 새로운 클래스 추가가 용이

### - 단점

전반적으로 설계가 일반화되기 때문에, 객체간의 특별한 제약을 가하기 힘듦.

## 코드 예제

사회에서 회사와 직원간의 관계를 콤퍼짓 패턴을 이용하여 구현.

~~~java
public abstract class Social {
	public abstract String getName();
}
// Social 추상 클래스는 String 자료형을 리턴해주는 getName 추상 함수를 지니고 있다.


public class Member extends Social{
	private String name;
	public Member(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
// Member 클래스는 Social을 상속 받아 getName기능만하며, getName 함수를 자신의 클래스 변수인 name을 반환해주도록 재정의하였다.


public class Company extends Social{
	private String name;
	private List<Social> members = new ArrayList<Social>();
	public Company(String name) {
		this.name = name;
	}
	
	public void add(Social social) {
		members.add(social);
	}
	
	public void remove(Social social) {
		members.remove(social);
	}
	
	public void destroy() {
		members.clear();
	}
	
	public String getMemberTree() {
		if(this instanceof Company) {
			return "🏢 -> " + name + "\n" + getMemberTree(1);
		}else {
			return getMemberTree();
		}
	}

	public String getMemberTree(int depth ) {
		StringBuffer sb = new StringBuffer();
		for(Social member : members) {
			if(member instanceof Company) {
				for(int i = 0 ; i < depth; i++) {
					sb.append("  ");
				}
				sb.append("🏢 -> " + member.getName() + "\n");
				sb.append( ((Company)(member)).getMemberTree(depth+1) );
			}
			else {
				for(int i = 0 ; i < depth ; i ++) {
					sb.append("  ");
				}
				sb.append("👤 -> " + member.getName() + "\n");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String getName() {
		return name;
	}
}
// Company 클래스는 Social을 상속 받아 getName 함수를 자신의 클래스 변수인 name을 반환해주도록 재정의하였고, 단일 객체인 Member 를 저장할 List 자료형 클래스 변수 members와, Member List에 Member 를 추가하는 add 함수, Member List에 Member를 제거하는 remove 함수,Member List를 비워줄 destroy 함수, 트리 모형을 출력을 위한 getMemberTree 함수로 구성.


public class Main {
	public static void main(String[] args) {
		Company cafe24 = new Company("Cafe24");
		cafe24.add(new Member("Jae-Seok"));
		System.out.println(cafe24.getMemberTree());

		cafe24.add(new Member("Gi-Woong"));
		cafe24.add(new Member("Dong-Hwa"));
		cafe24.add(new Member("Jae-Guk"));
		cafe24.add(new Member("Soo-Bin"));
		cafe24.add(new Member("Yeon-Hoon"));
		System.out.println(cafe24.getMemberTree());
		System.out.println();
		
		Company feelway = new Company("Feelway");
		
		feelway.add(new Member("SooYong"));
		System.out.println(feelway.getMemberTree());
		System.out.println();
		
		cafe24.add(feelway);
		System.out.println(cafe24.getMemberTree());
		
		feelway.add(new Member("SungHoon"));
		System.out.println(cafe24.getMemberTree());
		
		cafe24.remove(feelway);
		System.out.println(cafe24.getMemberTree());
	}
}
// Main 클래스는 복합 객체 Company와 단일 객체 Member 로 이루어져, 각각의 객체에 add, remove 한 결과를 트리구조로 출력합니다.
~~~

### 참고문헌

[https://kimsunzun.tistory.com/entry/Composite%EB%B3%B5%ED%95%A9%EC%B2%B4-%ED%8C%A8%ED%84%B4]

[https://jdm.kr/blog/228]

[https://blog.seotory.com/post/2017/09/java-composite-pattern]

[https://cinrueom.tistory.com/86]

[https://gmlwjd9405.github.io/2018/08/10/composite-pattern.html]

