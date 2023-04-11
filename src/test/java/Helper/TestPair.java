package Helper;

import org.example.Helper.Pair;
import org.example.Time.Timeframe;
import org.example.Time.Time;
import org.example.Time.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestPair {
    private Pair<Day, Timeframe> pair;

    @BeforeEach
    public void init() {
        Day day = Day.MONDAY;
        Timeframe tf = new Timeframe(new Time(10));
        pair = new Pair<>(day, tf);
    }

    @Test
    public void testGetter() {
        assertEquals(Day.MONDAY, pair.getKey());
        assertEquals("10:00-11:30", pair.getValue().toString());
    }

    @Test
    public void testSetter() {
        pair.setKey(Day.FRIDAY);
        pair.setValue(new Timeframe(new Time(0)));

        assertEquals(Day.FRIDAY, pair.getKey());
        assertEquals("00:00-01:30", pair.getValue().toString());
    }


}
