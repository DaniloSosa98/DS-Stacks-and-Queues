
import java.util.Random;

class Soldier extends Sim_Object {

    private int weight;
    private String name;

    public Soldier(String Sname) {
        super(100);
        Random random = new Random();
        weight = random.nextInt(150) + 150;
        name = Sname;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public int inflictDamage() {
        return (getLife() % 10) * 7;
    }

    public String toString() {
        return getName() + ": " + getWeight() + " lbs, Life: " + getLife();
    }

}
