public class Main {

    public static void main(String[] args) {


//        De trein start op station Goes met 1 wagon.
        System.out.println("");
        Station Goes = new Station("Goes");

        Station VlissingenSouburg = new Station("VlissingenSouburg");
        Station Arnemuiden = new Station("Arnemuiden");
        Station Middelburg = new Station("Middelburg");
        Station Vlissingen = new Station("Vlissingen");

        Trein NS = new Trein(Goes);

        Wagon w1 = new Wagon(NS);
        NS.aankoppelen(w1);



//        Op Goes stappen 5 reizigers 2e klas op, 1 reiziger 1e klas en 1 zwartrijder.
//  Allen hebben ze bestemming "Vlissingen";
// enkel de zwartrijder heeft bestemming "Middelburg".
        System.out.println("");
        Reiziger henk = new Reiziger("Henk", new Ticket(TicketType.tweedeKlas), Vlissingen);
        NS.instappen(henk);
        Reiziger klaas = new Reiziger("Kaas", new Ticket(TicketType.tweedeKlas), Vlissingen);
        NS.instappen(klaas);

        //1e klas
        Reiziger jasper = new Reiziger("Jasper", new Ticket(TicketType.eersteKlas), Vlissingen);
        NS.instappen(jasper);

        //zwartreiziger
        Reiziger zwartnek = new Reiziger("zwartnek", new Ticket(TicketType.zwartrijder), Middelburg);
        NS.instappen(zwartnek);


//        Op Arnemuiden
//        wordt er een wagon aangekoppeld
//        stappen er twee 2e klas reizigers op met bestemming "Vlissingen-Souburg"
        System.out.println("");
        NS.reizen(Arnemuiden);
        Wagon w2 = new Wagon(NS);
        NS.aankoppelen(w2);

        Reiziger fabio = new Reiziger("fabio", new Ticket(TicketType.tweedeKlas), VlissingenSouburg);
        NS.instappen(fabio);
        Reiziger sjon = new Reiziger("sjon", new Ticket(TicketType.tweedeKlas), VlissingenSouburg);
        NS.instappen(sjon);


//        Tussen Arnemuiden en Middelburg worden de kaartjes gecontroleerd. De zwartrijder wordt uit de trein gesmeten.
//        Op station "Middelburg" stappen de reizigers uit met bestemming "Middelburg". Er stapt 1 reiziger 1e klas in met bestemming "Vlissingen".
        System.out.println("");
        NS.ticketcheck();
        NS.reizen(Middelburg);
        Reiziger nieuweling = new Reiziger("nieuweling rijk", new Ticket(TicketType.eersteKlas), Vlissingen);
        NS.instappen(nieuweling);


//        Op station "Vlissingen-Souburg" stappen de reizigers uit met bestemming "Vlissingen-Souburg". Er stappen geen reizigers in.
        System.out.println("");
        NS.reizen(VlissingenSouburg);

//        Op station "Vlissingen" stappen alle reizigers uit. Alle wagons zijn nu leeg.
        System.out.println("");
        NS.reizen(Vlissingen);
    }
}
