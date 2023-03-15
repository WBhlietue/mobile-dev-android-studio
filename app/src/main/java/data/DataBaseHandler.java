package data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.MyWish;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBaseHandler extends SQLiteOpenHelper {
    private final ArrayList<MyWish> wishList = new ArrayList<>();

    public DataBaseHandler( Context context) {
        super(context, Constants.CONTENT_NAME, null, Constants.DATABASE_VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Wish_Table = "CREATE TABLE " + Constants.TABLE_NAME+" ( "+Constants.KEY_ID+" INTEGER PRIMARY KEY, " + Constants.TITLE_NAME + " TEXT, " + Constants.CONTENT_NAME + " TEXT,  " + Constants.DATA_NAME + " LONG);";
        sqLiteDatabase.execSQL(Create_Wish_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void DeleteWish(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.KEY_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void AddWish(MyWish wish){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(Constants.TITLE_NAME, wish.getTitle());
        val.put(Constants.CONTENT_NAME, wish.getContent());
        val.put(Constants.DATA_NAME, System.currentTimeMillis());
        db.insert(Constants.TABLE_NAME, null, val);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<MyWish> getWishes(){
        String selectQuery = "SELECT * FROM" + Constants.TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cur = db.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID, Constants.TITLE_NAME, Constants.CONTENT_NAME, Constants.DATA_NAME}, null, null, null, null, Constants.DATA_NAME + " DESC");
        if(cur.moveToFirst()){
            do{
                MyWish wish = new MyWish();
                wish.setTitle(cur.getString(cur.getColumnIndex(Constants.TITLE_NAME)));
                wish.setContent(cur.getString(cur.getColumnIndex(Constants.CONTENT_NAME)));
                wish.setID(cur.getInt(cur.getColumnIndex(Constants.KEY_ID)));
                DateFormat dateFormat = DateFormat.getDateInstance();
                String dateData = dateFormat.format(new Date(cur.getLong(cur.getColumnIndex(Constants.DATA_NAME))).getTime());
                wish.setDate(dateData);
                wishList.add(wish);
            }while(cur.moveToNext());
        }
        cur.close();
        db.close();
        return wishList;
    }

}
