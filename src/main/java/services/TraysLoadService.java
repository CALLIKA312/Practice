package services;

import dao.TraysDao;
import dao.TraysLoadDao;
import models.Trays;
import models.TraysLoad;

import java.util.List;

public class TraysLoadService {
    private TraysLoadDao traysLoadDao = new TraysLoadDao();

    public TraysLoadService() {
    }

    public TraysLoad findCables(int id) {
        return traysLoadDao.findById(id);
    }

    public static List<TraysLoad> getAll() {
        return TraysLoadDao.findAll();
    }
}
