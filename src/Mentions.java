public class Mentions {

  private String id;
  private int idArtiste;
  private int idArtisteMentionne;
  private int nbMention;

  public Mentions(String id, int idArtiste, int idArtisteMentionne, int nbMention) {
    this.id = id;
    this.idArtiste = idArtiste;
    this.idArtisteMentionne = idArtisteMentionne;
    this.nbMention = nbMention;
  }

  public String getId() {
    return id;
  }

  public int getIdArtiste() {
    return idArtiste;
  }

  public int getIdArtisteMentionne() {
    return idArtisteMentionne;
  }

  public int getNbMention() {
    return nbMention;
  }
}
