package org.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class LoadingImages {
    ArrayList<ImageView> tops = new ArrayList<>();
    ArrayList<ImageView> bottoms = new ArrayList<>();
    ArrayList<ImageView> shoes = new ArrayList<>();

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

    ImageView icon1 = createFunction.createImage("/images/icon1.png", 600, 70, 30);
    ImageView icon2 = createFunction.createImage("/images/icon2.png", 650, 70, 30);
    ImageView icon3 = createFunction.createImage("/images/icon3.png", 700, 70, 30);

    ImageView icon4 = createFunction.createImage("/images/icon4.png", 925, 525, 50);

    Pane doll1 = createFunction.createDoll(doll);

    Pane menu = createFunction.createMenu(icon1, icon2, icon3);


    ArrayList<DragDropLogic> dragDropLogics1 = new ArrayList<>();
    ArrayList<DragDropLogic> dragDropLogics2 = new ArrayList<>();
    ArrayList<DragDropLogic> dragDropLogics3 = new ArrayList<>();


    private void storeClothes() {
        tops.add(polo1);
        tops.add(hoodie1);
        tops.add(pullover1);
        tops.add(pullover2);
        tops.add(tanktop1);
        tops.add(tshirt1);

        bottoms.add(dunki1);
        bottoms.add(pants1);
        bottoms.add(skirt1);
        bottoms.add(skirt2);

        shoes.add(shoe1);
        shoes.add(shoe2);
        shoes.add(shoe3);


        for(int i = 0; i < tops.size(); i++){
            DragDropLogic dragDropLogic = new DragDropLogic();
            dragDropLogic.dragdrop(doll1, tops.get(i), createFunction.menuContent);
            dragDropLogics1.add(dragDropLogic);
        }
        for(int i = 0; i < bottoms.size(); i++){
            DragDropLogic dragDropLogic2 = new DragDropLogic();
            dragDropLogic2.dragdrop(doll1, bottoms.get(i), createFunction.menuContent);
            dragDropLogics2.add(dragDropLogic2);
        }
        for(int i = 0; i < shoes.size(); i++){
            DragDropLogic dragDropLogic3 = new DragDropLogic();
            dragDropLogic3.dragdrop(doll1, shoes.get(i), createFunction.menuContent);
            dragDropLogics3.add(dragDropLogic3);
        }

    }

    private void check_drag(){
        if(menu_num == 1){
            for (DragDropLogic d : dragDropLogics1) d.setDraggingEnabled(true);
            for (DragDropLogic d : dragDropLogics2) d.setDraggingEnabled(false);
            for (DragDropLogic d : dragDropLogics3) d.setDraggingEnabled(false);

        }else if(menu_num == 2){
            for (DragDropLogic d : dragDropLogics1) d.setDraggingEnabled(false);
            for (DragDropLogic d : dragDropLogics2) d.setDraggingEnabled(true);
            for (DragDropLogic d : dragDropLogics3) d.setDraggingEnabled(false);

        }else if(menu_num == 3){
            for (DragDropLogic d : dragDropLogics1) d.setDraggingEnabled(false);
            for (DragDropLogic d : dragDropLogics2) d.setDraggingEnabled(false);
            for (DragDropLogic d : dragDropLogics3) d.setDraggingEnabled(true);

        }
    }


    private Runnable swapAction;

    public void changeBackground(StackPane root) {
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

        StackPane.setAlignment(rec1, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(icon4, Pos.BOTTOM_RIGHT);

        StackPane.setMargin(rec1, new Insets(0, 20, 20, 0));
        StackPane.setMargin(icon4, new Insets(0, 20, 20, 0));

        root.getChildren().addAll(rec1, icon4);
    }


    int menu_num = 1;
    public void setMenu(Pane root) {
        storeClothes();
        check_drag();
        root.getChildren().add(menu);
        root.getChildren().add(doll1);

        createFunction.menuBackground.getChildren().setAll(createFunction.rect1);
        createFunction.menuContent.getChildren().setAll(tops);

        createFunction.rect1_1.setOnMouseClicked(e -> {
            menu_num = 1;
            check_drag();

            createFunction.menuBackground.getChildren().setAll(createFunction.rect1);
            createFunction.menuContent.getChildren().clear();

            for(int i = 0; i < tops.size(); i++){
                if(!doll1.getChildren().contains(tops.get(i))) createFunction.menuContent.getChildren().add(tops.get(i));
            }

        });
        createFunction.rect2_1.setOnMouseClicked(e -> {
            menu_num = 2;
            check_drag();

            createFunction.menuBackground.getChildren().setAll(createFunction.rect2);
            createFunction.menuContent.getChildren().clear();

            for(int i = 0; i < bottoms.size(); i++){
                if(!doll1.getChildren().contains(bottoms.get(i))) createFunction.menuContent.getChildren().add(bottoms.get(i));
            }

        });
        createFunction.rect3_1.setOnMouseClicked(e -> {
            menu_num = 3;
            check_drag();

            createFunction.menuBackground.getChildren().setAll(createFunction.rect3);
            createFunction.menuContent.getChildren().clear();

            for(int i = 0; i < shoes.size(); i++){
                if(!doll1.getChildren().contains(shoes.get(i))) createFunction.menuContent.getChildren().add(shoes.get(i));
            }

        });


    }


}
