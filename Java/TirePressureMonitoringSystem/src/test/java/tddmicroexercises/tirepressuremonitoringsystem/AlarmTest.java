package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AlarmTest {

    @Test
    public void checkInitialisation() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void checkIfPressureIsTooLow() {
        Alarm alarm = new Alarm();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
