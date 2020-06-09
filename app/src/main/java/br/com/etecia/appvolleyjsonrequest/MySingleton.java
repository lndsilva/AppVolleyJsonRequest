package br.com.etecia.appvolleyjsonrequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton myInstance;
    private RequestQueue requestQueue;
    private static Context myContext;

    public MySingleton(Context context) {
        myContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (myInstance == null) {
            myInstance = new MySingleton(context);
        }
        return myInstance;
    }

    public <T> void addToRequestque(Request<T> request) {
        requestQueue.add(request);

    }
}
