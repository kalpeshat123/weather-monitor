import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WeatherApp extends Frame implements ActionListener {
    TextField cityInput;
    Button fetchBtn;

    public WeatherApp() {
        Label label = new Label("Enter City:");
        cityInput = new TextField(20);
        fetchBtn = new Button("Fetch Weather");

        fetchBtn.addActionListener(this);

        setLayout(new FlowLayout());
        add(label); add(cityInput); add(fetchBtn);

        setSize(300, 120);
        setTitle("Weather UI");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String city = cityInput.getText();
        try {
            FileWriter fw = new FileWriter("weather-data/city.txt");
            fw.write(city);
            fw.close();
            System.out.println("City saved: " + city);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WeatherApp();
    }
}
