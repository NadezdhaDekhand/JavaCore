package HW7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String cityCode = RequestHandler.detectCityId("Novosibirsk");
        System.out.println(cityCode);
        String forecast = RequestHandler.getForecast(cityCode);
       // System.out.println(forecast);
        String oneDay = RequestHandler.getOneDay(cityCode);
        System.out.println(oneDay);
        System.out.println();

    }
}
