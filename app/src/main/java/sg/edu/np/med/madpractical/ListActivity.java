package sg.edu.np.med.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView robot = findViewById(R.id.imageView2);
        robot.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        int numGenerated = numberGenerator();
                        Bundle extras = new Bundle();
                        extras.putInt("Number", numGenerated);
                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                        activityName.putExtras(extras);
                        startActivity(activityName);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });
    }
    public int numberGenerator(){
        Random ran = new Random();
        int myNumber = ran.nextInt();
        return myNumber;
    }
}