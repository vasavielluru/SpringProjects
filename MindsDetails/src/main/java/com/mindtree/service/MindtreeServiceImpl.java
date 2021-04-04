package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Exception.MindserviceException;
import com.mindtree.entity.Mind;
import com.mindtree.entity.Track;
import com.mindtree.repository.MindRepository;
import com.mindtree.repository.TrackRepository;

@Service
public class MindtreeServiceImpl {

	@Autowired
	public MindRepository mindRepo;

	@Autowired
	public TrackRepository trackRepo;

	public List<Mind> getMindsOfTrack(String trackName) throws MindserviceException {
		int K = 0;
		List<Mind> minds = new ArrayList<Mind>();
		minds = mindRepo.findAll();

		List<Mind> listMind = new ArrayList<Mind>();

		for (Mind object : minds) {

			if (trackName.equals(object.getTrackName())) {
				listMind.add(object);

		 		K = 1;
			}

		}
		if (K == 0) {
			throw new MindserviceException("No Such name Found");
		}
		return listMind;
	}

	public Track addTrack(Track tracks, String name) throws MindserviceException {

		List<Mind> minds = getMindsOfTrack(name);

		tracks.setMindsOfTrack(minds);
		trackRepo.save(tracks);
		return tracks;

	}

	public Mind addMind(Mind mindEmployee) throws MindserviceException {

		// Track track=trackRepo.findById(id);
		int id = mindEmployee.getId();
		Mind mind = null;
		mind = mindRepo.findById(id);
		if (mind == null) {
			mindRepo.save(mindEmployee);
		} else {
			throw new MindserviceException("Id already exists");

		}
		return mindEmployee;
	}

}
