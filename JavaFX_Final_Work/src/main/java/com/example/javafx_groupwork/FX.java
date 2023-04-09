package com.example.javafx_groupwork;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FX extends Application {
    public void start(Stage main) throws IOException {
        main.setTitle("商店管理系统");
        main.setHeight(600);
        main.setWidth(1400);
        Button button = new Button("展示所有商品信息");
        Button button2 = new Button("添加商品信息");
        Button button3 = new Button("移除商品信息");
        Button button4 = new Button("修改商品价格");
        Button button4_5 = new Button("重置商品");
        Button button5 = new Button("结账");
        Button button6 = new Button("展示所有结账记录");
        Button button7 = new Button("删除结账记录");
        Button button7_5 = new Button("重置结账");
        Label label1= new Label("商品管理");
        Label label2= new Label("记录管理");
        label1.setStyle("-fx-font-size: 25");
        label2.setStyle("-fx-font-size: 25");
        button.setPrefSize(180,50);
        button.setStyle("-fx-font-size:18");
        button.setCursor(Cursor.HAND);
        button2.setPrefSize(150,50);
        button2.setStyle("-fx-font-size:18");
        button2.setCursor(Cursor.HAND);
        button3.setPrefSize(150,50);
        button3.setStyle("-fx-font-size:18");
        button3.setCursor(Cursor.HAND);
        button4.setPrefSize(150,50);
        button4.setStyle("-fx-font-size:18");
        button4.setCursor(Cursor.HAND);
        button4_5.setPrefSize(100,50);
        button4_5.setStyle("-fx-font-size:18");
        button4_5.setCursor(Cursor.HAND);
        button5.setPrefSize(100,50);
        button5.setStyle("-fx-font-size:18");
        button5.setCursor(Cursor.HAND);
        button6.setPrefSize(180,50);
        button6.setStyle("-fx-font-size:18");
        button6.setCursor(Cursor.HAND);
        button7.setPrefSize(160,50);
        button7.setStyle("-fx-font-size:18");
        button7.setCursor(Cursor.HAND);
        button7_5.setPrefSize(100,50);
        button7_5.setStyle("-fx-font-size:18");
        button7_5.setCursor(Cursor.HAND);

        VBox vbox = new VBox();
        HBox box1 = new HBox();
        HBox box2 = new HBox();

        box1.setStyle("-fx-border-color:#000000");
        box2.setStyle("-fx-border-color:#000000");

        box1.getChildren().addAll(button2,button,button3,button4,button4_5);
        box2.getChildren().addAll(button5,button6,button7,button7_5);
        box1.setPrefHeight(250);
        box1.setPrefWidth(1200);
        box1.setAlignment(Pos.CENTER);
        box1.setSpacing(50);
        box2.setPrefHeight(250);
        box2.setPrefWidth(1200);
        box2.setAlignment(Pos.CENTER);
        box2.setSpacing(50);
        vbox.getChildren().addAll(label1,box1,label2,box2);
        vbox.setPrefHeight(500);
        vbox.setPrefWidth(1200);
        GridPane GD = new GridPane();
        GD.add(vbox,0,0);
        GD.setAlignment(Pos.CENTER);

        Scene scene = new Scene(GD);
        main.setScene(scene);

        main.show();

        GoodsList g = new GoodsList();

        CustomerList cl = new CustomerList();

        //展示所有商品信息
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                g.Display(g.gList);
                //判断列表是否为空
                if (g.gList.size() == 0) {
                    Label tip = new Label("当前无内容，请先录入数据");
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage False = new Stage();
                    False.setScene(s_false);
                    False.setHeight(100);
                    False.setWidth(250);
                    False.initOwner(main);
                    False.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    False.show();
                } else {
                    //显示商品列表
                    Stage display = new Stage();
                    display.setTitle("商品列表");
                    display.setHeight(300);
                    display.setWidth(240);
                    GridPane gd = new GridPane();
                    Label tablehead = new Label("编号" + "\t\t" + "名称" + "\t\t" + "价格");
                    gd.add(tablehead,0,0);
                    Scene s_display = new Scene(gd);
                    display.setScene(s_display);
                    for (int i = 0; i < g.gList.size(); i++) {
                        Label[] label = new Label[100];
                        label[i] = new Label(g.gList.get(i).getIndex() + "\t\t" + g.gList.get(i).getName() + "\t\t" + g.gList.get(i).getPrice());
                        gd.add(label[i],0,i+1);
                    }
                    display.show();
                }
            }
        });

        //添加商品信息
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button ok1 = new Button("确认");
                ok1.setCursor(Cursor.HAND);
                ok1.setLayoutY(160);
                ok1.setLayoutX(120);
                Label name = new Label("名称：");
                TextField t_add_name = new TextField();
