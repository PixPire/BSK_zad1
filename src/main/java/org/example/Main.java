package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Przestawianie rail fence dla k = n.");
        System.out.println("Wybor Opcji:");
        System.out.println("1. Kodowanie");
        System.out.println("2. Dekodowanie");
        String mode = scanner.nextLine(); //pobieranie opcji
        int modeNr = Integer.parseInt(mode);
        int n = 0;
        String result = "";
        String inputText = "";
        boolean exit=false;

        do {
            switch (modeNr) {
                case 1: { //KODOWANIE
                    n=podajN(scanner);
                    System.out.println("Podaj tekst do zakodowania: ");
                    inputText = scanner.nextLine(); //wpisywanie tekstu do zakodowania

                    result = "Zakodowany tekst: " + Code(inputText, n);
                    exit=true;
                    break;
                }
                case 2: { //DEKODOWANIE
                    n=podajN(scanner);
                    System.out.println("Podaj tekst do odkodowania: ");
                    inputText = scanner.nextLine(); //wpisywanie tekstu do odkodowania
                    result = "Zdekodowany tekst: " + Decode(inputText, n);
                    exit=true;
                    break;
                }
                default: {
                    System.out.println("Wybierz poprawna opcje:");
                    System.out.println("1. Kodowanie");
                    System.out.println("2. Dekodowanie");
                    mode = scanner.nextLine(); //pobieranie opcji
                    modeNr = Integer.parseInt(mode);
                }
            }
        }while(!exit);


        System.out.println(result);

    }



    public static String Code(String text, int n) {

        String codedText="";

        StringBuilder[] rails = new StringBuilder[n]; //Utworzenie obiektu tablicy StringBuilderów, każdy StringBuilder
        // tworzy oddzielny napis-szynę, które później będą składane w zakodowany tekst

        for(int i=0;i<n;i++){
            rails[i]=new StringBuilder(); //Utworzenie konkretnych instancji StringBuilder dla każdej szyny
        }

        int activeRail = 0; // nr aktualnie obslugiwanej szyny, pierwsza litera zapisana bedzie na szynie najwyzszej -> 0
        boolean dirDown = true; // boolean określający, czy kolejna litera będzie zapisana na szynie niższej (true) czy na szynie wyższej (false)

        for (int i = 0; i < text.length(); i++) { //pętla wpisująca kolejne litery na odpowiednie szyny

            rails[activeRail].append(text.charAt(i));//dodawanie litery do aktywnej szyny


            //przełączanie aktywnej szyny na niższą lub wyższą zależnie od aktualnego kierunku zygzaku dirDown
            if(dirDown)activeRail++;
            if(!dirDown)activeRail--;

            if(activeRail==0){ //jezeli litera została wpisana na najwyższej szynie, to kolejne będą wypisywane na kolejnych niższych szynach
                dirDown=true;
            }else if(activeRail==n){
                dirDown=false;
                activeRail=n-2;
            }
        }

        StringBuilder codedTextBuilder = new StringBuilder();//Utworzenie StringBuildera, do którego przekazywane będą kolejne szyny

        for(int i=0;i<n;i++){
            codedTextBuilder.append(rails[i].toString());//przekazywanie kolejnych szyn do wyniku
        }
        codedText=codedTextBuilder.toString();
        return codedText;
    }




    public static String Decode(String codedText, int n) {

        char[] decodedText = new char[codedText.length()];

        int activeChar = 0; //indeks, która pozycja w tekście zakodowanym jest aktualnie rozpatrywana

        for (int activeRail = 0; activeRail < n; activeRail++) { //rozpatrywanie każdej szyny
            int decodedPosition = activeRail; //na której pozycji należy umieścić aktualnie rozpatrywaną literę z kodu zakodowanego.
            boolean dirDown = true;


            //określanie, na której pozycji tekstu odkodowanego ma się znajdować dana litera
            while (decodedPosition < codedText.length()) {
                decodedText[decodedPosition] = codedText.charAt(activeChar++);

                //przejscie na kolejną literę tej samej szyny
                if (activeRail == 0 || activeRail == n - 1) {
                    decodedPosition = decodedPosition + 2 * (n - 1);//dla szyn graniczących
                } else if (dirDown) { //dla pozostałych szyn stosowane zamiennie 2 wzory na odczytywanie kolejnych wartosci
                    // (zależnie czy zygzak idzie do góry czy do dołu są 2 ilości ,,wolnych pól" między literami tej samej szyny)
                    decodedPosition = decodedPosition + 2 * (n - activeRail - 1);
                    dirDown = false;
                } else {
                    decodedPosition = decodedPosition + 2 * activeRail;
                    dirDown = true;
                }
            }
        }
        return new String(decodedText);
    }



    public static int podajN(Scanner scanner){
        System.out.println("Podaj n: ");
        int n=0;

        while(n<=0||n>10){
            try{
                String inputText = scanner.nextLine();
                n=Integer.parseInt(inputText);

            }catch(NumberFormatException e)
            {
                System.out.println("Podaj prawidlowa wartosc z zakresu 1-10: ");
                n=0;
            }

        }
        return n;
    }
}