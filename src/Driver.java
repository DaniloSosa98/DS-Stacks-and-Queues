
public class Driver {

    public static int Pos = 0;

    public static void main(String[] args) {

        LoadFile f = new LoadFile();
        String[] names = f.Array();
        Soldier s;
        Soldier[] soldiers = new Soldier[63];
        for (int i = 0; i < names.length; i++) {
            s = new Soldier(names[i]);
            soldiers[i] = s;
        }
        soldiers = battle(soldiers);

        Thread t = new Thread(soldiers);
        t.run();
        

    }

    public static Soldier[] battle(Soldier[] soldiers) {

        Cavern c = new Cavern(soldiers.length);
        for (int i = 0; i < soldiers.length; i++) {
            c.push(soldiers[i]);
        }

        Predator p = new Predator();
        int Plife = p.getLife();
        int Slife;
        System.out.println("Predator's initial HP: " + Plife);
        int countS = 62;
        boolean Salive = true, Palive = true;

        //SIMULAION
        do {
            Salive = true;
            Slife = c.peek().getLife();
            do {
                System.out.println("------------------------------------------");

                if (Slife > 0) {
                    Plife = Plife - c.peek().inflictDamage();
                    System.out.println("Predator's HP: " + Plife);
                }

                if (Plife < 0) {
                    System.out.println("Predator was defeated");
                    System.out.println("------------------------------------------");
                    Palive = false;
                }

                if (Plife > 0) {
                    Slife = Slife - p.inflictDamage();
                    System.out.println("Soldier's " + c.peek().getName() + " HP: " + Slife);
                }

                if (Slife < 0) {
                    System.out.println("Soldier was defeated");
                    System.out.println("------------------------------------------");
                    c.pop();
                    Salive = false;
                }

            } while (Salive && Palive);

            countS--;

        } while (Plife > 0 && !c.isEmpty());
        Pos = countS+1;
        return c.stackArray;
    }

}
