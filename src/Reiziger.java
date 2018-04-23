public class Reiziger {
    private String name;
    private boolean heeftTicket = false;
    private Station eindbestemming;
    private Klas klas;

    public Reiziger(String name, boolean heeftTicket, Station eindbestemming, Klas klas) {
        this.name = name;
        this.heeftTicket = heeftTicket;
        this.eindbestemming = eindbestemming;
        this.klas = klas;
    }

    public String getName() {
        return name;
    }

    public Klas getKlas() {
        return klas;
    }
}
