package xyz.GPSforLEGENDS;


import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    static int[][] timeTable = {{2,8,10},{2,17,20},{3,7,50},{6,8,0},{6,16,0},{7,16,30},{8,8,20},{8,16,40},{30,8,10}};

    public static void main(String[] args) {

        erzeugeListe(1, timeTable, 2022, 1);
    }

    private static void erzeugeListe(int persnr, int[][] zeiten, int jahr, int monat){
        schreibeKopf(123, 2022, 2);
        outer:
        for(int i = 1; i <= tageImMonat(monat, jahr); i++){
            for(int k = 0; k < timeTable.length; k++){
                
                //passender Eintrag
                if(i == timeTable[k][0]){
                    //gibt es auch gehen Zeit?
                    if((k+1 < timeTable.length) && timeTable[k][0] == timeTable[k+1][0]){
                        int gekommen = timeTable[k][1]*60 + timeTable[k][2];
                        int gegangen = timeTable[k+1][1]*60 + timeTable[k+1][2];

                        int anwesenheit = gegangen - gekommen;

                        schreibeZeile(i, timeTable[k][1], timeTable[k][2], timeTable[k+1][1], timeTable[k+1][2], anwesenheit, "");

                        k += 1;
                        continue outer;
                    } else{
                        //keine gehen Zeiten
                        schreibeZeile(i, timeTable[k][1], timeTable[k][2], -1, -1, -1, "Buchung fehlt");
                        continue outer;
                    }
                } else{
                    //nicht anwesend
                }
            }
            schreibeZeile(i, -1, -1, -1, -1, -1, "nicht anwesend");
        }
    }

    private static int tageImMonat(int monat, int jahr){

        YearMonth yearMonth = YearMonth.of(jahr, monat);
        return yearMonth.lengthOfMonth();
    }

    private static void schreibeKopf(int persnr, int jahr, int monat){
        YearMonth yearMonth = YearMonth.of(jahr, monat);
        System.out.println("Mitarbeiter: " + persnr + "        " + yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN) + " " + yearMonth.getYear());

        System.out.println("");
        System.out.println("Tag Kommen Gehen Anwesenheit Bermerkung");
        System.out.println("=======================================");
    }

    private static void schreibeZeile(int tag, int std1, int min1, int std2, int min2, int anwTag, String bemerkung){
        System.out.println(tag + "   " + std1 + ":" + min1 + "   " + std2 + ":" + min2 + "   " + anwTag/60 + ":" + anwTag%60 + "    " + bemerkung);
    }

    private static void schreibeFuß(int anwMonat){
        System.out.println("Summe Anwesenheit: " + anwMonat);
    }


}
