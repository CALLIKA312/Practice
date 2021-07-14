import controllerUtils.AutoCompleteComboBoxListener;
import controllerUtils.CoverFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import models.Cities;
import models.Cover;
import models.Regions;
import services.CitiesService;
import services.CoverService;
import services.RegionsService;
import services.SnowLoadsService;

import java.net.URL;
import java.util.ArrayList;
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
    public ComboBox<Object> snowLoads_CB;
    public ScrollPane cables_SP;
    public Button test_Button;


    public ComboBox<Integer> construction_CB;
    public ComboBox<Integer> mass_CB;
    public Pane cover_Pane;

    CoverFilter coverFilter = new CoverFilter();
    Cover choseCover;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        massColumn.setCellValueFactory(new PropertyValueFactory<>("mass"));
        title_displayColumn.setCellValueFactory(new PropertyValueFactory<>("title_display"));
        construction_idColumn.setCellValueFactory(new PropertyValueFactory<>("construction_id"));

        mainTable_TableView.setItems(FXCollections.observableArrayList(CoverService.getAll()));

        coverFilter.setTableView(mainTable_TableView);

        cities_CB.setItems(FXCollections.observableArrayList(CitiesService.getAll()));
        new AutoCompleteComboBoxListener<>(cities_CB);
        snowLoads_CB.setItems(FXCollections.observableArrayList(SnowLoadsService.getAll()));
        new AutoCompleteComboBoxListener<>(snowLoads_CB);


        List<Cover> coverList = CoverService.getAll();

        construction_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverConstructions(coverList)));
        new AutoCompleteComboBoxListener<>(construction_CB);
        mass_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverMass(coverList)));
        new AutoCompleteComboBoxListener<>(mass_CB);

    }

    public void citiesChose(ActionEvent actionEvent) {
        int regionId = cities_CB.getValue().getRegion_id();
        for (Regions region : regionsList) {
            if (region.getId() == regionId) {
                snowLoads_CB.setValue(cities_CB.getValue().getSnowarea());
                region_Label.setText(region.getName());
                return;
            }
        }
    }

    public void regionChose(ActionEvent actionEvent) {
        cities_CB.setValue(null);
        region_Label.setText("");
    }

    private ArrayList<Integer> makeUniqueAndSortCoverConstructions(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getConstruction_id())) arrayList.add(cover.getConstruction_id());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }

    private ArrayList<Integer> makeUniqueAndSortCoverMass(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getMass())) arrayList.add(cover.getMass());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }


    public void test_Click(ActionEvent actionEvent) {
        cover_Pane.setVisible(true);
    }

    public void constructionChose(ActionEvent actionEvent) {
        if (construction_CB.getValue() != null) coverFilter.setConstructionValueWithUpdate(construction_CB.getValue());
    }

    public void clearConstruction_CB(ActionEvent actionEvent) {
        ObservableList<Integer> integers = construction_CB.getItems();
        construction_CB.setItems(null);
        construction_CB.setItems(integers);
        coverFilter.setConstructionValueWithUpdate(Integer.MAX_VALUE);
    }

    public void massChose(ActionEvent actionEvent) {
        if (mass_CB.getValue() != null) coverFilter.setMassValueWithUpdate(mass_CB.getValue());
    }

    public void clearMass_CB(ActionEvent actionEvent) {
        ObservableList<Integer> integers = mass_CB.getItems();
        mass_CB.setItems(null);
        mass_CB.setItems(integers);
        coverFilter.setMassValueWithUpdate(Integer.MAX_VALUE);
    }

    public void coverChose(ActionEvent actionEvent) {
        Cover curCover = mainTable_TableView.getSelectionModel().getSelectedItem();
        if (curCover != null) {
            choseCover = curCover;
            cover_Pane.setVisible(false);
        }
    }
}
