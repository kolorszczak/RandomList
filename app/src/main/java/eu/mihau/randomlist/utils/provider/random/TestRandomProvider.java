package eu.mihau.randomlist.utils.provider.random;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TestRandomProvider implements RandomProvider {

    private int percentsIndex;
    private int colorIndex;

    List<Integer> randomPercentages;
    List<Integer> randomColors;

    @Inject
    public TestRandomProvider() {
        percentsIndex = 0;
        colorIndex = 0;

        randomPercentages = new ArrayList<>();
        randomColors = new ArrayList<>();
    }

    @Override
    public int getPercent() {
        if (percentsIndex > randomPercentages.size()) {
            percentsIndex = 0;
        }
        return randomPercentages.get(percentsIndex++);
    }

    @Override
    public int getColor() {
        if (colorIndex > randomColors.size()) {
            colorIndex = 0;
        }
        return randomColors.get(colorIndex++);
    }
}
