import java.util.ArrayList;

public class Router {
    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public ArrayList<Karte> getKarten() {
        return karten;
    }

    public void setKarten(ArrayList<Karte> karten) {
        this.karten = karten;
    }

    private ArrayList<Karte> karten;


}
