package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottosFactory {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int AMOUNT_DIVIDE = 1000;

    public Lottos createLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        validateAmount(amount);
        int sheet = amount / AMOUNT_DIVIDE;

        for (int i = 0; i < sheet; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE)));
        }
        return new Lottos(lottos);
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_DIVIDE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000의 배수여야 합니다");
        }
    }
}
