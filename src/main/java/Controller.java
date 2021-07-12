import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cities;
import models.Cover;
import models.Regions;
import services.CitiesService;
import services.CoverService;
import services.RegionsService;
import services.SnowLoadsService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    public TableView<Cover> mainTable_TableView;
    public TableColumn<Cover, Integer> idColumn;
    public TableColumn<Cover, Integer> massColumn;
    public TableColumn<Cover, String> title_displayColumn;
    public TableColumn<Cover, Integer> construction_idColumn;
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


        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        massColumn.setCellValueFactory(new PropertyValueFactory<>("mass"));
        title_displayColumn.setCellValueFactory(new PropertyValueFactory<>("title_display"));
        construction_idColumn.setCellValueFactory(new PropertyValueFactory<>("construction_id"));

        mainTable_TableView.setItems(FXCollections.observableArrayList(CoverService.getAll()));



        cities_CB.setItems(FXCollections.observableArrayList(CitiesService.getAll()));
        new AutoCompleteComboBoxListener<>(cities_CB);

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
