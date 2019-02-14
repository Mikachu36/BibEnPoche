package besnard.mickael.bibenpoche.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import besnard.mickael.bibenpoche.bo.Dvd;
import besnard.mickael.bibenpoche.contract.DvdContract;
import besnard.mickael.bibenpoche.dbhelper.GestionBDDHelper;

import static besnard.mickael.bibenpoche.contract.DvdContract.COL_ANNEE;
import static besnard.mickael.bibenpoche.contract.DvdContract.COL_TITRE;
import static besnard.mickael.bibenpoche.contract.DvdContract.COL_ID;
import static besnard.mickael.bibenpoche.contract.DvdContract.COL_GENRE;
import static besnard.mickael.bibenpoche.contract.DvdContract.COL_ACTEUR;
import static besnard.mickael.bibenpoche.contract.DvdContract.COL_REALISATEUR;
import static besnard.mickael.bibenpoche.contract.DvdContract.TABLE_NAME;

public class DvdDao {
    //--------------------------------
    // Connexion BDD
    //--------------------------------
    //Représente la connexion.
    private SQLiteDatabase db;
    private GestionBDDHelper helper;
    public DvdDao(Context context) {
        helper = new GestionBDDHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------
    // INSERT ( R.I. P 225 )
    //--------------------------------
    public long insertDVD(Dvd dvd){
        Log.v("InsertDvdActivity", "insertBDDDvd :" + dvd.toString());
        ContentValues values = new ContentValues();
        //values.put(COL_ID.trim(), cd.getId());
        values.put(COL_ACTEUR, dvd.getActeur());
        values.put(COL_ANNEE,String.valueOf(dvd.getAnnee()));
        values.put(COL_TITRE, dvd.getTitre());
        values.put(COL_GENRE, dvd.getGenre());
        values.put(COL_REALISATEUR, dvd.getRealisateur());

        return db.insert(TABLE_NAME.trim(),null,values);
    }

    //--------------------------------
    // UPDATE ( R.I. P 225 )
    //--------------------------------
    public int updateDvd (int id, Dvd dvd ){
        ContentValues content = new ContentValues();
        content.put(COL_ACTEUR, dvd.getActeur());
        content.put(COL_ANNEE,String.valueOf(dvd.getAnnee()));
        content.put(COL_TITRE, dvd.getTitre());
        content.put(COL_GENRE, dvd.getGenre());
        content.put(COL_REALISATEUR, dvd.getRealisateur());

        return db.update(TABLE_NAME, content, COL_ID + " = "
                + id, null);
    }

    //--------------------------------
    // DELETE ( R.I. P 225 )
    //--------------------------------
    public int removeDvd (String nom){
        return db.delete(TABLE_NAME, COL_TITRE + " = " +
                nom, null);
    }

    //--------------------------------
    // SELECT ALL ( R.I. P 225 )
    //--------------------------------
    public Cursor selectAllDvd(){

        String[] listeColumn = new String[]{

                COL_ID,
                COL_ACTEUR,
                COL_ANNEE,
                COL_TITRE,
                COL_REALISATEUR,
                COL_GENRE
        };
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME+";",null);
    }
    /**
     * Cette methode recherche toutes les ruches et renvoie une liste de ruches
     *
     * @return list
     */
    public List<Dvd> getAllDvd() {
        // array of columns to fetch
        String[] columns = {
                DvdContract.COL_ID,
                DvdContract.COL_TITRE,
                DvdContract.COL_ANNEE,
                DvdContract.COL_TITRE,
                DvdContract.COL_REALISATEUR,
                DvdContract.COL_GENRE
        };
        // sorting orders
        String sortOrder =
                COL_TITRE+ " ASC";
        List<Dvd> dvdList = new ArrayList<Dvd>();



        // query the ruche table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(DvdContract.TABLE_NAME, //Table to query
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
        return dvdList;
    }
}
