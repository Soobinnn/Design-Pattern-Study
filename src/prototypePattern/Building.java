package prototypePattern;

public interface Building extends Cloneable{
	public abstract void abilityToDo();
	public abstract Building createClone();
}

