import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button hello, howdy, chinese, clear, exit, tagalog;
	private Label appLabel;
	private TextField appText;
	
	//  declare two HBoxes
	private HBox hBox1, hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dm;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Howdy");
		clear = new Button("Clear");
		exit = new Button("Exit");
		//Added optional button
		tagalog = new Button ("Tagalog");
		
		appLabel = new Label("Feedback: ");
		appText = new TextField();
		
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		
		//  set margins and set alignment of the components
		HBox.setMargin(hello, new Insets(5));
		HBox.setMargin(howdy, new Insets(5));
		HBox.setMargin(chinese, new Insets(5));
		HBox.setMargin(tagalog, new Insets(5));
		HBox.setMargin(clear, new Insets(5));
		HBox.setMargin(exit, new Insets(5));
		
		
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBox1.getChildren().addAll(appLabel, appText);
		
		//  add the buttons to the other HBox
		hBox2.getChildren().addAll(hello, howdy, chinese, tagalog, clear, exit);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBox1, hBox2);
		
		//Setting the actions for each button
		hello.setOnAction(new ButtonHandler());
		howdy.setOnAction(new ButtonHandler());
		chinese.setOnAction(new ButtonHandler());
		tagalog.setOnAction(new ButtonHandler());
		clear.setOnAction(new ButtonHandler());
		exit.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget() == hello) {
				appText.setText(dm.getHello());
			} else if (event.getTarget() == howdy) {
				appText.setText(dm.getHowdy());
			} else if (event.getTarget() == chinese) {
				appText.setText(dm.getChinese());
			} else if (event.getTarget() == tagalog) {
				appText.setText(dm.getTagalog());
			} else if (event.getTarget() == clear) {
				appText.setText("");
			} else if (event.getTarget() == exit) {
				Platform.exit();
				System.exit(0);		
		}
	}
}
}