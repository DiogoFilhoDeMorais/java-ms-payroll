package com.microservice.payroll.model;

import java.io.Serializable;

public class PaymentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Float dailyIncome;
    private Integer days;
    private Float total;

    public PaymentModel() {}

    public PaymentModel(String name, Float dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.total = dailyIncome * days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Float dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Float getTotal() {
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dailyIncome == null) ? 0 : dailyIncome.hashCode());
        result = prime * result + ((days == null) ? 0 : days.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaymentModel other = (PaymentModel) obj;
        if (dailyIncome == null) {
            if (other.dailyIncome != null)
                return false;
        } else if (!dailyIncome.equals(other.dailyIncome))
            return false;
        if (days == null) {
            if (other.days != null)
                return false;
        } else if (!days.equals(other.days))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PaymentModel [dailyIncome=" + dailyIncome + ", days=" + days + ", name=" + name + "]";
    }

}
