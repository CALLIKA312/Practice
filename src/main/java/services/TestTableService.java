package services;

import dao.TestTableDao;
import models.TestTable;

public class TestTableService {
    private TestTableDao testTableDao = new TestTableDao();

    public TestTableService() {
    }

    public TestTable findTestTable(int id) {
        return testTableDao.findById(id);
    }

    public void saveTestTable(TestTable testTable) {
        testTableDao.save(testTable);
    }

    public void updateTestTable(TestTable testTable) {
        testTableDao.update(testTable);
    }

    public void deleteTestTable(TestTable testTable) {
        testTableDao.delete(testTable);
    }

}
