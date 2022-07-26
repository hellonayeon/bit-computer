package me.hellonayeon.backend.bbs.controller;

import java.util.Date;

import java.util.List;
import me.hellonayeon.backend.bbs.dto.BbsDto;
import me.hellonayeon.backend.bbs.dto.BbsParam;
import me.hellonayeon.backend.bbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BbsController {

	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/getBbsList", method = RequestMethod.GET)
	public List<BbsDto> getBbsList(){
		System.out.println("BbsController getBbsList " + new Date());
		
		List<BbsDto> list = service.getBbsList();
		return list;
	}
	
	@RequestMapping(value = "/writeBbs", method = RequestMethod.GET)
	public String writeBbs(BbsDto dto) {
		System.out.println("BbsController writeBbs " + new Date());
		
		boolean b = service.writeBbs(dto);
		if(!b) {
			return "NO";
		}
		return "OK";
	}	
	
	@RequestMapping(value = "/getBbsSearchList", method = RequestMethod.GET)
	public List<BbsDto> getBbsSearchList(BbsParam param){
		System.out.println("BbsController getBbsSearchList " + new Date());
		
		List<BbsDto> list = service.getBbsSearchList(param);
		return list;
	}
	
	@RequestMapping(value = "/getBbsSearchPageList", method = RequestMethod.GET)
	public List<BbsDto> getBbsSearchPageList(BbsParam param){
		System.out.println("BbsController getBbsSearchPageList " + new Date());
		
		// 페이지 설정
		int sn = param.getPageNumber(); // 0 1 2 3
		int start = sn * 10 + 1;	// 1  11
		int end = (sn + 1) * 10;	// 10 20
		
		param.setStart(start);
		param.setEnd(end);
		
		return service.getBbsSearchPageList(param);		
	}
	
	@RequestMapping(value = "/getBbsCount", method = RequestMethod.GET)
	public int getBbsCount(BbsParam param) {
		System.out.println("BbsController getBbsCount " + new Date());
		
		return service.getBbsCount(param);
	}
}








