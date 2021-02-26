
class Predator extends Sim_Object {

    public Predator() {
        super(1000);
    }

    @Override
    public int inflictDamage() {
        return (getLife() % 10) * 5;
    }
}
