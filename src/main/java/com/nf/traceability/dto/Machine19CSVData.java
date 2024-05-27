package com.nf.traceability.dto;

public class Machine19CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private String sfl_serial_number;
    private String functional_test_status;
    private Double min_load_value;
    private Double max_load_value;
    private Double actual_load_value;
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

    public String getSfl_serial_number() {
        return sfl_serial_number;
    }

    public void setSfl_serial_number(String sfl_serial_number) {
        this.sfl_serial_number = sfl_serial_number;
    }

    public String getFunctional_test_status() {
        return functional_test_status;
    }

    public void setFunctional_test_status(String functional_test_status) {
        this.functional_test_status = functional_test_status;
    }

    public Double getMin_load_value() {
        return min_load_value;
    }

    public void setMin_load_value(Double min_load_value) {
        this.min_load_value = min_load_value;
    }

    public Double getMax_load_value() {
        return max_load_value;
    }

    public void setMax_load_value(Double max_load_value) {
        this.max_load_value = max_load_value;
    }

    public Double getActual_load_value() {
        return actual_load_value;
    }

    public void setActual_load_value(Double actual_load_value) {
        this.actual_load_value = actual_load_value;
    }
}
