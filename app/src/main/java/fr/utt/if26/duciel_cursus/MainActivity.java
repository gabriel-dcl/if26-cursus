package fr.utt.if26.duciel_cursus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fr.utt.if26.duciel_cursus.controllers.BdControllers.BDModuleAddActivity;
import fr.utt.if26.duciel_cursus.controllers.BdControllers.BDModuleListActivity;
import fr.utt.if26.duciel_cursus.controllers.BdControllers.BdModuleDelActivity;
import fr.utt.if26.duciel_cursus.controllers.ModuleListActivity;
import fr.utt.if26.duciel_cursus.controllers.ModuleRecyclerActivity;
import fr.utt.if26.duciel_cursus.controllers.RoomModuleListActivity;
import fr.utt.if26.duciel_cursus.controllers.SigleListActivity;

public class MainActivity extends AppCompatActivity {
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplicationContext().deleteDatabase("word_database");

        setContentView(R.layout.activity_main);

        TextView mainTv = findViewById(R.id.main_tv);
        mainTv.setText("Modules du programme ISI");
        mainTv.setTextSize(30);
        mainTv.setBackgroundColor(Color.BLUE);

        this.registerForContextMenu(mainTv);

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Context Menu");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_option_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return this.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.main_menu_sigle_list:
                sigleList();
                return true;
            case R.id.main_menu_sigle_add:
                sigleAdd();
                return true;
            case R.id.main_menu_sigle_del:
                sigleDel();
                return true;
            case R.id.main_menu_module_list:
                moduleList();
                return true;
            case R.id.main_menu_module_recycler_list:
                moduleRecyclerList();
                return true;
            case R.id.main_menu_module_add:
                moduleAdd();
                return true;
            case R.id.main_menu_module_del:
                moduleDel();
                return true;
            case R.id.main_menu_module_room_list:
                moduleRoomList();
                return true;
            case R.id.main_menu_module_room_add:
                moduleRoomAdd();
                return true;
            case R.id.main_menu_module_room_del:
                moduleRoomDel();
                return true;
            case R.id.main_menu_module_sql_list:
                moduleSqlList();
                return true;
            case R.id.main_menu_module_sql_add:
                moduleSqlAdd();
                return true;
            case R.id.main_menu_module_sql_del:
                moduleSqlDel();
                return true;
            default:
                return false;
        }
    }

    private void moduleRoomList() {
        Intent intent = new Intent().setClass(this, RoomModuleListActivity.class);
        startActivity(intent);
    }

    private void moduleRoomAdd() {
        Toast.makeText(this, "Je veux ajouter une liste room", Toast.LENGTH_LONG).show();
    }

    private void moduleRoomDel() {
        Toast.makeText(this, "Je veux suppriemr une liste room", Toast.LENGTH_LONG).show();
    }

    private void moduleSqlList() {
        Intent intent = new Intent().setClass(this, BDModuleListActivity.class);
        startActivity(intent);
    }

    private void moduleSqlAdd() {
        Intent intent = new Intent().setClass(this, BDModuleAddActivity.class);
        startActivity(intent);
    }

    private void moduleSqlDel() {
        Intent intent = new Intent().setClass(this, BdModuleDelActivity.class);
        startActivity(intent);
    }

    private void sigleList() {
        Intent intent = new Intent().setClass(this, SigleListActivity.class);
        startActivity(intent);
    }

    private void sigleAdd() {
        Toast.makeText(this, "Je veux ajouter un sigle", Toast.LENGTH_LONG).show();
    }

    private void sigleDel() {
        Toast.makeText(this, "Je veux enlever un sigle", Toast.LENGTH_LONG).show();
    }

    private void moduleList() {
        Intent intent = new Intent().setClass(this, ModuleListActivity.class);
        startActivity(intent);
    }

    private void moduleRecyclerList() {
        Intent intent = new Intent().setClass(this, ModuleRecyclerActivity.class);
        startActivity(intent);
    }


    private void moduleAdd() {
        Toast.makeText(this, "Je veux ajouter un module", Toast.LENGTH_LONG).show();
    }

    private void moduleDel() {
        Toast.makeText(this, "Je veux enlever un module", Toast.LENGTH_LONG).show();
    }
}