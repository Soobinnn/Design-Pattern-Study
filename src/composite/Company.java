package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
