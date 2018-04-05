package lab1;

public class Walec extends Punkt {
    //konstruktor domyślny
    public Walec() {
        super();
        promien = 2;
    }

    //konstruktor z argumentem określającym promien
    public Walec(double m, double r) {
        super(m);
        promien = r;
    }

    //Setter promienia
    public void ustawPromien(double setPromien)
    {
        promien = setPromien;
    }

    //Getter promienia
    public double wezPromien() {return promien;}

    //Przeciążona metoda obliczająca glowny moment bezwładności
    public void glownyMoment()
    {
        glownyMom = masa * Math.pow(promien, 2)/2;
        System.out.println("Główny moment bezwładności wynosi: " + glownyMom);
    }

    //Przeciążona metoda obliczająca moment bezwładności z twierdzenia Steinera
    public void steinerMoment(double odl) {
        super.steinerMoment(odl);
    }

    //Przeciążona metoda wypisująca informacje o Walcu
    public void info(float odl) {
        System.out.println("Walec o masie: " + masa + " i promieniu: " + promien);
        glownyMoment();
        steinerMoment(odl);
        System.out.println();
    }
}