package com.nf.traceability.service;

//import java.math.BigInteger;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.nf.traceability.dto.*;
import static com.nf.traceability.constant.QueriesToExecute.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unchecked")
public class LogDataService {

    @Autowired
	private EntityManagerFactory entityManagerFactory;
    private Line1 line1;
    private Machine1 machine1;
    private Machine2 machine2;
    private Machine3 machine3;
    private Machine4 machine4;
    private Machine5 machine5;
    private Machine6 machine6;
    private Machine7 machine7;
    private Machine8 machine8;
    private Machine9 machine9;
    private Machine10 machine10;
    private Machine11 machine11;
    private Machine19 Machine19;
    private Machine13 machine13;
    private Machine14 machine14;

    
    public Line1 sendLogResults() {
        //String pattern = "yyyy-MM-dd";
        //String dateInString = new SimpleDateFormat(pattern).format(new Date());
        //String OKpartsQuery = "";
        //String NotOKPartsQuery = "";
        String prodId = "";
        String p2prodId = "";
        String p3prodId = "";
        String p4prodId = "";
        String m1flagid = "";
        String m2flagid = "";
        String m3flagid = "";
        String m4flagid = "";
        String m5flagid = "";
        String m6flagid = "";
        String m7flagid = "";
        String m8flagid = "";
        String m9flagid = "";
        String m13flagid = "";
        String m10flagid = "";
        String m14flagid = "";
        String m11flagid = "";
        String m11flagid1 = "";
        String m12flagid = "";
        String m12flagid1 = "";


        Integer prodStatus = null;

        // machine 1,2,4,6,9 = multiple rows
        // machine 3,5,7,8,10,11 = single result or row
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        EntityManager entityManager3 = entityManagerFactory.createEntityManager();


        line1 = new Line1();
        machine1 = new Machine1();
        List<Object[]> m1Data = entityManager.createNativeQuery(MACHINE_1_QUERY).getResultList();
        machine1.setProductId((String) m1Data.get(0)[0]);
        machine1.setProcess1PassFail(m1Data.get(0)[1] != null ? (Integer) m1Data.get(0)[1] : 3);
        p2prodId = m1Data.get(1)[0] != null ? (String) m1Data.get(1)[0] : "";
        machine1.setProcess2PassFail(!p2prodId.isEmpty() && p2prodId.equals(machine1.getProductId()) && m1Data.get(1)[1] != null ? (Integer) m1Data.get(1)[1] : 3);
        p3prodId = m1Data.get(2)[0] != null ? (String) m1Data.get(2)[0] : "";
        machine1.setProcess3PassFail(!p3prodId.isEmpty() && p3prodId.equals(machine1.getProductId()) && m1Data.get(2)[1] != null ? (Integer) m1Data.get(2)[1] : 3);
        m1flagid = m1Data.get(3)[0] != null ? (String) m1Data.get(3)[0] : "";
        machine1.setProcess4PassFail(!m1flagid.isEmpty() && m1flagid.equals(machine1.getProductId()) && m1Data.get(3)[1] != null ? (Integer) m1Data.get(3)[1] : 3);

        machine2 = new Machine2();
        List<Object[]> m2Data = entityManager.createNativeQuery(MACHINE_2_QUERY).getResultList();
        machine2.setProductId((String) m2Data.get(0)[0]);
        machine2.setProcess1PassFail(m2Data.get(0)[1] != null ? (Integer) m2Data.get(0)[1] : 3);
        machine2.setProcess1Parameter1(m2Data.get(0)[2] != null ? (Double) m2Data.get(0)[2] : 0);
        machine2.setProcess1Parameter2(m2Data.get(0)[3] != null ? (Double) m2Data.get(0)[3] : 0);
        machine2.setProcess1Parameter3(m2Data.get(0)[4] != null ? (Double) m2Data.get(0)[4] : 0);
        machine2.setProcess1Parameter4(m2Data.get(0)[5] != null ? (Double) m2Data.get(0)[5] : 0);
        m2flagid = m2Data.get(1)[0] != null ? (String) m2Data.get(1)[0] : "";
        machine2.setProcess2PassFail(!m2flagid.isEmpty() && m2flagid.equals(machine2.getProductId()) && m2Data.get(1)[1] != null ? (Integer) m2Data.get(1)[1] : 3);
        machine2.setProcess2Parameter1(!m2flagid.isEmpty() && m2flagid.equals(machine2.getProductId()) && m2Data.get(1)[2] != null ? (Double) m2Data.get(1)[2] : 0);
        machine2.setProcess2Parameter2(!m2flagid.isEmpty() && m2flagid.equals(machine2.getProductId()) && m2Data.get(1)[3] != null ? (Double) m2Data.get(1)[3] : 0);
        machine2.setProcess2Parameter3(!m2flagid.isEmpty() && m2flagid.equals(machine2.getProductId()) && m2Data.get(1)[4] != null ? (Double) m2Data.get(1)[4] : 0);

        machine3 = new Machine3();
        Object[] m3Data = (Object[]) entityManager.createNativeQuery(MACHINE_3_QUERY).getSingleResult();
        machine3.setProductId((String) m3Data[0]);
        m3flagid = machine3.getProductId();
        machine3.setProcess1PassFail(m3Data[1] != null ? (Integer) m3Data[1] : 3);

        machine4 = new Machine4();
        List<Object[]> m4Data = entityManager.createNativeQuery(MACHINE_4_QUERY).getResultList();
        machine4.setProductId((String) m4Data.get(0)[0]);
        machine4.setProcess1PassFail(m4Data.get(0)[1] != null ? (Integer) m4Data.get(0)[1] : 3);
        m4flagid = m4Data.get(1)[0] != null ? (String) m4Data.get(1)[0] : "";
        machine4.setProcess2PassFail(!m4flagid.isEmpty() && m4flagid.equals(machine4.getProductId()) && m4Data.get(1)[1] != null ? (Integer) m4Data.get(1)[1] : 3);

        machine5 = new Machine5();
        Object[] m5Data = (Object[]) entityManager1.createNativeQuery(MACHINE_5_QUERY).getSingleResult();
        machine5.setProductId((String) m5Data[0]);
        m5flagid = machine5.getProductId();
        machine5.setProcess1PassFail(m5Data[1] != null ? (Integer) m5Data[1] : 3);
        machine5.setProcess1Parameter1(m5Data[2] != null ? (Double) m5Data[2] : 0);
        machine5.setProcess1Parameter2(m5Data[3] != null ? (Double) m5Data[3] : 0);

        machine6 = new Machine6();
        List<Object[]> m6Data = entityManager1.createNativeQuery(MACHINE_6_QUERY).getResultList();
        machine6.setProductId((String) m6Data.get(0)[0]);
        machine6.setProcess1PassFail(m6Data.get(0)[1] != null ? (Integer) m6Data.get(0)[1] : 3);
        machine6.setProcess1Parameter1(m6Data.get(0)[2] != null ? (Double) m6Data.get(0)[2] : 0);
        machine6.setProcess1Parameter2(m6Data.get(0)[3] != null ? (Double) m6Data.get(0)[3] : 0);
        machine6.setProcess1Parameter3(m6Data.get(0)[4] != null ? (Double) m6Data.get(0)[4] : 0);
        m6flagid = m6Data.get(1)[0] != null ? (String) m6Data.get(1)[0] : "";
        machine6.setProcess2PassFail(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[1] != null ? (Integer) m6Data.get(1)[1] : 3);
        machine6.setProcess2Parameter1(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[2] != null ? (Double) m6Data.get(1)[2] : 0);
        machine6.setProcess2Parameter2(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[3] != null ? (Double) m6Data.get(1)[3] : 0);
        machine6.setProcess2Parameter3(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[4] != null ? (Double) m6Data.get(1)[4] : 0);
        machine6.setProcess2Parameter4(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[5] != null ? (Double) m6Data.get(1)[5] : 0);
        machine6.setProcess2Parameter5(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[6] != null ? (Double) m6Data.get(1)[6] : 0);
        machine6.setProcess2Parameter6(!m6flagid.isEmpty() && m6flagid.equals(machine6.getProductId()) && m6Data.get(1)[7] != null ? (Double) m6Data.get(1)[7] : 0);

        machine7 = new Machine7();
        Object[] m7Data = (Object[]) entityManager1.createNativeQuery(MACHINE_7_QUERY).getSingleResult();
        machine7.setProductId((String) m7Data[0]);
        m7flagid = machine7.getProductId();
        machine7.setProcess1PassFail(m7Data[1] != null ? (Integer) m7Data[1] : 3);
        machine7.setProcess1Parameter1(m7Data[2] != null ? (Double) m7Data[2] : 0);
        machine7.setProcess1Parameter2(m7Data[3] != null ? (Double) m7Data[3] : 0);
        machine7.setProcess1Parameter3(m7Data[4] != null ? (Double) m7Data[4] : 0);

        machine8 = new Machine8();
        Object[] m8Data = (Object[]) entityManager1.createNativeQuery(MACHINE_8_QUERY).getSingleResult();
        machine8.setProductId((String) m8Data[0]);
        m8flagid = machine8.getProductId();
        machine8.setProcess1PassFail(m8Data[1] != null ? (Integer) m8Data[1] : 3);
        machine8.setProcess1Parameter1(m8Data[2] != null ? (Double) m8Data[2] : 0);
        machine8.setProcess1Parameter2(m8Data[3] != null ? (Double) m8Data[3] : 0);
        machine8.setProcess1Parameter3(m8Data[4] != null ? (Double) m8Data[4] : 0);
        machine8.setProcess1Parameter4(m8Data[5] != null ? (Double) m8Data[5] : 0);

        machine9 = new Machine9();
        List<Object[]> m9Data = entityManager2.createNativeQuery(MACHINE_9_QUERY).getResultList();
        machine9.setProductId((String) m9Data.get(0)[0]);
        machine9.setProcess1PassFail(m9Data.get(0)[1] != null ? (Integer) m9Data.get(0)[1] : 3);
        machine9.setProcess1Parameter1(m9Data.get(0)[2] != null ? (Double) m9Data.get(0)[2] : 0);
        machine9.setProcess1Parameter2(m9Data.get(0)[3] != null ? (Double) m9Data.get(0)[3] : 0);
        machine9.setProcess1Parameter3(m9Data.get(0)[4] != null ? (Double) m9Data.get(0)[4] : 0);
        machine9.setProcess1Parameter4(m9Data.get(0)[5] != null ? (Double) m9Data.get(0)[5] : 0);
        machine9.setProcess1Parameter5(m9Data.get(0)[6] != null ? (Double) m9Data.get(0)[6] : 0);
        machine9.setProcess1Parameter6(m9Data.get(0)[7] != null ? (Double) m9Data.get(0)[7] : 0);
        p2prodId = m9Data.get(1)[0] != null ? (String) m9Data.get(1)[0] : "";
        p3prodId = m9Data.get(2)[0] != null ? (String) m9Data.get(2)[0] : "";
        p4prodId = m9Data.get(3)[0] != null ? (String) m9Data.get(3)[0] : "";
        m9flagid = m9Data.get(4)[0] != null ? (String) m9Data.get(4)[0] : "";
        machine9.setProcess2PassFail(!p2prodId.isEmpty() && p2prodId.equals(machine9.getProductId()) && m9Data.get(1)[1] != null ? (Integer) m9Data.get(1)[1] : 3);
        machine9.setProcess3PassFail(!p3prodId.isEmpty() && p3prodId.equals(machine9.getProductId()) && m9Data.get(2)[1] != null ? (Integer) m9Data.get(2)[1] : 3);
        machine9.setProcess4PassFail(!p4prodId.isEmpty() && p4prodId.equals(machine9.getProductId()) && m9Data.get(3)[1] != null ? (Integer) m9Data.get(3)[1] : 3);
        machine9.setProcess5PassFail(!m9flagid.isEmpty() && m9flagid.equals(machine9.getProductId()) && m9Data.get(4)[1] != null ? (Integer) m9Data.get(4)[1] : 3);

        machine10 = new Machine10();
        Object[] m10Data = (Object[]) entityManager2.createNativeQuery(MACHINE_10_QUERY).getSingleResult();
        machine10.setProductId((String) m10Data[0]);
        m10flagid = machine10.getProductId();
        machine10.setProcess1PassFail(m10Data[1] != null ? (Integer) m10Data[1] : 3);
        machine10.setProcess1Parameter1(m10Data[2] != null ? (Double) m10Data[2] : 0);
        machine10.setProcess1Parameter2(m10Data[3] != null ? (Double) m10Data[3] : 0);
        machine10.setProcess1Parameter3(m10Data[4] != null ? (Double) m10Data[4] : 0);
        machine10.setProcess1Parameter4(m10Data[5] != null ? (Double) m10Data[5] : 0);
        machine10.setProcess1Parameter5(m10Data[6] != null ? (Double) m10Data[6] : 0);
        machine10.setProcess1Parameter6(m10Data[7] != null ? (Double) m10Data[7] : 0);

        machine11 = new Machine11();
        Object[]  m11Data = (Object[]) entityManager2.createNativeQuery(MACHINE_11_QUERY).getSingleResult();
        machine11.setProductId((String) m11Data[0]);
        machine11.setProcess1PassFail(m11Data[1] != null ? (Integer) m11Data[1] : 3);
        m11flagid = m11Data[0] != null ? (String) m11Data[0] : "";
        machine11.setProcess1Parameter1(!m11flagid.isEmpty() && m11flagid.equals(machine11.getProductId()) && m11Data[2] != null ? (Double) m11Data[2] : 0);
        machine11.setProcess1Parameter2(!m11flagid.isEmpty() && m11flagid.equals(machine11.getProductId()) && m11Data[3] != null ? (Double) m11Data[3] : 0);
        machine11.setProcess1Parameter3(!m11flagid.isEmpty() && m11flagid.equals(machine11.getProductId()) && m11Data[4] != null ? (Double) m11Data[4] : 0);
         
        Machine19 = new Machine19();
        Object[]  m12Data = (Object[]) entityManager2.createNativeQuery(MACHINE_12_QUERY).getSingleResult();
        Machine19.setProductId((String) m12Data[0]);
        Machine19.setProcess1PassFail(m12Data[1] != null ? (Integer) m12Data[1] : 3);
        m12flagid = m11Data[0] != null ? (String) m12Data[0] : "";
        Machine19.setProcess1Parameter1(!m12flagid.isEmpty() && m12flagid.equals(Machine19.getProductId()) && m12Data[2] != null ? (Double) m12Data[2] : 0);
        Machine19.setProcess1Parameter2(!m12flagid.isEmpty() && m12flagid.equals(Machine19.getProductId()) && m12Data[3] != null ? (Double) m12Data[3] : 0);
        Machine19.setProcess1Parameter3(!m12flagid.isEmpty() && m12flagid.equals(Machine19.getProductId()) && m12Data[4] != null ? (Double) m12Data[4] : 0);


        machine13 = new Machine13();
        List<Object[]> m13Data = entityManager2.createNativeQuery(MACHINE_13_QUERY).getResultList();
        machine13.setProductId((String) m13Data.get(0)[0]);
        machine13.setProcess1PassFail(m13Data.get(0)[1] != null ? (Integer) m13Data.get(0)[1] : 3);
        machine13.setProcess1Parameter1(m13Data.get(0)[2] != null ? (Double) m13Data.get(0)[2] : 0);
        machine13.setProcess1Parameter2(m13Data.get(0)[3] != null ? (Double) m13Data.get(0)[3] : 0);
        machine13.setProcess1Parameter3(m13Data.get(0)[4] != null ? (Double) m13Data.get(0)[4] : 0);
        machine13.setProcess1Parameter4(m13Data.get(0)[5] != null ? (Double) m13Data.get(0)[5] : 0);
        machine13.setProcess1Parameter5(m13Data.get(0)[6] != null ? (Double) m13Data.get(0)[6] : 0);
        machine13.setProcess1Parameter6(m13Data.get(0)[7] != null ? (Double) m13Data.get(0)[7] : 0);
        p2prodId = m13Data.get(1)[0] != null ? (String) m13Data.get(1)[0] : "";
        p3prodId = m13Data.get(2)[0] != null ? (String) m13Data.get(2)[0] : "";
        p4prodId = m13Data.get(3)[0] != null ? (String) m13Data.get(3)[0] : "";
        m13flagid = m13Data.get(4)[0] != null ? (String) m13Data.get(4)[0] : "";
        machine13.setProcess2PassFail(!p2prodId.isEmpty() && p2prodId.equals(machine13.getProductId()) && m13Data.get(1)[1] != null ? (Integer) m13Data.get(1)[1] : 3);
        machine13.setProcess3PassFail(!p3prodId.isEmpty() && p3prodId.equals(machine13.getProductId()) && m13Data.get(2)[1] != null ? (Integer) m13Data.get(2)[1] : 3);
        machine13.setProcess4PassFail(!p4prodId.isEmpty() && p4prodId.equals(machine13.getProductId()) && m13Data.get(3)[1] != null ? (Integer) m13Data.get(3)[1] : 3);
        machine13.setProcess5PassFail(!m13flagid.isEmpty() && m13flagid.equals(machine13.getProductId()) && m13Data.get(4)[1] != null ? (Integer) m13Data.get(4)[1] : 3);


        machine14 = new Machine14();
        Object[] m14Data = (Object[]) entityManager2.createNativeQuery(MACHINE_14_QUERY).getSingleResult();
        machine14.setProductId((String) m14Data[0]);
        m14flagid = machine14.getProductId();
        machine14.setProcess1PassFail(m14Data[1] != null ? (Integer) m14Data[1] : 3);
        machine14.setProcess1Parameter1(m14Data[2] != null ? (Double) m14Data[2] : 0);
        machine14.setProcess1Parameter2(m14Data[3] != null ? (Double) m14Data[3] : 0);
        machine14.setProcess1Parameter3(m14Data[4] != null ? (Double) m14Data[4] : 0);
        machine14.setProcess1Parameter4(m14Data[5] != null ? (Double) m14Data[5] : 0);
        machine14.setProcess1Parameter5(m14Data[6] != null ? (Double) m14Data[6] : 0);
        machine14.setProcess1Parameter6(m14Data[7] != null ? (Double) m14Data[7] : 0);


        Object[] currentShiftFromTable = (Object[]) entityManager1.createNativeQuery(CURRENT_SHIFT_QUERY).getSingleResult();
        m12flagid1 = currentShiftFromTable[3] != null ? (String) currentShiftFromTable[3] : "";
        Machine19.setSflPartId(!m12flagid1.isEmpty() && m12flagid1.equals(Machine19.getProductId()) && currentShiftFromTable[0] != null ? (String) currentShiftFromTable[0] : "NA");
        m12flagid1 = Machine19.getProductId();
        Machine19.setCurrentShift((Integer) currentShiftFromTable[1]);
        //to show the sflPartId(SFL SERIAL NUMBER) for machine11
        Object[] currentShiftFromTable1 = (Object[]) entityManager1.createNativeQuery(CURRENT_SHIFT_QUERY1).getSingleResult();
        m11flagid1 = currentShiftFromTable1[3] != null ? String.valueOf(currentShiftFromTable1[3]) : "";
        machine11.setSflPartId(!m11flagid1.isEmpty() && m11flagid1.equals(machine11.getProductId()) && currentShiftFromTable1[0] != null ? String.valueOf(currentShiftFromTable1[0]) : "NA");
        m11flagid1 = machine11.getProductId();
        machine11.setCurrentShift((Integer) currentShiftFromTable1[1]);
        //
       
        List<Object[]> allMachineStatus = entityManager3.createNativeQuery(ALL_MACHINE_CURRENT_STATUS).getResultList();
        prodId = allMachineStatus.get(0)[0] != null ? (String) allMachineStatus.get(0)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(0)[1] != null ? (Integer) allMachineStatus.get(0)[1] : 4);
        machine1.setStatus(!prodId.isEmpty() && prodId.equals(m1flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(1)[0] != null ? (String) allMachineStatus.get(1)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(1)[1] != null ? (Integer) allMachineStatus.get(1)[1] : 4);
        machine2.setStatus(!prodId.isEmpty() && prodId.equals(m2flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(2)[0] != null ? (String) allMachineStatus.get(2)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(2)[1] != null ? (Integer) allMachineStatus.get(2)[1] : 4);
        machine3.setStatus(!prodId.isEmpty() && prodId.equals(m3flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(3)[0] != null ? (String) allMachineStatus.get(3)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(3)[1] != null ? (Integer) allMachineStatus.get(3)[1] : 4);
        machine4.setStatus(!prodId.isEmpty() && prodId.equals(m4flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(4)[0] != null ? (String) allMachineStatus.get(4)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(4)[1] != null ? (Integer) allMachineStatus.get(4)[1] : 4);
        machine5.setStatus(!prodId.isEmpty() && prodId.equals(m5flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(5)[0] != null ? (String) allMachineStatus.get(5)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(5)[1] != null ? (Integer) allMachineStatus.get(5)[1] : 4);
        machine6.setStatus(!prodId.isEmpty() && prodId.equals(m6flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(6)[0] != null ? (String) allMachineStatus.get(6)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(6)[1] != null ? (Integer) allMachineStatus.get(6)[1] : 4);
        machine7.setStatus(!prodId.isEmpty() && prodId.equals(m7flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        prodId = allMachineStatus.get(7)[0] != null ? (String) allMachineStatus.get(7)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(7)[1] != null ? (Integer) allMachineStatus.get(7)[1] : 4);
        machine8.setStatus(!prodId.isEmpty() && prodId.equals(m8flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        
        prodId = allMachineStatus.get(8)[0] != null ? (String) allMachineStatus.get(8)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(8)[1] != null ? (Integer) allMachineStatus.get(8)[1] : 4);
        machine9.setStatus(!prodId.isEmpty() && prodId.equals(m9flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
                
        prodId = allMachineStatus.get(9)[0] != null ? (String) allMachineStatus.get(9)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(9)[1] != null ? (Integer) allMachineStatus.get(9)[1] : 4);
        machine10.setStatus(!prodId.isEmpty() && prodId.equals(m10flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        
        prodId = allMachineStatus.get(10)[0] != null ? (String) allMachineStatus.get(10)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(10)[1] != null ? (Integer) allMachineStatus.get(10)[1] : 4);
        machine11.setStatus(!prodId.isEmpty() && prodId.equals(m11flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
       
        prodId = allMachineStatus.get(11)[0] != null ? (String) allMachineStatus.get(11)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(11)[1] != null ? (Integer) allMachineStatus.get(11)[1] : 4);
        Machine19.setStatus(!prodId.isEmpty() && prodId.equals(m12flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        prodId = allMachineStatus.get(12)[0] != null ? (String) allMachineStatus.get(12)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(12)[1] != null ? (Integer) allMachineStatus.get(12)[1] : 4);
        machine13.setStatus(!prodId.isEmpty() && prodId.equals(m13flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        
        prodId = allMachineStatus.get(13)[0] != null ? (String) allMachineStatus.get(13)[0] : "";
        prodStatus = Integer.valueOf(allMachineStatus.get(13)[1] != null ? (Integer) allMachineStatus.get(9)[1] : 4);
        machine14.setStatus(!prodId.isEmpty() && prodId.equals(m14flagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);
        
        
           
        line1.setMachine1(machine1);
        line1.setMachine2(machine2);
        line1.setMachine3(machine3);
        line1.setMachine4(machine4);
        line1.setMachine5(machine5);
        line1.setMachine6(machine6);
        line1.setMachine7(machine7);
        line1.setMachine8(machine8);
        line1.setMachine9(machine9);
        line1.setMachine10(machine10);
        line1.setMachine11(machine11);
        line1.setMachine19(Machine19);
        line1.setMachine13(machine13);
        line1.setMachine14(machine14);

        entityManager.close();
        entityManager1.close();
        entityManager2.close();
        entityManager3.close();

        return line1;
    }

    //Machine1
    public Machine1 getUpdatedMachine1Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine1 mData = new Machine1();
        String mQuery = getIndividualMachineQuery("machine1production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_1_QUERY).getResultList();
        String mflagid = mInitData.get(3)[0] != null ? (String) mInitData.get(3)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine1CSVData> getMachine1Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p2.pass_fail as process3status, p3.pass_fail as process4status, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine1production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine1CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine1fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> m1CompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(m1CompleteData.size() >= 1) {
            for(Object[] data : m1CompleteData) {
                if(data != null) {
                    Machine1CSVData mData = new Machine1CSVData();
                    mData.setMachine_name("OP1010 - OIL HOLE CHECKING MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setOcv_hole_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setOcv_hole_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setOcv_hole_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setBap_hole_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setBap_hole_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setBap_hole_status("NA");
                    }
                    if(data[8] != null) {
                        p3status = Integer.valueOf((Integer) data[8]);
                        if(p3status.intValue() == 1) {
                            mData.setPipe_plug_hole_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setPipe_plug_hole_status("NOT OK");
                        }
                    }
                    if(data[8] == null) {
                        mData.setPipe_plug_hole_status("NA");
                    }
                    if(data[9] != null) {
                        p4status = Integer.valueOf((Integer) data[9]);
                        if(p4status.intValue() == 1) {
                            mData.setThread_plug_hole_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setThread_plug_hole_status("NOT OK");
                        }
                    }
                    if(data[9] == null) {
                        mData.setThread_plug_hole_status("NA");
                    }
                    if(data[10] != null) {
                        String reason = failReason.get((Integer) data[10]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[10] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[11] != null ? (String) data[11] : "NA");
                    machineCSVDataList.add(mData);
                }
            }
        }

        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine1CSVData> getMachine1FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
//                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
//                "p2.pass_fail as process3status, p3.pass_fail as process4status FROM machine1production p "+
//                "INNER JOIN machine1process1 p0 ON p.product_id = p0.product_id AND '["+fDate+", "+tDate+"]'::daterange @> p0.filter_date"+
//                "INNER JOIN machine1process2 p1 ON p.product_id = p1.product_id AND '["+fDate+", "+tDate+"]'::daterange @> p1.filter_date"+
//                "INNER JOIN machine1process3 p2 ON p.product_id = p2.product_id AND '["+fDate+", "+tDate+"]'::daterange @> p2.filter_date"+
//                "INNER JOIN machine1process4 p3 ON p.product_id = p3.product_id AND '["+fDate+", "+tDate+"]'::daterange @> p3.filter_date";

        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p2.pass_fail as process3status, p3.pass_fail as process4status, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine1production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine1CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine1fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine1CSVData mData = new Machine1CSVData();
                    mData.setMachine_name("OP1010 - OIL HOLE CHECKING MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setOcv_hole_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setOcv_hole_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setOcv_hole_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setBap_hole_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setBap_hole_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setBap_hole_status("NA");
                    }
                    if(data[8] != null) {
                        p3status = Integer.valueOf((Integer) data[8]);
                        if(p3status.intValue() == 1) {
                            mData.setPipe_plug_hole_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setPipe_plug_hole_status("NOT OK");
                        }
                    }
                    if(data[8] == null) {
                        mData.setPipe_plug_hole_status("NA");
                    }
                    if(data[9] != null) {
                        p4status = Integer.valueOf((Integer) data[9]);
                        if(p4status.intValue() == 1) {
                            mData.setThread_plug_hole_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setThread_plug_hole_status("NOT OK");
                        }
                    }
                    if(data[9] == null) {
                        mData.setThread_plug_hole_status("NA");
                    }
                    if(data[10] != null) {
                        String reason = failReason.get((Integer) data[10]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[10] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[11] != null ? (String) data[11] : "NA");
                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine1CSVData> getMachine1DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p2.pass_fail as process3status, p3.pass_fail as process4status, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine1production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Machine1CSVData mData = null;
        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine1CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine1fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        mData = new Machine1CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1010 - OIL HOLE CHECKING MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if (mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if (mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if (mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");

            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if (prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if (prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if (p1status.intValue() == 1) {
                    mData.setOcv_hole_status("OK");
                }
                if (p1status.intValue() != 1) {
                    mData.setOcv_hole_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setOcv_hole_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[7]);
                if (p2status.intValue() == 1) {
                    mData.setBap_hole_status("OK");
                }
                if (p2status.intValue() != 1) {
                    mData.setBap_hole_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setBap_hole_status("NA");
            }
            if(dataBasedOnProductId.get(0)[8] != null) {
                p3status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[8]);
                if (p3status.intValue() == 1) {
                    mData.setPipe_plug_hole_status("OK");
                }
                if (p3status.intValue() != 1) {
                    mData.setPipe_plug_hole_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[8] == null) {
                mData.setPipe_plug_hole_status("NA");
            }
            if(dataBasedOnProductId.get(0)[9] != null) {
                p4status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[9]);
                if (p4status.intValue() == 1) {
                    mData.setThread_plug_hole_status("OK");
                }
                if (p4status.intValue() != 1) {
                    mData.setThread_plug_hole_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[9] == null) {
                mData.setThread_plug_hole_status("NA");
            }
            if(dataBasedOnProductId.get(0)[10] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[10]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[10] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[11] != null ? (String) dataBasedOnProductId.get(0)[11] : "NA");
            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    private String getIndividualMachineQuery(String machineName) {
        String query = "SELECT p.product_id, p.shift, p.pass_fail, p.total_shift_count, "+
                "p.shift_count, p.shift_reject_count, p.start_time, p.end_time, p.cycle_time, p.log_date, p.operator_name "+
                "FROM "+machineName+" p ORDER BY p.mid DESC LIMIT 1";
        return query;
    }

    private String getLineQuery(String machineName) {
        String query = "SELECT p.product_id, p.shift, p.pass_fail, p.total_shift_count, "+
                "p.shift_count, p.shift_reject_count, p.start_time, p.end_time, p.cycle_time, p.sfl_part_id, p.log_date, p.operator_name "+
                "FROM "+machineName+" p ORDER BY p.mid DESC LIMIT 1";
        return query;
    }

    private String okPartsQuery(String date, Integer shift) {
        if(date.charAt(0) == '0') {
            date = date.substring(1);
        }
        String query ="( "+
                 "SELECT product_id FROM machine11production WHERE filter_date = '"+date+"' AND pass_fail = 1 AND shift = "+shift+
                 ")"+
                 "UNION ALL "+
                 "( "+ 
                 "SELECT product_id FROM Machine19production WHERE filter_date = '"+date+"' AND pass_fail = 1 AND shift = "+shift+
                 ")";
        return query;
    }

     private String notOkPartsQuery(String date, Integer shift) {
//         if(date.charAt(0) == '0') {
//             date = date.substring(1);
//         }
         String query = "( "+
                 "SELECT product_id FROM machine1production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine2production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine3production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine4production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine5production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine6production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine7production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine8production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine9production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine10production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine11production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ")"+
                 "UNION ALL "+
                 "( "+ 
                 "SELECT product_id FROM Machine19production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ")"+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine13production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") "+
                 "UNION ALL "+
                 "( "+
                 "SELECT product_id FROM machine14production WHERE filter_date = '"+date+"' AND pass_fail = 0 AND shift = "+shift+
                 ") ";
         return query;
     }

    //Machine2
    public Machine2 getUpdatedMachine2Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine2 mData = new Machine2();
        String mQuery = getIndividualMachineQuery("machine2production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_2_QUERY).getResultList();
        String mflagid = mInitData.get(1)[0] != null ? (String) mInitData.get(1)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine2CSVData> getMachine2Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p0.parameter4 as process1param4, p1.parameter1 as process2param1, p1.parameter2 as process2param2, "+
                "p1.parameter3 as process2param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine2production p "+
                "LEFT JOIN machine2process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine2process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine2CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine2fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine2CSVData mData = new Machine2CSVData();
                    mData.setMachine_name("OP1020A - BALL PRESS MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setBall_press_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setBall_press_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setBall_press_status("NA");
                    }
                    mData.setMin_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setMax_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setActual_id_a_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setActual_id_b_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setMin_load_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setMax_load_value(data[13] != null ? (Double) data[13] : 0);
                    mData.setActual_load_value(data[14] != null ? (Double) data[14] : 0);
                    if(data[15] != null) {
                        String reason = failReason.get((Integer) data[15]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[15] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[16] != null ? (String) data[16] : "NA");
                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine2CSVData> getMachine2FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p0.parameter4 as process1param4, p1.parameter1 as process2param1, p1.parameter2 as process2param2, "+
                "p1.parameter3 as process2param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine2production p "+
                "LEFT JOIN machine2process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine2process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine2CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine2fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine2CSVData mData = new Machine2CSVData();
                    mData.setMachine_name("OP1020A - BALL PRESS MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setBall_press_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setBall_press_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setBall_press_status("NA");
                    }
                    mData.setMin_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setMax_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setActual_id_a_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setActual_id_b_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setMin_load_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setMax_load_value(data[13] != null ? (Double) data[13] : 0);
                    mData.setActual_load_value(data[14] != null ? (Double) data[14] : 0);
                    if(data[15] != null) {
                        String reason = failReason.get((Integer) data[15]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[15] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[16] != null ? (String) data[16] : "NA");
                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine2CSVData> getMachine2DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p0.parameter4 as process1param4, p1.parameter1 as process2param1, p1.parameter2 as process2param2, "+
                "p1.parameter3 as process2param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine2production p "+
                "LEFT JOIN machine2process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine2process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.product_id = '" + productId +"'";

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine2CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine2fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine2CSVData mData = new Machine2CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1020A - BALL PRESS MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setId_gauge_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setId_gauge_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setId_gauge_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[7]);
                if(p2status.intValue() == 1) {
                    mData.setBall_press_status("OK");
                }
                if(p2status.intValue() != 1) {
                    mData.setBall_press_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setBall_press_status("NA");
            }
            mData.setMin_id_gauge_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setMax_id_gauge_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setActual_id_a_gauge_value(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setActual_id_b_gauge_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setMin_load_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            mData.setMax_load_value(dataBasedOnProductId.get(0)[13] != null ? (Double) dataBasedOnProductId.get(0)[13] : 0);
            mData.setActual_load_value(dataBasedOnProductId.get(0)[14] != null ? (Double) dataBasedOnProductId.get(0)[14] : 0);
            if(dataBasedOnProductId.get(0)[15] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[15]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[15] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[16] != null ? (String) dataBasedOnProductId.get(0)[16] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine3
    public Machine3 getUpdatedMachine3Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine3 mData = new Machine3();
        String mQuery = getIndividualMachineQuery("machine3production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_3_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine3CSVData> getMachine3Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine3production p "+
                "LEFT JOIN machine3process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine3CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine3fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine3CSVData mData = new Machine3CSVData();
                    mData.setMachine_name("OP1020B - SOCKET PRESS MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setSocket_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setSocket_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setSocket_press_status("NA");
                    }
                    if(data[7] != null) {
                        String reason = failReason.get((Integer) data[7]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[7] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[8] != null ? (String) data[8] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine3CSVData> getMachine3FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine3production p "+
                "LEFT JOIN machine3process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine3CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine3fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine3CSVData mData = new Machine3CSVData();
                    mData.setMachine_name("OP1020B - SOCKET PRESS MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setSocket_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setSocket_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setSocket_press_status("NA");
                    }
                    if(data[7] != null) {
                        String reason = failReason.get((Integer) data[7]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[7] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[8] != null ? (String) data[8] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine3CSVData> getMachine3DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine3production p "+
                "LEFT JOIN machine3process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine3CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine3fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine3CSVData mData = new Machine3CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1020B - SOCKET PRESS MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setSocket_press_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setSocket_press_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setSocket_press_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[7]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[8] != null ? (String) dataBasedOnProductId.get(0)[8] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine4
    public Machine4 getUpdatedMachine4Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine4 mData = new Machine4();
        String mQuery = getIndividualMachineQuery("machine4production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_4_QUERY).getResultList();
        String mflagid = mInitData.get(1)[0] != null ? (String) mInitData.get(1)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine4CSVData> getMachine4Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine4production p "+
                "LEFT JOIN machine4process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine4process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine4CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine4fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine4CSVData mData = new Machine4CSVData();
                    mData.setMachine_name("OP1030 - SCREW & NUT ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPre_screwing_and_screwing_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPre_screwing_and_screwing_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPre_screwing_and_screwing_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setNut_tightening_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setNut_tightening_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setNut_tightening_status("NA");
                    }
                    if(data[8] != null) {
                        String reason = failReason.get((Integer) data[8]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[8] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[9] != null ? (String) data[9] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine4CSVData> getMachine4FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine4production p "+
                "LEFT JOIN machine4process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine4process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine4CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine4fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine4CSVData mData = new Machine4CSVData();
                    mData.setMachine_name("OP1030 - SCREW & NUT ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPre_screwing_and_screwing_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPre_screwing_and_screwing_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPre_screwing_and_screwing_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setNut_tightening_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setNut_tightening_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setNut_tightening_status("NA");
                    }
                    if(data[8] != null) {
                        String reason = failReason.get((Integer) data[8]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[8] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[9] != null ? (String) data[9] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine4CSVData> getMachine4DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine4production p "+
                "LEFT JOIN machine4process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine4process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.product_id = '" + productId +"'";

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine4CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine4fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine4CSVData mData = new Machine4CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1030 - SCREW & NUT ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setPre_screwing_and_screwing_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setPre_screwing_and_screwing_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setPre_screwing_and_screwing_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[7]);
                if(p2status.intValue() == 1) {
                    mData.setNut_tightening_status("OK");
                }
                if(p2status.intValue() != 1) {
                    mData.setNut_tightening_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setNut_tightening_status("NA");
            }
            if(dataBasedOnProductId.get(0)[8] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[8]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[8] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[9] != null ? (String) dataBasedOnProductId.get(0)[9] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine5
    public Machine5 getUpdatedMachine5Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine5 mData = new Machine5();
        String mQuery = getIndividualMachineQuery("machine5production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_5_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine5CSVData> getMachine5Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine5production p "+
                "LEFT JOIN machine5process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine5CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine5fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine5CSVData mData = new Machine5CSVData();
                    mData.setMachine_name("OP1040A - PIPE PLUG VALVE ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPipe_plug_asmbly_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPipe_plug_asmbly_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPipe_plug_asmbly_status("NA");
                    }
                    mData.setTarget_torque(data[7] != null ? (Double) data[7] : 0);
                    mData.setActual_torque(data[8] != null ? (Double) data[8] : 0);
                    if(data[9] != null) {
                        String reason = failReason.get((Integer) data[9]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[9] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[10] != null ? (String) data[10] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine5CSVData> getMachine5FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine5production p "+
                "LEFT JOIN machine5process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine5CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine5fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine5CSVData mData = new Machine5CSVData();
                    mData.setMachine_name("OP1040A - PIPE PLUG VALVE ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPipe_plug_asmbly_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPipe_plug_asmbly_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPipe_plug_asmbly_status("NA");
                    }
                    mData.setTarget_torque(data[7] != null ? (Double) data[7] : 0);
                    mData.setActual_torque(data[8] != null ? (Double) data[8] : 0);
                    if(data[9] != null) {
                        String reason = failReason.get((Integer) data[9]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[9] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[10] != null ? (String) data[10] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine5CSVData> getMachine5DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine5production p "+
                "LEFT JOIN machine5process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine5CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine5fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine5CSVData mData = new Machine5CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1040A - PIPE PLUG VALVE ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setPipe_plug_asmbly_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setPipe_plug_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setPipe_plug_asmbly_status("NA");
            }
            mData.setTarget_torque(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setActual_torque(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            if(dataBasedOnProductId.get(0)[9] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[9]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[9] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[10] != null ? (String) dataBasedOnProductId.get(0)[10] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine6
    public Machine6 getUpdatedMachine6Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine6 mData = new Machine6();
        String mQuery = getIndividualMachineQuery("machine6production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_6_QUERY).getResultList();
        String mflagid = mInitData.get(1)[0] != null ? (String) mInitData.get(1)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine6CSVData> getMachine6Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p1.parameter1 as process2param1, p1.parameter2 as process2param2, p1.parameter3 as process2param3, "+
                "p1.parameter4 as process2param4, p1.parameter5 as process2param5, p1.parameter6 as process2param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine6production p "+
                "LEFT JOIN machine6process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine6process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine6CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine6fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine6CSVData mData = new Machine6CSVData();
                    mData.setMachine_name("OP1040B - INSERT VALVE ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setInsert_valve_press_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setInsert_valve_press_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setInsert_valve_press_status("NA");
                    }
                    mData.setMin_id_gauge_bore_dia(data[8] != null ? (Double) data[8] : 0);
                    mData.setMax_id_gauge_bore_dia(data[9] != null ? (Double) data[9] : 0);
                    mData.setActual_id_gauge_bore_dia(data[10] != null ? (Double) data[10] : 0);
                    mData.setMin_load_insert_valve_press_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setMax_load_insert_valve_press_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setActual_load_insert_valve_press_value(data[13] != null ? (Double) data[13] : 0);
                    mData.setMin_displacement_insert_valve_value(data[14] != null ? (Double) data[14] : 0);
                    mData.setMax_displacement_insert_valve_value(data[15] != null ? (Double) data[15] : 0);
                    mData.setActual_displacement_insert_valve_value(data[16] != null ? (Double) data[16] : 0);
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine6CSVData> getMachine6FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p1.parameter1 as process2param1, p1.parameter2 as process2param2, p1.parameter3 as process2param3, "+
                "p1.parameter4 as process2param4, p1.parameter5 as process2param5, p1.parameter6 as process2param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine6production p "+
                "LEFT JOIN machine6process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine6process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine6CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine6fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine6CSVData mData = new Machine6CSVData();
                    mData.setMachine_name("OP1040B - INSERT VALVE ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    if(data[7] != null) {
                        p2status = Integer.valueOf((Integer) data[7]);
                        if(p2status.intValue() == 1) {
                            mData.setInsert_valve_press_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setInsert_valve_press_status("NOT OK");
                        }
                    }
                    if(data[7] == null) {
                        mData.setInsert_valve_press_status("NA");
                    }
                    mData.setMin_id_gauge_bore_dia(data[8] != null ? (Double) data[8] : 0);
                    mData.setMax_id_gauge_bore_dia(data[9] != null ? (Double) data[9] : 0);
                    mData.setActual_id_gauge_bore_dia(data[10] != null ? (Double) data[10] : 0);
                    mData.setMin_load_insert_valve_press_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setMax_load_insert_valve_press_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setActual_load_insert_valve_press_value(data[13] != null ? (Double) data[13] : 0);
                    mData.setMin_displacement_insert_valve_value(data[14] != null ? (Double) data[14] : 0);
                    mData.setMax_displacement_insert_valve_value(data[15] != null ? (Double) data[15] : 0);
                    mData.setActual_displacement_insert_valve_value(data[16] != null ? (Double) data[16] : 0);
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine6CSVData> getMachine6DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p1.pass_fail as process2status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p1.parameter1 as process2param1, p1.parameter2 as process2param2, p1.parameter3 as process2param3, "+
                "p1.parameter4 as process2param4, p1.parameter5 as process2param5, p1.parameter6 as process2param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine6production p "+
                "LEFT JOIN machine6process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine6process2 p1 ON p.product_id = p1.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine6CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine6fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine6CSVData mData = new Machine6CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1040B - INSERT VALVE ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setId_gauge_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setId_gauge_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setId_gauge_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[7]);
                if(p2status.intValue() == 1) {
                    mData.setInsert_valve_press_status("OK");
                }
                if(p2status.intValue() != 1) {
                    mData.setInsert_valve_press_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setInsert_valve_press_status("NA");
            }
            mData.setMin_id_gauge_bore_dia(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setMax_id_gauge_bore_dia(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setActual_id_gauge_bore_dia(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setMin_load_insert_valve_press_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setMax_load_insert_valve_press_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            mData.setActual_load_insert_valve_press_value(dataBasedOnProductId.get(0)[13] != null ? (Double) dataBasedOnProductId.get(0)[13] : 0);
            mData.setMin_displacement_insert_valve_value(dataBasedOnProductId.get(0)[14] != null ? (Double) dataBasedOnProductId.get(0)[14] : 0);
            mData.setMax_displacement_insert_valve_value(dataBasedOnProductId.get(0)[15] != null ? (Double) dataBasedOnProductId.get(0)[15] : 0);
            mData.setActual_displacement_insert_valve_value(dataBasedOnProductId.get(0)[16] != null ? (Double) dataBasedOnProductId.get(0)[16] : 0);
            if(dataBasedOnProductId.get(0)[17] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[17]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[17] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[18] != null ? (String) dataBasedOnProductId.get(0)[18] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine7
    public Machine7 getUpdatedMachine7Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine7 mData = new Machine7();
        String mQuery = getIndividualMachineQuery("machine7production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_7_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine7CSVData> getMachine7Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine7production p "+
                "LEFT JOIN machine7process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine7CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine7fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine7CSVData mData = new Machine7CSVData();
                    mData.setMachine_name("OP1040C - BALL OVER HEIGHT CHECK MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setBall_over_height_check_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setBall_over_height_check_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setBall_over_height_check_status("NA");
                    }
                    mData.setMin_ball_over_height_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ball_over_height_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ball_over_height_value(data[9] != null ? (Double) data[9] : 0);
                    if(data[10] != null) {
                        String reason = failReason.get((Integer) data[10]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[10] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[11] != null ? (String) data[11] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine7CSVData> getMachine7FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine7production p "+
                "LEFT JOIN machine7process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine7CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine7fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine7CSVData mData = new Machine7CSVData();
                    mData.setMachine_name("OP1040C - BALL OVER HEIGHT CHECK MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setBall_over_height_check_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setBall_over_height_check_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setBall_over_height_check_status("NA");
                    }
                    mData.setMin_ball_over_height_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ball_over_height_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ball_over_height_value(data[9] != null ? (Double) data[9] : 0);
                    if(data[10] != null) {
                        String reason = failReason.get((Integer) data[10]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[10] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[11] != null ? (String) data[11] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;

    }

    public ArrayList<Machine7CSVData> getMachine7DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p.fail_reason as failreason, p.cycle_time as cycletime "+
                "FROM machine7production p "+
                "LEFT JOIN machine7process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine7CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine7fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine7CSVData mData = new Machine7CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1040C - BALL OVER HEIGHT CHECK MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setBall_over_height_check_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setBall_over_height_check_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setBall_over_height_check_status("NA");
            }
            mData.setMin_ball_over_height_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_ball_over_height_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_ball_over_height_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            if(dataBasedOnProductId.get(0)[10] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[10]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[10] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[11] != null ? (String) dataBasedOnProductId.get(0)[11] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine8
    public Machine8 getUpdatedMachine8Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine8 mData = new Machine8();
        String mQuery = getIndividualMachineQuery("machine8production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_8_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine8CSVData> getMachine8Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p0.parameter4 as process1param4 "+
                "FROM machine8production p "+
                "LEFT JOIN machine8process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine8CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine8fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine8CSVData mData = new Machine8CSVData();
                    mData.setMachine_name("OP1040D - THREAD PLUG ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setBall_spring_oring_thread_plug_asmbly_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setBall_spring_oring_thread_plug_asmbly_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setBall_spring_oring_thread_plug_asmbly_status("NA");
                    }
                    if(data[7] != null) {
                        String reason = failReason.get((Integer) data[7]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[7] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[8] != null ? (String) data[8] : "NA");
                    mData.setMinimum_torque(data[9] != null ? (Double) data[9] : 0);
                    mData.setMaximum_torque(data[10] != null ? (Double) data[10] : 0);
                    mData.setActual_torque(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_angle(data[12] != null ? (Double) data[12] : 0);

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine8CSVData> getMachine8FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p0.parameter4 as process1param4 "+
                "FROM machine8production p "+
                "LEFT JOIN machine8process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine8CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine8fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine8CSVData mData = new Machine8CSVData();
                    mData.setMachine_name("OP1040D - THREAD PLUG ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setBall_spring_oring_thread_plug_asmbly_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setBall_spring_oring_thread_plug_asmbly_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setBall_spring_oring_thread_plug_asmbly_status("NA");
                    }
                    if(data[7] != null) {
                        String reason = failReason.get((Integer) data[7]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[7] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[8] != null ? (String) data[8] : "NA");
                    mData.setMinimum_torque(data[9] != null ? (Double) data[9] : 0);
                    mData.setMaximum_torque(data[10] != null ? (Double) data[10] : 0);
                    mData.setActual_torque(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_angle(data[12] != null ? (Double) data[12] : 0);

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine8CSVData> getMachine8DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime, p0.parameter1 as process1param1, "+
                "p0.parameter2 as process1param2, p0.parameter3 as process1param3, p0.parameter4 as process1param4 "+
                "FROM machine8production p "+
                "LEFT JOIN machine8process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine8CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine8fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine8CSVData mData = new Machine8CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1040D - THREAD PLUG ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setBall_spring_oring_thread_plug_asmbly_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setBall_spring_oring_thread_plug_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setBall_spring_oring_thread_plug_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[7] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[7]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[7] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[8] != null ? (String) dataBasedOnProductId.get(0)[8] : "NA");
            mData.setMinimum_torque(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setMaximum_torque(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setActual_torque(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setActual_angle(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }
       //////////////////////////Machine9///////////////////////////////

    public Machine9 getUpdatedMachine9Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine9 mData = new Machine9();
        String mQuery = getIndividualMachineQuery("machine9production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_9_QUERY).getResultList();
        String mflagid = mInitData.get(4)[0] != null ? (String) mInitData.get(4)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine9CSVData> getMachine9Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine9production p "+
                "LEFT JOIN machine9process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine9process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine9process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine9process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine9process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine9CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine9fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine9CSVData mData = new Machine9CSVData();
                    mData.setMachine_name("OP1050 - OCV ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    mData.setMin_ocv_id_gauge_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ocv_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ocv_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_bap_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_bap_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_bap_id_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        p2status = Integer.valueOf((Integer) data[13]);
                        if(p2status.intValue() == 1) {
                            mData.setOcv_and_bap_asmbly_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setOcv_and_bap_asmbly_status("NOT OK");
                        }
                    }
                    if(data[13] == null) {
                        mData.setOcv_and_bap_asmbly_status("NA");
                    }
                    if(data[14] != null) {
                        p3status = Integer.valueOf((Integer) data[14]);
                        if(p3status.intValue() == 1) {
                            mData.setSpring_asmbly_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setSpring_asmbly_status("NOT OK");
                        }
                    }
                    if(data[14] == null) {
                        mData.setSpring_asmbly_status("NA");
                    }
                    if(data[15] != null) {
                        p4status = Integer.valueOf((Integer) data[15]);
                        if(p4status.intValue() == 1) {
                            mData.setRetainer_asmbly_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setRetainer_asmbly_status("NOT OK");
                        }
                    }
                    if(data[15] == null) {
                        mData.setRetainer_asmbly_status("NA");
                    }
                    if(data[16] != null) {
                        p5status = Integer.valueOf((Integer) data[16]);
                        if(p5status.intValue() == 1) {
                            mData.setCirclip_asmbly_status("OK");
                        }
                        if(p5status.intValue() != 1) {
                            mData.setCirclip_asmbly_status("NOT OK");
                        }
                    }
                    if(data[16] == null) {
                        mData.setCirclip_asmbly_status("NA");
                    }
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine9CSVData> getMachine9FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine9production p "+
                "LEFT JOIN machine9process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine9process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine9process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine9process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine9process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine9CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine9fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine9CSVData mData = new Machine9CSVData();
                    mData.setMachine_name("OP1050 - OCV ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    mData.setMin_ocv_id_gauge_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ocv_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ocv_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_bap_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_bap_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_bap_id_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        p2status = Integer.valueOf((Integer) data[13]);
                        if(p2status.intValue() == 1) {
                            mData.setOcv_and_bap_asmbly_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setOcv_and_bap_asmbly_status("NOT OK");
                        }
                    }
                    if(data[13] == null) {
                        mData.setOcv_and_bap_asmbly_status("NA");
                    }
                    if(data[14] != null) {
                        p3status = Integer.valueOf((Integer) data[14]);
                        if(p3status.intValue() == 1) {
                            mData.setSpring_asmbly_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setSpring_asmbly_status("NOT OK");
                        }
                    }
                    if(data[14] == null) {
                        mData.setSpring_asmbly_status("NA");
                    }
                    if(data[15] != null) {
                        p4status = Integer.valueOf((Integer) data[15]);
                        if(p4status.intValue() == 1) {
                            mData.setRetainer_asmbly_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setRetainer_asmbly_status("NOT OK");
                        }
                    }
                    if(data[15] == null) {
                        mData.setRetainer_asmbly_status("NA");
                    }
                    if(data[16] != null) {
                        p5status = Integer.valueOf((Integer) data[16]);
                        if(p5status.intValue() == 1) {
                            mData.setCirclip_asmbly_status("OK");
                        }
                        if(p5status.intValue() != 1) {
                            mData.setCirclip_asmbly_status("NOT OK");
                        }
                    }
                    if(data[16] == null) {
                        mData.setCirclip_asmbly_status("NA");
                    }
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine9CSVData> getMachine9DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine9production p "+
                "LEFT JOIN machine9process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine9process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine9process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine9process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine9process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine9CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine9fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine9CSVData mData = new Machine9CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1050 - OCV ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setId_gauge_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setId_gauge_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setId_gauge_status("NA");
            }
            mData.setMin_ocv_id_gauge_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_ocv_id_gauge_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_ocv_id_gauge_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setMin_bap_id_gauge_value(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setMax_bap_id_gauge_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setActual_bap_id_gauge_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            if(dataBasedOnProductId.get(0)[13] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[13]);
                if(p2status.intValue() == 1) {
                    mData.setOcv_and_bap_asmbly_status("OK");
                }
                if(p2status.intValue() != 1) {
                    mData.setOcv_and_bap_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[13] == null) {
                mData.setOcv_and_bap_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[14] != null) {
                p3status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[14]);
                if(p3status.intValue() == 1) {
                    mData.setSpring_asmbly_status("OK");
                }
                if(p3status.intValue() != 1) {
                    mData.setSpring_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[14] == null) {
                mData.setSpring_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[15] != null) {
                p4status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[15]);
                if(p4status.intValue() == 1) {
                    mData.setRetainer_asmbly_status("OK");
                }
                if(p4status.intValue() != 1) {
                    mData.setRetainer_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[15] == null) {
                mData.setRetainer_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[16] != null) {
                p5status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[16]);
                if(p5status.intValue() == 1) {
                    mData.setCirclip_asmbly_status("OK");
                }
                if(p5status.intValue() != 1) {
                    mData.setCirclip_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[16] == null) {
                mData.setCirclip_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[17] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[17]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[17] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[18] != null ? (String) dataBasedOnProductId.get(0)[18] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine13

    public Machine13 getUpdatedMachine13Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine13 mData = new Machine13();
        String mQuery = getIndividualMachineQuery("machine13production");
        String prodId = "";
        Integer prodStatus = null;
        List<Object[]> mInitData = entityManager.createNativeQuery(MACHINE_13_QUERY).getResultList();
        String mflagid = mInitData.get(4)[0] != null ? (String) mInitData.get(4)[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine13CSVData> getMachine13Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine13production p "+
                "LEFT JOIN machine13process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine13process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine13process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine13process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine13process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine13CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine13fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine13CSVData mData = new Machine13CSVData();
                    mData.setMachine_name("OP1050A - OCV ASSEMBLY MACHINE A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    mData.setMin_ocv_id_gauge_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ocv_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ocv_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_bap_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_bap_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_bap_id_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        p2status = Integer.valueOf((Integer) data[13]);
                        if(p2status.intValue() == 1) {
                            mData.setOcv_and_bap_asmbly_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setOcv_and_bap_asmbly_status("NOT OK");
                        }
                    }
                    if(data[13] == null) {
                        mData.setOcv_and_bap_asmbly_status("NA");
                    }
                    if(data[14] != null) {
                        p3status = Integer.valueOf((Integer) data[14]);
                        if(p3status.intValue() == 1) {
                            mData.setSpring_asmbly_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setSpring_asmbly_status("NOT OK");
                        }
                    }
                    if(data[14] == null) {
                        mData.setSpring_asmbly_status("NA");
                    }
                    if(data[15] != null) {
                        p4status = Integer.valueOf((Integer) data[15]);
                        if(p4status.intValue() == 1) {
                            mData.setRetainer_asmbly_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setRetainer_asmbly_status("NOT OK");
                        }
                    }
                    if(data[15] == null) {
                        mData.setRetainer_asmbly_status("NA");
                    }
                    if(data[16] != null) {
                        p5status = Integer.valueOf((Integer) data[16]);
                        if(p5status.intValue() == 1) {
                            mData.setCirclip_asmbly_status("OK");
                        }
                        if(p5status.intValue() != 1) {
                            mData.setCirclip_asmbly_status("NOT OK");
                        }
                    }
                    if(data[16] == null) {
                        mData.setCirclip_asmbly_status("NA");
                    }
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine13CSVData> getMachine13FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine13production p "+
                "LEFT JOIN machine13process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine13process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine13process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine13process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine13process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine13CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine13fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine13CSVData mData = new Machine13CSVData();
                    mData.setMachine_name("OP1050A - OCV ASSEMBLY MACHINE A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setId_gauge_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setId_gauge_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setId_gauge_status("NA");
                    }
                    mData.setMin_ocv_id_gauge_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_ocv_id_gauge_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_ocv_id_gauge_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_bap_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_bap_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_bap_id_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        p2status = Integer.valueOf((Integer) data[13]);
                        if(p2status.intValue() == 1) {
                            mData.setOcv_and_bap_asmbly_status("OK");
                        }
                        if(p2status.intValue() != 1) {
                            mData.setOcv_and_bap_asmbly_status("NOT OK");
                        }
                    }
                    if(data[13] == null) {
                        mData.setOcv_and_bap_asmbly_status("NA");
                    }
                    if(data[14] != null) {
                        p3status = Integer.valueOf((Integer) data[14]);
                        if(p3status.intValue() == 1) {
                            mData.setSpring_asmbly_status("OK");
                        }
                        if(p3status.intValue() != 1) {
                            mData.setSpring_asmbly_status("NOT OK");
                        }
                    }
                    if(data[14] == null) {
                        mData.setSpring_asmbly_status("NA");
                    }
                    if(data[15] != null) {
                        p4status = Integer.valueOf((Integer) data[15]);
                        if(p4status.intValue() == 1) {
                            mData.setRetainer_asmbly_status("OK");
                        }
                        if(p4status.intValue() != 1) {
                            mData.setRetainer_asmbly_status("NOT OK");
                        }
                    }
                    if(data[15] == null) {
                        mData.setRetainer_asmbly_status("NA");
                    }
                    if(data[16] != null) {
                        p5status = Integer.valueOf((Integer) data[16]);
                        if(p5status.intValue() == 1) {
                            mData.setCirclip_asmbly_status("OK");
                        }
                        if(p5status.intValue() != 1) {
                            mData.setCirclip_asmbly_status("NOT OK");
                        }
                    }
                    if(data[16] == null) {
                        mData.setCirclip_asmbly_status("NA");
                    }
                    if(data[17] != null) {
                        String reason = failReason.get((Integer) data[17]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[17] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[18] != null ? (String) data[18] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine13CSVData> getMachine13DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p2.pass_fail as process2status, p3.pass_fail as process3status, p4.pass_fail as process4status, "+
                "p5.pass_fail as process5status, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine13production p "+
                "LEFT JOIN machine13process1 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine13process2 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine13process3 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine13process4 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine13process5 p5 ON p.product_id = p5.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine13CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine13fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine13CSVData mData = new Machine13CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1050A - OCV ASSEMBLY MACHINE A");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setId_gauge_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setId_gauge_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setId_gauge_status("NA");
            }
            mData.setMin_ocv_id_gauge_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_ocv_id_gauge_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_ocv_id_gauge_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setMin_bap_id_gauge_value(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setMax_bap_id_gauge_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setActual_bap_id_gauge_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            if(dataBasedOnProductId.get(0)[13] != null) {
                p2status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[13]);
                if(p2status.intValue() == 1) {
                    mData.setOcv_and_bap_asmbly_status("OK");
                }
                if(p2status.intValue() != 1) {
                    mData.setOcv_and_bap_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[13] == null) {
                mData.setOcv_and_bap_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[14] != null) {
                p3status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[14]);
                if(p3status.intValue() == 1) {
                    mData.setSpring_asmbly_status("OK");
                }
                if(p3status.intValue() != 1) {
                    mData.setSpring_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[14] == null) {
                mData.setSpring_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[15] != null) {
                p4status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[15]);
                if(p4status.intValue() == 1) {
                    mData.setRetainer_asmbly_status("OK");
                }
                if(p4status.intValue() != 1) {
                    mData.setRetainer_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[15] == null) {
                mData.setRetainer_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[16] != null) {
                p5status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[16]);
                if(p5status.intValue() == 1) {
                    mData.setCirclip_asmbly_status("OK");
                }
                if(p5status.intValue() != 1) {
                    mData.setCirclip_asmbly_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[16] == null) {
                mData.setCirclip_asmbly_status("NA");
            }
            if(dataBasedOnProductId.get(0)[17] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[17]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[17] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[18] != null ? (String) dataBasedOnProductId.get(0)[18] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }


    //Machine10
    public Machine10 getUpdatedMachine10Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine10 mData = new Machine10();
        String mQuery = getIndividualMachineQuery("machine10production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_10_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");
        entityManager.close();
        return mData;
    }

    public ArrayList<Machine10CSVData> getMachine10Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine10production p "+
                "LEFT JOIN machine10process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine10CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine10fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine10CSVData mData = new Machine10CSVData();
                    mData.setMachine_name("OP1060 - PIN PRESS ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPin_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPin_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPin_press_status("NA");
                    }
                    mData.setMin_pin_press_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_pin_press_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_pin_press_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_pin_displacement_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_pin_displacement_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_pin_displacement_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        String reason = failReason.get((Integer) data[13]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[13] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[14] != null ? (String) data[14] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine10CSVData> getMachine10FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine10production p "+
                "LEFT JOIN machine10process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine10CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine10fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine10CSVData mData = new Machine10CSVData();
                    mData.setMachine_name("OP1060 - PIN PRESS ASSEMBLY MACHINE");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPin_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPin_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPin_press_status("NA");
                    }
                    mData.setMin_pin_press_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_pin_press_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_pin_press_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_pin_displacement_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_pin_displacement_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_pin_displacement_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        String reason = failReason.get((Integer) data[13]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[13] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[14] != null ? (String) data[14] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine10CSVData> getMachine10DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine10production p "+
                "LEFT JOIN machine10process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine10CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine10fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine10CSVData mData = new Machine10CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1060 - PIN PRESS ASSEMBLY MACHINE");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setPin_press_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setPin_press_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setPin_press_status("NA");
            }
            mData.setMin_pin_press_load_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_pin_press_load_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_pin_press_load_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setMin_pin_displacement_value(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setMax_pin_displacement_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setActual_pin_displacement_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            if(dataBasedOnProductId.get(0)[13] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[13]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[13] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[14] != null ? (String) dataBasedOnProductId.get(0)[14] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine11
    public Machine11 getUpdatedMachine11Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine11 mData = new Machine11();
        String mQuery = getLineQuery("machine11production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_11_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");
        mData.setSflPartId(machineCurrentData[9] != null ? (String) machineCurrentData[9] : "NA");

        entityManager.close();
        return mData;
    }

    public ArrayList<Machine11CSVData> getMachine11Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine11production p "+
                "LEFT JOIN machine11process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"' ";
        ArrayList<Machine11CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine11fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine11CSVData mData = new Machine11CSVData();
                    mData.setMachine_name("OP1070 - FUNCTIONAL TEST RIG");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setFunctional_test_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setFunctional_test_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setFunctional_test_status("NA");
                    }
                    mData.setMin_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setSfl_serial_number(data[10] != null ? (String) data[10] : "NA");
                    if(data[11] != null) {
                        String reason = failReason.get((Integer) data[11]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[11] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[12] != null ? (String) data[12] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine11CSVData> getMachine11FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine11production p "+
                "LEFT JOIN machine11process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine11CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine11fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine11CSVData mData = new Machine11CSVData();
                    mData.setMachine_name("OP1070 - FUNCTIONAL TEST RIGOP1070 - FUNCTIONAL TEST RIG");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setFunctional_test_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setFunctional_test_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setFunctional_test_status("NA");
                    }
                    mData.setMin_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setSfl_serial_number(data[10] != null ? (String) data[10] : "NA");
                    if(data[11] != null) {
                        String reason = failReason.get((Integer) data[11]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[11] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[12] != null ? (String) data[12] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine11CSVData> getMachine11DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM machine11production p "+
                "LEFT JOIN machine11process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine11CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine11fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine11CSVData mData = new Machine11CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1070 - FUNCTIONAL TEST RIG");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setFunctional_test_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setFunctional_test_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setFunctional_test_status("NA");
            }
            mData.setMin_load_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_load_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_load_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setSfl_serial_number(dataBasedOnProductId.get(0)[10] != null ? (String) dataBasedOnProductId.get(0)[10] : "NA");
            if(dataBasedOnProductId.get(0)[11] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[11]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[11] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[12] != null ? (String) dataBasedOnProductId.get(0)[12] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine19(70A)
    public Machine19 getUpdatedMachine19Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine19 mData = new Machine19();
        String mQuery = getLineQuery("Machine19production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_12_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");
        mData.setSflPartId(machineCurrentData[9] != null ? (String) machineCurrentData[9] : "NA");

        entityManager.close();
        return mData;
    }

         public ArrayList<Machine19CSVData> getMachine19Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM Machine19production p "+
                "LEFT JOIN Machine19process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date = '"+dateInString+"' ";
        ArrayList<Machine19CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("Machine19fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine19CSVData mData = new Machine19CSVData();
                    mData.setMachine_name("OP1070A - FUNCTIONAL TEST RIG A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setFunctional_test_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setFunctional_test_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setFunctional_test_status("NA");
                    }
                    mData.setMin_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setSfl_serial_number(data[10] != null ? (String) data[10] : "NA");
                    if(data[11] != null) {
                        String reason = failReason.get((Integer) data[11]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[11] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[12] != null ? (String) data[12] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine19CSVData> getMachine19FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM Machine19production p "+
                "LEFT JOIN Machine19process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine19CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("Machine19fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine19CSVData mData = new Machine19CSVData();
                    mData.setMachine_name("OP1070A - FUNCTIONAL TEST RIGOP1070A - FUNCTIONAL TEST RIG A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setFunctional_test_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setFunctional_test_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setFunctional_test_status("NA");
                    }
                    mData.setMin_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setSfl_serial_number(data[10] != null ? (String) data[10] : "NA");
                    if(data[11] != null) {
                        String reason = failReason.get((Integer) data[11]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[11] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[12] != null ? (String) data[12] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine19CSVData> getMachine19DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p0.pass_fail as process1status, "+
                "p0.parameter1 as process1param1, p0.parameter2 as process1param2, p0.parameter3 as process1param3, "+
                "p.sfl_part_id as sflid, p.fail_reason as failreason, p.cycle_time as cycletime FROM Machine19production p "+
                "LEFT JOIN Machine19process1 p0 ON p.product_id = p0.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
       //Integer p2status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine19CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("Machine19fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine19CSVData mData = new Machine19CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1070A - FUNCTIONAL TEST RIG A");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setFunctional_test_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setFunctional_test_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setFunctional_test_status("NA");
            }
            mData.setMin_load_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_load_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_load_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setSfl_serial_number(dataBasedOnProductId.get(0)[10] != null ? (String) dataBasedOnProductId.get(0)[10] : "NA");
            if(dataBasedOnProductId.get(0)[11] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[11]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[11] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[12] != null ? (String) dataBasedOnProductId.get(0)[12] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //Machine14
    public Machine14 getUpdatedMachine14Data() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Machine14 mData = new Machine14();
        String mQuery = getIndividualMachineQuery("machine14production");
        String prodId = "";
        Integer prodStatus = null;
        Object[] mInitData = (Object[]) entityManager.createNativeQuery(MACHINE_14_QUERY).getSingleResult();
        String mflagid = mInitData[0] != null ? (String) mInitData[0] : "";
        Object[] machineCurrentData = (Object[]) entityManager.createNativeQuery(mQuery).getSingleResult();
        mData.setProductId(machineCurrentData[0] != null ? (String) machineCurrentData[0] : "");
        prodId = mData.getProductId();

        mData.setShift(machineCurrentData[1] != null ? (Integer) machineCurrentData[1] : 4);
        prodStatus = Integer.valueOf(machineCurrentData[2] != null ? (Integer) machineCurrentData[2] : 4);
        mData.setStatus(!prodId.isEmpty() && prodId.equals(mflagid) &&  prodStatus.intValue() != 4 ? prodStatus.intValue() : prodStatus.intValue() != 4 && prodStatus.intValue() == 0 ? 0 : 3);

        mData.setTotalProductionCount(machineCurrentData[3] != null ? (Integer) machineCurrentData[3] : 0);
        mData.setOkParts(machineCurrentData[4] != null ? (Integer) machineCurrentData[4] : 0);
        mData.setNotOkParts(machineCurrentData[5] != null ? (Integer) machineCurrentData[5] : 0);
        mData.setStartTime(machineCurrentData[6] != null ? (String) machineCurrentData[6] : "NA");
        mData.setEndTime(machineCurrentData[7] != null ? (String) machineCurrentData[7] : "NA");
        mData.setCycleTime(machineCurrentData[8] != null ? (String) machineCurrentData[8] : "NA");
        entityManager.close();
        return mData;
    }

    public ArrayList<Machine14CSVData> getMachine14Data() {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine14production p "+
                "LEFT JOIN machine14process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'";
        ArrayList<Machine14CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine14fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine14CSVData mData = new Machine14CSVData();
                    mData.setMachine_name("OP1060A - PIN PRESS ASSEMBLY MACHINE A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPin_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPin_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPin_press_status("NA");
                    }
                    mData.setMin_pin_press_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_pin_press_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_pin_press_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_pin_displacement_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_pin_displacement_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_pin_displacement_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        String reason = failReason.get((Integer) data[13]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[13] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[14] != null ? (String) data[14] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine14CSVData> getMachine14FilteredData(String fromDate, String toDate) {
        String currentShift = "";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String machineCSVQuery = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine14production p "+
                "LEFT JOIN machine14process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'";
        ArrayList<Machine14CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine14fail_reason");

        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(machineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Machine14CSVData mData = new Machine14CSVData();
                    mData.setMachine_name("OP1060A - PIN PRESS ASSEMBLY MACHINE A");
                    mData.setComponent_barcode(data[0] != null ? (String) data[0] : "NA");
                    sb = new StringBuilder(data[1] != null ? (String) data[1] : "NA");
                    mData.setDate(data[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    if(data[2] != null) {
                        mShift = Integer.valueOf((Integer) data[2]);
                        if(mShift.intValue() == 1) {
                            currentShift = "A";
                        }
                        if(mShift.intValue() == 2) {
                            currentShift = "B";
                        }
                        if(mShift.intValue() == 3) {
                            currentShift = "C";
                        }
                        if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                            currentShift = "NA";
                        }
                    }
                    mData.setShift(data[2] != null ? currentShift : "NA");
                    mData.setTime(data[3] != null ? (String) data[3] : "NA");
                    mData.setOperator_name(data[4] != null ? (String) data[4] : "NA");
                    if(data[5] != null) {
                        prodStatus = Integer.valueOf((Integer) data[5]);
                        if(prodStatus.intValue() == 1) {
                            mData.setProduction_status("OK");
                        }
                        if(prodStatus.intValue() != 1) {
                            mData.setProduction_status("NOT OK");
                        }
                    }
                    if(data[5] == null) {
                        mData.setProduction_status("NA");
                    }
                    if(data[6] != null) {
                        p1status = Integer.valueOf((Integer) data[6]);
                        if(p1status.intValue() == 1) {
                            mData.setPin_press_status("OK");
                        }
                        if(p1status.intValue() != 1) {
                            mData.setPin_press_status("NOT OK");
                        }
                    }
                    if(data[6] == null) {
                        mData.setPin_press_status("NA");
                    }
                    mData.setMin_pin_press_load_value(data[7] != null ? (Double) data[7] : 0);
                    mData.setMax_pin_press_load_value(data[8] != null ? (Double) data[8] : 0);
                    mData.setActual_pin_press_load_value(data[9] != null ? (Double) data[9] : 0);
                    mData.setMin_pin_displacement_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setMax_pin_displacement_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setActual_pin_displacement_value(data[12] != null ? (Double) data[12] : 0);
                    if(data[13] != null) {
                        String reason = failReason.get((Integer) data[13]);
                        mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
                    }
                    if(data[13] == null) {
                        mData.setFail_reason("NA");
                    }
                    mData.setCycleTime(data[14] != null ? (String) data[14] : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Machine14CSVData> getMachine14DataUsingProductId(String productId) {
        String currentShift = "";
        String query = "SELECT p.product_id as barcode, p.log_date as mlogdate, p.shift as mshift, p.end_time as mtime, "+
                "p.operator_name as moperator, p.pass_fail as productionstatus, p1.pass_fail as process1status, "+
                "p1.parameter1 as process1param1, p1.parameter2 as process1param2, p1.parameter3 as process1param3, "+
                "p1.parameter4 as process1param4, p1.parameter5 as process1param5, p1.parameter6 as process1param6, "+
                "p.fail_reason as failreason, p.cycle_time as cycletime FROM machine14production p "+
                "LEFT JOIN machine14process1 p1 ON p.product_id = p1.product_id "+
                "WHERE p.product_id = '" + productId +"'";
        Integer prodStatus = null;
        Integer p1status = null;
        StringBuilder sb = null;
        Integer mShift = null;
        ArrayList<Machine14CSVData> machineCSVDataList = new ArrayList<>();
        HashMap<Integer, String> failReason = getFailReasonData("machine14fail_reason");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> dataBasedOnProductId = entityManager.createNativeQuery(query).getResultList();
        Machine14CSVData mData = new Machine14CSVData();
        if(dataBasedOnProductId != null) {
            mData.setMachine_name("OP1060A - PIN PRESS ASSEMBLY MACHINE A");
            mData.setComponent_barcode(dataBasedOnProductId.get(0)[0] != null ? (String) dataBasedOnProductId.get(0)[0] : "NA");
            sb = new StringBuilder(dataBasedOnProductId.get(0)[1] != null ? (String) dataBasedOnProductId.get(0)[1] : "NA");
            mData.setDate(dataBasedOnProductId.get(0)[1] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
            if(dataBasedOnProductId.get(0)[2] != null) {
                mShift = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[2]);
                if(mShift.intValue() == 1) {
                    currentShift = "A";
                }
                if(mShift.intValue() == 2) {
                    currentShift = "B";
                }
                if(mShift.intValue() == 3) {
                    currentShift = "C";
                }
                if(mShift.intValue() != 1 && mShift.intValue() != 2 && mShift.intValue() != 3) {
                    currentShift = "NA";
                }
            }
            mData.setShift(dataBasedOnProductId.get(0)[2] != null ? currentShift : "NA");
            mData.setTime(dataBasedOnProductId.get(0)[3] != null ? (String) dataBasedOnProductId.get(0)[3] : "NA");
            mData.setOperator_name(dataBasedOnProductId.get(0)[4] != null ? (String) dataBasedOnProductId.get(0)[4] : "NA");
            if(dataBasedOnProductId.get(0)[5] != null) {
                prodStatus = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[5]);
                if(prodStatus.intValue() == 1) {
                    mData.setProduction_status("OK");
                }
                if(prodStatus.intValue() != 1) {
                    mData.setProduction_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[5] == null) {
                mData.setProduction_status("NA");
            }
            if(dataBasedOnProductId.get(0)[6] != null) {
                p1status = Integer.valueOf((Integer) dataBasedOnProductId.get(0)[6]);
                if(p1status.intValue() == 1) {
                    mData.setPin_press_status("OK");
                }
                if(p1status.intValue() != 1) {
                    mData.setPin_press_status("NOT OK");
                }
            }
            if(dataBasedOnProductId.get(0)[6] == null) {
                mData.setPin_press_status("NA");
            }
            mData.setMin_pin_press_load_value(dataBasedOnProductId.get(0)[7] != null ? (Double) dataBasedOnProductId.get(0)[7] : 0);
            mData.setMax_pin_press_load_value(dataBasedOnProductId.get(0)[8] != null ? (Double) dataBasedOnProductId.get(0)[8] : 0);
            mData.setActual_pin_press_load_value(dataBasedOnProductId.get(0)[9] != null ? (Double) dataBasedOnProductId.get(0)[9] : 0);
            mData.setMin_pin_displacement_value(dataBasedOnProductId.get(0)[10] != null ? (Double) dataBasedOnProductId.get(0)[10] : 0);
            mData.setMax_pin_displacement_value(dataBasedOnProductId.get(0)[11] != null ? (Double) dataBasedOnProductId.get(0)[11] : 0);
            mData.setActual_pin_displacement_value(dataBasedOnProductId.get(0)[12] != null ? (Double) dataBasedOnProductId.get(0)[12] : 0);
            if(dataBasedOnProductId.get(0)[13] != null) {
                String reason = failReason.get((Integer) dataBasedOnProductId.get(0)[13]);
                mData.setFail_reason(reason != null && !reason.isEmpty() ? reason : "NA");
            }
            if(dataBasedOnProductId.get(0)[13] == null) {
                mData.setFail_reason("NA");
            }
            mData.setCycleTime(dataBasedOnProductId.get(0)[14] != null ? (String) dataBasedOnProductId.get(0)[14] : "NA");

            machineCSVDataList.add(mData);
        }
        entityManager.close();
        return machineCSVDataList;
    }


    //Line1Production
    public Integer getTotalProductionCount() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());

        Object[] currentShiftFromTable = (Object[]) entityManager.createNativeQuery(CURRENT_SHIFT_QUERY).getSingleResult();
        String OKpartsQuery = okPartsQuery(dateInString, (Integer) currentShiftFromTable[1]);

        List<Object[]> totalOKParts = entityManager.createNativeQuery(OKpartsQuery).getResultList();
        Integer totalProduction = Integer.valueOf(totalOKParts.size());

        entityManager.close();
        return totalProduction;
    }

    public Machine19 getDailyReport() {
        Machine19 dailyReport = new Machine19();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());

        Object[] currentShiftFromTable = (Object[]) entityManager.createNativeQuery(CURRENT_SHIFT_QUERY).getSingleResult();
        String OKpartsQuery = okPartsQuery(dateInString, (Integer) currentShiftFromTable[1]);

        List<Object[]> totalOKParts = entityManager.createNativeQuery(OKpartsQuery).getResultList();

        String NotOKPartsQuery = notOkPartsQuery(dateInString, (Integer) currentShiftFromTable[1]);
        List<Object[]> totalNotOKParts = entityManager.createNativeQuery(NotOKPartsQuery).getResultList();

        dailyReport.setCurrentShift((Integer) currentShiftFromTable[1]);
        dailyReport.setOkParts(totalOKParts.size());
        dailyReport.setNotOkParts(totalNotOKParts.size());
        dailyReport.setTotalProduction(Integer.sum(totalOKParts.size(), totalNotOKParts.size()));

        entityManager.close();
        return dailyReport;
    }

    public ArrayList<Line1CSVData> getLine1ProductionData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String pattern = "yyyy-MM-dd";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        String lineCSVQuery ="("+ 
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+ 
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'"+
                ") "+
            "UNION ALL "+
                "( "+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.filter_date = '"+dateInString+"'"+
                ")";
        ArrayList<Line1CSVData> machineCSVDataList = new ArrayList<>();

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(lineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Line1CSVData mData = new Line1CSVData();
                    mData.setMachine_name("Exhaust Lever Assembly Line");
                    sb = new StringBuilder(data[0] != null ? (String) data[0] : "NA");
                    mData.setDate(data[0] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    mData.setTime(data[1] != null ? (String) data[1] : "NA");
                    mShift = Integer.valueOf(data[2] != null ? (Integer) data[2] : 4);
                    mData.setShift(mShift.intValue() == 1 ? "A" : mShift.intValue() == 2 ? "B" : mShift.intValue() == 3 ? "C" : "NA");
                    mData.setSfl_serial_number(data[3] != null ? (String) data[3] : "NA");
                    mData.setComponent_barcode(data[4] != null ? (String) data[4] : "NA");
                    prodStatus = Integer.valueOf(data[5] != null ? (Integer) data[5] : 2);
                    mData.setProduction_status(prodStatus.intValue() == 1 ? "OK" : prodStatus.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine1
                    p1status = Integer.valueOf(data[6] != null ? (Integer) data[6] : 2);
                    mData.setOp1010_ocv_hole_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[7] != null ? (Integer) data[7] : 2);
                    mData.setOp1010_bap_hole_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[8] != null ? (Integer) data[8] : 2);
                    mData.setOp1010_pipe_plug_hole_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[9] != null ? (Integer) data[9] : 2);
                    mData.setOp1010_thread_plug_hole_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine2
                    mData.setOp1020a_min_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setOp1020a_max_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setOp1020a_actual_id_a_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setOp1020a_actual_id_b_gauge_value(data[13] != null ? (Double) data[13] : 0);
                    p1status = Integer.valueOf(data[14] != null ? (Integer) data[14] : 2);
                    mData.setOp1020a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1020a_min_load_value(data[15] != null ? (Double) data[15] : 0);
                    mData.setOp1020a_max_load_value(data[16] != null ? (Double) data[16] : 0);
                    mData.setOp1020a_actual_load_value(data[17] != null ? (Double) data[17] : 0);
                    p2status = Integer.valueOf(data[18] != null ? (Integer) data[18] : 2);
                    mData.setOp1020a_ball_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine3
                    p1status = Integer.valueOf(data[19] != null ? (Integer) data[19] : 2);
                    mData.setOp1020b_socket_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine4
                    p1status = Integer.valueOf(data[20] != null ? (Integer) data[20] : 2);
                    mData.setOp1030_pre_screwing_and_screwing_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[21] != null ? (Integer) data[21] : 2);
                    mData.setOp1030_nut_tightening_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine5
                    mData.setOp1040a_target_torque(data[22] != null ? (Double) data[22] : 0);
                    mData.setOp1040a_actual_torque(data[23] != null ? (Double) data[23] : 0);
                    p1status = Integer.valueOf(data[24] != null ? (Integer) data[24] : 2);
                    mData.setOp1040a_pipe_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine6
                    mData.setOp1040b_min_id_gauge_bore_dia(data[25] != null ? (Double) data[25] : 0);
                    mData.setOp1040b_max_id_gauge_bore_dia(data[26] != null ? (Double) data[26] : 0);
                    mData.setOp1040b_actual_id_gauge_bore_dia(data[27] != null ? (Double) data[27] : 0);
                    p1status = Integer.valueOf(data[28] != null ? (Integer) data[28] : 2);
                    mData.setOp1040b_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1040b_min_load_insert_valve_press_value(data[29] != null ? (Double) data[29] : 0);
                    mData.setOp1040b_max_load_insert_valve_press_value(data[30] != null ? (Double) data[30] : 0);
                    mData.setOp1040b_actual_load_insert_valve_press_value(data[31] != null ? (Double) data[31] : 0);
                    mData.setOp1040b_min_displacement_insert_valve_value(data[32] != null ? (Double) data[32] : 0);
                    mData.setOp1040b_max_displacement_insert_valve_value(data[33] != null ? (Double) data[33] : 0);
                    mData.setOp1040b_actual_displacement_insert_valve_value(data[34] != null ? (Double) data[34] : 0);
                    p2status = Integer.valueOf(data[35] != null ? (Integer) data[35] : 2);
                    mData.setOp1040b_insert_valve_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine7
                    mData.setOp1040c_min_ball_over_height_value(data[36] != null ? (Double) data[36] : 0);
                    mData.setOp1040c_max_ball_over_height_value(data[37] != null ? (Double) data[37] : 0);
                    mData.setOp1040c_actual_ball_over_height_value(data[38] != null ? (Double) data[38] : 0);
                    p1status = Integer.valueOf(data[39] != null ? (Integer) data[39] : 2);
                    mData.setOp1040c_ball_over_height_check_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine8
                    mData.setOp1040d_minimum_torque(data[40] != null ? (Double) data[40] : 0);
                    mData.setOp1040d_maximum_torque(data[41] != null ? (Double) data[41] : 0);
                    mData.setOp1040d_actual_torque(data[42] != null ? (Double) data[42] : 0);
                    mData.setOp1040d_actual_angle(data[43] != null ? (Double) data[43] : 0);

                    p1status = Integer.valueOf(data[44] != null ? (Integer) data[44] : 2);
                    mData.setOp1040d_ball_spring_oring_thread_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine9
                    mData.setOp1050_min_ocv_id_gauge_value(data[45] != null ? (Double) data[45] : 0);
                    mData.setOp1050_max_ocv_id_gauge_value(data[46] != null ? (Double) data[46] : 0);
                    mData.setOp1050_actual_ocv_id_gauge_value(data[47] != null ? (Double) data[47] : 0);
                    mData.setOp1050_min_bap_id_gauge_value(data[48] != null ? (Double) data[48] : 0);
                    mData.setOp1050_max_bap_id_gauge_value(data[49] != null ? (Double) data[49] : 0);
                    mData.setOp1050_actual_bap_id_gauge_value(data[50] != null ? (Double) data[50] : 0);
                    p1status = Integer.valueOf(data[51] != null ? (Integer) data[51] : 2);
                    mData.setOp1050_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[52] != null ? (Integer) data[52] : 2);
                    mData.setOp1050_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[53] != null ? (Integer) data[53] : 2);
                    mData.setOp1050_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[54] != null ? (Integer) data[54] : 2);
                    mData.setOp1050_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[55] != null ? (Integer) data[55] : 2);
                    mData.setOp1050_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                    
                    //Machine10
                    mData.setOp1060_min_pin_press_load_value(data[56] != null ? (Double) data[56] : 0);
                    mData.setOp1060_max_pin_press_load_value(data[57] != null ? (Double) data[57] : 0);
                    mData.setOp1060_actual_pin_press_load_value(data[58] != null ? (Double) data[58] : 0);
                    mData.setOp1060_min_pin_displacement_value(data[59] != null ? (Double) data[59] : 0);
                    mData.setOp1060_max_pin_displacement_value(data[60] != null ? (Double) data[60] : 0);
                    mData.setOp1060_actual_pin_displacement_value(data[61] != null ? (Double) data[61] : 0);
                    p1status = Integer.valueOf(data[62] != null ? (Integer) data[62] : 2);
                    mData.setOp1060_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine11
                    p1status = Integer.valueOf(data[63] != null ? (Integer) data[63] : 2);
                    mData.setOp1070_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070_min_load_value(data[64] != null ? (Double) data[64] : 0);
                    mData.setOp1070_max_load_value(data[65] != null ? (Double) data[65] : 0);
                    mData.setOp1070_actual_load_value(data[66] != null ? (Double) data[66] : 0);

                     //Machine19
                    p1status = Integer.valueOf(data[67] != null ? (Integer) data[67] : 2);
                    mData.setOp1070a_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070a_min_load_value(data[68] != null ? (Double) data[68] : 0);
                    mData.setOp1070a_max_load_value(data[69] != null ? (Double) data[69] : 0);
                    mData.setOp1070a_actual_load_value(data[70] != null ? (Double) data[70] : 0);

                    //Machine13 (50A)
                    mData.setOp1050a_min_ocv_id_gauge_value(data[71] != null ? (Double) data[71] : 0);
                    mData.setOp1050a_max_ocv_id_gauge_value(data[72] != null ? (Double) data[72] : 0);
                    mData.setOp1050a_actual_ocv_id_gauge_value(data[73] != null ? (Double) data[73] : 0);
                    mData.setOp1050a_min_bap_id_gauge_value(data[74] != null ? (Double) data[74] : 0);
                    mData.setOp1050a_max_bap_id_gauge_value(data[75] != null ? (Double) data[75] : 0);
                    mData.setOp1050a_actual_bap_id_gauge_value(data[76] != null ? (Double) data[76] : 0);
                    p1status = Integer.valueOf(data[77] != null ? (Integer) data[77] : 2);
                    mData.setOp1050a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[78] != null ? (Integer) data[78] : 2);
                    mData.setOp1050a_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[79] != null ? (Integer) data[79] : 2);
                    mData.setOp1050a_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[80] != null ? (Integer) data[80] : 2);
                    mData.setOp1050a_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[81] != null ? (Integer) data[81] : 2);
                    mData.setOp1050a_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                     //Machine14 (60A)
                    mData.setOp1060a_min_pin_press_load_value(data[82] != null ? (Double) data[82] : 0);
                    mData.setOp1060a_max_pin_press_load_value(data[83] != null ? (Double) data[83] : 0);
                    mData.setOp1060a_actual_pin_press_load_value(data[84] != null ? (Double) data[84] : 0);
                    mData.setOp1060a_min_pin_displacement_value(data[85] != null ? (Double) data[85] : 0);
                    mData.setOp1060a_max_pin_displacement_value(data[86] != null ? (Double) data[86] : 0);
                    mData.setOp1060a_actual_pin_displacement_value(data[87] != null ? (Double) data[87] : 0);
                    p1status = Integer.valueOf(data[88] != null ? (Integer) data[88] : 2);
                    mData.setOp1060a_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Line1CSVData> getLine1ProductionFilteredData(String fromDate, String toDate) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String lineCSVQuery = "("+ 
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+ 
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'"+
                 ") "+
            "UNION ALL "+
                "( "+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+ 
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'"+
                 ") ";
        ArrayList<Line1CSVData> machineCSVDataList = new ArrayList<>();

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(lineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Line1CSVData mData = new Line1CSVData();
                    mData.setMachine_name("Exhaust Lever Assembly Line");
                    sb = new StringBuilder(data[0] != null ? (String) data[0] : "NA");
                    mData.setDate(data[0] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    mData.setTime(data[1] != null ? (String) data[1] : "NA");
                    mShift = Integer.valueOf(data[2] != null ? (Integer) data[2] : 4);
                    mData.setShift(mShift.intValue() == 1 ? "A" : mShift.intValue() == 2 ? "B" : mShift.intValue() == 3 ? "C" : "NA");
                    mData.setSfl_serial_number(data[3] != null ? (String) data[3] : "NA");
                    mData.setComponent_barcode(data[4] != null ? (String) data[4] : "NA");
                    prodStatus = Integer.valueOf(data[5] != null ? (Integer) data[5] : 2);
                    mData.setProduction_status(prodStatus.intValue() == 1 ? "OK" : prodStatus.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine1
                    p1status = Integer.valueOf(data[6] != null ? (Integer) data[6] : 2);
                    mData.setOp1010_ocv_hole_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[7] != null ? (Integer) data[7] : 2);
                    mData.setOp1010_bap_hole_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[8] != null ? (Integer) data[8] : 2);
                    mData.setOp1010_pipe_plug_hole_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[9] != null ? (Integer) data[9] : 2);
                    mData.setOp1010_thread_plug_hole_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine2
                    mData.setOp1020a_min_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setOp1020a_max_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setOp1020a_actual_id_a_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setOp1020a_actual_id_b_gauge_value(data[13] != null ? (Double) data[13] : 0);
                    p1status = Integer.valueOf(data[14] != null ? (Integer) data[14] : 2);
                    mData.setOp1020a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1020a_min_load_value(data[15] != null ? (Double) data[15] : 0);
                    mData.setOp1020a_max_load_value(data[16] != null ? (Double) data[16] : 0);
                    mData.setOp1020a_actual_load_value(data[17] != null ? (Double) data[17] : 0);
                    p2status = Integer.valueOf(data[18] != null ? (Integer) data[18] : 2);
                    mData.setOp1020a_ball_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine3
                    p1status = Integer.valueOf(data[19] != null ? (Integer) data[19] : 2);
                    mData.setOp1020b_socket_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine4
                    p1status = Integer.valueOf(data[20] != null ? (Integer) data[20] : 2);
                    mData.setOp1030_pre_screwing_and_screwing_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[21] != null ? (Integer) data[21] : 2);
                    mData.setOp1030_nut_tightening_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine5
                    mData.setOp1040a_target_torque(data[22] != null ? (Double) data[22] : 0);
                    mData.setOp1040a_actual_torque(data[23] != null ? (Double) data[23] : 0);
                    p1status = Integer.valueOf(data[24] != null ? (Integer) data[24] : 2);
                    mData.setOp1040a_pipe_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine6
                    mData.setOp1040b_min_id_gauge_bore_dia(data[25] != null ? (Double) data[25] : 0);
                    mData.setOp1040b_max_id_gauge_bore_dia(data[26] != null ? (Double) data[26] : 0);
                    mData.setOp1040b_actual_id_gauge_bore_dia(data[27] != null ? (Double) data[27] : 0);
                    p1status = Integer.valueOf(data[28] != null ? (Integer) data[28] : 2);
                    mData.setOp1040b_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1040b_min_load_insert_valve_press_value(data[29] != null ? (Double) data[29] : 0);
                    mData.setOp1040b_max_load_insert_valve_press_value(data[30] != null ? (Double) data[30] : 0);
                    mData.setOp1040b_actual_load_insert_valve_press_value(data[31] != null ? (Double) data[31] : 0);
                    mData.setOp1040b_min_displacement_insert_valve_value(data[32] != null ? (Double) data[32] : 0);
                    mData.setOp1040b_max_displacement_insert_valve_value(data[33] != null ? (Double) data[33] : 0);
                    mData.setOp1040b_actual_displacement_insert_valve_value(data[34] != null ? (Double) data[34] : 0);
                    p2status = Integer.valueOf(data[35] != null ? (Integer) data[35] : 2);
                    mData.setOp1040b_insert_valve_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine7
                    mData.setOp1040c_min_ball_over_height_value(data[36] != null ? (Double) data[36] : 0);
                    mData.setOp1040c_max_ball_over_height_value(data[37] != null ? (Double) data[37] : 0);
                    mData.setOp1040c_actual_ball_over_height_value(data[38] != null ? (Double) data[38] : 0);
                    p1status = Integer.valueOf(data[39] != null ? (Integer) data[39] : 2);
                    mData.setOp1040c_ball_over_height_check_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine8
                    mData.setOp1040d_minimum_torque(data[40] != null ? (Double) data[40] : 0);
                    mData.setOp1040d_maximum_torque(data[41] != null ? (Double) data[41] : 0);
                    mData.setOp1040d_actual_torque(data[42] != null ? (Double) data[42] : 0);
                    mData.setOp1040d_actual_angle(data[43] != null ? (Double) data[43] : 0);
                    p1status = Integer.valueOf(data[44] != null ? (Integer) data[44] : 2);
                    mData.setOp1040d_ball_spring_oring_thread_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine9
                    mData.setOp1050_min_ocv_id_gauge_value(data[45] != null ? (Double) data[45] : 0);
                    mData.setOp1050_max_ocv_id_gauge_value(data[46] != null ? (Double) data[46] : 0);
                    mData.setOp1050_actual_ocv_id_gauge_value(data[47] != null ? (Double) data[47] : 0);
                    mData.setOp1050_min_bap_id_gauge_value(data[48] != null ? (Double) data[48] : 0);
                    mData.setOp1050_max_bap_id_gauge_value(data[49] != null ? (Double) data[49] : 0);
                    mData.setOp1050_actual_bap_id_gauge_value(data[50] != null ? (Double) data[50] : 0);
                    p1status = Integer.valueOf(data[51] != null ? (Integer) data[51] : 2);
                    mData.setOp1050_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[52] != null ? (Integer) data[52] : 2);
                    mData.setOp1050_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[53] != null ? (Integer) data[53] : 2);
                    mData.setOp1050_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[54] != null ? (Integer) data[54] : 2);
                    mData.setOp1050_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[55] != null ? (Integer) data[55] : 2);
                    mData.setOp1050_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine10
                    mData.setOp1060_min_pin_press_load_value(data[56] != null ? (Double) data[56] : 0);
                    mData.setOp1060_max_pin_press_load_value(data[57] != null ? (Double) data[57] : 0);
                    mData.setOp1060_actual_pin_press_load_value(data[58] != null ? (Double) data[58] : 0);
                    mData.setOp1060_min_pin_displacement_value(data[59] != null ? (Double) data[59] : 0);
                    mData.setOp1060_max_pin_displacement_value(data[60] != null ? (Double) data[60] : 0);
                    mData.setOp1060_actual_pin_displacement_value(data[61] != null ? (Double) data[61] : 0);
                    p1status = Integer.valueOf(data[62] != null ? (Integer) data[62] : 2);
                    mData.setOp1060_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine11
                    p1status = Integer.valueOf(data[63] != null ? (Integer) data[63] : 2);
                    mData.setOp1070_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070_min_load_value(data[64] != null ? (Double) data[64] : 0);
                    mData.setOp1070_max_load_value(data[65] != null ? (Double) data[65] : 0);
                    mData.setOp1070_actual_load_value(data[66] != null ? (Double) data[66] : 0);

                     //Machine19
                    p1status = Integer.valueOf(data[67] != null ? (Integer) data[67] : 2);
                    mData.setOp1070a_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070a_min_load_value(data[68] != null ? (Double) data[68] : 0);
                    mData.setOp1070a_max_load_value(data[69] != null ? (Double) data[69] : 0);
                    mData.setOp1070a_actual_load_value(data[70] != null ? (Double) data[70] : 0);

                    //Machine13
                    mData.setOp1050a_min_ocv_id_gauge_value(data[71] != null ? (Double) data[71] : 0);
                    mData.setOp1050a_max_ocv_id_gauge_value(data[72] != null ? (Double) data[72] : 0);
                    mData.setOp1050a_actual_ocv_id_gauge_value(data[73] != null ? (Double) data[73] : 0);
                    mData.setOp1050a_min_bap_id_gauge_value(data[74] != null ? (Double) data[74] : 0);
                    mData.setOp1050a_max_bap_id_gauge_value(data[75] != null ? (Double) data[75] : 0);
                    mData.setOp1050a_actual_bap_id_gauge_value(data[76] != null ? (Double) data[76] : 0);
                    p1status = Integer.valueOf(data[77] != null ? (Integer) data[77] : 2);
                    mData.setOp1050a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[78] != null ? (Integer) data[78] : 2);
                    mData.setOp1050a_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[79] != null ? (Integer) data[79] : 2);
                    mData.setOp1050a_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[80] != null ? (Integer) data[80] : 2);
                    mData.setOp1050a_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[81] != null ? (Integer) data[81] : 2);
                    mData.setOp1050a_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");


                    //Machine14
                    mData.setOp1060a_min_pin_press_load_value(data[82] != null ? (Double) data[82] : 0);
                    mData.setOp1060a_max_pin_press_load_value(data[83] != null ? (Double) data[83] : 0);
                    mData.setOp1060a_actual_pin_press_load_value(data[84] != null ? (Double) data[84] : 0);
                    mData.setOp1060a_min_pin_displacement_value(data[85] != null ? (Double) data[85] : 0);
                    mData.setOp1060a_max_pin_displacement_value(data[86] != null ? (Double) data[86] : 0);
                    mData.setOp1060a_actual_pin_displacement_value(data[87] != null ? (Double) data[87] : 0);
                    p1status = Integer.valueOf(data[88] != null ? (Integer) data[88] : 2);
                    mData.setOp1060a_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    
                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    public ArrayList<Line1CSVData> getLine1ProductionDataUsingProductId(String sflId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String lineCSVQuery =  "("+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3, "+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.sfl_part_id = '" + sflId +"'"+
                ") "+
            "UNION ALL "+
                "( "+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3 ,"+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.sfl_part_id = '" + sflId +"'"+
                ")";
        ArrayList<Line1CSVData> machineCSVDataList = new ArrayList<>();

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(lineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            if(mCompleteData != null) {
                Line1CSVData mData = new Line1CSVData();
                mData.setMachine_name("Exhaust Lever Assembly Line");
                sb = new StringBuilder(mCompleteData.get(0)[0] != null ? (String) mCompleteData.get(0)[0] : "NA");
                mData.setDate(mCompleteData.get(0)[0] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                mData.setTime(mCompleteData.get(0)[1] != null ? (String) mCompleteData.get(0)[1] : "NA");
                mShift = Integer.valueOf(mCompleteData.get(0)[2] != null ? (Integer) mCompleteData.get(0)[2] : 4);
                mData.setShift(mShift.intValue() == 1 ? "A" : mShift.intValue() == 2 ? "B" : mShift.intValue() == 3 ? "C" : "NA");
                mData.setSfl_serial_number(mCompleteData.get(0)[3] != null ? (String) mCompleteData.get(0)[3] : "NA");
                mData.setComponent_barcode(mCompleteData.get(0)[4] != null ? (String) mCompleteData.get(0)[4] : "NA");
                prodStatus = Integer.valueOf(mCompleteData.get(0)[5] != null ? (Integer) mCompleteData.get(0)[5] : 2);
                mData.setProduction_status(prodStatus.intValue() == 1 ? "OK" : prodStatus.intValue() == 0 ? "NOT OK" : "NA");

                //Machine1
                p1status = Integer.valueOf(mCompleteData.get(0)[6] != null ? (Integer) mCompleteData.get(0)[6] : 2);
                mData.setOp1010_ocv_hole_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                p2status = Integer.valueOf(mCompleteData.get(0)[7] != null ? (Integer) mCompleteData.get(0)[7] : 2);
                mData.setOp1010_bap_hole_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                p3status = Integer.valueOf(mCompleteData.get(0)[8] != null ? (Integer) mCompleteData.get(0)[8] : 2);
                mData.setOp1010_pipe_plug_hole_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                p4status = Integer.valueOf(mCompleteData.get(0)[9] != null ? (Integer) mCompleteData.get(0)[9] : 2);
                mData.setOp1010_thread_plug_hole_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine2
                mData.setOp1020a_min_id_gauge_value(mCompleteData.get(0)[10] != null ? (Double) mCompleteData.get(0)[10] : 0);
                mData.setOp1020a_max_id_gauge_value(mCompleteData.get(0)[11] != null ? (Double) mCompleteData.get(0)[11] : 0);
                mData.setOp1020a_actual_id_a_gauge_value(mCompleteData.get(0)[12] != null ? (Double) mCompleteData.get(0)[12] : 0);
                mData.setOp1020a_actual_id_b_gauge_value(mCompleteData.get(0)[13] != null ? (Double) mCompleteData.get(0)[13] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[14] != null ? (Integer) mCompleteData.get(0)[14] : 2);
                mData.setOp1020a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                mData.setOp1020a_min_load_value(mCompleteData.get(0)[15] != null ? (Double) mCompleteData.get(0)[15] : 0);
                mData.setOp1020a_max_load_value(mCompleteData.get(0)[16] != null ? (Double) mCompleteData.get(0)[16] : 0);
                mData.setOp1020a_actual_load_value(mCompleteData.get(0)[17] != null ? (Double) mCompleteData.get(0)[17] : 0);
                p2status = Integer.valueOf(mCompleteData.get(0)[18] != null ? (Integer) mCompleteData.get(0)[18] : 2);
                mData.setOp1020a_ball_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine3
                p1status = Integer.valueOf(mCompleteData.get(0)[19] != null ? (Integer) mCompleteData.get(0)[19] : 2);
                mData.setOp1020b_socket_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine4
                p1status = Integer.valueOf(mCompleteData.get(0)[20] != null ? (Integer) mCompleteData.get(0)[20] : 2);
                mData.setOp1030_pre_screwing_and_screwing_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                p2status = Integer.valueOf(mCompleteData.get(0)[21] != null ? (Integer) mCompleteData.get(0)[21] : 2);
                mData.setOp1030_nut_tightening_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine5
                mData.setOp1040a_target_torque(mCompleteData.get(0)[22] != null ? (Double) mCompleteData.get(0)[22] : 0);
                mData.setOp1040a_actual_torque(mCompleteData.get(0)[23] != null ? (Double) mCompleteData.get(0)[23] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[24] != null ? (Integer) mCompleteData.get(0)[24] : 2);
                mData.setOp1040a_pipe_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine6
                mData.setOp1040b_min_id_gauge_bore_dia(mCompleteData.get(0)[25] != null ? (Double) mCompleteData.get(0)[25] : 0);
                mData.setOp1040b_max_id_gauge_bore_dia(mCompleteData.get(0)[26] != null ? (Double) mCompleteData.get(0)[26] : 0);
                mData.setOp1040b_actual_id_gauge_bore_dia(mCompleteData.get(0)[27] != null ? (Double) mCompleteData.get(0)[27] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[28] != null ? (Integer) mCompleteData.get(0)[28] : 2);
                mData.setOp1040b_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                mData.setOp1040b_min_load_insert_valve_press_value(mCompleteData.get(0)[29] != null ? (Double) mCompleteData.get(0)[29] : 0);
                mData.setOp1040b_max_load_insert_valve_press_value(mCompleteData.get(0)[30] != null ? (Double) mCompleteData.get(0)[30] : 0);
                mData.setOp1040b_actual_load_insert_valve_press_value(mCompleteData.get(0)[31] != null ? (Double) mCompleteData.get(0)[31] : 0);
                mData.setOp1040b_min_displacement_insert_valve_value(mCompleteData.get(0)[32] != null ? (Double) mCompleteData.get(0)[32] : 0);
                mData.setOp1040b_max_displacement_insert_valve_value(mCompleteData.get(0)[33] != null ? (Double) mCompleteData.get(0)[33] : 0);
                mData.setOp1040b_actual_displacement_insert_valve_value(mCompleteData.get(0)[34] != null ? (Double) mCompleteData.get(0)[34] : 0);
                p2status = Integer.valueOf(mCompleteData.get(0)[35] != null ? (Integer) mCompleteData.get(0)[35] : 2);
                mData.setOp1040b_insert_valve_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine7
                mData.setOp1040c_min_ball_over_height_value(mCompleteData.get(0)[36] != null ? (Double) mCompleteData.get(0)[36] : 0);
                mData.setOp1040c_max_ball_over_height_value(mCompleteData.get(0)[37] != null ? (Double) mCompleteData.get(0)[37] : 0);
                mData.setOp1040c_actual_ball_over_height_value(mCompleteData.get(0)[38] != null ? (Double) mCompleteData.get(0)[38] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[39] != null ? (Integer) mCompleteData.get(0)[39] : 2);
                mData.setOp1040c_ball_over_height_check_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine8
                mData.setOp1040d_minimum_torque(mCompleteData.get(0)[40] != null ? (Double) mCompleteData.get(0)[40] : 0);
                mData.setOp1040d_maximum_torque(mCompleteData.get(0)[41] != null ? (Double) mCompleteData.get(0)[41] : 0);
                mData.setOp1040d_actual_torque(mCompleteData.get(0)[42] != null ? (Double) mCompleteData.get(0)[42] : 0);
                mData.setOp1040d_actual_angle(mCompleteData.get(0)[43] != null ? (Double) mCompleteData.get(0)[43] : 0);

                p1status = Integer.valueOf(mCompleteData.get(0)[44] != null ? (Integer) mCompleteData.get(0)[44] : 2);
                mData.setOp1040d_ball_spring_oring_thread_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine9
                mData.setOp1050_min_ocv_id_gauge_value(mCompleteData.get(0)[45] != null ? (Double) mCompleteData.get(0)[45] : 0);
                mData.setOp1050_max_ocv_id_gauge_value(mCompleteData.get(0)[46] != null ? (Double) mCompleteData.get(0)[46] : 0);
                mData.setOp1050_actual_ocv_id_gauge_value(mCompleteData.get(0)[47] != null ? (Double) mCompleteData.get(0)[47] : 0);
                mData.setOp1050_min_bap_id_gauge_value(mCompleteData.get(0)[48] != null ? (Double) mCompleteData.get(0)[48] : 0);
                mData.setOp1050_max_bap_id_gauge_value(mCompleteData.get(0)[49] != null ? (Double) mCompleteData.get(0)[49] : 0);
                mData.setOp1050_actual_bap_id_gauge_value(mCompleteData.get(0)[50] != null ? (Double) mCompleteData.get(0)[50] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[51] != null ? (Integer) mCompleteData.get(0)[51] : 2);
                mData.setOp1050_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                p2status = Integer.valueOf(mCompleteData.get(0)[52] != null ? (Integer) mCompleteData.get(0)[52] : 2);
                mData.setOp1050_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                p3status = Integer.valueOf(mCompleteData.get(0)[53] != null ? (Integer) mCompleteData.get(0)[53] : 2);
                mData.setOp1050_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                p4status = Integer.valueOf(mCompleteData.get(0)[54] != null ? (Integer) mCompleteData.get(0)[54] : 2);
                mData.setOp1050_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                p5status = Integer.valueOf(mCompleteData.get(0)[55] != null ? (Integer) mCompleteData.get(0)[55] : 2);
                mData.setOp1050_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine10
                mData.setOp1060_min_pin_press_load_value(mCompleteData.get(0)[56] != null ? (Double) mCompleteData.get(0)[56] : 0);
                mData.setOp1060_max_pin_press_load_value(mCompleteData.get(0)[57] != null ? (Double) mCompleteData.get(0)[57] : 0);
                mData.setOp1060_actual_pin_press_load_value(mCompleteData.get(0)[58] != null ? (Double) mCompleteData.get(0)[58] : 0);
                mData.setOp1060_min_pin_displacement_value(mCompleteData.get(0)[59] != null ? (Double) mCompleteData.get(0)[59] : 0);
                mData.setOp1060_max_pin_displacement_value(mCompleteData.get(0)[60] != null ? (Double) mCompleteData.get(0)[60] : 0);
                mData.setOp1060_actual_pin_displacement_value(mCompleteData.get(0)[61] != null ? (Double) mCompleteData.get(0)[61] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[62] != null ? (Integer) mCompleteData.get(0)[62] : 2);
                mData.setOp1060_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine11
                p1status = Integer.valueOf(mCompleteData.get(0)[63] != null ? (Integer) mCompleteData.get(0)[63] : 2);
                mData.setOp1070_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                mData.setOp1070_min_load_value(mCompleteData.get(0)[64] != null ? (Double) mCompleteData.get(0)[64] : 0);
                mData.setOp1070_max_load_value(mCompleteData.get(0)[65] != null ? (Double) mCompleteData.get(0)[65] : 0);
                mData.setOp1070_actual_load_value(mCompleteData.get(0)[66] != null ? (Double) mCompleteData.get(0)[66] : 0);

                //Machine19
                p1status = Integer.valueOf(mCompleteData.get(0)[67] != null ? (Integer) mCompleteData.get(0)[67] : 2);
                mData.setOp1070a_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                mData.setOp1070a_min_load_value(mCompleteData.get(0)[68] != null ? (Double) mCompleteData.get(0)[68] : 0);
                mData.setOp1070a_max_load_value(mCompleteData.get(0)[69] != null ? (Double) mCompleteData.get(0)[69] : 0);
                mData.setOp1070a_actual_load_value(mCompleteData.get(0)[70] != null ? (Double) mCompleteData.get(0)[70] : 0);

                //Machine13
                mData.setOp1050a_min_ocv_id_gauge_value(mCompleteData.get(0)[71] != null ? (Double) mCompleteData.get(0)[71] : 0);
                mData.setOp1050a_max_ocv_id_gauge_value(mCompleteData.get(0)[72] != null ? (Double) mCompleteData.get(0)[72] : 0);
                mData.setOp1050a_actual_ocv_id_gauge_value(mCompleteData.get(0)[73] != null ? (Double) mCompleteData.get(0)[73] : 0);
                mData.setOp1050a_min_bap_id_gauge_value(mCompleteData.get(0)[74] != null ? (Double) mCompleteData.get(0)[74] : 0);
                mData.setOp1050a_max_bap_id_gauge_value(mCompleteData.get(0)[75] != null ? (Double) mCompleteData.get(0)[75] : 0);
                mData.setOp1050a_actual_bap_id_gauge_value(mCompleteData.get(0)[76] != null ? (Double) mCompleteData.get(0)[76] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[77] != null ? (Integer) mCompleteData.get(0)[77] : 2);
                mData.setOp1050a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                p2status = Integer.valueOf(mCompleteData.get(0)[78] != null ? (Integer) mCompleteData.get(0)[78] : 2);
                mData.setOp1050a_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                p3status = Integer.valueOf(mCompleteData.get(0)[79] != null ? (Integer) mCompleteData.get(0)[79] : 2);
                mData.setOp1050a_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                p4status = Integer.valueOf(mCompleteData.get(0)[80] != null ? (Integer) mCompleteData.get(0)[80] : 2);
                mData.setOp1050a_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                p5status = Integer.valueOf(mCompleteData.get(0)[81] != null ? (Integer) mCompleteData.get(0)[81] : 2);
                mData.setOp1050a_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                //Machine14
                mData.setOp1060a_min_pin_press_load_value(mCompleteData.get(0)[82] != null ? (Double) mCompleteData.get(0)[82] : 0);
                mData.setOp1060a_max_pin_press_load_value(mCompleteData.get(0)[83] != null ? (Double) mCompleteData.get(0)[83] : 0);
                mData.setOp1060a_actual_pin_press_load_value(mCompleteData.get(0)[84] != null ? (Double) mCompleteData.get(0)[84] : 0);
                mData.setOp1060a_min_pin_displacement_value(mCompleteData.get(0)[85] != null ? (Double) mCompleteData.get(0)[85] : 0);
                mData.setOp1060a_max_pin_displacement_value(mCompleteData.get(0)[86] != null ? (Double) mCompleteData.get(0)[86] : 0);
                mData.setOp1060a_actual_pin_displacement_value(mCompleteData.get(0)[87] != null ? (Double) mCompleteData.get(0)[87] : 0);
                p1status = Integer.valueOf(mCompleteData.get(0)[88] != null ? (Integer) mCompleteData.get(0)[88] : 2);
                mData.setOp1060a_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                
                machineCSVDataList.add(mData);
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    private HashMap<Integer, String> getFailReasonData(String machineName) {
        String query = "SELECT p.fail_code, p.reason FROM "+machineName+" p";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        HashMap<Integer, String> failReasonData = new HashMap<>();

        List<Object[]> mCompleteData = entityManager.createNativeQuery(query).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    failReasonData.put((Integer) data[0], (String) data[1]);
                }
            }
        }
        entityManager.close();
        return failReasonData;
    }


    //MailData
    public ArrayList<Line1CSVData> getShiftWiseMailData(int shift, String fromDate, String toDate) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String lineCSVQuery = "("+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.shift = "+shift+" AND p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'"+
                ") "+
            "UNION ALL "+
                "( "+
                "SELECT p.log_date as mlogdate, p.end_time as mtime, p.shift as mshift, "+
                "p.sfl_part_id as sflid, p.product_id as barcode, p.pass_fail as productionstatus, "+
                "p0.pass_fail as m1process1status, p1.pass_fail as m1process2status, p2.pass_fail as m1process3status, "+
                "p3.pass_fail as m1process4status, p4.parameter1 as m2process1param1, p4.parameter2 as m2process1param2, "+
                "p4.parameter3 as m2process1param3, p4.parameter4 as m2process1param4, p4.pass_fail as m2process1status, "+
                "p5.parameter1 as m2process2param1, p5.parameter2 as m2process2param2, p5.parameter3 as m2process2param3, "+
                "p5.pass_fail as m2process2status, p6.pass_fail as m3process1status, p7.pass_fail as m4process1status, "+
                "p8.pass_fail as m4process2status, p9.parameter1 as m5process1param1, p9.parameter2 as m5process1param2, "+
                "p9.pass_fail as m5process1status, p10.parameter1 as m6process1param1, p10.parameter2 as m6process1param2, "+
                "p10.parameter3 as m6process1param3, p10.pass_fail as m6process1status, p11.parameter1 as m6process2param1, "+
                "p11.parameter2 as m6process2param2, p11.parameter3 as m6process2param3, p11.parameter4 as m6process2param4, "+
                "p11.parameter5 as m6process2param5, p11.parameter6 as m6process2param6, p11.pass_fail as m6process2status, "+
                "p12.parameter1 as m7process1param1, p12.parameter2 as m7process1param2, p12.parameter3 as m7process1param3, "+
                "p12.pass_fail as m7process1status, p13.parameter1 as m8process1param1,  p13.parameter2 as m8process1param2, "+
                "p13.parameter3 as m8process1param3, p13.parameter4 as m8process1param4, p13.pass_fail as m8process1status, "+
                "p14.parameter1 as m9process1param1, p14.parameter2 as m9process1param2, p14.parameter3 as m9process1param3, "+
                "p14.parameter4 as m9process1param4, p14.parameter5 as m9process1param5, p14.parameter6 as m9process1param6, "+
                "p14.pass_fail as m9process1status, p15.pass_fail as m9process2status, p16.pass_fail as m9process3status, "+
                "p17.pass_fail as m9process4status, p18.pass_fail as m9process5status, p19.parameter1 as m10process1param1, "+
                "p19.parameter2 as m10process1param2, p19.parameter3 as m10process1param3, p19.parameter4 as m10process1param4, "+
                "p19.parameter5 as m10process1param5, p19.parameter6 as m10process1param6, p19.pass_fail as m10process1status, "+
                "p20.pass_fail as m11process1status, p20.parameter1 as m11process1param1, p20.parameter2 as m11process1param2, "+
                "p20.parameter3 as m11process1param3,"+
                "p21.pass_fail as m12process1status, p21.parameter1 as m12process1param1, p21.parameter2 as m12process1param2, "+
                "p21.parameter3 as m12process1param3, "+
                "p22.parameter1 as m13process1param1, p22.parameter2 as m13process1param2, p22.parameter3 as m13process1param3, "+
                "p22.parameter4 as m13process1param4, p22.parameter5 as m13process1param5, p22.parameter6 as m13process1param6, "+
                "p22.pass_fail as m13process1status, p23.pass_fail as m13process2status, p24.pass_fail as m13process3status, "+
                "p25.pass_fail as m13process4status, p26.pass_fail as m13process5status, "+
                "p27.parameter1 as m14process1param1, p27.parameter2 as m14process1param2,"+
                "p27.parameter3 as m14process1param3, p27.parameter4 as m14process1param4, p27.parameter5 as m14process1param5,"+
                "p27.parameter6 as m14process1param6, p27.pass_fail as m14process1status FROM machine11production p "+
                "LEFT JOIN machine1process1 p0 ON p.product_id = p0.product_id "+
                "LEFT JOIN machine1process2 p1 ON p.product_id = p1.product_id "+
                "LEFT JOIN machine1process3 p2 ON p.product_id = p2.product_id "+
                "LEFT JOIN machine1process4 p3 ON p.product_id = p3.product_id "+
                "LEFT JOIN machine2process1 p4 ON p.product_id = p4.product_id "+
                "LEFT JOIN machine2process2 p5 ON p.product_id = p5.product_id "+
                "LEFT JOIN machine3process1 p6 ON p.product_id = p6.product_id "+
                "LEFT JOIN machine4process1 p7 ON p.product_id = p7.product_id "+
                "LEFT JOIN machine4process2 p8 ON p.product_id = p8.product_id "+
                "LEFT JOIN machine5process1 p9 ON p.product_id = p9.product_id "+
                "LEFT JOIN machine6process1 p10 ON p.product_id = p10.product_id "+
                "LEFT JOIN machine6process2 p11 ON p.product_id = p11.product_id "+
                "LEFT JOIN machine7process1 p12 ON p.product_id = p12.product_id "+
                "LEFT JOIN machine8process1 p13 ON p.product_id = p13.product_id "+
                "LEFT JOIN machine9process1 p14 ON p.product_id = p14.product_id "+
                "LEFT JOIN machine9process2 p15 ON p.product_id = p15.product_id "+
                "LEFT JOIN machine9process3 p16 ON p.product_id = p16.product_id "+
                "LEFT JOIN machine9process4 p17 ON p.product_id = p17.product_id "+
                "LEFT JOIN machine9process5 p18 ON p.product_id = p18.product_id "+
                "LEFT JOIN machine10process1 p19 ON p.product_id = p19.product_id "+
                "LEFT JOIN machine11process1 p20 ON p.product_id = p20.product_id "+
                "LEFT JOIN Machine19process1 p21 ON p.product_id = p21.product_id "+
                "LEFT JOIN machine13process1 p22 ON p.product_id = p22.product_id "+
                "LEFT JOIN machine13process2 p23 ON p.product_id = p23.product_id "+
                "LEFT JOIN machine13process3 p24 ON p.product_id = p24.product_id "+
                "LEFT JOIN machine13process4 p25 ON p.product_id = p25.product_id "+
                "LEFT JOIN machine13process5 p26 ON p.product_id = p26.product_id "+
                "LEFT JOIN machine14process1 p27 ON p.product_id = p27.product_id "+
                "WHERE p.shift = "+shift+" AND p.filter_date BETWEEN SYMMETRIC '"+fromDate+"' AND '"+toDate+"'"+
                ")"
                ;

        ArrayList<Line1CSVData> machineCSVDataList = new ArrayList<>();

        Integer prodStatus = null;
        Integer p1status = null;
        Integer p2status = null;
        Integer p3status = null;
        Integer p4status = null;
        Integer p5status = null;
        StringBuilder sb = null;
        Integer mShift = null;

        List<Object[]> mCompleteData = entityManager.createNativeQuery(lineCSVQuery).getResultList();
        if(mCompleteData.size() >= 1) {
            for(Object[] data : mCompleteData) {
                if(data != null) {
                    Line1CSVData mData = new Line1CSVData();
                    mData.setMachine_name("Exhaust Lever Assembly Line");
                    sb = new StringBuilder(data[0] != null ? (String) data[0] : "NA");
                    mData.setDate(data[0] != null ? sb.substring(0, sb.indexOf("(")) : "NA");
                    mData.setTime(data[1] != null ? (String) data[1] : "NA");
                    mShift = Integer.valueOf(data[2] != null ? (Integer) data[2] : 4);
                    mData.setShift(mShift.intValue() == 1 ? "A" : mShift.intValue() == 2 ? "B" : mShift.intValue() == 3 ? "C" : "NA");
                    mData.setSfl_serial_number(data[3] != null ? (String) data[3] : "NA");
                    mData.setComponent_barcode(data[4] != null ? (String) data[4] : "NA");
                    prodStatus = Integer.valueOf(data[5] != null ? (Integer) data[5] : 2);
                    mData.setProduction_status(prodStatus.intValue() == 1 ? "OK" : prodStatus.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine1
                    p1status = Integer.valueOf(data[6] != null ? (Integer) data[6] : 2);
                    mData.setOp1010_ocv_hole_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[7] != null ? (Integer) data[7] : 2);
                    mData.setOp1010_bap_hole_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[8] != null ? (Integer) data[8] : 2);
                    mData.setOp1010_pipe_plug_hole_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[9] != null ? (Integer) data[9] : 2);
                    mData.setOp1010_thread_plug_hole_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine2
                    mData.setOp1020a_min_id_gauge_value(data[10] != null ? (Double) data[10] : 0);
                    mData.setOp1020a_max_id_gauge_value(data[11] != null ? (Double) data[11] : 0);
                    mData.setOp1020a_actual_id_a_gauge_value(data[12] != null ? (Double) data[12] : 0);
                    mData.setOp1020a_actual_id_b_gauge_value(data[13] != null ? (Double) data[13] : 0);
                    p1status = Integer.valueOf(data[14] != null ? (Integer) data[14] : 2);
                    mData.setOp1020a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1020a_min_load_value(data[15] != null ? (Double) data[15] : 0);
                    mData.setOp1020a_max_load_value(data[16] != null ? (Double) data[16] : 0);
                    mData.setOp1020a_actual_load_value(data[17] != null ? (Double) data[17] : 0);
                    p2status = Integer.valueOf(data[18] != null ? (Integer) data[18] : 2);
                    mData.setOp1020a_ball_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine3
                    p1status = Integer.valueOf(data[19] != null ? (Integer) data[19] : 2);
                    mData.setOp1020b_socket_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine4
                    p1status = Integer.valueOf(data[20] != null ? (Integer) data[20] : 2);
                    mData.setOp1030_pre_screwing_and_screwing_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[21] != null ? (Integer) data[21] : 2);
                    mData.setOp1030_nut_tightening_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine5
                    mData.setOp1040a_target_torque(data[22] != null ? (Double) data[22] : 0);
                    mData.setOp1040a_actual_torque(data[23] != null ? (Double) data[23] : 0);
                    p1status = Integer.valueOf(data[24] != null ? (Integer) data[24] : 2);
                    mData.setOp1040a_pipe_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine6
                    mData.setOp1040b_min_id_gauge_bore_dia(data[25] != null ? (Double) data[25] : 0);
                    mData.setOp1040b_max_id_gauge_bore_dia(data[26] != null ? (Double) data[26] : 0);
                    mData.setOp1040b_actual_id_gauge_bore_dia(data[27] != null ? (Double) data[27] : 0);
                    p1status = Integer.valueOf(data[28] != null ? (Integer) data[28] : 2);
                    mData.setOp1040b_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1040b_min_load_insert_valve_press_value(data[29] != null ? (Double) data[29] : 0);
                    mData.setOp1040b_max_load_insert_valve_press_value(data[30] != null ? (Double) data[30] : 0);
                    mData.setOp1040b_actual_load_insert_valve_press_value(data[31] != null ? (Double) data[31] : 0);
                    mData.setOp1040b_min_displacement_insert_valve_value(data[32] != null ? (Double) data[32] : 0);
                    mData.setOp1040b_max_displacement_insert_valve_value(data[33] != null ? (Double) data[33] : 0);
                    mData.setOp1040b_actual_displacement_insert_valve_value(data[34] != null ? (Double) data[34] : 0);
                    p2status = Integer.valueOf(data[35] != null ? (Integer) data[35] : 2);
                    mData.setOp1040b_insert_valve_press_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine7
                    mData.setOp1040c_min_ball_over_height_value(data[36] != null ? (Double) data[36] : 0);
                    mData.setOp1040c_max_ball_over_height_value(data[37] != null ? (Double) data[37] : 0);
                    mData.setOp1040c_actual_ball_over_height_value(data[38] != null ? (Double) data[38] : 0);
                    p1status = Integer.valueOf(data[39] != null ? (Integer) data[39] : 2);
                    mData.setOp1040c_ball_over_height_check_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine8
                    mData.setOp1040d_minimum_torque(data[40] != null ? (Double) data[40] : 0);
                    mData.setOp1040d_maximum_torque(data[41] != null ? (Double) data[41] : 0);
                    mData.setOp1040d_actual_torque(data[42] != null ? (Double) data[42] : 0);
                    mData.setOp1040d_actual_angle(data[43] != null ? (Double) data[43] : 0);

                    p1status = Integer.valueOf(data[44] != null ? (Integer) data[44] : 2);
                    mData.setOp1040d_ball_spring_oring_thread_plug_asmbly_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine9
                    mData.setOp1050_min_ocv_id_gauge_value(data[45] != null ? (Double) data[45] : 0);
                    mData.setOp1050_max_ocv_id_gauge_value(data[46] != null ? (Double) data[46] : 0);
                    mData.setOp1050_actual_ocv_id_gauge_value(data[47] != null ? (Double) data[47] : 0);
                    mData.setOp1050_min_bap_id_gauge_value(data[48] != null ? (Double) data[48] : 0);
                    mData.setOp1050_max_bap_id_gauge_value(data[49] != null ? (Double) data[49] : 0);
                    mData.setOp1050_actual_bap_id_gauge_value(data[50] != null ? (Double) data[50] : 0);
                    p1status = Integer.valueOf(data[51] != null ? (Integer) data[51] : 2);
                    mData.setOp1050_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[52] != null ? (Integer) data[52] : 2);
                    mData.setOp1050_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[53] != null ? (Integer) data[53] : 2);
                    mData.setOp1050_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[54] != null ? (Integer) data[54] : 2);
                    mData.setOp1050_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[55] != null ? (Integer) data[55] : 2);
                    mData.setOp1050_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");
                    
                    //Machine10
                    mData.setOp1060_min_pin_press_load_value(data[56] != null ? (Double) data[56] : 0);
                    mData.setOp1060_max_pin_press_load_value(data[57] != null ? (Double) data[57] : 0);
                    mData.setOp1060_actual_pin_press_load_value(data[58] != null ? (Double) data[58] : 0);
                    mData.setOp1060_min_pin_displacement_value(data[59] != null ? (Double) data[59] : 0);
                    mData.setOp1060_max_pin_displacement_value(data[60] != null ? (Double) data[60] : 0);
                    mData.setOp1060_actual_pin_displacement_value(data[61] != null ? (Double) data[61] : 0);
                    p1status = Integer.valueOf(data[62] != null ? (Integer) data[62] : 2);
                    mData.setOp1060_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine11
                    p1status = Integer.valueOf(data[63] != null ? (Integer) data[63] : 2);
                    mData.setOp1070_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070_min_load_value(data[64] != null ? (Double) data[64] : 0);
                    mData.setOp1070_max_load_value(data[65] != null ? (Double) data[65] : 0);
                    mData.setOp1070_actual_load_value(data[66] != null ? (Double) data[66] : 0);

                    //Machine19
                    p1status = Integer.valueOf(data[67] != null ? (Integer) data[67] : 2);
                    mData.setOp1070a_functional_test_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    mData.setOp1070a_min_load_value(data[68] != null ? (Double) data[68] : 0);
                    mData.setOp1070a_max_load_value(data[69] != null ? (Double) data[69] : 0);
                    mData.setOp1070a_actual_load_value(data[70] != null ? (Double) data[70] : 0);

                    //Machine13
                    mData.setOp1050a_min_ocv_id_gauge_value(data[71] != null ? (Double) data[71] : 0);
                    mData.setOp1050a_max_ocv_id_gauge_value(data[72] != null ? (Double) data[72] : 0);
                    mData.setOp1050a_actual_ocv_id_gauge_value(data[73] != null ? (Double) data[73] : 0);
                    mData.setOp1050a_min_bap_id_gauge_value(data[74] != null ? (Double) data[74] : 0);
                    mData.setOp1050a_max_bap_id_gauge_value(data[75] != null ? (Double) data[75] : 0);
                    mData.setOp1050a_actual_bap_id_gauge_value(data[76] != null ? (Double) data[76] : 0);
                    p1status = Integer.valueOf(data[77] != null ? (Integer) data[77] : 2);
                    mData.setOp1050a_id_gauge_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");
                    p2status = Integer.valueOf(data[78] != null ? (Integer) data[78] : 2);
                    mData.setOp1050a_ocv_and_bap_asmbly_status(p2status.intValue() == 1 ? "OK" : p2status.intValue() == 0 ? "NOT OK" : "NA");
                    p3status = Integer.valueOf(data[79] != null ? (Integer) data[79] : 2);
                    mData.setOp1050a_spring_asmbly_status(p3status.intValue() == 1 ? "OK" : p3status.intValue() == 0 ? "NOT OK" : "NA");
                    p4status = Integer.valueOf(data[80] != null ? (Integer) data[80] : 2);
                    mData.setOp1050a_retainer_asmbly_status(p4status.intValue() == 1 ? "OK" : p4status.intValue() == 0 ? "NOT OK" : "NA");
                    p5status = Integer.valueOf(data[81] != null ? (Integer) data[81] : 2);
                    mData.setOp1050a_circlip_asmbly_status(p5status.intValue() == 1 ? "OK" : p5status.intValue() == 0 ? "NOT OK" : "NA");

                    //Machine14
                    mData.setOp1060a_min_pin_press_load_value(data[82] != null ? (Double) data[82] : 0);
                    mData.setOp1060a_max_pin_press_load_value(data[83] != null ? (Double) data[83] : 0);
                    mData.setOp1060a_actual_pin_press_load_value(data[84] != null ? (Double) data[84] : 0);
                    mData.setOp1060a_min_pin_displacement_value(data[85] != null ? (Double) data[85] : 0);
                    mData.setOp1060a_max_pin_displacement_value(data[86] != null ? (Double) data[86] : 0);
                    mData.setOp1060a_actual_pin_displacement_value(data[87] != null ? (Double) data[87] : 0);
                    p1status = Integer.valueOf(data[88] != null ? (Integer) data[88] : 2);
                    mData.setOp1060a_pin_press_status(p1status.intValue() == 1 ? "OK" : p1status.intValue() == 0 ? "NOT OK" : "NA");

                    machineCSVDataList.add(mData);
                }
            }
        }
        entityManager.close();
        return machineCSVDataList;
    }

    //DELETE FROM machine1process1 WHERE filter_date BETWEEN SYMMETRIC '2021-11-15' AND '2022-02-15';

    @PersistenceContext
    private EntityManager entManager;

    @Transactional
    @Modifying
    public String deleteLine1(String endDate) {
        String[] end = endDate.split("-");
        String EndDateMessage = "" + end[2] + "-" + end[1] + "-" + end[0];
        String startDate = "2021-12-01";
        String query = "call delete_line('"+startDate+"', '"+endDate+"')";
        entManager.createNativeQuery(query).executeUpdate();
        entManager.close();
        return "All the data is deleted until the date ("+EndDateMessage+")";
    }

    //Error update
    public ErrorInfo checkError() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String query = "SELECT pass_fail, error_time, error_date FROM serverdownlog ORDER BY log_id DESC LIMIT 1";
        Object[] errorRes = (Object[]) entityManager.createNativeQuery(query).getSingleResult();
        ErrorInfo errorInfo = new ErrorInfo();
        if(errorRes.length > 0) {
            errorInfo.setReason((Integer) errorRes[0] == 1 ? "OPC Server lost connection!!" : "success");
            errorInfo.setErrorTime((String) errorRes[1]);
            errorInfo.setErrorDate((String) errorRes[2]);
        }

        entityManager.close();
        return errorInfo;
    }

    @Transactional
    @Modifying
    public String updateErrorStatus() {
        int val = 0;
        String query = "update serverdownlog set pass_fail = "+val;
        entManager.createNativeQuery(query).executeUpdate();
        entManager.close();
        return "Value updated!!";
    }

   

}
