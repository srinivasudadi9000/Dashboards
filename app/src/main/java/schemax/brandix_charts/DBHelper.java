package schemax.brandix_charts;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srinivas on 03/01/18.
 */

public class DBHelper {
    static SQLiteDatabase db;
    Context context;

    public DBHelper(Context context) {
        this.context = context;
    }

    public DBHelper(List<Normal> normals, Context context) {
        this.context = context;

        db = context.openOrCreateDatabase("BRANDIX", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS normal(normal_id VARCHAR unique,normal_percentage VARCHAR);");
         String size = String.valueOf(normals.size());
        //Toast.makeText(context.getApplicationContext(), size, Toast.LENGTH_SHORT).show();
        Log.d("size of list",size);
        for (int i = 0; i < normals.size(); i++) {
            Log.d("ok"+i,normals.get(i).getPercentage().toString());
            if (validaterecord(normals.get(i).getId()).equals("notvalidate")) {
                  Log.d("looplo",normals.get(i).getPercentage().toString());
                insertProject(normals.get(i).getId(), normals.get(i).getPercentage());
            } else {
                //  Log.d("projects","no ra");
                updateNormal_Localdb(normals.get(i).getId().toString(),normals.get(i).getPercentage(),context);
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

    public ArrayList<BarEntry> getNormal(Context context) {

        db = context.openOrCreateDatabase("BRANDIX", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM normal ", null);
        int x =0;
        ArrayList<BarEntry> barEntries = new ArrayList<>();
         Log.d("count", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                      Log.d("hoooo", c.getString(c.getColumnIndex("normal_id")));
                    Log.d("hoooo", c.getString(c.getColumnIndex("normal_percentage")));
                    Integer X = x;
                    Integer Y = Integer.valueOf(c.getString(c.getColumnIndex("normal_percentage")));

                    barEntries.add(new BarEntry(X, Y));
                    x = x+15;
                    c.moveToNext();
             }
        }
        return barEntries;
        //finish();
    }

    public static void updateNormal_Localdb(String normal_id, String normal_percentage, Context mycontext) {

        db = mycontext.openOrCreateDatabase("BRANDIX", Context.MODE_PRIVATE, null);

        db.execSQL("UPDATE normal SET normal_percentage='" + normal_percentage+"'"+
                " WHERE normal_id=" + normal_id);



       // db.close();
        Log.d("success", "successfully updated recce");
    }

}
