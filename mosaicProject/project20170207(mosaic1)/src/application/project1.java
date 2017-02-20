package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class project1 extends Application {

	public static FlowPane flowbox()
	{
		FlowPane section = new FlowPane();
		
		Pane x=new Pane();
		x.setBackground(new Background(new BackgroundFill(Color.GREEN, null,new Insets(5))));
		//x.setAlignment(Pos.TOP_LEFT);
		//x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setMinHeight(20);
		x.setMinWidth(20);
		
		
		Label y= new Label(" ");
		y.setBackground(new Background(new BackgroundFill(Color.YELLOW,null,new Insets(5))));
		//y.setAlignment(Pos.TOP_CENTER);
		//y.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		y.setMinHeight(20);
		y.setMinWidth(20);
		
		Label z=new Label(" ");
		z.setBackground(new Background(new BackgroundFill(Color.GOLDENROD,null,new Insets(5))));
		//z.setAlignment(Pos.TOP_RIGHT);
		//z.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		z.setMinHeight(20);
		z.setMinWidth(20);
		section.getChildren().addAll(x,y,z);
		
		return section;

	}
	@SuppressWarnings("static-access")
	public static VBox verticalBox1()
	{
		Label section1 = new Label(" ");
		section1.setBackground(new Background(new BackgroundFill(Color.BLUE, null,null)));
		section1.setAlignment(Pos.CENTER);
		section1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		section1.setPrefHeight(100);
		section1.setPrefWidth(100);
		
		Label section2 = new Label(" ");
		section2.setBackground(new Background(new BackgroundFill(Color.BISQUE, null,null)));
		section2.setAlignment(Pos.CENTER);
		section2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		section2.setPrefHeight(100);
		section2.setPrefWidth(100);
		
		FlowPane section3 = new FlowPane();
		section3 = flowbox();
		section3.setBackground(new Background(new BackgroundFill(Color.GREY, null,null)));
		section3.setAlignment(Pos.TOP_CENTER);
		section3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		section3.setPrefHeight(100);
		section3.setPrefWidth(100);
		
		VBox vb = new VBox();
		vb.getChildren().addAll(section1,section2,section3);
		
		//vb.setMinHeight(100);
		vb.prefWidth(100);
		VBox.setVgrow(section3, Priority.ALWAYS);
		VBox.setVgrow(section1, Priority.ALWAYS);
		VBox.setVgrow(section2, Priority.ALWAYS);
		return vb;
	}
	public static GridPane gridBox()
	{
		GridPane gp = new GridPane();
		Pane  x;
		
		for(int r = 0; r<8;r++)
			for(int c = 1; c<=8; c++)
			{
				x=new Pane();
				x.setMinSize(5,5);
				x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				if((r+c)%2==0)
				{
					x.setBackground(new Background(new BackgroundFill(Color.BLACK, null,null)));
				}
				else
				{
					x.setBackground(new Background(new BackgroundFill(Color.WHITE, null,null)));				
				}
				gp.add(x, c, r);
				GridPane.setVgrow(x, Priority.ALWAYS);
				GridPane.setHgrow(x, Priority.ALWAYS);
				
			}
		
		gp.setPrefHeight(150);
		return gp;
		
	}
	
	public static BorderPane borderB()
	{
		BorderPane bp = new BorderPane();
		Label x;
		
		bp.setTop(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.GREEN,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefHeight(30);
		
		bp.setRight(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.GREEN,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefWidth(30);
		
		bp.setBottom(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.GREEN,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefHeight(30);
		
		bp.setLeft(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.GREEN,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefWidth(30);
		
		Pane y;
		GridPane gp = new GridPane();
		for(int r = 0; r<2;r++)
			for(int c = 1; c<=2; c++)
			{
				y=new Pane();
				if((r+c)%2==0)
				{
					y.setBackground(new Background(new BackgroundFill(Color.BISQUE, null,null)));
				}
				else
				{
					y.setBackground(new Background(new BackgroundFill(Color.YELLOW, null,null)));				
				}
				gp.add(y, c, r);
				GridPane.setHgrow(y,Priority.ALWAYS);
				GridPane.setVgrow(y,Priority.ALWAYS);
			}
		
		bp.setCenter(gp);
		
//		x.setAlignment(Pos.CENTER);
//		x.setBackground(new Background(new
//		BackgroundFill(Color.CYAN, new CornerRadii(4),new
//		Insets(3))));
//		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		x.setPrefHeight(50);
		
		//bp.setMinHeight(150);
		bp.setPrefHeight(150);
		
		return bp;
	}
	@SuppressWarnings("static-access")
	public static VBox verticalBox()
	{
		VBox vb = new VBox();
		
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
		
		bp = borderB();
		gp = gridBox();
		
		vb.getChildren().addAll(bp,gp);
		//vb.setMinWidth(100);
		vb.setPrefWidth(100);
		
		VBox.setVgrow(bp,Priority.ALWAYS);
		VBox.setVgrow(gp,Priority.ALWAYS);

		return vb;
		
	}
	
	public static BorderPane borderBox()
	{
		BorderPane bp = new BorderPane();
		Label x;
		
		bp.setTop(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.RED,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefHeight(50);
		
		bp.setRight(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new
		BackgroundFill(Color.PINK, null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefWidth(10);
		
		bp.setBottom(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.YELLOW,
		null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefHeight(50);
		
		bp.setLeft(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefWidth(10);
		
		bp.setCenter(x=new Label(""));
		x.setAlignment(Pos.CENTER);
		x.setBackground(new Background(new
		BackgroundFill(Color.CYAN, null,null)));
		x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		x.setPrefHeight(100);
		
		bp.setPrefWidth(100);
		//bp.setMinWidth(100);
		
		return bp;

	}
	@Override
	public void start(Stage p) throws Exception {
		// TODO Auto-generated method stub
		BorderPane box1 = new BorderPane();
		VBox box2 = new VBox();
		VBox box3 = new VBox();
		
		box1 = borderBox();
		box2 = verticalBox();
		box3 = verticalBox1();
		
		HBox root = new HBox();
		root.getChildren().addAll(box1,box2,box3);
		HBox.setHgrow(box1, Priority.ALWAYS);
		HBox.setHgrow(box2,Priority.ALWAYS);
		HBox.setHgrow(box3, Priority.ALWAYS);
		
		root.setAlignment(Pos.CENTER);
		Scene s=new Scene(root,300,300);
		p.setScene(s);
		p.setTitle("Mosaic1");
		p.show();

		
		
	}
	public static void main(String []args)
	{
		launch(args);
	}

}
