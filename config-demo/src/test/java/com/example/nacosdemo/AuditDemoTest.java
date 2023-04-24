package com.example.nacosdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


















class AuditDemoTest {

    @Test
    void test4() {
        List<AuditDemo.Audit> audits = new ArrayList<>();
        audits.add(new AuditDemo.Audit(0, 95));
        audits.add(new AuditDemo.Audit(9.5, 4));
        audits.add(new AuditDemo.Audit(5, 15));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(10,9));
        audits.add(new AuditDemo.Audit(5, 0));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(0, 10.5));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(0, 2));
        audits.add(new AuditDemo.Audit(0, 0));
        audits.add(new AuditDemo.Audit(79,0));
        audits.add(new AuditDemo.Audit(5, 95));
        audits.add(new AuditDemo.Audit(5, 95));
        double effectiveBetNeed = AuditDemo.getEffectiveBetNeed(audits);
        Assertions.assertEquals(205, effectiveBetNeed);
    }

    @Test
    void test1() {
        List<AuditDemo.Audit> audits = new ArrayList<>();
        audits.add(new AuditDemo.Audit(0, 3, 0, 17, null));
        audits.add(new AuditDemo.Audit(1, 10, 0, 14, null));
        audits.add(new AuditDemo.Audit(2, 0, 0, 0, null));
        audits.add(new AuditDemo.Audit(3, 5, 0, 2, null));
        audits.add(new AuditDemo.Audit(4, 0, 0, 100, null));
        double effectiveBetNeed = AuditDemo.getEffectiveBetNeed(audits);
        Assertions.assertEquals(115, effectiveBetNeed);
    }

    @Test
    void test3() {
        List<AuditDemo.Audit> audits = new ArrayList<>();
        audits.add(new AuditDemo.Audit(-1, 0, 0, 3, null));
        audits.add(new AuditDemo.Audit(0, 3, 0, 17, null));
        audits.add(new AuditDemo.Audit(1, 10, 0, 14, null));
        audits.add(new AuditDemo.Audit(2, 0, 0, 0, null));
        audits.add(new AuditDemo.Audit(3, 5, 0, 2, null));
        audits.add(new AuditDemo.Audit(4, 0, 0, 100, null));
        double effectiveBetNeed = AuditDemo.getEffectiveBetNeed(audits);
        Assertions.assertEquals(118, effectiveBetNeed);
    }

    @Test
    void test2() {
        List<AuditDemo.Audit> audits = new ArrayList<>();
        audits.add(new AuditDemo.Audit(1, 10, 0, 14, null));
        audits.add(new AuditDemo.Audit(2, 0, 0, 0, null));
        audits.add(new AuditDemo.Audit(3, 5, 0, 2, null));
        audits.add(new AuditDemo.Audit(4, 0, 0, 100, null));
        double effectiveBetNeed = AuditDemo.getEffectiveBetNeed(audits);
        Assertions.assertEquals(101, effectiveBetNeed);
    }
}