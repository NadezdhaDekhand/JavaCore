package HW_8;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        String cityCode = RequestHandler.detectCityId("Novosibirsk");
        String forecast = RequestHandler.getForecast(cityCode);
}
}
