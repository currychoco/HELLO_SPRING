package hello.hellospring.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("김덕춘");
		
		//when
		Long saveID = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveID).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("조용팔");
		
		Member member2 = new Member();
		member2.setName("조용팔");
		
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		
		/*
		 * try { memberService.join(member2); fail(); }catch(IllegalStateException e) {
		 * Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); }
		 */
		
		//then
		
	}

	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
