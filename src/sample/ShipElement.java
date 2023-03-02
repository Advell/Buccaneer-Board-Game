package sample;

import com.google.gson.annotations.Expose;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.InputStream;

import static sample.BoardController.BOARD;
import static sample.BoardController.TILE_SIZE;

public class ShipElement extends StackPane {
    @Expose(serialize = true, deserialize = true)
    private boolean selected;

    @Expose(serialize = true, deserialize = true)
    private double currentX, currentY;

    @Expose(serialize = true, deserialize = true)
    private double mouseX, mouseY;

    @Expose(serialize = true, deserialize = true)
    private Directions direction;

    ImageView shipImage;
    //private InputStream shipPic_selected = this.getClass().getResourceAsStream("resources/ship_buccaneer_selected.png");

    public ShipElement(int xC, int yC, Directions d, InputStream shipPic) {
        //ImageView shipImageSel;
        selected = false;
        direction = d;
        move(xC, yC);
        try {
            shipImage = new ImageView();
            shipImage.setImage(new Image(shipPic));
            shipImage.setRotate(direction.degree);
            shipImage.setFitWidth(TILE_SIZE);
            shipImage.setFitHeight(TILE_SIZE);
            getChildren().add(shipImage);
            /*shipImageSel = new ImageView();
            shipImageSel.setImage(new Image(shipPic_selected));
            shipImageSel.setFitWidth(TILE_SIZE);
            shipImageSel.setFitHeight(TILE_SIZE);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOnMouseClicked(mouseEvent -> {
            BOARD[getBoardX()][getBoardY()].whenClickedOn(getBoardX(), getBoardY());
        });
        hoverProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean show) -> {
            if (show && !selected) {
                //getChildren().add(shipImageSel);
            } else {
                //getChildren().remove(shipImageSel);
            }
        });
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void move(int x, int y) {
        currentX = x * TILE_SIZE;
        currentY = y * TILE_SIZE;
        relocate(currentX, currentY);
    }

    public double getX() {
        return currentX / TILE_SIZE;
    }

    public double getY() {
        return currentY / TILE_SIZE;
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {

        return currentY;
    }

    public int getBoardX() {return toBoard(currentX);}
    public int getBoardY() {return toBoard(currentY);}

    private int toBoard(double pixel) {
        return (int) (pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    public Directions getDirection() {
        return direction;
    }

    public boolean isSelected() {return selected;}

    public void changeSelected() {selected = !selected;}

    public void setDirection(Directions d) {
        this.direction = d;
        shipImage.setRotate(d.degree);
    }
}
