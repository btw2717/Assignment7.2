import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Scene;

import javax.swing.*;


public class WeekDayDriver extends Application{
    WeekDay test = new WeekDay("Monday");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> choices = new ArrayList<>();
        choices.add("Set the day");
        choices.add("Print the day");
        choices.add("Get the day");
        choices.add("Get the next day");
        choices.add("Get the previous day");
        choices.add("Add a number of days and find out what day it will be");
        choices.add("Subtract a number of days and find out what day it was");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Choose an operation to perform", choices);

        dialog.setTitle("What to do");
        dialog.setHeaderText("What would you like to do?");
        dialog.setContentText("Please choose an action");


        int count = 0;
        loop: do {

            Optional<String> selection = dialog.showAndWait();

            if (selection.isPresent()) {
                String selected = selection.get();
                switch (selected) {
                    case "Please choose an action":
                        Alert noAction = new Alert(Alert.AlertType.INFORMATION);
                        noAction.setHeaderText("Please choose an action");
                        noAction.showAndWait();
                        break;
                    case "Set the day":
                        String name = JOptionPane.showInputDialog(null, "Enter the day you want");
                        test.setDay(name);
                        break;
                    case "Print the day":
                        JOptionPane.showMessageDialog(null, test.toString());
                        break;
                    case "Get the day":
                        JOptionPane.showMessageDialog(null, test.getDay());
                        break;
                    case "Get the next day":
                        JOptionPane.showMessageDialog(null, test.calculateDay(1));
                        break;
                    case "Get the previous day":
                        JOptionPane.showMessageDialog(null, test.calculateDay(-1));
                        break;
                    case "Add a number of days and find out what day it will be":
                        String numOfDays = JOptionPane.showInputDialog(null, "Enter the number of days you want to add:");
                        int numOfDays1 = Integer.parseInt(numOfDays);
                        JOptionPane.showMessageDialog(null, "The resultant day will be: " + test.calculateDay(numOfDays1));
                        break;
                    case "Subtract a number of days and find out what day it was":
                        String numOfDays2 = JOptionPane.showInputDialog(null, "Enter the number of days you want to subtract with a negative sign:");
                        int numOfDays3 = Integer.parseInt(numOfDays2);
                        JOptionPane.showMessageDialog(null, "The resultant day will be: " + test.calculateDay(numOfDays3));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "yolo");
                }
                count++;
            } else {
                JOptionPane.showMessageDialog(null, test.toString());
                break loop;

            }
        }while(choices != null);
    }

}
