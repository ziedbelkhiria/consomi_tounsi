package tn.esprit.spring.restController;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.repository.PubliciteRepository;
import tn.esprit.spring.service.PubliciteService;





@RestController
@RequestMapping("/publicite")


public class PubliciteController  {
	@Autowired
	PubliciteService pubservice;
	@Autowired 
	PubliciteRepository publirepo;
	
	@PostMapping("/posterpub")
	public ResponseEntity<?> posterpubliciter(@ModelAttribute Publicite publi) throws IOException {
		
		if (publi.getImage() != null) {
			publi.setPic(publi.getImage().getBytes());
		}
		pubservice.publier(publi);
		return new ResponseEntity<>(new Responsemodel("added"), HttpStatus.CREATED);
	}
	
	@GetMapping("/afficherpub")
	public List<Publicite> afficherpub() {
		return pubservice.afficherpub();

	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deletepub(@PathVariable("id") Long id) throws RelationNotFoundException {
		pubservice.deletepubById(id);
		return HttpStatus.FORBIDDEN;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Publicite> updatepublicite(@PathVariable("id") long id,
			@ModelAttribute Publicite forumdet) throws IOException {
		Optional<Publicite> newform = publirepo.findById(id);

		if (newform.isPresent()) {
			Publicite Newwform = newform.get();
			Newwform.setName(forumdet.getName());
			Newwform.setContent(forumdet.getContent());
			if (forumdet.getImage() != null) {
				Newwform.setPic(forumdet.getImage().getBytes());
			}

			return new ResponseEntity<>(publirepo.save(Newwform), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	
	} 
}
