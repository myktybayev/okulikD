package kz.informatics.okulik.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoreDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "okulik.db";
    private static final int DATABASE_VERSION = 4;

    public static final String TABLE_STUDENTS = "students";

    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_SURNAME= "surname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CLASS = "sClass";

    public static final String TABLE_SLOGINS = "loginStudents";
    public static final String COLUMN_LOGIN = "login";

    public static final String TABLE_GAMES = "games";
    public static final String COLUMN_GAME_NUMBER = "game_number";
    public static final String COLUMN_UPAI = "upai";


    Context context;

    public StoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_STUDENTS + "(" +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT , " +
                COLUMN_PASSWORD + " TEXT , " +
                COLUMN_CLASS + " TEXT )");

        db.execSQL("CREATE TABLE " + TABLE_SLOGINS + "(" +
                COLUMN_EMAIL + " TEXT , " +
                COLUMN_LOGIN + " TEXT )");

        db.execSQL("CREATE TABLE " + TABLE_GAMES + "(" +
                COLUMN_EMAIL + " TEXT , " +
                COLUMN_GAME_NUMBER + " TEXT , " +
                COLUMN_UPAI + " TEXT )");


        ContentValues userValue = new ContentValues();
        userValue.put(COLUMN_LOGIN, "no");

        db.insert(TABLE_SLOGINS, null, userValue);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SLOGINS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);

        onCreate(db);
    }

}