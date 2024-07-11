//package com.example.demo.fee.entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import jakarta.persistence.Embeddable;
//
//@Embeddable
//public class FeeId implements Serializable {
//	String userId;
//    int month;
//
//    public FeeId() {}
//
//    public FeeId(String userId, int month) {
//        this.userId = userId;
//        this.month = month;
//    }
//    
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId, month);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        FeeId feeId = (FeeId) obj;
//        return month == feeId.month && Objects.equals(userId, feeId.userId);
//    }
//}