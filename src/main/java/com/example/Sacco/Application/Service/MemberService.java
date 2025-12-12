package com.example.Sacco.Application.Service;


import com.example.Sacco.Application.Model.Member;
import com.example.Sacco.Application.Model.LoanPayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Optional;

@Service
public class MemberService {

    private final List<Member> members = new CopyOnWriteArrayList<>();
    private final List<LoanPayment> payments = new CopyOnWriteArrayList<>();

    public Member register(Member member) {
        if (members.stream().anyMatch(m -> m.getId().equals(member.getId()))) {
            throw new IllegalArgumentException("Member with ID " + member.getId() + " already exists.");
        }
        members.add(member);
        return member;
    }

    public List<Member> getAllMembers() {
        return List.copyOf(members);
    }

    public Optional<Member> getMemberById(String id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public LoanPayment recordPayment(LoanPayment payment) {
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
        payments.add(payment);
        return payment;
    }

    public List<LoanPayment> getPayments(String memberId) {
        return payments.stream()
                .filter(p -> p.getMemberId().equals(memberId))
                .toList();
    }

    public double getTotalPayments(String memberId) {
        return payments.stream()
                .filter(p -> p.getMemberId().equals(memberId))
                .mapToDouble(LoanPayment::getAmount)
                .sum();
    }
}