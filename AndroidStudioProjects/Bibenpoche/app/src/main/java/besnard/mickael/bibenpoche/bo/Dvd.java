package besnard.mickael.bibenpoche.bo;

public class Dvd {
    private int id;
    private String titre;
    private String acteur;
    private String realisateur;
    private String genre;
    private int annee;

// constructeur
    public Dvd(int id, String titre, String acteur, String realisateur, String genre, int annee) {
        this.id = id;
        this.titre = titre;
        this.acteur = acteur;
        this.realisateur = realisateur;
        this.genre = genre;
        this.annee = annee;
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

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // methode to string
    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", acteur='" + acteur + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", genre='" + genre + '\'' +
                ", annee=" + annee +
                '}';
    }
}
