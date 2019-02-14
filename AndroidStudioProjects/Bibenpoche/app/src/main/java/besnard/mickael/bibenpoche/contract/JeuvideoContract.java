package besnard.mickael.bibenpoche.contract;

public abstract class JeuvideoContract {
    public static final String TABLE_NAME = " JEUXVIDEO ";
    //--------------------------------
    // Nom des colonnes
    //--------------------------------
    public static final  String COL_ID = " ID ";
    public static final  String COL_TITRE = " TITRE ";
    public static final  String COL_SUPPORT = " SUPPORT ";
    public static final  String COL_ANNEE = " ANNEE ";
    public static final  String COL_GENRE = " GENRE ";

    //--------------------------------
    // Requêtes création  table JEUXVIDEO
    //--------------------------------
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_TITRE
                    + " TEXT , "
                    + COL_SUPPORT
                    + " TEXT , "
                    + COL_ANNEE
                    + " INTEGER , "
                    + COL_GENRE
                    + " TEXT ) ";

    //--------------------------------
    // Requêtes suppression  table JEUXVIDEO
    //--------------------------------
    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;
}
