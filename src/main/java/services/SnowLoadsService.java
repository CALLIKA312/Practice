package services;

import dao.RegionsDao;
import dao.SnowLoadsDao;
import models.Regions;
import models.SnowLoads;

import java.util.List;

public class SnowLoadsService {

    private SnowLoadsDao snowLoadsDao = new SnowLoadsDao();

    public SnowLoadsService() {
    }

    public SnowLoads findById(int id) {
        return SnowLoadsDao.findById(id);
    }

    public static List<SnowLoads> getAll() {
        return SnowLoadsDao.findAll();
    }
}
