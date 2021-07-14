import controllerUtils.AutoCompleteComboBoxListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import models.Cables;
import models.Cities;
import models.Cover;
import models.Regions;
import services.*;

import java.util.ArrayList;
import java.util.List;

import static controllerUtils.CollectionsUtil.getFilteredList;


public class Controller {


    public Pane cover_Pane;
    public TableView<Cover> covers_TableView;
    public TableColumn<Cover, Integer> articulCovers_Column;
    public TableColumn<Cover, Integer> massCovers_Column;
    public TableColumn<Cover, String> lengthCovers_Column;
    public TableColumn<Cover, Integer> heightCovers_Column;
    public TableColumn<Cover, Integer> widthCovers_Column;

    public ComboBox<Integer> length_CB;
    public ComboBox<Integer> width_CB;
    public ComboBox<Integer> height_CB;


    public ComboBox<Cities> cities_CB;
    public Label region_Label;
    public List<Regions> regionsList = RegionsService.getAll();
    public ComboBox<Object> snowLoads_CB;
    public Button test_Button;


    public TableView<Cables> cables_TableView;
    public TableColumn<Cables, String> articulCables_Column;
    public TableColumn<Cables, Integer> diametrCabeles_Column;
    public TableColumn<Cables, Integer> massCables_Column;
    public TableColumn<Cables, String> voltageCables_Column;

    public ComboBox<Integer> massCables_CB;

    public TableView<Cables> choseCables_TableView;
    public TableColumn<Cables, String> choseCablesArticul_Column;
    public TableColumn<Cables, Integer> massChoseCables_Column;
    public TabPane mainTabPane;
    public Tab choseCable_Tab;
    public Tab choseCover_Tab;


    Cover choseCover;
    List<Cover> coverList;
    List<Cables> cablesList;

    @FXML
    public void initialize() {

        cities_CB.setItems(FXCollections.observableArrayList(CitiesService.getAll()));
        new AutoCompleteComboBoxListener<>(cities_CB);
        snowLoads_CB.setItems(FXCollections.observableArrayList(SnowLoadsService.getAll()));
        new AutoCompleteComboBoxListener<>(snowLoads_CB);


        articulCovers_Column.setCellValueFactory(new PropertyValueFactory<>("articul"));
        massCovers_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));
        lengthCovers_Column.setCellValueFactory(new PropertyValueFactory<>("length"));
        heightCovers_Column.setCellValueFactory(new PropertyValueFactory<>("height"));
        widthCovers_Column.setCellValueFactory(new PropertyValueFactory<>("width"));

        coverList = CoverService.getAll();

        covers_TableView.setItems(FXCollections.observableArrayList(coverList));


        length_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverLength(coverList)));
        height_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverHeight(coverList)));
        width_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverWidth(coverList)));

        articulCables_Column.setCellValueFactory(new PropertyValueFactory<>("articul_new"));
        diametrCabeles_Column.setCellValueFactory(new PropertyValueFactory<>("diametr"));
        massCables_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));
        voltageCables_Column.setCellValueFactory(new PropertyValueFactory<>("voltage"));


        cablesList = CablesService.getAll();

        cables_TableView.setItems(FXCollections.observableArrayList(cablesList));

        massCables_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCablesMass(cablesList)));

        choseCablesArticul_Column.setCellValueFactory(new PropertyValueFactory<>("articul"));
        massChoseCables_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));


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

    public void updateCablesTable() {
        List<Cables> filteredList = getFilteredList(cablesList, massCables_CB);
        cables_TableView.setItems(FXCollections.observableArrayList(filteredList));
    }


    private ArrayList<Integer> makeUniqueAndSortCablesMass(List<Cables> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cables cables : notUniqueList) {
            if (!arrayList.contains(cables.getMass())) arrayList.add(cables.getMass());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }

    public void regionChose(ActionEvent actionEvent) {
        cities_CB.setValue(null);
    }

    public void test_Click(ActionEvent actionEvent) {
        cover_Pane.setVisible(true);
    }


    public void massCablesChose(ActionEvent actionEvent) {
        updateCablesTable();
    }


    public void clearNumberOfCores_CB(ActionEvent actionEvent) {
        massCables_CB.setValue(null);
        updateCablesTable();
    }

    public void cabelChose(ActionEvent actionEvent) {
        List<Cables> choseCables = choseCables_TableView.getItems();
        choseCables.add(cables_TableView.getSelectionModel().getSelectedItem());
    }

    public void deleteChosenCable(ActionEvent actionEvent) {
        List<Cables> choseCables = choseCables_TableView.getItems();
        choseCables.remove(choseCables_TableView.getSelectionModel().getSelectedItem());
    }

    public void goToCovers_Press(ActionEvent actionEvent) {
        if (!choseCables_TableView.getItems().isEmpty()) {
            SingleSelectionModel<Tab> selectionModel = mainTabPane.getSelectionModel();
            selectionModel.select(choseCover_Tab);
        }
    }


    public void updateCoversTable() {
        List<Cover> filteredList = getFilteredList(coverList, length_CB.getValue(), width_CB.getValue(), height_CB.getValue());
        covers_TableView.setItems(FXCollections.observableList(filteredList));
    }


    private ArrayList<Integer> makeUniqueAndSortCoverLength(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getLength())) arrayList.add(cover.getLength());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }

    private ArrayList<Integer> makeUniqueAndSortCoverHeight(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getHeight())) arrayList.add(cover.getHeight());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }

    private ArrayList<Integer> makeUniqueAndSortCoverWidth(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getWidth())) arrayList.add(cover.getWidth());
        }
        arrayList.sort(Integer::compareTo);
        return arrayList;
    }


    public void coverChose(ActionEvent actionEvent) {
        Cover curCover = covers_TableView.getSelectionModel().getSelectedItem();
        if (curCover != null) {
            choseCover = curCover;
        }
    }

    public void heightChose(ActionEvent actionEvent) {
        updateCoversTable();
    }

    public void widthChose(ActionEvent actionEvent) {
        updateCoversTable();
    }

    public void lengthChose(ActionEvent actionEvent) {
        updateCoversTable();
    }


    public void clearHeight_CB(ActionEvent actionEvent) {
        height_CB.setValue(null);
        updateCoversTable();
    }

    public void clearWidth_CB(ActionEvent actionEvent) {
        width_CB.setValue(null);
        updateCoversTable();
    }

    public void clearLength_CB(ActionEvent actionEvent) {
        length_CB.setValue(null);
        updateCoversTable();
    }


}