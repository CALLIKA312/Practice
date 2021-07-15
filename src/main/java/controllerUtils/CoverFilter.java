package controllerUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.Cover;

import java.util.ArrayList;

public class CoverFilter {
    private TableView<Cover> tableView;
    private ObservableList<Cover> data;
    private int constructionValue;
    private int massValue;

    private boolean ignoreConstructionValue = true;
    private boolean ignoreMassValue = true;

    public CoverFilter() {
    }

    public TableView<Cover> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Cover> tableView) {
        this.tableView = tableView;
        this.data = tableView.getItems();
    }

    public ObservableList<Cover> getData() {
        return data;
    }

    public void setData(ObservableList<Cover> data) {
        this.data = data;
    }

    public int getConstructionValue() {
        return constructionValue;
    }

    public void setConstructionValue(int constructionValue) {
        this.constructionValue = constructionValue;
    }

    public void setConstructionValueWithUpdate(int constructionValue) {
        this.constructionValue = constructionValue;
        ignoreConstructionValue = constructionValue == Integer.MAX_VALUE;
    }

    public int getMassValue() {
        return massValue;
    }

    public void setMassValue(int massValue) {
        this.massValue = massValue;
    }

    public void setMassValueWithUpdate(int massValue) {
        this.massValue = massValue;
        ignoreMassValue = massValue == Integer.MAX_VALUE;
    }


}
