package besnard.mickael.bibenpoche.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import besnard.mickael.bibenpoche.bo.Manga;
import besnard.mickael.bibenpoche.contract.MangaContract;
import besnard.mickael.bibenpoche.dbhelper.GestionBDDHelper;

import static besnard.mickael.bibenpoche.contract.MangaContract.TABLE_NAME;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_VOLUME;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_EDITION;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_AUTEUR;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_ID;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_TITRE;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_ANNEE;
import static besnard.mickael.bibenpoche.contract.MangaContract.COL_CATEGORIE;


public class MangaDao {
    //--------------------------------
    // Connexion BDD
    //--------------------------------
    //Représente la connexion.
    private SQLiteDatabase db;
    private GestionBDDHelper helper;
    public MangaDao(Context context) {
        helper = new GestionBDDHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------
    // INSERT ( R.I. P 225 )
    //--------------------------------
    public long insertManga(Manga manga){
        Log.v("InsertMangaActivity", "insertBDDManga :" + manga.toString());
        ContentValues values = new ContentValues();
        //values.put(COL_ID.trim(), cd.getId());
      values.put(COL_ANNEE, String.valueOf(manga.getAnnee()));
      values.put(COL_VOLUME, String.valueOf(manga.getVolume()));
      values.put(COL_CATEGORIE, manga.getCategorie());
      values.put(COL_EDITION, manga.getEdition());
      values.put(COL_AUTEUR, manga.getAuteur());
      values.put(COL_TITRE, manga.getTitre());

        return db.insert(TABLE_NAME.trim(),null,values);
    }

    //--------------------------------
    // UPDATE ( R.I. P 225 )
    //--------------------------------
    public int updateManga (int id, Manga  manga ){
        ContentValues content = new ContentValues();
        content.put(COL_ANNEE, String.valueOf(manga.getAnnee()));
        content.put(COL_VOLUME, String.valueOf(manga.getVolume()));
        content.put(COL_CATEGORIE, manga.getCategorie());
        content.put(COL_EDITION, manga.getEdition());
        content.put(COL_AUTEUR, manga.getAuteur());
        content.put(COL_TITRE, manga.getTitre());

        return db.update(TABLE_NAME, content, COL_ID + " = "
                + id, null);
    }

    //--------------------------------
    // DELETE ( R.I. P 225 )
    //--------------------------------
    public int removeManga (String nom){
        return db.delete(TABLE_NAME, COL_TITRE + " = " +
                nom, null);
    }

    //--------------------------------
    // SELECT ALL ( R.I. P 225 )
    //--------------------------------
    public Cursor selectAllManga(){

        String[] listeColumn = new String[]{

                COL_ID,
                COL_AUTEUR,
                COL_ANNEE,
                COL_TITRE,
                COL_CATEGORIE,
                COL_TITRE,
                COL_EDITION
        };
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME+";",null);
    }
    /**
     * Cette methode recherche toutes les ruches et renvoie une liste de ruches
     *
     * @return list
     */
    public List<Manga> getAllManga() {
        // array of columns to fetch
        String[] columns = {
       MangaContract.COL_EDITION,
                MangaContract.COL_ANNEE,
                MangaContract.COL_AUTEUR,
                MangaContract.COL_VOLUME,
                MangaContract.COL_CATEGORIE,
                MangaContract.COL_TITRE,
        };
        // sorting orders
        String sortOrder =
                COL_TITRE+ " ASC";
        List<Manga> mangaList = new ArrayList<Manga>();



        // query the ruche table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(MangaContract.TABLE_NAME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
      /*  if (cursor.moveToFirst()) {
            do {
                Cd cd = new Cd();
                cd.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(CdContract.COL_ID))));
                cd.setArtiste(cursor.getString(cursor.getColumnIndex(CdContract.COL_ARTISTE)));
                cd.setAnnee(Integer.parseInt(String.valueOf(cursor.getColumnIndex(CdContract.COL_ANNEE))));
                cd.setTitre(cursor.getString(cursor.getColumnIndex(CdContract.COL_TITRE)));
                cd.getGenre(cursor.getString(cursor.getColumnIndex(CdContract.COL_GENRE)));
                // Adding user record to list
                cdList.add(cd);
            } while (cursor.moveToNext());
        }
        cursor.close();*/
        //db.close();

        // return liste de dvd
        return mangaList;
    }
}
