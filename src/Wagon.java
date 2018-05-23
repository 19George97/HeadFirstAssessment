import java.util.ArrayList;
import java.util.List;

public class Wagon {

    private List<Reiziger> eersteKlas = new ArrayList<Reiziger>();
    private List<Reiziger> tweedeKlas = new ArrayList<Reiziger>();
    private Trein trein;

    public Wagon(Trein trein) {
        this.trein = trein;
    }

    //check het aantal plekken in de wagon voor een kaartje type
    public int plekken(TicketType type) {

        int eersteKlasPlekken =
//                Constants.EERSTE_KLAS_MAX - eersteKlas.size();
                4 - eersteKlas.size();

        int tweedeKlasPlekken =
//                Constants.TWEEDE_KLAS_MAX - tweedeKlas.size();
                5 - tweedeKlas.size();


        //de wagon is vol
        if (tweedeKlasPlekken == 0 && eersteKlasPlekken == 0)
            return 0;

        switch(type) {

            case zwartrijder:
            case eersteKlas:
                if (eersteKlasPlekken == 0)
                    return tweedeKlasPlekken;

                return eersteKlasPlekken;

            case tweedeKlas:
                if (tweedeKlasPlekken == 0)
                    return eersteKlasPlekken;

                return tweedeKlasPlekken;
        }

        return 0;
    }

    public void instappen(Reiziger r) {

        TicketType type = r.getTicket().getType();

        if (plekken(type) == 0) {
            System.out.println("Kan niet instappen, er is geen plek voor deze reiziger.");
            return;
        }

        getListForTicket(type).add(r);
    }

    public void uitstappen(Reiziger r) {
        if (eersteKlas.contains(r))
            eersteKlas.remove(r);
        tweedeKlas.remove(r);
    }

    public boolean bevatReiziger(Reiziger r){
        //als reiziger in tweede of eerste klas zit van deze wagon return true
        if(tweedeKlas.contains(r) || eersteKlas.contains(r)){
            return true;
        }
        return false;
    }

    private List<Reiziger> getListForTicket(TicketType type) {

        int eersteKlasPlekken =
                4 - eersteKlas.size();

        int tweedeKlasPlekken =
                5 - tweedeKlas.size();

        //de wagon is vol
        if (tweedeKlasPlekken == 0 && eersteKlasPlekken == 0)
            return null;

        switch(type) {
            case zwartrijder:
            case eersteKlas:
                if (eersteKlasPlekken > 0)
                    return eersteKlas;

                return tweedeKlas;
            case tweedeKlas:
                if (tweedeKlasPlekken > 0)
                    return tweedeKlas;

                return eersteKlas;
        }

        return null;
    }

    public List<Reiziger> alleReizigers(){

        List<Reiziger> listReizigers = new ArrayList<Reiziger>(this.eersteKlas);
        listReizigers.addAll(this.tweedeKlas);

        return listReizigers;

    }

    public void aangekomen() {
        for (Reiziger r : alleReizigers()) {
            if (trein.getStation() == r.getEindbestemming()) {
                trein.uitstappen(r);
            }
        }
    }

}
