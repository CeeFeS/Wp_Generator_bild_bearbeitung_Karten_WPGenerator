import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Router router = new Router();
        router.setBezeichnung("ATN 950C");


        ArrayList<Karte> karten = new ArrayList<>();
        Karte karte_slot1 = new Karte(1, null, null);
        Karte karte_slot2 = new Karte(2, "ATN950C-CXPB, DC, redundant, 1588, ipv6", "1310nm + 1490nm + 1470nm");
        Karte karte_slot3 = new Karte(3, null, null);
        Karte karte_slot4 = new Karte(4, "ATN950C-CXPB, DC, redundant, 1588, ipv6", "1310nm + 1490nm + 1470nm");
        Karte karte_slot5 = new Karte(5, null, null);
        Karte karte_slot6 = new Karte(6, "ATN950C-CXPB, DC, redundant, 1588, ipv6", "1310nm + 1490nm + 1470nm");


        karten.add(karte_slot1);
        karten.add(karte_slot2);
        karten.add(karte_slot3);
        karten.add(karte_slot4);
        karten.add(karte_slot5);
        karten.add(karte_slot6);
        router.setKarten(karten);


        BildGenerator bildGenerator = new BildGenerator(router);

    }
}
