package br.com.etecia.appvolleyjsonrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView nome, email, mobile;
    Button btnCarregaDados;

    String url_json = "http://192.168.100.5/Projetovolleyapi/informacoes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaro os objetos xml para java
        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.txtEmail);
        mobile = findViewById(R.id.txtMobile);

        btnCarregaDados = findViewById(R.id.btnCarregaInformacoes);

        btnCarregaDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_json, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Os nomes recebidos pelo response.get deverá ter o mesmo nome dos campos da tabela php
                                    nome.setText(response.getString("Nome"));
                                    email.setText(response.getString("Email"));
                                    mobile.setText(response.getString("Mobile"));
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(),
                                            "Nenhum nome encontrado...",
                                            Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao carregar as informações",
                                Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestque(jsonObjectRequest);
            }
        });
    }
}
