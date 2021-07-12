package services;

import dao.CitiesDao;
import models.Cities;
import models.TestTable;

import java.util.List;

public class CitiesService {
    private CitiesDao citiesDao = new CitiesDao();

    public CitiesService() {
    }

    public Cities findCities(int id) {
        return citiesDao.findById(id);
    }

    public static List<Cities> getAll(){
        return CitiesDao.findAll();
    }

}
