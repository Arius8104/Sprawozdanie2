package lab1;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Punkt {
    protected double masa = 0;
    protected double promien = 0;
    protected double glownyMom = 0;
    protected double steinerMom = 0;

    //Mutator pozwalający zmienić wartość masy
    public void ustawMase(double setMas) {
        masa = setMas;
    }

    //Akcesor zwracający masę
    public double wezMase() {
        return masa;
    }

    //konstruktor domyślny
    public Punkt() {
        masa = 5;
    }

    //konstruktor z argumentem określającym masę
    public Punkt(double m) {
        masa = m;
    }

    //metoda obliczająca moment bezwładności względem głównej osi przy promieniu = 0
    public void glownyMoment() {
        glownyMom = masa * Math.pow(promien, 2);
        System.out.println("Główny moment bezwładności wynosi: " + glownyMom);
    }

    //metoda obliczająca moment bezwładności względem osi oddalonej o 'odl'
    public void steinerMoment(double odl) {
        double steinerMom = glownyMom + masa * Math.pow((odl), 2);
        System.out.println("Moment bezwladnosci względem osi oddalonej o " + odl + "m wynosi: " + steinerMom);
    }

    //metoda wypisująca podstawowe informacje o punkcie materialnym przy 'odl' = 4
    public void info(double odl) {
        System.out.println("Punkt materialny o masie: " + masa);
        glownyMoment();
        steinerMoment(odl);
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        //Utworzenie 3 obiektow roznych klas przy pomocy konstrukorow z parametrami
        Walec walec1 = new Walec(2,5);
        Kula kula1 = new Kula(2,5);
        Pret pret1 = new Pret(2,5);

        //Wypisanie podstawowych informacji o obiektach
        walec1.info(4);
        kula1.info(5);
        pret1.info(6);

        //Stworzenie tablicy obiektów różnych klas pochodnych
        ArrayList<Punkt> listaBryl = new ArrayList<Punkt>();

        //Utworzenie i dodanie nowych obiektow do tablicy
        listaBryl.add(new Walec(4,7));
        listaBryl.add(new Kula(4,7));
        listaBryl.add(new Pret(4,7));

        //Wypisanie w petli informajci o obiektach
        for (int i = 0; i < 3; i++) {
            listaBryl.get(i).info(8);
        }

        //Zadanie na bdb
        //Deklaracja zmiennych wpisywanych przez uzytkownika
        int wybor = 0;
        double zczytanaMasa = 0;
        double zczytanyPromDl = 0;
        double zczytanaOdl = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Obliczanie momentów bezwładności wybranej bryły:");
        System.out.println("1.Walec");
        System.out.println("2.Kula");
        System.out.println("3.Pret");
        String odczyt = reader.readLine();
        wybor = Integer.parseInt(odczyt);
        while(wybor < 1 || wybor > 3)
        {
            System.out.println("Wybierz wartosc od 1 do 3");
            odczyt = reader.readLine();
            wybor = Integer.parseInt(odczyt);
        }
        System.out.println("Podaj mase");
        odczyt = reader.readLine();
        zczytanaMasa = Double.parseDouble(odczyt);
        while( zczytanaMasa < 0)
        {
            System.out.println("Masa musi być dodatnia");
            odczyt = reader.readLine();
            zczytanaMasa = Double.parseDouble(odczyt);
        }
        System.out.println("Podaj promien/dlugosc");
        odczyt = reader.readLine();
        zczytanyPromDl = Double.parseDouble(odczyt);
        while( zczytanyPromDl < 0)
        {
            System.out.println("Promien/dlugosc musza być dodatnie");
            odczyt = reader.readLine();
            zczytanyPromDl = Double.parseDouble(odczyt);
        }
        System.out.println("Podaj odległość od osi obrotu");
        odczyt = reader.readLine();
        zczytanaOdl = Double.parseDouble(odczyt);
        while( zczytanaOdl < 0)
        {
            System.out.println("Odległość musi być dodatnia");
            odczyt = reader.readLine();
            zczytanaOdl = Double.parseDouble(odczyt);
        }

        //Utworzenie obiektu w zależności od podanych przez użytkownika parametrów
        switch(wybor)
        {
            case 1:
            {
                Walec walec2 = new Walec(zczytanaMasa,zczytanyPromDl);
                walec2.info(zczytanaOdl);
                break;
            }
            case 2:
            {
                Kula kula2 = new Kula(zczytanaMasa,zczytanyPromDl);
                kula2.info(zczytanaOdl);
                break;
            }
            case 3:
            {
                Pret pret2 = new Pret(zczytanaMasa,zczytanyPromDl);
                pret2.info(zczytanaOdl);
                break;
            }
        }
    }
}
