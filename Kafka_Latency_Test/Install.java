import java.io.*;								             //This programm is the installation of the Application
public class Install {									     // Class, Grobal strings and variables
    public static String cpth = System.getProperty("user.dir"),basth = "#!/bin/bash\n" + "xterm -e ",BhSc="/.BashScripts/";
    public static String JavPth="/Latency_Analysis/.JAvaFolder/Latency_Testing",kfk="/kafka_2.10-0.9.0.1/";
    public static String mvP=" && mvn package && echo \"ok\" > "+cpth+"/CON.txt && cd "+cpth+JavPth;
    public static String funl="_forward/target && ulimit -c unlimited && ./kafka-example forward \"&echo $! >> ";
    public static String unl=" && ulimit -c unlimited"+" && ./kafka-example consumer \"",fpp=cpth+JavPth+funl+cpth+BhSc;;
    public static String zsK=" && bin/kafka-server-stop.sh && sleep 5 && bin/zookeeper-server-stop.sh config/server.properties \"";
    public static String tpc=" && bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic";
    public static String zookeeperbashscript=basth+"\"cd "+cpth+kfk+" && bin/zookeeper-server-start.sh config/zookeeper.properties\"";
    public static String serverbashscript = basth+" \"cd "+cpth+kfk+" && bin/kafka-server-start.sh config/server.properties\"";
    public static String mvnpackagebashscript=basth+" \"cd "+cpth+JavPth+mvP+"/target"+unl;
    public static String mvnpackagebashscript1=basth+" \"cd "+cpth+JavPth+"_1/"+mvP+"_1/target"+unl;
    public static String mvnpackagebashscript2=basth+" \"cd "+cpth+JavPth+"_2/"+mvP+"_2/target"+unl;
    public static String mvnpackagebashscript3=basth+" \"cd "+cpth+JavPth+"_3/"+mvP+"_3/target"+unl;
    public static String mvnpackagebashscript4=basth+" \"cd "+cpth+JavPth+"_4/"+mvP+"_4/target"+unl;
    public static String mvnpackagebashscript5=basth+" \"cd "+cpth+JavPth+"_5/"+mvP+"_5/target"+unl;
    public static String mvnpackageforwardbashscript=basth+" \"cd "+cpth+JavPth+"_forward/"+" && mvn package && cd "+fpp+"ClusterPids.txt";
    public static String producerbashscript=basth+" \"cd "+cpth+JavPth+"/target"+" && ulimit -c unlimited"+" && ./kafka-example producer \"";
    public static String CpuUsagebashscript=basth+" \"top -b -d 0.001 | grep \\\"Cpu(s)\\\" >> "+cpth+"/Latency_Analysis/Results/Log.txt\"";
    public static String CpuUsageKillerbashscript=basth+" \" pkill -INT top\"",MatOctscript = basth+" \"cd " + cpth +BhSc+"\n";
    public static String NetworkUsagebashscript=basth+" \" nload -t 5 -m  wlo1 > "+cpth+"/Latency_Analysis/Results/NetWorkNloadLog.txt\"";
    public static String NetworkQualityKillerbashscript=basth+" \" kill -9 \"";
    public static String NetworkUsageKillerbashscript=basth+" \" pkill -INT nload\"\n"+"xterm -e \" pkill -INT top\"";
    public static String ClusterKillerbashscript=basth+" \" cd "+cpth+kfk+zsK;
    public static String IfconfigNetDevice=basth+" \" ifconfig | grep \"wl\" | cut -d ' ' -f 1 > "+cpth+"/.AvailableDevice.kaf\"";
    public static String MoveFiles=basth+" \" mv "+cpth+"/Latency_Analysis/Results/*.txt "+cpth+"/Latency_Analysis/Results/size/\n\"";
    public static String MoveDate=basth+" \" mv "+cpth+"/Latency_Analysis/Results/* "+cpth+"/Latency_Analysis/BackUP/\n\"";
    public static String Movefolders=basth+" \" mv "+cpth+"/Latency_Analysis/Results/size "+cpth+"/Latency_Analysis/Results/Experiment\n\"";
    public static String topicbashscript1=basth+" \"cd "+cpth+kfk+tpc+" fast-messages\"";
    public static String topicbashscript2="\n"+"xterm -e \"cd "+cpth+kfk+tpc+" fast-messages2\"";
    public static String topicbashover= topicbashscript1 + topicbashscript2,pathzookeeperbash = cpth +BhSc+"zookeeperBash";
    public static String pathserverbash= cpth +BhSc+"serverBash",pathtopicbash = cpth +BhSc+"topicBash";
    public static String pathmvnpackagebash= cpth +BhSc+"mvnpackageBash",pathmvnpackagebash1 = cpth +BhSc+"mvnpackageBash1";
    public static String pathmvnpackagebash2= cpth +BhSc+"mvnpackageBash2",pathmvnpackagebash3 = cpth +BhSc+"mvnpackageBash3";
    public static String pathmvnpackagebash4= cpth +BhSc+"mvnpackageBash4",pathmvnpackagebash5 = cpth +BhSc+"mvnpackageBash5";
    public static String pathmvnpackageforwardbash = cpth +BhSc+"mvnpackageforwardBash",pathproducerbash = cpth +BhSc+"producerbash";
    public static String pathCpuUsagebash= cpth +BhSc+"CpuUsageMonitor",pathNetworkUsageKillerbash = cpth +BhSc+"NetWorkUsageKiller";
    public static String pathCpuUsageKillerbash = cpth +BhSc+"CpuUsageKiller",pathNetworkUsagebash = cpth +BhSc+"NetWorkUsageMonitor";
    public static String pathNetworkQualitybash=cpth+BhSc+"NetWorkQualityMonitor",pathMoveDate = cpth +BhSc+"MoveDate";
    public static String pathIfconfigNetDevice = cpth +BhSc+"NetDevice",pathMoveFiles = cpth +BhSc+"MoveFile";
    public static String pathClusterKiler = cpth +BhSc+"ClusterKiller",pathMoveFolders = cpth +BhSc+"MoveFolders";
    public static String DeleteFolders=basth+"\"rm -r "+cpth+"/Latency_Analysis/Results/size \n\"",pathDeleteFolders=cpth+BhSc+"DeleteFolders";
    public static String pathMatOct = cpth +BhSc+"Plotting",Matl_Or_Octa,pathNetworkQualityKillbash=cpth+BhSc+"NetWorkQualityKiller";
    public static String NetworkQualitybashscript=basth+" \" while true;do sudo iwconfig wlo1|grep \\\"Link Quality\\\"|tr  \\\"Link Quality=SgevedBm/\\\" \\\" \\\" >> "+cpth+"/Latency_Analysis/Results/NetWorkIwfConfigLog.txt;done\"&echo $! >> "+cpth+"/.PID.kaf";
     /******************************************** MAIN FUNCTION ******************************************/
    public static void main(String args[]) throws IOException {				     //Main function , here the programm starts
        File fileMO = new File(cpth + "/.Matlab_Or_Octave.kaf");
        if(!fileMO.exists()){								     //Check if installation is already done
            try (BufferedReader fileupdate = new BufferedReader(new FileReader(cpth + "/.Matlab_Or_Octave.kaf"))) {
                String line;Matl_Or_Octa="";while ((line = fileupdate.readLine()) != null) {Matl_Or_Octa += line;}
                if(!"octave".equals(Matl_Or_Octa)&&!"matlab".equals(Matl_Or_Octa)){
                System.out.println("Error occured , please run again the Instalation");System.exit(0);}
            }catch (IOException ex) {}}							     //Check for errors,if not create all files and folders
        else{System.out.println("Error occured , please run again the Instalation");System.exit(0);}
        Folder_Creator();Bash_Creator();Create_Consumer_Java();Create_Producer_Java();Create_Matlab_Octave_Code();
        Create_Forward_Java();Create_Run_Java();Create_Extra_Consumer_Java();Create_Props();Create_Pom_Xml();Move_Folders_Ex();
        Set_Config_Files(".BashScripts/","\n",".BashScripts/ && "+Matl_Or_Octa+" scan_folders.m ; cd ../ ; javac -g Notificator.java ; java Notificator ; java MoveFolders \"",pathMatOct);
        File folder = new File(cpth + "/.Install_Configuration.kaf");
        Set_Bash_Files(cpth + "/.Install_Configuration.kaf", "Installation Success\nApplication ready to run");
        System.out.println("---------BUILT SUCCESS------------");			     // Install is done
    }/*************************************** FOLDER CREATOR FUNCTION *************************************/
    public static void Folder_Creator() throws IOException {	 			     // Folder_Creator function ,here creates all folders
        String[] Folder_Taple = new String[61];String b;	 			     // Here is a Array of all the folders names
        Folder_Taple[0] = cpth + "/.BashScripts";                   Folder_Taple[1] = cpth + "/Latency_Analysis";
        Folder_Taple[2] = cpth + "/Latency_Analysis/.JAvaFolder";   Folder_Taple[3] = cpth + JavPth;
        Folder_Taple[4] = cpth + JavPth+"_forward";                 Folder_Taple[5] = cpth + JavPth+"/src";
        Folder_Taple[6] = cpth + JavPth+"/src/main";                Folder_Taple[7] = cpth + JavPth+"/src/main/java";
        Folder_Taple[8] = cpth + JavPth+"/src/main/resources";      Folder_Taple[9] = cpth + JavPth+"/src/main/java/com";
        Folder_Taple[10] = cpth + JavPth+"/src/main/java/com/mapr"; Folder_Taple[11] = cpth + JavPth+"/src/main/java/com/mapr/examples";
        Folder_Taple[12] = cpth + JavPth+"_forward/src";            Folder_Taple[13] = cpth + JavPth+"_forward/src/main";
        Folder_Taple[14] = cpth + JavPth+"_forward/src/main/java";  Folder_Taple[15] = cpth + JavPth+"_forward/src/main/resources";
        Folder_Taple[16] = cpth + JavPth+"_forward/src/main/java/com";  Folder_Taple[17] = cpth + JavPth+"_forward/src/main/java/com/mapr";
        Folder_Taple[18] = cpth + JavPth+"_forward/src/main/java/com/mapr/examples";Folder_Taple[19] = cpth + "/Latency_Analysis/Results";
	Folder_Taple[20] = cpth + "/Latency_Analysis/BackUP";				     //Here is a loop for the folders of extra Consumers
        int j = 20;for (int k = 1; k < 6; k++) {b=cpth + JavPth+"_" + String.valueOf(k);
            j++;Folder_Taple[j] = b;                           j++;Folder_Taple[j] = b+"/src";
            j++;Folder_Taple[j] = b+"/src/main";               j++;Folder_Taple[j] = b+"/src/main/java";
            j++;Folder_Taple[j] = b+"/src/main/resources";     j++;Folder_Taple[j] = b+"/src/main/java/com";
            j++;Folder_Taple[j] = b+"/src/main/java/com/mapr"; j++;Folder_Taple[j] = b+"/src/main/java/com/mapr/examples";
        }										     //Here is the creation of the folders
	for (int i = 0; i < 61; i++) {Create_Folders(Folder_Taple[i]);}
    }/***************************** BASH SCRIPT,JAVA AND MATLAB FILE FUNCTION *****************************/
    public static void Bash_Creator() throws IOException {				     //Bash_Creator functions , Creates all the files
        String[][] Bash_Taple = new String[24][2];					     //Here is an array of all tha files names
        Bash_Taple[0][0]  = pathzookeeperbash;               Bash_Taple[0][1]  = zookeeperbashscript;
        Bash_Taple[1][0]  = pathserverbash;                  Bash_Taple[1][1]  = serverbashscript;
        Bash_Taple[2][0]  = pathtopicbash;                   Bash_Taple[2][1]  = topicbashover;
        Bash_Taple[3][0]  = pathmvnpackagebash;              Bash_Taple[3][1]  = mvnpackagebashscript;
        Bash_Taple[4][0]  = pathproducerbash;                Bash_Taple[4][1]  = producerbashscript;
        Bash_Taple[5][0]  = pathmvnpackageforwardbash;       Bash_Taple[5][1]  = mvnpackageforwardbashscript;
        Bash_Taple[6][0]  = pathCpuUsagebash;                Bash_Taple[6][1]  = CpuUsagebashscript;
        Bash_Taple[7][0]  = pathNetworkUsagebash;            Bash_Taple[7][1]  = NetworkUsagebashscript;
        Bash_Taple[8][0]  = pathNetworkUsageKillerbash;      Bash_Taple[8][1]  = NetworkUsageKillerbashscript;
        Bash_Taple[9][0]  = pathCpuUsageKillerbash;          Bash_Taple[9][1]  = CpuUsageKillerbashscript;
        Bash_Taple[10][0] = pathNetworkQualitybash;          Bash_Taple[10][1] = NetworkQualitybashscript;
        Bash_Taple[11][0] = pathNetworkQualityKillbash;      Bash_Taple[11][1] = NetworkQualityKillerbashscript;
        Bash_Taple[12][0] = pathIfconfigNetDevice;           Bash_Taple[12][1] = IfconfigNetDevice;
        Bash_Taple[13][0] = pathMoveFiles;                   Bash_Taple[13][1] = MoveFiles;
        Bash_Taple[14][0] = pathClusterKiler;                Bash_Taple[14][1] = ClusterKillerbashscript;
        Bash_Taple[15][0] = pathmvnpackagebash1;             Bash_Taple[15][1] = mvnpackagebashscript1;
        Bash_Taple[16][0] = pathmvnpackagebash2;             Bash_Taple[16][1] = mvnpackagebashscript2;
        Bash_Taple[17][0] = pathmvnpackagebash3;             Bash_Taple[17][1] = mvnpackagebashscript3;
        Bash_Taple[18][0] = pathmvnpackagebash4;             Bash_Taple[18][1] = mvnpackagebashscript4;
        Bash_Taple[19][0] = pathmvnpackagebash5;             Bash_Taple[19][1] = mvnpackagebashscript5;
        Bash_Taple[20][0] = pathMatOct;                      Bash_Taple[20][1] = MatOctscript;
        Bash_Taple[21][0] = pathMoveFolders;                 Bash_Taple[21][1] = Movefolders;
        Bash_Taple[22][0] = pathMoveDate;                    Bash_Taple[22][1] = MoveDate;
        Bash_Taple[23][0] = pathDeleteFolders;               Bash_Taple[23][1] = DeleteFolders;
        for (int i = 0; i < 24; i++) {Set_Bash_Files(Bash_Taple[i][0], Bash_Taple[i][1]);}
    }/**************************************** CREATION OF FOLDERS ****************************************/					
    public static void Create_Folders(String path) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File folder = new File(path);if (!folder.exists()) {folder.mkdir();}		     //Here creates all folders
    }/********************************* CREATION OF .BASH,.JAVA,.M FILES **********************************/					
    public static void Set_Bash_Files(String path, String script) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try (PrintWriter writer = new PrintWriter(path, "UTF-8")) {writer.println(script);writer.close();}
        final File file = new File(path);file.setReadable(true, false);file.setExecutable(true, false);file.setWritable(true, false);
    }/********************************** CREATION OF EXTRA CONSUMER.JAVA **********************************/
    public static void Create_Extra_Consumer_Java() throws IOException { 		     //Here creates the extraConsumer java files
        String sp="         ",consumer = "package com.mapr.examples;\n"
                + "import com.fasterxml.jackson.databind.JsonNode;\nimport com.fasterxml.jackson.databind.ObjectMapper;\n"
                + "import com.google.common.io.Resources;\nimport org.HdrHistogram.Histogram;\n"
                + "import org.apache.kafka.clients.consumer.ConsumerRecord;\n"
                + "import org.apache.kafka.clients.consumer.ConsumerRecords;\n"
                + "import org.apache.kafka.clients.consumer.KafkaConsumer;\n"
                + "import java.io.*;\nimport java.util.*;\nimport java.lang.System;\nimport java.lang.Runtime;\n"
                + "import java.util.logging.Level;\nimport java.util.logging.Logger;\n\npublic class Consumer {\n\n"
                + "     public static double [][] globalLatencyarray = new double[1000][4];\n"
                + "     public static double [] statLatencyarray = new double[1000];\n\n"
                + "     public static void main(String[] args) throws IOException,InterruptedException {\n\n"
                + "         String LogFile = \"" + cpth + "/Latency_Analysis/Results/LogFile.txt\";	\n"
                + "         String pathLogoverallfile = \"" + cpth + "/Latency_Analysis/Results/LogOverallFile.txt\";\n"
                + "         ObjectMapper mapper = new ObjectMapper();\n"+sp+"Histogram stats = new Histogram(1, 10000000, 2);\n"
                + "         Histogram global = new Histogram(1, 10000000, 2);\n"+sp+"int counterLatency = 0;\n"
                + "         File myFile,myFile1;\n"+sp+"myFile=new File(LogFile);\n"+sp+"if(!myFile.exists()){\n"
                + "             myFile.createNewFile();\n"+sp+"}\n"+sp+"FileWriter fw = new FileWriter(LogFile);\n"
                + "         final PrintWriter pw = new PrintWriter(fw);\n"+sp+"myFile1=new File(pathLogoverallfile);\n"
                + "         if(!myFile1.exists()){\n"
                + "             myFile1.createNewFile();\n"+sp+"}\n"+sp+"FileWriter fw1 = new FileWriter(pathLogoverallfile );\n"
                + "         final PrintWriter pw1 = new PrintWriter(fw1);\n"+sp+"KafkaConsumer<String, String> consumer;\n"
                + "         try (InputStream props = Resources.getResource(\"consumer.props\").openStream()) {\n"
                + "             Properties properties = new Properties();\n             properties.load(props);\n"
                + "             if (properties.getProperty(\"group.id\") == null) {\n"
                + "                 properties.setProperty(\"group.id\", \"group-\" + new Random().nextInt(100000));\n"
                + "             }\n             consumer = new KafkaConsumer<>(properties);\n"
                + "         }\n"+sp+"consumer.subscribe(Arrays.asList(\"fast-messages2\", \"summary-markers2\"));\n"
                + "         int timeouts = 0;\n"+sp+"while (true) {\n             ConsumerRecords<String, String> records = consumer.poll(200);\n"
                + "             if (records.count() == 0) {\n                 timeouts++;\n             } else {\n"
                + "                 System.out.printf(\"Got %d records after %d timeouts\\n\", records.count(), timeouts);\n"
                + "                 timeouts = 0;\n             }\n"
                + "             long diff=0,i =0;\n             for (ConsumerRecord<String, String> record : records) {\n"
                + "                 switch (record.topic()) {\n                     case \"fast-messages2\":\n"
                + "                         JsonNode msg = mapper.readTree(record.value());\n"
                + "                         switch(msg.get(\"type\").asText()){\n                             case \"test\": \n"
                + "                                 long latency=(long)(((System.nanoTime()* 1e-9  msg.get(\"t\").asDouble() * 1000)/2);\n"
                + "                                 stats.recordValue(latency);\n"
                + "                                 global.recordValue(latency);\n"
                + "                                 break;\n                             case \"marker\":\n"
                + "                                 System.out.printf(\"%d messages ,latency(min,max,avg,99%%)= %d,%d,%.1f,%d(ms)\\n\",\n"
                + "                                     global.getTotalCount(),\n"
                + "                                     global.getValueAtPercentile(0), global.getValueAtPercentile(100),\n"
                + "                                     global.getMean(), global.getValueAtPercentile(99));\n"
                + "                                 statLatencyarray[counterLatency]=stats.getMean();\n"
                + "                                 globalLatencyarray[counterLatency][0]=global.getMean();\n"
                + "                                 globalLatencyarray[counterLatency][1]=(double)(global.getValueAtPercentile(0));\n"
                + "                                 globalLatencyarray[counterLatency][2]=(double)(global.getValueAtPercentile(100));\n"
                + "                                 globalLatencyarray[counterLatency][3]=(double)(global.getValueAtPercentile(99));\n"
                + "                                 counterLatency++;\n                                 if(global.getTotalCount()>99900){\n"
                + "                                     for(counterLatency=0;counterLatency<1000;counterLatency++){\n"
                + "                                         pw1.print(globalLatencyarray[counterLatency][0]);\n"
                + "                                         pw1.print(\" \");\n"
                + "                                         pw1.print(globalLatencyarray[counterLatency][1]);\n"
                + "                                         pw1.print(\" \");\n"
                + "                                         pw1.print(globalLatencyarray[counterLatency][2]);\n"
                + "                                         pw1.print(\" \");\n"
                + "                                         pw1.print(globalLatencyarray[counterLatency][3]);\n"
                + "                                         pw1.print(\"\\n\");\n"
                + "                                         pw.print(statLatencyarray[counterLatency]);\n"
                + "                                         pw.print(\"\\n\");}\n"          
                + "                                     pw.close();\n                                     pw1.close();\n"
                + "                                     System.exit(0);\n"
                + "                                 }\n                                 stats.reset();\n"
                + "                                 break;\n                             default:\n"
                + "                                 throw new IllegalArgumentException(\"Illegal message type: \" + msg.get(\"type\"));\n"
                + "                         }\n                         break;\n                     case \"summary-markers2\":\n"
                + "                         break;\n                     default:\n"
                + "                         throw new IllegalStateException(\"Not possible to get message on topic \" + record.topic());\n"
                + "                 }\n             }\n         }\n     }\n}";
        for (int i = 1; i < 6; i++) {							     //here is the creation of the java files
            Set_Bash_Files(cpth +JavPth+"_" + String.valueOf(i) + "/src/main/java/com/mapr/examples/Consumer.java", consumer);
            Set_Config_Files("LogFile.","txt","LogFile"+String.valueOf(i)+ ".",cpth+JavPth+"_"+String.valueOf(i)+"/src/main/java/com/mapr/examples/Consumer.java");
            Set_Config_Files("LogOverallFile.","txt","LogOverallFile"+String.valueOf(i)+".",cpth+JavPth+"_"+String.valueOf(i)+"/src/main/java/com/mapr/examples/Consumer.java");
        }
    }/************************************* CREATION OF CONSUMER.JAVA *************************************/
    public static void Create_Consumer_Java() throws IOException {			     //Here creates the main Consumer java
        String consumer = "package com.mapr.examples;\nimport com.fasterxml.jackson.databind.JsonNode;\n"
                + "import com.fasterxml.jackson.databind.ObjectMapper;\nimport com.google.common.io.Resources;\n"
                + "import org.apache.kafka.clients.consumer.ConsumerRecord;\nimport org.apache.kafka.clients.consumer.ConsumerRecords;\n"
                + "import org.apache.kafka.clients.consumer.KafkaConsumer;\nimport java.io.*;\n"
                + "import java.util.*;\nimport java.util.logging.Level;\nimport java.util.logging.Logger;\n"
                + "import java.lang.System;\nimport java.lang.Runtime;\n\npublic class Consumer {\n\n"
                + "     public static String KillCpuUsagePath = \"" + cpth + "/.BashScripts/CpuUsageKiller\";	\n"
                + "     public static String NetworkUsagePath = \"" + cpth + "/Latency_Analysis/Results/NetWorkNloadLog.txt\";	\n"
                + "     public static String CpuUsagePath = \"" + cpth + "/Latency_Analysis/Results/Log.txt\";\n"
                + "     public static String NetworkQualityKillerbashPath = \"" + cpth + "/.BashScripts/NetWorkQualityKiller\";\n"
                + "     public static double [] statLatencyarray = new double[1000];\n     public static double ovlatn;\n"
                + "     public static long consumerTime,producerTime;\n"
		+ "     public static Process MoveFileProcess,KillNetQualityProcess,KillCpuUsageProcess,KillNetworkUsageProcess;\n"
                + "     public static void main(String[] args) throws IOException,InterruptedException {\n\n"
                + "         String LogFile = \"" + cpth + "/Latency_Analysis/Results/LogFile.txt\";	\n"
                + "         String pathLogoverallfile = \"" + cpth + "/Latency_Analysis/Results/LogOverallFile.txt\";\n"
                + "         String varFile = \"" + cpth + "/Latency_Analysis/Results/LogOverallVarFile.txt\";\n"
                + "         ObjectMapper mapper = new ObjectMapper();\n"
                + "         File myFile,myFile1,myFile3;\n         int counterLatency = 0;\n         myFile=new File(LogFile);\n"
                + "         if(!myFile.exists()){\n             myFile.createNewFile();\n         }\n"
                + "         FileWriter fw = new FileWriter(LogFile);\n         final PrintWriter pw = new PrintWriter(fw);\n"
 		+ "         myFile3=new File(varFile);\n         if(!myFile3.exists()){\n             myFile3.createNewFile();\n         }\n"
                + "         FileWriter fw2 = new FileWriter(varFile);\n         final PrintWriter pw2 = new PrintWriter(fw2);\n"
                + "         myFile1=new File(pathLogoverallfile);\n         if(!myFile1.exists()){\n"
                + "             myFile1.createNewFile();\n         }\n         FileWriter fw1 = new FileWriter(pathLogoverallfile );\n"
                + "         final PrintWriter pw1 = new PrintWriter(fw1);\n\n\n         Runtime.getRuntime().addShutdownHook(new Thread() {\n"
                + "                 public void run() { \n                 String linee;\n                 String inputt =\"\";\n"
                + "                 try(BufferedReader in = new BufferedReader(new FileReader(\"" + cpth + "/.PID.kaf\"))){;\n"
                + "                     while ((linee = in.readLine()) != null) {\n"
                + "                         inputt = \"#!/bin/bash\\n\" + \"xterm -e \\\" kill -9 \" + linee+\"\\\"\";\n"
                + "                         try (FileOutputStream fileOut = new FileOutputStream(NetworkQualityKillerbashPath)) {\n"
                + "                             fileOut.write(inputt.getBytes());\n"
                + "                         }\n                         catch (IOException ex) {}\n"
                + "                     }\n                     in.close();\n                 }\n"
                + "                 catch (IOException ex) {}\n"
                + "                 ProcessBuilder KillNetQualityBuilder = new ProcessBuilder(NetworkQualityKillerbashPath);\n"
                + "                 try {\n                     KillNetQualityProcess = KillNetQualityBuilder.start();\n"
                + "                 } catch (IOException ex) {}\n"
                + "                 ProcessBuilder KillCpuUsageBuilder = new ProcessBuilder(KillCpuUsagePath);\n"
                + "                 try {\n                     KillCpuUsageProcess = KillCpuUsageBuilder.start();\n"
                + "                 } catch (IOException ex) {}\n"
                + "                 ProcessBuilder KillNetworkUsageBuilder = new ProcessBuilder(\"" + pathNetworkUsageKillerbash + "\");\n"
                + "                 try {\n                     KillNetworkUsageProcess = KillNetworkUsageBuilder.start();\n"
                + "                 } catch (IOException ex) {}\n                 try {\n"
                + "                     KillNetQualityProcess.waitFor();KillCpuUsageProcess.waitFor();KillNetworkUsageProcess.waitFor();\n"     
		+ "                 } catch (InterruptedException ex) {}\n"
                + "                 String line2 = \"\";\n                 String input = \"\";\n"
                + "                 String line = \"\";\n                 Double value;\n"
                + "                 try (BufferedReader fileupdate2 = new BufferedReader(new FileReader(CpuUsagePath))) {\n"
                + "                     PrintWriter writer2=new PrintWriter(\""+cpth+"/Latency_Analysis/Results/CpuUsageLog.txt\""
                + ",\"UTF-8\");\n                     while ((line = fileupdate2.readLine()) != null) {\n"
                + "                         line2 = line.substring(line.indexOf(\":\") + 1, line.indexOf(\"us,\"));\n"
                + "                         input = input + line2+\"" + "\\n" + "\";\n"
                + "                     }\n                     writer2.println(input);\n"
                + "                     writer2.close();\n                 }\n"
                + "                 catch (Exception e) {}\n                 try{\n"
                + "                     File file2 = new File(\"" + cpth + "/Latency_Analysis/Results/Log.txt\");\n"
                + "                     file2.delete();\n                 }catch(Exception e){}\n                 input = \"\";\n"
                + "                 try (BufferedReader fileupdate = new BufferedReader(new FileReader(NetworkUsagePath))) {\n"
                + "                     PrintWriter writer=new PrintWriter(\""+cpth+"/Latency_Analysis/Results/NetworkLog.txt\",\"UTF-8\");"
                + "\n                     while ((line = fileupdate.readLine()) != null) {\n"
                + "                         if (line.toLowerCase().indexOf(\"Curr\".toLowerCase()) != -1) {\n"
                + "                             line2 = line.substring(line.indexOf(\":\") + 1, line.indexOf(\"B\"));\n"
                + "                             if (line2.toLowerCase().indexOf(\"k\".toLowerCase()) != -1) {\n"
                + "                                 line2 = line2.substring(0, line2.indexOf(\"k\"));\n"
                + "                                 value = Double.parseDouble(line2);\n                                 value = value * 1000;\n"
                + "                                 line2 = String.valueOf(value);\n                             }\n"
                + "                             if (line2.toLowerCase().indexOf(\"M\".toLowerCase()) != -1) {\n"
                + "                                 line2 = line2.substring(0, line2.indexOf(\"M\"));\n"
                + "                                 value=Double.parseDouble(line2);\n                                 value = value * 1000000;\n"
                + "                                 line2 = String.valueOf(value);\n                             }\n"
                + "                             input=input+line2+\" \";\n                            line2=line.substring(line.indexOf(\"s\"));\n"
                + "                             line2 = line2.substring(line2.indexOf(\":\") + 1, line2.indexOf(\"B\"));\n"
                + "                             if (line2.toLowerCase().indexOf(\"k\".toLowerCase()) != -1) {\n"
                + "                                 line2 = line2.substring(0, line2.indexOf(\"k\"));\n"
                + "                                 value = Double.parseDouble(line2);\n                                 value = value * 1000;\n"
                + "                                 line2 = String.valueOf(value);\n                             }\n"
                + "                             if (line2.toLowerCase().indexOf(\"M\".toLowerCase()) != -1) {\n"
                + "                                 line2 = line2.substring(0, line2.indexOf(\"M\"));\n"
                + "                                 value=Double.parseDouble(line2);\n                                 value = value * 1000000;\n"
                + "                                 line2 = String.valueOf(value);\n                             }\n"
                + "                             input = input + line2 + \"\\n\";                         }\n                     }\n"
                + "                     writer.println(input);\n                     writer.close();\n"
                + "                 }\n                 catch (Exception e) {}\n                 try{\n"
                + "                     File file = new File(\"" + cpth + "/Latency_Analysis/Results/NetWorkNloadLog.txt\");\n"
                + "                     file.delete();\n                 }catch(Exception e){}\n"
                + "                 try{\n                     File filepid = new File(\"" + cpth + "/.PID.kaf\");\n"
                + "                     filepid.delete();\n                 }catch(Exception e){}\n"
		+ "                 int counterLatency;\n                 double globalLatency = 0,v= 0;\n"
                + "                 for(counterLatency=0;counterLatency<1000;counterLatency++){\n"
                + "                     pw.print(statLatencyarray[counterLatency]);\n                     pw.print(\"\\n\");\n"
		+ "		     if(counterLatency > 1){\n      	 	        "
		+ "v=v*((counterLatency-2)/(counterLatency-1))+((Math.pow(statLatencyarray[counterLatency]-globalLatency,2))/counterLatency);}\n" 
                + "                     globalLatency = globalLatency + ((statLatencyarray[counterLatency]-globalLatency)/(counterLatency+1));\n" 
		+ "                     pw1.print(globalLatency);\n                     pw1.print(\"\\n\");\n"                    
		+ "                     pw2.print(v);\n                     pw2.print(\"\\n\");\n"                    
		+ "                     ovlatn=globalLatency;\n"
                + "                 }\n                 try{\n                     BufferedReader stdInput = new BufferedReader"
                + "(new FileReader(\""+cpth+"/Latency_Analysis/Results/ProgramTime.txt\"));\n"
                + "                     String jj,line5 =stdInput.readLine();jj=line5;\n"
                + "                     line5 =stdInput.readLine();double rr,mess2;int mess;\n"
                + "                     stdInput.close();\n                     producerTime=Long.parseLong(line5);\n"
                + "                     PrintWriter totaltime = new PrintWriter(new BufferedWriter"
                + "(new FileWriter(\""+cpth+"/Latency_Analysis/Results/ProgramTime.txt\",true)));\n"
                + "                     totaltime.println((double)(consumerTime-producerTime)/(double)1000000000);\n"
                + "                     mess=Integer.parseInt(jj)/100000;\n"
                + "                     mess2=((double)(Integer.parseInt(jj)))/((double)(consumerTime-producerTime)/(double)1000000000);\n"
                + "                     rr=(double)(mess2)/(double)(mess);\n                     totaltime.println(rr);\n"
                + "                     totaltime.println(ovlatn);\n"
		+ "			totaltime.println(v);\n                     totaltime.close();\n"
                + "                 }catch(IOException exxx){}\n                 pw.close();\n                 pw1.close();pw2.close();\n"
  		+ "                 ProcessBuilder MoveFileUsageBuilder=new ProcessBuilder(\""+cpth+"/.BashScripts/MoveFile\");\n"
                + "                 try {\n                         MoveFileProcess = MoveFileUsageBuilder.start();\n"
                + "                 }catch(IOException ex){}\n" 
		+ "                 try{ MoveFileProcess.waitFor();}catch (InterruptedException ex) {}\n"
                + "                 ProcessBuilder MathOctBuilder = new ProcessBuilder(\"" + cpth + "/.BashScripts/Plotting\");\n"
                + "                 try {\n                     Process MathOctProcess = MathOctBuilder.start();\n"
                + "                 }catch(IOException ex){}\n             }\n         });\n\n\n         KafkaConsumer<String, String> consumer;\n"
                + "         try (InputStream props = Resources.getResource(\"consumer.props\").openStream()) {\n"
                + "             Properties properties = new Properties();\n             properties.load(props);\n"
                + "             if (properties.getProperty(\"group.id\") == null) {\n"
                + "                 properties.setProperty(\"group.id\", \"group-\" + new Random().nextInt(100000));\n"
                + "             }\n             consumer = new KafkaConsumer<>(properties);\n"
                + "         }\n         consumer.subscribe(Arrays.asList(\"fast-messages2\"));\n"
		+ "         int countermess=1,i=0;\n         double statsLatency=0;\n"
                + "         while (true) {\n             ConsumerRecords<String, String> records = consumer.poll(200);\n"
                + "             for (ConsumerRecord<String, String> record : records) {\n"
                + "                 switch (record.topic()) {\n                     case \"fast-messages2\":\n"
                + "                         JsonNode msg = mapper.readTree(record.value());\n"
                + "                         switch (msg.get(\"type\").asText()) {\n"
                + "                             case \"test\": \n"
                + "                                 long latency=(long)(((System.nanoTime()* 1e-9 -msg.get(\"t\").asDouble())*1000)/2);\n"
                + "                                 statsLatency=statsLatency+latency;\n                                 i++;\n"
		+ "                                 break;\n                             case \"marker\":\n"
	        + "                                 statsLatency=(long)(statsLatency/i);\n"
                + "                                 System.out.printf(\"Consumer received : %4d/1000 packages of 100 messages\\n\",countermess);\n"
 		+ "                                 statLatencyarray[counterLatency]=statsLatency;\n"
                + "                                 statsLatency=0;i=0;countermess++;\n"
                + "                                 counterLatency++;\n                                 if(countermess>1000){\n"
                + "                                         consumerTime = System.nanoTime();\n"
                + "                                         System.exit(0);\n"
                + "                                 }\n"
                + "                                 break;\n                             default:\n"
                + "                                 throw new IllegalArgumentException(\"Illegal message type: \" + msg.get(\"type\"));\n"
                + "                         }\n                         break;\n                 default:\n"
                + "                         throw new IllegalStateException(\"Not possible to get message on topic \" + record.topic());\n"
                + "                 }\n             }\n         }\n     }\n}";		     //Here create the java file
        Set_Bash_Files(cpth +JavPth+"/src/main/java/com/mapr/examples/Consumer.java", consumer);
    }/************************************* CREATION OF PRODUCER.JAVA *************************************/
    public static void Create_Producer_Java() throws UnsupportedEncodingException, IOException {
        String s1="     ",s2=s1+"    ",producer = "package com.mapr.examples;\n"	     //here creates the producer java file 
                + "import com.google.common.io.Resources;\nimport org.apache.kafka.clients.producer.KafkaProducer;\n"
                + "import org.apache.kafka.clients.producer.ProducerRecord;\nimport java.util.*;\nimport java.io.*;\n\n"
                + "public class Producer {\n\n     public static String CpuUsagePath = \"" + cpth + "/.BashScripts/CpuUsageMonitor\";\n"
                + "     public static String NetworkUsagebashPath = \"" + cpth + "/.BashScripts/NetWorkUsageMonitor\";\n"
                + "     public static String NetworkQualitybashPath = \"" + cpth + "/.BashScripts/NetWorkQualityMonitor\";\n"
                + "     public static Process CpuUsageProcess;\n"+s1+"public static Process NetworkUsageProcess;\n"
                + "     public static Process NetworkQualityProcess;\n\n"+s1+"public static void main(String[] args)"
                + " throws IOException,InterruptedException {Thread.sleep(3000);\n\n"
                + "         int sleeptime = 2;\n"+s2+"int length = 1;\n"+s2+"PrintWriter totaltime = new PrintWriter"
                + "(\""+cpth+"/Latency_Analysis/Results/ProgramTime.txt\",\"UTF-8\");\n"
                + "         KafkaProducer<String, String> producer;\n"+s2+"try "
                + "(InputStream props = Resources.getResource(\"producer.props\").openStream()) {\n"
                + "             Properties properties = new Properties();\n"+s2+"    "+"properties.load(props);\n"
                + "             producer = new KafkaProducer<>(properties);\n"+s2+"}\n"+s2+"try {\n"+s2+"    "+"String string = \"a\"; \n"
                + "             totaltime.println(length*100000);\n             int g;\n"+s2+"    "+"for(g=1;g<length;g++){\n"
                + "                 string = string + \"a\";\n"+s2+"    "+"}\n"+s2+"    "+"for (int i = 0; i < 100000; i++) {\n"
                + "                 if (i == 1){\n                     Thread.sleep(10000);\n"
                + "                     ProcessBuilder CpuUsageBuilder = new ProcessBuilder(CpuUsagePath);\n"
                + "                     try {\n                         CpuUsageProcess = CpuUsageBuilder.start();\n"
                + "                     } catch (IOException ex) {}\n"
                + "                     ProcessBuilder NetworkUsageBuilder = new ProcessBuilder(NetworkUsagebashPath);\n"
                + "                     try {\n                         NetworkUsageProcess = NetworkUsageBuilder.start();\n"
                + "                     } catch (IOException ex) {}\n"
                + "                     ProcessBuilder NetworkQualityBuilder = new ProcessBuilder(NetworkQualitybashPath);\n"
                + "                     try {\n                         NetworkQualityProcess = NetworkQualityBuilder.start();\n"
                + "                     } catch (IOException ex) {}\n"
                + "                     totaltime.println(System.nanoTime());\n                     totaltime.close();\n"
                + "                 }\n"
                + "                 producer.send(new ProducerRecord<String, String>(\n                 \"fast-messages\",\n"
                + "                 String.format(\"{\\\"type\\\":\\\"test\\\", \\\"t\\\":\\\"%.3f\\\", \\\"k\\\":\\\"%d\\\","
                + " \\\"m\\\":\\\"%s\\\"}\", System.nanoTime() * 1e-9, i, string)));\n"
                + "                 if (i % 100 == 0) {\n                     try {\n"
                + "                         Thread.sleep(sleeptime);\n"
                + "                     } \n                     catch(InterruptedException ex) {}\n"
                + "                     producer.send(new ProducerRecord<String, String>(\"fast-messages\",\n"
                + "                     String.format(\"{\\\"type\\\":\\\"marker\\\", \\\"t\\\":\\\"%.3f\\\", \\\"k\\\":\\\"%d\\\","
                + " \\\"m\\\":\\\"%s\\\"}\", System.nanoTime() * 1e-9, i, string)));\n"
                + "                     producer.flush();\n                     System.out.println(\"Sent msg number \" + i);\n"
                + "                 }\n"
                + "             }\n"+s2+"} catch (Throwable throwable) {}\n"+s2+"CpuUsageProcess.getOutputStream().close();\n     }\n}";
        Set_Bash_Files(cpth +JavPth+"/src/main/java/com/mapr/examples/Producer.java", producer);
    }/************************************** CREATION OF FORWARD.JAVA *************************************/ 
    public static void Create_Forward_Java() throws IOException {                            //Here is the creation of Forward Java File
        String forward = "package com.mapr.examples;\nimport com.fasterxml.jackson.databind.JsonNode;\n"
                + "import com.fasterxml.jackson.databind.ObjectMapper;\nimport org.apache.kafka.clients.consumer.ConsumerRecord;\n"
                + "import com.google.common.io.Resources;\nimport org.HdrHistogram.Histogram;\n"
                + "import org.apache.kafka.clients.consumer.ConsumerRecords;\nimport org.apache.kafka.clients.producer.KafkaProducer;\n"
                + "import org.apache.kafka.clients.consumer.KafkaConsumer;\nimport com.google.common.io.Resources;\n"
                + "import org.apache.kafka.clients.producer.ProducerRecord;\nimport java.io.*;\nimport java.util.*;\n"
                + "import java.util.logging.Level;\nimport java.util.logging.Logger;\nimport java.lang.System;\nimport java.lang.Runtime;\n"
                + "\npublic class Forward {\n\n    public static void main(String[] args) throws IOException {\n\n"
                + "        KafkaConsumer<String, String> consumer;\n"
                + "        try (InputStream props = Resources.getResource(\"forward-consumer.props\").openStream()) {\n"
                + "            Properties properties = new Properties();\n"
                + "            properties.load(props);\n            if (properties.getProperty(\"group.id\") == null) {\n"
                + "                properties.setProperty(\"group.id\", \"group-\" + new Random().nextInt(100000));\n"
                + "            }\n            consumer = new KafkaConsumer<>(properties);\n"
                + "        }\n        consumer.subscribe(Arrays.asList(\"fast-messages\"));\n        KafkaProducer<String, String> producer;\n"
                + "        try (InputStream props = Resources.getResource(\"forward-producer.props\").openStream()) {\n"
                + "            Properties properties = new Properties();\n            properties.load(props);\n"
                + "            producer = new KafkaProducer<>(properties);\n        }\n"
                + "        int timeouts = 0;\n        while (true) {\n            ConsumerRecords<String, String> records = consumer.poll(200);\n"
                + "            if (records.count() == 0) {\n                timeouts++;\n            } \n            else {\n"
                + "                System.out.printf(\"Got %d records after %d timeouts\\n\", records.count(), timeouts);\n"
                + "                timeouts = 0;\n            }\n"
                + "            for (ConsumerRecord<String, String> record : records) {\n"
                + "                producer.send( new ProducerRecord<String, String>(record.topic() + \"2\", record.value()) );\n"
                + "            }\n        }\n    }\n}";					     //Here is the creation of java file
        Set_Bash_Files(cpth +JavPth+"_forward/src/main/java/com/mapr/examples/Forward.java", forward);
    }/*************************************** CREATION OF RUN.JAVA ****************************************/
    public static void Create_Run_Java() throws IOException {				     //for Producer Consumer
        String run = "package com.mapr.examples;\nimport java.io.IOException;\n\n"
                + "public class Run {\n\n    public static void main(String[] args) throws IOException,InterruptedException {\n\n"
                + "        switch (args[0]) {\n            case \"producer\":\n"
                + "                   Producer.main(args);\n                    break;\n            case \"consumer\":\n"
                + "                    Consumer.main(args);\n                    break;\n            default:\n"
                + "                    throw new IllegalArgumentException(\"Don't know how to do \" + args[0]);\n"
                + "        }\n    }\n}";
        String run_Extra = "package com.mapr.examples;\n\n"				     //For extras Consumer
                + "import java.io.IOException;\n\npublic class Run {\n\n"
                + "    public static void main(String[] args) throws IOException,InterruptedException {\n\n"
                + "        switch (args[0]) {case \"consumer\":Consumer.main(args);break;\n"
                + "            default:throw new IllegalArgumentException(\"Don't know how to do \" + args[0]);\n"
                + "        }\n    }\n}";						     //For Forward
        String run_forward = "package com.mapr.examples;\nimport java.io.IOException;\n\n"
                + "public class Run {\n\n    public static void main(String[] args) throws IOException,InterruptedException {\n\n"
                + "        switch (args[0]) {\n            case \"forward\":\n"
                + "                    Forward.main(args);\n                    break;\n            default:\n"
                + "                    throw new IllegalArgumentException(\"Don't know how to do \" + args[0]);\n"
                + "        }\n    }\n}";						     //Here is the creation of java files
        Set_Bash_Files(cpth +JavPth+"/src/main/java/com/mapr/examples/Run.java", run);
        Set_Bash_Files(cpth +JavPth+"_forward/src/main/java/com/mapr/examples/Run.java", run_forward);
        for(int i=1;i<6;i++){ Set_Bash_Files(cpth+JavPth+"_"+String.valueOf(i)+"/src/main/java/com/mapr/examples/Run.java",run_Extra);}
    }/************************************ CREATION OF PROPERTIES FILES ***********************************/
    public static void Create_Props() throws IOException {				     //Creates the properties text files
        String consumerProps = "bootstrap.servers=192.168.2.6:9092\n"			     //Consumer Props
                + "oup.id=testenable.auto.commit=true\nkey.deserializer=org.apache.kafka.common.serialization.StringDeserializer\n"
                + "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer\n"
                + "session.timeout.ms=10000\nfetch.min.bytes=50000\nreceive.buffer.bytes=262144\nmax.partition.fetch.bytes=2097152";
        String producerProps = "bootstrap.servers=192.168.2.6:9092\n"			     //Producer Props
                + "acks=all\nretries=0\nbatch.size=16384\nauto.commit.interval.ms=1000\nlinger.ms=0\n"
                + "key.serializer=org.apache.kafka.common.serialization.StringSerializer\n"
                + "value.serializer=org.apache.kafka.common.serialization.StringSerializer\nblock.on.buffer.full=true";
        String forwardProProps = "bootstrap.servers=192.168.2.2:9092\n"			     //Forward-Producer Props
                + "acks=all\nretries=0\nbatch.size=16384\nauto.commit.interval.ms=1000\nlinger.ms=0\n"
                + "key.serializer=org.apache.kafka.common.serialization.StringSerializer\n"
                + "value.serializer=org.apache.kafka.common.serialization.StringSerializer\nblock.on.buffer.full=true";
        String forwardConProps = "bootstrap.servers=192.168.2.2:9092\n"			     //Forward-Consumer Props
                + "group.id=test\nenable.auto.commit=true\nkey.deserializer=org.apache.kafka.common.serialization.StringDeserializer\n"
                + "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer\nsession.timeout.ms=10000\n"
                + "fetch.min.bytes=50000\nreceive.buffer.bytes=262144\nmax.partition.fetch.bytes=2097152\ncompression.type=none";
        Set_Bash_Files(cpth +JavPth+"/src/main/resources/producer.props", producerProps);    //Set the files
        Set_Bash_Files(cpth +JavPth+"/src/main/resources/consumer.props", consumerProps);
        Set_Bash_Files(cpth +JavPth+"_forward/src/main/resources/forward-consumer.props", forwardConProps);
        Set_Bash_Files(cpth +JavPth+"_forward/src/main/resources/forward-producer.props", forwardProProps);
        for(int i= 1;i<6;i++){Set_Bash_Files(cpth+JavPth+"_"+String.valueOf(i)+"/src/main/resources/consumer.props",consumerProps);}
    }/************************************* CREATION OF POM.XML FILE **************************************/
    public static void Create_Pom_Xml() throws IOException {				     //Creates the XML file for all
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n"
                + "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
                + "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n"
                + "    <modelVersion>4.0.0</modelVersion>\n\n"
                + "    <groupId>mapr.com</groupId>\n    <artifactId>kafka-examples</artifactId>\n"
                + "    <version>1.0-SNAPSHOT</version>\n\n    <dependencies>\n"
                + "        <dependency>\n            <groupId>org.apache.kafka</groupId>\n"
                + "            <artifactId>kafka-clients</artifactId>\n            <version>0.9.0.0</version>\n"
                + "        </dependency>\n        <dependency>\n            <groupId>com.google.guava</groupId>\n"
                + "            <artifactId>guava</artifactId>\n            <version>19.0</version>\n"
                + "        </dependency>\n        <dependency>\n            <groupId>org.hdrhistogram</groupId>\n"
                + "            <artifactId>HdrHistogram</artifactId>\n            <version>2.1.8</version>\n"
                + "        </dependency>\n        <dependency>\n            <groupId>com.fasterxml.jackson.core</groupId>\n"
                + "            <artifactId>jackson-databind</artifactId>\n            <version>2.5.1</version>\n"
                + "        </dependency>\n    </dependencies>\n\n    <build>\n        <plugins>\n"
                + "            <plugin>\n                <groupId>org.apache.maven.plugins</groupId>\n"
                + "                <artifactId>maven-compiler-plugin</artifactId>\n                <configuration>\n"
                + "                    <source>1.7</source>\n                    <target>1.7</target>\n"
                + "                </configuration>\n            </plugin>\n            <plugin>\n"
                + "                <artifactId>maven-assembly-plugin</artifactId>\n                <version>2.4</version>\n"
                + "                <configuration>\n                    <archive>\n                        <manifest>\n"
                + "                            <mainClass>com.mapr.examples.Run</mainClass>\n"
                + "                        </manifest>\n                    </archive>\n"
                + "                    <descriptorRefs>\n                        <descriptorRef>jar-with-dependencies</descriptorRef>\n"
                + "                    </descriptorRefs>\n                </configuration>\n                <executions>\n"
                + "                    <execution>\n                        <id>make-assembly</id>\n"
                + "                        <phase>package</phase>\n"
                + "                        <goals>\n                            <goal>single</goal>\n"
                + "                        </goals>\n                    </execution>\n                </executions>\n"
                + "            </plugin>\n            <plugin>\n                <groupId>org.skife.maven</groupId>\n"
                + "                <artifactId>really-executable-jar-maven-plugin</artifactId>\n                <version>1.1.0</version>\n"
                + "                <configuration>\n                    <!-- value of flags will be interpolated into the java invocation -->\n"
                + "                    <!-- as \"java $flags -jar ...\" -->\n                    <!--<flags></flags>-->\n\n"
                + "                    <!-- (optional) name for binary executable, if not set will just -->\n"
                + "                    <!-- make the regular jar artifact executable -->\n"
                + "                    <programFile>kafka-example</programFile>\n"
                + "                </configuration>\n\n                <executions>\n                    <execution>\n"
                + "                        <phase>package</phase>\n                        <goals>\n"
                + "                            <goal>really-executable-jar</goal>\n                        </goals>\n"
                + "                    </execution>\n                </executions>\n            </plugin>\n"
                + "        </plugins>\n    </build>\n</project>";			     //Here create all XML files
        Set_Bash_Files(cpth +JavPth+"/pom.xml", xml);Set_Bash_Files(cpth +JavPth+"_forward/pom.xml", xml);
        for (int i = 1; i < 6; i++) {Set_Bash_Files(cpth +JavPth+"_" + String.valueOf(i) + "/pom.xml", xml);}
    }/********************************** CREATION OF MATLAB CODE .M FILES *********************************/
    public static void Create_Matlab_Octave_Code() throws IOException {
        String pthB =cpth +"/.BashScripts";						     //Here create .m files for Calculation and Plotting
        String MatOctCode = "standalone=1;\nroot='s/';\nfilepath='';\nfilepath = strcat(filepath, root);\nif ~standalone\n"
                + "    fig = figure();\nend\nplot_latency_per100(root, filepath, 'LogFile.txt', standalone);pause(1);\n"
                + "measure_of_cpu(root, filepath, 'CpuUsageLog.txt', standalone);pause(1);\n"
                + "network_quality_link(root, filepath, 'NetWorkIwfConfigLog.txt', standalone);pause(1);\n"
                + "network_quality_dBm(root, filepath, 'NetWorkIwfConfigLog.txt', standalone);pause(1);\n"
                + "network_usage(root, filepath, 'NetworkLog.txt', standalone);\n";
        String plot_latency_100 = "function fig = plot_latency_per100(foldername, filepath, filename, standalone)\n"
                + "file = strcat(filepath, filename);\nfileID = fopen(file,'r');\nlatency = zeros(1,1);\ncount=0;\n"
                + "fscanf(fileID,'%f',1);\navg=0;\nwhile ~feof(fileID)\n    count = count+1;\n    latency(count,1)=count;\n"
                + "    curr=fscanf(fileID,'%f',1);\n     if ~isempty(curr)\n        latency(count,2)=curr;\n    else\n"
                + "        break;\n    end\n    avg = avg + latency(count,2);\nend\nfclose(fileID);\navg=avg/count-1;\n"
                + "if standalone\n    fig = figure();\nelse\n    subplot(5,1,1);\nend\nplot(latency(1:count-1,2:2),'LineWidth',0.5);\n"
                + "metric ='per100';\nif standalone\n    legend('avg','Location','northwest');\n"
                + "    title(sprintf('Latency for <%s>, %s, average = %f ms', foldername, metric, avg));\n"
                + "    xlabel('number of packets x 100');\n"
                + "end\nfullFileName = fullfile(filepath, 'per100');\nylabel('time (ms)');\ngrid on;\nif standalone\n"
                + "    saveas(fig,fullFileName, 'fig');\n   set(fig,'PaperPositionMode','auto');\n    print(fullFileName,'-dpng','-r300');\n"
                + "    saveas(fig,fullFileName,'fig');\n    set(fig,'PaperPositionMode','auto');\n    print(fullFileName,'-dpng','-r300');\n"
                + "end\nend";
        String plot_latency_overall = "function fig = plot_latency_overall(foldername, filepath, filename, standalone)\n"
                + "file = strcat(filepath, filename);\nfileID = fopen(file,'r');\nlatency = zeros(5,5);\ncount=0;\n"
                + "fscanf(fileID,'%f',1);\navg=0;\nwhile ~feof(fileID)\n    count = count+1;\n    latency(count,1)=count;\n"
                + "    curr=fscanf(fileID,'%f',1);\n    if ~isempty(curr)\n        latency(count,2)=curr;\n    else\n"
                + "        break;\n    end\n    curr=fscanf(fileID,'%f',1);\n    if ~isempty(curr)\n        latency(count,3)=curr;\n"
                + "    else\n        break;\n    end\n    curr=fscanf(fileID,'%f',1);\n    if ~isempty(curr)\n"
                + "        latency(count,4)=curr;\n    else\n        break;\n    end\n    curr=fscanf(fileID,'%f',1);\n"
                + "    if ~isempty(curr)\n        latency(count,5)=curr;\n    else\n        break;\n    end\nend\nfclose(fileID);\n"
                + "if standalone\n    fig = figure();\nelse\n    subplot(5,1,1);\nend\n"
                + "plot(latency(1:count-1,2:5),'LineWidth',0.5);\nmetric ='overall';\n"
                + "legend(sprintf('avg = %d',latency(count,2)),sprintf('min = %d',latency(count,3)),"
                + "sprintf('max = %f',latency(count,4)),sprintf('99th = %d',latency(count,5)),'Location', 'northwest' );\n"
                + "title(sprintf('Latency for <%s>, %s', foldername, metric));\nxlabel('number of packets x 100');\n"
                + "fullFileName = fullfile(filepath, 'overall');\nylabel('time (ms)');\ngrid on;\nif standalone\n"
                + "   saveas(fig,fullFileName, 'fig');\n   set(fig,'PaperPositionMode','auto');\n    print(fullFileName,'-dpng','-r300');\n"
                + "   saveas(fig,fullFileName,'fig');\n    set(fig,'PaperPositionMode','auto');\n    print(fullFileName,'-dpng','-r300');\n"
                + "end\nend";
        String network_usage = "function [scaled_network] = network_usage(foldername, filepath, filename, standalone)\n"
                + "file=strcat(filepath,filename);\nfileID = fopen(file,'r');\nmetrics = zeros(2,2);\nline=0;\n"
                + "while ~feof(fileID)\n    line = line+1;\n    metrics(line,1)=line;\n    curr=fscanf(fileID,'%f',1);\n"
                + "    if ~isempty(curr)\n        metrics(line,2)=curr;\n    end\n    curr=fscanf(fileID,'%f',1);\n"
                + "    if ~isempty(curr)\n        metrics(line,3)=curr;\n    end\nend\nfclose(fileID);\n"
                + "ratio = 1000 /(line-1);\nscaled_network = zeros(1000,3);\nfor i=0:999\n    scaled_network(i+1,1)=i;\n"
                + "    %convert bits to KBytes\n    scaled_network(i+1,2)= metrics( floor(i/ratio)+1, 2) / (8*1024);\n"
                + "    scaled_network(i+1,3)= metrics( floor(i/ratio)+1, 3) / (8*1024);\nend\n"
                + "if standalone\n    fig = figure();\nelse\n    subplot(5,1,5,\"aligh\")\nend\n"
                + "plot(scaled_network(1:i-1,2:3),'LineWidth',0.5);\nif standalone \n"
                + "    legend('traffic in', 'traffic out', 'Location', 'northwest' );\n"
                + "    title(sprintf('Network Usage for <%s>', foldername));\n    xlabel('number of packets x 100');\n"
                + "end\nylabel('KBytes/s');\ngrid on;\nif standalone\n    file = strcat(filepath,'Network_usage');\n"
                + "    saveas(fig,file, 'fig');\n\n    set(fig,'PaperPositionMode','auto');\n"
                + "    print(file,'-dpng','-r300');\nend\nend";
        String network_quality_link = "function [scaled_quality] = network_quality_link(foldername, filepath, filename, standalone)\n"
                + "file=strcat(filepath,filename);\nfileID = fopen(file,'r');\nmetrics = zeros(2,2);\nline=0;\n"
                + "while ~feof(fileID)\n    line = line+1;\n    metrics(line,1)=line;\n    curr=fscanf(fileID,'%d',1);\n"
                + "     if ~isempty(curr)\n        metrics(line,2)=curr;\n    else\n       break;\n    end\n"
                + "    fscanf(fileID,'%d',1);\n    curr=fscanf(fileID,'%d',1);\n    if isempty(curr)\n       break;\n"
                + "    end\nend\nfclose(fileID);\nratio = 1000 /(line-1);\nscaled_quality = zeros(1000,3);\n"
                + "for i=0:999\n    scaled_quality(i+1,1)=i;\n    scaled_quality(i+1,2)= metrics( floor(i/ratio)+1, 2);\n"
                + "end\nif standalone\n    fig = figure();\nelse\n    subplot(5,1,3)\nend\n"
                + "plot(scaled_quality(1:i-1,2:3),'LineWidth',0.5);\nif standalone \n"
                + "    legend('link quality', 'Location', 'northwest' );\n    title(sprintf('Network Quality for <%s>', foldername));\n"
                + "    xlabel('number of packets x 100');\nend\nylabel('signal quality');\ngrid on;\nif standalone\n"
                + "    file = strcat(filepath,'Network_quality_link');\n    saveas(fig,file, 'fig');\n"
                + "    set(fig,'PaperPositionMode','auto');\n    print(file,'-dpng','-r300');\nend\nend";
        String network_quality_dBm = "function [scaled_quality] = network_quality_dBm(foldername, filepath, filename, standalone)\n"
                + "file=strcat(filepath,filename);\nfileID = fopen(file,'r');\nmetrics = zeros(2,2);\nline=0;\n"
                + "while ~feof(fileID)\n    line = line+1;\n    metrics(line,1)=line;\n    curr=fscanf(fileID,'%d',1);\n"
                + "     if isempty(curr)\n        break;\n    end\n    fscanf(fileID,'%d',1);\n    curr=fscanf(fileID,'%d',1);\n"
                + "    if ~isempty(curr)\n        metrics(line,2)=curr;\n    else\n       break;\n    end\nend\n"
                + "fclose(fileID);\nratio = 1000 /(line-1);\nscaled_quality = zeros(1000,3);\nfor i=0:999\n"
                + "    scaled_quality(i+1,1)=i;\n    scaled_quality(i+1,2)= metrics( floor(i/ratio)+1, 2);\nend\n"
                + "if standalone\n    fig = figure();\nelse\n    subplot(5,1,4)\nend\n"
                + "plot(scaled_quality(1:i-1,2:2),'LineWidth',0.5);\nif standalone \n"
                + "    legend('dBm', 'Location', 'northwest' );\n    title(sprintf('Network Quality for <%s>', foldername));\n"
                + "    xlabel('number of packets x 100');\nend\nylabel('signal quality');\ngrid on;\nif standalone\n"
                + "    file = strcat(filepath,'Network_quality_dBm');\n    saveas(fig,file, 'fig');\n\n"
                + "    set(fig,'PaperPositionMode','auto');\n    print(file,'-dpng','-r300');\nend\nend";
        String measure_CPU = "function [scaled] = measure_of_cpu(foldername, filepath, filename, standalone)\n"
                + "file=strcat(filepath,filename);\nfileID = fopen(file,'r');\nmetrics = zeros(1,1);\n"
                + "line=0;\nwhile ~feof(fileID)\n    line = line+1;\n    metrics(line,1)=line;\n"
                + "    curr=fscanf(fileID,'%f',1);\n    if ~isempty(curr)\n        metrics(line,2)=curr;\n"
                + "    end\nend\nfclose(fileID);\nratio = 100/(line-1);\nscaled = zeros(100,2);\n"
                + "for i=1:100\n    scaled(i,1)=i-1;\n    scaled(i,2)=metrics( floor(i/ratio), 2);\n"
                + "end\nif standalone\n    fig = figure();\nelse\n    subplot(5,1,2);\nend\n"
                + "plot(scaled(1:i,2:2),'LineWidth',0.5);\nif standalone\n"
                + "    title(sprintf('CPU usage for <%s>', foldername));\nend\nylabel('%CPU');\n"
                + "grid on;\nif standalone	\n    xlabel('number of packets x 100');\n"
                + "    file = strcat(filepath,'CPU_usage');\n    saveas(fig,file, 'fig');\n" //Here is the creation of the .m files
                + "    set(fig,'PaperPositionMode','auto');\n    print(file,'-dpng','-r300');\nend\nend";
        Set_Bash_Files(pthB+"/scan_folders.m", MatOctCode);	    Set_Bash_Files(pthB+"/plot_latency_per100.m", plot_latency_100);
        Set_Bash_Files(pthB+"/network_usage.m", network_usage);     Set_Bash_Files(pthB+"/plot_latency_overall.m", plot_latency_overall);
        Set_Bash_Files(pthB+"/measure_of_cpu.m", measure_CPU);      Set_Bash_Files(pthB+"/network_quality_link.m", network_quality_link);
        Set_Bash_Files(pthB+"/network_quality_dBm.m", network_quality_dBm);
    }/*************************** CREATION OF MOVEFOLDERS.JAVA,NOTIFICATOR.JAVA ***************************/
    public static void Move_Folders_Ex() throws UnsupportedEncodingException, IOException{
        String moveFolders = "import java.io.*;\n"				             //Here creates MoveFolder and DeleteFolder java file
                + "public class MoveFolders {\n"					     //Its the programm tha organises the Files and Folders
                + "    public static String curpath = System.getProperty(\"user.dir\")+ \"/Latency_Analysis/Results/\""
                + ",prp=System.getProperty(\"user.dir\");\n    public static void main(String[] args) throws IOException, InterruptedException {\n"
                + "        File file = new File(curpath);System.out.println(curpath);\n"
                + "        String[] names = file.list(), nameBuffer = new String[100];String current = \"\";\n"
                + "        int counter = 1, z = 0, nameCounter, counter1, counter2, flag = 0, check = 0;\n"
                + "        int[] nameCountBuff = new int[100];double latency, totaltime, totalthrou = 0,v = 0;\n"
                + "        String h = curpath;counter1 = counter2 = nameCounter = 0;\n"
                + "        for (String name : names) {\n            if (new File(curpath + name).isDirectory()) {\n"
                + "                name = name.substring(0, name.length() - 1);\n"
                + "                if (!name.toLowerCase().contains(\"Experiment\".toLowerCase())) {\n"
                + "                    if (flag == 0) {\n                        nameBuffer[0] = name;nameCountBuff[0] = 1;\n"
                + "                        flag = 1;nameCounter = 1;\n                    } else {\n"
                + "                        for (counter1 = 0; counter1 < nameCounter; counter1++) {\n"
                + "                            if (nameBuffer[counter1].equals(name)) {\n"
                + "                                nameCountBuff[counter1]++;\n"
                + "                                if (nameCountBuff[counter1] >= 5) {\n"
                + "                                    for (int i = 0; i < 5 ; i++) {\n"
                + "                                        try {\n"
                + "                                            BufferedReader stdInput = new BufferedReader(new FileReader(h +"
                + " nameBuffer[counter1] + Integer.toString(i) + \"/LogResults/ProgramTime.txt\"));\n"
                + "                                            String jj=stdInput.readLine();jj=stdInput.readLine();jj=stdInput.readLine();\n"
                + "                                            jj = stdInput.readLine();jj = stdInput.readLine();\n"
                + "                                            totalthrou = totalthrou + Double.parseDouble(jj);\n"
		+ "				       	       jj = stdInput.readLine();v=v+Double.parseDouble(jj);stdInput.close();\n"
                + "                                        } catch (IOException exxx) {}\n                                    }\n"
                + "                                    File folder = new File(h + \"/Experiment-\" + nameBuffer[counter1] + "
                + "Integer.toString(z) + \"/\");\n                                    while (folder.exists()) {\n"
                + "                                        z++;folder = new File(h + \"/Experiment-\" + nameBuffer[counter1] + "
                + "Integer.toString(z) + \"/\");\n"
                + "                                    }\n                                    folder.mkdir();\n"
                + "                                    PrintWriter writer = new PrintWriter(h + \"/Experiment-\" + nameBuffer[counter1] "
                + "+ Integer.toString(z) + \"/TotalAvgLAtency.txt\", \"UTF-8\");\n                                    totalthrou=totalthrou/5;\n"
                + "              		            v=v/5;writer.println(totalthrou);writer.println(v);\n"
		+ " 				    writer.println((Math.sqrt(v))/totalthrou);writer.close();\n"
                + "                                    Set_Config_Files(\"Results/size\", \" \", \"Results/\" + nameBuffer[counter1] "
                + "+ \"*\",prp+ \"/.BashScripts/MoveFolders\");\n"
                + "                                    Set_Config_Files(\"Experiment\", \"\\n\", \"Experiment-\" + nameBuffer[counter1]"
                + " + Integer.toString(z) + \"/\", prp+\"/.BashScripts/MoveFolders\");\n"
                + "                                   ProcessBuilder processbuilder=new ProcessBuilder(prp+\"/.BashScripts/MoveFolders\");\n"
                + "                                    try {Process process = processbuilder.start();} catch (IOException ex) {}"
                + "nameCountBuff[counter1]=0;\n                                }check = 1;break;\n"
                + "                            }\n"
                + "                        }\n                       if (check == 0) {\n"
                + "                            nameBuffer[nameCounter] = name;nameCountBuff[nameCounter] = 1;\n"
                + "                            nameCounter++;\n                        }\n"
                + "                        check = 0;\n                    }\n                    current = name;\n"
                + "                }\n            }\n        }\n    }\n"
                + "    public static void Set_Config_Files(String start, String end, String change, String path) throws IOException {\n"
                + "        String line2 = \"\", input = \"\";                            //Replace string from start-end with change\n"
                + "        try (BufferedReader fileupdate = new BufferedReader(new FileReader(path))) {\n"
                + "            String line;input = \"\";\n"
                + "            while ((line = fileupdate.readLine()) != null) {input += line + '\\n';}fileupdate.close();\n"
                + "        } catch (IOException ex) {}\n"
                + "        if (input.toLowerCase().contains(start.toLowerCase())) {\n"
                + "            line2 = input.substring(input.indexOf(start));\n            line2 = line2.substring(0, line2.indexOf(end));\n"
                + "            input = input.replace(line2, change);                 //Replacement here\n"
                + "            try (FileOutputStream fileOut = new FileOutputStream(path)) {fileOut.write(input.getBytes());fileOut.flush();"
                + "fileOut.close();}\n        }\n    }\n}";				     //The Notificator java file
	String Notificator = "import java.awt.*;\nimport java.io.*;\nimport javax.swing.*;\npublic class Notificator {\n"
                + "        public static void main(String... args) throws IOException, InterruptedException {\n"
                + "            int fileCoun = new File(\""+cpth+"/Latency_Analysis/Results/size/LogResults\").listFiles().length;\n"            
                + "            if(fileCoun!=17){\n  		   frameCreator(\"Error occured.Please run experiment again\",false);\n"
		+ "           	   ProcessBuilder processbuilder = new ProcessBuilder(\""+cpth+"/.BashScripts/DeleteFolders\");\n"
		+ "                try {Process process = processbuilder.start();} catch (IOException ex) {}\n"
                + "            }else{frameCreator(\"You can see now the results and metrics!!\",true);}\n"
                + "        }\n        public static void frameCreator(String mess,boolean type) throws InterruptedException{\n"
                + "         String output;if(type==false){output=\"ERROR EXPERIMENT FAILED\";}else{output=\"EXPERIMENT FINISHED WITH SUCCESS\";}\n"
                + "            JFrame frame = new JFrame(\"Experiment Is Finished\");"
		+ "frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting of Frame\n"
                + "            JPanel contentPane = new JPanel();contentPane.setOpaque(true);"
		+ "contentPane.setBackground(Color.WHITE);contentPane.setLayout(null);\n"
                + "            JLabel label = new JLabel(output, JLabel.CENTER);label.setSize(300, 30);label.setLocation(50, 5);\n"
                + "            JLabel label2 = new JLabel(mess, JLabel.CENTER);label2.setSize(400, 30);label2.setLocation(0, 50); \n"
                + "            if(type==true){label.setForeground(Color.green);}else{label.setForeground(Color.red);}\n"
                + "            contentPane.add(label);contentPane.add(label2);\n            frame.setContentPane(contentPane);\n"
                + "            frame.setSize(400, 180);frame.setLocationRelativeTo(null);frame.setVisible(true);\n"
                + "            Thread.sleep(5000);frame.dispose();\n        }\n}";
        Set_Bash_Files(cpth +"/MoveFolders.java", moveFolders);				     // Here is the creation of the java file
        Set_Bash_Files(cpth +"/Notificator.java", Notificator);				     // Here is the creation of the java file
    }/********************************** CHANGES LINE FROM FILE FUNCTION **********************************/  
    public static void Set_Config_Files(String start, String end, String change, String path) throws IOException {
        String line2 = "", input = "";                            			     //Replace string from start-end with change
        try (BufferedReader fileupdate = new BufferedReader(new FileReader(path))) {
            String line;input = "";while ((line = fileupdate.readLine()) != null) {input += line + '\n';}fileupdate.close();
        }catch (IOException ex) {}
        if (input.toLowerCase().contains(start.toLowerCase())) {			     //Here the replacement
            line2 = input.substring(input.indexOf(start));line2 = line2.substring(0, line2.indexOf(end));input = input.replace(line2, change);
            try (FileOutputStream fileOut = new FileOutputStream(path)) {fileOut.write(input.getBytes());fileOut.flush();fileOut.close();}
        }
    } 
}								 
