package com.nf.traceability.dto;

public class Machine6CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double min_id_gauge_bore_dia;
    private Double max_id_gauge_bore_dia;
    private Double actual_id_gauge_bore_dia;
    private Double min_load_insert_valve_press_value;
    private Double max_load_insert_valve_press_value;
    private Double actual_load_insert_valve_press_value;
    private Double min_displacement_insert_valve_value;
    private Double max_displacement_insert_valve_value;
    private Double actual_displacement_insert_valve_value;
    private String id_gauge_status;
    private String insert_valve_press_status;
    private String fail_reason;
    private String cycleTime;

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

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

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getProduction_status() {
        return production_status;
    }

    public void setProduction_status(String production_status) {
        this.production_status = production_status;
    }

    public Double getMin_id_gauge_bore_dia() {
        return min_id_gauge_bore_dia;
    }

    public void setMin_id_gauge_bore_dia(Double min_id_gauge_bore_dia) {
        this.min_id_gauge_bore_dia = min_id_gauge_bore_dia;
    }

    public Double getMax_id_gauge_bore_dia() {
        return max_id_gauge_bore_dia;
    }

    public void setMax_id_gauge_bore_dia(Double max_id_gauge_bore_dia) {
        this.max_id_gauge_bore_dia = max_id_gauge_bore_dia;
    }

    public Double getActual_id_gauge_bore_dia() {
        return actual_id_gauge_bore_dia;
    }

    public void setActual_id_gauge_bore_dia(Double actual_id_gauge_bore_dia) {
        this.actual_id_gauge_bore_dia = actual_id_gauge_bore_dia;
    }

    public Double getMin_load_insert_valve_press_value() {
        return min_load_insert_valve_press_value;
    }

    public void setMin_load_insert_valve_press_value(Double min_load_insert_valve_press_value) {
        this.min_load_insert_valve_press_value = min_load_insert_valve_press_value;
    }

    public Double getMax_load_insert_valve_press_value() {
        return max_load_insert_valve_press_value;
    }

    public void setMax_load_insert_valve_press_value(Double max_load_insert_valve_press_value) {
        this.max_load_insert_valve_press_value = max_load_insert_valve_press_value;
    }

    public Double getActual_load_insert_valve_press_value() {
        return actual_load_insert_valve_press_value;
    }

    public void setActual_load_insert_valve_press_value(Double actual_load_insert_valve_press_value) {
        this.actual_load_insert_valve_press_value = actual_load_insert_valve_press_value;
    }

    public Double getMin_displacement_insert_valve_value() {
        return min_displacement_insert_valve_value;
    }

    public void setMin_displacement_insert_valve_value(Double min_displacement_insert_valve_value) {
        this.min_displacement_insert_valve_value = min_displacement_insert_valve_value;
    }

    public Double getMax_displacement_insert_valve_value() {
        return max_displacement_insert_valve_value;
    }

    public void setMax_displacement_insert_valve_value(Double max_displacement_insert_valve_value) {
        this.max_displacement_insert_valve_value = max_displacement_insert_valve_value;
    }

    public Double getActual_displacement_insert_valve_value() {
        return actual_displacement_insert_valve_value;
    }

    public void setActual_displacement_insert_valve_value(Double actual_displacement_insert_valve_value) {
        this.actual_displacement_insert_valve_value = actual_displacement_insert_valve_value;
    }

    public String getId_gauge_status() {
        return id_gauge_status;
    }

    public void setId_gauge_status(String id_gauge_status) {
        this.id_gauge_status = id_gauge_status;
    }

    public String getInsert_valve_press_status() {
        return insert_valve_press_status;
    }

    public void setInsert_valve_press_status(String insert_valve_press_status) {
        this.insert_valve_press_status = insert_valve_press_status;
    }
}
