import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Cities;
import models.Regions;
import models.TestTable;
import services.CitiesService;
import services.RegionsService;
import services.SnowLoadsService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    public TableView<TestTable> mainTable_TableView;
    public TableColumn<TestTable, Integer> idColumn;
    public TableColumn<TestTable, String> nameColumn;
    public TableColumn<TestTable, Integer> valueColumn;
    public ComboBox<Cities> cities_CB;
    public TextField test_TF;
    public Label region_Label;

    public List<Regions> regionsList = RegionsService.getAll();
    public ComboBox<Object> region_CB;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public void initialize() {

        /*TestTableService testTableService = new TestTableService();
        TestTable testTable = new TestTable("Yabloko", new Random().nextInt(300));
        testTableService.saveTestTable(testTable);*/


        /* idColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("index"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<TestTable, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<TestTable, Integer>("value"));

        ObservableList<TestTable> testTableData = FXCollections.observableArrayList(TestTableService.getAll());
        mainTable_TableView.setItems(testTableData);*/


        cities_CB.setItems(FXCollections.observableArrayList(CitiesService.getAll()));
        new AutoCompleteComboBoxListener<>(cities_CB);

        List list = SnowLoadsService.getAll();
        region_CB.setItems(FXCollections.observableArrayList(SnowLoadsService.getAll()));
        new AutoCompleteComboBoxListener<>(region_CB);


    }


    public void citiesChosen(ActionEvent actionEvent) {
        int regionId = cities_CB.getValue().getRegion_id();
        for (Regions region : regionsList) {
            if (region.getId() == regionId) {
                region_CB.setValue(cities_CB.getValue().getSnowarea());
                region_Label.setText(region.getName());
                return;
            }
        }
    }

    public void regionChosen(ActionEvent actionEvent) {
        cities_CB.setValue(null);
        region_Label.setText("");
    }
}
