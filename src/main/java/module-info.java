module ru.gb.dailyplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.dailyplanner to javafx.fxml;
    exports ru.gb.dailyplanner;
    exports ru.gb.dailyplanner.controllers;
    opens ru.gb.dailyplanner.controllers to javafx.fxml;
}