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
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {
    public TableView<TestTable> mainTable_TableView;
    public TableColumn<TestTable, Integer> idColumn;
    public TableColumn<TestTable, String> nameColumn;
    public TableColumn<TestTable, Integer> valueColumn;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public void initialize() {

        TestTableService testTableService = new TestTableService();
        TestTable testTable = new TestTable("Vishnya", new Random().nextInt(300));
        testTableService.saveTestTable(testTable);


        idColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("index"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<TestTable, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("value"));

        ObservableList<TestTable> testTableData = FXCollections.observableArrayList(TestTableService.getAll());
        mainTable_TableView.setItems(testTableData);

    }


}
