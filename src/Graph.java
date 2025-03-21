import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<Integer, Map<Artists, Integer>> nbMentionDArtistesParArtiste;
    private Map<Integer, Artists> MapArtists ;

    public Graph(File artists, File mentions) {
        nbMentionDArtistesParArtiste = new HashMap<Integer, Map<Artists, Integer>>();
        MapArtists = new HashMap<Integer, Artists>();

        try (BufferedReader brArtist = new BufferedReader(new FileReader(artists))) {
            String artistLine;

            while ((artistLine = brArtist.readLine()) != null) {
                String[] artist = artistLine.split(",");
                MapArtists.put(Integer.parseInt((artist[0])), new Artists(Integer.parseInt(artist[0]), artist[1], artist[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        try (BufferedReader brMentions = new BufferedReader(new FileReader(mentions))) {
            String mentionLine;

            while ((mentionLine = brMentions.readLine()) != null) {
                String[] mention = mentionLine.split(",");
                Map<Artists, Integer> map = new HashMap<>();
                map.put(MapArtists.get(Integer.parseInt(mention[1])),Integer.parseInt(mention[2]));
                nbMentionDArtistesParArtiste.put(Integer.parseInt(mention[0]), map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
