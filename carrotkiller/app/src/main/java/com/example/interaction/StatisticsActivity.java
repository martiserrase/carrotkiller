package com.example.interaction;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class StatisticsActivity extends AppCompatActivity {

    //    Button shareSS;
    ImageView ima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        verifyStoragePermission(this);
       // ima = findViewById(R.id.); //posar la foto de captura de pantalla


        Button backGame_button = findViewById(R.id.go_to_game_button);

        backGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, StartedGameActivity.class);
                startActivity(intent);

            }
        });

//        shareSS = findViewById(R.id.share);
//        shareSS.setOnClickListener(view -> {
//            File file = SaveFile();
//            if(file!=null)
//                share(file);
//        });
    }

    // Toolbar menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share:
                Toast.makeText(this, "THANKS FOR SHARING!", Toast.LENGTH_SHORT).show();
                takeScreenShot(getWindow().getDecorView().getRootView(), "screenshot_result");
                return true;

            case R.id.quit_game:
                Toast.makeText(this, "GOODBYE!", Toast.LENGTH_SHORT).show();
                image();
                return true;
            case R.id.log_out:
                Toast.makeText(this, "CONFIRM LOG OUT!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.confirm_log_out:
                Toast.makeText(this, "LOGGED OUT", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public Bitmap screenShot(View view) {
//        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
//                view.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        view.draw(canvas);
//        return bitmap;
//    }

    // Take Screenshot
    protected static File takeScreenShot(View view, String fileName) {

        Date date = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);

        try {
            String dirPath = Environment.getExternalStorageDirectory().toString() + "/carrot-killer";
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                boolean mkdir = fileDir.mkdirs();
            }
            String path = dirPath + "/" + fileName + "-" + format + ".jpeg";

            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);

            File imageFile = new File(path);

            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return imageFile;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSION_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermission(Activity activity) {

        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    PERMISSION_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

    // Share screenshot
    private void image() {

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        BitmapDrawable drawable = (BitmapDrawable) ima.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        File f = new File(getExternalCacheDir() + "/" + getResources().getString(R.string.app_name) + ".png");
        Intent shareint;

        try {
            FileOutputStream outputStream = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.flush();
            outputStream.close();
            shareint = new Intent(Intent.ACTION_SEND);
            shareint.setType("image/*");
            shareint.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
            shareint.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        startActivity(Intent.createChooser(shareint, "share image"));

    }
}
