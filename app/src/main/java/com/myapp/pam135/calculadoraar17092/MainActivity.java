package com.myapp.pam135.calculadoraar17092;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Para el editText
    EditText pantalla;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
    private void updateTxt(String aggDato){
        String vieja = pantalla.getText().toString();

        //Posición del cursor
        int posCursor = pantalla.getSelectionStart();

        String izquierda= vieja.substring(0, posCursor);
        String derecha = vieja.substring(posCursor);

        //Nos va a permitir agregar más numeros
        if (getString(R.string.txtvista).equals(pantalla.getText().toString())){
            pantalla.setText(aggDato);
            //para mantener el cursor al lado derecho y que no se vaya al final del texto
            pantalla.setSelection(posCursor+1);
        }else {
            pantalla.setText(String.format("%s%s%s",izquierda,aggDato,derecha ));

            //para mantener el cursor al lado derecho y que no se vaya al final del texto
            pantalla.setSelection(posCursor+1);
        }
        ;
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
        pantalla.setText("");
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
        int posCursor = pantalla.getSelectionStart();

        //Llevar cuenta de los parentesis cerrados y abiertos
        int abrirPar =0;
        int cerrarPar =0;

        int tamañoTexto = pantalla.getText().length();

        for (int i =0; i<posCursor; i++){
            if (pantalla.getText().toString().substring(i,i+1).equals("(")){
                abrirPar++;
            }
            if (pantalla.getText().toString().substring(i,i+1).equals(")")){
                cerrarPar++;
            }
        }

        if (abrirPar == cerrarPar || pantalla.getText().toString().substring(tamañoTexto-1,tamañoTexto).equals("(")){
            updateTxt("(");
            pantalla.setSelection(posCursor+1);
        }
        else if (abrirPar > cerrarPar || !pantalla.getText().toString().substring(tamañoTexto-1,tamañoTexto).equals(")")){
            updateTxt(")");
            pantalla.setSelection(posCursor+1);
        }
    }

    public void btnMasMenos(View view){
        updateTxt("-");
    }

    public void btnPunto(View view){
        updateTxt(".");
    }

    public void btnIgual(View view){

        String expresionUser = pantalla.getText().toString();

        //reemplazo los simbolos de division y multiplicacion
        expresionUser = expresionUser.replaceAll("÷", "/");
        expresionUser = expresionUser.replaceAll("x", "*");

        //Calcular operación
        Expression expresion = new Expression(expresionUser);
        String resultado = String.valueOf(expresion.calculate());

        //Agregando resultado a la pantalla
        pantalla.setText(resultado);
        //Actualizando cursor
        pantalla.setSelection(resultado.length());

    }

    public void btnBorrar(View view){
        int posCursor = pantalla.getSelectionStart();
        int tamañoTexto = pantalla.getText().length();

        //Para evitar errores de indices hacemos una condición
        if (posCursor != 0 && tamañoTexto !=0){
            //Permite reemplazar diferentes caracteres del texto
            SpannableStringBuilder seleccion = (SpannableStringBuilder) pantalla.getText();
            // Tomaría el caracter a de |a|rbol para reemplazarlo por ""
            seleccion.replace(posCursor-1, posCursor, "");

            //Actualizamos nuesta pantalla
            pantalla.setText(seleccion);
            //Y actualizo la posición del cursor también
            pantalla.setSelection(posCursor-1);
        }
    }
}