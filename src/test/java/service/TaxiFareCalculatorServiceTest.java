package service;

import domain.Fare;
import domain.TaxiRide;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TaxiFareCalculatorServiceTest {

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @Test
    void calculateFare() {
        //TaxiFareCalculatorService taxiFareCalculatorService = new TaxiFareCalculatorService();
        /** To be fixed **/
        TaxiRide taxiRide = TaxiRide.builder()
                .isNightSurcharge(false).distanceInMile(9L).build();
        Fare rideFare = new Fare();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(70), totalCharge);
    }
}