package controllerUtils;

import models.Cables;
import models.Cover;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsUtil {


    /**
     * метод для получения отфильтрованного списка крышек
     */
    public static List<Cover> getFilteredList(List<Cover> coversList, Object height, Object width, Object length) {

        Predicate<Cover> heightPredicate = p -> p.getHeight() == (height != null ? Integer.parseInt(String.valueOf(height)) : p.getHeight());

        Predicate<Cover> widthPredicate = p -> p.getWidth() == (width != null ? Integer.parseInt(String.valueOf(width)) : p.getWidth());

        Predicate<Cover> lengthPredicate = p -> p.getLength() == (length != null ? Integer.parseInt(String.valueOf(length)) : p.getLength());

        return coversList.stream().filter(heightPredicate).filter(widthPredicate).filter(lengthPredicate).collect(Collectors.toList());

    }


    public static List<Cables> getFilteredList(List<Cables> cablesList, Object articul, Object mass) {
        Predicate<Cables> articulPredicate = p -> p.getArticul().equals(articul != null ? String.valueOf(articul) : p.getArticul());
        Predicate<Cables> massPredicate = p -> p.getMass() == (mass != null ? Integer.parseInt(String.valueOf(mass)) : p.getMass());
        return cablesList.stream().filter(articulPredicate).filter(massPredicate).collect(Collectors.toList());
    }
}
