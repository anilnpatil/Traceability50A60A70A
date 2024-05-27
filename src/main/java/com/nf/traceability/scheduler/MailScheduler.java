package com.nf.traceability.scheduler;

import com.nf.traceability.dto.Line1CSVData;
//import com.nf.traceability.dto.Machine11;
import com.nf.traceability.dto.Machine19;
import com.nf.traceability.service.LogDataService;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

@Component
public class MailScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MailScheduler.class);

    @Autowired
    private LogDataService logDataService;

//   @Scheduled(cron = "0 20 15 * * ?")
//   public void testCSVMail() throws IOException, URISyntaxException {
//       String res = logDataService.deleteLine1("abc");
//       logger.info("Deletion status = " + res);
//   }

    @Scheduled(cron = "0 5 17 * * ?")
    public void sendShiftACompletionMail() throws IOException, URISyntaxException {
        String csvPattern = "dd.MM.yy";
        String queryPattern = "yyyy-MM-dd";
        String csvDate = new SimpleDateFormat(csvPattern).format(new Date());
        String queryFromDate = new SimpleDateFormat(queryPattern).format(new Date());
        ArrayList<Line1CSVData> shiftAData = logDataService.getShiftWiseMailData(1, queryFromDate, queryFromDate);
        writeDataToCSVUsingArray(csvDate, 1, shiftAData);
        logger.info("Shift A");
    }

    @Scheduled(cron = "0 35 1 * * ?")
    public void sendShiftBCompletionMail() throws IOException, URISyntaxException {
        String csvPattern = "dd.MM.yy";
        String queryPattern = "yyyy-MM-dd";

        //to get calendar instance
        Calendar cal = Calendar.getInstance();

        //subtract 1 from calendar current date
        cal.add(Calendar.DATE, -1);

        String queryFromDate = new SimpleDateFormat(queryPattern).format(cal.getTime());
        String csvDate = new SimpleDateFormat(csvPattern).format(cal.getTime());

        String queryToDate = new SimpleDateFormat(queryPattern).format(new Date());
        ArrayList<Line1CSVData> shiftBData = logDataService.getShiftWiseMailData(2, queryFromDate, queryToDate);
        writeDataToCSVUsingArray(csvDate, 2, shiftBData);
        logger.info("Shift B");
    }

    @Scheduled(cron = "0 35 8 * * ?")
    public void sendShiftCCompletionMail() throws IOException, URISyntaxException {
        String csvPattern = "dd.MM.yy";
        String queryPattern = "yyyy-MM-dd";
        String csvDate = new SimpleDateFormat(csvPattern).format(new Date());
        String queryFromDate = new SimpleDateFormat(queryPattern).format(new Date());
        ArrayList<Line1CSVData> shiftCData = logDataService.getShiftWiseMailData(3, queryFromDate, queryFromDate);
        writeDataToCSVUsingArray(csvDate, 3, shiftCData);
        logger.info("Shift C");
    }

    public void writeDataToCSVUsingArray(String date, int shift, ArrayList<Line1CSVData> shiftData) throws IOException, URISyntaxException {

        String[] mainHeader1 = {"","","","","","","","OP1010 - OIL HOLE CHECKING MACHINE","","","",
                "OP1020A - BALL PRESS MACHINE","","","","","","","","","OP1020B - SOCKET PRESS MACHINE",
                "OP1030 - SCREW & NUT ASSEMBLY MACHINE","","OP1040A - PIPE PLUG VALVE ASSEMBLY MACHINE",
                "","","OP1040B - INSERT VALVE ASSEMBLY MACHINE","","","","","","","","","","",
                "OP1040C - BALL OVER HEIGHT CHECK MACHINE","","","",
                "OP1040D - THREAD PLUG ASSEMBLY MACHINE","OP1050 - OCV ASSEMBLY MACHINE","","","","","",
                "","","","","","OP1050A - OCV ASSEMBLY MACHINE A","","","","","",
                "","","","","","OP1060 - PIN PRESS ASSEMBLY MACHINE","","","","","","",
                "OP1060A - PIN PRESS ASSEMBLY MACHINE A","","","","","","",
                "OP1070 - FUNCTIONAL TEST RIG","","","","","","",
                "OP1070A - FUNCTIONAL TEST RIG-A"};

        String[] mainHeader2 = {"DATE","TIME","SHIFT","SFL SERIAL NUMBER","COMPONENT BARCODE",
                "MACHINE NAME","PRODUCTION STATUS","OCV HOLE STATUS","BAP HOLE STATUS",
                "PIPE PLUG HOLE STATUS","THREAD PLUG HOLE STATUS","MIN ID  GAUGE VALUE (MM)",
                "MAX ID GAUGE  VALUE(MM)","ACTUAL ID A GAUGE VALUE (MM)","ACTUAL ID B GAUGE VALUE (MM)",
                "ID GAUGE STATUS","MIN LOAD VALUE(KG)","MAX LOAD VALUE (KG)","ACTUAL LOAD VALUE (KG)",
                "BALL PRESS STATUS","SOCKET PRESS STATUS","PRE-SCREWING AND SCREWING STATUS",
                "NUT TIGHTENING STATUS","TARGET TORQUE (NM)","ACTUAL TORQUE (NM)",
                "PIPE PLUG ASSEMBLY STATUS","MIN ID GAUGE BORE DIA (MM)","MAX ID GAUGE BORE DIA (MM)",
                "ACTUAL ID GAUGE BORE DIA (MM)","ID GAUGE STATUS",
                "MIN LOAD INSERT VALVE PRESS VALUE (KG)","MAX LOAD INSERT VALVE PRESS VALUE (KG)",
                "ACTUAL LOAD INSERT VALVE PRESS VALUE (KG)","MIN DISPLACEMENT INSERT VALVE VALUE (MM)",
                "MAX DISPLACEMENT INSERT VALVE VALUE (MM)","ACTUAL DISPLACEMENT INSERT VALVE VALUE (MM)",
                "INSERT VALVE PRESS STATUS","MIN BALL OVER HEIGHT VALUE (MM)",
                "MAX BALL OVER HEIGHT VALUE (MM)","ACTUAL BALL OVER HEIGHT VALUE (MM)",
                "BALL OVER HEIGHT CHECK STATUS","MINIMUM TORQUE (NM)","MAXIMUM TORQUE (NM)","ACTUAL TORQUE (NM)",
                "ACTUAL ANGLE","BALL / SPRING/ O-RING / THREAD PLUG ASSEMBLY STATUS",
                "MIN OCV ID GAUGE VALUE (MM)","MAX OCV ID GAUGE VALUE (MM)",
                "ACTUAL OCV ID GAUGE VALUE (MM)","MIN BAP ID GAUGE VALUE (MM)",
                "MAX BAP ID GAUGE VALUE (MM)","ACTUAL BAP ID GAUGE VALUE (MM)","ID GAUGE STATUS",
                "OCV / BAP ASSEMBLY STATUS","SPRING ASSEMBLY STATUS","RETAINER ASSEMBLY STATUS",
                "CIRCLIP ASSEMBLY STATUS","MIN PIN PRESS LOAD VALUE (KG)",
                "MAX PIN PRESS LOAD VALUE (KG)","ACTUAL PIN PRESS LOAD VALUE (KG)",
                "MIN PIN DISPLACEMENT VALUE (MM)","MAX PIN DISPLACEMENT VALUE (MM)",
                "ACTUAL PIN  DISPLACEMENT VALUE (MM)","PIN PRESS STATUS",
                "MIN LOAD VALUE (KG)","MAX LOAD VALUE (KG)","ACTUAL LOAD VALUE (KG)","FUNCTIONAL TEST STATUS","FUNCTIONAL TEST STATUS-A"};

//        Path path = Paths.get(ClassLoader.getSystemResource(shift == 1 ? "ShiftA.csv" : shift == 2 ? "ShiftB.csv" : "ShiftC.csv").toURI());
//        FileOutputStream fos = new FileOutputStream(path.toString());
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        CSVWriter csvWriter = new CSVWriter(osw);

        String subjectPrefix = "Exhaust Rocker Lever Data - ";
        String subject = shift == 1 ? subjectPrefix + date +" Shift(A)" : shift == 2 ? subjectPrefix + date +" Shift(B)"  : subjectPrefix + date +" Shift(C)";
        Machine19 dailyData = logDataService.getDailyReport();
        String body = "<h3><strong>Exhaust Rocker lever Assembly Line: </strong></h3>" +
                "<p><strong>Total Production - "+dailyData.getTotalProduction()+"</strong></p>"+
                "<p><strong>OK parts - "+dailyData.getOkParts()+ "</strong></p>"+
                "<p><strong>NOK parts - "+dailyData.getNotOkParts()+ "</strong></p>";


        String path = shift == 1 ? "D:\\git-repos\\traceability\\traceability\\ShiftWise-reports\\ShiftA-Reports\\ShiftA("+date+").csv" : shift == 2 ? "D:\\git-repos\\traceability\\traceability\\ShiftWise-reports\\ShiftB-Reports\\ShiftB("+date+").csv" : "D:\\git-repos\\traceability\\traceability\\ShiftWise-reports\\ShiftC-Reports\\ShiftC("+date+").csv";
        CSVWriter csvWriter = new CSVWriter(new FileWriter(path));
        try {

            csvWriter.writeNext(mainHeader1);
            csvWriter.writeNext(mainHeader2);

            if(shiftData != null && shiftData.size() >= 1) {
                for(Line1CSVData csvData : shiftData) {
                    String row;
                    String[] data = {
                            row = csvData.getDate(), csvData.getTime(), csvData.getShift(),
                            csvData.getSfl_serial_number(), csvData.getComponent_barcode(),
                            csvData.getMachine_name(), csvData.getProduction_status(),
                            csvData.getOp1010_ocv_hole_status(), csvData.getOp1010_bap_hole_status(),
                            csvData.getOp1010_pipe_plug_hole_status(), csvData.getOp1010_thread_plug_hole_status(),
                            String.valueOf(csvData.getOp1020a_min_id_gauge_value()), String.valueOf(csvData.getOp1020a_max_id_gauge_value()),
                            String.valueOf(csvData.getOp1020a_actual_id_a_gauge_value()), String.valueOf(csvData.getOp1020a_actual_id_b_gauge_value()),
                            csvData.getOp1020a_id_gauge_status(), String.valueOf(csvData.getOp1020a_min_load_value()), String.valueOf(csvData.getOp1020a_max_load_value()),
                            String.valueOf(csvData.getOp1020a_actual_load_value()), csvData.getOp1020a_ball_press_status(), csvData.getOp1020b_socket_press_status(),
                            csvData.getOp1030_pre_screwing_and_screwing_status(), csvData.getOp1030_nut_tightening_status(), String.valueOf(csvData.getOp1040a_target_torque()),
                            String.valueOf(csvData.getOp1040a_actual_torque()), csvData.getOp1040a_pipe_plug_asmbly_status(), String.valueOf(csvData.getOp1040b_min_id_gauge_bore_dia()),
                            String.valueOf(csvData.getOp1040b_max_id_gauge_bore_dia()), String.valueOf(csvData.getOp1040b_actual_id_gauge_bore_dia()), csvData.getOp1040b_id_gauge_status(),
                            String.valueOf(csvData.getOp1040b_min_load_insert_valve_press_value()), String.valueOf(csvData.getOp1040b_max_load_insert_valve_press_value()),
                            String.valueOf(csvData.getOp1040b_actual_load_insert_valve_press_value()), String.valueOf(csvData.getOp1040b_min_displacement_insert_valve_value()),
                            String.valueOf(csvData.getOp1040b_max_displacement_insert_valve_value()), String.valueOf(csvData.getOp1040b_actual_displacement_insert_valve_value()),
                            csvData.getOp1040b_insert_valve_press_status(), String.valueOf(csvData.getOp1040c_min_ball_over_height_value()), String.valueOf(csvData.getOp1040c_max_ball_over_height_value()),
                            String.valueOf(csvData.getOp1040c_actual_ball_over_height_value()), csvData.getOp1040c_ball_over_height_check_status(), String.valueOf(csvData.getOp1040d_minimum_torque()),
                            String.valueOf(csvData.getOp1040d_maximum_torque()), String.valueOf(csvData.getOp1040d_actual_torque()), String.valueOf(csvData.getOp1040d_actual_angle()),
                            csvData.getOp1040d_ball_spring_oring_thread_plug_asmbly_status(),
                            String.valueOf(csvData.getOp1050_min_ocv_id_gauge_value()), String.valueOf(csvData.getOp1050_max_ocv_id_gauge_value()), String.valueOf(csvData.getOp1050_actual_ocv_id_gauge_value()),
                            String.valueOf(csvData.getOp1050_min_bap_id_gauge_value()), String.valueOf(csvData.getOp1050_max_bap_id_gauge_value()), String.valueOf(csvData.getOp1050_actual_bap_id_gauge_value()),
                            csvData.getOp1050_id_gauge_status(), csvData.getOp1050_ocv_and_bap_asmbly_status(), csvData.getOp1050_spring_asmbly_status(), csvData.getOp1050_retainer_asmbly_status(),
                            csvData.getOp1050_circlip_asmbly_status(),
                            String.valueOf(csvData.getOp1050a_min_ocv_id_gauge_value()), String.valueOf(csvData.getOp1050a_max_ocv_id_gauge_value()), String.valueOf(csvData.getOp1050a_actual_ocv_id_gauge_value()),
                            String.valueOf(csvData.getOp1050a_min_bap_id_gauge_value()), String.valueOf(csvData.getOp1050a_max_bap_id_gauge_value()), String.valueOf(csvData.getOp1050a_actual_bap_id_gauge_value()),
                            csvData.getOp1050a_id_gauge_status(), csvData.getOp1050a_ocv_and_bap_asmbly_status(), csvData.getOp1050a_spring_asmbly_status(), csvData.getOp1050a_retainer_asmbly_status(),
                            csvData.getOp1050a_circlip_asmbly_status(),
                            String.valueOf(csvData.getOp1060_min_pin_press_load_value()), String.valueOf(csvData.getOp1060_max_pin_press_load_value()),
                            String.valueOf(csvData.getOp1060_actual_pin_press_load_value()), String.valueOf(csvData.getOp1060_min_pin_displacement_value()), String.valueOf(csvData.getOp1060_max_pin_displacement_value()),
                            String.valueOf(csvData.getOp1060_actual_pin_displacement_value()), csvData.getOp1060_pin_press_status(),
                            String.valueOf(csvData.getOp1060a_min_pin_press_load_value()), String.valueOf(csvData.getOp1060a_max_pin_press_load_value()),
                            String.valueOf(csvData.getOp1060a_actual_pin_press_load_value()), String.valueOf(csvData.getOp1060a_min_pin_displacement_value()), String.valueOf(csvData.getOp1060a_max_pin_displacement_value()),
                            String.valueOf(csvData.getOp1060a_actual_pin_displacement_value()), csvData.getOp1060a_pin_press_status(),
                            String.valueOf(csvData.getOp1070_min_load_value()), String.valueOf(csvData.getOp1070_max_load_value()), String.valueOf(csvData.getOp1070_actual_load_value()),
                            csvData.getOp1070_functional_test_status(),
                            String.valueOf(csvData.getOp1070a_min_load_value()), String.valueOf(csvData.getOp1070a_max_load_value()), String.valueOf(csvData.getOp1070a_actual_load_value()),
                            csvData.getOp1070a_functional_test_status()
                    };
                    csvWriter.writeNext(data);
                }

            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            csvWriter.close();
            if(shiftData != null && shiftData.size() >= 1) {
                sendEmail(subject, body, path);
            }
//            osw.close();
//            fos.close();
        }
    }

    public void sendEmail(String subject, String body, String path) {
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator()
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication("datasendernextfirstsfl@gmail.com", "sendmail@sfldata");
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("datasendernextfirstsfl@gmail.com", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("raja.c2@sfl.co.in"));
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("adityakadambala8@gmail.com"));
            msg.setRecipients( Message.RecipientType.CC, InternetAddress.parse( "aditya.k@nextfirst.com, monesh.c@nextfirst.com"));
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body,
                    "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile(path);
            multipart.addBodyPart(attachPart); // add 2 times for sending 2 attachments
            msg.setContent(multipart);
            Transport.send(msg);
        }
        catch (Exception exe)
        {
            exe.printStackTrace();
        }
    }
}
