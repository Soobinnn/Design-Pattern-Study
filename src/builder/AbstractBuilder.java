package builder;

public interface AbstractBuilder {
	public Person.Builder setLocation(String location);
	public Person.Builder setHobby(String hobby);
}
