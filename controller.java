package application;

import java.util.ArrayList;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class controller {

	@FXML
	public VBox tower1, tower2, tower3, bricksStorage, source, destination,undo,inside;
	@FXML
	public ComboBox<Integer> bricksInPlay;
	@FXML
	public Label Brick;
	@FXML
	public Button tower1button, tower2button, tower3button;
	@FXML
	public VBox splash;
	@FXML
	public Label movecount,errorMessage;
	int moves=0;
	boolean buttonclick1, buttonclick2, buttonclick3;
	Stack<aMove> movesList = new Stack<aMove>();
	double origX, origY, deltaX, deltaY;
	
	public Label dragBrick;
	
	public void initBricks() {
		for (int i = 0; i < tower1.getChildren().size(); i++) {

			((Label) tower1.getChildren().get(i)).setPrefWidth((i) * 10);

		}
	}


	public void initialize() {
		ArrayList<Integer> bricksList = new ArrayList<Integer>(1);
		bricksList.add(1);
		bricksList.add(2);
		bricksList.add(3);
		bricksList.add(4);
		bricksList.add(5);
		bricksList.add(6);
		bricksList.add(7);
		bricksList.add(8);
		ObservableList<Integer> obList = FXCollections.observableList(bricksList);
		bricksInPlay.setItems(obList);
		bricksInPlay.setValue(8);

	}
	
	
	public void ontower1MousePressed(MouseEvent event)
	{


		dragBrick = (Label) tower1.getChildren().get(0);
		
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();
		
	}
	public void onTower1MouseDragged(MouseEvent event)
	{

		
		dragBrick.setTranslateX(event.getSceneX() - deltaX);
		dragBrick.setTranslateY(event.getSceneY() - deltaY);
		
		if (tower2.contains(tower2.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {

			inside = tower2;
		}
		else if (tower3.contains(tower3.sceneToLocal(new Point2D(event.getSceneX(),event.getSceneY()))))
		{
			inside = tower3;
		}			
	}
	
	public void onTower1MouseReleased(MouseEvent event)
	{
		dragBrick.setTranslateX(0);
		dragBrick.setTranslateY(0);
		if (inside!= null)
		{
			source = tower1;
			destination = inside;
			moveBrick();
		}
	}
	public void ontower2MousePressed(MouseEvent event)
	{
		dragBrick = (Label) tower2.getChildren().get(0);
		
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();
		
	}
	public void onTower2MouseDragged(MouseEvent event)
	{
		dragBrick.setTranslateX(event.getSceneX() - deltaX);
		dragBrick.setTranslateY(event.getSceneY() - deltaY);
		
		if ( tower1.contains(tower1.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()))))
		{
			inside = tower1;
		}
		else if (tower3.contains(tower3.sceneToLocal(new Point2D(event.getSceneX(),event.getSceneY()))))
		{
			inside = tower3;
		}
	}
	public void onTower2MouseReleased(MouseEvent event)
	{
		dragBrick.setTranslateX(0);
		dragBrick.setTranslateY(0);
		if (inside!= null)
		{
			source = tower2;
			destination = inside;
			moveBrick();
		}
	}
	public void ontower3MousePressed(MouseEvent event)
	{
		dragBrick = (Label) tower3.getChildren().get(0);
		
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();
	}
	public void onTower3MouseDragged(MouseEvent event)
	{
		dragBrick.setTranslateX(event.getSceneX() - deltaX);
		dragBrick.setTranslateY(event.getSceneY() - deltaY);
		
		if ( tower1.contains(tower1.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()))))
		{
			inside = tower1;
		}
		else if (tower2.contains(tower2.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			
			inside = tower2;
		}	
	}
	
	public void onTower3MouseReleased(MouseEvent event)
	{
		dragBrick.setTranslateX(0);
		dragBrick.setTranslateY(0);
		if (inside!= null)
		{
			source = tower3;
			destination = inside;
			moveBrick();
		}
	}	
	public void moveBrick()
	{
		if (destination.getChildren().size() == 0 || ((Label) destination.getChildren().get(0))
				.getWidth() > ((Label) source.getChildren().get(0)).getWidth())
		{
		destination.getChildren().add(0,source.getChildren().get(0));
		moveList();
		}
	}
	public void undoMove()
	{

		if(moves==0){
			moves=0;
			errorMessage.setText("There are no more moves to undo");
		}
		else{
		(movesList.peek().getSource()).getChildren().add(0,(movesList.peek().getDestination()).getChildren().get(0));
		movesList.pop();
		moves--;
		}
		
		movecount.setText(""+moves);
			
	}
	
	public void moveList ()
	{
		
		aMove move = new aMove(source, destination);
		movesList.push(move);
		
	}

	public void buttonClick1(MouseEvent e) {

		if (buttonclick2 == true) {
			
				source = tower2;
				destination=tower1;
				moveBrick();

				buttonclick2 = false;
				tower2button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
			
			

		} else if (buttonclick3 == true) {
			
				source = tower3;
				destination = tower1;
				moveBrick();
				
				buttonclick3 = false;
				tower3button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
				
			
		} else if (buttonclick1 == true) {
			buttonclick1 = false;
			tower1button.setTextFill(Color.BLACK);
		} else {
			buttonclick1 = true;
			tower1button.setTextFill(Color.CHARTREUSE);
		}
		
	}

	public void buttonClick2(MouseEvent e) {
		if (buttonclick3 == true) {
			
				source=tower3;
				destination=tower2;
				moveBrick();
				
				
				buttonclick3 = false;
				tower3button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
				
			
		} else if (buttonclick1 == true) {
			
				source=tower1;
				destination=tower2;
				moveBrick();
				
				
				buttonclick1 = false;
				tower1button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
				
			
		} else if (buttonclick2 == true) {
			buttonclick2 = false;
			tower2button.setTextFill(Color.BLACK);
		} else {
			buttonclick2 = true;
			tower2button.setTextFill(Color.CHARTREUSE);
		}

	}

	public void buttonClick3(MouseEvent e) {
		if (buttonclick2 == true) {
			
				source=tower2;
				destination=tower3;
				moveBrick();
			
				buttonclick2 = false;
				tower2button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
				
			
		} else if (buttonclick1 == true) {
			
				source=tower1;
				destination=tower3;
				moveBrick();
				
				buttonclick1 = false;
				tower1button.setTextFill(Color.BLACK);
				moves++;
				movecount.setText(""+moves);
				
			
		} else if (buttonclick3 == true) {
			buttonclick3 = false;
			tower3button.setTextFill(Color.BLACK);
		} else {
			buttonclick3 = true;
			tower3button.setTextFill(Color.CHARTREUSE);
		}
	}



	public void bricksdropdownclicked(ActionEvent e) {
		

		int size = tower1.getChildren().size();
		for (int i = 0; i < size; i++) {
			Label brick = (Label) tower1.getChildren().get(0);
			tower1.getChildren().remove(brick);
			bricksStorage.getChildren().add(0, brick);
		}
		size = tower2.getChildren().size();
		for (int i = 0; i < size; i++) {
			Label brick = (Label) tower2.getChildren().get(0);
			tower2.getChildren().remove(brick);
			bricksStorage.getChildren().add(0, brick);
		}
		size = tower3.getChildren().size();
		for (int i = 0; i < size; i++) {
			Label brick = (Label) tower3.getChildren().get(0);
			tower3.getChildren().remove(brick);
			bricksStorage.getChildren().add(0, brick);
		}
		String num = bricksInPlay.getSelectionModel().getSelectedItem().toString();
		int numOfBricks = Integer.parseInt(num);
		for (int i = 0; i < numOfBricks; i++) {
			Label brick = (Label) bricksStorage.getChildren().get(0);
			bricksStorage.getChildren().remove(brick);
			tower1.getChildren().add(0, brick);

		}

		for (int i = 0; i < tower1.getChildren().size(); i++) {

			((Label) tower1.getChildren().get(i)).setPrefWidth((i + 2) * 10);
			
		}
		moves=0;
		movecount.setText(""+moves);
	}

	public void startMenu(ActionEvent event) {
		splash.setVisible(false);
		
		for (int i = 0; i < tower1.getChildren().size(); i++) {

			((Label) tower1.getChildren().get(i)).setPrefWidth((i + 2) * 10);
			
		}
		moves=0;
		movecount.setText(""+moves);
	}

}
