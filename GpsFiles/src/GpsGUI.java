import javax.swing.*;

import nz.sodium.Cell;
import nz.sodium.CellSink;
import nz.sodium.Stream;
import swidgets.SLabel;
import swidgets.STextField;

import javax.swing.*;
import java.awt.*;

public class GpsGUI {
    JFrame frame = new JFrame("GPS");
    static Cell<String> trackerNumberChange=new Cell<>("lllll");


    public GpsGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,160);
        frame.setVisible(true);
//        frame.add(trackerNumberChange);
    }

    public void updateCell(GpsEvent gpsEvent){
        System.out.println("更新了");
        trackerNumberChange.equals(gpsEvent.toString());
        SLabel sLabel = new SLabel(trackerNumberChange);
        frame.add(sLabel);
    }






}
