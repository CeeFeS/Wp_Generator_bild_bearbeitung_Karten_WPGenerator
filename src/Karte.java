public class Karte {
    private int slot;
    private String bezeichnung;

    public Karte(int slot, String bezeichnung, String farbe) {
        this.slot = slot;
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    private String farbe;
}
