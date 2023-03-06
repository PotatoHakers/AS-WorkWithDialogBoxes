package com.example.workingwithdialogboxes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_exit = findViewById(R.id.button_exit);

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Вы действительно хотите выйти?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                dialog.setNegativeButton("Нет", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();

            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); try {
            dialog.setMessage(getTitle().toString()+ " версия "+ getPackageManager().getPackageInfo(getPackageName(),0).versionName +
                    "\r\n\nПрограмма с примером выполнения диалогового окна\r\n\n Автор - Гержа Александр Геннадьевич, гр. 20ИТ-1");
        } catch (PackageManager.NameNotFoundException e) { e.printStackTrace();

        }
        dialog.setTitle("О программе"); dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { dialog.dismiss();
            }
        });
        dialog.setIcon(R.mipmap.ic_launcher_round); AlertDialog alertDialog = dialog.create(); alertDialog.show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}











