
public class Thread implements Runnable {

    int seconds = 10;
    int survivedP = Driver.Pos;
    boolean countdown = true;
    Soldier[] s;
    int maxCapacity = survivedP / 2;
    int maxWeight = maxCapacity * 290;
    Bridge b;
    int movedS = 0;
    static int count = 0;

    public Thread(Soldier[] sold) {
        s = sold;
    }

    @Override
    public void run() {

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("The amount of soldier the survived the Predator battle are: " + survivedP);
        System.out.println("THE PREDATOR STARTED THE SELF-DESTRUCT!!!");
        System.out.println("The bridged Capacity is: " + maxCapacity);
        System.out.println("The bridged Max Weight is: " + maxWeight);
        System.out.println("***********************************************************");
        System.out.println();

        b = fillBridge();

        while (countdown && count <= survivedP) {
            //print countdown
            String cadena = Integer.toString(seconds);
            System.out.println("-------------------------------------------------------");
            System.out.println();
            System.out.println(cadena + "s FOR DESTRUCTION");
            System.out.println();

            if (checkWeight(b)) {
                b = take5(b);
            } else {
                seconds = 0;
                System.out.println("Soldiers have died from bridge collapse and explosion");
                System.out.println();
                System.out.println("-------------------------------------------------------");
            }

            seconds--;//seconds decrease

            if (seconds == -1) {

                for (int i = b.front; i < b.queArray.length; i++) {
                    System.out.println(b.queArray[i].getName() + " died.");
                }
                countdown = false;
            }

            try {
                java.lang.Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public Bridge fillBridge() {

        Bridge b = new Bridge(survivedP);

        for (int i = survivedP; i >= 0; i--) {
            b.insert(s[i]);
        }

        return b;

    }

    public boolean checkWeight(Bridge br) {
        if (maxCapacity + br.front <= b.size()) {
            int sumW = 0;

            for (int i = br.front; i < maxCapacity + br.front; i++) {
                sumW = sumW + br.queArray[br.front + 1].getWeight();

            }

            System.out.println("The sum of the soldiers in the bridge is: " + sumW);

            if (sumW < maxWeight) {
                System.out.println("The bridge can hold them");
                System.out.println("-------------------------------------------------------");
                System.out.println();
                return true;
            } else {
                System.out.println("The bridge collapsed");
                System.out.println("-------------------------------------------------------");
                System.out.println();
                return false;
            }
        } else {
            return true;
        }

    }

    public Bridge take5(Bridge br) {
        //System.out.println("The front is: " + b.queArray[b.front].getName());
        outerloop:
        for (int i = 0; i < 5; i++) {
            if (br.front < survivedP) {

                System.out.println(br.peekFront().getName() + " has passed the bridge.");
                br.remove();
                count++;

            }else{
                break outerloop;
            }

        }
        System.out.println("-------------------------------------------------------");

        return br;
    }

}
