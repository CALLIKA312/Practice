import controllerUtils.AutoCompleteComboBoxListener;
import controllerUtils.CollectionsUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.*;
import services.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Controller {


    public TabPane mainTabPane;
    public Tab Cable_Tab;
    public Tab Cover_Tab;

    public TableView<Cables> cables_TableView;
    public TableColumn<Cables, String> articulCables_Column;
    public TableColumn<Cables, Integer> diametrCabeles_Column;
    public TableColumn<Cables, Integer> massCables_Column;
    public TableColumn<Cables, String> voltageCables_Column;


    public ComboBox<String> articulCables_CB;
    public ComboBox<Integer> massCables_CB;

    public TableView<Cables> choseCables_TableView;
    public TableColumn<Cables, String> choseCablesArticul_Column;
    public TableColumn<Cables, Integer> massChoseCables_Column;


    public TableView<Cover> covers_TableView;
    public TableColumn<Cover, Integer> articul_newCovers_Column;
    public TableColumn<Cover, Integer> massCovers_Column;
    public TableColumn<Cover, String> lengthCovers_Column;
    public TableColumn<Cover, Integer> typeCovers_Column;
    public TableColumn<Cover, Integer> widthCovers_Column;

    public ComboBox<Integer> length_CB;
    public ComboBox<Integer> width_CB;
    public ComboBox<Integer> type_CB;

    public Pane selectedCover_Pane;
    public Label title_newCover_Label;
    public Label formOfCover_Label;
    public Label articul_newCover_Label;

    public Tab Trays_Tab;

    public TableColumn<Trays, String> articul_newTrays_Column;
    public TableColumn<Trays, Integer> heightTrays_Column;
    public TableColumn<Trays, Integer> widthTrays_Column;
    public TableColumn<Trays, Integer> lengthTrays_Column;
    public TableColumn<Trays, Integer> massTrays_Column;
    public TableColumn<Trays, String> suitabilityTrays_Column;


    public ComboBox<Cities> cities_CB;
    public Label region_Label;
    public ComboBox<SnowLoads> snowLoads_CB;
    public Button chooseCity_Button;
    public TableView<Trays> trays_TableView;
    public HBox city_HBox;
    public Label snowLoad_Label;
    public Label snowLoadTitle_Label;
    public VBox calculating_VBox;


    List<Regions> regionsList;
    Cover choseCover = null;
    List<Cover> coverList;
    List<Cables> cablesList;
    List<Trays> traysList;
    List<TraysLoad> traysLoadList;

    @FXML
    public void initialize() {


        regionsList = RegionsService.getAll();

        cities_CB.setItems(FXCollections.observableArrayList(CitiesService.getAll()));
        new AutoCompleteComboBoxListener<>(cities_CB);
        snowLoads_CB.setItems(FXCollections.observableArrayList(SnowLoadsService.getAll()));

        articulCables_Column.setCellValueFactory(new PropertyValueFactory<>("articul"));
        diametrCabeles_Column.setCellValueFactory(new PropertyValueFactory<>("diametr"));
        massCables_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));
        voltageCables_Column.setCellValueFactory(new PropertyValueFactory<>("voltage"));

        cablesList = CablesService.getAll();
        cables_TableView.setItems(FXCollections.observableArrayList(cablesList));

        massCables_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCablesMass(cablesList)));
        new AutoCompleteComboBoxListener<>(massCables_CB);
        articulCables_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCablesArticul(cablesList)));
        new AutoCompleteComboBoxListener<>(articulCables_CB);


        choseCablesArticul_Column.setCellValueFactory(new PropertyValueFactory<>("articul"));
        massChoseCables_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));


        articul_newCovers_Column.setCellValueFactory(new PropertyValueFactory<>("articul_new"));
        massCovers_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));
        lengthCovers_Column.setCellValueFactory(new PropertyValueFactory<>("length"));
        typeCovers_Column.setCellValueFactory(new PropertyValueFactory<>("type"));
        widthCovers_Column.setCellValueFactory(new PropertyValueFactory<>("width"));

        coverList = CoverService.getAll();

        covers_TableView.setItems(FXCollections.observableArrayList(coverList));


        length_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverLength(coverList)));
        new AutoCompleteComboBoxListener<>(length_CB);
        type_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverType(coverList)));
        new AutoCompleteComboBoxListener<>(type_CB);
        width_CB.setItems(FXCollections.observableArrayList(makeUniqueAndSortCoverWidth(coverList)));
        new AutoCompleteComboBoxListener<>(width_CB);

        traysLoadList = TraysLoadService.getAll();

        traysList = TraysService.getAll();
        articul_newTrays_Column.setCellValueFactory(new PropertyValueFactory<>("articul_new"));
        heightTrays_Column.setCellValueFactory(new PropertyValueFactory<>("height"));
        widthTrays_Column.setCellValueFactory(new PropertyValueFactory<>("width"));
        lengthTrays_Column.setCellValueFactory(new PropertyValueFactory<>("length"));
        massTrays_Column.setCellValueFactory(new PropertyValueFactory<>("mass"));
        suitabilityTrays_Column.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().suitability)));


    }

    public void citiesChose(ActionEvent actionEvent) {
        int regionId = cities_CB.getValue().getRegion_id();
        for (Regions region : regionsList) {
            if (region.getId() == regionId) {
                snowLoads_CB.setValue(snowLoads_CB.getItems().get(cities_CB.getValue().getSnowarea() - 1));
                region_Label.setText(region.getName());
                snowLoad_Label.setText(snowLoads_CB.getValue().getLoad_n() + " Па");
                snowLoadTitle_Label.setVisible(true);
                snowLoad_Label.setVisible(true);
                calculating_VBox.setDisable(false);
                return;
            }
        }
    }


    public void regionChose(ActionEvent actionEvent) {
        /*cities_CB.setValue(null);
        snowLoad_Label.setText(snowLoads_CB.getValue().getLoad_n() + " Па");
        snowLoadTitle_Label.setVisible(true);
        snowLoad_Label.setVisible(true);
        calculating_VBox.setDisable(false);*/
    }


    public void updateCablesTable() {
        List<Cables> filteredList = CollectionsUtil.getFilteredListOfCables(cablesList, articulCables_CB.getValue(), massCables_CB.getValue());
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


    private ArrayList<String> makeUniqueAndSortCablesArticul(List<Cables> notUniqueList) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Cables cables : notUniqueList) {
            if (!arrayList.contains(cables.getArticul())) arrayList.add(cables.getArticul());
        }
        arrayList.sort(String::compareTo);
        return arrayList;
    }


    public void massCablesChose(ActionEvent actionEvent) {
        if (massCables_CB.getValue() != null) updateCablesTable();
    }


    public void clearMassCables_CB(ActionEvent actionEvent) {
        massCables_CB.setValue(null);
        updateCablesTable();
    }

    public void articulCablesChose(ActionEvent actionEvent) {
        updateCablesTable();
    }

    public void clearArticulCables_CB(ActionEvent actionEvent) {
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
        if (choseCables_TableView.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Предупреждение");
            alert.setHeaderText("Сначала нужно выбрать один или несколько проводов");
            alert.showAndWait();
        } else {
            SingleSelectionModel<Tab> selectionModel = mainTabPane.getSelectionModel();
            selectionModel.select(Cover_Tab);
            Cover_Tab.setDisable(false);
        }
    }


    public void updateCoversTable() {
        List<Cover> filteredList = CollectionsUtil.getFilteredListOfCovers(coverList, type_CB.getValue(), width_CB.getValue(), length_CB.getValue());
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

    private ArrayList<Integer> makeUniqueAndSortCoverType(List<Cover> notUniqueList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Cover cover : notUniqueList) {
            if (!arrayList.contains(cover.getType())) arrayList.add(cover.getType());
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
            title_newCover_Label.setText(choseCover.getTitle_new());
            formOfCover_Label.setText(String.valueOf(choseCover.getType()));
            articul_newCover_Label.setText(choseCover.getArticul_new());
            selectedCover_Pane.setVisible(true);
            city_HBox.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Предупреждение");
            alert.setHeaderText("Сначала нужно выбрать крышку для лотка");
            alert.showAndWait();
        }
    }


    public void typeChose(ActionEvent actionEvent) {
        updateCoversTable();
    }


    public void widthChose(ActionEvent actionEvent) {
        updateCoversTable();
    }

    public void lengthChose(ActionEvent actionEvent) {
        updateCoversTable();
    }

    public void clearType_CB(ActionEvent actionEvent) {
        type_CB.setValue(null);
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


    boolean isCityLocked = false;

    public void choseCityLock(ActionEvent actionEvent) {
        if (isCityLocked) {
            isCityLocked = false;
            cities_CB.setEditable(true);
            snowLoads_CB.setEditable(true);
            chooseCity_Button.setText("Choose city");
        } else {
            isCityLocked = true;
            cities_CB.setEditable(false);
            snowLoads_CB.setEditable(false);
            chooseCity_Button.setText("Unlocked choose");
        }

    }


    public void calculatingBestTrays(ActionEvent actionEvent) {
        if (choseCables_TableView.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Предупреждение");
            alert.setHeaderText("Сначала нужно выбрать один или несколько проводов");
            alert.showAndWait();
        } else if (choseCover == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Предупреждение");
            alert.setHeaderText("Сначала нужно выбрать крышку для лотка");
            alert.showAndWait();
        } else {

            List<Trays> filteredList = CollectionsUtil.getFilteredListOfTrays(traysList, choseCover.getLength(), choseCover.getWidth(), choseCover.getThickness());

            double snowFactor = 0;
            int coverType = choseCover.getType();
            switch (coverType) {
                case 201:
                case 215:
                    snowFactor = 1;
                    break;
                case 204:
                case 219:
                    snowFactor = 0.85;
                    break;
                case 220:
                    snowFactor = 0.45;
                    break;
            }
            double cablesLoadPart = 0;
            double snowLoadPart = (double) snowLoads_CB.getValue().getLoad_n() * snowFactor * ((double) choseCover.getLength() / 1000) * ((double) choseCover.getWidth() / 1000) / 100;
            for (Cables cables : choseCables_TableView.getItems()) {
                cablesLoadPart += (double) cables.getMass() * 9.8 * ((double) choseCover.getLength() / 1000) / 1000;
            }
            double coverLoadPart = choseCover.getMass() * 9.8;

            double realCriticalLoad = snowLoadPart + cablesLoadPart + coverLoadPart;


            ArrayList<Trays> resultTrays = new ArrayList<>();

            for (Trays trays : filteredList) {
                int height = trays.getHeight();
                TraysLoad curTraysLoad = CollectionsUtil.getFilteredListOfTraysLoad(traysLoadList, trays.getType(), choseCover.getLength() / 1000, trays.getThickness());
                //System.out.println(curTraysLoad);
                if (curTraysLoad == null) continue;
                double curLoad = 0;
                switch (height) {
                    case 25:
                        curLoad = curTraysLoad.getHi25();
                        break;
                    case 40:
                        curLoad = curTraysLoad.getHi40();
                        break;
                    case 50:
                        curLoad = curTraysLoad.getHi50();
                        break;
                    case 60:
                        curLoad = curTraysLoad.getHi60();
                        break;
                    case 75:
                        curLoad = curTraysLoad.getHi75();
                        break;
                    case 85:
                        curLoad = curTraysLoad.getHi85();
                        break;
                    case 100:
                        curLoad = curTraysLoad.getHi100();
                        break;
                    case 110:
                        curLoad = curTraysLoad.getHi110();
                        break;
                    case 120:
                        curLoad = curTraysLoad.getHi120();
                        break;
                    case 150:
                        curLoad = curTraysLoad.getHi150();
                        break;
                    case 160:
                        curLoad = curTraysLoad.getHi160();
                        break;
                    case 200:
                        curLoad = curTraysLoad.getHi200();
                        break;
                    case 70:
                        curLoad = curTraysLoad.getHi70();
                        break;
                    case 80:
                        curLoad = curTraysLoad.getHi80();
                        break;
                    case 125:
                        curLoad = curTraysLoad.getHi125();
                        break;
                    case 175:
                        curLoad = curTraysLoad.getHi175();
                        break;
                }

                curLoad *= 1000;
                if (curLoad == 0) continue;
                resultTrays.add(trays);
                trays.suitability = realCriticalLoad / 0.7 / curLoad * 100;

            }

            resultTrays.sort((x, y) -> (x.suitability < y.suitability) ? 1 : ((x.suitability == y.suitability) ? 0 : -1));

            trays_TableView.setItems(FXCollections.observableArrayList(resultTrays));
            SingleSelectionModel<Tab> selectionModel = mainTabPane.getSelectionModel();
            selectionModel.select(Trays_Tab);
            Trays_Tab.setDisable(false);
        }
    }


}