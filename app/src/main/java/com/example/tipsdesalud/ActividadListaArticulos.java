package com.example.tipsdesalud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tipsdesalud.modelo.ModeloArticulos;

public class ActividadListaArticulos extends AppCompatActivity implements FragmentoListaArticulos.EscuchaFragmento{

    private boolean dosPaneles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_articulos);

        ((Toolbar) findViewById(R.id.toolbar)).setTitle(getTitle());

        if (findViewById(R.id.contenedor_detalle_articulo) != null){

            dosPaneles = true;

            cargarFragmentoDetalle(ModeloArticulos.ITEMS.get(0).id);
        }



        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_lista, FragmentoListaArticulos.crear()).commit();

    }

    private void cargarFragmentoDetalle(String id){
        Bundle arguments = new Bundle();

        arguments.putString(FragmentoDetalleArticulo.ID_ARTICULO, id);
        FragmentoDetalleArticulo fragment = new FragmentoDetalleArticulo();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_detalle_articulo, fragment).commit();
    }


    @Override
    public void alSeleccionarItem(String idArticulo){

        if (dosPaneles){
            cargarFragmentoDetalle(idArticulo);
        }else {
            Intent intent = new Intent(this, ActividadDetalleArticulo.class);
            intent.putExtra(FragmentoDetalleArticulo.ID_ARTICULO, idArticulo);

        startActivity(intent);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

