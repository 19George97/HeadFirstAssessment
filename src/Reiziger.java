
public class Reiziger {
    private String name;
    private Ticket ticket;
    private Station eindbestemming;

    public Reiziger(String name, Ticket ticket, Station eindbestemming) {
        this.name = name;
        this.ticket = ticket;
        this.eindbestemming = eindbestemming;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Station getEindbestemming() {
        return eindbestemming;
    }
}
