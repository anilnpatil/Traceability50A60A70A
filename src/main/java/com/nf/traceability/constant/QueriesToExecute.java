package com.nf.traceability.constant;
 
public class QueriesToExecute {

    public static final String MACHINE_1_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail FROM machine1process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail FROM machine1process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p2.product_id, p2.pass_fail FROM machine1process3 p2 ORDER BY p2.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p3.product_id, p3.pass_fail FROM machine1process4 p3 ORDER BY p3.pid DESC LIMIT 1 " +
    ")";
    public static final String MACHINE_2_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail, p0.parameter1, p0.parameter2, p0.parameter3, p0.parameter4 FROM machine2process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail, p1.parameter1, p1.parameter2, p1.parameter3, p1.parameter4 FROM machine2process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ")";
    public static final String MACHINE_3_QUERY = "SELECT p.product_id, p.pass_fail FROM machine3process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String MACHINE_4_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail FROM machine4process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail FROM machine4process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ")";
    public static final String MACHINE_5_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2 FROM machine5process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String MACHINE_6_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail, p0.parameter1, p0.parameter2, p0.parameter3, p0.parameter4, p0.parameter5, p0.parameter6 FROM machine6process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail, p1.parameter1, p1.parameter2, p1.parameter3, p1.parameter4, p1.parameter5, p1.parameter6 FROM machine6process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ")";
    public static final String MACHINE_7_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3 FROM machine7process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String MACHINE_8_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3, p.parameter4 FROM machine8process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String MACHINE_9_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail, p0.parameter1, p0.parameter2, p0.parameter3, p0.parameter4, p0.parameter5, p0.parameter6 FROM machine9process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail, p1.parameter1, p1.parameter2, p1.parameter3, p1.parameter4, p1.parameter5, p1.parameter6 FROM machine9process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p2.product_id, p2.pass_fail, p2.parameter1, p2.parameter2, p2.parameter3, p2.parameter4, p2.parameter5, p2.parameter6 FROM machine9process3 p2 ORDER BY p2.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p3.product_id, p3.pass_fail, p3.parameter1, p3.parameter2, p3.parameter3, p3.parameter4, p3.parameter5, p3.parameter6 FROM machine9process4 p3 ORDER BY p3.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p4.product_id, p4.pass_fail, p4.parameter1, p4.parameter2, p4.parameter3, p4.parameter4, p4.parameter5, p4.parameter6 FROM machine9process5 p4 ORDER BY p4.pid DESC LIMIT 1 " +
    ")";
    
    public static final String MACHINE_10_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3, p.parameter4, p.parameter5, p.parameter6 FROM machine10process1 p ORDER BY p.pid DESC LIMIT 1";
//    public static final String MACHINE_11_QUERY = "( " +
//            "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3 FROM machine11process1 p ORDER BY p.pid DESC LIMIT 1" +
//            ") " +
//            "UNION ALL " +
//            "( " +
//            "SELECT p0.product_id, p0.pass_fail, p0.parameter1, p0.parameter2, p0.parameter3 FROM machine11process2 p0 ORDER BY p0.pid DESC LIMIT 1" +
//            ")";
    public static final String MACHINE_11_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3 FROM machine11process1 p ORDER BY p.pid DESC LIMIT 1";
    //code for 12(70A) ../
    public static final String MACHINE_12_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3 FROM Machine19process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String MACHINE_13_QUERY = "( " +
    "SELECT p0.product_id, p0.pass_fail, p0.parameter1, p0.parameter2, p0.parameter3, p0.parameter4, p0.parameter5, p0.parameter6 FROM machine13process1 p0 ORDER BY p0.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p1.product_id, p1.pass_fail, p1.parameter1, p1.parameter2, p1.parameter3, p1.parameter4, p1.parameter5, p1.parameter6 FROM machine13process2 p1 ORDER BY p1.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p2.product_id, p2.pass_fail, p2.parameter1, p2.parameter2, p2.parameter3, p2.parameter4, p2.parameter5, p2.parameter6 FROM machine13process3 p2 ORDER BY p2.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p3.product_id, p3.pass_fail, p3.parameter1, p3.parameter2, p3.parameter3, p3.parameter4, p3.parameter5, p3.parameter6 FROM machine13process4 p3 ORDER BY p3.pid DESC LIMIT 1 " +
    ") " +
    "UNION ALL " +
    "( " +
    "SELECT p4.product_id, p4.pass_fail, p4.parameter1, p4.parameter2, p4.parameter3, p4.parameter4, p4.parameter5, p4.parameter6 FROM machine13process5 p4 ORDER BY p4.pid DESC LIMIT 1 " +
    ")";
    public static final String MACHINE_14_QUERY = "SELECT p.product_id, p.pass_fail, p.parameter1, p.parameter2, p.parameter3, p.parameter4, p.parameter5, p.parameter6 FROM machine14process1 p ORDER BY p.pid DESC LIMIT 1";
    public static final String CURRENT_SHIFT_QUERY = "SELECT p1.sfl_part_id, p1.shift, p1.pass_fail, p1.product_id FROM Machine19production p1 ORDER BY p1.mid DESC LIMIT 1";
    public static final String CURRENT_SHIFT_QUERY1 = "SELECT p1.sfl_part_id, p1.shift, p1.pass_fail, p1.product_id FROM machine11production p1 ORDER BY p1.mid DESC LIMIT 1";
    public static final String ALL_MACHINE_CURRENT_STATUS = "( "+
            "SELECT product_id, pass_fail FROM machine1production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine2production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine3production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine4production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine5production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine6production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine7production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine8production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine9production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine10production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine11production ORDER BY mid DESC LIMIT 1"+
            ")"+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM Machine19production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine13production ORDER BY mid DESC LIMIT 1"+
            ") "+
            "UNION ALL "+
            "( "+
            "SELECT product_id, pass_fail FROM machine14production ORDER BY mid DESC LIMIT 1"+
            ") ";
            
}





