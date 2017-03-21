package bhangun.buku.fx.bab.others;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClipboardSample extends Application {
  /*public static void main(String[] args) {
    DataFormat fmt = new DataFormat("text/foo", "text/bar");
    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    content.put(fmt, "Hello");
    clipboard.setContent(content);
  }*/

  public static void main(String[] args) {
      Application.launch(args);
  }
  /*@Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("Text Fonts");
      Group root = new Group();
      Scene scene = new Scene(root, 550, 250,Color.web("0x0000FF"));

      final Clipboard clipboard = Clipboard.getSystemClipboard();
      final ClipboardContent content = new ClipboardContent();
      content.putString("Some text");
      content.putHtml("<b>Some</b> text");
      clipboard.setContent(content);
      


      primaryStage.setScene(scene);
      primaryStage.show();
  }*/
  
  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("Text Fonts");
      Group root = new Group();
      Scene scene = new Scene(root, 550, 250,Color.web("white"));

      final Clipboard clipboard = Clipboard.getSystemClipboard();
      final ClipboardContent content = new ClipboardContent();
      content.putString("some text");
      content.put(DataFormat.PLAIN_TEXT, "other text");
      clipboard.setContent(content);
      


      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
