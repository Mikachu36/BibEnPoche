package besnard.mickael.bibenpoche.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import besnard.mickael.bibenpoche.bo.Dvd;
import besnard.mickael.bibenpoche.bo.Jeu_video;
import besnard.mickael.bibenpoche.contract.DvdContract;
import besnard.mickael.bibenpoche.contract.JeuvideoContract;
import besnard.mickael.bibenpoche.dbhelper.GestionBDDHelper;

import static besnard.mickael.bibenpoche.contract.JeuvideoContract.TABLE_NAME;
import static besnard.mickael.bibenpoche.contract.JeuvideoContract.COL_GENRE;
import static besnard.mickael.bibenpoche.contract.JeuvideoContract.COL_ID;
import static besnard.mickael.bibenpoche.contract.JeuvideoContract.COL_TITRE;
import static besnard.mickael.bibenpoche.contract.JeuvideoContract.COL_ANNEE;
import static besnard.mickael.bibenpoche.contract.JeuvideoContract.COL_SUPPORT;


public class JeuvideoDao {
    //--------------------------------
    // Connexion BDD
    //--------------------------------
    //Représente la connexion.
    private SQLiteDatabase db;
    private GestionBDDHelper helper;
    public JeuvideoDao(Context context) {
        helper = new GestionBDDHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------
    // INSERT ( R.I. P 225 )
    //--------------------------------
    public long insertDVD(Jeu_video jeu_video){
        Log.v("InsertJeuVideoActivity", "insertBDDJeuxVideo :" + jeu_video.toString());
        ContentValues values = new ContentValues();
        //values.put(COL_ID.trim(), cd.getId());
        values.put(COL_SUPPORT, jeu_video.getSupport());
        values.put(COL_ANNEE,String.valueOf(jeu_video.getAnnee()));
        values.put(COL_TITRE, jeu_video.getTitre());
        values.put(COL_GENRE, jeu_video.getGenre());


        return db.insert(TABLE_NAME.trim(),null,values);
    }

    //--------------------------------
    // UPDATE ( R.I. P 225 )
    //--------------------------------
    public int updateJeuxVideo (int id, Jeu_video jeu_video ){
        ContentValues content = new ContentValues();
        content.put(COL_SUPPORT, jeu_video.getSupport());
        content.put(COL_ANNEE,String.valueOf(jeu_video.getAnnee()));
        content.put(COL_TITRE, jeu_video.getTitre());
        content.put(COL_GENRE, jeu_video.getGenre());


        return db.update(TABLE_NAME, content, COL_ID + " = "
                + id, null);
    }

    //--------------------------------
    // DELETE ( R.I. P 225 )
    //--------------------------------
    public int removeJeuxVideo (String nom){
        return db.delete(TABLE_NAME, COL_TITRE + " = " +
                nom, null);
    }

    //--------------------------------
    // SELECT ALL ( R.I. P 225 )
    //--------------------------------
    public Cursor selectAllJeuxVideo(){

        String[] listeColumn = new String[]{

                COL_ID,
                COL_SUPPORT,
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
    public List<Jeu_video> getAllJeuxVideo() {
        // array of columns to fetch
        String[] columns = {
                JeuvideoContract.COL_ID,
                JeuvideoContract.COL_TITRE,
                JeuvideoContract.COL_ANNEE,
                JeuvideoContract.COL_TITRE,
                JeuvideoContract.COL_SUPPORT,
                JeuvideoContract.COL_GENRE
        };
        // sorting orders
        String sortOrder =
                COL_TITRE+ " ASC";
        List<Jeu_video> jeuxList = new ArrayList<Jeu_video>();



        // query the ruche table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(JeuvideoContract.TABLE_NAME, //Table to query
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
        return jeuxList;
    }
}
