package controllerUtils;

import models.Cables;
import models.Cover;
import models.Trays;
import models.TraysLoad;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsUtil {


    /**
     * метод для получения отфильтрованного списка крышек
     */
    public static List<Cover> getFilteredListOfCovers(List<Cover> coversList, Object type, Object width, Object length) {
        Predicate<Cover> heightPredicate = p -> p.getType() == (type != null ? Integer.parseInt(String.valueOf(type)) : p.getType());
        Predicate<Cover> widthPredicate = p -> p.getWidth() == (width != null ? Integer.parseInt(String.valueOf(width)) : p.getWidth());
        Predicate<Cover> lengthPredicate = p -> p.getLength() == (length != null ? Integer.parseInt(String.valueOf(length)) : p.getLength());
        return coversList.stream().filter(heightPredicate).filter(widthPredicate).filter(lengthPredicate).collect(Collectors.toList());
    }


    public static List<Cables> getFilteredListOfCables(List<Cables> cablesList, Object articul, Object mass) {
        Predicate<Cables> articulPredicate = p -> p.getArticul().equals(articul != null ? String.valueOf(articul) : p.getArticul());
        Predicate<Cables> massPredicate = p -> p.getMass() == (mass != null ? Integer.parseInt(String.valueOf(mass)) : p.getMass());
        return cablesList.stream().filter(articulPredicate).filter(massPredicate).collect(Collectors.toList());
    }

    public static List<Trays> getFilteredListOfTrays(List<Trays> traysList, Object length, Object wight, Object thickness) {
        Predicate<Trays> lengthPredicate = p -> p.getLength() == (length != null ? Integer.parseInt(String.valueOf(length)) : p.getLength());
        Predicate<Trays> wightPredicate = p -> p.getWidth() == (wight != null ? Integer.parseInt(String.valueOf(wight)) : p.getWidth());
        Predicate<Trays> thicknessPredicate = p -> p.getThickness() == (thickness != null ? Double.parseDouble(String.valueOf(thickness)) : p.getThickness());
        return traysList.stream().filter(lengthPredicate).filter(wightPredicate).filter(thicknessPredicate).collect(Collectors.toList());
    }

    public static TraysLoad getFilteredListOfTraysLoad(List<TraysLoad> traysLoadList, Object trays_type, Object step, Object ths) {
        Predicate<TraysLoad> trays_typePredicate = p -> p.getTrays_type() == (trays_type != null ? Integer.parseInt(String.valueOf(trays_type)) : p.getTrays_type());
        Predicate<TraysLoad> stepPredicate = p -> p.getStep() == (step != null ? Double.parseDouble(String.valueOf(step)) : p.getStep());
        Predicate<TraysLoad> thsPredicate = p -> p.getThs() == (ths != null ? Double.parseDouble(String.valueOf(ths)) : p.getThs());


        return traysLoadList.stream().filter(trays_typePredicate).filter(stepPredicate).filter(thsPredicate).findFirst().orElse(null);

    }

}
