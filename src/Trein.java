
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Trein {


    private Wagon wagon;

//    private Reiziger[] reizigers = new Reiziger[];

    private Station station;

    public Trein(Wagon wagon, Station station) {
        this.wagon = wagon;
        this.station = station;
    }


    public int vrijePlek(int klasnumber) {
        if (klasnumber == 2) {
            for (int i = 0; i < this.getWagon().getTweedeklas().length; i++) {
                if (this.getWagon().getTweedeklas()[i] == null)
                    return i;
            }
        } else if( klasnumber == 1) {
            for (int i = 0; i < this.getWagon().getEersteklas().length; i++) {
                if (this.getWagon().getEersteklas()[i] == null)
                    return i;
            }
        }
        return -1;
    }

    public void instappen(Reiziger reiziger) {
        //nog plek vrij in gekozen klas
        if(vrijePlek(reiziger.getKlas().getKlasnumber()) != -1){
            if (reiziger.getKlas().getKlasnumber() == 2) {
                this.getWagon().getTweedeklas()[vrijePlek(reiziger.getKlas().getKlasnumber())] = reiziger;
            } else if (reiziger.getKlas().getKlasnumber() == 1) {
                this.getWagon().getEersteklas()[vrijePlek(reiziger.getKlas().getKlasnumber())] = reiziger;
            }
            System.out.println(reiziger.getName() + " is ingestapt!");

        } else if(vrijePlek(reiziger.getKlas().getKlasnumber()) == -1){
            System.out.println("De " + reiziger.getKlas().getKlasnumber() + "e klas is vol, " + reiziger.getName() + " mag naar een andere klas");
            this.getWagon().getEersteklas()[vrijePlek(1)] = reiziger;
            System.out.println(reiziger.getName() + " is ingestapt in de eerste klas!");
        }

    }


    public void reizen(Station station, boolean controle){
        if(controle){
            System.out.println("De tickets worden gecontroleerd! Opgepast!");
        }
        System.out.println("de trein gaat verder naar het volgende stations");
        this.setStation(station);
        System.out.println("is nu aangekomen bij station " + this.station.getName());
    }

    public void aankoppelen(Wagon wagon){
        System.out.println("Wagon wordt aangekoppeld");
    }

//    public void showInfo(){
//        System.out.println("de Wagon ziet er nu zo uit ");
//        System.out.println(this.getWagon());
//    }

    @Override
    public String toString() {
        return "Totaal aantal wagons " + this.getWagon() + "\n" + "Huidig station: " + this.getStation();
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }
}
