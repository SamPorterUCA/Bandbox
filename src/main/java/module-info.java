module org.summer26.section1.group8.bandbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker to javafx.fxml, javafx.base;
    opens org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator to javafx.fxml, javafx.base;
    opens org.summer26.section1.group8.bandbox.Mona_2320239.CleaningWorker.ModelClass to javafx.fxml, javafx.base;
    opens org.summer26.section1.group8.bandbox.Mona_2320239.SystemAdministrator.ModelClass to javafx.fxml, javafx.base;
    opens org.summer26.section1.group8.bandbox to javafx.fxml;
    exports org.summer26.section1.group8.bandbox;
}