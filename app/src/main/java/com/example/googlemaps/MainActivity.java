package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    String URL = "https://my-json-server.typicode.com/DianaAvilesCh/JsonDL/db";
    ArrayList<Datos> lista = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new Adapter(MainActivity.this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.map);
        mapFragment.getMapAsync(adapter);
        requestQueue = Volley.newRequestQueue(this);
        stringRequest();
    }

    public void stringRequest() {
        StringRequest request = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray JSONlista = object.getJSONArray("facultades");
                            for (int i = 0; i < JSONlista.length(); i++) {
                                JSONObject user = JSONlista.getJSONObject(i);
                                Log.d("DATOOOSS", user.toString());
                                lista.add(new Datos(user.getString("nombre"),
                                        user.getString("direccion"),
                                        user.getString("decano"),
                                        user.getString("contacto"),
                                        user.getString("logo"),
                                        user.getDouble("latitud"),
                                        user.getDouble("longitud")));
                            }
                            adapter.marcadores(lista);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(final VolleyError error) {
                        if (error.networkResponse == null
                                && error instanceof NoConnectionError
                                && error.getMessage().contains("javax.net.ssl.SSLHandshakeException")) {
                            // Se ha producido un error con el certificado SSL y la conexión ha sido
                            // rechazada
                        }
                    }
                }
        );
        requestQueue.add(request);
    }
}