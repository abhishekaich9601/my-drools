package domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxiRide {
    private Boolean isNightSurcharge;
    private Long distanceInMile;
}
