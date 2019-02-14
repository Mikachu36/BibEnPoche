package besnard.mickael.bibenpoche.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Cd {
    private int id;
    private String artiste;
    private String titre;
    private int annee;
    private String genre;

    // constructeur

    public Cd(int id, String artiste, String titre, int annee, String genre) {
        this.id = id;
        this.artiste = artiste;
        this.titre = titre;
        this.annee = annee;
        this.genre = genre;
    }

    protected Cd (Parcel in){
        this.id = in.readInt();
        this.artiste = in.readString();
        this.titre = in.readString();
        this.annee = in.readInt();
        this.genre = in.readString();
    }

    // overide
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(artiste);
        dest.writeString(titre);
        dest.writeInt(annee);
        dest.writeString(genre);

    }

    //overide
    public int describeContents() {return 0;}

    public static final Parcelable.Creator<Cd> CREATOR = new Parcelable.Creator<Cd>() {
        @Override
        public Cd createFromParcel(Parcel in) { return new Cd(in); }

        @Override
        public Cd[] newArray(int size) { return new Cd[size]; }
    };
    // getter et setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
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
        return "Cd{" +
                "id=" + id +
                ", artiste='" + artiste + '\'' +
                ", titre='" + titre + '\'' +
                ", annee='" + annee + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
