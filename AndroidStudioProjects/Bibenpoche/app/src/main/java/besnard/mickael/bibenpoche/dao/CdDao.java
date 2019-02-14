package besnard.mickael.bibenpoche.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import besnard.mickael.bibenpoche.bo.Cd;
import besnard.mickael.bibenpoche.contract.CdContract;
import besnard.mickael.bibenpoche.dbhelper.GestionBDDHelper;

import static besnard.mickael.bibenpoche.contract.CdContract.COL_ANNEE;
import static besnard.mickael.bibenpoche.contract.CdContract.COL_ARTISTE;
import static besnard.mickael.bibenpoche.contract.CdContract.COL_GENRE;
import static besnard.mickael.bibenpoche.contract.CdContract.COL_ID;
import static besnard.mickael.bibenpoche.contract.CdContract.COL_TITRE;
import static besnard.mickael.bibenpoche.contract.CdContract.TABLE_NAME;


public class CdDao {
    //--------------------------------
    // Connexion BDD
    //--------------------------------
    //Représente la connexion.
    private SQLiteDatabase db;
    private GestionBDDHelper helper;
    public CdDao(Context context) {
        helper = new GestionBDDHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------
    // INSERT ( R.I. P 225 )
    //--------------------------------
    public long insertCD(Cd cd){
        Log.v("InsertCdActivity", "insertBDDCd :" + cd.toString());
        ContentValues values = new ContentValues();
        //values.put(COL_ID.trim(), cd.getId());
        values.put(COL_ARTISTE, cd.getArtiste());
        values.put(COL_ANNEE,String.valueOf(cd.getAnnee()));
        values.put(COL_TITRE, cd.getTitre());
        values.put(COL_GENRE, cd.getGenre());

        return db.insert(TABLE_NAME.trim(),null,values);
    }

    //--------------------------------
    // UPDATE ( R.I. P 225 )
    //--------------------------------
    public int updateCd (int id, Cd cd ){
        ContentValues content = new ContentValues();
        content.put(COL_ARTISTE, cd.getArtiste());
        content.put(COL_ANNEE, cd.getAnnee());
        content.put(COL_TITRE, cd.getTitre());
        content.put(COL_GENRE, cd.getGenre());

        return db.update(TABLE_NAME, content, COL_ID + " = "
                + id, null);
    }

    //--------------------------------
    // DELETE ( R.I. P 225 )
    //--------------------------------
    public int removeCd (String nom){
        return db.delete(TABLE_NAME, COL_TITRE + " = " +
                nom, null);
    }

    //--------------------------------
    // SELECT ALL ( R.I. P 225 )
    //--------------------------------
    public Cursor selectAllCd(){

        String[] listeColumn = new String[]{

                COL_ID,
                COL_ARTISTE,
                COL_ANNEE,
                COL_TITRE,
                COL_GENRE
        };
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME+";",null);
    }
    /**
     * Cette methode recherche toutes les ruches et renvoie une liste de ruches
     *
     * @return list
     */
    public List<Cd> getAllCd() {
        // array of columns to fetch
        String[] columns = {
                CdContract.COL_ID,
               CdContract.COL_TITRE,
                CdContract.COL_ANNEE,
                CdContract.COL_TITRE,
                CdContract.COL_GENRE
        };
        // sorting orders
        String sortOrder =
                COL_ARTISTE + " ASC";
        List<Cd> cdList = new ArrayList<Cd>();



        // query the ruche table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(CdContract.TABLE_NAME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
     /*   if (cursor.moveToFirst()) {
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

        // return liste de cd
        return cdList;
    }
}
