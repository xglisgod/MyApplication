package cn.edu.bistu.cs.se.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.widget.Toast;

public class DBServer {
    private static SQLiteDatabase db;

    private static Context context=null;
    public DBServer(SQLiteDatabase db,Context context){
        this.db=db;
        this.context=context;
    }
    //数据库的打开或创建
    public static void create_db() {
        //创建或打开数据库
        db = SQLiteDatabase.openOrCreateDatabase("/data/data/cn.edu.bistu.cs.se.myapplication/databases/mynotes.db", null);

        if (db == null) {
            Toast.makeText(context, "数据库创建不成功", Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(context,"数据库创建成功",Toast.LENGTH_LONG).show();
        //创建表
        db.execSQL("create table if not exists notes(_id integer primary key autoincrement," +
                "title text," +
                "context text," +
                "time varchar(20))");

    }

    public static SQLiteDatabase getSQLiteDatabase(){
        return db;
    }

    //查询全部信息
    public static Cursor selectAll(){
        return db.rawQuery(" select * from notes ",null);
    }
    //根据ID查询信息
    public static Cursor selectNotesById(Integer id){
        return db.rawQuery(" select * from notes where _id=? ",new String[]{id.toString()});
    }
    //根据ID删除信息
    public static void deleteNotesById(Integer id){
        if(id==null) return;
        db.delete(" notes ","_id=?" ,new String[]{id.toString()});
    }
    //根据ID更新信息
    public static void updateNotesById(Integer id, ContentValues values){
        db.update(" notes ",values,"_id=? ",new String[]{id.toString()});
    }
    //添加事件
    public static void addNotes(ContentValues values){
        values.put("createTime", DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()).toString());
        db.insert("notes",null,values);
    }


}


