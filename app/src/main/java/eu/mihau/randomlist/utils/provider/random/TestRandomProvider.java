package eu.mihau.randomlist.utils.provider.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import eu.mihau.randomlist.R;

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

        Integer color = R.color.md_red_500;

        randomPercentages.addAll(Arrays.asList(44, 66, 88, 5, 99));
        randomColors.addAll(Arrays.asList(color, color, color, color, color, color));
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
