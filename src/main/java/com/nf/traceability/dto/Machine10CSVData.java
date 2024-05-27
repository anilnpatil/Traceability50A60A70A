package com.nf.traceability.dto;

public class Machine10CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double min_pin_press_load_value;
    private Double max_pin_press_load_value;
    private Double actual_pin_press_load_value;
    private Double min_pin_displacement_value;
    private Double max_pin_displacement_value;
    private Double actual_pin_displacement_value;
    private String pin_press_status;
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

    public Double getMin_pin_press_load_value() {
        return min_pin_press_load_value;
    }

    public void setMin_pin_press_load_value(Double min_pin_press_load_value) {
        this.min_pin_press_load_value = min_pin_press_load_value;
    }

    public Double getMax_pin_press_load_value() {
        return max_pin_press_load_value;
    }

    public void setMax_pin_press_load_value(Double max_pin_press_load_value) {
        this.max_pin_press_load_value = max_pin_press_load_value;
    }

    public Double getActual_pin_press_load_value() {
        return actual_pin_press_load_value;
    }

    public void setActual_pin_press_load_value(Double actual_pin_press_load_value) {
        this.actual_pin_press_load_value = actual_pin_press_load_value;
    }

    public Double getMin_pin_displacement_value() {
        return min_pin_displacement_value;
    }

    public void setMin_pin_displacement_value(Double min_pin_displacement_value) {
        this.min_pin_displacement_value = min_pin_displacement_value;
    }

    public Double getMax_pin_displacement_value() {
        return max_pin_displacement_value;
    }

    public void setMax_pin_displacement_value(Double max_pin_displacement_value) {
        this.max_pin_displacement_value = max_pin_displacement_value;
    }

    public Double getActual_pin_displacement_value() {
        return actual_pin_displacement_value;
    }

    public void setActual_pin_displacement_value(Double actual_pin_displacement_value) {
        this.actual_pin_displacement_value = actual_pin_displacement_value;
    }

    public String getPin_press_status() {
        return pin_press_status;
    }

    public void setPin_press_status(String pin_press_status) {
        this.pin_press_status = pin_press_status;
    }
}
