
import java.util.Random;

abstract class Sim_Object {

    private int life;

    public Sim_Object(int _lifeLimit) {
        Random randomGenerator = new Random();
        life = randomGenerator.nextInt(_lifeLimit) + _lifeLimit;
    }

    public int getLife() {
        return life;
    }

    public void takeDamage(int damage) {
        life -= damage;
    }

    public abstract int inflictDamage();
}
