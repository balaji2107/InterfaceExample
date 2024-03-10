import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TrainScheduleForm1 extends JFrame {

    private JPanel panelTrainA, panelTrainB,JTextField;
    String[][] aTrain=new String[2][2];
    String[][] bTrain=new String[2][2];
    int[] needTrain=new int[2];
    public TrainScheduleForm1() {
        setTitle("Train Schedule Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 150);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel1.setLayout(new GridLayout(2, 2));
        JLabel departureALabel = new JLabel("Train A Departure Time :");
        JTextField departureAField = new JTextField();
        JLabel arrivalALabel = new JLabel("Train A Arrival Time :");
        JTextField arrivalAField = new JTextField();
	    JLabel departureALabel1 = new JLabel("Train A Departure Time :");
        JTextField departureAField1 = new JTextField();
        JLabel arrivalALabel1 = new JLabel("Train A Arrival Time :");
        JTextField arrivalAField1 = new JTextField();
	

            panel.add(departureALabel);
            panel.add(departureAField);
            panel.add(arrivalALabel);
            panel.add(arrivalAField);
            panel.add(departureALabel1);
            panel.add(departureAField1);
            panel.add(arrivalALabel1);
            panel.add(arrivalAField1);

	    
	    JLabel departureLabel = new JLabel("Train B Departure Time :");
        JTextField departureField = new JTextField();
        JLabel arrivalLabel = new JLabel("Train B Arrival Time :");
        JTextField arrivalField = new JTextField();
	    JLabel departureLabel1 = new JLabel("Train B Departure Time :");
        JTextField departureField1 = new JTextField();
        JLabel arrivalLabel1 = new JLabel("Train B Arrival Time :");
        JTextField arrivalField1 = new JTextField();

	
            panel1.add(departureLabel);
            panel1.add(departureField);
            panel1.add(arrivalLabel);
            panel1.add(arrivalField);
	        panel1.add(departureLabel1);
            panel1.add(departureField1);
            panel1.add(arrivalLabel1);
            panel1.add(arrivalField1);

	        add(panel,BorderLayout.WEST);
            add(panel1,BorderLayout.EAST);

	    JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    aTrain[0][0]=departureAField.getText();
                    aTrain[0][1]=arrivalAField.getText();
                    aTrain[1][0]=departureAField1.getText();
                    aTrain[1][1]=arrivalAField1.getText();
                    bTrain[0][0]=departureField.getText();
                    bTrain[0][1]=arrivalField.getText();
                    bTrain[1][0]=departureField1.getText();
                    bTrain[1][1]=arrivalField1.getText();
                    int[] res=submitForm(aTrain,bTrain);

                    if(res[0]==-1 || res[1]==-1) {
                        JOptionPane.showConfirmDialog(null, "Invalid Input", "Confirmation", JOptionPane.CLOSED_OPTION);
                    }
                    else {
                        JOptionPane.showConfirmDialog(null, "Train A: "+res[0]+" Train B: "+res[1]+" ", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                    }
                }
        });

        add(submitButton,BorderLayout.SOUTH);

        setVisible(true);
     }
  
    

    private int[] submitForm(String[][] aTrain,String[][] bTrain) {
        List<Integer> departA=new ArrayList<>();
        List<Integer> arrivalA=new ArrayList<>();
        List<Integer> departB=new ArrayList<>();
        List<Integer> arrivalB=new ArrayList<>();

       for(int i=0;i<aTrain.length;i++){
            int minDepATime=splitTime(aTrain[i][0]);
            int minArrATime=splitTime(aTrain[i][1]);

            if(minDepATime==-1 || minArrATime==-1) {
                needTrain[0] = -1;
                return needTrain;
            } else if (minDepATime>minArrATime) {
                needTrain[0]=-1;
                return  needTrain;
            }
            else {
                departA.add(minDepATime);
                arrivalA.add(minArrATime);
            }
        }
        for(int i=0;i<bTrain.length;i++){
            int minDepBTime=splitTime(bTrain[i][0]);
            int minArrBTime=splitTime(bTrain[i][1]);
            if(minDepBTime==-1 || minArrBTime==-1) {
                needTrain[1] = -1;
                return needTrain;
            }
            else if (minDepBTime>minArrBTime) {
                needTrain[1]=-1;
                return  needTrain;
            }
            else {
                departB.add(minDepBTime);
                arrivalB.add(minArrBTime);
            }
        }
        int aCount=0;
        int bCount=0;
        for (int i = 0; i < departA.size(); i++) {
            if(arrivalB.isEmpty()) {
                aCount=departA.size();
                break;
            }
            if (Collections.min(arrivalB)<departA.get(i)){
                arrivalB.remove(Collections.min(arrivalB));
                continue;
            }
            if(!departA.isEmpty() && !(Collections.min(arrivalB)<departA.get(i))) {
                aCount++;
            }
        }
        needTrain[0]=aCount;
        for (int i = 0; i < departB.size(); i++) {
            if(arrivalA.isEmpty()) {
                bCount=departB.size();
                break;
            }
            if (Collections.min(arrivalA)<departB.get(i)){
                arrivalA.remove(Collections.min(arrivalA));
                continue;
            }
            if(!departB.isEmpty() &&  !(Collections.min(arrivalA)<departB.get(i))) {
                bCount++;

            }
        }
        needTrain[1]=bCount;
        return  needTrain;

    }
    private int splitTime(String s){
        String[] sp=s.split(":");
        if(sp.length!=2)
            return -1;
        else{
            String hour=sp[0];
            String min=sp[1];
            int converMin=converTime(hour,min);
//            System.out.println(converMin);
            return converMin;
        }
    }
    private int converTime(String strHour,String strMin){
        int t = Integer.parseInt(strHour) *60+ Integer.parseInt(strMin);
        return t;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrainScheduleForm1());
    }
}
