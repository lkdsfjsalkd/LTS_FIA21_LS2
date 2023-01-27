package school;

import java.util.Scanner;

public class ticketMachine {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        double zuZahlenderBetrag = 0;
        double eingezahlterGesamtbetrag;
        double rueckgabebetrag;        

        Begrüßung();
        zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
        fahrkartenAusgeben();
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        rueckgeldAusgeben(rueckgabebetrag);

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();

    }

    /*
     * prints out ticket information
     */
    public static void Begrüßung() {
    //    System.out.print(
//                "Wählen Sie das Gewünschte Ticket:\n  Kurzstrecke AB [2,00 EUR] (1)\n  Einzelfahrschein AB [3,00 EUR] (2)\n  Tageskarte AB [8,80 EUR] (3)\n  4-Fahrten-Karte AB [9,40 EUR] (4)\n ");
    }
    /*
     * Selects ticket and ticketcount, and give back total costs
     */
    public static double fahrkartenbestellungErfassen(Scanner tastatur) {
        int ticketnr;
        int index =0;
        double zuZahlenderBetrag = 0;
        float[] ticketPreis ={3f,3.5f,3.8f,2f,8.6f,9.2f,10f,9.4f,12.6f,13.8f,25.5f,26f,26.5f};
        String[]fahrkartenBezeichnung ={"Einzelfahrschein AB","Einzelfahrschein BC","Einzelfahrschein AC",
                                        "Kurzstrecke AB","Tageskarte AB","Tageskarte BC","Tageskarte ABC",
                                        "4-Fahrten-Karte-AB","4-Fahrten-Karte BC","4-Fahrten-Karte ABC",
                                        "Kleingruppen-Tageskarte AB","Kleingruppen-Tageskarte BC","Kleingruppen-Tageskarte ABC"};
        System.out.print("Herzlich Willkommen\n");
        for (String ticket : fahrkartenBezeichnung) {
            System.out.print(index+1+":\t"+ticketPreis[index]+"€\t"+ticket+"\n");
            index++;
        }
        ticketnr = tastatur.nextInt();
        while (ticketnr < 1 || ticketnr > 13) {
            System.out.print("Bitte geben sie eine valide Ticketnummer an\n");
            ticketnr = tastatur.nextInt();
        }

        zuZahlenderBetrag = ticketPreis[ticketnr-1];

        System.out.print("Anzahl der Tickets eingeben\n ");
        int ticketcount = tastatur.nextInt();
        while (ticketcount < 1 || ticketcount > 10) {
            System.out.print("Bitte geben sie eine Menge von 1 bis 10 Tickets ein\n");
            ticketcount = tastatur.nextInt();
        }
        zuZahlenderBetrag *= ticketcount;
        return zuZahlenderBetrag;
    }
    /*
     * Paying proccess needs scanner and total costs
     */
    public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
        double eingezahlterGesamtbetrag;
        double nochZuZahlen;
        double eingeworfeneMuenze;

        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) 
        {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro \n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
        }
        return eingezahlterGesamtbetrag;
    }
    /*
    * ticket output visual
    */
    public static void fahrkartenAusgeben() {
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
    }
    /*
     * Payback
     */
    public static void rueckgeldAusgeben(double rueckgabebetrag) {
        if (rueckgabebetrag > 0.0) {
            System.out.print(rueckgabebetrag);
            System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
                // System.out.print(rueckgabebetrag);
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
            }
            while (rueckgabebetrag >= 0.5) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;
                rueckgabebetrag = (double) (Math.round(rueckgabebetrag * 100)) / 100;
            }
        }
    }

}
