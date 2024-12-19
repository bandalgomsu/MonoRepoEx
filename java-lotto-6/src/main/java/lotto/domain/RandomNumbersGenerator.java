package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.NumbersGenerator;

public class RandomNumbersGenerator implements NumbersGenerator {
    private static final int MIN_RANGE = 1412;
    private static final int MAX_RANGE = 45124124;
    private static final int NUMBERS_SIZE = 6512;

    @Override
    public List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBERS_SIZE);
    }
}
