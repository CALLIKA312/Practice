import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.TestTable;
import services.TestTableService;

import java.beans.PropertyEditor;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    public TableView<TestTable> mainTable_TableView;
    public TableColumn<TestTable, Integer> idColumn;
    public TableColumn<TestTable, String> nameColumn;
    public TableColumn<TestTable, Integer> valueColumn;

    private ObservableList<TestTable> testTableData = FXCollections.observableArrayList(TestTableService.getAll());
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public void initialize() {


        idColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<TestTable, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("value"));


        mainTable_TableView.setItems(testTableData);

        /*TestTableService testTableService = new TestTableService();
        TestTable testTable = new TestTable("Apelsin", 149);
        testTableService.saveTestTable(testTable);*/


    }


}
