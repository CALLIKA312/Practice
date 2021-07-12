package services;

import dao.CoverDao;
import dao.SnowLoadsDao;
import models.Cover;
import models.SnowLoads;

import java.util.List;

public class CoverService {
    private CoverDao coverDao = new CoverDao();

    public CoverService() {
    }

    public Cover findById(int id) {
        return CoverDao.findById(id);
    }

    public static List<Cover> getAll() {
        return CoverDao.findAll();
    }
}
