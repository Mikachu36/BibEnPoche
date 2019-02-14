package besnard.mickael.bibenpoche.bo;

public class Jeu_video {
private int id;
private String titre;
private String support;
private String annee;
private String genre;

    // constructeur

    public Jeu_video(int id, String titre, String support, String annee, String genre) {
        this.id = id;
        this.titre = titre;
        this.support = support;
        this.annee = annee;
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

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
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
        return "Jeu_video{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", support='" + support + '\'' +
                ", annee='" + annee + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
