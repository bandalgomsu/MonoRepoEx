package recommend.subway.station.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seats {
    private final List<Seat> seats;
}
