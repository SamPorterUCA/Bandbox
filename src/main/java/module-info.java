module org.summer26.section1.group8.bandbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.summer26.section1.group8.bandbox to javafx.fxml;
    exports org.summer26.section1.group8.bandbox;
}