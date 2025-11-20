package org.example.demo;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class LoadingImages {
    ArrayList<ImageView> clothes = new ArrayList<>();

    CreateFunctions createFunction = new CreateFunctions();
    Background bg1 = createFunction.createBackground("/images/bg1.png");
    Background bg2 = createFunction.createBackground("/images/bg2.png");
    Background bg3 = createFunction.createBackground("/images/bg3.png");

    ImageView doll = createFunction.createImage("/images/doll3.png", 73, 33, 380);

    ImageView polo1 = createFunction.createImage("/images/polo1.png", 560, 50, 180);
    ImageView hoodie1 = createFunction.createImage("/images/hoodie1.png", 660, 50, 180);
    ImageView pullover1 = createFunction.createImage("/images/pullover1.png", 560, 150, 180);
    ImageView pullover2 = createFunction.createImage("/images/pullover2.png", 660, 150, 180);
    ImageView tanktop1 = createFunction.createImage("/images/tanktop1.png", 560, 250, 180);
    ImageView tshirt1 = createFunction.createImage("/images/tshirt1.png", 660, 250, 180);

    ImageView dunki1 = createFunction.createImage("/images/dunki1.png", 560, 0, 180);
    ImageView pants1 = createFunction.createImage("/images/pants1.png", 660, 0, 180);
    ImageView skirt1 = createFunction.createImage("/images/skirt1.png", 560, 200, 180);
    ImageView skirt2 = createFunction.createImage("/images/skirt2.png", 660, 200, 180);

    ImageView shoe1 = createFunction.createImage("/images/shoe1.png", 560, -125, 180);
    ImageView shoe2 = createFunction.createImage("/images/shoe2.png", 660, -125, 180);
    ImageView shoe3 = createFunction.createImage("/images/shoe3.png", 760, -125, 180);

    Pane doll1 = createFunction.createDoll(doll);

    Pane menu = createFunction.createMenu();

    public void storeClothes() {
        clothes.add(dunki1);
        clothes.add(polo1);
        clothes.add(hoodie1);
        clothes.add(pants1);
        clothes.add(pullover1);
        clothes.add(pullover2);
        clothes.add(shoe1);
        clothes.add(skirt1);
        clothes.add(skirt2);
        clothes.add(tanktop1);
        clothes.add(tshirt1);
        clothes.add(shoe2);
        clothes.add(shoe3);

        for (int i = 0; i < clothes.size(); i++) {
            DragDropLogic dragDropLogic = new DragDropLogic();
            dragDropLogic.dragdrop(doll1, clothes.get(i), createFunction.menuContent);
        }

    }


    private Runnable swapAction;

    public void changeBackground(Pane root) {
        Rectangle rec1 = new Rectangle(925, 525, 50, 50);
        rec1.setFill(Color.LIGHTBLUE);
        rec1.setStroke(Color.DARKBLUE);

        swapAction = () -> {
            if (root.getBackground().equals(bg1)) {
                root.setBackground(bg2);
            } else if (root.getBackground().equals(bg2)) {
                root.setBackground(bg3);
            } else {
                root.setBackground(bg1);
            }
        };

        rec1.setOnMouseClicked(e -> swapAction.run());
        root.getChildren().add(rec1);
    }

    public void setMenu(Pane root) {
        root.getChildren().add(menu);
        root.getChildren().add(doll1);

        createFunction.menuBackground.getChildren().setAll(createFunction.rect1);
        createFunction.menuContent.getChildren().setAll(polo1, hoodie1, pullover1, pullover2, tanktop1, tshirt1);

        createFunction.rect1_1.setOnMouseClicked(e -> {
            createFunction.menuBackground.getChildren().setAll(createFunction.rect1);
            createFunction.menuContent.getChildren().clear();

            if (!doll1.getChildren().contains(polo1)) createFunction.menuContent.getChildren().add(polo1);
            if (!doll1.getChildren().contains(hoodie1)) createFunction.menuContent.getChildren().add(hoodie1);
            if (!doll1.getChildren().contains(pullover1)) createFunction.menuContent.getChildren().add(pullover1);
            if (!doll1.getChildren().contains(pullover2)) createFunction.menuContent.getChildren().add(pullover2);
            if (!doll1.getChildren().contains(tanktop1)) createFunction.menuContent.getChildren().add(tanktop1);
            if (!doll1.getChildren().contains(tshirt1)) createFunction.menuContent.getChildren().add(tshirt1);


        });
        createFunction.rect2_1.setOnMouseClicked(e -> {
            createFunction.menuBackground.getChildren().setAll(createFunction.rect2);
            createFunction.menuContent.getChildren().clear();

            if (!doll1.getChildren().contains(dunki1)) createFunction.menuContent.getChildren().add(dunki1);
            if (!doll1.getChildren().contains(pants1)) createFunction.menuContent.getChildren().add(pants1);
            if (!doll1.getChildren().contains(skirt1)) createFunction.menuContent.getChildren().add(skirt1);
            if (!doll1.getChildren().contains(skirt2)) createFunction.menuContent.getChildren().add(skirt2);

        });
        createFunction.rect3_1.setOnMouseClicked(e -> {
            createFunction.menuBackground.getChildren().setAll(createFunction.rect3);
            createFunction.menuContent.getChildren().clear();

            if (!doll1.getChildren().contains(shoe1)) createFunction.menuContent.getChildren().add(shoe1);
            if (!doll1.getChildren().contains(shoe2)) createFunction.menuContent.getChildren().add(shoe2);
            if (!doll1.getChildren().contains(shoe3)) createFunction.menuContent.getChildren().add(shoe3);


        });


    }





}
