package com.web.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.ClubDto;
import com.web.models.Club;
import com.web.repository.ClubRepository;
import com.web.services.ClubService;

@Service
public class ClubServiceImpl implements ClubService{
	
	private ClubRepository clubRepository;
	
	@Autowired
	public ClubServiceImpl(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}



	@Override
	public List<ClubDto> findAllClubs() {
		List<Club> clubs = clubRepository.findAll();
		return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
	}



	private ClubDto mapToClubDto(Club club) {
		ClubDto clubDto = ClubDto.builder()
				.Id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
				.build();
		
		return clubDto;

}
}
