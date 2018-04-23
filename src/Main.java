public class Main {

    public static void main(String[] args) {

        Klas eersteKlas = new Klas(1);
        Klas tweedeKlas = new Klas(2);

        Station Goes = new Station("Goes");
        Station Middelburg = new Station("Middelburg");
        Station Arnemuiden = new Station("Arnemuiden");
        Station Vlissingen = new Station("Vlissingen");


        Wagon w1 = new Wagon();
        Trein NS = new Trein(w1, Goes);
        System.out.println(NS);

        Reiziger klaas = new Reiziger("klaas", true, Vlissingen, tweedeKlas);
        Reiziger piet = new Reiziger("piet", true, Vlissingen, tweedeKlas);
        Reiziger henk = new Reiziger("henk", true, Vlissingen, tweedeKlas);
        Reiziger jan = new Reiziger("jan", true, Vlissingen, tweedeKlas);
        Reiziger peter = new Reiziger("peter", true, Vlissingen, tweedeKlas);

        NS.instappen(klaas);
        NS.instappen(piet);
        NS.instappen(henk);
        NS.instappen(jan);
        NS.instappen(peter);

        Reiziger doc = new Reiziger("doc", true, Vlissingen, eersteKlas);

        NS.instappen(doc);

        Reiziger zwart = new Reiziger("wart", false, Middelburg, tweedeKlas);

        NS.instappen(zwart);

        NS.reizen(Arnemuiden, false);

        Wagon w2 = new Wagon();

        NS.aankoppelen(w2);

    }
}
