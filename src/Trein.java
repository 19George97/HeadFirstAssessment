
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Trein {

    private List<Wagon> wagons = new ArrayList<Wagon>();

    private Station station;

    public Trein(Station station) {
        this.station = station;
    }

    public void aankoppelen(Wagon wagon) {
        wagons.add(wagon);
        System.out.println("Nieuwe wagon aangekoppeld: " + wagon);
    }

    public void ticketcheck(){

        List<Reiziger> totaalReizigersInTrein = new ArrayList<Reiziger>();
        for(Wagon w : this.wagons){
            totaalReizigersInTrein.addAll(w.alleReizigers());
        }

        for (Reiziger r : totaalReizigersInTrein) {
            if (r.getTicket().getType() == TicketType.zwartrijder) {
                uitstappen(r);
                System.out.println("Zwartrijder " + r.getName() + " is eruit geschopt");
            }
        }
    }

    public void instappen(Reiziger reiziger) {
        //nog plek vrij in gekozen klas
        TicketType type = reiziger.getTicket().getType();
        for (Wagon wagon : wagons) {
            if (wagon.plekken(type) > 0) { //er is een plek vrij
                wagon.instappen(reiziger);
                System.out.println(reiziger.getName() + " is ingestapt");
                return;
            }
        }
        System.out.println("Er is geen plek voor deze reiziger.");
    }

    public void uitstappen(Reiziger r){
        for(Wagon w : wagons){
            if(w.bevatReiziger(r)){
                w.uitstappen(r);
                System.out.println(r.getName() + " is gearriveerd op zijn bestemming en nu uitgestapt");
            }
        }
    }

    public void reizen(Station station) {
        this.station = station;
        System.out.println("Aan het reizen.... tuf tuf");
        System.out.println("Aangekomen in " + station.getName());
        //mensen op bestemming stappen uit
        for (Wagon wagon : wagons) {
            wagon.aangekomen();
        }
        this.toString();
    }


    public String toString() {
        System.out.println("De trein ziet er nu als volgt uit: ");
        System.out.println("Totaal aantal wagons " + this.getWagons().size() + "\n" + "Huidig station: " + this.getStation());

        for(Wagon w: wagons){
            System.out.println("Gegevens van wagon " + w);
            System.out.println("Alle reizigers in deze wagon: " + w.alleReizigers().size());
            for(Reiziger r : w.alleReizigers()){
                System.out.println("Reiziger: " + r.getName() + " Ticket: " + r.getTicket().getType() + " Eindbestemming: " + r.getEindbestemming());
            }
        }
        return null;
    }

    public List<Wagon> getWagons() {
        return this.wagons;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }
}
