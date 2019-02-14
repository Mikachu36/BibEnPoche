package besnard.mickael.bibenpoche.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import besnard.mickael.bibenpoche.bo.Livre;
import besnard.mickael.bibenpoche.contract.LivreContract;
import besnard.mickael.bibenpoche.dbhelper.GestionBDDHelper;

import static besnard.mickael.bibenpoche.contract.LivreContract.COL_TITRE;
import static besnard.mickael.bibenpoche.contract.LivreContract.COL_ID;
import static besnard.mickael.bibenpoche.contract.LivreContract.COL_GENRE;
import static besnard.mickael.bibenpoche.contract.LivreContract.COL_AUTEUR;
import static besnard.mickael.bibenpoche.contract.LivreContract.COL_EDITION;
import static besnard.mickael.bibenpoche.contract.LivreContract.COL_VOLUME;
import static besnard.mickael.bibenpoche.contract.LivreContract.TABLE_NAME;

public class LivreDao {
    //--------------------------------
    // Connexion BDD
    //--------------------------------
    //Représente la connexion.
    private SQLiteDatabase db;
    private GestionBDDHelper helper;
    public LivreDao(Context context) {
        helper = new GestionBDDHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------
    // INSERT ( R.I. P 225 )
    //--------------------------------
    public long insertDVD(Livre livre){
        Log.v("InsertLivreActivity", "insertBDDLivre :" + livre.toString());
        ContentValues values = new ContentValues();
        //values.put(COL_ID.trim(), cd.getId());
        values.put(COL_AUTEUR, livre.getAuteur() );
        values.put(COL_EDITION,livre.getEdition());
        values.put(COL_TITRE, livre.getTitre());
        values.put(COL_GENRE, livre.getGenre());
        values.put(COL_VOLUME, String.valueOf(livre.getVolume()));

        return db.insert(TABLE_NAME.trim(),null,values);
    }

    //--------------------------------
    // UPDATE ( R.I. P 225 )
    //--------------------------------
    public int updateLivre (int id, Livre livre ){
        ContentValues content = new ContentValues();
        content.put(COL_AUTEUR, livre.getAuteur());
        content.put(COL_VOLUME,String.valueOf(livre.getVolume()));
        content.put(COL_TITRE, livre.getTitre());
        content.put(COL_GENRE, livre.getGenre());
        content.put(COL_EDITION, livre.getEdition());

        return db.update(TABLE_NAME, content, COL_ID + " = "
                + id, null);
    }

    //--------------------------------
    // DELETE ( R.I. P 225 )
    //--------------------------------
    public int removeLivre (String nom){
        return db.delete(TABLE_NAME, COL_TITRE + " = " +
                nom, null);
    }

    //--------------------------------
    // SELECT ALL ( R.I. P 225 )
    //--------------------------------
    public Cursor selectAllLivre(){

        String[] listeColumn = new String[]{

                COL_ID,
                COL_AUTEUR,
                COL_EDITION,
                COL_TITRE,
                COL_VOLUME,
                COL_GENRE
        };
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME+";",null);
    }
    /**
     * Cette methode recherche toutes les ruches et renvoie une liste de ruches
     *
     * @return list
     */
    public List<Livre> getAllLivre() {
        // array of columns to fetch
        String[] columns = {
                LivreContract.COL_EDITION,
                LivreContract.COL_AUTEUR,
                LivreContract.COL_VOLUME,
                LivreContract.COL_GENRE,
                LivreContract.COL_TITRE
        };
        // sorting orders
        String sortOrder =
                COL_TITRE+ " ASC";
        List<Livre> livreList = new ArrayList<Livre>();



        // query the ruche table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(LivreContract.TABLE_NAME, //Table to query
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
        return livreList;
    }
}
