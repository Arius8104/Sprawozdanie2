package lab1;

public class Kula extends Punkt {
    
    //konstruktor domyślny
    public Kula() {
        super();
        promien = 2;
    }

    //konstruktor z argumentem określającym promien
    public Kula(double m, double r) {
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
        glownyMom = masa * Math.pow(promien, 2)*2/5;
        System.out.println("Główny moment bezwładności wynosi: " + glownyMom);
    }

    //Przeciążona metoda obliczająca moment bezwładności z twierdzenia Steinera
    public void steinerMoment(float odl) {
        super.steinerMoment(odl);
    }

    //Przeciążona metoda wypisująca informacje o Kuli
    public void info(double odl) {
        System.out.println("Kula o masie: " + masa + " i promieniu: " + promien);
        glownyMoment();
        steinerMoment(odl);
        System.out.println();
    }
}