import javafx.fxml.FXML;
import models.TestTable;
import services.TestTableService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    public void initialize() {
        System.out.println(123);
        TestTableService testTableService = new TestTableService();
        TestTable testTable = new TestTable(7, "Apelsin", 149);
        testTableService.saveTestTable(testTable);
    }
}
