module ge.edu.sangu.tasklist {
    requires javafx.controls;
    requires javafx.fxml;

    opens ge.edu.sangu.tasklist to javafx.fxml;
    exports ge.edu.sangu.tasklist;
    exports ge.edu.sangu.tasklist.service;
}