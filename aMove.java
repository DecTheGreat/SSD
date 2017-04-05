package application;

import javafx.scene.layout.VBox;

public class aMove {
	VBox source, destination;
	public aMove(VBox source, VBox destination) {
		this.source=source;
		this.destination = destination;
	}


	public VBox getSource() {
		return source;
	}
	public void setSource(VBox source) {
		this.source = source;
	}
	public VBox getDestination() {
		return destination;
	}
	public void setDestination(VBox destination) {
		this.destination = destination;
	}
}