package net.bingyan.xuyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bingyan.xuyu.domain.Moment;
import net.bingyan.xuyu.domain.MomentPhoto;
import net.bingyan.xuyu.mapper.UtilMapper;

@Service
public class UtilService {

	@Autowired
	private UtilMapper utilMapper;

	public List<MomentPhoto> getMomentPhotos(Moment moment) {
		return utilMapper.selectMomentPhotos(moment.getMomentId());
	}
}
