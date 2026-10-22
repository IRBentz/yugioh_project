package yugioh.testing;

import yugioh.card.component.LinkArrowComponent;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumToLinkArrowComponentArray {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while(kb.hasNext()) {
            evalIntToList(Integer.decode(kb.next())).forEach(System.out::println);
        }
    }

    private static void evalNum1(int num) {
        ArrayList<LinkArrowComponent> linkArrows = new ArrayList<>(Arrays.asList(LinkArrowComponent.values()));
        ArrayList<LinkArrowComponent> matchedArrows = new ArrayList<>();
        for(LinkArrowComponent arrow : linkArrows.reversed()) {
            if(num - arrow.getNumericIden() >= 0) {
                num -= arrow.getNumericIden();
                matchedArrows.add(arrow);
            }
        }
        matchedArrows.reversed().forEach(System.out::println);
    }

    static List<LinkArrowComponent> evalIntToList(int num) {
        if(num > 495) {
            throw new Error("Invalid input");
        }
        if(num <= 0) {
            return new ArrayList<>();
        }
        for(LinkArrowComponent comp : Arrays.asList(LinkArrowComponent.values()).reversed()) {
            if(num >= comp.getNumericIden()) {
                List<LinkArrowComponent> matched = evalIntToList(num - comp.getNumericIden());
                matched.add(comp);
                return matched;
            }
        }
        return new ArrayList<>();
    }
}
