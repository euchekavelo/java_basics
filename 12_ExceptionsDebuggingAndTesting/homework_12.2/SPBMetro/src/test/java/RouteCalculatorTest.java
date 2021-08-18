import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    private List<Station> route;
    private List<Station> routeConnection;
    private StationIndex stationIndex;
    private RouteCalculator routeCalculator;

    public void setUp() throws Exception {

        //Создадим несколько линий.
        Line line1 = new Line(1, "Первая линия");
        Line line2 = new Line(2, "Вторая линия");
        Line line3 = new Line(3, "Третья линия");

        //Создадим несколько станций.
        Station station1 = new Station("Андриановская", line1);
        Station station2 = new Station("Барановская", line1);
        Station station3 = new Station("Веселевская", line2);
        Station station4 = new Station("Горьковская", line2);
        Station station5 = new Station("Домодедовская", line3);
        Station station6 = new Station("Ермолаевская", line3);

        //К созданным линиям добавим созданные станции.
        line1.addStation(station1);
        line1.addStation(station2);
        line2.addStation(station3);
        line2.addStation(station4);
        line3.addStation(station5);
        line3.addStation(station6);

        //Создадим маршрут.
        route = new ArrayList<>();
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);

        //Создадим переход.
        routeConnection = new ArrayList<>();

        //Создадим схему метро.
        stationIndex = new StationIndex();
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addConnection(routeConnection);

        //Создадим маршрутный калькулятор, передав в конструктор созданную схему метро.
        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        Station from = stationIndex.getStation("Андриановская");
        Station to = stationIndex.getStation("Барановская");

        List<Station> expected = new ArrayList<>();
        expected.add(from);
        expected.add(to);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        Station from = stationIndex.getStation("Андриановская");
        Station to = stationIndex.getStation("Горьковская");
        Station stationConnectionOne = stationIndex.getStation("Барановская");
        Station stationConnectionTwo = stationIndex.getStation("Веселевская");

        //Добавим переход, связывающий две станции разных линий (между первой и второй).
        routeConnection.add(stationConnectionOne);
        routeConnection.add(stationConnectionTwo);
        stationIndex.addConnection(routeConnection);

        List<Station> expected = new ArrayList<>();
        expected.add(from);
        expected.add(stationConnectionOne);
        expected.add(stationConnectionTwo);
        expected.add(to);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        Station from = stationIndex.getStation("Андриановская");
        Station to = stationIndex.getStation("Ермолаевская");

        Station stationConnectionOne = stationIndex.getStation("Барановская");
        Station stationConnectionTwo = stationIndex.getStation("Веселевская");
        Station stationConnectionThree = stationIndex.getStation("Горьковская");
        Station stationConnectionFour = stationIndex.getStation("Домодедовская");

        //Добавим переход, связывающий две станции разных линий (между первой и второй).
        routeConnection.add(stationConnectionOne);
        routeConnection.add(stationConnectionTwo);
        stationIndex.addConnection(routeConnection);

        //Добавим дополнительную связку перехода для разных линий (между второй и третьей).
        List<Station> connectionTwo = new ArrayList<>();
        connectionTwo.add(stationConnectionThree);
        connectionTwo.add(stationConnectionFour);
        stationIndex.addConnection(connectionTwo);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(route, actual);
    }

}