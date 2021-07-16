package services;

import dao.CablesDao;
import dao.TraysDao;
import models.Cables;
import models.Trays;

import java.util.List;

public class TraysService {
    private TraysDao traysDao = new TraysDao();

    public TraysService() {
    }

    public Trays findCables(int id) {
        return traysDao.findById(id);
    }

    public static List<Trays> getAll() {
        return TraysDao.findAll();
    }
}
