package com.myapp.pam135.calculadoraar17092;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Para el editText
    EditText pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.input);

        //Esconder teclado
        pantalla.setShowSoftInputOnFocus(false);

        /**
         * Limpiar el CERO de la pantalla cuando demos click
         * */
        pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.txtvista).equals(pantalla.getText().toString())){
                    pantalla.setText("");
                }
            }
        });
    }

    //Metodo para insertar datos
    private void updateTxt(String add){
        String vieja = pantalla.getText().toString();

        //Posición del cursor
        int posCursor = pantalla.getSelectionStart();

        String izquierda= vieja.substring(0, posCursor);
        String derecha = vieja.substring(posCursor);

        //Nos va a permitir agregar más numeros
        pantalla.setText(String.format("%s%s%s",izquierda,add,derecha ));
    }

    public void btnCero(View view){
        updateTxt("0");
    }

    public void btnUno(View view){
        updateTxt("1");
    }

    public void btnDos(View view){
        updateTxt("2");
    }

    public void btnTres(View view){
        updateTxt("3");
    }

    public void btnCuatro(View view){
        updateTxt("4");
    }

    public void btnCinco(View view){
        updateTxt("5");
    }

    public void btnSeis(View view){
        updateTxt("6");
    }

    public void btnSiete(View view){
        updateTxt("7");
    }

    public void btnOcho(View view){
        updateTxt("8");
    }

    public void btnNueve(View view){
        updateTxt("9");
    }

    public void btnClear(View view){
        updateTxt("");
    }

    public void btnMultiplicacion(View view){
        updateTxt("x");
    }

    public void btnDivision(View view){
        updateTxt("÷");
    }

    public void btnsuma(View view){
        updateTxt("+");
    }

    public void btnResta(View view){
        updateTxt("-");
    }

    public void btnExp(View view){
        updateTxt("^");
    }

    public void btnParentisis(View view){
        
    }

    public void btnMasMenos(View view){

    }

    public void btnPunto(View view){
        updateTxt(".");
    }

    public void btnIgual(View view){
    }

    public void btnBorrar(View view){

    }
}