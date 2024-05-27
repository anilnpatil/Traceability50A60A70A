package com.nf.traceability.dto;

public class Machine7CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double min_ball_over_height_value;
    private Double max_ball_over_height_value;
    private Double actual_ball_over_height_value;
    private String ball_over_height_check_status;
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

    public Double getMin_ball_over_height_value() {
        return min_ball_over_height_value;
    }

    public void setMin_ball_over_height_value(Double min_ball_over_height_value) {
        this.min_ball_over_height_value = min_ball_over_height_value;
    }

    public Double getMax_ball_over_height_value() {
        return max_ball_over_height_value;
    }

    public void setMax_ball_over_height_value(Double max_ball_over_height_value) {
        this.max_ball_over_height_value = max_ball_over_height_value;
    }

    public Double getActual_ball_over_height_value() {
        return actual_ball_over_height_value;
    }

    public void setActual_ball_over_height_value(Double actual_ball_over_height_value) {
        this.actual_ball_over_height_value = actual_ball_over_height_value;
    }

    public String getBall_over_height_check_status() {
        return ball_over_height_check_status;
    }

    public void setBall_over_height_check_status(String ball_over_height_check_status) {
        this.ball_over_height_check_status = ball_over_height_check_status;
    }
}
