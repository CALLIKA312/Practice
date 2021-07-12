package services;

import dao.CitiesDao;
import dao.RegionsDao;
import models.Cities;
import models.Regions;

import java.util.List;

public class RegionsService {

    private RegionsDao regionsDao = new RegionsDao();

    public RegionsService() {
    }

    public Regions findRegions(int id) {
        return regionsDao.findById(id);
    }

    public static List<Regions> getAll() {
        return RegionsDao.findAll();
    }
}
