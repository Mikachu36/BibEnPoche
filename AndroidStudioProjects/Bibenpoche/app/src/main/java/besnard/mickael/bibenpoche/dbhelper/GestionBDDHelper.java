package besnard.mickael.bibenpoche.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import besnard.mickael.bibenpoche.contract.CdContract;
import besnard.mickael.bibenpoche.contract.DvdContract;
import besnard.mickael.bibenpoche.contract.JeuvideoContract;
import besnard.mickael.bibenpoche.contract.LivreContract;
import besnard.mickael.bibenpoche.contract.MangaContract;

public class GestionBDDHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "bibenpoche.db";
    private final static int DATABASE_VERSION = 1;
    public GestionBDDHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CdContract.SQL_CREATE_TABLE);
        db.execSQL(DvdContract.SQL_CREATE_TABLE);
        db.execSQL(JeuvideoContract.SQL_CREATE_TABLE);
        db.execSQL(LivreContract.SQL_CREATE_TABLE);
        db.execSQL(MangaContract.SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CdContract.SQL_DROP_TABLE);
        db.execSQL(DvdContract.SQL_DROP_TABLE);
        db.execSQL(JeuvideoContract.SQL_DROP_TABLE);
        db.execSQL(LivreContract.SQL_DROP_TABLE);
        db.execSQL(MangaContract.SQL_DROP_TABLE);
    }
}
