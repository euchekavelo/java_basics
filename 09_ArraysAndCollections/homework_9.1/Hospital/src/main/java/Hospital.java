public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        float minTemperature = 32;
        float maxTemperature = 40;

        float[] temperatureData = new float[patientsCount];
        for (int i = 0; i < patientsCount; i ++)
        {
            temperatureData[i] = (float) ((Math.random() * (maxTemperature - minTemperature)) + minTemperature);
        }

        return temperatureData;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float sumTemperature = 0;
        int countHealthy = 0;
        String patientsTemperature = "";
        float minPermissibleTemperature = (float) 36.2;
        float maxPermissibleTemperature = (float) 36.9;

        for (float temperature : temperatureData)
        {
            temperature = (float) (Math.round(temperature * 10.0) / 10.0);
            patientsTemperature = patientsTemperature.concat(temperature + " ");
            sumTemperature = sumTemperature + temperature;
            if (temperature >= minPermissibleTemperature && temperature <= maxPermissibleTemperature)
            {
                countHealthy = countHealthy + 1;
            }
        }

        float averageTemperature = (float) (Math.round(sumTemperature / temperatureData.length * 100.0) / 100.0);

        return "Температуры пациентов: " + patientsTemperature.trim() +
                "\nСредняя температура: " + averageTemperature +
                "\nКоличество здоровых: " + countHealthy;
    }
}
