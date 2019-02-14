package besnard.mickael.bibenpoche.contract;

public abstract class DvdContract {
    public static final String TABLE_NAME = " DVD ";
    //--------------------------------
    // Nom des colonnes
    //--------------------------------
    public static final  String COL_ID = " ID ";
    public static final  String COL_TITRE = " TITRE ";
    public static final  String COL_ACTEUR = " ACTEUR ";
    public static final  String COL_REALISATEUR = " REALISATEUR ";
    public static final  String COL_GENRE = " GENRE ";
    public static final  String COL_ANNEE = " ANNEE ";


    //--------------------------------
    // Requêtes création  table DVD
    //--------------------------------
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_TITRE
                    + " TEXT , "
                    + COL_ACTEUR
                    + " TEXT , "
                    + COL_REALISATEUR
                    + " TEXT , "
                    + COL_GENRE
                    + " TEXT , "
                    + COL_ANNEE
                    + " INT ) ";

    //--------------------------------
    // Requêtes suppression  table DVD
    //--------------------------------
    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;
}
