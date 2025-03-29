public class Artists {

  private int id;
  private String nom;
  private String info;

  public Artists(int id, String nom, String info) {
    this.id = id;
    this.nom = nom;
    this.info = info;
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getInfo() {
    return info;
  }
}
