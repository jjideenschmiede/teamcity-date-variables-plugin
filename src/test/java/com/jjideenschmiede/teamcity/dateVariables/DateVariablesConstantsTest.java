package com.jjideenschmiede.teamcity.dateVariables;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DateVariablesConstants class
 */
public class DateVariablesConstantsTest {

    @Test
    public void testConstantsValues() {
        assertEquals("teamcity.date.", DateVariablesConstants.PREFIX);

        assertEquals(DateVariablesConstants.PREFIX + "year", DateVariablesConstants.YEAR);
        assertEquals(DateVariablesConstants.PREFIX + "month", DateVariablesConstants.MONTH);
        assertEquals(DateVariablesConstants.PREFIX + "day", DateVariablesConstants.DAY);
        assertEquals(DateVariablesConstants.PREFIX + "hour", DateVariablesConstants.HOUR);
        assertEquals(DateVariablesConstants.PREFIX + "minute", DateVariablesConstants.MINUTE);
        assertEquals(DateVariablesConstants.PREFIX + "second", DateVariablesConstants.SECOND);
        assertEquals(DateVariablesConstants.PREFIX + "timestamp", DateVariablesConstants.TIMESTAMP);
        assertEquals(DateVariablesConstants.PREFIX + "iso", DateVariablesConstants.ISO_DATE);
    }
}
