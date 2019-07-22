package com.somnath.apps.java8;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class DateTime {

	public static void main(String[] args) {
		System.out.println("start...");

		LocalDate localDate = LocalDate.now();
		System.out.println("localDate:" + localDate);
		LocalDate localDate1 = LocalDate.of(2018, 3, 2);
		System.out.println("localDate1:" + localDate1);
		LocalDate localDate2 = LocalDate.parse("2018-02-28");
		System.out.println("localDate2:" + localDate2);
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println("previousMonthSameDay:" + previousMonthSameDay);
		LocalDate  twoDaysBackDate = LocalDate.now().minusDays(2);
		System.out.println("twoDaysBackDate:" + twoDaysBackDate);

		System.out.println("#############################################");

		LocalDateTime beginningOfDay = LocalDate.parse("2018-02-27").atStartOfDay();
		System.out.println("beginningOfDay:" + beginningOfDay);

		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
				.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth:" + firstDayOfMonth);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("dateTime:" + localDateTime);

		System.out.println("#############################################");

		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println("zoneId:" + zoneId);

		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("allZoneIds:" + allZoneIds);

		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println("zonedDateTime:" + zonedDateTime);

		System.out.println("end...");
	}

}
