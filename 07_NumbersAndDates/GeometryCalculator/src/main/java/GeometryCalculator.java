public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        double radiusModulus = Math.abs(radius);
        return Math.PI * radiusModulus * radiusModulus;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        double radiusModulus = Math.abs(radius);
        return 4.0 / 3 * Math.PI * radiusModulus * radiusModulus * radiusModulus;
    }

    public static boolean isTrianglePossible(double a, double b, double c)
    {
        boolean firstCondition = (a + b) > c;
        boolean secondCondition = (a + c) > b;
        boolean thirdCondition = (b + c) > a;
        if (firstCondition && secondCondition && thirdCondition)
            return true;
        else
            return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        boolean trianglePossible = isTrianglePossible(a, b, c);
        if (trianglePossible) {
            double semiPerimeter = (a + b + c) / 2;
            return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        }
        else
            return -1.0;
    }
}
