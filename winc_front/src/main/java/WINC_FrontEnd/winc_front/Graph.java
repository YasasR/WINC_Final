package WINC_FrontEnd.winc_front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graph extends Application {

	Service service = Service.getServiceInstance();
	Exhibit[] exhibits;
	boolean changed = false;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		exhibits = service.getAllExhbitsCount();
		
		Thread t = new Thread(() -> {
			try {
				while (true) {
					updateExhibits(service.getAllExhbitsCount());
					for (Exhibit ex : exhibits)
						// System.out.println(ex.toString());
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		t.start();

		primaryStage.setTitle("Exhibits");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle("Current Population Summary");
		xAxis.setLabel("Exhibit");
		yAxis.setLabel("Count");
		bc.setAnimated(false);
		
		Scene scene = new Scene(bc, 1366, 768);
		
		XYChart.Series[] series = new XYChart.Series[exhibits.length];
		
		for (int i = 0; i < exhibits.length; i++) {
			series[i] = new XYChart.Series();
			series[i].setName(exhibits[i].getName());
			series[i].getData().add(new XYChart.Data(Integer.toString(exhibits[i].getId()), exhibits[i].getCount()));
			bc.getData().add(series[i]);
		}
		
		primaryStage.setScene(scene);
		primaryStage.show();

		// Animating the data in barchart
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), (ActionEvent actionEvent) -> {
			
			if (changed) {
				
				for (int i = 0; i < exhibits.length; i++) {
					series[i].getData().remove(0);
					series[i].getData().add(new XYChart.Data(Integer.toString(exhibits[i].getId()), exhibits[i].getCount()));
//					series[i].getData().set(0, new XYChart.Data(Integer.toString(exhibits[i].getId()), exhibits[i].getCount()));
				}
				this.changed = false;
			}
		}));

		timeline.setCycleCount(2000);
		timeline.setAutoReverse(true);
		timeline.play();

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public synchronized void updateExhibits(Exhibit[] exhibit) {
		if(!this.exhibits.equals(exhibit)) {
			this.exhibits = exhibit;
			this.changed = true;
		}
	}

}
