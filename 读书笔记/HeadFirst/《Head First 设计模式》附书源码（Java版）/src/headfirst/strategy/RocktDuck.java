package headfirst.strategy;

public class RocktDuck extends Duck {
	public RocktDuck() {
		setFlyBehavior(new FlyRocketPowered());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a RocktDuck");
	}
}
