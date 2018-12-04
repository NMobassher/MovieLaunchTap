package uoit.ca.movieapp;


/* This is a service that runs in the background to fetch movie titles
 *  alongside some other information
 * */

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Retrieval {

    /* Fields */

    static String CURRENT_API = "http://www.themoviedb.org";
    static MovieInterface client;

    /* For configure client*/
    static OkHttpClient.Builder builder;
    static Request startRequest;
    static HttpUrl startUrl;
    static HttpUrl url;
    static Request.Builder requestBuilder;
    static Request endRequest;
    /* Methods */

    public static void configureClient() {
        if (client == null) {
            builder = new OkHttpClient.Builder();
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    startRequest = chain.request();
                    startUrl = startRequest.url();
                    url = startUrl.newBuilder().addQueryParameter("CURRENT_API", BuildConfig.API_KEY).build();
                    requestBuilder = startRequest.newBuilder().url(url);
                    endRequest = requestBuilder.build();
                    return chain.proceed(endRequest);
                }
            });

        }

    }


}
