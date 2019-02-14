package besnard.mickael.bibenpoche.bo;

public class Livre {
    private int id;
    private String titre;
    private int volume;
    private String auteur;
    private String edition;
    private String genre;

    // constructeur

    public Livre(int id, String titre, int volume, String auteur, String edition) {
        this.id = id;
        this.titre = titre;
        this.volume = volume;
        this.auteur = auteur;
        this.edition = edition;
        this.genre = genre;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


// methode to string

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", volume=" + volume +
                ", auteur='" + auteur + '\'' +
                ", edition='" + edition + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
