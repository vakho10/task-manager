package ge.edu.sangu.tasklist;

import ge.edu.sangu.tasklist.service.Process;
import ge.edu.sangu.tasklist.service.TasklistService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TableView<Process> tableView;

    private TasklistService tasklistService = new TasklistService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshTable();
    }

    public void refreshTable() {
        TableColumn<ge.edu.sangu.tasklist.service.Process, String> imageName = new TableColumn<>("Image Name");
        imageName.setCellValueFactory(new PropertyValueFactory<>("imageName"));

        TableColumn<ge.edu.sangu.tasklist.service.Process, Integer> pid = new TableColumn<>("PID");
        pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        TableColumn<ge.edu.sangu.tasklist.service.Process, String> sessionName = new TableColumn<>("Session Name");
        sessionName.setCellValueFactory(new PropertyValueFactory<>("sessionName"));
        TableColumn<ge.edu.sangu.tasklist.service.Process, Integer> sessionIdentifier = new TableColumn<>("Session Identifier");
        sessionIdentifier.setCellValueFactory(new PropertyValueFactory<>("sessionIdentifier"));
        TableColumn<Process, String> memoryUsage = new TableColumn<>("Memory Usage");
        memoryUsage.setCellValueFactory(new PropertyValueFactory<>("memoryUsage"));

        tableView.getColumns().setAll(imageName, pid, sessionName, sessionIdentifier, memoryUsage);

        List<Process> processList;
        try {
            processList = tasklistService.listProcesses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObservableList<Process> processes = FXCollections.observableArrayList(processList);
        tableView.setItems(processes);
    }
}