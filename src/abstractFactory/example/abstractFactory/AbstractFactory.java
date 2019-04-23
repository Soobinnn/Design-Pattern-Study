package abstractFactory;

/*
 * ProductA와 ProductB를 생성하는 Factory 객체에 대한 인터페이스 정의
 */
public interface AbstractFactory {
	public ProductA createProductA();
	public ProductB createProductB();
}
