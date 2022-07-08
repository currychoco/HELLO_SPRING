package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;


@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Long join(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}); // 중복회원 검증

		memberRepository.save(member);
		return member.getId();
	}

	public List<Member> findMembers() {// 전체 회원 조회
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberID) {
		return memberRepository.findByID(memberID);
	}
}
