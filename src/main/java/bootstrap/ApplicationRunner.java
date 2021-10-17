package bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TaxiFareCalculatorService;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
        TaxiFareCalculatorService taxiFareCalculatorService = context.getBean(TaxiFareCalculatorService.class);
        /*
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();
            String[] splittedLine = inputLine.split(" ");
            boolean isNightSurcharge = Boolean.valueOf(splittedLine[0]);
            Long distance = Long.parseLong(splittedLine[1]);
            TaxiRide taxiRide = TaxiRide.builder()
                    .isNightSurcharge(isNightSurcharge)
                    .distanceInMile(distance).build();
            Fare rideFare = new Fare();
            Long calculatedFare = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
            System.out.println("calculatedFare="+calculatedFare);
        }

         */
        Boolean evaluatedResult = taxiFareCalculatorService.evaluatedListWorking();
        System.out.println("evaluatedResult="+evaluatedResult);
    }
}
