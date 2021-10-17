package domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fare {
    private Long nightSurcharge;
    private Long rideFare;

    public Long getTotalFare() {
        return nightSurcharge + rideFare;
    }
}
