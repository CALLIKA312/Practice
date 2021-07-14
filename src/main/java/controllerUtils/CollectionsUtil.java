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
    public static List<Cover> getFilteredList(List<Cover> coversList, Object length, Object width, Object height) {

        // передаваемые объекты могут быть null, поэтому нельзя сравнивать их напрямую со значением поля таблицы, проверяем с помощью instanceof

        Predicate<Cover> lengthPredicate = p -> p.getLength() == (length instanceof Integer ? (Integer) length : p.getLength());

        Predicate<Cover> widthPredicate = p -> p.getWidth() == (width instanceof Integer ? (Integer) width : p.getWidth());

        Predicate<Cover> heightPredicate = p -> p.getHeight() == (height instanceof Integer ? (Integer) height : p.getHeight());


        List<Predicate<Cover>> predicates = Arrays.asList(lengthPredicate, widthPredicate, heightPredicate);

        return coversList.stream().filter(p -> predicates.stream().allMatch(f -> f.test(p))).collect(Collectors.toList());
    }


    public static List<Cables> getFilteredList(List<Cables> cablesList, Object mass) {
        Predicate<Cables> numberOfCoresPredicate = p -> p.getMass() == (mass instanceof Integer ? (Integer) mass : p.getMass());
        List<Predicate<Cables>> predicates = Collections.singletonList(numberOfCoresPredicate);

        return cablesList.stream().filter(p -> predicates.stream().allMatch(f-> f.test(p))).collect(Collectors.toList());
    }
}
