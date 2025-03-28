import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<Integer, Map<Artists, Integer>> nbMentionDArtistesParArtiste;
    private Map<Integer, Artists> mapArtists ;
    private Map<String, Integer> mapArtistParNom;
    private Map<String, List<Integer>> listDArcs;

    public Graph(String artists, String mentions) {
        nbMentionDArtistesParArtiste = new HashMap<>();
        mapArtists = new HashMap<>();
        listDArcs = new HashMap<>();
        mapArtistParNom = new HashMap<>();

        try (BufferedReader brArtist = new BufferedReader(new FileReader(artists))) {
            String artistLine;

            while ((artistLine = brArtist.readLine()) != null) {
                String[] artist = artistLine.split(",");
                mapArtistParNom.put(artist[1], Integer.parseInt(artist[0]));
                mapArtists.put(Integer.parseInt((artist[0])), new Artists(Integer.parseInt(artist[0]), artist[1], artist[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        try (BufferedReader brMentions = new BufferedReader(new FileReader(mentions))) {
            String mentionLine;

            while ((mentionLine = brMentions.readLine()) != null) {
                String[] mention = mentionLine.split(",");
                Map<Artists, Integer> map = new HashMap<>();
                map.put(mapArtists.get(Integer.parseInt(mention[1])),1/Integer.parseInt(mention[2]));
                nbMentionDArtistesParArtiste.put(Integer.parseInt(mention[0]), map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void trouverCheminLePlusCourt(String artistSource , String artistMentionne) {
        List file = new ArrayList<Objects>();
        Boolean trouve = false;
        int longueurChemin = 0;
        double coupChemin = 0;
        int idArtisteSource = mapArtistParNom.get(artistSource);
        int idArtisteMentionne = mapArtistParNom.get(artistMentionne);
        while (!trouve){
            Map<Artists, Integer> listArtistMentionne = nbMentionDArtistesParArtiste.get(idArtisteSource);
            file.addAll(listArtistMentionne.keySet());
            if (listArtistMentionne.containsKey(idArtisteMentionne)) {
                System.out.println( "Longueur du chemin : " + longueurChemin + "\n" +
                        "Coût total du chemin : " + coupChemin + "\n" +
                        "Chemin :\n");
                trouve = true;
            }
        }

    }

    public void trouverCheminMaxMentions(String artistSource , String artistMentionne) {

    }

}
