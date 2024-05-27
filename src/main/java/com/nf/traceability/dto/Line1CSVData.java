package com.nf.traceability.dto;

public class Line1CSVData {
    private String date;
    private String time;
    private String shift;
    private String sfl_serial_number;
    private String component_barcode;
    private String machine_name;
    private String production_status;

    private String op1010_ocv_hole_status;
    private String op1010_bap_hole_status;
    private String op1010_pipe_plug_hole_status;
    private String op1010_thread_plug_hole_status;

    private Double op1020a_min_id_gauge_value;
    private Double op1020a_max_id_gauge_value;
    private Double op1020a_actual_id_a_gauge_value;
    private Double op1020a_actual_id_b_gauge_value;
    private String op1020a_id_gauge_status;
    private Double op1020a_min_load_value;
    private Double op1020a_max_load_value;
    private Double op1020a_actual_load_value;
    private String op1020a_ball_press_status;

    private String op1020b_socket_press_status ;

    private String op1030_pre_screwing_and_screwing_status;
    private String op1030_nut_tightening_status;

    private Double op1040a_target_torque;
    private Double op1040a_actual_torque;
    private String op1040a_pipe_plug_asmbly_status;

    private Double op1040b_min_id_gauge_bore_dia;
    private Double op1040b_max_id_gauge_bore_dia;
    private Double op1040b_actual_id_gauge_bore_dia;
    private String op1040b_id_gauge_status;
    private Double op1040b_min_load_insert_valve_press_value;
    private Double op1040b_max_load_insert_valve_press_value;
    private Double op1040b_actual_load_insert_valve_press_value;
    private Double op1040b_min_displacement_insert_valve_value;
    private Double op1040b_max_displacement_insert_valve_value;
    private Double op1040b_actual_displacement_insert_valve_value;
    private String op1040b_insert_valve_press_status;

    private Double op1040c_min_ball_over_height_value;
    private Double op1040c_max_ball_over_height_value;
    private Double op1040c_actual_ball_over_height_value;
    private String op1040c_ball_over_height_check_status;

    private Double op1040d_minimum_torque;
    private Double op1040d_maximum_torque;
    private Double op1040d_actual_torque;
    private Double op1040d_actual_angle;
    private String op1040d_ball_spring_oring_thread_plug_asmbly_status;

    private Double op1050_min_ocv_id_gauge_value;
    private Double op1050_max_ocv_id_gauge_value;
    private Double op1050_actual_ocv_id_gauge_value;
    private Double op1050_min_bap_id_gauge_value;
    private Double op1050_max_bap_id_gauge_value;
    private Double op1050_actual_bap_id_gauge_value;
    private String op1050_id_gauge_status;
    private String op1050_ocv_and_bap_asmbly_status;
    private String op1050_spring_asmbly_status;
    private String op1050_retainer_asmbly_status;
    private String op1050_circlip_asmbly_status;

    private Double op1050a_min_ocv_id_gauge_value;
    private Double op1050a_max_ocv_id_gauge_value;
    private Double op1050a_actual_ocv_id_gauge_value;
    private Double op1050a_min_bap_id_gauge_value;
    private Double op1050a_max_bap_id_gauge_value;
    private Double op1050a_actual_bap_id_gauge_value;
    private String op1050a_id_gauge_status;
    private String op1050a_ocv_and_bap_asmbly_status;
    private String op1050a_spring_asmbly_status;
    private String op1050a_retainer_asmbly_status;
    private String op1050a_circlip_asmbly_status;


    private Double op1060_min_pin_press_load_value;
    private Double op1060_max_pin_press_load_value;
    private Double op1060_actual_pin_press_load_value;
    private Double op1060_min_pin_displacement_value;
    private Double op1060_max_pin_displacement_value;
    private Double op1060_actual_pin_displacement_value;
    private String op1060_pin_press_status;

    private Double op1060a_min_pin_press_load_value;
    private Double op1060a_max_pin_press_load_value;
    private Double op1060a_actual_pin_press_load_value;
    private Double op1060a_min_pin_displacement_value;
    private Double op1060a_max_pin_displacement_value;
    private Double op1060a_actual_pin_displacement_value;
    private String op1060a_pin_press_status;

    private String op1070_functional_test_status;
    private Double op1070_min_load_value;
    private Double op1070_max_load_value;
    private Double op1070_actual_load_value;

