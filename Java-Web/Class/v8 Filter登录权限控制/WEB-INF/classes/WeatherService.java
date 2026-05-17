import java.util.*;
import java.text.*;

public class WeatherService
{
    public String getWeather()
    {
        return "sunny";
    }

    public static void main(String[] arg)
    {
        WeatherService ws = new WeatherService();
        System.out.println("weather Today:" + ws.getWeather());
    }
}