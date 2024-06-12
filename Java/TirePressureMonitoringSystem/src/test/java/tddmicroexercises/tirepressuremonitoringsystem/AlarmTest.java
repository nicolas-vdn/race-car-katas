package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlarmTest {

    @Mock
    private Sensor sensor;
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    private Alarm alarm;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        alarm = new Alarm(sensor, LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD);
    }

    @Test
    public void shouldSetAlarmOnWhenPressureIsTooLow() {
        //Arrange
        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

        //Act
        alarm.check();

        //Assert
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void shouldSetAlarmOnWhenPressureIsTooHigh() {
        //Arrange
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

        //Act
        alarm.check();

        //Assert
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void shouldSetAlarmOffWhenPressureIsOk() {
        //Arrange
        when(sensor.popNextPressurePsiValue()).thenReturn(18.0);

        //Act
        alarm.check();

        //Assert
        assertFalse(alarm.isAlarmOn());
    }
}
