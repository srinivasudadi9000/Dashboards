package schemax.brandix_charts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

/**
 * Created by srinivas on 03/01/18.
 */

public class DBHelper {
    static SQLiteDatabase db;
    Context context;

    public DBHelper(List<Normal> normals, Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("BRANDIX", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS normal(normal_id VARCHAR unique,normal_percentage VARCHAR);");
        String size = String.valueOf(normals.size());
        // Toast.makeText(context.getApplicationContext(), size, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < normals.size(); i++) {
            if (validaterecord(normals.get(i).getId()).equals("notvalidate")) {
                //  Log.d("projects",projects.get(i).getProject_id().toString());
                insertProject(normals.get(i).getId(), normals.get(i).getPercentage());
            } else {
                //  Log.d("projects","no ra");
            }
        }
    }
    //viewmydb();

    private void insertProject(String id, String percentage) {
        db.execSQL("INSERT INTO normal VALUES('" + id + "','" + percentage + "');");
    }

    private String validaterecord(String id) {
        Cursor c = db.rawQuery("SELECT * FROM normal WHERE normal_id='" + id + "'", null);
        if (c.moveToFirst()) {
            return "validate";
        } else {
            return "notvalidate";
        }
    }

    public void getNormal() {
        db = context.openOrCreateDatabase("BRANDIX", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM normal ", null);

        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                Log.d("hi",c.getString(c.getColumnIndex("normal_id")));
                Log.d("hi",c.getString(c.getColumnIndex("normal_percentage")));
                c.moveToNext();
            }
        }
        //finish();
    }
}
