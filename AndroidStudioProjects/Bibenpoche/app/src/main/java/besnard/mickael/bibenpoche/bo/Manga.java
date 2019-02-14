package besnard.mickael.bibenpoche.bo;

public class Manga {
    private int id;
    private String titre;
    private int volume;
    private String auteur;
    private int annee;
    private String edition;
    private String categorie;

    // constructeur

    public Manga(int id, String titre, int volume, String auteur, int annee, String edition, String categorie) {
        this.id = id;
        this.titre = titre;
        this.volume = volume;
        this.auteur = auteur;
        this.annee = annee;
        this.edition = edition;
        this.categorie = categorie;
    }


    // getter et setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    // methode to string


    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", volume=" + volume +
                ", auteur='" + auteur + '\'' +
                ", annee=" + annee +
                ", edition='" + edition + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}


