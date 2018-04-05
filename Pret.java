package lab1;

public class Pret extends Punkt {
    
    private double dlugosc = 0;
    
    //konstruktor domyślny
    public Pret() {
        super();
        dlugosc = 2;
    }

    //konstruktor z argumentem określającym promien
    public Pret(double m, double l) {
        super(m);
        dlugosc = l;
    }

    //Setter dlugosci
    public void ustawDlugosc(double setDlugosc)
    {
        dlugosc = setDlugosc;
    }

    //Getter dlugosci
    public double wezDlugosc() {return dlugosc;}

    //Przeciążona metoda obliczająca glowny moment bezwładności
    public void glownyMoment()
    {
        glownyMom = masa * Math.pow(dlugosc, 2)/12;
        System.out.println("Główny moment bezwładności wynosi: " + glownyMom);
    }

    //Przeciążona metoda obliczająca moment bezwładności z twierdzenia Steinera
    public void steinerMoment(float odl) {
        super.steinerMoment(odl);
    }

    //Przeciążona metoda wypisująca informacje o Pręcie
    public void info(double odl) {
        System.out.println("Pret o masie: " + masa + " i dlugosci: " + dlugosc);
        glownyMoment();
        steinerMoment(odl);
        System.out.println();
    }
}