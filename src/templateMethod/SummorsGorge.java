package templateMethod;

public class SummorsGorge {

	public static void main(String[] args) {
		
		System.out.println("소환사의 협곡에 오신 것을 환영합니다.\n");
		
		TopLiner top1 = new Teemo();
		TopLiner top2 = new Vladimir();
		
		System.out.println("티모 스킬");
		top1.skill();
		top1.ultimateSkill();
		System.out.println("소환사 주문");
		top1.flashing();
		top1.warp();
		
		System.out.println("");
		
		System.out.println("블라디 스킬");
		top2.skill();
		top2.ultimateSkill();
		System.out.println("소환사 주문");
		top2.flashing();
		top2.warp();
		
	}

}
