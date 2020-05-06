package examples;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ExampleData {

    public static void main(String[] args) {
        examplesLocalTime();
        examplesLocalDate();
        examplesLocalDateTime();
    }

    private static void examplesLocalTime(){
        System.out.println("-- LocalTime.now --");
        LocalTime localTimeStop = LocalTime.now();
        System.out.println(localTimeStop);

        System.out.println("-- LocalTime.of HH:MM --");
        LocalTime localTimeStart = LocalTime.of(10,10);
        System.out.println(localTimeStart);

        System.out.println("-- LocalTime.of HH:MM:SS --");
        localTimeStart = LocalTime.of(10,10, 10);
        System.out.println(localTimeStart);

        System.out.println("-- Duration --");
        System.out.println(Duration.between(localTimeStart, localTimeStop));
    }

    private static void examplesLocalDate(){

        System.out.println("-- LocalDate now --");
        LocalDate dateStop = LocalDate.now();
        System.out.println(dateStop);

        System.out.println("-- LocalDate of --");
        LocalDate dateStart = LocalDate.of(2018, Month.JANUARY,01);
        System.out.println(dateStart);

        System.out.println("-- Period --");
        System.out.println(Period.between(dateStart, dateStop));

        System.out.println("-- DateTimeFormatter --");
        System.out.println(dateStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dateStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(dateStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(dateStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
    }

    private static void examplesLocalDateTime(){

        System.out.println("-- LocalDateTime now --");
        LocalDateTime dateTimeStop = LocalDateTime.now();
        System.out.println(dateTimeStop);

        System.out.println("-- LocalDate of --");
        LocalDateTime dateTimeStart = LocalDateTime.of(2018, Month.OCTOBER, 01, 10,10,10);
        System.out.println(dateTimeStart);

        System.out.println("-- Duration --");
        System.out.println(Duration.between(dateTimeStart, dateTimeStop));

        System.out.println("-- DateTimeFormatter --");
        System.out.println(dateTimeStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dateTimeStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(dateTimeStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(dateTimeStart.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));

        System.out.println(dateTimeStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }

}


