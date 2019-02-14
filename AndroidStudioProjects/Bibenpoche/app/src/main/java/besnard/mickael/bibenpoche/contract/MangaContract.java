package besnard.mickael.bibenpoche.contract;

public abstract class MangaContract {
    public static final String TABLE_NAME = " MANGA ";
    //--------------------------------
    // Nom des colonnes
    //--------------------------------
    public static final  String COL_ID = " ID ";
    public static final  String COL_TITRE = " TITRE ";
    public static final  String COL_VOLUME = " VOLUME ";
    public static final  String COL_AUTEUR = " AUTEUR ";
    public static final  String COL_ANNEE = " ANNEE ";
    public static final  String COL_EDITION = " EDITION ";
    public static final  String COL_CATEGORIE = " CATEGORIE ";

    //--------------------------------
    // Requêtes création  table MANGA
    //--------------------------------
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_TITRE
                    + " TEXT , "
                    + COL_VOLUME
                    + " INTEGER , "
                    + COL_AUTEUR
                    + " TEXT , "
                    + COL_ANNEE
                    + " INTEGER , "
                    + COL_EDITION
                    + " TEXT , "
                    + COL_CATEGORIE
                    + " TEXT ) ";

    //--------------------------------
    // Requêtes suppression  table MANGA
    //--------------------------------
    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;
}
