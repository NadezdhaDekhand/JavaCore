package HW7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RequestHandler {

    final static OkHttpClient okHttpClient = new OkHttpClient();
    final static ObjectMapper objectMapper = new ObjectMapper();
    final static String host = "dataservice.accuweather.com";

    public static String detectCityId(String cityName) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "mjiVGNFI3UqA5pezieI2Wj5Yf2fzGZVB")
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();
        String city = objectMapper.readTree(json).get(0).at("/LocalizedName").asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key").asText();
        return code;
    }

    public static String getForecast(String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", "mjiVGNFI3UqA5pezieI2Wj5Yf2fzGZVB")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();
        String forecastsJson = objectMapper.readTree(json).at("/DailyForecasts").toString();
        for (int i = 0; i < 5; i++) {

            String dayForecasts = objectMapper.readTree(forecastsJson).get(i).toString();
            String maxTemp = objectMapper.readTree(dayForecasts).at("/Temperature")
                    .at("/Maximum")
                    .at("/Value").asText();
            String minTemp = objectMapper.readTree(dayForecasts).at("/Temperature")
                    .at("/Minimum")
                    .at("/Value").asText();
            String date = objectMapper.readTree(dayForecasts).at("/Date").asText();
            System.out.println(date + " " + maxTemp + " " + minTemp);
        }


        return json;
    }
    public static String getOneDay(String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", "mjiVGNFI3UqA5pezieI2Wj5Yf2fzGZVB")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();
        String forecastsJson = objectMapper.readTree(json).at("/DailyForecasts").toString();
        String forecastsJson1 = objectMapper.readTree(forecastsJson).get(0).toString();
        String maxTemp = objectMapper.readTree(forecastsJson1).at("/Temperature")
                .at("/Maximum")
                .at("/Value").asText();
        return "Максимальная температура за 1 день" +maxTemp;
    }
}