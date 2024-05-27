package com.nf.traceability.dto;

public class Machine4 {
    private String productId;
    private Integer process1PassFail;
    private Integer process2PassFail;
    private Integer status;
    private Integer shift;
    private Integer totalProductionCount;
    private Integer okParts;
    private Integer notOkParts;
    private String startTime;
    private String endTime;
    private String cycleTime;

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getTotalProductionCount() {
        return totalProductionCount;
    }

    public void setTotalProductionCount(Integer totalProductionCount) {
        this.totalProductionCount = totalProductionCount;
    }

    public Integer getOkParts() {
        return okParts;
    }

    public void setOkParts(Integer okParts) {
        this.okParts = okParts;
    }

    public Integer getNotOkParts() {
        return notOkParts;
    }

    public void setNotOkParts(Integer notOkParts) {
        this.notOkParts = notOkParts;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProcess1PassFail() {
        return process1PassFail;
    }

    public void setProcess1PassFail(Integer process1PassFail) {
        this.process1PassFail = process1PassFail;
    }

    public Integer getProcess2PassFail() {
        return process2PassFail;
    }

    public void setProcess2PassFail(Integer process2PassFail) {
        this.process2PassFail = process2PassFail;
    }
}
