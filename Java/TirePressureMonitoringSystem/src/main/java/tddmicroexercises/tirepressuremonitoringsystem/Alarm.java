package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private double lowPressureThreshold;
    private double highPressureThreshold;

    protected Sensor sensor;

    protected boolean alarmOn = false;

    public Alarm(Sensor sensor, double lowPressureThreshold, double highPressureThreshold) {
        this.sensor = sensor;
        this.lowPressureThreshold = lowPressureThreshold;
        this.highPressureThreshold = highPressureThreshold;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < lowPressureThreshold || psiPressureValue > highPressureThreshold) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
