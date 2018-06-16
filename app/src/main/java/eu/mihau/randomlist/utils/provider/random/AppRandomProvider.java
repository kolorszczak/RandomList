package eu.mihau.randomlist.utils.provider.random;

import java.util.Random;

import javax.inject.Inject;

import eu.mihau.randomlist.R;

public class AppRandomProvider implements RandomProvider {

    private Random random;

    @Inject
    public AppRandomProvider() {
        random = new Random();
    }

    @Override
    public int getPercent() {
        return random.nextInt(101);
    }

    @Override
    public int getColor() {
        return random.nextInt() % 2 == 0 ? R.color.md_red_400 : R.color.md_blue_300;
    }
}
