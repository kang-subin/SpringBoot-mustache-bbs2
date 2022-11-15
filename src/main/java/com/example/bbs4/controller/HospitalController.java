package com.example.bbs4.controller;

import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.repository.Hospitalrepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {
    private final Hospitalrepository hospitalRepository;

    public HospitalController(Hospitalrepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping("")
    public String list(Model model, Pageable pageable) { // 페이징 기능 추가
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable); // pageble(페이지 처리에 필요한 정보를 가짐) 파라미터로 넘겨주면 db를 가져올 때 limit 조건을 자동으로 사용할 수 있도록 해줌
        // 페이징 처리에 필요한 모든 정보를 (pageable) 받아서 가져온 정보를 페이지 정보를 담는 page 객체에 담는다.
        log.info("size:{}", hospitals.getSize()); // 페이지에 당 데이터 개수 기본 20으로 설정되어 있어서 20개 출력된 것 변경가능
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); // 이전의 페이지를 요청하는  정보를 가진 pageable 에서 페이지 번호를 넘김
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지를 요청하는 정보를 가진 pageable의 페이지 번호를 넘김
        return "hospitals/list";


    }
}