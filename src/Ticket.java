public class Ticket {

    private TicketType type;

    public Ticket(TicketType type) {
        this.setType(type);
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

}