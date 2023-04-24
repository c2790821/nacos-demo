package com.example.nacosdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuditDemo {

    public static double getEffectiveBetNeed(List<Audit> audits) {
//        Collections.reverse(audits);
        audits.forEach(System.out::println);
        System.out.println();
        calculateAudit(audits);
        audits.forEach(System.out::println);
        double effectiveBet = calculateNeedEffectiveBet2(audits);
        System.out.println();
        System.out.println(effectiveBet);
        return effectiveBet;
    }

    private static double calculateNeedEffectiveBet2(List<Audit> audits) {
        double remainEffective = 0;
        double totalNeedEffective = 0;
        for (Audit audit : audits) {
            double needEffective = audit.depositAuditPoint - (audit.effectiveBet + remainEffective);
            if (needEffective > 0) {
                totalNeedEffective += needEffective;
                remainEffective = 0;
            } else if (needEffective <= 0) {
                remainEffective = Math.abs(needEffective);
            }
            System.out.println("auditPoint: " + audit.depositAuditPoint + "; totalNeed: " + totalNeedEffective + "; remain effective: " + remainEffective);
        }
        return totalNeedEffective;
    }

    public double getEffectiveBetNeed(Audit... auditss) {
        List<Audit> audits = Arrays.stream(auditss).toList();
        return getEffectiveBetNeed(audits);
    }

    public static void main(String[] args) {
        List<AuditDemo.Audit> audits = new ArrayList<>();
        audits.add(new AuditDemo.Audit(-1, 0, 0, 3, null));
        audits.add(new AuditDemo.Audit(0, 3, 0, 17, null));
        audits.add(new AuditDemo.Audit(1, 10, 0, 14, null));
        audits.add(new AuditDemo.Audit(2, 0, 0, 0, null));
        audits.add(new AuditDemo.Audit(3, 5, 0, 2, null));
        audits.add(new AuditDemo.Audit(4, 115, 0, 100, null));
        Collections.reverse(audits);
        audits.forEach(System.out::println);
        System.out.println();
        calculateAudit(audits);
        audits.forEach(System.out::println);
        double effectiveBet = calculateNeedEffectiveBet(audits);
        System.out.println();
        System.out.println(effectiveBet);
    }

    private static double calculateNeedEffectiveBet(List<Audit> audits) {
        double totalEffectiveBetNeeded = 0.0;
        double remainingEffectiveBet = 0.0;

        for (int i = 0; i < audits.size(); i++) {
            Audit audit = audits.get(i);
            double currentEffectiveBet = audit.getEffectiveBet();
            double effectiveBetToConsider = remainingEffectiveBet + currentEffectiveBet;

            if (!audit.successAudit || i == audits.size() - 1) {
                double effectiveBetNeeded = audit.getDepositAuditPoint() - effectiveBetToConsider;
                if (effectiveBetNeeded > 0) {
                    totalEffectiveBetNeeded += effectiveBetNeeded;
                }
                remainingEffectiveBet = 0.0;
            } else {
                remainingEffectiveBet = effectiveBetToConsider - audit.getDepositAuditPoint();
            }
        }

        return totalEffectiveBetNeeded;
    }


    private static void calculateAudit(List<Audit> audits) {
        for (int i = 0; i < audits.size(); i++) {
            double previousEffectiveBetRemaining;
            if (i == 0) {
                previousEffectiveBetRemaining = 0;
            } else {
                previousEffectiveBetRemaining = audits.get(i - 1).remainingEffectiveBet;
            }
            Audit audit = audits.get(i);
            double currentEffectiveBet = audit.getEffectiveBet();
            double auditPoint = audit.getDepositAuditPoint();
            if (previousEffectiveBetRemaining + currentEffectiveBet >= auditPoint) {
                audit.remainingEffectiveBet = previousEffectiveBetRemaining + currentEffectiveBet - auditPoint;
                audit.successAudit = true;
            } else {
                audit.remainingEffectiveBet = previousEffectiveBetRemaining + currentEffectiveBet;
                audit.successAudit = false;
            }
        }
    }


    @Data
    @AllArgsConstructor
    public static class Audit {
        private int period; //期數
        private double effectiveBet; //有效投注額
        private double remainingEffectiveBet; //剩餘有效投注額
        private double depositAuditPoint; //存款稽核點

        private Boolean successAudit;

        public Audit(double effectiveBet,
                     double depositAuditPont) {
            this.effectiveBet = effectiveBet;
            this.depositAuditPoint = depositAuditPont;
        }
    }
}
