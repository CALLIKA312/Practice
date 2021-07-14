package services;

import dao.CablesDao;
import models.Cables;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public class CablesService {
    private CablesDao cablesDao = new CablesDao();

    public CablesService() {
    }

    public Cables findCables(int id) {
        return cablesDao.findById(id);
    }

    public static List<Cables> getAll() {
        return CablesDao.findAll();
    }
}
