import java.awt.*;									       //Imports for the program
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class KafkaLatencyTest {                                         		       //Class,Global initiative variables
    public static String cpth = System.getProperty("user.dir");public static ProcessBuilder [] b = new ProcessBuilder[5];
    public static String LatencyFolder = cpth + "/Latency_Analysis/.JAvaFolder/Latency_Testing",date,kafka="kafka_2.10-0.9.0.1";
    public static String pathproducerconfigs = LatencyFolder + "/src/main/resources/producer.props",length="64",fq="2";
    public static String pathconsumerconfigs = LatencyFolder + "/src/main/resources/consumer.props";
    public static String pathforwardproducerconfigs = LatencyFolder + "_forward/src/main/resources/forward-producer.props";
    public static String pathforwardconsumerconfigs = LatencyFolder + "_forward/src/main/resources/forward-consumer.props";
    public static String pathprofducerjava = LatencyFolder + "/src/main/java/com/mapr/examples/Producer.java";
    public static String pathconsumerjava = LatencyFolder + "/src/main/java/com/mapr/examples/Consumer.java";
    public static String ifconfig = null, connectionIp = null, NetDevice = "",clusterDone = "";
    public static String[] lineClusterPid = new String[3];public static Process [] a = new Process[5];
    public static Process zookeeperprocess, brokerprocess, topicsprocess, mvnpackageprocess, mvnpackageforwardprocess,moveDateproc;
    public static ProcessBuilder zookeeperProcessBuilder, brokerProcessBuilder, topicsProcessBuilder, mvnpackageProcessBuilder;
    public static Process consumerprocess, producerprocess, producerconsumerprocess, Clusterprocess,ForwardProcess;
    public static ProcessBuilder consumerProcessBuilder, mvnpackageforwardProcessBuilder, producerProcessBuilder,moveDateprocBuld;
    public static ProcessBuilder producerconsumerProcessBuilder,ForwardProcessBuilder,ClusterProcessBuilder;
     /********************************************* DISPLAY GUI *******************************************/
    private void displayGUI() {					              		       //Gui Interface,create main frame
        JFrame frame = new JFrame("Absolute Layout Example");frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting of Frame
        JPanel contentPane = new JPanel();contentPane.setOpaque(true);contentPane.setBackground(Color.WHITE);contentPane.setLayout(null);
        JLabel label = new JLabel("Apache Kafka Latency App", JLabel.CENTER);label.setSize(300, 30);label.setLocation(270, 5);               
        JLabel label2 = new JLabel("Open Zookeeper,Broker and Topics locally.",JLabel.LEFT);label2.setSize(350,30);label2.setLocation(50,80);
        JLabel label3 = new JLabel("Open Producer", JLabel.LEFT);label3.setSize(350, 30);label3.setLocation(50, 130);
        JLabel label4 = new JLabel("Open Consumer", JLabel.LEFT);label4.setSize(350, 30);label4.setLocation(50, 180);
        JLabel label5 = new JLabel("Current Network IP", JLabel.LEFT);label5.setSize(350, 30);label5.setLocation(50, 230);
        JLabel label6 = new JLabel("Current Network IP", JLabel.LEFT);label6.setSize(350, 30);label6.setLocation(720, 230);
        label6.setText("    " + ifconfig);						       //Buttons fror cluster,producer,consumer and exit
        JButton button1 = new JButton("Cluster");button1.setSize(120, 30);button1.setLocation(720, 80);  //Cluster
        button1.addActionListener((ActionEvent e) -> {ClusterExecution();clusterDone="OK";button1.setEnabled(false);});
        JButton button2 = new JButton("Producer");button2.setSize(120, 30);button2.setLocation(720, 130);//Producer
        button2.addActionListener((ActionEvent e) -> {try {Create_Producer_Frame();}catch (InterruptedException ex) {}});
        JButton button3 = new JButton("Consumer");button3.setSize(120, 30);button3.setLocation(720, 180);//Consumer
        button3.addActionListener((ActionEvent e) -> {try {Create_Consumer_Frame("Consumer");}catch (InterruptedException ex) {}});
        JButton button4 = new JButton("Exit");button4.setSize(120, 30);button4.setLocation(720, 300);    //Exit
        button4.addActionListener((ActionEvent e) -> {int i = 0;      			       //Here kills opened zoo,server and forward
            try (BufferedReader fileupdate = new BufferedReader(new FileReader(cpth+"/.BashScripts/ClusterPids.txt"))) {
                String p = "";lineClusterPid[0] = "";					       //Gets PIDS from file
                while ((p = fileupdate.readLine()) != null) {lineClusterPid[i] = p;i++;}fileupdate.close();
            } catch (IOException ex) {}
            try {if(i==1){					       			       //Kills forward if exists
                    Set_Config_Files("kill", "\"", "kill -9 " + lineClusterPid[0],cpth+"/.BashScripts/NetWorkQualityKiller");
                    Process_Creator(ForwardProcessBuilder, ForwardProcess,cpth+"/.BashScripts/NetWorkQualityKiller");}
                 if("OK".equals(clusterDone)){			       			       //Kills zoo and broker if exists
                    Set_Config_Files("kill", "&", "kill -9  " + lineClusterPid[1] + " ",cpth+ "/.BashScripts/ClusterKiller");
                    Set_Config_Files("wait", "\"", "wait && kill -9  " + lineClusterPid[0],cpth+"/.BashScripts/ClusterKiller");
                    Process_Creator(ClusterProcessBuilder, Clusterprocess,cpth+"/.BashScripts/ClusterKiller");}
                    Set_Config_Files("BackUP/", "\n", "BackUP/"+date+"/",cpth+"/.BashScripts/MoveDate");
            } catch (IOException ex) {}				       			       // Sets BackUp for Results if exists
	    File folderdate = new File(cpth+"/Latency_Analysis/BackUP/"+date+"/");folderdate.mkdir();
            Process_Creator(moveDateprocBuld, moveDateproc,cpth+"/.BashScripts/MoveDate");     //Programm terminates
            File file3 = new File(cpth+"/.BashScripts/ClusterPids.txt");file3.delete();System.exit(0);
        });
        contentPane.add(label);contentPane.add(label2);contentPane.add(label3);		       //Set the frame
        contentPane.add(label4);contentPane.add(label5);contentPane.add(label6);
        contentPane.add(button1);contentPane.add(button2);contentPane.add(button3);contentPane.add(button4);
        frame.setContentPane(contentPane);frame.setSize(850, 370);frame.setLocationByPlatform(true);frame.setVisible(true);
    }/******************************************** MAIN FUNCTION ******************************************/
    public static void main(String... args) throws IOException {        		       //Main Function
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());date = date.replaceAll(" ","-");
        File folder = new File(cpth+ "/.Install_Configuration.kaf");		               //Gets date,create ack for install
        if (!folder.exists()) {System.out.println("Please run the Install first to continue");System.exit(0);}
        Ifconfig_Execution();SwingUtilities.invokeLater(new KafkaLatencyTest()::displayGUI);   //Programm STARTS HERE
    }/************************************ ZOO,BROKER,TOPICS CREATION *************************************/
    public static void ClusterExecution() {                             		       //Cluster Function
        try {
            String servPr = "/"+kafka+"/config/server.properties";      		       //Set current IP to Broker
            Set_Config_Files("#advertised.host", "\n", "advertised.host.name = " + ifconfig,cpth+servPr);
            Set_Config_Files("advertised.host", "\n", "advertised.host.name = " + ifconfig,cpth+servPr);
        } catch (IOException ex) {}                                     		       //Create Zookeeper
        Process_Creator(zookeeperProcessBuilder, zookeeperprocess,cpth+"/.BashScripts/zookeeperBash");
        try {Thread.sleep(6000);} catch (InterruptedException ex) {}    		       //Create Server-Broker
        Process_Creator(brokerProcessBuilder, brokerprocess,cpth+"/.BashScripts/serverBash");
        try {Thread.sleep(6000);}catch (InterruptedException ex) {}     		       //Create 2 Topics
        Process_Creator(topicsProcessBuilder, topicsprocess,cpth+"/.BashScripts/topicBash");
    }/************************************** GET IP ADDRESS FUNCTION **************************************/
    public static void Ifconfig_Execution() throws IOException {        		       //Ifconfig Function
        Runtime rt = Runtime.getRuntime();String[] commands = {"ifconfig"};Process proc = rt.exec(commands);  
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        String s = null;ProcessBuilder decice = null;Process Pdevice = null;ifconfig = null;
        while ((s = stdInput.readLine()) != null) {ifconfig = ifconfig + s + "\n";}
        while ((s = stdError.readLine()) != null) {ifconfig = ifconfig + s + "\n";}
        Process_Creator(decice, Pdevice,cpth+"/.BashScripts/NetDevice");
        try {Thread.sleep(4000);}catch (InterruptedException ex) {}
        try (BufferedReader fileupdate = new BufferedReader(new FileReader(cpth+"/.AvailableDevice.kaf"))) {
            String line;while ((line = fileupdate.readLine()) != null) {NetDevice += line;}fileupdate.close();
        } catch (IOException ex1) {}				        		       //Get IP and available Devices of PC
        ifconfig = ifconfig.substring(ifconfig.indexOf("wl") + 1);ifconfig = ifconfig.substring(ifconfig.indexOf(":192.") + 1);  
        ifconfig = ifconfig.substring(0, ifconfig.indexOf(" "));
    }/********************************** CHANGES LINE FROM FILE FUNCTION **********************************/        
    public static void Set_Config_Files(String start, String end, String change, String path) throws IOException {
        String line2 = "", input = "";                                  		       //Replace string from start-end with change
        try (BufferedReader fileupdate = new BufferedReader(new FileReader(path))) {
            String line;input = "";while ((line = fileupdate.readLine()) != null) {input += line + '\n';}fileupdate.close();
        }catch (IOException ex) {}
        if (input.toLowerCase().contains(start.toLowerCase())) {        		       //Replacement here
            line2 = input.substring(input.indexOf(start));line2 = line2.substring(0, line2.indexOf(end));input = input.replace(line2, change);
            try (FileOutputStream fileOut = new FileOutputStream(path)) {fileOut.write(input.getBytes());fileOut.flush();fileOut.close();}
        }
    }/******************************* CREATE PROCESS FROM GIVEN BASH SCRIPT *******************************/  
    public static void Process_Creator(ProcessBuilder processbuilder, Process process, String bash) {
        processbuilder = new ProcessBuilder(bash);try {process = processbuilder.start();} catch (IOException ex) {}
    }/************************************** CREATES PRODUCER FRAME ***************************************/                 
    public static void Create_Producer_Frame() throws InterruptedException {		       //Producer Creation Function
        JFrame framepro = new JFrame("Producer Console");				       //Frame variables
        JPanel contentPane = new JPanel();contentPane.setOpaque(true);contentPane.setLayout(null);
        JLabel labpro1 = new JLabel(" * Enter the length of messages in bytes");
        JLabel labpro2 = new JLabel(" * Enter the frequency of messages in milliseconds");
        JLabel labpro3 = new JLabel(" * Enter the IP of the machine for connection");
        JLabel labpro4 = new JLabel(" * Enter the number of consumers (optional) , (Max 6 Consumers)");
        labpro1.setSize(500, 30);labpro1.setLocation(20, 20);labpro2.setSize(500, 30);labpro2.setLocation(20, 100);
        labpro3.setSize(500, 30);labpro3.setLocation(20, 180);labpro4.setSize(500, 30);labpro4.setLocation(20, 260);
        JButton exitbpro = new JButton("Enter");exitbpro.setSize(120, 30);exitbpro.setLocation(20, 350);
        JButton exitstoppro = new JButton("Exit");exitstoppro.setSize(120, 30);exitstoppro.setLocation(350, 350);
        JTextArea areapro2 = new JTextArea();areapro2.append(length);areapro2.setSize(450, 20);areapro2.setLocation(20, 60);
        JTextArea areapro3 = new JTextArea();areapro3.append(fq);areapro3.setSize(450, 20);areapro3.setLocation(20, 130);
        JTextArea areapro4 = new JTextArea();areapro4.append(ifconfig);areapro4.setSize(450, 20);areapro4.setLocation(20, 210);
        JTextArea areapro5 = new JTextArea();areapro5.append("1");areapro5.setSize(450, 20);areapro5.setLocation(20, 290);
        contentPane.add(labpro1);contentPane.add(labpro2);contentPane.add(labpro3);contentPane.add(labpro4);
        contentPane.add(areapro2, BorderLayout.EAST);contentPane.add(areapro3, BorderLayout.EAST);contentPane.add(areapro5, BorderLayout.EAST);
        contentPane.add(areapro4, BorderLayout.EAST);contentPane.add(exitbpro);contentPane.add(exitstoppro);
        framepro.setContentPane(contentPane);framepro.setSize(500, 400);framepro.setLocationRelativeTo(null);framepro.setVisible(true);
        exitstoppro.addActionListener((ActionEvent arg1) -> {framepro.dispose();});	       //Exit Button
        exitbpro.addActionListener((ActionEvent arg1) -> {              		       //After pressing Enter Button
            connectionIp = areapro4.getText();String ConP="/src/main/resources/consumer.props";//Get Given IP
            String cNum,bts="bootstrap.servers="+connectionIp+":9092",LAR="/Latency_Analysis/Results/",bt="bootstrap";
            if ("".equals(connectionIp)) {Error_Frame("*You must insert IP First");            //Invoke Error
            } else {framepro.dispose();int z=0;length = areapro2.getText();if("".equals(length)){length = "64";}
                fq = areapro3.getText();if("".equals(fq)){fq = "2";}cNum = areapro5.getText();if("".equals(cNum)){cNum = "1";}
                if (Integer.parseInt(cNum)>6){cNum = "1";}				       //Get IP,frequency,size and number of consumer
                try {String qq,ww;ww = "size-"+length+"-Frequency-"+fq+"-Consumers-"+cNum;qq=ww+"-"+Integer.toString(z);          
                    File folder = new File(cpth+"/Latency_Analysis/Results/"+qq);
                    while(folder.exists()){z++;qq=ww+"-"+Integer.toString(z);folder = new File(cpth+"/Latency_Analysis/Results/"+qq);}
                    File folder6 = new File(cpth+"/Latency_Analysis/Results/"+qq+"/LogResults");
                    folder.mkdir();folder6.mkdir();			                       //Here sets all the apropiate files and bash Scripts
                    Set_Config_Files("nload",">","nload -t 1 -m "+NetDevice,cpth+"/.BashScripts/NetWorkUsageMonitor");
                    Set_Config_Files("iwconfig","|","iwconfig "+NetDevice,cpth+"/.BashScripts/NetWorkQualityMonitor");
                    Set_Config_Files("size","\n",qq +"/LogResults/",cpth+"/.BashScripts/MoveFile");
                    Set_Config_Files("size","\n",qq,cpth+"/.BashScripts/DeleteFolders");
                    Set_Config_Files("size","/",qq,cpth+"/Notificator.java");Set_Config_Files("sleeptime",";","sleeptime="+fq,pathprofducerjava);
                    Set_Config_Files(bt,"\n",bts,pathproducerconfigs);       Set_Config_Files(bt,"\n",bts,pathconsumerconfigs);
                    Set_Config_Files(bt,"\n",bts,LatencyFolder+"_1"+ConP);   Set_Config_Files(bt,"\n",bts,LatencyFolder+"_2"+ConP);
                    Set_Config_Files(bt,"\n",bts,LatencyFolder+"_3"+ConP);   Set_Config_Files(bt,"\n",bts,LatencyFolder+"_4"+ConP);
                    Set_Config_Files(bt,"\n",bts,LatencyFolder+"_5"+ConP);   Set_Config_Files("length",";","length="+length,pathprofducerjava);
                    Set_Config_Files("root",";","root='"+"LogResults/"+"'",cpth+"/.BashScripts/scan_folders.m");
                    Set_Config_Files("filepath",";","filepath='"+cpth+LAR+qq+"/'",cpth+"/.BashScripts/scan_folders.m");
                } catch (IOException ex) {}                             		       //Make mvn package for building
                if(Integer.parseInt(cNum)>1){
                    for(int k =1;k<Integer.parseInt(cNum);k++){				       //Case for more than one consumer
                        Process_Creator(b[k-1], a[k-1],cpth+ "/.BashScripts/mvnpackageBash"+String.valueOf(k));
                        File folder5 = new File(cpth + "/CON.txt");while (!folder5.exists()){}folder5.delete();
                    }   
                }									       //Here creates consumer and then producer process
                Process_Creator(mvnpackageProcessBuilder, mvnpackageprocess,cpth+ "/.BashScripts/mvnpackageBash");
                File folder1 = new File(cpth+ "/CON.txt");while (!folder1.exists()){}folder1.delete();
                Process_Creator(producerProcessBuilder, producerprocess,cpth+"/.BashScripts/producerbash");
            }
        });
    }/*************************************** CREATES CONSUMER FRAME **************************************/		      
    public static void Create_Consumer_Frame(String Type) throws InterruptedException {	       //Consumer Creator Function
        JFrame frame = new JFrame(Type+" Console");JPanel panel1 = new JPanel();  	       //Frame variables 
        JLabel lab1 = new JLabel(" * Enter IP of the machine you want to establish the connection");
        JButton exitb = new JButton("Enter");JButton exitb2 = new JButton("Exit");
        panel1.setPreferredSize(new Dimension(500, 70));frame.add(panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();panel2.setPreferredSize(new Dimension(500, 70));frame.add(panel2, BorderLayout.CENTER);
        JPanel panel3 = new JPanel();panel3.setPreferredSize(new Dimension(500, 70));frame.add(panel3, BorderLayout.SOUTH);
        JTextArea area2 = new JTextArea(1, 30);area2.append(ifconfig);  		       //Gets IP of pc
        panel1.add(lab1);panel2.add(area2, BorderLayout.EAST);panel3.add(exitb);panel3.add(exitb2);
        frame.setSize(500, 200);frame.setLocationRelativeTo(null);frame.setVisible(true);
        exitb2.addActionListener((ActionEvent arg0) -> {frame.dispose();});
        exitb.addActionListener((ActionEvent arg0) -> {                 		       //After pressing Enter Button
            if("Consumer".equals(Type)){
                int errorinputcount = 0;connectionIp = area2.getText();
                if ("".equals(connectionIp)) { Error_Frame("*You must insert IP First");}
                else {frame.dispose();							       //Set config files
                    try {String bts="bootstrap.servers=" + connectionIp + ":9092",bp="bootstrap";
			Set_Config_Files(bp,"\n",bts,pathforwardproducerconfigs);Set_Config_Files(bp,"\n",bts,pathforwardconsumerconfigs);
                    } catch (IOException ex) {}						       //Here creates consumer process
                    Process_Creator(mvnpackageforwardProcessBuilder, mvnpackageforwardprocess,cpth+"/.BashScripts/mvnpackageforwardBash");
                }
             }
        });
    }/**************************************** CREATES ERROR FRAME ****************************************/     
    public static void Error_Frame(String message) {                    		       //Sends an Error message 
        JFrame frameerror = new JFrame(" Error Console");               		       //Error Frame
        frameerror.setSize(200, 100);frameerror.setLocationRelativeTo(null);frameerror.setVisible(true);
        JPanel panelerror = new JPanel();JButton exiterr = new JButton("Exit");JLabel error = new JLabel(message);
        panelerror.add(error);panelerror.add(exiterr);frameerror.add(panelerror);
        exiterr.addActionListener((ActionEvent arg1) -> {frameerror.dispose();});	       //Create error frame
    }
}
