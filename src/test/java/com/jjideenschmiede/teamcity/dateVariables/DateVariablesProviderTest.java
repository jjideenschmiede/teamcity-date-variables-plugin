package com.jjideenschmiede.teamcity.dateVariables;

import jetbrains.buildServer.serverSide.SBuild;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DateVariablesProvider class
 */
public class DateVariablesProviderTest {

    @Mock
    private SBuild mockBuild;

    private DateVariablesProvider provider;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        provider = new DateVariablesProvider();
    }

    @Test
    public void testGetParameters() {
        Map<String, String> params = provider.getParameters(mockBuild, false);

        assertNotNull(params.get(DateVariablesConstants.YEAR));
        assertNotNull(params.get(DateVariablesConstants.MONTH));
        assertNotNull(params.get(DateVariablesConstants.DAY));
        assertNotNull(params.get(DateVariablesConstants.HOUR));
        assertNotNull(params.get(DateVariablesConstants.MINUTE));
        assertNotNull(params.get(DateVariablesConstants.SECOND));
        assertNotNull(params.get(DateVariablesConstants.TIMESTAMP));
        assertNotNull(params.get(DateVariablesConstants.ISO_DATE));

        assertTrue(Pattern.matches("\\d{4}", params.get(DateVariablesConstants.YEAR)));
        assertTrue(Pattern.matches("\\d{2}", params.get(DateVariablesConstants.MONTH)));
        assertTrue(Pattern.matches("\\d{2}", params.get(DateVariablesConstants.DAY)));
        assertTrue(Pattern.matches("\\d{2}", params.get(DateVariablesConstants.HOUR)));
        assertTrue(Pattern.matches("\\d{2}", params.get(DateVariablesConstants.MINUTE)));
        assertTrue(Pattern.matches("\\d{2}", params.get(DateVariablesConstants.SECOND)));
        assertTrue(Pattern.matches("\\d+", params.get(DateVariablesConstants.TIMESTAMP)));

        assertTrue(params.get(DateVariablesConstants.ISO_DATE).contains("T"));
        assertTrue(params.get(DateVariablesConstants.ISO_DATE).contains("+") ||
                   params.get(DateVariablesConstants.ISO_DATE).contains("-"));
    }

    @Test
    public void testParameterValues() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        Map<String, String> params = provider.getParameters(mockBuild, false);

        int year = Integer.parseInt(params.get(DateVariablesConstants.YEAR));
        int month = Integer.parseInt(params.get(DateVariablesConstants.MONTH));
        int day = Integer.parseInt(params.get(DateVariablesConstants.DAY));

        assertTrue(Math.abs(year - now.getYear()) <= 1);
        assertTrue(Math.abs(month - now.getMonthValue()) <= 1);
        assertTrue(Math.abs(day - now.getDayOfMonth()) <= 1);
    }
}
