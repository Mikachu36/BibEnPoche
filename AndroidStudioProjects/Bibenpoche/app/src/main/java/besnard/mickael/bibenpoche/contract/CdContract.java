package besnard.mickael.bibenpoche.contract;

public abstract class CdContract {
    public static final String TABLE_NAME = " CD ";
    //--------------------------------
    // Nom des colonnes
    //--------------------------------
    public static final  String COL_ID = " ID ";
    public static final  String COL_ARTISTE = " ARTISTE ";
    public static final  String COL_TITRE = " TITRE ";
    public static final  String COL_ANNEE = " ANNEE ";
    public static final  String COL_GENRE = " GENRE ";


    //--------------------------------
    // Requêtes création  table CD
    //--------------------------------
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_ARTISTE
                    + " TEXT , "
                    + COL_TITRE
                    + " TEXT , "
                    + COL_ANNEE
                    + " INTEGER , "
                    + COL_GENRE
                    + " TEXT ) ";

    //--------------------------------
    // Requêtes suppression  table CD
    //--------------------------------
    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;
}
