package com.example.tipsdesalud;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.tipsdesalud.modelo.ModeloArticulos;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoListaArticulos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoListaArticulos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoListaArticulos extends Fragment implements AdaptadorArticulos.OnItemClickListener {


    private EscuchaFragmento  escucha;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentoListaArticulos() {
    }


    public static FragmentoListaArticulos crear(){
        return new FragmentoListaArticulos();
    }


    public static FragmentoListaArticulos newInstance(String param1, String param2) {
        FragmentoListaArticulos fragment = new FragmentoListaArticulos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_lista_articulos, container, false);

        View recyclerView = v.findViewById(R.id.reciclador);

    assert recyclerView != null;

    prepararLista((RecyclerView) recyclerView);
    return v;
    }

    private void prepararLista(@NonNull RecyclerView recyclerView){
        recyclerView.setAdapter(new AdaptadorArticulos(ModeloArticulos.ITEMS, this));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EscuchaFragmento) {
            escucha = (EscuchaFragmento) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debes implementar EscuchaFragmento");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        escucha = null;
    }

    @Override
    public void onClick(AdaptadorArticulos.ViewHolder viewHolder, String idArticulo){

    }



    public interface OnFragmentInteractionListener {
        void alSeleccionarItem(String idArticulo);
    }
}
