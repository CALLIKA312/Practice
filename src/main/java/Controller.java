import models.TestTable;
import services.TestTableService;

public class Controller {

    public static void main(String[] args) {

        TestTableService testTableService = new TestTableService();
        TestTable testTable = new TestTable("Apelsin", 149);

    }
}
