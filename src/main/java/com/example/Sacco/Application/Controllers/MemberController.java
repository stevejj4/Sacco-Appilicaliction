package com.example.Sacco.Application.Controllers;

import com.example.Sacco.Application.Model.Member;
import com.example.Sacco.Application.Model.LoanPayment;
import com.example.Sacco.Application.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Register a new member
    @PostMapping("/register")
    public Member register(@RequestBody Member member) {
        return memberService.register(member);
    }

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    // Record a payment
    @PostMapping("/{id}/payments")
    public LoanPayment recordPayment(@PathVariable String id, @RequestBody LoanPayment payment) {
        // Ensure payment is linked to the correct memberId
        payment.setMemberId(id);
        return memberService.recordPayment(payment);
    }

    // Get all payments for a member
    @GetMapping("/{id}/payments")
    public List<LoanPayment> getPayments(@PathVariable String id) {
        return memberService.getPayments(id);
    }

    // Get total payments for a member
    @GetMapping("/{id}/payments/total")
    public double getTotalPayments(@PathVariable String id) {
        return memberService.getTotalPayments(id);
    }
}