//                t_add_name.setFocusTraversable(false);
                t_add_name.setPromptText("请输入你的商品名称");
                name.setLayoutX(40);
                name.setLayoutY(40);
                t_add_name.setLayoutX(80);
                t_add_name.setLayoutY(40);
                Label index = new Label("编号：");
                TextField t_add_index = new TextField();
                t_add_index.setFocusTraversable(false);
                t_add_index.setPromptText("请输入你的商品编号");
                index.setLayoutX(40);
                index.setLayoutY(80);
                t_add_index.setLayoutX(80);
                t_add_index.setLayoutY(80);
                Label price = new Label("价格：");
                TextField t_add_price = new TextField();
                t_add_price.setFocusTraversable(false);
                t_add_price.setPromptText("请输入你的商品价格");
                price.setLayoutX(40);
                price.setLayoutY(120);
                t_add_price.setLayoutX(80);
                t_add_price.setLayoutY(120);
                Stage add = new Stage();
                add.setTitle("添加商品");
                add.setHeight(250);
                add.setWidth(280);
                add.setResizable(false);
                Group g_add = new Group();
                g_add.getChildren().add(t_add_index);
                g_add.getChildren().add(t_add_name);
                g_add.getChildren().add(t_add_price);
                g_add.getChildren().add(name);
                g_add.getChildren().add(index);
                g_add.getChildren().add(price);
                g_add.getChildren().add(ok1);
                Scene s_add = new Scene(g_add);
                add.setScene(s_add);
                add.initOwner(main);
                add.initModality(Modality.WINDOW_MODAL);
                add.show();

                ok1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //若商品列表不为空，则进行对名称、编号和价格的检查
                        if (g.gList.size() > 0) {
                            boolean flag = true;
                            String NAME = t_add_name.getText();
                            String INDEX = t_add_index.getText();
                            String PRICE = t_add_price.getText();
                            //判断价格是否为数字,如果不是则报错，界面无响应
                            double a = 1;
                            if (getType(Double.parseDouble(PRICE)).equals(getType(a))) {
                                System.out.println("可以转为数字");
                            }
                            //判断价格是否大于零，如果小于零则弹出提示框
                            if (Double.parseDouble(PRICE) <= 0) {
                                flag = false;
                                //弹出提示框
                                {
                                    GridPane g_error = new GridPane();
                                    Scene s_error = new Scene(g_error);
                                    Stage error = new Stage();
                                    error.setScene(s_error);
                                    Label l_error = new Label("价格需要大于0，请重试");
                                    Button ok = new Button("确定");
                                    ok.setCursor(Cursor.HAND);
                                    g_error.add(ok, 0, 1);
                                    g_error.add(l_error, 0, 0);
                                    g_error.setAlignment(Pos.CENTER);
                                    error.setHeight(250);
                                    error.setWidth(400);
                                    error.initOwner(add);
                                    error.initModality(Modality.WINDOW_MODAL);
                                    error.show();
                                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            error.close();
                                        }
                                    });
                                }
                            } else {
                                //判断输入内容是否与已保存的数据有相同名称或编号，若有，则弹出提示框
                                for (int i = 0; i < g.gList.size(); i++) {
                                    if (g.gList.get(i).getName().equals(NAME) || g.gList.get(i).getIndex().equals(INDEX)) {//进入则表示检查不通过
                                        flag = false;
                                        //弹出提示框
                                        {
                                            AnchorPane g_error = new AnchorPane();
                                            Scene s_error = new Scene(g_error);
                                            Stage error = new Stage();
                                            error.setScene(s_error);
                                            Label l_error = new Label("存在相同名称或编号的商品，请重试");
                                            Button ok2 = new Button("确定");
                                            ok2.setCursor(Cursor.HAND);
                                            g_error.getChildren().addAll(l_error,ok2);
                                            g_error.setTopAnchor(l_error,70.0);
                                            g_error.setLeftAnchor(l_error,100.0);
                                            g_error.setTopAnchor(ok2,100.0);
                                            g_error.setLeftAnchor(ok2,170.0);
                                            error.setHeight(250);
                                            error.setWidth(400);
                                            error.initOwner(add);
                                            error.initModality(Modality.WINDOW_MODAL);
                                            error.show();
                                            ok2.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent actionEvent) {
                                                    error.close();
                                                }
                                            });
                                        }
                                        break;
                                    }
                                }
                            }
                            if (flag) {//若通过了"名称和编号是否重复"和"价格是否为数字"的检查,则添加该商品信息
                                g.Name = t_add_name.getText();
                                g.Price = Double.parseDouble(t_add_price.getText());
                                g.Index = t_add_index.getText();
                                g.AddGoods(g.gList);
                                //添加成功提示框
                                {
                                    GridPane g_done = new GridPane();
                                    Scene s_done = new Scene(g_done);
                                    Stage done = new Stage();
                                    done.setScene(s_done);
                                    Label l_done = new Label("添加成功");
                                    g_done.add(l_done, 0, 0);
                                    Button ok3 = new Button("确定");
                                    ok3.setCursor(Cursor.HAND);
                                    g_done.add(ok3, 0, 1);
                                    g_done.setAlignment(Pos.CENTER);
                                    done.setHeight(250);
                                    done.setWidth(400);
                                    done.initOwner(add);
                                    done.initModality(Modality.WINDOW_MODAL);
                                    done.show();
                                    ok3.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            done.close();
                                            add.close();
                                        }
                                    });
                                }
                            }
                        } else {//若商品列表为空，进入这里
                            //判断价格是否大于零，如果小于零则弹出提示框
                            if (Double.parseDouble(t_add_price.getText()) <= 0) {
                                //弹出错误信息提示框
                                {
                                    GridPane g_error = new GridPane();
                                    Scene s_error = new Scene(g_error);
                                    Stage error = new Stage();
                                    error.setScene(s_error);
                                    Label l_error = new Label("价格需要大于0，请重试");
                                    Button ok = new Button("确定");
                                    ok.setCursor(Cursor.HAND);
                                    g_error.add(ok, 0, 1);
                                    g_error.add(l_error, 0, 0);
                                    g_error.setAlignment(Pos.CENTER);
                                    error.setHeight(250);
                                    error.setWidth(400);
                                    error.initOwner(add);
                                    error.initModality(Modality.WINDOW_MODAL);
                                    error.show();
                                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            error.close();
                                        }
                                    });
                                }
                            } else {
                                //添加成功提示框
                                {
                                    g.Name = t_add_name.getText();
                                    g.Price = Double.parseDouble(t_add_price.getText());
                                    g.Index = t_add_index.getText();
                                    g.AddGoods(g.gList);
                                    GridPane g_done = new GridPane();
                                    Scene s_done = new Scene(g_done);
                                    Stage done = new Stage();
                                    done.setScene(s_done);
                                    Label l_done = new Label("添加成功");
                                    g_done.add(l_done, 0, 0);
                                    Button ok = new Button("确定");
                                    ok.setCursor(Cursor.HAND);
                                    g_done.add(ok, 0, 1);
                                    g_done.setAlignment(Pos.CENTER);
                                    done.setHeight(250);
                                    done.setWidth(400);
                                    done.initOwner(add);
                                    done.initModality(Modality.WINDOW_MODAL);
                                    done.show();
                                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            done.close();
                                            add.close();
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
            }
        });

        //移除商品信息
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //判断商品列表是否为空
                if (g.gList.size() == 0) {
                    Label tip = new Label("当前无内容，请先录入数据");
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage False = new Stage();
                    False.setScene(s_false);
                    False.setHeight(100);
                    False.setWidth(250);
                    False.initOwner(main);
                    False.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    False.show();
                } else {
                    //显示删除商品界面
                    Label tip = new Label("请输入要删除的商品编号：");
                    TextField t_index = new TextField();
                    Button ok = new Button("确定");
                    ok.setCursor(Cursor.HAND);
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage remove = new Stage();
                    remove.setTitle("移除商品");
                    remove.setScene(s_false);
                    remove.setHeight(250);
                    remove.setWidth(400);
                    remove.initOwner(main);
                    remove.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    root.add(t_index, 1, 0);
                    root.add(ok, 2, 0);
                    remove.show();

                    ok.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        //点击后判断编号是否存在，存在则删除，否则弹出提示框
                        public void handle(ActionEvent actionEvent) {
                            boolean flag = false;
                            for (int i = 0; i < g.gList.size(); i++) {
                                if (t_index.getText().equals(g.gList.get(i).getIndex())) {
                                    g.gList.remove(i);
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                //编号存在则进入这里
                                GridPane g_done = new GridPane();
                                Scene s_done = new Scene(g_done);
                                Stage done = new Stage();
                                done.setScene(s_done);
                                Label l_done = new Label("删除成功");
                                g_done.add(l_done, 0, 0);
                                Button ok = new Button("确定");
                                ok.setCursor(Cursor.HAND);
                                g_done.add(ok, 0, 1);
                                g_done.setAlignment(Pos.CENTER);
                                done.setHeight(250);
                                done.setWidth(400);
                                done.initOwner(remove);
                                done.initModality(Modality.WINDOW_MODAL);
                                done.show();
                                ok.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        done.close();
                                        remove.close();
                                    }
                                });
                            } else {
                                //编号不存在则进入这里
                                GridPane g_error = new GridPane();
                                Scene s_error = new Scene(g_error);
                                Stage error = new Stage();
                                error.setScene(s_error);
                                Label l_error = new Label("该编号无指定商品");
                                g_error.add(l_error, 0, 0);
                                g_error.setAlignment(Pos.CENTER);
                                error.setHeight(250);
                                error.setWidth(400);
                                error.initOwner(remove);
                                error.initModality(Modality.WINDOW_MODAL);
                                error.show();

                            }

                        }
                    });
                }
            }
        });

        //修改商品价格
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //判断商品列表是否为空
                if (g.gList.size() == 0) {
                    Label tip = new Label("当前无内容，请先录入数据");
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage False = new Stage();
                    False.setScene(s_false);
                    False.setHeight(100);
                    False.setWidth(250);
                    False.initOwner(main);
                    False.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    False.show();
                } else {
                    //显示修改商品界面
                    Label tip = new Label("请输入要修改的商品编号：");
                    TextField t_index = new TextField();
                    Button ok = new Button("确定");
                    ok.setCursor(Cursor.HAND);
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage modify = new Stage();
                    modify.setTitle("修改商品价格");
                    modify.setScene(s_false);
                    modify.setHeight(250);
                    modify.setWidth(400);
                    modify.initOwner(main);
                    modify.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    root.add(t_index, 1, 0);
                    root.add(ok, 2, 0);
                    modify.show();

                    ok.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        //点击后判断编号是否存在，存在开始修改，否则弹出提示框
                        public void handle(ActionEvent actionEvent) {
                            boolean flag = false;
                            int index = -1;
                            for (int i = 0; i < g.gList.size(); i++) {
                                if (t_index.getText().equals(g.gList.get(i).getIndex())) {
                                    flag = true;
                                    index = i;
                                    break;
                                }
                            }
                            if (flag) {
                                System.out.println(index);
                                //编号存在则进入这里
                                AnchorPane g_modify2 = new AnchorPane();
                                Scene s_modify2 = new Scene(g_modify2);
                                Stage modify2 = new Stage();
                                modify2.setScene(s_modify2);
                                Label l_price = new Label("修改价格为：");
                                TextField t_price = new TextField();
                                Button ok = new Button("确定");
                                ok.setCursor(Cursor.HAND);
                                g_modify2.getChildren().addAll(l_price,t_price,ok);
                                g_modify2.setTopAnchor(l_price,90.0);
                                g_modify2.setLeftAnchor(l_price,80.0);
                                g_modify2.setTopAnchor(t_price,86.0);
                                g_modify2.setLeftAnchor(t_price,150.0);
                                g_modify2.setTopAnchor(ok,120.0);
                                g_modify2.setLeftAnchor(ok,190.0);

                                modify2.setHeight(250);
                                modify2.setWidth(400);
                                modify2.initOwner(modify);
                                modify2.initModality(Modality.WINDOW_MODAL);
                                modify2.show();
                                int x = index;

                                ok.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {

                                        //判断修改的价格是否大于零
                                        if (Double.parseDouble(t_price.getText()) > 0) {
                                            //修改价格
                                            g.gList.get(x).setPrice(Double.parseDouble(t_price.getText()));
                                            //弹出提示
                                            {
                                                GridPane g_done = new GridPane();
                                                Scene s_done = new Scene(g_done);
                                                Stage done = new Stage();
                                                done.setScene(s_done);
                                                Label l_done = new Label("修改成功");
                                                Button ok = new Button("确定");
                                                ok.setCursor(Cursor.HAND);
                                                g_done.add(l_done, 0, 0);
                                                g_done.add(ok, 0, 1);
                                                g_done.setAlignment(Pos.CENTER);
                                                done.setHeight(250);
                                                done.setWidth(400);
                                                done.initOwner(modify2);
                                                done.initModality(Modality.WINDOW_MODAL);
                                                done.show();
                                                ok.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent actionEvent) {
                                                        done.close();
                                                        modify2.close();
                                                        modify.close();
                                                    }
                                                });
                                            }
                                        } else {
                                            GridPane g_error = new GridPane();
                                            Scene s_error = new Scene(g_error);
                                            Stage error = new Stage();
                                            error.setScene(s_error);
                                            Label l_error = new Label("价格必须大于零，请重新输入");
                                            Button ok = new Button("确定");
                                            ok.setCursor(Cursor.HAND);
                                            g_error.add(l_error, 0, 0);
                                            g_error.add(ok, 0, 1);
                                            g_error.setAlignment(Pos.CENTER);
                                            error.setHeight(250);
                                            error.setWidth(400);
                                            error.initOwner(modify2);
                                            error.initModality(Modality.WINDOW_MODAL);
                                            error.show();
                                            t_price.clear();
                                            ok.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent actionEvent) {
                                                    error.close();
                                                }
                                            });
                                        }
                                    }
                                });
                            } else {
                                //编号不存在则弹出提示框
                                {
                                    AnchorPane g_error = new AnchorPane();
                                    Scene s_error = new Scene(g_error);
                                    Stage error = new Stage();
                                    error.setScene(s_error);
                                    Label l_error = new Label("该编号无指定商品");
                                    Button ok = new Button("确定");
                                    ok.setCursor(Cursor.HAND);
                                    g_error.getChildren().addAll(l_error,ok);
                                    g_error.setTopAnchor(l_error,85.0);
                                    g_error.setLeftAnchor(l_error,150.0);
                                    g_error.setTopAnchor(ok,115.0);
                                    g_error.setLeftAnchor(ok,178.0);
                                    error.setHeight(250);
                                    error.setWidth(400);
                                    error.initOwner(modify);
                                    error.initModality(Modality.WINDOW_MODAL);
                                    error.show();
                                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            error.close();
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            }
        });

        //结账
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button ok = new Button("确认");
                ok.setCursor(Cursor.HAND);
                ok.setLayoutX(120);
                ok.setLayoutY(120);
                Label index = new Label("编号：");
                TextField t_checkout_index = new TextField();
                t_checkout_index.setFocusTraversable(false);
                index.setLayoutX(30);
                index.setLayoutY(80);
                t_checkout_index.setLayoutX(70);
                t_checkout_index.setLayoutY(80);
                Label number = new Label("数量：");
                TextField t_checkout_number = new TextField();
                number.setLayoutX(30);
                number.setLayoutY(40);
                t_checkout_number.setLayoutX(70);
                t_checkout_number.setLayoutY(40);

                Stage checkout = new Stage();
                checkout.setTitle("结账");
                checkout.setHeight(210);
                checkout.setWidth(280);
                checkout.setResizable(false);
                Group g_checkout = new Group();
                g_checkout.getChildren().add(t_checkout_index);
                g_checkout.getChildren().add(t_checkout_number);
                g_checkout.getChildren().add(number);
                g_checkout.getChildren().add(index);
                g_checkout.getChildren().add(ok);
                Scene s_checkout = new Scene(g_checkout);
                checkout.setScene(s_checkout);
                checkout.initOwner(main);
                checkout.initModality(Modality.WINDOW_MODAL);
                checkout.show();

                //每次结账都会重新构建一个GoodsList对象来存储一个新的顾客的消费清单，以区分不同顾客
                GoodsList rl = new GoodsList();

                ok.setOnAction(new EventHandler<ActionEvent>() {
                    double total = 0;

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        boolean flag2 = true;

                        while (flag2) {
                            String INDEX = t_checkout_index.getText();
                            String NUMBER = t_checkout_number.getText();
                            boolean flag = true;
                            //判断价格是否为数字,如果不是则报错，界面无响应
                            double a = 1;
                            if (getType(Double.parseDouble(NUMBER)).equals(getType(a))) {
                                System.out.println("可以转为数字");
                            }
                            //判断数量是否大于零，如果小于零则弹出提示框
                            if (Double.parseDouble(NUMBER) <= 0) {
                                //弹出提示框
                                {
                                    Group g_error = new Group();
                                    Scene s_error = new Scene(g_error);
                                    Stage error = new Stage();
                                    error.setScene(s_error);
                                    Label l_error = new Label("数量需要大于0，请重试");
                                    Button ok = new Button("确定");
                                    ok.setCursor(Cursor.HAND);
                                    g_error.getChildren().add(l_error);
                                    g_error.getChildren().add(ok);
                                    l_error.setLayoutX(130);
                                    l_error.setLayoutY(80);
                                    ok.setLayoutX(170);
                                    ok.setLayoutY(120);
                                    error.setHeight(250);
                                    error.setWidth(400);
                                    error.initOwner(checkout);
                                    error.initModality(Modality.WINDOW_MODAL);
                                    error.show();
                                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            error.close();
                                        }
                                    });
                                }
                            }/*若大于零则正常往下*/else{
                                //查找输入编号
                                int I = 0;
                                for (int i = 0; i < g.gList.size(); i++) {
                                    if (g.gList.get(i).getIndex().equals(INDEX)) {
                                        I = i;
                                        flag = false;
                                        total += g.gList.get(i).getPrice() * Double.parseDouble(NUMBER);
                                        break;
                                    }
                                }
                                //若编号不存在
                                if (flag) {
                                    {
                                        t_checkout_index.clear();
                                        t_checkout_number.clear();
                                        Group g_error = new Group();
                                        Scene s_error = new Scene(g_error);
                                        Stage error = new Stage();
                                        error.setScene(s_error);
                                        Label l_error = new Label("该编号不存在，请重试");
                                        Button ok1 = new Button("确定");
                                        ok1.setCursor(Cursor.HAND);
                                        g_error.getChildren().add(l_error);
                                        g_error.getChildren().add(ok1);
                                        l_error.setLayoutX(130);
                                        l_error.setLayoutY(80);
                                        ok1.setLayoutX(170);
                                        ok1.setLayoutY(120);
                                        error.setHeight(250);
                                        error.setWidth(400);
                                        error.initOwner(checkout);
                                        error.initModality(Modality.WINDOW_MODAL);
                                        error.show();
                                        ok1.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                error.close();
                                            }
                                        });
                                        break;
                                    }
                                } else {
                                    //若编号存在则进行收款
                                    //-----加入记录-----
                                    //每次点击继续添加后都会重新构建一个Goods对象储存新的商品信息
                                    Goods r = new Goods();
                                    r.setName(g.gList.get(I).getName());
                                    r.setIndex(g.gList.get(I).getIndex());
                                    r.setPrice(g.gList.get(I).getPrice());
                                    r.setNumber(Integer.parseInt(t_checkout_number.getText()));
                                    //-------------------
                                    double innerTotal = total;
                                    t_checkout_index.clear();
                                    t_checkout_number.clear();
                                    Group g_done = new Group();
                                    Scene s_done = new Scene(g_done);
                                    Stage done = new Stage();
                                    done.setScene(s_done);
                                    Label l_done = new Label("添加成功，点击确定保存数据");
                                    Button ok1 = new Button("确定");
                                    ok1.setCursor(Cursor.HAND);
                                    Button Continue = new Button("继续添加");
                                    Continue.setCursor(Cursor.HAND);
                                    g_done.getChildren().addAll(ok1,l_done,Continue);
                                    l_done.setLayoutX(120);
                                    l_done.setLayoutY(80);
                                    ok1.setLayoutX(130);
                                    ok1.setLayoutY(120);
                                    Continue.setLayoutX(190);
                                    Continue.setLayoutY(120);
                                    done.setHeight(250);
                                    done.setWidth(400);
                                    done.initOwner(checkout);
                                    done.initModality(Modality.WINDOW_MODAL);
                                    done.show();
                                    //若点击确认，则显示应收金额，并将该商品记录在该客户的账单里
                                    ok1.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            //----将该商品记录在该客户的账单里-----
                                            rl.gList.add(r);
                                            //---------------------------------
                                            cl.addToRecordsList(rl);
                                            System.out.println(innerTotal);
                                            done.close();
                                            checkout.close();
                                            Group g_done2 = new Group();
                                            Scene s_done2 = new Scene(g_done2);
                                            Stage done2 = new Stage();
                                            done2.setScene(s_done2);
                                            Label l_done2 = new Label("应收款 " + innerTotal + " 元");
                                            Button close = new Button("确定");
                                            close.setCursor(Cursor.HAND);
                                            g_done2.getChildren().addAll(l_done2,close);
                                            l_done2.setLayoutX(120);
                                            l_done2.setLayoutY(80);
                                            close.setLayoutX(135);
                                            close.setLayoutY(110);
                                            done2.setHeight(250);
                                            done2.setWidth(320);
                                            done2.show();
                                            close.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent actionEvent) {
                                                    done2.close();
                                                }

                                            });

                                        }
                                    });
                                    //若点击继续添加，则返回上一级界面继续添加，并将该商品记录在该客户的账单里
                                    Continue.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            //----将该商品记录在该客户的账单里-----
                                            rl.gList.add(r);
                                            ////-------------------------------
                                            System.out.println(innerTotal);
                                            done.close();

                                        }
                                    });
                                    break;
                                }
                            }
                            break;
                        }


                    }
                });
            }
        });

        //展示结账记录
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //判断有无消费记录
                if (cl.customerlist.size() == 0) {
                    Label tip = new Label("当前无消费记录");
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage False = new Stage();
                    False.setScene(s_false);
                    False.setHeight(100);
                    False.setWidth(250);
                    False.initOwner(main);
                    False.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    False.show();
                } else {
                    //显示结账记录
                    Stage display = new Stage();
                    display.setTitle("结账记录");
                    display.setHeight(400);
                    display.setWidth(240);
                    GridPane gd = new GridPane();
                    Scene s_display = new Scene(gd);
                    display.setScene(s_display);
                    int Y1 = 0;
                    int Y2 = 0;
                    //两层for循环获取所需数据
                    //用GridPane布局控制每个Label的坐标
                    for (int i = 0; i < cl.customerlist.size(); i++) {
                        double total = 0;
                        Label[] labels = new Label[50];
                        labels[i] = new Label("顾客" + (i + 1) + "------------");
                        Label tablehead = new Label("名称" + "\t\t" + "价格" + "\t\t" + "数量");
                        //Y1指内圈循环的次数（也是商品信息的行数），Y2指除了商品信息的行数和每个账单的第一行以外，其他行的总数，因此在每打印完一个顾客的账单后，Y2都会+2
                        gd.add(labels[i],0,i+Y1+Y2);
                        gd.add(tablehead,0,i+1+Y1+Y2);

                        //temp代表TableHead所在的行数
                        int temp = i+1+Y1+Y2;
                        for (int j = 0; j < cl.customerlist.get(i).gList.size(); j++) {
                            Y1 += 1;
                            Label[] info = new Label[10];
                            info[0] = new Label(cl.customerlist.get(i).gList.get(j).getName());
                            info[1] = new Label(String.valueOf(cl.customerlist.get(i).gList.get(j).getPrice()));
                            info[2] = new Label(String.valueOf(cl.customerlist.get(i).gList.get(j).getNumber()));
                            HBox box = new HBox();
                            box.getChildren().addAll(info[0],info[1],info[2]);
                            box.setSpacing(40);
                            gd.add(box,0,(temp)+1+j);
                            total +=cl.customerlist.get(i).gList.get(j).getPrice()*cl.customerlist.get(i).gList.get(j).getNumber();
                        }
                        Label[] end = new Label[50];
                        end[i] = new Label("---------------合计: "+total+"元");
                        gd.add(end[i],0,i+2+Y1+Y2);
                        Y2+=2;
                    }
                    display.show();
                }
            }
        });

        //移除结账记录
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //判断结账列表是否为空
                if (cl.customerlist.size() == 0) {
                    Label tip = new Label("无消费记录");
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage False = new Stage();
                    False.setScene(s_false);
                    False.setHeight(100);
                    False.setWidth(250);
                    False.initOwner(main);
                    False.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    False.show();
                }else{
                    //显示删除记录界面
                    Label tip = new Label("请输入要删除的记录编号：");
                    TextField t_index = new TextField();
                    Button ok = new Button("确定");
                    ok.setCursor(Cursor.HAND);
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    Scene s_false = new Scene(root);
                    Stage remove = new Stage();
                    remove.setTitle("移除记录");
                    remove.setScene(s_false);
                    remove.setHeight(250);
                    remove.setWidth(400);
                    remove.initOwner(main);
                    remove.initModality(Modality.WINDOW_MODAL);
                    root.add(tip, 0, 0);
                    root.add(t_index, 1, 0);
                    root.add(ok, 2, 0);
                    remove.show();

                    ok.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        //点击后判断编号是否存在，存在则删除，否则弹出提示框
                        public void handle(ActionEvent actionEvent) {
                            boolean flag = false;
                            int i = Integer.parseInt(t_index.getText())-1;
                            if (i<cl.customerlist.size()) {
                                cl.customerlist.remove(i);
                                flag = true;
                            }
                            if (flag) {
                                //编号存在则进入这里
                                GridPane g_done = new GridPane();
                                Scene s_done = new Scene(g_done);
                                Stage done = new Stage();
                                done.setScene(s_done);
                                Label l_done = new Label("删除成功");
                                g_done.add(l_done, 0, 0);
                                Button close = new Button("确定");
                                close.setCursor(Cursor.HAND);
                                g_done.add(close, 0, 1);
                                g_done.setAlignment(Pos.CENTER);
                                done.setHeight(250);
                                done.setWidth(400);
                                done.initOwner(remove);
                                done.initModality(Modality.WINDOW_MODAL);
                                done.show();
                                close.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        done.close();
                                        remove.close();
                                    }
                                });
                            } else {
                                //编号不存在则进入这里
                                GridPane g_error = new GridPane();
                                Scene s_error = new Scene(g_error);
                                Stage error = new Stage();
                                error.setScene(s_error);
                                Label l_error = new Label("该编号无指定记录");
                                g_error.add(l_error, 0, 0);
                                g_error.setAlignment(Pos.CENTER);
                                error.setHeight(250);
                                error.setWidth(400);
                                error.initOwner(remove);
                                error.initModality(Modality.WINDOW_MODAL);
                                error.show();

                            }
                        }
                    });
                }
            }
        });

        button4_5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Text name = new Text("大BOSS：");
                Text password = new Text("密码：");
                TextField e_name = new TextField();
                e_name.setPrefWidth(150);
                PasswordField e_password = new PasswordField();
                Button clear = new Button("清除");
                clear.setCursor(Cursor.HAND);
                Button login = new Button("登录");
                login.setCursor(Cursor.HAND);
                GridPane gridPane = new GridPane();
                gridPane.add(name, 0, 0);
                gridPane.add(e_name, 1,0);
                gridPane.add(password, 0, 1);
                gridPane.add(e_password, 1, 1);
                gridPane.add(clear, 0,2);
                gridPane.add(login, 1,2);
                gridPane.setMargin(login, new Insets(0,0,0,115));
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setVgap(10);
                gridPane.setHgap(5);
                Stage stage1 = new Stage();
                Scene scene = new Scene(gridPane);
                stage1.setScene(scene);
                stage1.setTitle("商店大BOSS");
                stage1.setHeight(300);
                stage1.setWidth(500);
                stage1.initOwner(main);
                stage1.initModality(Modality.WINDOW_MODAL);
                stage1.show();
                clear.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        e_name.clear();
                        e_password.clear();
                    }
                });
                login.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String[] set = {"朱桂龙","123456","梁华健","000000","钟陆文","987654"};
                        for (int i = 0; i < 3; i++) {
                            if (e_name.getText().equals(set[2*i]) && e_password.getText().equals(set[2*i + 1])) {
                                stage1.close();
                                g.gList.clear();
                                Label tip = new Label("已重置商品信息");
                                GridPane root = new GridPane();
                                root.setAlignment(Pos.CENTER);
                                Scene s_false = new Scene(root);
                                Stage False = new Stage();
                                False.setScene(s_false);
                                False.setHeight(100);
                                False.setWidth(250);
                                False.initOwner(main);
                                False.initModality(Modality.WINDOW_MODAL);
                                root.add(tip, 0, 0);
                                False.show();
                                break;
                            }
                            else if (i == 2) {
                                    Label tip = new Label("密码输入错误");
                                    GridPane root = new GridPane();
                                    root.setAlignment(Pos.CENTER);
                                    Scene s_false = new Scene(root);
                                    Stage False = new Stage();
                                    False.setScene(s_false);
                                    False.setHeight(100);
                                    False.setWidth(250);
                                    False.initOwner(main);
                                    False.initModality(Modality.WINDOW_MODAL);
                                    root.add(tip, 0, 0);
                                    False.show();
                                    break;
                                }
                        }
                    }
                });
            }
        });

        button7_5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                    Text name = new Text("小BOSS：");
                    Text password = new Text("密码：");
                    TextField e_name = new TextField();
                    e_name.setPrefWidth(150);
                    PasswordField e_password = new PasswordField();
                    Button clear = new Button("清除");
                    clear.setCursor(Cursor.HAND);
                    Button login = new Button("登录");
                     login.setCursor(Cursor.HAND);
                    GridPane gridPane = new GridPane();
                    gridPane.add(name, 0, 0);
                    gridPane.add(e_name, 1,0);
                    gridPane.add(password, 0, 1);
                    gridPane.add(e_password, 1, 1);
                    gridPane.add(clear, 0,2);
                    gridPane.add(login, 1,2);
                    GridPane.setMargin(login, new Insets(0,0,0,115));
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setVgap(10);
                    gridPane.setHgap(5);
                    Scene scene = new Scene(gridPane);
                    Stage stage2 = new Stage();
                    stage2.setScene(scene);
                    stage2.setTitle("商店小BOSS");
                    stage2.setHeight(300);
                    stage2.setWidth(500);
                    stage2.initOwner(main);
                    stage2.initModality(Modality.WINDOW_MODAL);
                    stage2.show();
                    clear.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            e_name.clear();
                            e_password.clear();
                        }
                    });
                    login.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String[] set = {"朱桂龙","123456","梁华健","000000","钟陆文","987654"};
                            for (int i = 0; i < 3; i++) {
                                if (e_name.getText().equals(set[2*i]) && e_password.getText().equals(set[2*i + 1])) {
                                    stage2.close();
                                    cl.customerlist.clear();
                                    Label tip = new Label("已重置结账记录信息");
                                    GridPane root = new GridPane();
                                    root.setAlignment(Pos.CENTER);
                                    Scene s_false = new Scene(root);
                                    Stage False = new Stage();
                                    False.setScene(s_false);
                                    False.setHeight(100);
                                    False.setWidth(250);
                                    False.initOwner(main);
                                    False.initModality(Modality.WINDOW_MODAL);
                                    root.add(tip, 0, 0);
                                    False.show();
                                    break;
                                }
                                else if (i == 2) {
                                            Label tip = new Label("密码输入错误");
                                            GridPane root = new GridPane();
                                            root.setAlignment(Pos.CENTER);
                                            Scene s_false = new Scene(root);
                                            Stage False = new Stage();
                                            False.setScene(s_false);
                                            False.setHeight(100);
                                            False.setWidth(250);
                                            False.initOwner(main);
                                            False.initModality(Modality.WINDOW_MODAL);
                                            root.add(tip, 0, 0);
                                            False.show();
                                            break;
                                        }
                            }
                        }
                    });
                    }
                });
    }

    public static void main(String[] args) {
        launch();
    }

    private static String getType(Object a) {
        return a.getClass().toString();
    }
}