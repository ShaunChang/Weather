import nz.sodium.Cell;
import nz.sodium.CellSink;
import nz.sodium.Listener;
import nz.sodium.Stream;
import swidgets.SLabel;
import swidgets.STextField;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * An example of how to use the GpsService class
 */
public class Example2 {

    public static void main(String[] args) {
        Stack<GpsEvent> stack=new Stack<>();

        CellSink<GpsEvent> cellSink=new CellSink<>(null);
        Cell<String> cxc=new Cell<>("Trace");

        Cell<String> lift = cellSink.lift(cxc, (c1, c2) -> {
            return c2+c1 ;
        });

        JFrame frame = new JFrame("label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10,5,1,1));

        frame.setSize(800, 600);
        frame.setVisible(true);

//        //create a new cell with return value
//        Cell<String> cell = sTextField.sUserChanges.map(t ->"jjjjjjj"+t).hold("");
//        SLabel sLabel = new SLabel(sTextField.text);

        // Initialise the GPS Service
        GpsService serv = new GpsService();
        // Retrieve Event Streams
        Stream<GpsEvent>[] streams = serv.getEventStreams();
        // Attach a handler method to each stream
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        int count=0;
        for (Stream<GpsEvent> s : streams) {
            System.out.println("di  "+count++);
            System.out.println(s);
            s.listen((GpsEvent ev) -> System.out.println(ev));
            Cell<String> hold = s.map(ev -> ev.toString()).hold(null);
            Cell<String> trackerNumberCell = s.map(ev -> "Tracker number: "+ev.toString().split(" | ")[0].split("Tracker")[1]).hold("");
            Cell<String> latitudeCell = s.map(ev -> "latitude: "+ev.toString().split("lat:")[1].split(" lon")[0]).hold("");
            Cell<String> longitudeCell = s.map(ev -> "longitude: "+ev.toString().split("lon:")[1].split("  alt")[0]).hold("");
            Cell<String> commaDelimitedStringCell = s.map(ev -> ev.toString().replace(" | lat:",",").replace(" lon:",",").split(" alt")[0]+","+formatter.format(new Date(System.currentTimeMillis()))
        ).hold("");

            System.out.println("hold:  "+hold.toString());
//            SLabel trakerNmae=new SLabel(new Cell<>("Tracker number: "));
            SLabel trakerNmaeLabel = new SLabel(trackerNumberCell);
//            SLabel latitudeName =new SLabel(new Cell<>("latitude: "));
            SLabel latitudeLabel =new SLabel(latitudeCell);
//            SLabel longitudeName =new SLabel(new Cell<>("latitude: "));
            SLabel longitudeLabel =new SLabel(longitudeCell);

            SLabel commaDelimitedString=new SLabel(commaDelimitedStringCell);
//            frame.add(trakerNmae);
            frame.add(trakerNmaeLabel);
//            frame.add(latitudeName);
            frame.add(latitudeLabel);
//            frame.add(longitudeName);
            frame.add(longitudeLabel);
            frame.add(commaDelimitedString);

        }

//        //Monitored data
//        CellSink<String> trackerNumber =new CellSink<>("cccccccccc");
//        CellSink<String> latitude =new CellSink<>("0.00");
//        CellSink<String> longitude =new CellSink<>("0.00");
//
//        GpsEvent gpsEvent=null;
//
//        SLabel trackerNumberLable=new SLabel(trackerNumber);
//
//        frame.add(trackerNumberLable);
//        frame.setSize(400,160);
//        frame.setVisible(true);

//        while (!stack.isEmpty()){
//            GpsEvent pop = stack.pop();
//            System.out.println(pop);
//            trackerNumber.send(pop.toString());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }


//        Cell<String> trackerNumber="";
//        //change data in input stream
//                Cell<String> trackerNumberChange= trackerNumber.sUserChanges.map(t ->{
//           return t.replace("","");
//       }).hold("");


//
//
//        //Reaction function
//        Cell<Integer> display = trackerNumber.lift()
//

    }


}
