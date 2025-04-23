package com.jjideenschmiede.teamcity.dateVariables;

import jetbrains.buildServer.serverSide.SBuild;
import jetbrains.buildServer.serverSide.parameters.AbstractBuildParametersProvider;
import org.jetbrains.annotations.NotNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides date-related parameters to TeamCity builds
 */
public class DateVariablesProvider extends AbstractBuildParametersProvider {

	@NotNull
	@Override
	public Map<String, String> getParameters(@NotNull SBuild build, boolean emulationMode) {
		Map<String, String> params = new HashMap<>();

		ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

		params.put(DateVariablesConstants.YEAR, String.valueOf(now.getYear()));
		params.put(DateVariablesConstants.MONTH, String.format("%02d", now.getMonthValue()));
		params.put(DateVariablesConstants.DAY, String.format("%02d", now.getDayOfMonth()));
		params.put(DateVariablesConstants.HOUR, String.format("%02d", now.getHour()));
		params.put(DateVariablesConstants.MINUTE, String.format("%02d", now.getMinute()));
		params.put(DateVariablesConstants.SECOND, String.format("%02d", now.getSecond()));

		params.put(DateVariablesConstants.TIMESTAMP, String.valueOf(now.toEpochSecond()));

		params.put(DateVariablesConstants.ISO_DATE, now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

		return params;
	}
}