    //code for machine 12(70A)../
    private String op1070a_functional_test_status;
    private Double op1070a_min_load_value;
    private Double op1070a_max_load_value;
    private Double op1070a_actual_load_value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getSfl_serial_number() {
        return sfl_serial_number;
    }

    public void setSfl_serial_number(String sfl_serial_number) {
        this.sfl_serial_number = sfl_serial_number;
    }

    public String getComponent_barcode() {
        return component_barcode;
    }

    public void setComponent_barcode(String component_barcode) {
        this.component_barcode = component_barcode;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getProduction_status() {
        return production_status;
    }

    public void setProduction_status(String production_status) {
        this.production_status = production_status;
    }

    public String getOp1010_ocv_hole_status() {
        return op1010_ocv_hole_status;
    }

    public void setOp1010_ocv_hole_status(String op1010_ocv_hole_status) {
        this.op1010_ocv_hole_status = op1010_ocv_hole_status;
    }

    public String getOp1010_bap_hole_status() {
        return op1010_bap_hole_status;
    }

    public void setOp1010_bap_hole_status(String op1010_bap_hole_status) {
        this.op1010_bap_hole_status = op1010_bap_hole_status;
    }

    public String getOp1010_pipe_plug_hole_status() {
        return op1010_pipe_plug_hole_status;
    }

    public void setOp1010_pipe_plug_hole_status(String op1010_pipe_plug_hole_status) {
        this.op1010_pipe_plug_hole_status = op1010_pipe_plug_hole_status;
    }

    public String getOp1010_thread_plug_hole_status() {
        return op1010_thread_plug_hole_status;
    }

    public void setOp1010_thread_plug_hole_status(String op1010_thread_plug_hole_status) {
        this.op1010_thread_plug_hole_status = op1010_thread_plug_hole_status;
    }

    public Double getOp1020a_min_id_gauge_value() {
        return op1020a_min_id_gauge_value;
    }

    public void setOp1020a_min_id_gauge_value(Double op1020a_min_id_gauge_value) {
        this.op1020a_min_id_gauge_value = op1020a_min_id_gauge_value;
    }

    public Double getOp1020a_max_id_gauge_value() {
        return op1020a_max_id_gauge_value;
    }

    public void setOp1020a_max_id_gauge_value(Double op1020a_max_id_gauge_value) {
        this.op1020a_max_id_gauge_value = op1020a_max_id_gauge_value;
    }

    public Double getOp1020a_actual_id_a_gauge_value() {
        return op1020a_actual_id_a_gauge_value;
    }

    public void setOp1020a_actual_id_a_gauge_value(Double op1020a_actual_id_a_gauge_value) {
        this.op1020a_actual_id_a_gauge_value = op1020a_actual_id_a_gauge_value;
    }

    public Double getOp1020a_actual_id_b_gauge_value() {
        return op1020a_actual_id_b_gauge_value;
    }

    public void setOp1020a_actual_id_b_gauge_value(Double op1020a_actual_id_b_gauge_value) {
        this.op1020a_actual_id_b_gauge_value = op1020a_actual_id_b_gauge_value;
    }

    public String getOp1020a_id_gauge_status() {
        return op1020a_id_gauge_status;
    }

    public void setOp1020a_id_gauge_status(String op1020a_id_gauge_status) {
        this.op1020a_id_gauge_status = op1020a_id_gauge_status;
    }

    public Double getOp1020a_min_load_value() {
        return op1020a_min_load_value;
    }

    public void setOp1020a_min_load_value(Double op1020a_min_load_value) {
        this.op1020a_min_load_value = op1020a_min_load_value;
    }

    public Double getOp1020a_max_load_value() {
        return op1020a_max_load_value;
    }

    public void setOp1020a_max_load_value(Double op1020a_max_load_value) {
        this.op1020a_max_load_value = op1020a_max_load_value;
    }

    public Double getOp1020a_actual_load_value() {
        return op1020a_actual_load_value;
    }

    public void setOp1020a_actual_load_value(Double op1020a_actual_load_value) {
        this.op1020a_actual_load_value = op1020a_actual_load_value;
    }

    public String getOp1020a_ball_press_status() {
        return op1020a_ball_press_status;
    }

    public void setOp1020a_ball_press_status(String op1020a_ball_press_status) {
        this.op1020a_ball_press_status = op1020a_ball_press_status;
    }

    public String getOp1020b_socket_press_status() {
        return op1020b_socket_press_status;
    }

    public void setOp1020b_socket_press_status(String op1020b_socket_press_status) {
        this.op1020b_socket_press_status = op1020b_socket_press_status;
    }

    public String getOp1030_pre_screwing_and_screwing_status() {
        return op1030_pre_screwing_and_screwing_status;
    }

    public void setOp1030_pre_screwing_and_screwing_status(String op1030_pre_screwing_and_screwing_status) {
        this.op1030_pre_screwing_and_screwing_status = op1030_pre_screwing_and_screwing_status;
    }

    public String getOp1030_nut_tightening_status() {
        return op1030_nut_tightening_status;
    }

    public void setOp1030_nut_tightening_status(String op1030_nut_tightening_status) {
        this.op1030_nut_tightening_status = op1030_nut_tightening_status;
    }

    public Double getOp1040a_target_torque() {
        return op1040a_target_torque;
    }

    public void setOp1040a_target_torque(Double op1040a_target_torque) {
        this.op1040a_target_torque = op1040a_target_torque;
    }

    public Double getOp1040a_actual_torque() {
        return op1040a_actual_torque;
    }

    public void setOp1040a_actual_torque(Double op1040a_actual_torque) {
        this.op1040a_actual_torque = op1040a_actual_torque;
    }

    public String getOp1040a_pipe_plug_asmbly_status() {
        return op1040a_pipe_plug_asmbly_status;
    }

    public void setOp1040a_pipe_plug_asmbly_status(String op1040a_pipe_plug_asmbly_status) {
        this.op1040a_pipe_plug_asmbly_status = op1040a_pipe_plug_asmbly_status;
    }

    public Double getOp1040b_min_id_gauge_bore_dia() {
        return op1040b_min_id_gauge_bore_dia;
    }

    public void setOp1040b_min_id_gauge_bore_dia(Double op1040b_min_id_gauge_bore_dia) {
        this.op1040b_min_id_gauge_bore_dia = op1040b_min_id_gauge_bore_dia;
    }

    public Double getOp1040b_max_id_gauge_bore_dia() {
        return op1040b_max_id_gauge_bore_dia;
    }

    public void setOp1040b_max_id_gauge_bore_dia(Double op1040b_max_id_gauge_bore_dia) {
        this.op1040b_max_id_gauge_bore_dia = op1040b_max_id_gauge_bore_dia;
    }

    public Double getOp1040b_actual_id_gauge_bore_dia() {
        return op1040b_actual_id_gauge_bore_dia;
    }

    public void setOp1040b_actual_id_gauge_bore_dia(Double op1040b_actual_id_gauge_bore_dia) {
        this.op1040b_actual_id_gauge_bore_dia = op1040b_actual_id_gauge_bore_dia;
    }

    public String getOp1040b_id_gauge_status() {
        return op1040b_id_gauge_status;
    }

    public void setOp1040b_id_gauge_status(String op1040b_id_gauge_status) {
        this.op1040b_id_gauge_status = op1040b_id_gauge_status;
    }

    public Double getOp1040b_min_load_insert_valve_press_value() {
        return op1040b_min_load_insert_valve_press_value;
    }

    public void setOp1040b_min_load_insert_valve_press_value(Double op1040b_min_load_insert_valve_press_value) {
        this.op1040b_min_load_insert_valve_press_value = op1040b_min_load_insert_valve_press_value;
    }

    public Double getOp1040b_max_load_insert_valve_press_value() {
        return op1040b_max_load_insert_valve_press_value;
    }

    public void setOp1040b_max_load_insert_valve_press_value(Double op1040b_max_load_insert_valve_press_value) {
        this.op1040b_max_load_insert_valve_press_value = op1040b_max_load_insert_valve_press_value;
    }

    public Double getOp1040b_actual_load_insert_valve_press_value() {
        return op1040b_actual_load_insert_valve_press_value;
    }

    public void setOp1040b_actual_load_insert_valve_press_value(Double op1040b_actual_load_insert_valve_press_value) {
        this.op1040b_actual_load_insert_valve_press_value = op1040b_actual_load_insert_valve_press_value;
    }

    public Double getOp1040b_min_displacement_insert_valve_value() {
        return op1040b_min_displacement_insert_valve_value;
    }

    public void setOp1040b_min_displacement_insert_valve_value(Double op1040b_min_displacement_insert_valve_value) {
        this.op1040b_min_displacement_insert_valve_value = op1040b_min_displacement_insert_valve_value;
    }

    public Double getOp1040b_max_displacement_insert_valve_value() {
        return op1040b_max_displacement_insert_valve_value;
    }

    public void setOp1040b_max_displacement_insert_valve_value(Double op1040b_max_displacement_insert_valve_value) {
        this.op1040b_max_displacement_insert_valve_value = op1040b_max_displacement_insert_valve_value;
    }

    public Double getOp1040b_actual_displacement_insert_valve_value() {
        return op1040b_actual_displacement_insert_valve_value;
    }

    public void setOp1040b_actual_displacement_insert_valve_value(Double op1040b_actual_displacement_insert_valve_value) {
        this.op1040b_actual_displacement_insert_valve_value = op1040b_actual_displacement_insert_valve_value;
    }

    public String getOp1040b_insert_valve_press_status() {
        return op1040b_insert_valve_press_status;
    }

    public void setOp1040b_insert_valve_press_status(String op1040b_insert_valve_press_status) {
        this.op1040b_insert_valve_press_status = op1040b_insert_valve_press_status;
    }

    public Double getOp1040c_min_ball_over_height_value() {
        return op1040c_min_ball_over_height_value;
    }

    public void setOp1040c_min_ball_over_height_value(Double op1040c_min_ball_over_height_value) {
        this.op1040c_min_ball_over_height_value = op1040c_min_ball_over_height_value;
    }

    public Double getOp1040c_max_ball_over_height_value() {
        return op1040c_max_ball_over_height_value;
    }

    public void setOp1040c_max_ball_over_height_value(Double op1040c_max_ball_over_height_value) {
        this.op1040c_max_ball_over_height_value = op1040c_max_ball_over_height_value;
    }

    public Double getOp1040c_actual_ball_over_height_value() {
        return op1040c_actual_ball_over_height_value;
    }

    public void setOp1040c_actual_ball_over_height_value(Double op1040c_actual_ball_over_height_value) {
        this.op1040c_actual_ball_over_height_value = op1040c_actual_ball_over_height_value;
    }

    public String getOp1040c_ball_over_height_check_status() {
        return op1040c_ball_over_height_check_status;
    }

    public void setOp1040c_ball_over_height_check_status(String op1040c_ball_over_height_check_status) {
        this.op1040c_ball_over_height_check_status = op1040c_ball_over_height_check_status;
    }

    public Double getOp1040d_minimum_torque() {
        return op1040d_minimum_torque;
    }

    public void setOp1040d_minimum_torque(Double op1040d_minimum_torque) {
        this.op1040d_minimum_torque = op1040d_minimum_torque;
    }

    public Double getOp1040d_maximum_torque() {
        return op1040d_maximum_torque;
    }

    public void setOp1040d_maximum_torque(Double op1040d_maximum_torque) {
        this.op1040d_maximum_torque = op1040d_maximum_torque;
    }

    public Double getOp1040d_actual_torque() {
        return op1040d_actual_torque;
    }

    public void setOp1040d_actual_torque(Double op1040d_actual_torque) {
        this.op1040d_actual_torque = op1040d_actual_torque;
    }

    public Double getOp1040d_actual_angle() {
        return op1040d_actual_angle;
    }

    public void setOp1040d_actual_angle(Double op1040d_actual_angle) {
        this.op1040d_actual_angle = op1040d_actual_angle;
    }

    public String getOp1040d_ball_spring_oring_thread_plug_asmbly_status() {
        return op1040d_ball_spring_oring_thread_plug_asmbly_status;
    }

    public void setOp1040d_ball_spring_oring_thread_plug_asmbly_status(String op1040d_ball_spring_oring_thread_plug_asmbly_status) {
        this.op1040d_ball_spring_oring_thread_plug_asmbly_status = op1040d_ball_spring_oring_thread_plug_asmbly_status;
    }

    public Double getOp1050_min_ocv_id_gauge_value() {
        return op1050_min_ocv_id_gauge_value;
    }

    public void setOp1050_min_ocv_id_gauge_value(Double op1050_min_ocv_id_gauge_value) {
        this.op1050_min_ocv_id_gauge_value = op1050_min_ocv_id_gauge_value;
    }

    public Double getOp1050_max_ocv_id_gauge_value() {
        return op1050_max_ocv_id_gauge_value;
    }

    public void setOp1050_max_ocv_id_gauge_value(Double op1050_max_ocv_id_gauge_value) {
        this.op1050_max_ocv_id_gauge_value = op1050_max_ocv_id_gauge_value;
    }

    public Double getOp1050_actual_ocv_id_gauge_value() {
        return op1050_actual_ocv_id_gauge_value;
    }

    public void setOp1050_actual_ocv_id_gauge_value(Double op1050_actual_ocv_id_gauge_value) {
        this.op1050_actual_ocv_id_gauge_value = op1050_actual_ocv_id_gauge_value;
    }

    public Double getOp1050_min_bap_id_gauge_value() {
        return op1050_min_bap_id_gauge_value;
    }

    public void setOp1050_min_bap_id_gauge_value(Double op1050_min_bap_id_gauge_value) {
        this.op1050_min_bap_id_gauge_value = op1050_min_bap_id_gauge_value;
    }

    public Double getOp1050_max_bap_id_gauge_value() {
        return op1050_max_bap_id_gauge_value;
    }

    public void setOp1050_max_bap_id_gauge_value(Double op1050_max_bap_id_gauge_value) {
        this.op1050_max_bap_id_gauge_value = op1050_max_bap_id_gauge_value;
    }

    public Double getOp1050_actual_bap_id_gauge_value() {
        return op1050_actual_bap_id_gauge_value;
    }

    public void setOp1050_actual_bap_id_gauge_value(Double op1050_actual_bap_id_gauge_value) {
        this.op1050_actual_bap_id_gauge_value = op1050_actual_bap_id_gauge_value;
    }

    public String getOp1050_id_gauge_status() {
        return op1050_id_gauge_status;
    }

    public void setOp1050_id_gauge_status(String op1050_id_gauge_status) {
        this.op1050_id_gauge_status = op1050_id_gauge_status;
    }

    public String getOp1050_ocv_and_bap_asmbly_status() {
        return op1050_ocv_and_bap_asmbly_status;
    }

    public void setOp1050_ocv_and_bap_asmbly_status(String op1050_ocv_and_bap_asmbly_status) {
        this.op1050_ocv_and_bap_asmbly_status = op1050_ocv_and_bap_asmbly_status;
    }

    public String getOp1050_spring_asmbly_status() {
        return op1050_spring_asmbly_status;
    }

    public void setOp1050_spring_asmbly_status(String op1050_spring_asmbly_status) {
        this.op1050_spring_asmbly_status = op1050_spring_asmbly_status;
    }

    public String getOp1050_retainer_asmbly_status() {
        return op1050_retainer_asmbly_status;
    }

    public void setOp1050_retainer_asmbly_status(String op1050_retainer_asmbly_status) {
        this.op1050_retainer_asmbly_status = op1050_retainer_asmbly_status;
    }

    public String getOp1050_circlip_asmbly_status() {
        return op1050_circlip_asmbly_status;
    }

    public void setOp1050_circlip_asmbly_status(String op1050_circlip_asmbly_status) {
        this.op1050_circlip_asmbly_status = op1050_circlip_asmbly_status;
    }

    public Double getOp1050a_min_ocv_id_gauge_value() {
        return op1050a_min_ocv_id_gauge_value;
    }

   
    public void setOp1050a_min_ocv_id_gauge_value(Double op1050a_min_ocv_id_gauge_value) {
        this.op1050a_min_ocv_id_gauge_value = op1050a_min_ocv_id_gauge_value;
    }

   
    public Double getOp1050a_max_ocv_id_gauge_value() {
        return op1050a_max_ocv_id_gauge_value;
    }

   
    public void setOp1050a_max_ocv_id_gauge_value(Double op1050a_max_ocv_id_gauge_value) {
        this.op1050a_max_ocv_id_gauge_value = op1050a_max_ocv_id_gauge_value;
    }

    public Double getOp1050a_actual_ocv_id_gauge_value() {
        return op1050a_actual_ocv_id_gauge_value;
    }

    public void setOp1050a_actual_ocv_id_gauge_value(Double op1050a_actual_ocv_id_gauge_value) {
        this.op1050a_actual_ocv_id_gauge_value = op1050a_actual_ocv_id_gauge_value;
    }

    
    public Double getOp1050a_min_bap_id_gauge_value() {
        return op1050a_min_bap_id_gauge_value;
    }

    public void setOp1050a_min_bap_id_gauge_value(Double op1050a_min_bap_id_gauge_value) {
        this.op1050a_min_bap_id_gauge_value = op1050a_min_bap_id_gauge_value;
    }

   
    public Double getOp1050a_max_bap_id_gauge_value() {
        return op1050a_max_bap_id_gauge_value;
    }

    public void setOp1050a_max_bap_id_gauge_value(Double op1050a_max_bap_id_gauge_value) {
        this.op1050a_max_bap_id_gauge_value = op1050a_max_bap_id_gauge_value;
    }

   
    public Double getOp1050a_actual_bap_id_gauge_value() {
        return op1050a_actual_bap_id_gauge_value;
    }


    public void setOp1050a_actual_bap_id_gauge_value(Double op1050a_actual_bap_id_gauge_value) {
        this.op1050a_actual_bap_id_gauge_value = op1050a_actual_bap_id_gauge_value;
    }

    
    public String getOp1050a_id_gauge_status() {
        return op1050a_id_gauge_status;
    }

    
    public void setOp1050a_id_gauge_status(String op1050a_id_gauge_status) {
        this.op1050a_id_gauge_status = op1050a_id_gauge_status;
    }

  
    public String getOp1050a_ocv_and_bap_asmbly_status() {
        return op1050a_ocv_and_bap_asmbly_status;
    }

    
    public void setOp1050a_ocv_and_bap_asmbly_status(String op1050a_ocv_and_bap_asmbly_status) {
        this.op1050a_ocv_and_bap_asmbly_status = op1050a_ocv_and_bap_asmbly_status;
    }

    
    public String getOp1050a_spring_asmbly_status() {
        return op1050a_spring_asmbly_status;
    }

    
    public void setOp1050a_spring_asmbly_status(String op1050a_spring_asmbly_status) {
        this.op1050a_spring_asmbly_status = op1050a_spring_asmbly_status;
    }

    
    public String getOp1050a_retainer_asmbly_status() {
        return op1050a_retainer_asmbly_status;
    }

    public void setOp1050a_retainer_asmbly_status(String op1050a_retainer_asmbly_status) {
        this.op1050a_retainer_asmbly_status = op1050a_retainer_asmbly_status;
    }

    
    public String getOp1050a_circlip_asmbly_status() {
        return op1050a_circlip_asmbly_status;
    }

    
    public void setOp1050a_circlip_asmbly_status(String op1050a_circlip_asmbly_status) {
        this.op1050a_circlip_asmbly_status = op1050a_circlip_asmbly_status;
    }

    public Double getOp1060_min_pin_press_load_value() {
        return op1060_min_pin_press_load_value;
    }

    public void setOp1060_min_pin_press_load_value(Double op1060_min_pin_press_load_value) {
        this.op1060_min_pin_press_load_value = op1060_min_pin_press_load_value;
    }

    public Double getOp1060_max_pin_press_load_value() {
        return op1060_max_pin_press_load_value;
    }

    public void setOp1060_max_pin_press_load_value(Double op1060_max_pin_press_load_value) {
        this.op1060_max_pin_press_load_value = op1060_max_pin_press_load_value;
    }

    public Double getOp1060_actual_pin_press_load_value() {
        return op1060_actual_pin_press_load_value;
    }

    public void setOp1060_actual_pin_press_load_value(Double op1060_actual_pin_press_load_value) {
        this.op1060_actual_pin_press_load_value = op1060_actual_pin_press_load_value;
    }

    public Double getOp1060_min_pin_displacement_value() {
        return op1060_min_pin_displacement_value;
    }

    public void setOp1060_min_pin_displacement_value(Double op1060_min_pin_displacement_value) {
        this.op1060_min_pin_displacement_value = op1060_min_pin_displacement_value;
    }

    public Double getOp1060_max_pin_displacement_value() {
        return op1060_max_pin_displacement_value;
    }

    public void setOp1060_max_pin_displacement_value(Double op1060_max_pin_displacement_value) {
        this.op1060_max_pin_displacement_value = op1060_max_pin_displacement_value;
    }

    public Double getOp1060_actual_pin_displacement_value() {
        return op1060_actual_pin_displacement_value;
    }

    public void setOp1060_actual_pin_displacement_value(Double op1060_actual_pin_displacement_value) {
        this.op1060_actual_pin_displacement_value = op1060_actual_pin_displacement_value;
    }

    public String getOp1060_pin_press_status() {
        return op1060_pin_press_status;
    }

    public void setOp1060_pin_press_status(String op1060_pin_press_status) {
        this.op1060_pin_press_status = op1060_pin_press_status;
    }

    public String getOp1070_functional_test_status() {
        return op1070_functional_test_status;
    }

    public void setOp1070_functional_test_status(String op1070_functional_test_status) {
        this.op1070_functional_test_status = op1070_functional_test_status;
    }

    public Double getOp1070_min_load_value() {
        return op1070_min_load_value;
    }

    public void setOp1070_min_load_value(Double op1070_min_load_value) {
        this.op1070_min_load_value = op1070_min_load_value;
    }

    public Double getOp1070_max_load_value() {
        return op1070_max_load_value;
    }

    public void setOp1070_max_load_value(Double op1070_max_load_value) {
        this.op1070_max_load_value = op1070_max_load_value;
    }

    public Double getOp1070_actual_load_value() {
        return op1070_actual_load_value;
    }

    public void setOp1070_actual_load_value(Double op1070_actual_load_value) {
        this.op1070_actual_load_value = op1070_actual_load_value;
    }


    
    public String getOp1070a_functional_test_status() {
        return op1070a_functional_test_status;
    }

    
    public void setOp1070a_functional_test_status(String op1070a_functional_test_status) {
        this.op1070a_functional_test_status = op1070a_functional_test_status;
    }

   
    public Double getOp1070a_min_load_value() {
        return op1070a_min_load_value;
    }

    
    public void setOp1070a_min_load_value(Double op1070a_min_load_value) {
        this.op1070a_min_load_value = op1070a_min_load_value;
    }

    
    public Double getOp1070a_max_load_value() {
        return op1070a_max_load_value;
    }

    
    public void setOp1070a_max_load_value(Double op1070a_max_load_value) {
        this.op1070a_max_load_value = op1070a_max_load_value;
    }

    
    public Double getOp1070a_actual_load_value() {
        return op1070a_actual_load_value;
    }

    
    public void setOp1070a_actual_load_value(Double op1070a_actual_load_value) {
        this.op1070a_actual_load_value = op1070a_actual_load_value;
    }


    public Double getOp1060a_min_pin_press_load_value() {
        return op1060a_min_pin_press_load_value;
    }

    public void setOp1060a_min_pin_press_load_value(Double op1060a_min_pin_press_load_value) {
        this.op1060a_min_pin_press_load_value = op1060a_min_pin_press_load_value;
    }

    public Double getOp1060a_max_pin_press_load_value() {
        return op1060a_max_pin_press_load_value;
    }

    public void setOp1060a_max_pin_press_load_value(Double op1060a_max_pin_press_load_value) {
        this.op1060a_max_pin_press_load_value = op1060a_max_pin_press_load_value;
    }

    public Double getOp1060a_actual_pin_press_load_value() {
        return op1060a_actual_pin_press_load_value;
    }

    public void setOp1060a_actual_pin_press_load_value(Double op1060a_actual_pin_press_load_value) {
        this.op1060a_actual_pin_press_load_value = op1060a_actual_pin_press_load_value;
    }

    public Double getOp1060a_min_pin_displacement_value() {
        return op1060a_min_pin_displacement_value;
    }

    public void setOp1060a_min_pin_displacement_value(Double op1060a_min_pin_displacement_value) {
        this.op1060a_min_pin_displacement_value = op1060a_min_pin_displacement_value;
    }

    public Double getOp1060a_max_pin_displacement_value() {
        return op1060a_max_pin_displacement_value;
    }

    public void setOp1060a_max_pin_displacement_value(Double op1060a_max_pin_displacement_value) {
        this.op1060a_max_pin_displacement_value = op1060a_max_pin_displacement_value;
    }

    public Double getOp1060a_actual_pin_displacement_value() {
        return op1060a_actual_pin_displacement_value;
    }

    public void setOp1060a_actual_pin_displacement_value(Double op1060a_actual_pin_displacement_value) {
        this.op1060a_actual_pin_displacement_value = op1060a_actual_pin_displacement_value;
    }

    public String getOp1060a_pin_press_status() {
        return op1060a_pin_press_status;
    }

    public void setOp1060a_pin_press_status(String op1060a_pin_press_status) {
        this.op1060a_pin_press_status = op1060a_pin_press_status;
    }

}
